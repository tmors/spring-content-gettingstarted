package com.xpp.vo;

/**
 * @author pengyuxiang
 * @date 2019/1/12
 */
public class CommentVO {
    //用户id
    private String id;
    //昵称
    private String nickname;
    //用户头像
    private String face;
    //层数
    private String lvl_num;
    //评论id
    private String comment_id;
    //评论内容
    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getLvl_num() {
        return lvl_num;
    }

    public void setLvl_num(String lvl_num) {
        this.lvl_num = lvl_num;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
