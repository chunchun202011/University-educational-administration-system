package com.cy.school1.entity;

import java.util.Date;
import java.util.Objects;

/* 成绩实体类 */
//@Data //set,get
//@Setter
//@Constructor、@AllConstructor
public class Score {
    private String sdeno;
    private String sdept;
    private String classes;
    private String sno;
    private String cno;
    private Integer grade;
    private Integer isDelete;
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;

    public String getSdeno() {
        return sdeno;
    }

    public void setSdeno(String sdeno) {
        this.sdeno = sdeno;
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score)) return false;
        Score score = (Score) o;
        return Objects.equals(getSdeno(), score.getSdeno()) && Objects.equals(getSdept(), score.getSdept()) && Objects.equals(getClasses(), score.getClasses()) && Objects.equals(getSno(), score.getSno()) && Objects.equals(getCno(), score.getCno()) && Objects.equals(getGrade(), score.getGrade()) && Objects.equals(getIsDelete(), score.getIsDelete()) && Objects.equals(getCreatedUser(), score.getCreatedUser()) && Objects.equals(getCreatedTime(), score.getCreatedTime()) && Objects.equals(getModifiedUser(), score.getModifiedUser()) && Objects.equals(getModifiedTime(), score.getModifiedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSdeno(), getSdept(), getClasses(), getSno(), getCno(), getGrade(), getIsDelete(), getCreatedUser(), getCreatedTime(), getModifiedUser(), getModifiedTime());
    }

    @Override
    public String toString() {
        return "Score{" +
                ", sdeno='" + sdeno + '\'' +
                ", sdept='" + sdept + '\'' +
                ", classes='" + classes + '\'' +
                ", sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", grade=" + grade +
                ", isDelete=" + isDelete +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
