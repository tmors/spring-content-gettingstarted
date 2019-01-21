package com.xpp.mapper;

import com.xpp.entity.VideoInfoEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author pengyuxiang
 * @date 2019/1/21
 */
public interface IVideoInfoSerivce {

    @Select("select vi.video_id, vi.url, vi.height, vi.width from video_info vi where vi.video_id = #{cid}")
    public VideoInfoEntity getVideoInfoByCid(@Param("cid") String cid);

}
