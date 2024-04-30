package com.cy.school1.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class SCVO implements Serializable {
    private String sno;
    private String sname;
    private String cno;
    private String cname;
    private String tno;
    private String tname;
    private Integer credit;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
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

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
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
        if (!(o instanceof SCVO)) return false;
        SCVO scvo = (SCVO) o;
        return Objects.equals(getSno(), scvo.getSno()) && Objects.equals(getSname(), scvo.getSname()) && Objects.equals(getCno(), scvo.getCno()) && Objects.equals(getCname(), scvo.getCname()) && Objects.equals(getTno(), scvo.getTno()) && Objects.equals(getTname(), scvo.getTname()) && Objects.equals(getCredit(), scvo.getCredit()) && Objects.equals(getCreatedTime(), scvo.getCreatedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSno(), getSname(), getCno(), getCname(), getTno(), getTname(), getCredit(), getCreatedTime());
    }

    @Override
    public String toString() {
        return "SCVO{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", credit=" + credit +
                ", createdTime=" + createdTime +
                '}';
    }
}
