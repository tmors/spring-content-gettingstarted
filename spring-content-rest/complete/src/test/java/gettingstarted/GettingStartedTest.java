package gettingstarted;

import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.BeforeEach;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.Context;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.Describe;
import static com.github.paulcwarren.ginkgo4j.Ginkgo4jDSL.It;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

import com.github.paulcwarren.ginkgo4j.Ginkgo4jSpringRunner;
import com.jayway.restassured.RestAssured;

@RunWith(Ginkgo4jSpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GettingStartedTest {

	@Autowired private FileRepository fileRepo;
	@Autowired private FileContentStore fileContentStore;
	
    @Value("${local.server.port}") private int port;

    private File file;
    
    {
        Describe("File Tests", () -> {
        	BeforeEach(() -> {
        		RestAssured.port = port;
        	});
        	
        	Context("Given a File Entity", () -> {
        		BeforeEach(() -> {
            		File f = new File();
            		f.setName("test-file");
            		f.setMimeType("text/plain");
            		f.setSummary("test file summary");
            		file = fileRepo.save(f);
        		});
        		
        		It("should be able to associate content with the Entity", () -> {
        	    	given()
        	    		.multiPart("file", "file", new ByteArrayInputStream("This is plain text content!".getBytes()), "text/plain")
        		    .when()
        		        .put("/files/" + file.getId())
        		    .then()
        		    	.statusCode(HttpStatus.SC_OK);
                	    	
        	    	file = fileRepo.findOne(file.getId());
        	    	assertThat(IOUtils.toString(fileContentStore.getContent(file)), is("This is plain text content!"));
        		});
        		
        		Context("with existing content", () -> {
        			BeforeEach(() -> {
        				fileContentStore.setContent(file, new ByteArrayInputStream("Existing content".getBytes()));
        				fileRepo.save(file);
        				
        				Resource r = fileContentStore.getResource("file.txt");
        				if (r instanceof WritableResource) {
        					InputStream in = new ByteArrayInputStream("Hello Spring Content World!".getBytes());
        					OutputStream out = ((WritableResource)r).getOutputStream();
        					IOUtils.copy(in, out);
        					IOUtils.closeQuietly(out);
        					IOUtils.closeQuietly(in);
        				}
        			});
        			
        			It("should return the content", () -> {
        		    	given()
        		    		.header("accept", "text/plain")
        		    	.when()
        	    			.get("files/" + file.getId())
        	    		.then()
	        	    		.assertThat()
	        	    			.contentType(Matchers.startsWith("text/plain"))
	        	    			.body(Matchers.equalTo("Existing content"));
        			});

        			It("should return partial content", () -> {
        		    	given()
        		    		.header("accept", "text/plain")
        		    		.header("range", "bytes=6-19")
        		    	.when()
        	    			.get("files/file.txt")
        	    		.then()
	        	    		.assertThat()
	        	    			.statusCode(206)
	        	    			.contentType(Matchers.startsWith("text/plain"))
	        	    			.body(Matchers.equalTo("Spring Content"));
        			});
        		});
        	});
        });
    }

    @Test
    public void noop() {}
}
