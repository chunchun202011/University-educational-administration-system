package com.cy.school1.entity;

import java.util.Date;
import java.util.Objects;

public class Teacher extends BaseEntity{
    private String tno;
    private String tname;
    private String password;
    private String phone;
    private String email;
    private Integer gender;
    private String avatar;
    private Integer isDelete;
    private String createdUser;
    private Date createdTime;
    private String modifiedUser;
    private Date modifiedTime;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getTno(), teacher.getTno()) && Objects.equals(getTname(), teacher.getTname()) && Objects.equals(getPassword(), teacher.getPassword()) && Objects.equals(getPhone(), teacher.getPhone()) && Objects.equals(getEmail(), teacher.getEmail()) && Objects.equals(getGender(), teacher.getGender()) && Objects.equals(getAvatar(), teacher.getAvatar()) && Objects.equals(getIsDelete(), teacher.getIsDelete()) && Objects.equals(getCreatedUser(), teacher.getCreatedUser()) && Objects.equals(getCreatedTime(), teacher.getCreatedTime()) && Objects.equals(getModifiedUser(), teacher.getModifiedUser()) && Objects.equals(getModifiedTime(), teacher.getModifiedTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTno(), getTname(), getPassword(), getPhone(), getEmail(), getGender(), getAvatar(), getIsDelete(), getCreatedUser(), getCreatedTime(), getModifiedUser(), getModifiedTime());
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tno='" + tno + '\'' +
                ", tname='" + tname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", avatar='" + avatar + '\'' +
                ", isDelete=" + isDelete +
                ", createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
