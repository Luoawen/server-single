package com.alankin.ucenter.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChannelRecordExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public ChannelRecordExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Long value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Long value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Long value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Long value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Long value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Long> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Long> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Long value1, Long value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Long value1, Long value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIsNull() {
            addCriterion("sys_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIsNotNull() {
            addCriterion("sys_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdEqualTo(Long value) {
            addCriterion("sys_user_id =", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotEqualTo(Long value) {
            addCriterion("sys_user_id <>", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThan(Long value) {
            addCriterion("sys_user_id >", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sys_user_id >=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThan(Long value) {
            addCriterion("sys_user_id <", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThanOrEqualTo(Long value) {
            addCriterion("sys_user_id <=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIn(List<Long> values) {
            addCriterion("sys_user_id in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotIn(List<Long> values) {
            addCriterion("sys_user_id not in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdBetween(Long value1, Long value2) {
            addCriterion("sys_user_id between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotBetween(Long value1, Long value2) {
            addCriterion("sys_user_id not between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andRegisterCountIsNull() {
            addCriterion("register_count is null");
            return (Criteria) this;
        }

        public Criteria andRegisterCountIsNotNull() {
            addCriterion("register_count is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterCountEqualTo(Integer value) {
            addCriterion("register_count =", value, "registerCount");
            return (Criteria) this;
        }

        public Criteria andRegisterCountNotEqualTo(Integer value) {
            addCriterion("register_count <>", value, "registerCount");
            return (Criteria) this;
        }

        public Criteria andRegisterCountGreaterThan(Integer value) {
            addCriterion("register_count >", value, "registerCount");
            return (Criteria) this;
        }

        public Criteria andRegisterCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("register_count >=", value, "registerCount");
            return (Criteria) this;
        }

        public Criteria andRegisterCountLessThan(Integer value) {
            addCriterion("register_count <", value, "registerCount");
            return (Criteria) this;
        }

        public Criteria andRegisterCountLessThanOrEqualTo(Integer value) {
            addCriterion("register_count <=", value, "registerCount");
            return (Criteria) this;
        }

        public Criteria andRegisterCountIn(List<Integer> values) {
            addCriterion("register_count in", values, "registerCount");
            return (Criteria) this;
        }

        public Criteria andRegisterCountNotIn(List<Integer> values) {
            addCriterion("register_count not in", values, "registerCount");
            return (Criteria) this;
        }

        public Criteria andRegisterCountBetween(Integer value1, Integer value2) {
            addCriterion("register_count between", value1, value2, "registerCount");
            return (Criteria) this;
        }

        public Criteria andRegisterCountNotBetween(Integer value1, Integer value2) {
            addCriterion("register_count not between", value1, value2, "registerCount");
            return (Criteria) this;
        }

        public Criteria andInCountIsNull() {
            addCriterion("in_count is null");
            return (Criteria) this;
        }

        public Criteria andInCountIsNotNull() {
            addCriterion("in_count is not null");
            return (Criteria) this;
        }

        public Criteria andInCountEqualTo(Integer value) {
            addCriterion("in_count =", value, "inCount");
            return (Criteria) this;
        }

        public Criteria andInCountNotEqualTo(Integer value) {
            addCriterion("in_count <>", value, "inCount");
            return (Criteria) this;
        }

        public Criteria andInCountGreaterThan(Integer value) {
            addCriterion("in_count >", value, "inCount");
            return (Criteria) this;
        }

        public Criteria andInCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_count >=", value, "inCount");
            return (Criteria) this;
        }

        public Criteria andInCountLessThan(Integer value) {
            addCriterion("in_count <", value, "inCount");
            return (Criteria) this;
        }

        public Criteria andInCountLessThanOrEqualTo(Integer value) {
            addCriterion("in_count <=", value, "inCount");
            return (Criteria) this;
        }

        public Criteria andInCountIn(List<Integer> values) {
            addCriterion("in_count in", values, "inCount");
            return (Criteria) this;
        }

        public Criteria andInCountNotIn(List<Integer> values) {
            addCriterion("in_count not in", values, "inCount");
            return (Criteria) this;
        }

        public Criteria andInCountBetween(Integer value1, Integer value2) {
            addCriterion("in_count between", value1, value2, "inCount");
            return (Criteria) this;
        }

        public Criteria andInCountNotBetween(Integer value1, Integer value2) {
            addCriterion("in_count not between", value1, value2, "inCount");
            return (Criteria) this;
        }

        public Criteria andVerifyCountIsNull() {
            addCriterion("verify_count is null");
            return (Criteria) this;
        }

        public Criteria andVerifyCountIsNotNull() {
            addCriterion("verify_count is not null");
            return (Criteria) this;
        }

        public Criteria andVerifyCountEqualTo(Integer value) {
            addCriterion("verify_count =", value, "verifyCount");
            return (Criteria) this;
        }

        public Criteria andVerifyCountNotEqualTo(Integer value) {
            addCriterion("verify_count <>", value, "verifyCount");
            return (Criteria) this;
        }

        public Criteria andVerifyCountGreaterThan(Integer value) {
            addCriterion("verify_count >", value, "verifyCount");
            return (Criteria) this;
        }

        public Criteria andVerifyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("verify_count >=", value, "verifyCount");
            return (Criteria) this;
        }

        public Criteria andVerifyCountLessThan(Integer value) {
            addCriterion("verify_count <", value, "verifyCount");
            return (Criteria) this;
        }

        public Criteria andVerifyCountLessThanOrEqualTo(Integer value) {
            addCriterion("verify_count <=", value, "verifyCount");
            return (Criteria) this;
        }

        public Criteria andVerifyCountIn(List<Integer> values) {
            addCriterion("verify_count in", values, "verifyCount");
            return (Criteria) this;
        }

        public Criteria andVerifyCountNotIn(List<Integer> values) {
            addCriterion("verify_count not in", values, "verifyCount");
            return (Criteria) this;
        }

        public Criteria andVerifyCountBetween(Integer value1, Integer value2) {
            addCriterion("verify_count between", value1, value2, "verifyCount");
            return (Criteria) this;
        }

        public Criteria andVerifyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("verify_count not between", value1, value2, "verifyCount");
            return (Criteria) this;
        }

        public Criteria andProvideCountIsNull() {
            addCriterion("provide_count is null");
            return (Criteria) this;
        }

        public Criteria andProvideCountIsNotNull() {
            addCriterion("provide_count is not null");
            return (Criteria) this;
        }

        public Criteria andProvideCountEqualTo(Integer value) {
            addCriterion("provide_count =", value, "provideCount");
            return (Criteria) this;
        }

        public Criteria andProvideCountNotEqualTo(Integer value) {
            addCriterion("provide_count <>", value, "provideCount");
            return (Criteria) this;
        }

        public Criteria andProvideCountGreaterThan(Integer value) {
            addCriterion("provide_count >", value, "provideCount");
            return (Criteria) this;
        }

        public Criteria andProvideCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("provide_count >=", value, "provideCount");
            return (Criteria) this;
        }

        public Criteria andProvideCountLessThan(Integer value) {
            addCriterion("provide_count <", value, "provideCount");
            return (Criteria) this;
        }

        public Criteria andProvideCountLessThanOrEqualTo(Integer value) {
            addCriterion("provide_count <=", value, "provideCount");
            return (Criteria) this;
        }

        public Criteria andProvideCountIn(List<Integer> values) {
            addCriterion("provide_count in", values, "provideCount");
            return (Criteria) this;
        }

        public Criteria andProvideCountNotIn(List<Integer> values) {
            addCriterion("provide_count not in", values, "provideCount");
            return (Criteria) this;
        }

        public Criteria andProvideCountBetween(Integer value1, Integer value2) {
            addCriterion("provide_count between", value1, value2, "provideCount");
            return (Criteria) this;
        }

        public Criteria andProvideCountNotBetween(Integer value1, Integer value2) {
            addCriterion("provide_count not between", value1, value2, "provideCount");
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