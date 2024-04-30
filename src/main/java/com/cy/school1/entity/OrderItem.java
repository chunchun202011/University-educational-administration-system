package com.cy.school1.entity;

import com.cy.school1.controller.BaseController;

import java.util.Objects;

/* 选课单中的课程数据 */
public class OrderItem extends BaseEntity {
    private Integer od;
    private String sno;
    private Integer scid;
    private String cno;
    private String cname;
    private Integer credit;
    private Integer term;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
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

    public Integer getOd() {
        return od;
    }

    public void setOd(Integer od) {
        this.od = od;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        if (!super.equals(o)) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(getOd(), orderItem.getOd()) && Objects.equals(getSno(), orderItem.getSno()) && Objects.equals(getScid(), orderItem.getScid()) && Objects.equals(getCno(), orderItem.getCno()) && Objects.equals(getCname(), orderItem.getCname()) && Objects.equals(getCredit(), orderItem.getCredit()) && Objects.equals(getTerm(), orderItem.getTerm());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOd(), getSno(), getScid(), getCno(), getCname(), getCredit(), getTerm());
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "od=" + od +
                ", sno='" + sno + '\'' +
                ", scid=" + scid +
                ", cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", credit=" + credit +
                ", term=" + term +
                '}';
    }
}
