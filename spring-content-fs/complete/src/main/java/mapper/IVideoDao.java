package mapper;

import entity.VideoEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author pengyuxiang
 * @date 2019/1/8
 */
public interface IVideoDao {
    @Select("select * from video_info where Id=#{id}")
    public VideoEntity getVideoInfoById(@Param("id") String userId);
}
