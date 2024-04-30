package com.cy.school1.entity;

import org.springframework.util.unit.DataSize;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/* 选课单数据的实体类 */
public class SCOrder extends BaseEntity implements Serializable {
    private Integer scid;
    private String sno;
    private String cno;
    private Integer totalCredit;
    private Integer status;
    private Date orderTime;
    private Date chooseTime;

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
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

    public Integer getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(Integer totalCredit) {
        this.totalCredit = totalCredit;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getChooseTime() {
        return chooseTime;
    }

    public void setChooseTime(Date chooseTime) {
        this.chooseTime = chooseTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SCOrder)) return false;
        if (!super.equals(o)) return false;
        SCOrder scOrder = (SCOrder) o;
        return Objects.equals(getScid(), scOrder.getScid()) && Objects.equals(getSno(), scOrder.getSno()) && Objects.equals(getCno(), scOrder.getCno()) && Objects.equals(getTotalCredit(), scOrder.getTotalCredit()) && Objects.equals(getStatus(), scOrder.getStatus()) && Objects.equals(getOrderTime(), scOrder.getOrderTime()) && Objects.equals(getChooseTime(), scOrder.getChooseTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getScid(), getSno(), getCno(), getTotalCredit(), getStatus(), getOrderTime(), getChooseTime());
    }

    @Override
    public String toString() {
        return "SCOrder{" +
                "scid=" + scid +
                ", sno='" + sno + '\'' +
                ", cno='" + cno + '\'' +
                ", totalCredit=" + totalCredit +
                ", status=" + status +
                ", orderTime=" + orderTime +
                ", chooseTime=" + chooseTime +
                '}';
    }
}
