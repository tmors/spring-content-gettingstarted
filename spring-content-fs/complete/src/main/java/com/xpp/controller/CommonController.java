package com.xpp.controller;

/**
 * @author pengyuxiang
 * @date 2018/12/21
 */

import com.xpp.entity.*;
import com.xpp.mapper.*;
import com.xpp.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    @Autowired
    private IVideoService iVideoService;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICommentService iCommentService;

    @Autowired
    private IPicSerivce iPicSerivce;

    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping(value="/insertMain", method = RequestMethod.GET)
    public String insert(){
        CommentInfoEntity commentInfoEntity = new CommentInfoEntity();
        PicInfoEntity picInfoEntity = new PicInfoEntity();
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        VideoInfoEntity videoInfoEntity = new VideoInfoEntity();

        //构造userInfo
        userInfoEntity.setId(1L);
        userInfoEntity.setUserId("mkid");
        userInfoEntity.setName("MountainKing");
        userInfoEntity.setNickname("MK");
        userInfoEntity.setPasswd("MountainKing666");
        userInfoEntity.setFace("1");
        userInfoEntity.setSex("male");
        userInfoEntity.setRank("God");
        userInfoEntity.setRegtime("2019-01-01");
        userInfoEntity.setBirthday("2001-01-01");
        userInfoEntity.setDescription("this is Mountain King");
        userInfoEntity.setFans("1");
        userInfoEntity.setFollows("1");
        userInfoEntity.setFriends("1");
        userInfoEntity.setVideos("1");
        iUserService.addUser(userInfoEntity);

        //picInfo
        picInfoEntity.setId(1L);
        picInfoEntity.setName("MK face");
        picInfoEntity.setUrl("https://cdn.newsapi.com.au/image/v1/9fdbf585d17c95f7a31ccacdb6466af9");
        picInfoEntity.setDescription("this is MountainKing's face");
        iPicSerivce.addPic(picInfoEntity);

        //CommentInfo
        commentInfoEntity.setId(1L);
        commentInfoEntity.setLvlNum("10");
        commentInfoEntity.setCommentId("commentId");
        commentInfoEntity.setContent("MountainKing is so 6");
        commentInfoEntity.setPostman("1");
        iCommentService.addComment(commentInfoEntity);




        return "success";
    }


    @RequestMapping(value="/insertCategory", method = RequestMethod.GET)
    public String insertCategory(){
        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId(1L);
        categoryEntity.setType("recommend");
        categoryEntity.setParam("");
        categoryEntity.setGotoX("");
        categoryEntity.setStyle("gm_av");
        categoryEntity.setTitle("热门焦点");
        iCategoryService.addCategory(categoryEntity);


        categoryEntity.setId(2L);
        categoryEntity.setType("live");
        categoryEntity.setParam("");
        categoryEntity.setGotoX("live");
        categoryEntity.setStyle("gm_av");
        categoryEntity.setTitle("正在直播");
        iCategoryService.addCategory(categoryEntity);

        categoryEntity.setId(3L);
        categoryEntity.setType("live");
        categoryEntity.setParam("");
        categoryEntity.setGotoX("live");
        categoryEntity.setStyle("gm_av");
        categoryEntity.setTitle("正在直播");
        iCategoryService.addCategory(categoryEntity);

        categoryEntity.setId(4L);
        categoryEntity.setType("bangumi_2");
        categoryEntity.setParam("13");
        categoryEntity.setGotoX("subarea");
        categoryEntity.setStyle("gs_bangumi");
        categoryEntity.setTitle("番剧区");
        iCategoryService.addCategory(categoryEntity);

        categoryEntity.setId(5L);
        categoryEntity.setType("region");
        categoryEntity.setParam("1");
        categoryEntity.setGotoX("subarea");
        categoryEntity.setStyle("gm_av");
        categoryEntity.setTitle("动画区");
        iCategoryService.addCategory(categoryEntity);

        return "successOfInsertCategory";
    }

}
