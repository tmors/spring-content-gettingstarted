package com.xpp.controller;

import com.xpp.entity.CategoryEntity;
import com.xpp.entity.VideoDetailsInfoEntity;
import com.xpp.entity.VideoInfoEntity;
import com.xpp.mapper.*;
import com.xpp.vo.CommentVO;
import com.xpp.vo.HDVideoInfoVO;
import com.xpp.vo.VideoDetailsInfoVO;
import com.xpp.vo.result.Head;
import com.xpp.vo.result.Result;
import com.xpp.vo.result.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

/**
 * @author pengyuxiang
 * @date 2019/1/10
 */

@RestController
public class VideoController {
    @Autowired
    private IUserService iUserService;

    @Autowired
    private IVideoDetailsInfoService iVideoDetailsInfoService;

    @Autowired
    private ICommentService iCommentService;

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IVideoInfoSerivce iVideoInfoSerivce;

    @RequestMapping(value = "/videos", method = RequestMethod.GET)
    public List<VideoDetailsInfoVO> getAllVideoList() {
        List<VideoDetailsInfoVO> videoEntities = iVideoDetailsInfoService.getVideoList();
        return videoEntities;
    }

    @RequestMapping(value = "/videosinfo/pages/{pageId}", method = RequestMethod.GET)
    public List<VideoDetailsInfoVO> getCurrentVideoList(@PathVariable("pageId") Long id) {
        VideoDetailsInfoVO videoDetailsInfoVO = new VideoDetailsInfoVO();
        List<VideoDetailsInfoVO> videoEntities = new ArrayList<>();
        videoEntities.add(videoDetailsInfoVO);
        return videoEntities;
    }

    @RequestMapping(value = "/vdinfo/{vdid}", method = RequestMethod.GET)
    public VideoDetailsInfoVO getVideoDetailsInfo(@PathVariable("vdid") String vdid) {

        VideoDetailsInfoEntity videoDetailsInfoEntity = this.iVideoDetailsInfoService.getVideoDetailsInfoByCid(vdid);
        VideoDetailsInfoVO videoDetailsInfoVO = new VideoDetailsInfoVO();
        VideoDetailsInfoVO.DataBean.PagesBean pagesBean = new VideoDetailsInfoVO.DataBean.PagesBean();
        pagesBean.setCid(Integer.valueOf(videoDetailsInfoEntity.getParam()));
        videoDetailsInfoVO.getData().getPages().add(pagesBean);
        return videoDetailsInfoVO;
    }

    @RequestMapping(value = "/videoinfo/{videoId}", method = RequestMethod.GET)
    public HDVideoInfoVO getVideoInfo(@PathVariable("videoId") String videoId){
        VideoInfoEntity videoInfoEntity = this.iVideoInfoSerivce.getVideoInfoByCid(videoId);
        HDVideoInfoVO hdVideoInfoVO = new HDVideoInfoVO();
        HDVideoInfoVO.DurlEntity durlEntity = new HDVideoInfoVO.DurlEntity();
        durlEntity.setUrl(videoInfoEntity.getUrl());
        hdVideoInfoVO.addDurlEntity(durlEntity);

        return hdVideoInfoVO;
    }

    @RequestMapping(value = "/videocomment/{videoId}", method = RequestMethod.GET)
    public CommentVO getCommentByVideoId(@PathVariable("videoId") String cid) {
        CommentVO commentVO = this.iCommentService.getCommentByCid(cid);
        return commentVO;
    }


    @RequestMapping(value = "/getRecommand", method = RequestMethod.GET)
    public Result getRecommandList() {

        List<CategoryEntity> categoryEntities = iCategoryService.getAllCategory();
        Result result = new Result();
        for (CategoryEntity categoryEntity : categoryEntities) {
            String category = categoryEntity.getId().toString();
            List<VideoDetailsInfoVO> videoDetailsInfoVOList = iVideoDetailsInfoService.getVideoDetailsInfoListByCategory(category);

            ResultBean resultBean = new ResultBean();
            resultBean.setBody(videoDetailsInfoVOList);
            resultBean.setHead(new Head(categoryEntity.getParam(),
                    categoryEntity.getGotoX(),
                    categoryEntity.getStyle(),
                    categoryEntity.getTitle()));

            resultBean.setType(categoryEntity.getType());
            result.setCode(0);
            result.addResultBean(resultBean);
        }
        return result;
    }

}
