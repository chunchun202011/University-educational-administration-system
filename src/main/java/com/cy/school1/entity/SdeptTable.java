package com.cy.school1.entity;

import java.util.Objects;

/* 表示学院、专业的实体类 */
public class SdeptTable extends BaseEntity{
    private int id;
    private String parent;  //父代号：院系
    private String sid; //专业代号
    private String name;    //专业名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SdeptTable)) return false;
        if (!super.equals(o)) return false;
        SdeptTable that = (SdeptTable) o;
        return getId() == that.getId() && Objects.equals(getParent(), that.getParent()) && Objects.equals(getSid(), that.getSid()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getParent(), getSid(), getName());
    }

    @Override
    public String toString() {
        return "SdeptTable{" +
                "id=" + id +
                ", parent='" + parent + '\'' +
                ", sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
