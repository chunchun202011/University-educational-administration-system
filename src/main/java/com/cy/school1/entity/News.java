package com.cy.school1.entity;

import java.io.Serializable;
import java.util.Objects;

public class News extends BaseEntity implements Serializable {
    private Integer nid;
    private String title;
    private String content;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        if (!super.equals(o)) return false;
        News news = (News) o;
        return Objects.equals(getNid(), news.getNid()) && Objects.equals(getTitle(), news.getTitle()) && Objects.equals(getContent(), news.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNid(), getTitle(), getContent());
    }

    @Override
    public String toString() {
        return "News{" +
                "nid=" + nid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
