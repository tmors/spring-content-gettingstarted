package controller;

/**
 * @author pengyuxiang
 * @date 2018/12/21
 */

import entity.UserEntity;
import entity.VideoEntity;
import mapper.IUserDao;
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

    public IUserDao getiUserDao() {
        return iUserDao;
    }

    public void setiUserDao(IUserDao iUserDao) {
        this.iUserDao = iUserDao;
    }
}
