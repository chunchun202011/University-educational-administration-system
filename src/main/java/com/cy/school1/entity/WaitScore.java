package com.cy.school1.entity;

import java.util.Objects;

// 待添加成绩列表（课程）
public class WaitScore extends BaseEntity{
    Integer wid;
    String cno;
    Integer isDelete;

    public Integer getWid() {
        return wid;
    }

    public void setWid(Integer wid) {
        this.wid = wid;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WaitScore)) return false;
        if (!super.equals(o)) return false;
        WaitScore waitScore = (WaitScore) o;
        return Objects.equals(getWid(), waitScore.getWid()) && Objects.equals(getCno(), waitScore.getCno()) && Objects.equals(getIsDelete(), waitScore.getIsDelete());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getWid(), getCno(), getIsDelete());
    }

    @Override
    public String toString() {
        return "WaitScore{" +
                "wid=" + wid +
                ", cno='" + cno + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
