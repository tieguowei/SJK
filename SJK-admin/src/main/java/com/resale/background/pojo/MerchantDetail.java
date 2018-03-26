package com.resale.background.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class MerchantDetail {
	private Integer id;

    private String merchantName;

    private String merchantCode;

    private String invitationCode;

    private String isCommission;

    private String logoUrl;

    private String telephone;

    private String operatingStatus;

    private String phone;

    private Date openingTime;

    private Date closeTime;

    private BigDecimal floorPrice;

    private BigDecimal shippingFee;

    private String taskTime;

    private String isPersonage;

    private String idCard;

    private String idCardUrl;

    private String businessLicenseUrl;

    private Long margin;

    private String marginStatus;

    private String dimensionality;

    private String longitude;

    private Date createTime;

    private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode == null ? null : merchantCode.trim();
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode == null ? null : invitationCode.trim();
    }

    public String getIsCommission() {
        return isCommission;
    }

    public void setIsCommission(String isCommission) {
        this.isCommission = isCommission == null ? null : isCommission.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getOperatingStatus() {
        return operatingStatus;
    }

    public void setOperatingStatus(String operatingStatus) {
        this.operatingStatus = operatingStatus == null ? null : operatingStatus.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Date openingTime) {
        this.openingTime = openingTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public BigDecimal getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(BigDecimal floorPrice) {
        this.floorPrice = floorPrice;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getTaskTime() {
        return taskTime;
    }

    public void setTaskTime(String taskTime) {
        this.taskTime = taskTime == null ? null : taskTime.trim();
    }

    public String getIsPersonage() {
        return isPersonage;
    }

    public void setIsPersonage(String isPersonage) {
        this.isPersonage = isPersonage == null ? null : isPersonage.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getIdCardUrl() {
        return idCardUrl;
    }

    public void setIdCardUrl(String idCardUrl) {
        this.idCardUrl = idCardUrl == null ? null : idCardUrl.trim();
    }

    public String getBusinessLicenseUrl() {
        return businessLicenseUrl;
    }

    public void setBusinessLicenseUrl(String businessLicenseUrl) {
        this.businessLicenseUrl = businessLicenseUrl == null ? null : businessLicenseUrl.trim();
    }

    public Long getMargin() {
        return margin;
    }

    public void setMargin(Long margin) {
        this.margin = margin;
    }

    public String getMarginStatus() {
        return marginStatus;
    }

    public void setMarginStatus(String marginStatus) {
        this.marginStatus = marginStatus == null ? null : marginStatus.trim();
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

	public String getDimensionality() {
		return dimensionality;
	}

	public void setDimensionality(String dimensionality) {
		this.dimensionality = dimensionality;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
    
}