package com.cy.school1.vo;

import java.io.Serializable;
import java.util.Objects;

/* 成绩的VO类 */
public class ScoreVO implements Serializable {
    private String sno;
    private String sname;
    private Integer sr;
    private String cno;
    private String cname;
    private Integer grade;
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getSr() {
        return sr;
    }

    public void setSr(Integer sr) {
        this.sr = sr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScoreVO)) return false;
        ScoreVO scoreVO = (ScoreVO) o;
        return Objects.equals(getSno(), scoreVO.getSno()) && Objects.equals(getSname(), scoreVO.getSname()) && Objects.equals(getSr(), scoreVO.getSr()) && Objects.equals(getCno(), scoreVO.getCno()) && Objects.equals(getCname(), scoreVO.getCname()) && Objects.equals(getGrade(), scoreVO.getGrade()) && Objects.equals(getTname(), scoreVO.getTname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSno(), getSname(), getSr(), getCno(), getCname(), getGrade(), getTname());
    }

    @Override
    public String toString() {
        return "ScoreVO{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", sr='" + sr + '\'' +
                ", cno='" + cno + '\'' +
                ", cname='" + cname + '\'' +
                ", grade=" + grade +
                ", tname='" + tname + '\'' +
                '}';
    }
}