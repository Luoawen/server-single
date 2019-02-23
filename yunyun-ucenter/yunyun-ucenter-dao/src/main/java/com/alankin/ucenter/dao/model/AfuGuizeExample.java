package com.alankin.ucenter.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AfuGuizeExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public AfuGuizeExample() {
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

        public Criteria andGzCodeIsNull() {
            addCriterion("gz_code is null");
            return (Criteria) this;
        }

        public Criteria andGzCodeIsNotNull() {
            addCriterion("gz_code is not null");
            return (Criteria) this;
        }

        public Criteria andGzCodeEqualTo(String value) {
            addCriterion("gz_code =", value, "gzCode");
            return (Criteria) this;
        }

        public Criteria andGzCodeNotEqualTo(String value) {
            addCriterion("gz_code <>", value, "gzCode");
            return (Criteria) this;
        }

        public Criteria andGzCodeGreaterThan(String value) {
            addCriterion("gz_code >", value, "gzCode");
            return (Criteria) this;
        }

        public Criteria andGzCodeGreaterThanOrEqualTo(String value) {
            addCriterion("gz_code >=", value, "gzCode");
            return (Criteria) this;
        }

        public Criteria andGzCodeLessThan(String value) {
            addCriterion("gz_code <", value, "gzCode");
            return (Criteria) this;
        }

        public Criteria andGzCodeLessThanOrEqualTo(String value) {
            addCriterion("gz_code <=", value, "gzCode");
            return (Criteria) this;
        }

        public Criteria andGzCodeLike(String value) {
            addCriterion("gz_code like", value, "gzCode");
            return (Criteria) this;
        }

        public Criteria andGzCodeNotLike(String value) {
            addCriterion("gz_code not like", value, "gzCode");
            return (Criteria) this;
        }

        public Criteria andGzCodeIn(List<String> values) {
            addCriterion("gz_code in", values, "gzCode");
            return (Criteria) this;
        }

        public Criteria andGzCodeNotIn(List<String> values) {
            addCriterion("gz_code not in", values, "gzCode");
            return (Criteria) this;
        }

        public Criteria andGzCodeBetween(String value1, String value2) {
            addCriterion("gz_code between", value1, value2, "gzCode");
            return (Criteria) this;
        }

        public Criteria andGzCodeNotBetween(String value1, String value2) {
            addCriterion("gz_code not between", value1, value2, "gzCode");
            return (Criteria) this;
        }

        public Criteria andGzNameIsNull() {
            addCriterion("gz_name is null");
            return (Criteria) this;
        }

        public Criteria andGzNameIsNotNull() {
            addCriterion("gz_name is not null");
            return (Criteria) this;
        }

        public Criteria andGzNameEqualTo(String value) {
            addCriterion("gz_name =", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameNotEqualTo(String value) {
            addCriterion("gz_name <>", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameGreaterThan(String value) {
            addCriterion("gz_name >", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameGreaterThanOrEqualTo(String value) {
            addCriterion("gz_name >=", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameLessThan(String value) {
            addCriterion("gz_name <", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameLessThanOrEqualTo(String value) {
            addCriterion("gz_name <=", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameLike(String value) {
            addCriterion("gz_name like", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameNotLike(String value) {
            addCriterion("gz_name not like", value, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameIn(List<String> values) {
            addCriterion("gz_name in", values, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameNotIn(List<String> values) {
            addCriterion("gz_name not in", values, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameBetween(String value1, String value2) {
            addCriterion("gz_name between", value1, value2, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzNameNotBetween(String value1, String value2) {
            addCriterion("gz_name not between", value1, value2, "gzName");
            return (Criteria) this;
        }

        public Criteria andGzJiexiIsNull() {
            addCriterion("gz_jiexi is null");
            return (Criteria) this;
        }

        public Criteria andGzJiexiIsNotNull() {
            addCriterion("gz_jiexi is not null");
            return (Criteria) this;
        }

        public Criteria andGzJiexiEqualTo(String value) {
            addCriterion("gz_jiexi =", value, "gzJiexi");
            return (Criteria) this;
        }

        public Criteria andGzJiexiNotEqualTo(String value) {
            addCriterion("gz_jiexi <>", value, "gzJiexi");
            return (Criteria) this;
        }

        public Criteria andGzJiexiGreaterThan(String value) {
            addCriterion("gz_jiexi >", value, "gzJiexi");
            return (Criteria) this;
        }

        public Criteria andGzJiexiGreaterThanOrEqualTo(String value) {
            addCriterion("gz_jiexi >=", value, "gzJiexi");
            return (Criteria) this;
        }

        public Criteria andGzJiexiLessThan(String value) {
            addCriterion("gz_jiexi <", value, "gzJiexi");
            return (Criteria) this;
        }

        public Criteria andGzJiexiLessThanOrEqualTo(String value) {
            addCriterion("gz_jiexi <=", value, "gzJiexi");
            return (Criteria) this;
        }

        public Criteria andGzJiexiLike(String value) {
            addCriterion("gz_jiexi like", value, "gzJiexi");
            return (Criteria) this;
        }

        public Criteria andGzJiexiNotLike(String value) {
            addCriterion("gz_jiexi not like", value, "gzJiexi");
            return (Criteria) this;
        }

        public Criteria andGzJiexiIn(List<String> values) {
            addCriterion("gz_jiexi in", values, "gzJiexi");
            return (Criteria) this;
        }

        public Criteria andGzJiexiNotIn(List<String> values) {
            addCriterion("gz_jiexi not in", values, "gzJiexi");
            return (Criteria) this;
        }

        public Criteria andGzJiexiBetween(String value1, String value2) {
            addCriterion("gz_jiexi between", value1, value2, "gzJiexi");
            return (Criteria) this;
        }

        public Criteria andGzJiexiNotBetween(String value1, String value2) {
            addCriterion("gz_jiexi not between", value1, value2, "gzJiexi");
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