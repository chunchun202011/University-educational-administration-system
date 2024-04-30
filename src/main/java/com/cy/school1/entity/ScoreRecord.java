package com.cy.school1.entity;

import java.io.Serializable;
import java.util.Objects;

public class ScoreRecord extends BaseEntity implements Serializable {
    Integer sr;
    String sno;
    String cno;

    public Integer getSr() {
        return sr;
    }

    public void setSr(Integer sr) {
        this.sr = sr;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScoreRecord)) return false;
        if (!super.equals(o)) return false;
        ScoreRecord that = (ScoreRecord) o;
        return Objects.equals(getSr(), that.getSr()) && Objects.equals(getSno(), that.getSno()) && Objects.equals(getCno(), that.getCno());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSr(), getSno(), getCno());
    }


    @Override
    public String toString() {
        return "ScoreRecord{" +
                "sr=" + sr +
                ", sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                '}';
    }
}
