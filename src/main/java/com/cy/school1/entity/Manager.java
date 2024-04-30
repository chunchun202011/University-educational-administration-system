package com.cy.school1.entity;

import java.util.Date;
import java.util.Objects;

public class Manager extends BaseEntity{
    private String mno;
    private String mname;
    private String password;

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(getMno(), manager.getMno()) && Objects.equals(getMname(), manager.getMname()) && Objects.equals(getPassword(), manager.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMno(), getMname(), getPassword());
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mno='" + mno + '\'' +
                ", mname='" + mname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
