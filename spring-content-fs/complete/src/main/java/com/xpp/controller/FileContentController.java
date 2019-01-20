package com.xpp.controller;

import java.io.IOException;
import java.util.Optional;

import com.xpp.entity.FileMapperEntity;
import com.xpp.entity.VideoInfoEntity;
import com.xpp.vo.VideoVO;
import com.xpp.mapper.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static com.xpp.VideoConstant.URL_PREFIX;

@RestController
public class FileContentController {

    @Autowired
    private FileRepository filesRepo;

    @Autowired
    private FileContentStore contentStore;

    @Autowired
    private IVideoService iVideoService;

    @RequestMapping(value = "/files/{fileId}", method = RequestMethod.PUT)
    public ResponseEntity<?> setContent(@PathVariable("fileId") Long id, @RequestParam("file") MultipartFile file)
            throws IOException {

        Optional<FileMapperEntity> f = filesRepo.findById(id);
        if (f.isPresent()) {
            try{
                this.add2VideoInfo(f);
            }
            catch (Exception e){
                e.printStackTrace();
                return null;
            }
            f.get().setMimeType(file.getContentType());

            contentStore.setContent(f.get(), file.getInputStream());

            // save updated content-related info
            filesRepo.save(f.get());
            return new ResponseEntity<Object>(HttpStatus.OK);
        }
        return null;
    }

    @RequestMapping(value = "/files/{fileId}", method = RequestMethod.GET)
    public ResponseEntity<?> getContent(@PathVariable("fileId") Long id) {

        Optional<FileMapperEntity> f = filesRepo.findById(id);
        if (f.isPresent()) {

            InputStreamResource inputStreamResource = new InputStreamResource(contentStore.getContent(f.get()));
            HttpHeaders headers = new HttpHeaders();
            headers.setContentLength(f.get().getContentLength());
            headers.set("Content-Type", f.get().getMimeType());
            return new ResponseEntity<Object>(inputStreamResource, headers, HttpStatus.OK);
        }
        return null;
    }


    public void add2VideoInfo(Optional<FileMapperEntity> f){
        VideoInfoEntity videoInfoEntity = new VideoInfoEntity();
        videoInfoEntity.setId(1L);
        videoInfoEntity.setTitle("MountainKing.avi");
        videoInfoEntity.setUrl(URL_PREFIX + f.get().getId());
        videoInfoEntity.setCid("1");
        videoInfoEntity.setCover("1");
        videoInfoEntity.setComment_id("1");
        videoInfoEntity.setUp("1");
        videoInfoEntity.setCategory("1");
        videoInfoEntity.setDescription("This is a video related to Mr.Mountain ");
        videoInfoEntity.setPlaynumber("11234");
        videoInfoEntity.setParam("112345");
        videoInfoEntity.setStyle("gm_av");
        videoInfoEntity.setDanmaku("1100");


        iVideoService.addVideo(videoInfoEntity);

    }


}