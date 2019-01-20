package com.xpp.mapper;

import com.xpp.entity.CategoryEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author pengyuxiang
 * @date 2019/1/17
 */
public interface ICategoryService {

    @Insert("insert into category_info(id, type, param, gotox, style, title) values(#{id}, #{type}, #{param}, #{gotoX}, #{style}, #{title})")
    public void addCategory(CategoryEntity categoryEntity);

    @Select("select ci.id, ci.type, ci.param, ci.gotox, ci.style, ci.title from category_info ci")
    public List<CategoryEntity> getAllCategory();
}
