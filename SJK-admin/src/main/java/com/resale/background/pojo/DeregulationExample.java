package com.resale.background.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeregulationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeregulationExample() {
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

        public Criteria andMerchatNameIsNull() {
            addCriterion("merchat_name is null");
            return (Criteria) this;
        }

        public Criteria andMerchatNameIsNotNull() {
            addCriterion("merchat_name is not null");
            return (Criteria) this;
        }

        public Criteria andMerchatNameEqualTo(String value) {
            addCriterion("merchat_name =", value, "merchatName");
            return (Criteria) this;
        }

        public Criteria andMerchatNameNotEqualTo(String value) {
            addCriterion("merchat_name <>", value, "merchatName");
            return (Criteria) this;
        }

        public Criteria andMerchatNameGreaterThan(String value) {
            addCriterion("merchat_name >", value, "merchatName");
            return (Criteria) this;
        }

        public Criteria andMerchatNameGreaterThanOrEqualTo(String value) {
            addCriterion("merchat_name >=", value, "merchatName");
            return (Criteria) this;
        }

        public Criteria andMerchatNameLessThan(String value) {
            addCriterion("merchat_name <", value, "merchatName");
            return (Criteria) this;
        }

        public Criteria andMerchatNameLessThanOrEqualTo(String value) {
            addCriterion("merchat_name <=", value, "merchatName");
            return (Criteria) this;
        }

        public Criteria andMerchatNameLike(String value) {
            addCriterion("merchat_name like", value, "merchatName");
            return (Criteria) this;
        }

        public Criteria andMerchatNameNotLike(String value) {
            addCriterion("merchat_name not like", value, "merchatName");
            return (Criteria) this;
        }

        public Criteria andMerchatNameIn(List<String> values) {
            addCriterion("merchat_name in", values, "merchatName");
            return (Criteria) this;
        }

        public Criteria andMerchatNameNotIn(List<String> values) {
            addCriterion("merchat_name not in", values, "merchatName");
            return (Criteria) this;
        }

        public Criteria andMerchatNameBetween(String value1, String value2) {
            addCriterion("merchat_name between", value1, value2, "merchatName");
            return (Criteria) this;
        }

        public Criteria andMerchatNameNotBetween(String value1, String value2) {
            addCriterion("merchat_name not between", value1, value2, "merchatName");
            return (Criteria) this;
        }

        public Criteria andMerchatCodeIsNull() {
            addCriterion("merchat_code is null");
            return (Criteria) this;
        }

        public Criteria andMerchatCodeIsNotNull() {
            addCriterion("merchat_code is not null");
            return (Criteria) this;
        }

        public Criteria andMerchatCodeEqualTo(String value) {
            addCriterion("merchat_code =", value, "merchatCode");
            return (Criteria) this;
        }

        public Criteria andMerchatCodeNotEqualTo(String value) {
            addCriterion("merchat_code <>", value, "merchatCode");
            return (Criteria) this;
        }

        public Criteria andMerchatCodeGreaterThan(String value) {
            addCriterion("merchat_code >", value, "merchatCode");
            return (Criteria) this;
        }

        public Criteria andMerchatCodeGreaterThanOrEqualTo(String value) {
            addCriterion("merchat_code >=", value, "merchatCode");
            return (Criteria) this;
        }

        public Criteria andMerchatCodeLessThan(String value) {
            addCriterion("merchat_code <", value, "merchatCode");
            return (Criteria) this;
        }

        public Criteria andMerchatCodeLessThanOrEqualTo(String value) {
            addCriterion("merchat_code <=", value, "merchatCode");
            return (Criteria) this;
        }

        public Criteria andMerchatCodeLike(String value) {
            addCriterion("merchat_code like", value, "merchatCode");
            return (Criteria) this;
        }

        public Criteria andMerchatCodeNotLike(String value) {
            addCriterion("merchat_code not like", value, "merchatCode");
            return (Criteria) this;
        }

        public Criteria andMerchatCodeIn(List<String> values) {
            addCriterion("merchat_code in", values, "merchatCode");
            return (Criteria) this;
        }

        public Criteria andMerchatCodeNotIn(List<String> values) {
            addCriterion("merchat_code not in", values, "merchatCode");
            return (Criteria) this;
        }

        public Criteria andMerchatCodeBetween(String value1, String value2) {
            addCriterion("merchat_code between", value1, value2, "merchatCode");
            return (Criteria) this;
        }

        public Criteria andMerchatCodeNotBetween(String value1, String value2) {
            addCriterion("merchat_code not between", value1, value2, "merchatCode");
            return (Criteria) this;
        }

        public Criteria andDetailIsNull() {
            addCriterion("detail is null");
            return (Criteria) this;
        }

        public Criteria andDetailIsNotNull() {
            addCriterion("detail is not null");
            return (Criteria) this;
        }

        public Criteria andDetailEqualTo(String value) {
            addCriterion("detail =", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotEqualTo(String value) {
            addCriterion("detail <>", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThan(String value) {
            addCriterion("detail >", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailGreaterThanOrEqualTo(String value) {
            addCriterion("detail >=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThan(String value) {
            addCriterion("detail <", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLessThanOrEqualTo(String value) {
            addCriterion("detail <=", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailLike(String value) {
            addCriterion("detail like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotLike(String value) {
            addCriterion("detail not like", value, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailIn(List<String> values) {
            addCriterion("detail in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotIn(List<String> values) {
            addCriterion("detail not in", values, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailBetween(String value1, String value2) {
            addCriterion("detail between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andDetailNotBetween(String value1, String value2) {
            addCriterion("detail not between", value1, value2, "detail");
            return (Criteria) this;
        }

        public Criteria andInformerPhoneIsNull() {
            addCriterion("informer_phone is null");
            return (Criteria) this;
        }

        public Criteria andInformerPhoneIsNotNull() {
            addCriterion("informer_phone is not null");
            return (Criteria) this;
        }

        public Criteria andInformerPhoneEqualTo(String value) {
            addCriterion("informer_phone =", value, "informerPhone");
            return (Criteria) this;
        }

        public Criteria andInformerPhoneNotEqualTo(String value) {
            addCriterion("informer_phone <>", value, "informerPhone");
            return (Criteria) this;
        }

        public Criteria andInformerPhoneGreaterThan(String value) {
            addCriterion("informer_phone >", value, "informerPhone");
            return (Criteria) this;
        }

        public Criteria andInformerPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("informer_phone >=", value, "informerPhone");
            return (Criteria) this;
        }

        public Criteria andInformerPhoneLessThan(String value) {
            addCriterion("informer_phone <", value, "informerPhone");
            return (Criteria) this;
        }

        public Criteria andInformerPhoneLessThanOrEqualTo(String value) {
            addCriterion("informer_phone <=", value, "informerPhone");
            return (Criteria) this;
        }

        public Criteria andInformerPhoneLike(String value) {
            addCriterion("informer_phone like", value, "informerPhone");
            return (Criteria) this;
        }

        public Criteria andInformerPhoneNotLike(String value) {
            addCriterion("informer_phone not like", value, "informerPhone");
            return (Criteria) this;
        }

        public Criteria andInformerPhoneIn(List<String> values) {
            addCriterion("informer_phone in", values, "informerPhone");
            return (Criteria) this;
        }

        public Criteria andInformerPhoneNotIn(List<String> values) {
            addCriterion("informer_phone not in", values, "informerPhone");
            return (Criteria) this;
        }

        public Criteria andInformerPhoneBetween(String value1, String value2) {
            addCriterion("informer_phone between", value1, value2, "informerPhone");
            return (Criteria) this;
        }

        public Criteria andInformerPhoneNotBetween(String value1, String value2) {
            addCriterion("informer_phone not between", value1, value2, "informerPhone");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAmountDeductedIsNull() {
            addCriterion("amount_deducted is null");
            return (Criteria) this;
        }

        public Criteria andAmountDeductedIsNotNull() {
            addCriterion("amount_deducted is not null");
            return (Criteria) this;
        }

        public Criteria andAmountDeductedEqualTo(BigDecimal value) {
            addCriterion("amount_deducted =", value, "amountDeducted");
            return (Criteria) this;
        }

        public Criteria andAmountDeductedNotEqualTo(BigDecimal value) {
            addCriterion("amount_deducted <>", value, "amountDeducted");
            return (Criteria) this;
        }

        public Criteria andAmountDeductedGreaterThan(BigDecimal value) {
            addCriterion("amount_deducted >", value, "amountDeducted");
            return (Criteria) this;
        }

        public Criteria andAmountDeductedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_deducted >=", value, "amountDeducted");
            return (Criteria) this;
        }

        public Criteria andAmountDeductedLessThan(BigDecimal value) {
            addCriterion("amount_deducted <", value, "amountDeducted");
            return (Criteria) this;
        }

        public Criteria andAmountDeductedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount_deducted <=", value, "amountDeducted");
            return (Criteria) this;
        }

        public Criteria andAmountDeductedIn(List<BigDecimal> values) {
            addCriterion("amount_deducted in", values, "amountDeducted");
            return (Criteria) this;
        }

        public Criteria andAmountDeductedNotIn(List<BigDecimal> values) {
            addCriterion("amount_deducted not in", values, "amountDeducted");
            return (Criteria) this;
        }

        public Criteria andAmountDeductedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_deducted between", value1, value2, "amountDeducted");
            return (Criteria) this;
        }

        public Criteria andAmountDeductedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount_deducted not between", value1, value2, "amountDeducted");
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

        public Criteria andCreatorIdIsNull() {
            addCriterion("creator_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(Integer value) {
            addCriterion("creator_id =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(Integer value) {
            addCriterion("creator_id <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(Integer value) {
            addCriterion("creator_id >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("creator_id >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(Integer value) {
            addCriterion("creator_id <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(Integer value) {
            addCriterion("creator_id <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<Integer> values) {
            addCriterion("creator_id in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<Integer> values) {
            addCriterion("creator_id not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(Integer value1, Integer value2) {
            addCriterion("creator_id between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("creator_id not between", value1, value2, "creatorId");
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