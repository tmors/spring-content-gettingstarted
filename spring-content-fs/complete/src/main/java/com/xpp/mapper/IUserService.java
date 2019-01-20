package com.xpp.mapper;

import com.xpp.entity.UserInfoEntity;
import com.xpp.vo.UserVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author pengyuxiang
 * @date 2019/1/5
 */
public interface IUserService {
    @Select("select * from user_info where user_id=#{id}")
    public UserVO getUserById(@Param("id") String userId);

    @Insert("insert into user_info(" +
            "id, user_id, name, nickname, passwd, " +
            "face, sex, rank, regtime, birthday, description, " +
            "fans, follows, friends, videos" +
            ") values(" +
            "#{id},#{userId}, #{name}, #{nickname}, #{passwd}," +
            "#{face}, #{sex}, #{rank}, #{regtime}, #{birthday}, #{description}," +
            "#{fans}, #{follows}, #{friends}, #{videos})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public void addUser(UserInfoEntity userInfoEntity);

}
