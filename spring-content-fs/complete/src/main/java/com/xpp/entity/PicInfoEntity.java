package com.xpp.entity;

import javax.persistence.*;

/**
 * @author pengyuxiang
 * @date 2019/1/13
 */

@Entity
@Table(name = "pic_info")
public class PicInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //图片url
    private String url;
    //图片名称
    private String name;
    //图片描述
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
