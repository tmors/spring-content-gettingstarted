package com.xpp.controller;

import com.xpp.entity.CategoryEntity;
import com.xpp.mapper.ICategoryService;
import com.xpp.mapper.ICommentService;
import com.xpp.vo.CommentVO;
import com.xpp.vo.VideoVO;
import com.xpp.mapper.IUserService;
import com.xpp.mapper.IVideoService;
import com.xpp.vo.result.Body;
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
    private IVideoService iVideoService;

    @Autowired
    private ICommentService iCommentService;

    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping(value = "/videos", method = RequestMethod.GET)
    public List<VideoVO> getAllVideoList() {
        List<VideoVO> videoEntities = iVideoService.getVideoList();
        return videoEntities;
    }

    @RequestMapping(value = "/videosinfo/pages/{pageId}", method = RequestMethod.GET)
    public List<VideoVO> getCurrentVideoList(@PathVariable("pageId") Long id) {
        VideoVO videoVO = new VideoVO();
        List<VideoVO> videoEntities = new ArrayList<>();
        videoEntities.add(videoVO);
        return videoEntities;
    }

    @RequestMapping(value = "/videoinfo/{videoId}", method = RequestMethod.GET)
    public VideoVO getVideoInfo(@PathVariable("videoId") String cid) {
        VideoVO videoVO = this.iVideoService.getVideoInfoByCid(cid);
        return videoVO;
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
            List<VideoVO> videoVOList = iVideoService.getVideoListByCategory(category);

            ResultBean resultBean = new ResultBean();
            resultBean.setBody(videoVOList);
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
