package com.xpp.entity;

import javax.persistence.*;

/**
 * @author pengyuxiang
 * @date 2019/1/13
 */

@Entity
@Table(name = "comment_info")
public class CommentInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "lvl_num")
    private String lvlNum;

    @Column(name = "comment_id")
    private String commentId;

    private String content;
    private String postman;

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

    public String getLvlNum() {
        return lvlNum;
    }

    public void setLvlNum(String lvlNum) {
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
