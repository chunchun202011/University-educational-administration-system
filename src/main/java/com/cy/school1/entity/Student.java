package com.cy.school1.entity;

/*用户的实体类：SpringBoot约定大于配置*/
import java.io.Serializable;
import java.util.Objects;

public class Student extends BaseEntity implements Serializable {
    private String sno;
    private String sname;
    private String password;
    private String phone;
    private String email;
    private Integer gender;
    private String sdept;
    private String classes;
    private String status;
    private String shome;
    private String avatar;
    private Integer isDelete;

    //1.get和set方法，equals和hashCode()方法,toString()方法

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShome() {
        return shome;
    }

    public void setShome(String shome) {
        this.shome = shome;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(getSno(), student.getSno()) && Objects.equals(getSname(), student.getSname()) && Objects.equals(getPassword(), student.getPassword()) && Objects.equals(getPhone(), student.getPhone()) && Objects.equals(getEmail(), student.getEmail()) && Objects.equals(getGender(), student.getGender()) && Objects.equals(getSdept(), student.getSdept()) && Objects.equals(getClasses(), student.getClasses()) && Objects.equals(getStatus(), student.getStatus()) && Objects.equals(getShome(), student.getShome()) && Objects.equals(getAvatar(), student.getAvatar()) && Objects.equals(getIsDelete(), student.getIsDelete());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSno(), getSname(), getPassword(), getPhone(), getEmail(), getGender(), getSdept(), getClasses(), getStatus(), getShome(), getAvatar(), getIsDelete());
    }

    @Override
    public String toString() {
        return "Student{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", sdept='" + sdept + '\'' +
                ", classes='" + classes + '\'' +
                ", status='" + status + '\'' +
                ", shome='" + shome + '\'' +
                ", avatar='" + avatar + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
