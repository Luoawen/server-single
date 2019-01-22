package com.alankin.ucenter.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserOtherAcountExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public UserOtherAcountExample() {
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

        public Criteria andUserUidIsNull() {
            addCriterion("user_uid is null");
            return (Criteria) this;
        }

        public Criteria andUserUidIsNotNull() {
            addCriterion("user_uid is not null");
            return (Criteria) this;
        }

        public Criteria andUserUidEqualTo(Long value) {
            addCriterion("user_uid =", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidNotEqualTo(Long value) {
            addCriterion("user_uid <>", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidGreaterThan(Long value) {
            addCriterion("user_uid >", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidGreaterThanOrEqualTo(Long value) {
            addCriterion("user_uid >=", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidLessThan(Long value) {
            addCriterion("user_uid <", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidLessThanOrEqualTo(Long value) {
            addCriterion("user_uid <=", value, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidIn(List<Long> values) {
            addCriterion("user_uid in", values, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidNotIn(List<Long> values) {
            addCriterion("user_uid not in", values, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidBetween(Long value1, Long value2) {
            addCriterion("user_uid between", value1, value2, "userUid");
            return (Criteria) this;
        }

        public Criteria andUserUidNotBetween(Long value1, Long value2) {
            addCriterion("user_uid not between", value1, value2, "userUid");
            return (Criteria) this;
        }

        public Criteria andAcountIsNull() {
            addCriterion("acount is null");
            return (Criteria) this;
        }

        public Criteria andAcountIsNotNull() {
            addCriterion("acount is not null");
            return (Criteria) this;
        }

        public Criteria andAcountEqualTo(String value) {
            addCriterion("acount =", value, "acount");
            return (Criteria) this;
        }

        public Criteria andAcountNotEqualTo(String value) {
            addCriterion("acount <>", value, "acount");
            return (Criteria) this;
        }

        public Criteria andAcountGreaterThan(String value) {
            addCriterion("acount >", value, "acount");
            return (Criteria) this;
        }

        public Criteria andAcountGreaterThanOrEqualTo(String value) {
            addCriterion("acount >=", value, "acount");
            return (Criteria) this;
        }

        public Criteria andAcountLessThan(String value) {
            addCriterion("acount <", value, "acount");
            return (Criteria) this;
        }

        public Criteria andAcountLessThanOrEqualTo(String value) {
            addCriterion("acount <=", value, "acount");
            return (Criteria) this;
        }

        public Criteria andAcountLike(String value) {
            addCriterion("acount like", value, "acount");
            return (Criteria) this;
        }

        public Criteria andAcountNotLike(String value) {
            addCriterion("acount not like", value, "acount");
            return (Criteria) this;
        }

        public Criteria andAcountIn(List<String> values) {
            addCriterion("acount in", values, "acount");
            return (Criteria) this;
        }

        public Criteria andAcountNotIn(List<String> values) {
            addCriterion("acount not in", values, "acount");
            return (Criteria) this;
        }

        public Criteria andAcountBetween(String value1, String value2) {
            addCriterion("acount between", value1, value2, "acount");
            return (Criteria) this;
        }

        public Criteria andAcountNotBetween(String value1, String value2) {
            addCriterion("acount not between", value1, value2, "acount");
            return (Criteria) this;
        }

        public Criteria andAcountPasswordIsNull() {
            addCriterion("acount_password is null");
            return (Criteria) this;
        }

        public Criteria andAcountPasswordIsNotNull() {
            addCriterion("acount_password is not null");
            return (Criteria) this;
        }

        public Criteria andAcountPasswordEqualTo(String value) {
            addCriterion("acount_password =", value, "acountPassword");
            return (Criteria) this;
        }

        public Criteria andAcountPasswordNotEqualTo(String value) {
            addCriterion("acount_password <>", value, "acountPassword");
            return (Criteria) this;
        }

        public Criteria andAcountPasswordGreaterThan(String value) {
            addCriterion("acount_password >", value, "acountPassword");
            return (Criteria) this;
        }

        public Criteria andAcountPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("acount_password >=", value, "acountPassword");
            return (Criteria) this;
        }

        public Criteria andAcountPasswordLessThan(String value) {
            addCriterion("acount_password <", value, "acountPassword");
            return (Criteria) this;
        }

        public Criteria andAcountPasswordLessThanOrEqualTo(String value) {
            addCriterion("acount_password <=", value, "acountPassword");
            return (Criteria) this;
        }

        public Criteria andAcountPasswordLike(String value) {
            addCriterion("acount_password like", value, "acountPassword");
            return (Criteria) this;
        }

        public Criteria andAcountPasswordNotLike(String value) {
            addCriterion("acount_password not like", value, "acountPassword");
            return (Criteria) this;
        }

        public Criteria andAcountPasswordIn(List<String> values) {
            addCriterion("acount_password in", values, "acountPassword");
            return (Criteria) this;
        }

        public Criteria andAcountPasswordNotIn(List<String> values) {
            addCriterion("acount_password not in", values, "acountPassword");
            return (Criteria) this;
        }

        public Criteria andAcountPasswordBetween(String value1, String value2) {
            addCriterion("acount_password between", value1, value2, "acountPassword");
            return (Criteria) this;
        }

        public Criteria andAcountPasswordNotBetween(String value1, String value2) {
            addCriterion("acount_password not between", value1, value2, "acountPassword");
            return (Criteria) this;
        }

        public Criteria andAcountTypeKeyIsNull() {
            addCriterion("acount_type_key is null");
            return (Criteria) this;
        }

        public Criteria andAcountTypeKeyIsNotNull() {
            addCriterion("acount_type_key is not null");
            return (Criteria) this;
        }

        public Criteria andAcountTypeKeyEqualTo(Integer value) {
            addCriterion("acount_type_key =", value, "acountTypeKey");
            return (Criteria) this;
        }

        public Criteria andAcountTypeKeyNotEqualTo(Integer value) {
            addCriterion("acount_type_key <>", value, "acountTypeKey");
            return (Criteria) this;
        }

        public Criteria andAcountTypeKeyGreaterThan(Integer value) {
            addCriterion("acount_type_key >", value, "acountTypeKey");
            return (Criteria) this;
        }

        public Criteria andAcountTypeKeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("acount_type_key >=", value, "acountTypeKey");
            return (Criteria) this;
        }

        public Criteria andAcountTypeKeyLessThan(Integer value) {
            addCriterion("acount_type_key <", value, "acountTypeKey");
            return (Criteria) this;
        }

        public Criteria andAcountTypeKeyLessThanOrEqualTo(Integer value) {
            addCriterion("acount_type_key <=", value, "acountTypeKey");
            return (Criteria) this;
        }

        public Criteria andAcountTypeKeyIn(List<Integer> values) {
            addCriterion("acount_type_key in", values, "acountTypeKey");
            return (Criteria) this;
        }

        public Criteria andAcountTypeKeyNotIn(List<Integer> values) {
            addCriterion("acount_type_key not in", values, "acountTypeKey");
            return (Criteria) this;
        }

        public Criteria andAcountTypeKeyBetween(Integer value1, Integer value2) {
            addCriterion("acount_type_key between", value1, value2, "acountTypeKey");
            return (Criteria) this;
        }

        public Criteria andAcountTypeKeyNotBetween(Integer value1, Integer value2) {
            addCriterion("acount_type_key not between", value1, value2, "acountTypeKey");
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