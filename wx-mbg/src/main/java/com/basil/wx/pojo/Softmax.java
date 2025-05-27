package com.basil.wx.pojo;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Softmax implements Serializable {
    private Integer id;

    private String image;

    private Integer diseases;

    private BigDecimal diseases1;

    private BigDecimal diseases2;

    private BigDecimal diseases3;

    private BigDecimal diseases4;

    private BigDecimal diseases5;

    private BigDecimal diseases6;

    private BigDecimal diseases7;

    private Byte status;

    private Byte isDeleted;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getDiseases() {
        return diseases;
    }

    public void setDiseases(Integer diseases) {
        this.diseases = diseases;
    }

    public BigDecimal getDiseases1() {
        return diseases1;
    }

    public void setDiseases1(BigDecimal diseases1) {
        this.diseases1 = diseases1;
    }

    public BigDecimal getDiseases2() {
        return diseases2;
    }

    public void setDiseases2(BigDecimal diseases2) {
        this.diseases2 = diseases2;
    }

    public BigDecimal getDiseases3() {
        return diseases3;
    }

    public void setDiseases3(BigDecimal diseases3) {
        this.diseases3 = diseases3;
    }

    public BigDecimal getDiseases4() {
        return diseases4;
    }

    public void setDiseases4(BigDecimal diseases4) {
        this.diseases4 = diseases4;
    }

    public BigDecimal getDiseases5() {
        return diseases5;
    }

    public void setDiseases5(BigDecimal diseases5) {
        this.diseases5 = diseases5;
    }

    public BigDecimal getDiseases6() {
        return diseases6;
    }

    public void setDiseases6(BigDecimal diseases6) {
        this.diseases6 = diseases6;
    }

    public BigDecimal getDiseases7() {
        return diseases7;
    }

    public void setDiseases7(BigDecimal diseases7) {
        this.diseases7 = diseases7;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", image=").append(image);
        sb.append(", diseases=").append(diseases);
        sb.append(", diseases1=").append(diseases1);
        sb.append(", diseases2=").append(diseases2);
        sb.append(", diseases3=").append(diseases3);
        sb.append(", diseases4=").append(diseases4);
        sb.append(", diseases5=").append(diseases5);
        sb.append(", diseases6=").append(diseases6);
        sb.append(", diseases7=").append(diseases7);
        sb.append(", status=").append(status);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}