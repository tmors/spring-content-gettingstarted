package entity;

/**
 * @author pengyuxiang
 * @date 2018/12/21
 */
public class VideoEntity {
    private String title;
    private String videoUrl;
    private String description;
    private String picUrl;
    private String picDesc;
    private String comments;
    private String category;
    private String playnumber;
    private String weight;


    public VideoEntity(String title, String videoUrl) {
        this.title = title;
        this.videoUrl = videoUrl;
    }

    public VideoEntity() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicDesc() {
        return picDesc;
    }

    public void setPicDesc(String picDesc) {
        this.picDesc = picDesc;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
