package com.cy.school1.entity;

import java.util.Objects;

public class SC extends BaseEntity{
    private String newCno;
    private String sno;
    private String cno;
    private Integer term;
    private Integer credit;
    private Integer total;

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

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getNewCno() {
        return newCno;
    }

    public void setNewCno(String newCno) {
        this.newCno = newCno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SC)) return false;
        if (!super.equals(o)) return false;
        SC sc = (SC) o;
        return Objects.equals(getNewCno(), sc.getNewCno()) && Objects.equals(getSno(), sc.getSno()) && Objects.equals(getCno(), sc.getCno()) && Objects.equals(getTerm(), sc.getTerm()) && Objects.equals(getCredit(), sc.getCredit()) && Objects.equals(getTotal(), sc.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNewCno(), getSno(), getCno(), getTerm(), getCredit(), getTotal());
    }

    @Override
    public String toString() {
        return "SC{" +
                "newCno='" + newCno + '\'' +
                ", sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", term=" + term +
                ", credit=" + credit +
                ", total=" + total +
                '}';
    }
}
