package com.xpp.vo.result;

import com.xpp.vo.VideoDetailsInfoVO;

import java.util.List;

/**
 * @author pengyuxiang
 * @date 2019/1/16
 */
public class ResultBean {
    private String type;
    private Head head;
    private List<VideoDetailsInfoVO> body;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public List<VideoDetailsInfoVO> getBody() {
        return body;
    }

    public void setBody(List<VideoDetailsInfoVO> body) {
        this.body = body;
    }
}
