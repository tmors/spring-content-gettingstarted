package gettingstarted;

import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

@SpringBootApplication
public class SpringContentApplication implements InitializingBean {

	@Autowired private FileContentStore store;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringContentApplication.class, args);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Resource r = store.getResource("mov_bbb.mp4");
		if (r instanceof WritableResource) {
			InputStream in = this.getClass().getResourceAsStream("/mov_bbb.mp4");
			OutputStream out = ((WritableResource)r).getOutputStream();
			IOUtils.copy(in, out);
			IOUtils.closeQuietly(out);
			IOUtils.closeQuietly(in);
		}
	}
}
