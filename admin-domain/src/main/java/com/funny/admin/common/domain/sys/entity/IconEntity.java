package com.funny.admin.common.domain.sys.entity;

/**
 * Created by fangli@autohome.com.cn on 2016/10/11.
 */
public class IconEntity {
    private Long id;
    private Integer iconType;
    private String className;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIconType() {
        return iconType;
    }

    public void setIconType(Integer iconType) {
        this.iconType = iconType;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
