package com.resale.background.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Commission {
    private Integer id;

    private BigDecimal agencyNum;

    private BigDecimal adminNum;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAgencyNum() {
        return agencyNum;
    }

    public void setAgencyNum(BigDecimal agencyNum) {
        this.agencyNum = agencyNum;
    }

    public BigDecimal getAdminNum() {
        return adminNum;
    }

    public void setAdminNum(BigDecimal adminNum) {
        this.adminNum = adminNum;
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
}