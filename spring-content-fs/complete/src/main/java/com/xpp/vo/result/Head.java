package com.xpp.vo.result;

/**
 * @author pengyuxiang
 * @date 2019/1/16
 */
public class Head {
    private String param;
    private String gotoX;
    private String style;
    private String title;

    public Head(String param, String gotoX, String style, String title) {
        this.param = param;
        this.gotoX = gotoX;
        this.style = style;
        this.title = title;
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
