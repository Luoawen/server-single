package com.alankin.ucenter.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoanReceiptExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public LoanReceiptExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andApplyOrderUidIsNull() {
            addCriterion("apply_order_uid is null");
            return (Criteria) this;
        }

        public Criteria andApplyOrderUidIsNotNull() {
            addCriterion("apply_order_uid is not null");
            return (Criteria) this;
        }

        public Criteria andApplyOrderUidEqualTo(Long value) {
            addCriterion("apply_order_uid =", value, "applyOrderUid");
            return (Criteria) this;
        }

        public Criteria andApplyOrderUidNotEqualTo(Long value) {
            addCriterion("apply_order_uid <>", value, "applyOrderUid");
            return (Criteria) this;
        }

        public Criteria andApplyOrderUidGreaterThan(Long value) {
            addCriterion("apply_order_uid >", value, "applyOrderUid");
            return (Criteria) this;
        }

        public Criteria andApplyOrderUidGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_order_uid >=", value, "applyOrderUid");
            return (Criteria) this;
        }

        public Criteria andApplyOrderUidLessThan(Long value) {
            addCriterion("apply_order_uid <", value, "applyOrderUid");
            return (Criteria) this;
        }

        public Criteria andApplyOrderUidLessThanOrEqualTo(Long value) {
            addCriterion("apply_order_uid <=", value, "applyOrderUid");
            return (Criteria) this;
        }

        public Criteria andApplyOrderUidIn(List<Long> values) {
            addCriterion("apply_order_uid in", values, "applyOrderUid");
            return (Criteria) this;
        }

        public Criteria andApplyOrderUidNotIn(List<Long> values) {
            addCriterion("apply_order_uid not in", values, "applyOrderUid");
            return (Criteria) this;
        }

        public Criteria andApplyOrderUidBetween(Long value1, Long value2) {
            addCriterion("apply_order_uid between", value1, value2, "applyOrderUid");
            return (Criteria) this;
        }

        public Criteria andApplyOrderUidNotBetween(Long value1, Long value2) {
            addCriterion("apply_order_uid not between", value1, value2, "applyOrderUid");
            return (Criteria) this;
        }

        public Criteria andBrowerIdIsNull() {
            addCriterion("brower_id is null");
            return (Criteria) this;
        }

        public Criteria andBrowerIdIsNotNull() {
            addCriterion("brower_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrowerIdEqualTo(Long value) {
            addCriterion("brower_id =", value, "browerId");
            return (Criteria) this;
        }

        public Criteria andBrowerIdNotEqualTo(Long value) {
            addCriterion("brower_id <>", value, "browerId");
            return (Criteria) this;
        }

        public Criteria andBrowerIdGreaterThan(Long value) {
            addCriterion("brower_id >", value, "browerId");
            return (Criteria) this;
        }

        public Criteria andBrowerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("brower_id >=", value, "browerId");
            return (Criteria) this;
        }

        public Criteria andBrowerIdLessThan(Long value) {
            addCriterion("brower_id <", value, "browerId");
            return (Criteria) this;
        }

        public Criteria andBrowerIdLessThanOrEqualTo(Long value) {
            addCriterion("brower_id <=", value, "browerId");
            return (Criteria) this;
        }

        public Criteria andBrowerIdIn(List<Long> values) {
            addCriterion("brower_id in", values, "browerId");
            return (Criteria) this;
        }

        public Criteria andBrowerIdNotIn(List<Long> values) {
            addCriterion("brower_id not in", values, "browerId");
            return (Criteria) this;
        }

        public Criteria andBrowerIdBetween(Long value1, Long value2) {
            addCriterion("brower_id between", value1, value2, "browerId");
            return (Criteria) this;
        }

        public Criteria andBrowerIdNotBetween(Long value1, Long value2) {
            addCriterion("brower_id not between", value1, value2, "browerId");
            return (Criteria) this;
        }

        public Criteria andBrowerTimeIsNull() {
            addCriterion("brower_time is null");
            return (Criteria) this;
        }

        public Criteria andBrowerTimeIsNotNull() {
            addCriterion("brower_time is not null");
            return (Criteria) this;
        }

        public Criteria andBrowerTimeEqualTo(Integer value) {
            addCriterion("brower_time =", value, "browerTime");
            return (Criteria) this;
        }

        public Criteria andBrowerTimeNotEqualTo(Integer value) {
            addCriterion("brower_time <>", value, "browerTime");
            return (Criteria) this;
        }

        public Criteria andBrowerTimeGreaterThan(Integer value) {
            addCriterion("brower_time >", value, "browerTime");
            return (Criteria) this;
        }

        public Criteria andBrowerTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("brower_time >=", value, "browerTime");
            return (Criteria) this;
        }

        public Criteria andBrowerTimeLessThan(Integer value) {
            addCriterion("brower_time <", value, "browerTime");
            return (Criteria) this;
        }

        public Criteria andBrowerTimeLessThanOrEqualTo(Integer value) {
            addCriterion("brower_time <=", value, "browerTime");
            return (Criteria) this;
        }

        public Criteria andBrowerTimeIn(List<Integer> values) {
            addCriterion("brower_time in", values, "browerTime");
            return (Criteria) this;
        }

        public Criteria andBrowerTimeNotIn(List<Integer> values) {
            addCriterion("brower_time not in", values, "browerTime");
            return (Criteria) this;
        }

        public Criteria andBrowerTimeBetween(Integer value1, Integer value2) {
            addCriterion("brower_time between", value1, value2, "browerTime");
            return (Criteria) this;
        }

        public Criteria andBrowerTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("brower_time not between", value1, value2, "browerTime");
            return (Criteria) this;
        }

        public Criteria andRepayTimeIsNull() {
            addCriterion("repay_time is null");
            return (Criteria) this;
        }

        public Criteria andRepayTimeIsNotNull() {
            addCriterion("repay_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepayTimeEqualTo(Integer value) {
            addCriterion("repay_time =", value, "repayTime");
            return (Criteria) this;
        }

        public Criteria andRepayTimeNotEqualTo(Integer value) {
            addCriterion("repay_time <>", value, "repayTime");
            return (Criteria) this;
        }

        public Criteria andRepayTimeGreaterThan(Integer value) {
            addCriterion("repay_time >", value, "repayTime");
            return (Criteria) this;
        }

        public Criteria andRepayTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("repay_time >=", value, "repayTime");
            return (Criteria) this;
        }

        public Criteria andRepayTimeLessThan(Integer value) {
            addCriterion("repay_time <", value, "repayTime");
            return (Criteria) this;
        }

        public Criteria andRepayTimeLessThanOrEqualTo(Integer value) {
            addCriterion("repay_time <=", value, "repayTime");
            return (Criteria) this;
        }

        public Criteria andRepayTimeIn(List<Integer> values) {
            addCriterion("repay_time in", values, "repayTime");
            return (Criteria) this;
        }

        public Criteria andRepayTimeNotIn(List<Integer> values) {
            addCriterion("repay_time not in", values, "repayTime");
            return (Criteria) this;
        }

        public Criteria andRepayTimeBetween(Integer value1, Integer value2) {
            addCriterion("repay_time between", value1, value2, "repayTime");
            return (Criteria) this;
        }

        public Criteria andRepayTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("repay_time not between", value1, value2, "repayTime");
            return (Criteria) this;
        }

        public Criteria andProvideMoneyIsNull() {
            addCriterion("provide_money is null");
            return (Criteria) this;
        }

        public Criteria andProvideMoneyIsNotNull() {
            addCriterion("provide_money is not null");
            return (Criteria) this;
        }

        public Criteria andProvideMoneyEqualTo(Integer value) {
            addCriterion("provide_money =", value, "provideMoney");
            return (Criteria) this;
        }

        public Criteria andProvideMoneyNotEqualTo(Integer value) {
            addCriterion("provide_money <>", value, "provideMoney");
            return (Criteria) this;
        }

        public Criteria andProvideMoneyGreaterThan(Integer value) {
            addCriterion("provide_money >", value, "provideMoney");
            return (Criteria) this;
        }

        public Criteria andProvideMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("provide_money >=", value, "provideMoney");
            return (Criteria) this;
        }

        public Criteria andProvideMoneyLessThan(Integer value) {
            addCriterion("provide_money <", value, "provideMoney");
            return (Criteria) this;
        }

        public Criteria andProvideMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("provide_money <=", value, "provideMoney");
            return (Criteria) this;
        }

        public Criteria andProvideMoneyIn(List<Integer> values) {
            addCriterion("provide_money in", values, "provideMoney");
            return (Criteria) this;
        }

        public Criteria andProvideMoneyNotIn(List<Integer> values) {
            addCriterion("provide_money not in", values, "provideMoney");
            return (Criteria) this;
        }

        public Criteria andProvideMoneyBetween(Integer value1, Integer value2) {
            addCriterion("provide_money between", value1, value2, "provideMoney");
            return (Criteria) this;
        }

        public Criteria andProvideMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("provide_money not between", value1, value2, "provideMoney");
            return (Criteria) this;
        }

        public Criteria andShouldRepayMoneyIsNull() {
            addCriterion("should_repay_money is null");
            return (Criteria) this;
        }

        public Criteria andShouldRepayMoneyIsNotNull() {
            addCriterion("should_repay_money is not null");
            return (Criteria) this;
        }

        public Criteria andShouldRepayMoneyEqualTo(Integer value) {
            addCriterion("should_repay_money =", value, "shouldRepayMoney");
            return (Criteria) this;
        }

        public Criteria andShouldRepayMoneyNotEqualTo(Integer value) {
            addCriterion("should_repay_money <>", value, "shouldRepayMoney");
            return (Criteria) this;
        }

        public Criteria andShouldRepayMoneyGreaterThan(Integer value) {
            addCriterion("should_repay_money >", value, "shouldRepayMoney");
            return (Criteria) this;
        }

        public Criteria andShouldRepayMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("should_repay_money >=", value, "shouldRepayMoney");
            return (Criteria) this;
        }

        public Criteria andShouldRepayMoneyLessThan(Integer value) {
            addCriterion("should_repay_money <", value, "shouldRepayMoney");
            return (Criteria) this;
        }

        public Criteria andShouldRepayMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("should_repay_money <=", value, "shouldRepayMoney");
            return (Criteria) this;
        }

        public Criteria andShouldRepayMoneyIn(List<Integer> values) {
            addCriterion("should_repay_money in", values, "shouldRepayMoney");
            return (Criteria) this;
        }

        public Criteria andShouldRepayMoneyNotIn(List<Integer> values) {
            addCriterion("should_repay_money not in", values, "shouldRepayMoney");
            return (Criteria) this;
        }

        public Criteria andShouldRepayMoneyBetween(Integer value1, Integer value2) {
            addCriterion("should_repay_money between", value1, value2, "shouldRepayMoney");
            return (Criteria) this;
        }

        public Criteria andShouldRepayMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("should_repay_money not between", value1, value2, "shouldRepayMoney");
            return (Criteria) this;
        }

        public Criteria andYearMoneyRateIdIsNull() {
            addCriterion("year_money_rate_id is null");
            return (Criteria) this;
        }

        public Criteria andYearMoneyRateIdIsNotNull() {
            addCriterion("year_money_rate_id is not null");
            return (Criteria) this;
        }

        public Criteria andYearMoneyRateIdEqualTo(Long value) {
            addCriterion("year_money_rate_id =", value, "yearMoneyRateId");
            return (Criteria) this;
        }

        public Criteria andYearMoneyRateIdNotEqualTo(Long value) {
            addCriterion("year_money_rate_id <>", value, "yearMoneyRateId");
            return (Criteria) this;
        }

        public Criteria andYearMoneyRateIdGreaterThan(Long value) {
            addCriterion("year_money_rate_id >", value, "yearMoneyRateId");
            return (Criteria) this;
        }

        public Criteria andYearMoneyRateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("year_money_rate_id >=", value, "yearMoneyRateId");
            return (Criteria) this;
        }

        public Criteria andYearMoneyRateIdLessThan(Long value) {
            addCriterion("year_money_rate_id <", value, "yearMoneyRateId");
            return (Criteria) this;
        }

        public Criteria andYearMoneyRateIdLessThanOrEqualTo(Long value) {
            addCriterion("year_money_rate_id <=", value, "yearMoneyRateId");
            return (Criteria) this;
        }

        public Criteria andYearMoneyRateIdIn(List<Long> values) {
            addCriterion("year_money_rate_id in", values, "yearMoneyRateId");
            return (Criteria) this;
        }

        public Criteria andYearMoneyRateIdNotIn(List<Long> values) {
            addCriterion("year_money_rate_id not in", values, "yearMoneyRateId");
            return (Criteria) this;
        }

        public Criteria andYearMoneyRateIdBetween(Long value1, Long value2) {
            addCriterion("year_money_rate_id between", value1, value2, "yearMoneyRateId");
            return (Criteria) this;
        }

        public Criteria andYearMoneyRateIdNotBetween(Long value1, Long value2) {
            addCriterion("year_money_rate_id not between", value1, value2, "yearMoneyRateId");
            return (Criteria) this;
        }

        public Criteria andPurposeIdIsNull() {
            addCriterion("purpose_id is null");
            return (Criteria) this;
        }

        public Criteria andPurposeIdIsNotNull() {
            addCriterion("purpose_id is not null");
            return (Criteria) this;
        }

        public Criteria andPurposeIdEqualTo(Long value) {
            addCriterion("purpose_id =", value, "purposeId");
            return (Criteria) this;
        }

        public Criteria andPurposeIdNotEqualTo(Long value) {
            addCriterion("purpose_id <>", value, "purposeId");
            return (Criteria) this;
        }

        public Criteria andPurposeIdGreaterThan(Long value) {
            addCriterion("purpose_id >", value, "purposeId");
            return (Criteria) this;
        }

        public Criteria andPurposeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("purpose_id >=", value, "purposeId");
            return (Criteria) this;
        }

        public Criteria andPurposeIdLessThan(Long value) {
            addCriterion("purpose_id <", value, "purposeId");
            return (Criteria) this;
        }

        public Criteria andPurposeIdLessThanOrEqualTo(Long value) {
            addCriterion("purpose_id <=", value, "purposeId");
            return (Criteria) this;
        }

        public Criteria andPurposeIdIn(List<Long> values) {
            addCriterion("purpose_id in", values, "purposeId");
            return (Criteria) this;
        }

        public Criteria andPurposeIdNotIn(List<Long> values) {
            addCriterion("purpose_id not in", values, "purposeId");
            return (Criteria) this;
        }

        public Criteria andPurposeIdBetween(Long value1, Long value2) {
            addCriterion("purpose_id between", value1, value2, "purposeId");
            return (Criteria) this;
        }

        public Criteria andPurposeIdNotBetween(Long value1, Long value2) {
            addCriterion("purpose_id not between", value1, value2, "purposeId");
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

        public Criteria andCreateTimeEqualTo(Integer value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Integer value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Integer value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Integer value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Integer> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Integer> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Integer value1, Integer value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Integer value1, Integer value2) {
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

        public Criteria andUpdateTimeEqualTo(Integer value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Integer value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Integer value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Integer value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Integer value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Integer> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Integer> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Integer value1, Integer value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
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