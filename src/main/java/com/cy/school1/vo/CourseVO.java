package com.cy.school1.vo;

import java.io.Serializable;
import java.util.Objects;

// 与教师表联立的课程表
public class CourseVO implements Serializable {
    private String cno;
    private String cname;
    private Integer credit;
    private String tno;
    private String tname;
    private String cplace;
    private String ctime;
    private Integer need;
    private String detail;

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

    public String getCplace() {
        return cplace;
    }

    public void setCplace(String cplace) {
        this.cplace = cplace;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public Integer getNeed() {
        return need;
    }

    public void setNeed(Integer need) {
        this.need = need;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseVO)) return false;
        CourseVO courseVO = (CourseVO) o;
        return Objects.equals(getCno(), courseVO.getCno()) && Objects.equals(getCname(), courseVO.getCname()) && Objects.equals(getCredit(), courseVO.getCredit()) && Objects.equals(getTno(), courseVO.getTno()) && Objects.equals(getTname(), courseVO.getTname()) && Objects.equals(getCplace(), courseVO.getCplace()) && Objects.equals(getCtime(), courseVO.getCtime()) && Objects.equals(getNeed(), courseVO.getNeed()) && Objects.equals(getDetail(), courseVO.getDetail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCno(), getCname(), getCredit(), getTno(), getTname(), getCplace(), getCtime(), getNeed(), getDetail());
    }

    @Override
    public String toString() {
        return "CourseVO{" +
                "cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", credit=" + credit +
                ", tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", cplace='" + cplace + '\'' +
                ", ctime='" + ctime + '\'' +
                ", need=" + need +
                ", detail='" + detail + '\'' +
                '}';
    }
}
