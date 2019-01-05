package entity;

/**
 * @author pengyuxiang
 * @date 2018/12/21
 */
public class VideoEntity {
    private String title;
    private String videoUrl;

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
}
