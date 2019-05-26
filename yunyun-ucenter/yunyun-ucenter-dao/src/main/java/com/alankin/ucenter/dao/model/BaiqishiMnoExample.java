package com.alankin.ucenter.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaiqishiMnoExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public BaiqishiMnoExample() {
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

    protected abstract static class GeneratedCriteria implements Serializable {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileTagIsNull() {
            addCriterion("mobile_tag is null");
            return (Criteria) this;
        }

        public Criteria andMobileTagIsNotNull() {
            addCriterion("mobile_tag is not null");
            return (Criteria) this;
        }

        public Criteria andMobileTagEqualTo(String value) {
            addCriterion("mobile_tag =", value, "mobileTag");
            return (Criteria) this;
        }

        public Criteria andMobileTagNotEqualTo(String value) {
            addCriterion("mobile_tag <>", value, "mobileTag");
            return (Criteria) this;
        }

        public Criteria andMobileTagGreaterThan(String value) {
            addCriterion("mobile_tag >", value, "mobileTag");
            return (Criteria) this;
        }

        public Criteria andMobileTagGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_tag >=", value, "mobileTag");
            return (Criteria) this;
        }

        public Criteria andMobileTagLessThan(String value) {
            addCriterion("mobile_tag <", value, "mobileTag");
            return (Criteria) this;
        }

        public Criteria andMobileTagLessThanOrEqualTo(String value) {
            addCriterion("mobile_tag <=", value, "mobileTag");
            return (Criteria) this;
        }

        public Criteria andMobileTagLike(String value) {
            addCriterion("mobile_tag like", value, "mobileTag");
            return (Criteria) this;
        }

        public Criteria andMobileTagNotLike(String value) {
            addCriterion("mobile_tag not like", value, "mobileTag");
            return (Criteria) this;
        }

        public Criteria andMobileTagIn(List<String> values) {
            addCriterion("mobile_tag in", values, "mobileTag");
            return (Criteria) this;
        }

        public Criteria andMobileTagNotIn(List<String> values) {
            addCriterion("mobile_tag not in", values, "mobileTag");
            return (Criteria) this;
        }

        public Criteria andMobileTagBetween(String value1, String value2) {
            addCriterion("mobile_tag between", value1, value2, "mobileTag");
            return (Criteria) this;
        }

        public Criteria andMobileTagNotBetween(String value1, String value2) {
            addCriterion("mobile_tag not between", value1, value2, "mobileTag");
            return (Criteria) this;
        }

        public Criteria andMobileTagTypeIsNull() {
            addCriterion("mobile_tag_type is null");
            return (Criteria) this;
        }

        public Criteria andMobileTagTypeIsNotNull() {
            addCriterion("mobile_tag_type is not null");
            return (Criteria) this;
        }

        public Criteria andMobileTagTypeEqualTo(String value) {
            addCriterion("mobile_tag_type =", value, "mobileTagType");
            return (Criteria) this;
        }

        public Criteria andMobileTagTypeNotEqualTo(String value) {
            addCriterion("mobile_tag_type <>", value, "mobileTagType");
            return (Criteria) this;
        }

        public Criteria andMobileTagTypeGreaterThan(String value) {
            addCriterion("mobile_tag_type >", value, "mobileTagType");
            return (Criteria) this;
        }

        public Criteria andMobileTagTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_tag_type >=", value, "mobileTagType");
            return (Criteria) this;
        }

        public Criteria andMobileTagTypeLessThan(String value) {
            addCriterion("mobile_tag_type <", value, "mobileTagType");
            return (Criteria) this;
        }

        public Criteria andMobileTagTypeLessThanOrEqualTo(String value) {
            addCriterion("mobile_tag_type <=", value, "mobileTagType");
            return (Criteria) this;
        }

        public Criteria andMobileTagTypeLike(String value) {
            addCriterion("mobile_tag_type like", value, "mobileTagType");
            return (Criteria) this;
        }

        public Criteria andMobileTagTypeNotLike(String value) {
            addCriterion("mobile_tag_type not like", value, "mobileTagType");
            return (Criteria) this;
        }

        public Criteria andMobileTagTypeIn(List<String> values) {
            addCriterion("mobile_tag_type in", values, "mobileTagType");
            return (Criteria) this;
        }

        public Criteria andMobileTagTypeNotIn(List<String> values) {
            addCriterion("mobile_tag_type not in", values, "mobileTagType");
            return (Criteria) this;
        }

        public Criteria andMobileTagTypeBetween(String value1, String value2) {
            addCriterion("mobile_tag_type between", value1, value2, "mobileTagType");
            return (Criteria) this;
        }

        public Criteria andMobileTagTypeNotBetween(String value1, String value2) {
            addCriterion("mobile_tag_type not between", value1, value2, "mobileTagType");
            return (Criteria) this;
        }

        public Criteria andFinanceTagIsNull() {
            addCriterion("finance_tag is null");
            return (Criteria) this;
        }

        public Criteria andFinanceTagIsNotNull() {
            addCriterion("finance_tag is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceTagEqualTo(String value) {
            addCriterion("finance_tag =", value, "financeTag");
            return (Criteria) this;
        }

        public Criteria andFinanceTagNotEqualTo(String value) {
            addCriterion("finance_tag <>", value, "financeTag");
            return (Criteria) this;
        }

        public Criteria andFinanceTagGreaterThan(String value) {
            addCriterion("finance_tag >", value, "financeTag");
            return (Criteria) this;
        }

        public Criteria andFinanceTagGreaterThanOrEqualTo(String value) {
            addCriterion("finance_tag >=", value, "financeTag");
            return (Criteria) this;
        }

        public Criteria andFinanceTagLessThan(String value) {
            addCriterion("finance_tag <", value, "financeTag");
            return (Criteria) this;
        }

        public Criteria andFinanceTagLessThanOrEqualTo(String value) {
            addCriterion("finance_tag <=", value, "financeTag");
            return (Criteria) this;
        }

        public Criteria andFinanceTagLike(String value) {
            addCriterion("finance_tag like", value, "financeTag");
            return (Criteria) this;
        }

        public Criteria andFinanceTagNotLike(String value) {
            addCriterion("finance_tag not like", value, "financeTag");
            return (Criteria) this;
        }

        public Criteria andFinanceTagIn(List<String> values) {
            addCriterion("finance_tag in", values, "financeTag");
            return (Criteria) this;
        }

        public Criteria andFinanceTagNotIn(List<String> values) {
            addCriterion("finance_tag not in", values, "financeTag");
            return (Criteria) this;
        }

        public Criteria andFinanceTagBetween(String value1, String value2) {
            addCriterion("finance_tag between", value1, value2, "financeTag");
            return (Criteria) this;
        }

        public Criteria andFinanceTagNotBetween(String value1, String value2) {
            addCriterion("finance_tag not between", value1, value2, "financeTag");
            return (Criteria) this;
        }

        public Criteria andCommonTagTypeIsNull() {
            addCriterion("common_tag_type is null");
            return (Criteria) this;
        }

        public Criteria andCommonTagTypeIsNotNull() {
            addCriterion("common_tag_type is not null");
            return (Criteria) this;
        }

        public Criteria andCommonTagTypeEqualTo(String value) {
            addCriterion("common_tag_type =", value, "commonTagType");
            return (Criteria) this;
        }

        public Criteria andCommonTagTypeNotEqualTo(String value) {
            addCriterion("common_tag_type <>", value, "commonTagType");
            return (Criteria) this;
        }

        public Criteria andCommonTagTypeGreaterThan(String value) {
            addCriterion("common_tag_type >", value, "commonTagType");
            return (Criteria) this;
        }

        public Criteria andCommonTagTypeGreaterThanOrEqualTo(String value) {
            addCriterion("common_tag_type >=", value, "commonTagType");
            return (Criteria) this;
        }

        public Criteria andCommonTagTypeLessThan(String value) {
            addCriterion("common_tag_type <", value, "commonTagType");
            return (Criteria) this;
        }

        public Criteria andCommonTagTypeLessThanOrEqualTo(String value) {
            addCriterion("common_tag_type <=", value, "commonTagType");
            return (Criteria) this;
        }

        public Criteria andCommonTagTypeLike(String value) {
            addCriterion("common_tag_type like", value, "commonTagType");
            return (Criteria) this;
        }

        public Criteria andCommonTagTypeNotLike(String value) {
            addCriterion("common_tag_type not like", value, "commonTagType");
            return (Criteria) this;
        }

        public Criteria andCommonTagTypeIn(List<String> values) {
            addCriterion("common_tag_type in", values, "commonTagType");
            return (Criteria) this;
        }

        public Criteria andCommonTagTypeNotIn(List<String> values) {
            addCriterion("common_tag_type not in", values, "commonTagType");
            return (Criteria) this;
        }

        public Criteria andCommonTagTypeBetween(String value1, String value2) {
            addCriterion("common_tag_type between", value1, value2, "commonTagType");
            return (Criteria) this;
        }

        public Criteria andCommonTagTypeNotBetween(String value1, String value2) {
            addCriterion("common_tag_type not between", value1, value2, "commonTagType");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Long value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Long value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Long value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Long value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Long value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Long> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Long> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Long value1, Long value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Long value1, Long value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Long value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Long value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Long value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Long value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Long value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Long> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Long> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Long value1, Long value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Long value1, Long value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andMonTypeIsNull() {
            addCriterion("mon_type is null");
            return (Criteria) this;
        }

        public Criteria andMonTypeIsNotNull() {
            addCriterion("mon_type is not null");
            return (Criteria) this;
        }

        public Criteria andMonTypeEqualTo(String value) {
            addCriterion("mon_type =", value, "monType");
            return (Criteria) this;
        }

        public Criteria andMonTypeNotEqualTo(String value) {
            addCriterion("mon_type <>", value, "monType");
            return (Criteria) this;
        }

        public Criteria andMonTypeGreaterThan(String value) {
            addCriterion("mon_type >", value, "monType");
            return (Criteria) this;
        }

        public Criteria andMonTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mon_type >=", value, "monType");
            return (Criteria) this;
        }

        public Criteria andMonTypeLessThan(String value) {
            addCriterion("mon_type <", value, "monType");
            return (Criteria) this;
        }

        public Criteria andMonTypeLessThanOrEqualTo(String value) {
            addCriterion("mon_type <=", value, "monType");
            return (Criteria) this;
        }

        public Criteria andMonTypeLike(String value) {
            addCriterion("mon_type like", value, "monType");
            return (Criteria) this;
        }

        public Criteria andMonTypeNotLike(String value) {
            addCriterion("mon_type not like", value, "monType");
            return (Criteria) this;
        }

        public Criteria andMonTypeIn(List<String> values) {
            addCriterion("mon_type in", values, "monType");
            return (Criteria) this;
        }

        public Criteria andMonTypeNotIn(List<String> values) {
            addCriterion("mon_type not in", values, "monType");
            return (Criteria) this;
        }

        public Criteria andMonTypeBetween(String value1, String value2) {
            addCriterion("mon_type between", value1, value2, "monType");
            return (Criteria) this;
        }

        public Criteria andMonTypeNotBetween(String value1, String value2) {
            addCriterion("mon_type not between", value1, value2, "monType");
            return (Criteria) this;
        }

        public Criteria andBelongToIsNull() {
            addCriterion("belong_to is null");
            return (Criteria) this;
        }

        public Criteria andBelongToIsNotNull() {
            addCriterion("belong_to is not null");
            return (Criteria) this;
        }

        public Criteria andBelongToEqualTo(String value) {
            addCriterion("belong_to =", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToNotEqualTo(String value) {
            addCriterion("belong_to <>", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToGreaterThan(String value) {
            addCriterion("belong_to >", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToGreaterThanOrEqualTo(String value) {
            addCriterion("belong_to >=", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToLessThan(String value) {
            addCriterion("belong_to <", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToLessThanOrEqualTo(String value) {
            addCriterion("belong_to <=", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToLike(String value) {
            addCriterion("belong_to like", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToNotLike(String value) {
            addCriterion("belong_to not like", value, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToIn(List<String> values) {
            addCriterion("belong_to in", values, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToNotIn(List<String> values) {
            addCriterion("belong_to not in", values, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToBetween(String value1, String value2) {
            addCriterion("belong_to between", value1, value2, "belongTo");
            return (Criteria) this;
        }

        public Criteria andBelongToNotBetween(String value1, String value2) {
            addCriterion("belong_to not between", value1, value2, "belongTo");
            return (Criteria) this;
        }

        public Criteria andConnectCountIsNull() {
            addCriterion("connect_count is null");
            return (Criteria) this;
        }

        public Criteria andConnectCountIsNotNull() {
            addCriterion("connect_count is not null");
            return (Criteria) this;
        }

        public Criteria andConnectCountEqualTo(Integer value) {
            addCriterion("connect_count =", value, "connectCount");
            return (Criteria) this;
        }

        public Criteria andConnectCountNotEqualTo(Integer value) {
            addCriterion("connect_count <>", value, "connectCount");
            return (Criteria) this;
        }

        public Criteria andConnectCountGreaterThan(Integer value) {
            addCriterion("connect_count >", value, "connectCount");
            return (Criteria) this;
        }

        public Criteria andConnectCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("connect_count >=", value, "connectCount");
            return (Criteria) this;
        }

        public Criteria andConnectCountLessThan(Integer value) {
            addCriterion("connect_count <", value, "connectCount");
            return (Criteria) this;
        }

        public Criteria andConnectCountLessThanOrEqualTo(Integer value) {
            addCriterion("connect_count <=", value, "connectCount");
            return (Criteria) this;
        }

        public Criteria andConnectCountIn(List<Integer> values) {
            addCriterion("connect_count in", values, "connectCount");
            return (Criteria) this;
        }

        public Criteria andConnectCountNotIn(List<Integer> values) {
            addCriterion("connect_count not in", values, "connectCount");
            return (Criteria) this;
        }

        public Criteria andConnectCountBetween(Integer value1, Integer value2) {
            addCriterion("connect_count between", value1, value2, "connectCount");
            return (Criteria) this;
        }

        public Criteria andConnectCountNotBetween(Integer value1, Integer value2) {
            addCriterion("connect_count not between", value1, value2, "connectCount");
            return (Criteria) this;
        }

        public Criteria andConnectTimeIsNull() {
            addCriterion("connect_time is null");
            return (Criteria) this;
        }

        public Criteria andConnectTimeIsNotNull() {
            addCriterion("connect_time is not null");
            return (Criteria) this;
        }

        public Criteria andConnectTimeEqualTo(Integer value) {
            addCriterion("connect_time =", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeNotEqualTo(Integer value) {
            addCriterion("connect_time <>", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeGreaterThan(Integer value) {
            addCriterion("connect_time >", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("connect_time >=", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeLessThan(Integer value) {
            addCriterion("connect_time <", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeLessThanOrEqualTo(Integer value) {
            addCriterion("connect_time <=", value, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeIn(List<Integer> values) {
            addCriterion("connect_time in", values, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeNotIn(List<Integer> values) {
            addCriterion("connect_time not in", values, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeBetween(Integer value1, Integer value2) {
            addCriterion("connect_time between", value1, value2, "connectTime");
            return (Criteria) this;
        }

        public Criteria andConnectTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("connect_time not between", value1, value2, "connectTime");
            return (Criteria) this;
        }

        public Criteria andOriginatingCallCountIsNull() {
            addCriterion("originating_call_count is null");
            return (Criteria) this;
        }

        public Criteria andOriginatingCallCountIsNotNull() {
            addCriterion("originating_call_count is not null");
            return (Criteria) this;
        }

        public Criteria andOriginatingCallCountEqualTo(Integer value) {
            addCriterion("originating_call_count =", value, "originatingCallCount");
            return (Criteria) this;
        }

        public Criteria andOriginatingCallCountNotEqualTo(Integer value) {
            addCriterion("originating_call_count <>", value, "originatingCallCount");
            return (Criteria) this;
        }

        public Criteria andOriginatingCallCountGreaterThan(Integer value) {
            addCriterion("originating_call_count >", value, "originatingCallCount");
            return (Criteria) this;
        }

        public Criteria andOriginatingCallCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("originating_call_count >=", value, "originatingCallCount");
            return (Criteria) this;
        }

        public Criteria andOriginatingCallCountLessThan(Integer value) {
            addCriterion("originating_call_count <", value, "originatingCallCount");
            return (Criteria) this;
        }

        public Criteria andOriginatingCallCountLessThanOrEqualTo(Integer value) {
            addCriterion("originating_call_count <=", value, "originatingCallCount");
            return (Criteria) this;
        }

        public Criteria andOriginatingCallCountIn(List<Integer> values) {
            addCriterion("originating_call_count in", values, "originatingCallCount");
            return (Criteria) this;
        }

        public Criteria andOriginatingCallCountNotIn(List<Integer> values) {
            addCriterion("originating_call_count not in", values, "originatingCallCount");
            return (Criteria) this;
        }

        public Criteria andOriginatingCallCountBetween(Integer value1, Integer value2) {
            addCriterion("originating_call_count between", value1, value2, "originatingCallCount");
            return (Criteria) this;
        }

        public Criteria andOriginatingCallCountNotBetween(Integer value1, Integer value2) {
            addCriterion("originating_call_count not between", value1, value2, "originatingCallCount");
            return (Criteria) this;
        }

        public Criteria andOriginatingTimeIsNull() {
            addCriterion("originating_time is null");
            return (Criteria) this;
        }

        public Criteria andOriginatingTimeIsNotNull() {
            addCriterion("originating_time is not null");
            return (Criteria) this;
        }

        public Criteria andOriginatingTimeEqualTo(Integer value) {
            addCriterion("originating_time =", value, "originatingTime");
            return (Criteria) this;
        }

        public Criteria andOriginatingTimeNotEqualTo(Integer value) {
            addCriterion("originating_time <>", value, "originatingTime");
            return (Criteria) this;
        }

        public Criteria andOriginatingTimeGreaterThan(Integer value) {
            addCriterion("originating_time >", value, "originatingTime");
            return (Criteria) this;
        }

        public Criteria andOriginatingTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("originating_time >=", value, "originatingTime");
            return (Criteria) this;
        }

        public Criteria andOriginatingTimeLessThan(Integer value) {
            addCriterion("originating_time <", value, "originatingTime");
            return (Criteria) this;
        }

        public Criteria andOriginatingTimeLessThanOrEqualTo(Integer value) {
            addCriterion("originating_time <=", value, "originatingTime");
            return (Criteria) this;
        }

        public Criteria andOriginatingTimeIn(List<Integer> values) {
            addCriterion("originating_time in", values, "originatingTime");
            return (Criteria) this;
        }

        public Criteria andOriginatingTimeNotIn(List<Integer> values) {
            addCriterion("originating_time not in", values, "originatingTime");
            return (Criteria) this;
        }

        public Criteria andOriginatingTimeBetween(Integer value1, Integer value2) {
            addCriterion("originating_time between", value1, value2, "originatingTime");
            return (Criteria) this;
        }

        public Criteria andOriginatingTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("originating_time not between", value1, value2, "originatingTime");
            return (Criteria) this;
        }

        public Criteria andTerminatingCallCountIsNull() {
            addCriterion("terminating_call_count is null");
            return (Criteria) this;
        }

        public Criteria andTerminatingCallCountIsNotNull() {
            addCriterion("terminating_call_count is not null");
            return (Criteria) this;
        }

        public Criteria andTerminatingCallCountEqualTo(Integer value) {
            addCriterion("terminating_call_count =", value, "terminatingCallCount");
            return (Criteria) this;
        }

        public Criteria andTerminatingCallCountNotEqualTo(Integer value) {
            addCriterion("terminating_call_count <>", value, "terminatingCallCount");
            return (Criteria) this;
        }

        public Criteria andTerminatingCallCountGreaterThan(Integer value) {
            addCriterion("terminating_call_count >", value, "terminatingCallCount");
            return (Criteria) this;
        }

        public Criteria andTerminatingCallCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("terminating_call_count >=", value, "terminatingCallCount");
            return (Criteria) this;
        }

        public Criteria andTerminatingCallCountLessThan(Integer value) {
            addCriterion("terminating_call_count <", value, "terminatingCallCount");
            return (Criteria) this;
        }

        public Criteria andTerminatingCallCountLessThanOrEqualTo(Integer value) {
            addCriterion("terminating_call_count <=", value, "terminatingCallCount");
            return (Criteria) this;
        }

        public Criteria andTerminatingCallCountIn(List<Integer> values) {
            addCriterion("terminating_call_count in", values, "terminatingCallCount");
            return (Criteria) this;
        }

        public Criteria andTerminatingCallCountNotIn(List<Integer> values) {
            addCriterion("terminating_call_count not in", values, "terminatingCallCount");
            return (Criteria) this;
        }

        public Criteria andTerminatingCallCountBetween(Integer value1, Integer value2) {
            addCriterion("terminating_call_count between", value1, value2, "terminatingCallCount");
            return (Criteria) this;
        }

        public Criteria andTerminatingCallCountNotBetween(Integer value1, Integer value2) {
            addCriterion("terminating_call_count not between", value1, value2, "terminatingCallCount");
            return (Criteria) this;
        }

        public Criteria andTerminatingTimeIsNull() {
            addCriterion("terminating_time is null");
            return (Criteria) this;
        }

        public Criteria andTerminatingTimeIsNotNull() {
            addCriterion("terminating_time is not null");
            return (Criteria) this;
        }

        public Criteria andTerminatingTimeEqualTo(Integer value) {
            addCriterion("terminating_time =", value, "terminatingTime");
            return (Criteria) this;
        }

        public Criteria andTerminatingTimeNotEqualTo(Integer value) {
            addCriterion("terminating_time <>", value, "terminatingTime");
            return (Criteria) this;
        }

        public Criteria andTerminatingTimeGreaterThan(Integer value) {
            addCriterion("terminating_time >", value, "terminatingTime");
            return (Criteria) this;
        }

        public Criteria andTerminatingTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("terminating_time >=", value, "terminatingTime");
            return (Criteria) this;
        }

        public Criteria andTerminatingTimeLessThan(Integer value) {
            addCriterion("terminating_time <", value, "terminatingTime");
            return (Criteria) this;
        }

        public Criteria andTerminatingTimeLessThanOrEqualTo(Integer value) {
            addCriterion("terminating_time <=", value, "terminatingTime");
            return (Criteria) this;
        }

        public Criteria andTerminatingTimeIn(List<Integer> values) {
            addCriterion("terminating_time in", values, "terminatingTime");
            return (Criteria) this;
        }

        public Criteria andTerminatingTimeNotIn(List<Integer> values) {
            addCriterion("terminating_time not in", values, "terminatingTime");
            return (Criteria) this;
        }

        public Criteria andTerminatingTimeBetween(Integer value1, Integer value2) {
            addCriterion("terminating_time between", value1, value2, "terminatingTime");
            return (Criteria) this;
        }

        public Criteria andTerminatingTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("terminating_time not between", value1, value2, "terminatingTime");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallCountIsNull() {
            addCriterion("other_type_call_count is null");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallCountIsNotNull() {
            addCriterion("other_type_call_count is not null");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallCountEqualTo(Integer value) {
            addCriterion("other_type_call_count =", value, "otherTypeCallCount");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallCountNotEqualTo(Integer value) {
            addCriterion("other_type_call_count <>", value, "otherTypeCallCount");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallCountGreaterThan(Integer value) {
            addCriterion("other_type_call_count >", value, "otherTypeCallCount");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("other_type_call_count >=", value, "otherTypeCallCount");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallCountLessThan(Integer value) {
            addCriterion("other_type_call_count <", value, "otherTypeCallCount");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallCountLessThanOrEqualTo(Integer value) {
            addCriterion("other_type_call_count <=", value, "otherTypeCallCount");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallCountIn(List<Integer> values) {
            addCriterion("other_type_call_count in", values, "otherTypeCallCount");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallCountNotIn(List<Integer> values) {
            addCriterion("other_type_call_count not in", values, "otherTypeCallCount");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallCountBetween(Integer value1, Integer value2) {
            addCriterion("other_type_call_count between", value1, value2, "otherTypeCallCount");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallCountNotBetween(Integer value1, Integer value2) {
            addCriterion("other_type_call_count not between", value1, value2, "otherTypeCallCount");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallTimeIsNull() {
            addCriterion("other_type_call_time is null");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallTimeIsNotNull() {
            addCriterion("other_type_call_time is not null");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallTimeEqualTo(Integer value) {
            addCriterion("other_type_call_time =", value, "otherTypeCallTime");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallTimeNotEqualTo(Integer value) {
            addCriterion("other_type_call_time <>", value, "otherTypeCallTime");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallTimeGreaterThan(Integer value) {
            addCriterion("other_type_call_time >", value, "otherTypeCallTime");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("other_type_call_time >=", value, "otherTypeCallTime");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallTimeLessThan(Integer value) {
            addCriterion("other_type_call_time <", value, "otherTypeCallTime");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallTimeLessThanOrEqualTo(Integer value) {
            addCriterion("other_type_call_time <=", value, "otherTypeCallTime");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallTimeIn(List<Integer> values) {
            addCriterion("other_type_call_time in", values, "otherTypeCallTime");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallTimeNotIn(List<Integer> values) {
            addCriterion("other_type_call_time not in", values, "otherTypeCallTime");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallTimeBetween(Integer value1, Integer value2) {
            addCriterion("other_type_call_time between", value1, value2, "otherTypeCallTime");
            return (Criteria) this;
        }

        public Criteria andOtherTypeCallTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("other_type_call_time not between", value1, value2, "otherTypeCallTime");
            return (Criteria) this;
        }

        public Criteria andSendSmsCountIsNull() {
            addCriterion("send_sms_count is null");
            return (Criteria) this;
        }

        public Criteria andSendSmsCountIsNotNull() {
            addCriterion("send_sms_count is not null");
            return (Criteria) this;
        }

        public Criteria andSendSmsCountEqualTo(Integer value) {
            addCriterion("send_sms_count =", value, "sendSmsCount");
            return (Criteria) this;
        }

        public Criteria andSendSmsCountNotEqualTo(Integer value) {
            addCriterion("send_sms_count <>", value, "sendSmsCount");
            return (Criteria) this;
        }

        public Criteria andSendSmsCountGreaterThan(Integer value) {
            addCriterion("send_sms_count >", value, "sendSmsCount");
            return (Criteria) this;
        }

        public Criteria andSendSmsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_sms_count >=", value, "sendSmsCount");
            return (Criteria) this;
        }

        public Criteria andSendSmsCountLessThan(Integer value) {
            addCriterion("send_sms_count <", value, "sendSmsCount");
            return (Criteria) this;
        }

        public Criteria andSendSmsCountLessThanOrEqualTo(Integer value) {
            addCriterion("send_sms_count <=", value, "sendSmsCount");
            return (Criteria) this;
        }

        public Criteria andSendSmsCountIn(List<Integer> values) {
            addCriterion("send_sms_count in", values, "sendSmsCount");
            return (Criteria) this;
        }

        public Criteria andSendSmsCountNotIn(List<Integer> values) {
            addCriterion("send_sms_count not in", values, "sendSmsCount");
            return (Criteria) this;
        }

        public Criteria andSendSmsCountBetween(Integer value1, Integer value2) {
            addCriterion("send_sms_count between", value1, value2, "sendSmsCount");
            return (Criteria) this;
        }

        public Criteria andSendSmsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("send_sms_count not between", value1, value2, "sendSmsCount");
            return (Criteria) this;
        }

        public Criteria andReceiveSmsCountIsNull() {
            addCriterion("receive_sms_count is null");
            return (Criteria) this;
        }

        public Criteria andReceiveSmsCountIsNotNull() {
            addCriterion("receive_sms_count is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveSmsCountEqualTo(Integer value) {
            addCriterion("receive_sms_count =", value, "receiveSmsCount");
            return (Criteria) this;
        }

        public Criteria andReceiveSmsCountNotEqualTo(Integer value) {
            addCriterion("receive_sms_count <>", value, "receiveSmsCount");
            return (Criteria) this;
        }

        public Criteria andReceiveSmsCountGreaterThan(Integer value) {
            addCriterion("receive_sms_count >", value, "receiveSmsCount");
            return (Criteria) this;
        }

        public Criteria andReceiveSmsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("receive_sms_count >=", value, "receiveSmsCount");
            return (Criteria) this;
        }

        public Criteria andReceiveSmsCountLessThan(Integer value) {
            addCriterion("receive_sms_count <", value, "receiveSmsCount");
            return (Criteria) this;
        }

        public Criteria andReceiveSmsCountLessThanOrEqualTo(Integer value) {
            addCriterion("receive_sms_count <=", value, "receiveSmsCount");
            return (Criteria) this;
        }

        public Criteria andReceiveSmsCountIn(List<Integer> values) {
            addCriterion("receive_sms_count in", values, "receiveSmsCount");
            return (Criteria) this;
        }

        public Criteria andReceiveSmsCountNotIn(List<Integer> values) {
            addCriterion("receive_sms_count not in", values, "receiveSmsCount");
            return (Criteria) this;
        }

        public Criteria andReceiveSmsCountBetween(Integer value1, Integer value2) {
            addCriterion("receive_sms_count between", value1, value2, "receiveSmsCount");
            return (Criteria) this;
        }

        public Criteria andReceiveSmsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("receive_sms_count not between", value1, value2, "receiveSmsCount");
            return (Criteria) this;
        }

        public Criteria andDaysTypeIsNull() {
            addCriterion("days_type is null");
            return (Criteria) this;
        }

        public Criteria andDaysTypeIsNotNull() {
            addCriterion("days_type is not null");
            return (Criteria) this;
        }

        public Criteria andDaysTypeEqualTo(Byte value) {
            addCriterion("days_type =", value, "daysType");
            return (Criteria) this;
        }

        public Criteria andDaysTypeNotEqualTo(Byte value) {
            addCriterion("days_type <>", value, "daysType");
            return (Criteria) this;
        }

        public Criteria andDaysTypeGreaterThan(Byte value) {
            addCriterion("days_type >", value, "daysType");
            return (Criteria) this;
        }

        public Criteria andDaysTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("days_type >=", value, "daysType");
            return (Criteria) this;
        }

        public Criteria andDaysTypeLessThan(Byte value) {
            addCriterion("days_type <", value, "daysType");
            return (Criteria) this;
        }

        public Criteria andDaysTypeLessThanOrEqualTo(Byte value) {
            addCriterion("days_type <=", value, "daysType");
            return (Criteria) this;
        }

        public Criteria andDaysTypeIn(List<Byte> values) {
            addCriterion("days_type in", values, "daysType");
            return (Criteria) this;
        }

        public Criteria andDaysTypeNotIn(List<Byte> values) {
            addCriterion("days_type not in", values, "daysType");
            return (Criteria) this;
        }

        public Criteria andDaysTypeBetween(Byte value1, Byte value2) {
            addCriterion("days_type between", value1, value2, "daysType");
            return (Criteria) this;
        }

        public Criteria andDaysTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("days_type not between", value1, value2, "daysType");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
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