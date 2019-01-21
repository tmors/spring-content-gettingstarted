package com.xpp.entity;

import javax.persistence.*;

/**
 * @author pengyuxiang
 * @date 2019/1/13
 */
@Entity
@Table(name = "video_details_info")
public class VideoDetailsInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    //视频对应文件id，前台向后端获取
    @Column(name = "video_id")
    private String videoId;

    //Style
    private String style;
    //pic外键
    private String cover;
    //文件名
    private String filename;
    //描述
    private String description;
    //评论id
    private String comment_id;
    //权重
    private String weight;
    //分类
    private String category;
    //播放次数
    private String playnumber;
    //up主外键
    private String up;
    //弹幕库
    private String danmaku;
    //
    @Column(name = "goto_x")
    private String gotoX;
    //
    private String param;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlaynumber() {
        return playnumber;
    }

    public void setPlaynumber(String playnumber) {
        this.playnumber = playnumber;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getDanmaku() {
        return danmaku;
    }

    public void setDanmaku(String danmaku) {
        this.danmaku = danmaku;
    }

    public String getGotoX() {
        return gotoX;
    }

    public void setGotoX(String gotoX) {
        this.gotoX = gotoX;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
