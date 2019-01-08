package controller;

/**
 * @author pengyuxiang
 * @date 2018/12/21
 */

import entity.UserEntity;
import entity.VideoEntity;
import mapper.IUserDao;
import mapper.IVideoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommonController {
    @Autowired
    private IUserDao iUserDao;

    @Autowired
    private IVideoDao iVideoDao;

    @RequestMapping(value="/videos/{pageId}", method = RequestMethod.GET)
    public List<VideoEntity> getCurrentVideoList(@PathVariable("pageId") Long id){
        VideoEntity videoEntity = new VideoEntity("title","url");
        List<VideoEntity>  videoEntities = new ArrayList<>();
        videoEntities.add(videoEntity);
        return videoEntities;
    }


    @RequestMapping(value="/users/{userId}", method = RequestMethod.GET)
    public UserEntity getCurrentUserInfo(@PathVariable("userId") String id){
        UserEntity userEntity = iUserDao.getUserById(id);
        return userEntity;
    }

    @RequestMapping(value="/videos/info/{videoId}", method = RequestMethod.GET)
    public VideoEntity getVideoInfo(@PathVariable("videoId") String id) {
        VideoEntity videoEntity = this.iVideoDao.getVideoInfoById(id);
        return videoEntity;
    }

    @RequestMapping(value="/fortest", method = RequestMethod.GET)
    public VideoEntity getCurrentVideoList(){
        VideoEntity videoEntity = new VideoEntity("title","http://139.224.115.104:8081/files/1");
        return videoEntity;
    }

    public IUserDao getiUserDao() {
        return iUserDao;
    }

    public void setiUserDao(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }
}
