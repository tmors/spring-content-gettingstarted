package com.xpp.mapper;

import com.xpp.entity.CommentInfoEntity;
import com.xpp.vo.CommentVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author pengyuxiang
 * @date 2019/1/13
 */
public interface ICommentService {
    @Select("select ui.id, ui.name as nickname, c.user_id, pi.url as face, c.lvl_num,  c.comment_id, c.content   from video_info vi, comment_info c, user_info ui, pic_info pi where vi.cid = #{cid} and vi.comment_id = c.id and c.postman = ui.id and vi.cover = pi.id")
    public CommentVO getCommentByCid(@Param("cid") String cid);

    @Insert("insert into comment_info(id, user_id, lvl_num, comment_id, content, postman) values(#{id}, #{userId}, #{lvlNum}, #{commentId}, #{content}, #{postman})")
    public void addComment(CommentInfoEntity commentInfoEntity);
}
