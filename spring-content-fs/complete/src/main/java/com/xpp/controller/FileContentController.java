package com.xpp.controller;

import java.io.IOException;
import java.util.Optional;

import com.xpp.entity.FileMapperEntity;
import com.xpp.entity.VideoDetailsInfoEntity;
import com.xpp.mapper.IVideoDetailsInfoService;
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
    private IVideoDetailsInfoService iVideoDetailsInfoService;

    @RequestMapping(value = "/files/{fileId}", method = RequestMethod.PUT)
    public ResponseEntity<?> setContent(@PathVariable("fileId") Long id, @RequestParam("file") MultipartFile file)
            throws IOException {

        Optional<FileMapperEntity> f = filesRepo.findById(id);
        if (f.isPresent()) {
            this.add2VideoInfo(f);
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
        VideoDetailsInfoEntity videoDetailsInfoEntity = new VideoDetailsInfoEntity();
        videoDetailsInfoEntity.setId(1L);
        videoDetailsInfoEntity.setVideoId("1");
        videoDetailsInfoEntity.setCover("1");
        videoDetailsInfoEntity.setComment_id("1");
        videoDetailsInfoEntity.setUp("1");
        videoDetailsInfoEntity.setCategory("1");
        videoDetailsInfoEntity.setDescription("This is a video related to Mr.Mountain ");
        videoDetailsInfoEntity.setPlaynumber("11234");
        videoDetailsInfoEntity.setParam("112345");
        videoDetailsInfoEntity.setStyle("gm_av");
        videoDetailsInfoEntity.setDanmaku("1100");
        videoDetailsInfoEntity.setGotoX("av");


        iVideoDetailsInfoService.addVideo(videoDetailsInfoEntity);

    }


}