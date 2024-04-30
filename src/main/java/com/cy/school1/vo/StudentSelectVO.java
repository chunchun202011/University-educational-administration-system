package com.cy.school1.vo;

import java.io.Serializable;
import java.util.Objects;

public class StudentSelectVO implements Serializable {
    private String sno;
    private String sname;
    private String cno;
    private String cname;
    private Integer credit;
    private Integer ctime;
    private String tno;
    private String tname;

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

    public Integer getCtime() {
        return ctime;
    }

    public void setCtime(Integer ctime) {
        this.ctime = ctime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentSelectVO)) return false;
        StudentSelectVO that = (StudentSelectVO) o;
        return Objects.equals(getSno(), that.getSno()) && Objects.equals(getSname(), that.getSname()) && Objects.equals(getCno(), that.getCno()) && Objects.equals(getCname(), that.getCname()) && Objects.equals(getCredit(), that.getCredit()) && Objects.equals(getCtime(), that.getCtime()) && Objects.equals(getTno(), that.getTno()) && Objects.equals(getTname(), that.getTname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSno(), getSname(), getCno(), getCname(), getCredit(), getCtime(), getTno(), getTname());
    }

    @Override
    public String toString() {
        return "StudentSelectVO{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", credit=" + credit +
                ", ctime=" + ctime +
                ", tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }
}
