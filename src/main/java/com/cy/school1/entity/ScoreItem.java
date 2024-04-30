package com.cy.school1.entity;

import java.io.Serializable;
import java.util.Objects;

public class ScoreItem extends BaseEntity implements Serializable {
    Integer so;
    String sno;
    Integer sr;
    String cno;
    Integer grade;

    public Integer getSo() {
        return so;
    }

    public void setSo(Integer so) {
        this.so = so;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Integer getSr() {
        return sr;
    }

    public void setSr(Integer sr) {
        this.sr = sr;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScoreItem)) return false;
        if (!super.equals(o)) return false;
        ScoreItem scoreItem = (ScoreItem) o;
        return Objects.equals(getSo(), scoreItem.getSo()) && Objects.equals(getSno(), scoreItem.getSno()) && Objects.equals(getSr(), scoreItem.getSr()) && Objects.equals(getCno(), scoreItem.getCno()) && Objects.equals(getGrade(), scoreItem.getGrade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSo(), getSno(), getSr(), getCno(), getGrade());
    }

    @Override
    public String toString() {
        return "ScoreItem{" +
                "so=" + so +
                ", sno='" + sno + '\'' +
                ", sr=" + sr +
                ", cno='" + cno + '\'' +
                ", grade=" + grade +
                '}';
    }
}
