package com.xpp.mapper;

import com.xpp.entity.PicInfoEntity;
import org.apache.ibatis.annotations.Insert;

/**
 * @author pengyuxiang
 * @date 2019/1/13
 */
public interface IPicSerivce {
    @Insert("insert into pic_info(id, name, url, description) values(#{id}, #{name}, #{url}, #{description})")
    public void addPic(PicInfoEntity picInfoEntity);
}
