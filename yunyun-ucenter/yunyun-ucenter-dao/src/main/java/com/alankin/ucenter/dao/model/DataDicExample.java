package com.alankin.ucenter.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataDicExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public DataDicExample() {
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

        public Criteria andSysUserIdIsNull() {
            addCriterion("sys_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIsNotNull() {
            addCriterion("sys_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSysUserIdEqualTo(Integer value) {
            addCriterion("sys_user_id =", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotEqualTo(Integer value) {
            addCriterion("sys_user_id <>", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThan(Integer value) {
            addCriterion("sys_user_id >", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_user_id >=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThan(Integer value) {
            addCriterion("sys_user_id <", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("sys_user_id <=", value, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdIn(List<Integer> values) {
            addCriterion("sys_user_id in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotIn(List<Integer> values) {
            addCriterion("sys_user_id not in", values, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdBetween(Integer value1, Integer value2) {
            addCriterion("sys_user_id between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andSysUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_user_id not between", value1, value2, "sysUserId");
            return (Criteria) this;
        }

        public Criteria andDataTypeNameIsNull() {
            addCriterion("data_type_name is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeNameIsNotNull() {
            addCriterion("data_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeNameEqualTo(String value) {
            addCriterion("data_type_name =", value, "dataTypeName");
            return (Criteria) this;
        }

        public Criteria andDataTypeNameNotEqualTo(String value) {
            addCriterion("data_type_name <>", value, "dataTypeName");
            return (Criteria) this;
        }

        public Criteria andDataTypeNameGreaterThan(String value) {
            addCriterion("data_type_name >", value, "dataTypeName");
            return (Criteria) this;
        }

        public Criteria andDataTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("data_type_name >=", value, "dataTypeName");
            return (Criteria) this;
        }

        public Criteria andDataTypeNameLessThan(String value) {
            addCriterion("data_type_name <", value, "dataTypeName");
            return (Criteria) this;
        }

        public Criteria andDataTypeNameLessThanOrEqualTo(String value) {
            addCriterion("data_type_name <=", value, "dataTypeName");
            return (Criteria) this;
        }

        public Criteria andDataTypeNameLike(String value) {
            addCriterion("data_type_name like", value, "dataTypeName");
            return (Criteria) this;
        }

        public Criteria andDataTypeNameNotLike(String value) {
            addCriterion("data_type_name not like", value, "dataTypeName");
            return (Criteria) this;
        }

        public Criteria andDataTypeNameIn(List<String> values) {
            addCriterion("data_type_name in", values, "dataTypeName");
            return (Criteria) this;
        }

        public Criteria andDataTypeNameNotIn(List<String> values) {
            addCriterion("data_type_name not in", values, "dataTypeName");
            return (Criteria) this;
        }

        public Criteria andDataTypeNameBetween(String value1, String value2) {
            addCriterion("data_type_name between", value1, value2, "dataTypeName");
            return (Criteria) this;
        }

        public Criteria andDataTypeNameNotBetween(String value1, String value2) {
            addCriterion("data_type_name not between", value1, value2, "dataTypeName");
            return (Criteria) this;
        }

        public Criteria andDataTypeCodeIsNull() {
            addCriterion("data_type_code is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeCodeIsNotNull() {
            addCriterion("data_type_code is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeCodeEqualTo(Integer value) {
            addCriterion("data_type_code =", value, "dataTypeCode");
            return (Criteria) this;
        }

        public Criteria andDataTypeCodeNotEqualTo(Integer value) {
            addCriterion("data_type_code <>", value, "dataTypeCode");
            return (Criteria) this;
        }

        public Criteria andDataTypeCodeGreaterThan(Integer value) {
            addCriterion("data_type_code >", value, "dataTypeCode");
            return (Criteria) this;
        }

        public Criteria andDataTypeCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_type_code >=", value, "dataTypeCode");
            return (Criteria) this;
        }

        public Criteria andDataTypeCodeLessThan(Integer value) {
            addCriterion("data_type_code <", value, "dataTypeCode");
            return (Criteria) this;
        }

        public Criteria andDataTypeCodeLessThanOrEqualTo(Integer value) {
            addCriterion("data_type_code <=", value, "dataTypeCode");
            return (Criteria) this;
        }

        public Criteria andDataTypeCodeIn(List<Integer> values) {
            addCriterion("data_type_code in", values, "dataTypeCode");
            return (Criteria) this;
        }

        public Criteria andDataTypeCodeNotIn(List<Integer> values) {
            addCriterion("data_type_code not in", values, "dataTypeCode");
            return (Criteria) this;
        }

        public Criteria andDataTypeCodeBetween(Integer value1, Integer value2) {
            addCriterion("data_type_code between", value1, value2, "dataTypeCode");
            return (Criteria) this;
        }

        public Criteria andDataTypeCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("data_type_code not between", value1, value2, "dataTypeCode");
            return (Criteria) this;
        }

        public Criteria andDicKeyIsNull() {
            addCriterion("dic_key is null");
            return (Criteria) this;
        }

        public Criteria andDicKeyIsNotNull() {
            addCriterion("dic_key is not null");
            return (Criteria) this;
        }

        public Criteria andDicKeyEqualTo(String value) {
            addCriterion("dic_key =", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotEqualTo(String value) {
            addCriterion("dic_key <>", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyGreaterThan(String value) {
            addCriterion("dic_key >", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("dic_key >=", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyLessThan(String value) {
            addCriterion("dic_key <", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyLessThanOrEqualTo(String value) {
            addCriterion("dic_key <=", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyLike(String value) {
            addCriterion("dic_key like", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotLike(String value) {
            addCriterion("dic_key not like", value, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyIn(List<String> values) {
            addCriterion("dic_key in", values, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotIn(List<String> values) {
            addCriterion("dic_key not in", values, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyBetween(String value1, String value2) {
            addCriterion("dic_key between", value1, value2, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicKeyNotBetween(String value1, String value2) {
            addCriterion("dic_key not between", value1, value2, "dicKey");
            return (Criteria) this;
        }

        public Criteria andDicValueIsNull() {
            addCriterion("dic_value is null");
            return (Criteria) this;
        }

        public Criteria andDicValueIsNotNull() {
            addCriterion("dic_value is not null");
            return (Criteria) this;
        }

        public Criteria andDicValueEqualTo(String value) {
            addCriterion("dic_value =", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotEqualTo(String value) {
            addCriterion("dic_value <>", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueGreaterThan(String value) {
            addCriterion("dic_value >", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueGreaterThanOrEqualTo(String value) {
            addCriterion("dic_value >=", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueLessThan(String value) {
            addCriterion("dic_value <", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueLessThanOrEqualTo(String value) {
            addCriterion("dic_value <=", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueLike(String value) {
            addCriterion("dic_value like", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotLike(String value) {
            addCriterion("dic_value not like", value, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueIn(List<String> values) {
            addCriterion("dic_value in", values, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotIn(List<String> values) {
            addCriterion("dic_value not in", values, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueBetween(String value1, String value2) {
            addCriterion("dic_value between", value1, value2, "dicValue");
            return (Criteria) this;
        }

        public Criteria andDicValueNotBetween(String value1, String value2) {
            addCriterion("dic_value not between", value1, value2, "dicValue");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andExtendValIsNull() {
            addCriterion("extend_Val is null");
            return (Criteria) this;
        }

        public Criteria andExtendValIsNotNull() {
            addCriterion("extend_Val is not null");
            return (Criteria) this;
        }

        public Criteria andExtendValEqualTo(String value) {
            addCriterion("extend_Val =", value, "extendVal");
            return (Criteria) this;
        }

        public Criteria andExtendValNotEqualTo(String value) {
            addCriterion("extend_Val <>", value, "extendVal");
            return (Criteria) this;
        }

        public Criteria andExtendValGreaterThan(String value) {
            addCriterion("extend_Val >", value, "extendVal");
            return (Criteria) this;
        }

        public Criteria andExtendValGreaterThanOrEqualTo(String value) {
            addCriterion("extend_Val >=", value, "extendVal");
            return (Criteria) this;
        }

        public Criteria andExtendValLessThan(String value) {
            addCriterion("extend_Val <", value, "extendVal");
            return (Criteria) this;
        }

        public Criteria andExtendValLessThanOrEqualTo(String value) {
            addCriterion("extend_Val <=", value, "extendVal");
            return (Criteria) this;
        }

        public Criteria andExtendValLike(String value) {
            addCriterion("extend_Val like", value, "extendVal");
            return (Criteria) this;
        }

        public Criteria andExtendValNotLike(String value) {
            addCriterion("extend_Val not like", value, "extendVal");
            return (Criteria) this;
        }

        public Criteria andExtendValIn(List<String> values) {
            addCriterion("extend_Val in", values, "extendVal");
            return (Criteria) this;
        }

        public Criteria andExtendValNotIn(List<String> values) {
            addCriterion("extend_Val not in", values, "extendVal");
            return (Criteria) this;
        }

        public Criteria andExtendValBetween(String value1, String value2) {
            addCriterion("extend_Val between", value1, value2, "extendVal");
            return (Criteria) this;
        }

        public Criteria andExtendValNotBetween(String value1, String value2) {
            addCriterion("extend_Val not between", value1, value2, "extendVal");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Boolean value) {
            addCriterion("enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Boolean value) {
            addCriterion("enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Boolean value) {
            addCriterion("enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Boolean value) {
            addCriterion("enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Boolean value) {
            addCriterion("enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Boolean> values) {
            addCriterion("enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Boolean> values) {
            addCriterion("enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
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