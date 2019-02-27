package com.xpp.mapper;

import com.xpp.entity.CommentDTO;
import com.xpp.entity.CommentInfoEntity;
import com.xpp.vo.CommentVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author pengyuxiang
 * @date 2019/1/13
 */
public interface ICommentService {
    @Select("select ui.face, ui.sex, ui.nickname as nick, ui.rank, ci.content as msg, ci.lvl_num as lv from comment_info ci, user_info ui where ci.video_id = #{aid} and ci.user_id = ui.user_id")
    public List<CommentDTO> getCommentByAid(@Param("aid") String aid);

    @Insert("insert into comment_info(id, user_id, lvl_num, comment_id, content, postman) values(#{id}, #{userId}, #{lvlNum}, #{commentId}, #{content}, #{postman})")
    public void addComment(CommentInfoEntity commentInfoEntity);
}
