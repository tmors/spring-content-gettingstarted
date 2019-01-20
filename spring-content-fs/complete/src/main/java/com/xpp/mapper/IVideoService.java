package com.xpp.mapper;

import com.xpp.entity.VideoInfoEntity;
import com.xpp.vo.CommentVO;
import com.xpp.vo.VideoVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author pengyuxiang
 * @date 2019/1/8
 */
public interface IVideoService {
    @Select("select * from video_info where Id=#{id}")
    public VideoVO getVideoInfoById(@Param("id") String userId);

    @Select("select vi.title, vi.url, pi.url as face, vi.description, vi.category, vi.playnumber, ui.nickname as up, pi.url as upface from video_info vi, pic_info pi, user_info ui where vi.cid=#{cid} and vi.cover=pi.id and vi.up=ui.id")
    public VideoVO getVideoInfoByCid(@Param("cid") String cid);


    @Select("select vi.title, vi.url, pi.url as face, vi.description, vi.category, vi.playnumber, ui.nickname as up, pi.url as upface from video_info vi, pic_info pi, user_info ui where vi.cover=pi.id and vi.up=ui.id")
    public List<VideoVO> getVideoList();

    @Select("select vi.title, vi.style, pi.url as cover, ui.nickname as up, vi.param," +
            "pi.url as upface, ci.title as category, vi.goto_x, vi.playnumber as play, vi.danmaku, " +
            "vi.up, vi.url, vi.description from video_info vi, user_info ui,pic_info pi, category_info ci " +
            "where vi.cover = pi.id and vi.up = ui.id and vi.category = #{category} and ci.id = #{category}")
    public List<VideoVO> getVideoListByCategory(@Param("category") String cid);

    @Insert("insert into video_info(id, title, url, cid, cover, comment_id, up,description) values(#{id}, #{title}, #{url}, #{cid}, #{cover}, #{comment_id}, #{up}, #{description})")
    public void addVideo(VideoInfoEntity videoInfoEntity);



}
