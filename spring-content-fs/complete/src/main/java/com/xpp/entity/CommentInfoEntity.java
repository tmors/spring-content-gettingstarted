package com.xpp.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author pengyuxiang
 * @date 2019/1/13
 */

@Entity
@Table(name = "comment_info")
@Data
public class CommentInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "lvl_num")
    private Integer lvlNum;

    @Column(name = "comment_id")
    private String commentId;

    private String content;

    private String postman;

    @Column(name = "video_id")
    private String video_id;


    private String create_time;

    public String getVideo_id() {
        return video_id;
    }

    public void setVideo_id(String video_id) {
        this.video_id = video_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getLvlNum() {
        return lvlNum;
    }

    public void setLvlNum(Integer lvlNum) {
        this.lvlNum = lvlNum;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostman() {
        return postman;
    }

    public void setPostman(String postman) {
        this.postman = postman;
    }
}
