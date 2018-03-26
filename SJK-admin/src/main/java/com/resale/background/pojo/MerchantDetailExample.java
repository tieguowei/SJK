package com.resale.background.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MerchantDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MerchantDetailExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNull() {
            addCriterion("merchant_name is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNotNull() {
            addCriterion("merchant_name is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameEqualTo(String value) {
            addCriterion("merchant_name =", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotEqualTo(String value) {
            addCriterion("merchant_name <>", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThan(String value) {
            addCriterion("merchant_name >", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_name >=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThan(String value) {
            addCriterion("merchant_name <", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThanOrEqualTo(String value) {
            addCriterion("merchant_name <=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLike(String value) {
            addCriterion("merchant_name like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotLike(String value) {
            addCriterion("merchant_name not like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIn(List<String> values) {
            addCriterion("merchant_name in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotIn(List<String> values) {
            addCriterion("merchant_name not in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameBetween(String value1, String value2) {
            addCriterion("merchant_name between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotBetween(String value1, String value2) {
            addCriterion("merchant_name not between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantCodeIsNull() {
            addCriterion("merchant_code is null");
            return (Criteria) this;
        }

        public Criteria andMerchantCodeIsNotNull() {
            addCriterion("merchant_code is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantCodeEqualTo(String value) {
            addCriterion("merchant_code =", value, "merchantCode");
            return (Criteria) this;
        }

        public Criteria andMerchantCodeNotEqualTo(String value) {
            addCriterion("merchant_code <>", value, "merchantCode");
            return (Criteria) this;
        }

        public Criteria andMerchantCodeGreaterThan(String value) {
            addCriterion("merchant_code >", value, "merchantCode");
            return (Criteria) this;
        }

        public Criteria andMerchantCodeGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_code >=", value, "merchantCode");
            return (Criteria) this;
        }

        public Criteria andMerchantCodeLessThan(String value) {
            addCriterion("merchant_code <", value, "merchantCode");
            return (Criteria) this;
        }

        public Criteria andMerchantCodeLessThanOrEqualTo(String value) {
            addCriterion("merchant_code <=", value, "merchantCode");
            return (Criteria) this;
        }

        public Criteria andMerchantCodeLike(String value) {
            addCriterion("merchant_code like", value, "merchantCode");
            return (Criteria) this;
        }

        public Criteria andMerchantCodeNotLike(String value) {
            addCriterion("merchant_code not like", value, "merchantCode");
            return (Criteria) this;
        }

        public Criteria andMerchantCodeIn(List<String> values) {
            addCriterion("merchant_code in", values, "merchantCode");
            return (Criteria) this;
        }

        public Criteria andMerchantCodeNotIn(List<String> values) {
            addCriterion("merchant_code not in", values, "merchantCode");
            return (Criteria) this;
        }

        public Criteria andMerchantCodeBetween(String value1, String value2) {
            addCriterion("merchant_code between", value1, value2, "merchantCode");
            return (Criteria) this;
        }

        public Criteria andMerchantCodeNotBetween(String value1, String value2) {
            addCriterion("merchant_code not between", value1, value2, "merchantCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeIsNull() {
            addCriterion("invitation_code is null");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeIsNotNull() {
            addCriterion("invitation_code is not null");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeEqualTo(String value) {
            addCriterion("invitation_code =", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotEqualTo(String value) {
            addCriterion("invitation_code <>", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeGreaterThan(String value) {
            addCriterion("invitation_code >", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeGreaterThanOrEqualTo(String value) {
            addCriterion("invitation_code >=", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeLessThan(String value) {
            addCriterion("invitation_code <", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeLessThanOrEqualTo(String value) {
            addCriterion("invitation_code <=", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeLike(String value) {
            addCriterion("invitation_code like", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotLike(String value) {
            addCriterion("invitation_code not like", value, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeIn(List<String> values) {
            addCriterion("invitation_code in", values, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotIn(List<String> values) {
            addCriterion("invitation_code not in", values, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeBetween(String value1, String value2) {
            addCriterion("invitation_code between", value1, value2, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andInvitationCodeNotBetween(String value1, String value2) {
            addCriterion("invitation_code not between", value1, value2, "invitationCode");
            return (Criteria) this;
        }

        public Criteria andIsCommissionIsNull() {
            addCriterion("is_commission is null");
            return (Criteria) this;
        }

        public Criteria andIsCommissionIsNotNull() {
            addCriterion("is_commission is not null");
            return (Criteria) this;
        }

        public Criteria andIsCommissionEqualTo(String value) {
            addCriterion("is_commission =", value, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionNotEqualTo(String value) {
            addCriterion("is_commission <>", value, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionGreaterThan(String value) {
            addCriterion("is_commission >", value, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionGreaterThanOrEqualTo(String value) {
            addCriterion("is_commission >=", value, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionLessThan(String value) {
            addCriterion("is_commission <", value, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionLessThanOrEqualTo(String value) {
            addCriterion("is_commission <=", value, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionLike(String value) {
            addCriterion("is_commission like", value, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionNotLike(String value) {
            addCriterion("is_commission not like", value, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionIn(List<String> values) {
            addCriterion("is_commission in", values, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionNotIn(List<String> values) {
            addCriterion("is_commission not in", values, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionBetween(String value1, String value2) {
            addCriterion("is_commission between", value1, value2, "isCommission");
            return (Criteria) this;
        }

        public Criteria andIsCommissionNotBetween(String value1, String value2) {
            addCriterion("is_commission not between", value1, value2, "isCommission");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNull() {
            addCriterion("logo_url is null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIsNotNull() {
            addCriterion("logo_url is not null");
            return (Criteria) this;
        }

        public Criteria andLogoUrlEqualTo(String value) {
            addCriterion("logo_url =", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotEqualTo(String value) {
            addCriterion("logo_url <>", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThan(String value) {
            addCriterion("logo_url >", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("logo_url >=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThan(String value) {
            addCriterion("logo_url <", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLessThanOrEqualTo(String value) {
            addCriterion("logo_url <=", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlLike(String value) {
            addCriterion("logo_url like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotLike(String value) {
            addCriterion("logo_url not like", value, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlIn(List<String> values) {
            addCriterion("logo_url in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotIn(List<String> values) {
            addCriterion("logo_url not in", values, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlBetween(String value1, String value2) {
            addCriterion("logo_url between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andLogoUrlNotBetween(String value1, String value2) {
            addCriterion("logo_url not between", value1, value2, "logoUrl");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusIsNull() {
            addCriterion("operating_status is null");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusIsNotNull() {
            addCriterion("operating_status is not null");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusEqualTo(String value) {
            addCriterion("operating_status =", value, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusNotEqualTo(String value) {
            addCriterion("operating_status <>", value, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusGreaterThan(String value) {
            addCriterion("operating_status >", value, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusGreaterThanOrEqualTo(String value) {
            addCriterion("operating_status >=", value, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusLessThan(String value) {
            addCriterion("operating_status <", value, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusLessThanOrEqualTo(String value) {
            addCriterion("operating_status <=", value, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusLike(String value) {
            addCriterion("operating_status like", value, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusNotLike(String value) {
            addCriterion("operating_status not like", value, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusIn(List<String> values) {
            addCriterion("operating_status in", values, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusNotIn(List<String> values) {
            addCriterion("operating_status not in", values, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusBetween(String value1, String value2) {
            addCriterion("operating_status between", value1, value2, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andOperatingStatusNotBetween(String value1, String value2) {
            addCriterion("operating_status not between", value1, value2, "operatingStatus");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeIsNull() {
            addCriterion("opening_time is null");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeIsNotNull() {
            addCriterion("opening_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeEqualTo(Date value) {
            addCriterion("opening_time =", value, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeNotEqualTo(Date value) {
            addCriterion("opening_time <>", value, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeGreaterThan(Date value) {
            addCriterion("opening_time >", value, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("opening_time >=", value, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeLessThan(Date value) {
            addCriterion("opening_time <", value, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeLessThanOrEqualTo(Date value) {
            addCriterion("opening_time <=", value, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeIn(List<Date> values) {
            addCriterion("opening_time in", values, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeNotIn(List<Date> values) {
            addCriterion("opening_time not in", values, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeBetween(Date value1, Date value2) {
            addCriterion("opening_time between", value1, value2, "openingTime");
            return (Criteria) this;
        }

        public Criteria andOpeningTimeNotBetween(Date value1, Date value2) {
            addCriterion("opening_time not between", value1, value2, "openingTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNull() {
            addCriterion("close_time is null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNotNull() {
            addCriterion("close_time is not null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeEqualTo(Date value) {
            addCriterion("close_time =", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotEqualTo(Date value) {
            addCriterion("close_time <>", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThan(Date value) {
            addCriterion("close_time >", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("close_time >=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThan(Date value) {
            addCriterion("close_time <", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThanOrEqualTo(Date value) {
            addCriterion("close_time <=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIn(List<Date> values) {
            addCriterion("close_time in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotIn(List<Date> values) {
            addCriterion("close_time not in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeBetween(Date value1, Date value2) {
            addCriterion("close_time between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotBetween(Date value1, Date value2) {
            addCriterion("close_time not between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andFloorPriceIsNull() {
            addCriterion("floor_price is null");
            return (Criteria) this;
        }

        public Criteria andFloorPriceIsNotNull() {
            addCriterion("floor_price is not null");
            return (Criteria) this;
        }

        public Criteria andFloorPriceEqualTo(BigDecimal value) {
            addCriterion("floor_price =", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceNotEqualTo(BigDecimal value) {
            addCriterion("floor_price <>", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceGreaterThan(BigDecimal value) {
            addCriterion("floor_price >", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("floor_price >=", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceLessThan(BigDecimal value) {
            addCriterion("floor_price <", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("floor_price <=", value, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceIn(List<BigDecimal> values) {
            addCriterion("floor_price in", values, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceNotIn(List<BigDecimal> values) {
            addCriterion("floor_price not in", values, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("floor_price between", value1, value2, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andFloorPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("floor_price not between", value1, value2, "floorPrice");
            return (Criteria) this;
        }

        public Criteria andShippingFeeIsNull() {
            addCriterion("shipping_fee is null");
            return (Criteria) this;
        }

        public Criteria andShippingFeeIsNotNull() {
            addCriterion("shipping_fee is not null");
            return (Criteria) this;
        }

        public Criteria andShippingFeeEqualTo(BigDecimal value) {
            addCriterion("shipping_fee =", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeNotEqualTo(BigDecimal value) {
            addCriterion("shipping_fee <>", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeGreaterThan(BigDecimal value) {
            addCriterion("shipping_fee >", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_fee >=", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeLessThan(BigDecimal value) {
            addCriterion("shipping_fee <", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("shipping_fee <=", value, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeIn(List<BigDecimal> values) {
            addCriterion("shipping_fee in", values, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeNotIn(List<BigDecimal> values) {
            addCriterion("shipping_fee not in", values, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_fee between", value1, value2, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andShippingFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("shipping_fee not between", value1, value2, "shippingFee");
            return (Criteria) this;
        }

        public Criteria andTaskTimeIsNull() {
            addCriterion("task_time is null");
            return (Criteria) this;
        }

        public Criteria andTaskTimeIsNotNull() {
            addCriterion("task_time is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTimeEqualTo(String value) {
            addCriterion("task_time =", value, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeNotEqualTo(String value) {
            addCriterion("task_time <>", value, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeGreaterThan(String value) {
            addCriterion("task_time >", value, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeGreaterThanOrEqualTo(String value) {
            addCriterion("task_time >=", value, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeLessThan(String value) {
            addCriterion("task_time <", value, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeLessThanOrEqualTo(String value) {
            addCriterion("task_time <=", value, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeLike(String value) {
            addCriterion("task_time like", value, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeNotLike(String value) {
            addCriterion("task_time not like", value, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeIn(List<String> values) {
            addCriterion("task_time in", values, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeNotIn(List<String> values) {
            addCriterion("task_time not in", values, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeBetween(String value1, String value2) {
            addCriterion("task_time between", value1, value2, "taskTime");
            return (Criteria) this;
        }

        public Criteria andTaskTimeNotBetween(String value1, String value2) {
            addCriterion("task_time not between", value1, value2, "taskTime");
            return (Criteria) this;
        }

        public Criteria andIsPersonageIsNull() {
            addCriterion("is_personage is null");
            return (Criteria) this;
        }

        public Criteria andIsPersonageIsNotNull() {
            addCriterion("is_personage is not null");
            return (Criteria) this;
        }

        public Criteria andIsPersonageEqualTo(String value) {
            addCriterion("is_personage =", value, "isPersonage");
            return (Criteria) this;
        }

        public Criteria andIsPersonageNotEqualTo(String value) {
            addCriterion("is_personage <>", value, "isPersonage");
            return (Criteria) this;
        }

        public Criteria andIsPersonageGreaterThan(String value) {
            addCriterion("is_personage >", value, "isPersonage");
            return (Criteria) this;
        }

        public Criteria andIsPersonageGreaterThanOrEqualTo(String value) {
            addCriterion("is_personage >=", value, "isPersonage");
            return (Criteria) this;
        }

        public Criteria andIsPersonageLessThan(String value) {
            addCriterion("is_personage <", value, "isPersonage");
            return (Criteria) this;
        }

        public Criteria andIsPersonageLessThanOrEqualTo(String value) {
            addCriterion("is_personage <=", value, "isPersonage");
            return (Criteria) this;
        }

        public Criteria andIsPersonageLike(String value) {
            addCriterion("is_personage like", value, "isPersonage");
            return (Criteria) this;
        }

        public Criteria andIsPersonageNotLike(String value) {
            addCriterion("is_personage not like", value, "isPersonage");
            return (Criteria) this;
        }

        public Criteria andIsPersonageIn(List<String> values) {
            addCriterion("is_personage in", values, "isPersonage");
            return (Criteria) this;
        }

        public Criteria andIsPersonageNotIn(List<String> values) {
            addCriterion("is_personage not in", values, "isPersonage");
            return (Criteria) this;
        }

        public Criteria andIsPersonageBetween(String value1, String value2) {
            addCriterion("is_personage between", value1, value2, "isPersonage");
            return (Criteria) this;
        }

        public Criteria andIsPersonageNotBetween(String value1, String value2) {
            addCriterion("is_personage not between", value1, value2, "isPersonage");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("id_card is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("id_card is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("id_card =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("id_card <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("id_card >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("id_card >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("id_card <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("id_card <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("id_card like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("id_card not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("id_card in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("id_card not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("id_card between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("id_card not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardUrlIsNull() {
            addCriterion("id_card_url is null");
            return (Criteria) this;
        }

        public Criteria andIdCardUrlIsNotNull() {
            addCriterion("id_card_url is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardUrlEqualTo(String value) {
            addCriterion("id_card_url =", value, "idCardUrl");
            return (Criteria) this;
        }

        public Criteria andIdCardUrlNotEqualTo(String value) {
            addCriterion("id_card_url <>", value, "idCardUrl");
            return (Criteria) this;
        }

        public Criteria andIdCardUrlGreaterThan(String value) {
            addCriterion("id_card_url >", value, "idCardUrl");
            return (Criteria) this;
        }

        public Criteria andIdCardUrlGreaterThanOrEqualTo(String value) {
            addCriterion("id_card_url >=", value, "idCardUrl");
            return (Criteria) this;
        }

        public Criteria andIdCardUrlLessThan(String value) {
            addCriterion("id_card_url <", value, "idCardUrl");
            return (Criteria) this;
        }

        public Criteria andIdCardUrlLessThanOrEqualTo(String value) {
            addCriterion("id_card_url <=", value, "idCardUrl");
            return (Criteria) this;
        }

        public Criteria andIdCardUrlLike(String value) {
            addCriterion("id_card_url like", value, "idCardUrl");
            return (Criteria) this;
        }

        public Criteria andIdCardUrlNotLike(String value) {
            addCriterion("id_card_url not like", value, "idCardUrl");
            return (Criteria) this;
        }

        public Criteria andIdCardUrlIn(List<String> values) {
            addCriterion("id_card_url in", values, "idCardUrl");
            return (Criteria) this;
        }

        public Criteria andIdCardUrlNotIn(List<String> values) {
            addCriterion("id_card_url not in", values, "idCardUrl");
            return (Criteria) this;
        }

        public Criteria andIdCardUrlBetween(String value1, String value2) {
            addCriterion("id_card_url between", value1, value2, "idCardUrl");
            return (Criteria) this;
        }

        public Criteria andIdCardUrlNotBetween(String value1, String value2) {
            addCriterion("id_card_url not between", value1, value2, "idCardUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlIsNull() {
            addCriterion("business_license_url is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlIsNotNull() {
            addCriterion("business_license_url is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlEqualTo(String value) {
            addCriterion("business_license_url =", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlNotEqualTo(String value) {
            addCriterion("business_license_url <>", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlGreaterThan(String value) {
            addCriterion("business_license_url >", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlGreaterThanOrEqualTo(String value) {
            addCriterion("business_license_url >=", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlLessThan(String value) {
            addCriterion("business_license_url <", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlLessThanOrEqualTo(String value) {
            addCriterion("business_license_url <=", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlLike(String value) {
            addCriterion("business_license_url like", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlNotLike(String value) {
            addCriterion("business_license_url not like", value, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlIn(List<String> values) {
            addCriterion("business_license_url in", values, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlNotIn(List<String> values) {
            addCriterion("business_license_url not in", values, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlBetween(String value1, String value2) {
            addCriterion("business_license_url between", value1, value2, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseUrlNotBetween(String value1, String value2) {
            addCriterion("business_license_url not between", value1, value2, "businessLicenseUrl");
            return (Criteria) this;
        }

        public Criteria andMarginIsNull() {
            addCriterion("margin is null");
            return (Criteria) this;
        }

        public Criteria andMarginIsNotNull() {
            addCriterion("margin is not null");
            return (Criteria) this;
        }

        public Criteria andMarginEqualTo(Long value) {
            addCriterion("margin =", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginNotEqualTo(Long value) {
            addCriterion("margin <>", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginGreaterThan(Long value) {
            addCriterion("margin >", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginGreaterThanOrEqualTo(Long value) {
            addCriterion("margin >=", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginLessThan(Long value) {
            addCriterion("margin <", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginLessThanOrEqualTo(Long value) {
            addCriterion("margin <=", value, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginIn(List<Long> values) {
            addCriterion("margin in", values, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginNotIn(List<Long> values) {
            addCriterion("margin not in", values, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginBetween(Long value1, Long value2) {
            addCriterion("margin between", value1, value2, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginNotBetween(Long value1, Long value2) {
            addCriterion("margin not between", value1, value2, "margin");
            return (Criteria) this;
        }

        public Criteria andMarginStatusIsNull() {
            addCriterion("margin_status is null");
            return (Criteria) this;
        }

        public Criteria andMarginStatusIsNotNull() {
            addCriterion("margin_status is not null");
            return (Criteria) this;
        }

        public Criteria andMarginStatusEqualTo(String value) {
            addCriterion("margin_status =", value, "marginStatus");
            return (Criteria) this;
        }

        public Criteria andMarginStatusNotEqualTo(String value) {
            addCriterion("margin_status <>", value, "marginStatus");
            return (Criteria) this;
        }

        public Criteria andMarginStatusGreaterThan(String value) {
            addCriterion("margin_status >", value, "marginStatus");
            return (Criteria) this;
        }

        public Criteria andMarginStatusGreaterThanOrEqualTo(String value) {
            addCriterion("margin_status >=", value, "marginStatus");
            return (Criteria) this;
        }

        public Criteria andMarginStatusLessThan(String value) {
            addCriterion("margin_status <", value, "marginStatus");
            return (Criteria) this;
        }

        public Criteria andMarginStatusLessThanOrEqualTo(String value) {
            addCriterion("margin_status <=", value, "marginStatus");
            return (Criteria) this;
        }

        public Criteria andMarginStatusLike(String value) {
            addCriterion("margin_status like", value, "marginStatus");
            return (Criteria) this;
        }

        public Criteria andMarginStatusNotLike(String value) {
            addCriterion("margin_status not like", value, "marginStatus");
            return (Criteria) this;
        }

        public Criteria andMarginStatusIn(List<String> values) {
            addCriterion("margin_status in", values, "marginStatus");
            return (Criteria) this;
        }

        public Criteria andMarginStatusNotIn(List<String> values) {
            addCriterion("margin_status not in", values, "marginStatus");
            return (Criteria) this;
        }

        public Criteria andMarginStatusBetween(String value1, String value2) {
            addCriterion("margin_status between", value1, value2, "marginStatus");
            return (Criteria) this;
        }

        public Criteria andMarginStatusNotBetween(String value1, String value2) {
            addCriterion("margin_status not between", value1, value2, "marginStatus");
            return (Criteria) this;
        }

        public Criteria andDimensionalityIsNull() {
            addCriterion("dimensionality is null");
            return (Criteria) this;
        }

        public Criteria andDimensionalityIsNotNull() {
            addCriterion("dimensionality is not null");
            return (Criteria) this;
        }

        public Criteria andDimensionalityEqualTo(String value) {
            addCriterion("dimensionality =", value, "dimensionality");
            return (Criteria) this;
        }

        public Criteria andDimensionalityNotEqualTo(String value) {
            addCriterion("dimensionality <>", value, "dimensionality");
            return (Criteria) this;
        }

        public Criteria andDimensionalityGreaterThan(String value) {
            addCriterion("dimensionality >", value, "dimensionality");
            return (Criteria) this;
        }

        public Criteria andDimensionalityGreaterThanOrEqualTo(String value) {
            addCriterion("dimensionality >=", value, "dimensionality");
            return (Criteria) this;
        }

        public Criteria andDimensionalityLessThan(String value) {
            addCriterion("dimensionality <", value, "dimensionality");
            return (Criteria) this;
        }

        public Criteria andDimensionalityLessThanOrEqualTo(String value) {
            addCriterion("dimensionality <=", value, "dimensionality");
            return (Criteria) this;
        }

        public Criteria andDimensionalityLike(String value) {
            addCriterion("dimensionality like", value, "dimensionality");
            return (Criteria) this;
        }

        public Criteria andDimensionalityNotLike(String value) {
            addCriterion("dimensionality not like", value, "dimensionality");
            return (Criteria) this;
        }

        public Criteria andDimensionalityIn(List<String> values) {
            addCriterion("dimensionality in", values, "dimensionality");
            return (Criteria) this;
        }

        public Criteria andDimensionalityNotIn(List<String> values) {
            addCriterion("dimensionality not in", values, "dimensionality");
            return (Criteria) this;
        }

        public Criteria andDimensionalityBetween(String value1, String value2) {
            addCriterion("dimensionality between", value1, value2, "dimensionality");
            return (Criteria) this;
        }

        public Criteria andDimensionalityNotBetween(String value1, String value2) {
            addCriterion("dimensionality not between", value1, value2, "dimensionality");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}