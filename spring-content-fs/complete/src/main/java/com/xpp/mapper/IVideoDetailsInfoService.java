package com.xpp.mapper;

import com.xpp.entity.VideoInfoEntity;
import com.xpp.entity.VideoDetailsInfoEntity;
import com.xpp.vo.VideoDetailsInfoVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author pengyuxiang
 * @date 2019/1/8
 */
public interface IVideoDetailsInfoService {
    @Select("select * from video_details_info where Id=#{id}")
    public VideoDetailsInfoVO getVideoInfoById(@Param("id") String userId);

    @Select("select vi.style, pi.url as cover, ui.nickname as up, vi.param," +
            "pi.url as upface, ci.title as category, vi.goto_x, vi.playnumber as play, vi.danmaku, " +
            "vi.up, vi.description from video_details_info vi, user_info ui,pic_info pi, category_info ci " +
            "where vi.cover = pi.id and vi.up = ui.id and vi.category = #{category} and ci.id = #{category}")
    public VideoDetailsInfoVO getVideoDetailsInfoByCid(@Param("category") String category);


    @Select("select vi.title, vi.url, pi.url as face, vi.description, vi.category, vi.playnumber, ui.nickname as up, pi.url as upface from video_info vi, pic_info pi, user_info ui where vi.cover=pi.id and vi.up=ui.id")
    public List<VideoDetailsInfoVO> getVideoList();

    @Select("select vi.style, pi.url as cover, ui.nickname as up, vi.param," +
            "pi.url as upface, ci.title as category, vi.goto_x, vi.playnumber as play, vi.danmaku, " +
            "vi.up, vi.description from video_details_info vi, user_info ui,pic_info pi, category_info ci " +
            "where vi.cover = pi.id and vi.up = ui.id and vi.category = #{category} and ci.id = #{category}")
    public List<VideoDetailsInfoVO> getVideoDetailsInfoListByCategory(@Param("category") String cid);


    @Insert("insert into video_details_info(" +
            "id, video_id, cover, comment_id, up,description," +
            "goto_x, param, playnumber, style, danmaku) values(" +
            "#{id}, #{videoId}, #{cover}, #{comment_id}, #{up}, #{description}, " +
            "#{gotoX}, #{param}, #{playnumber}, #{style}, #{danmaku})")
    public void addVideo(VideoDetailsInfoEntity videoDetailsInfoEntity);



}
