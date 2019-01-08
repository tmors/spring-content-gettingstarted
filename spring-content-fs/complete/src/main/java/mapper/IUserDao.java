package mapper;

import entity.UserEntity;
import entity.VideoEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author pengyuxiang
 * @date 2019/1/5
 */
public interface IUserDao {
    @Select("select * from user_details_info where user_id=#{id}")
    public UserEntity getUserById(@Param("id") String userId);


}
