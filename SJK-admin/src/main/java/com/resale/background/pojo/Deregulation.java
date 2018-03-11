package com.resale.background.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Deregulation {
    private Integer id;

    private String merchatName;

    private String merchatCode;

    private String detail;

    private String informerPhone;

    private Integer userId;

    private String status;

    private BigDecimal amountDeducted;

    private Date createTime;

    private Date updateTime;

    private Integer creatorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMerchatName() {
        return merchatName;
    }

    public void setMerchatName(String merchatName) {
        this.merchatName = merchatName == null ? null : merchatName.trim();
    }

    public String getMerchatCode() {
        return merchatCode;
    }

    public void setMerchatCode(String merchatCode) {
        this.merchatCode = merchatCode == null ? null : merchatCode.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getInformerPhone() {
        return informerPhone;
    }

    public void setInformerPhone(String informerPhone) {
        this.informerPhone = informerPhone == null ? null : informerPhone.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public BigDecimal getAmountDeducted() {
        return amountDeducted;
    }

    public void setAmountDeducted(BigDecimal amountDeducted) {
        this.amountDeducted = amountDeducted;
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

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }
}