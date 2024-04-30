package com.cy.school1.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class OrderVO implements Serializable {
    private Integer scid;
    private String sno;
    private String sname;
    private String cno;
    private String cname;
    private Integer credit;
    private Integer term;
    private Integer totalCredit;
    private Date createdTime;

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(Integer totalCredit) {
        this.totalCredit = totalCredit;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderVO)) return false;
        OrderVO orderVO = (OrderVO) o;
        return Objects.equals(getScid(), orderVO.getScid()) && Objects.equals(getSno(), orderVO.getSno()) && Objects.equals(getSname(), orderVO.getSname()) && Objects.equals(getCno(), orderVO.getCno()) && Objects.equals(getCname(), orderVO.getCname()) && Objects.equals(getCredit(), orderVO.getCredit()) && Objects.equals(getTerm(), orderVO.getTerm()) && Objects.equals(getTotalCredit(), orderVO.getTotalCredit()) && Objects.equals(getCreatedTime(), orderVO.getCreatedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getScid(), getSno(), getSname(), getCno(), getCname(), getCredit(), getTerm(), getTotalCredit(), getCreatedTime());
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "scid=" + scid +
                ", sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", credit=" + credit +
                ", term=" + term +
                ", totalCredit=" + totalCredit +
                ", createdTime=" + createdTime +
                '}';
    }
}
