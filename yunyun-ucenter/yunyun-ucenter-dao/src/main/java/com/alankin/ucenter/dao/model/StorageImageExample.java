package com.alankin.ucenter.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StorageImageExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public StorageImageExample() {
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

        public Criteria andOriginalNameIsNull() {
            addCriterion("original_name is null");
            return (Criteria) this;
        }

        public Criteria andOriginalNameIsNotNull() {
            addCriterion("original_name is not null");
            return (Criteria) this;
        }

        public Criteria andOriginalNameEqualTo(String value) {
            addCriterion("original_name =", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotEqualTo(String value) {
            addCriterion("original_name <>", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameGreaterThan(String value) {
            addCriterion("original_name >", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameGreaterThanOrEqualTo(String value) {
            addCriterion("original_name >=", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameLessThan(String value) {
            addCriterion("original_name <", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameLessThanOrEqualTo(String value) {
            addCriterion("original_name <=", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameLike(String value) {
            addCriterion("original_name like", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotLike(String value) {
            addCriterion("original_name not like", value, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameIn(List<String> values) {
            addCriterion("original_name in", values, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotIn(List<String> values) {
            addCriterion("original_name not in", values, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameBetween(String value1, String value2) {
            addCriterion("original_name between", value1, value2, "originalName");
            return (Criteria) this;
        }

        public Criteria andOriginalNameNotBetween(String value1, String value2) {
            addCriterion("original_name not between", value1, value2, "originalName");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(Long value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(Long value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(Long value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(Long value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(Long value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<Long> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<Long> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(Long value1, Long value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(Long value1, Long value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andStorageNameIsNull() {
            addCriterion("storage_name is null");
            return (Criteria) this;
        }

        public Criteria andStorageNameIsNotNull() {
            addCriterion("storage_name is not null");
            return (Criteria) this;
        }

        public Criteria andStorageNameEqualTo(String value) {
            addCriterion("storage_name =", value, "storageName");
            return (Criteria) this;
        }

        public Criteria andStorageNameNotEqualTo(String value) {
            addCriterion("storage_name <>", value, "storageName");
            return (Criteria) this;
        }

        public Criteria andStorageNameGreaterThan(String value) {
            addCriterion("storage_name >", value, "storageName");
            return (Criteria) this;
        }

        public Criteria andStorageNameGreaterThanOrEqualTo(String value) {
            addCriterion("storage_name >=", value, "storageName");
            return (Criteria) this;
        }

        public Criteria andStorageNameLessThan(String value) {
            addCriterion("storage_name <", value, "storageName");
            return (Criteria) this;
        }

        public Criteria andStorageNameLessThanOrEqualTo(String value) {
            addCriterion("storage_name <=", value, "storageName");
            return (Criteria) this;
        }

        public Criteria andStorageNameLike(String value) {
            addCriterion("storage_name like", value, "storageName");
            return (Criteria) this;
        }

        public Criteria andStorageNameNotLike(String value) {
            addCriterion("storage_name not like", value, "storageName");
            return (Criteria) this;
        }

        public Criteria andStorageNameIn(List<String> values) {
            addCriterion("storage_name in", values, "storageName");
            return (Criteria) this;
        }

        public Criteria andStorageNameNotIn(List<String> values) {
            addCriterion("storage_name not in", values, "storageName");
            return (Criteria) this;
        }

        public Criteria andStorageNameBetween(String value1, String value2) {
            addCriterion("storage_name between", value1, value2, "storageName");
            return (Criteria) this;
        }

        public Criteria andStorageNameNotBetween(String value1, String value2) {
            addCriterion("storage_name not between", value1, value2, "storageName");
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

        public Criteria andStoragePathIsNull() {
            addCriterion("storage_path is null");
            return (Criteria) this;
        }

        public Criteria andStoragePathIsNotNull() {
            addCriterion("storage_path is not null");
            return (Criteria) this;
        }

        public Criteria andStoragePathEqualTo(String value) {
            addCriterion("storage_path =", value, "storagePath");
            return (Criteria) this;
        }

        public Criteria andStoragePathNotEqualTo(String value) {
            addCriterion("storage_path <>", value, "storagePath");
            return (Criteria) this;
        }

        public Criteria andStoragePathGreaterThan(String value) {
            addCriterion("storage_path >", value, "storagePath");
            return (Criteria) this;
        }

        public Criteria andStoragePathGreaterThanOrEqualTo(String value) {
            addCriterion("storage_path >=", value, "storagePath");
            return (Criteria) this;
        }

        public Criteria andStoragePathLessThan(String value) {
            addCriterion("storage_path <", value, "storagePath");
            return (Criteria) this;
        }

        public Criteria andStoragePathLessThanOrEqualTo(String value) {
            addCriterion("storage_path <=", value, "storagePath");
            return (Criteria) this;
        }

        public Criteria andStoragePathLike(String value) {
            addCriterion("storage_path like", value, "storagePath");
            return (Criteria) this;
        }

        public Criteria andStoragePathNotLike(String value) {
            addCriterion("storage_path not like", value, "storagePath");
            return (Criteria) this;
        }

        public Criteria andStoragePathIn(List<String> values) {
            addCriterion("storage_path in", values, "storagePath");
            return (Criteria) this;
        }

        public Criteria andStoragePathNotIn(List<String> values) {
            addCriterion("storage_path not in", values, "storagePath");
            return (Criteria) this;
        }

        public Criteria andStoragePathBetween(String value1, String value2) {
            addCriterion("storage_path between", value1, value2, "storagePath");
            return (Criteria) this;
        }

        public Criteria andStoragePathNotBetween(String value1, String value2) {
            addCriterion("storage_path not between", value1, value2, "storagePath");
            return (Criteria) this;
        }

        public Criteria andFullPathIsNull() {
            addCriterion("full_path is null");
            return (Criteria) this;
        }

        public Criteria andFullPathIsNotNull() {
            addCriterion("full_path is not null");
            return (Criteria) this;
        }

        public Criteria andFullPathEqualTo(String value) {
            addCriterion("full_path =", value, "fullPath");
            return (Criteria) this;
        }

        public Criteria andFullPathNotEqualTo(String value) {
            addCriterion("full_path <>", value, "fullPath");
            return (Criteria) this;
        }

        public Criteria andFullPathGreaterThan(String value) {
            addCriterion("full_path >", value, "fullPath");
            return (Criteria) this;
        }

        public Criteria andFullPathGreaterThanOrEqualTo(String value) {
            addCriterion("full_path >=", value, "fullPath");
            return (Criteria) this;
        }

        public Criteria andFullPathLessThan(String value) {
            addCriterion("full_path <", value, "fullPath");
            return (Criteria) this;
        }

        public Criteria andFullPathLessThanOrEqualTo(String value) {
            addCriterion("full_path <=", value, "fullPath");
            return (Criteria) this;
        }

        public Criteria andFullPathLike(String value) {
            addCriterion("full_path like", value, "fullPath");
            return (Criteria) this;
        }

        public Criteria andFullPathNotLike(String value) {
            addCriterion("full_path not like", value, "fullPath");
            return (Criteria) this;
        }

        public Criteria andFullPathIn(List<String> values) {
            addCriterion("full_path in", values, "fullPath");
            return (Criteria) this;
        }

        public Criteria andFullPathNotIn(List<String> values) {
            addCriterion("full_path not in", values, "fullPath");
            return (Criteria) this;
        }

        public Criteria andFullPathBetween(String value1, String value2) {
            addCriterion("full_path between", value1, value2, "fullPath");
            return (Criteria) this;
        }

        public Criteria andFullPathNotBetween(String value1, String value2) {
            addCriterion("full_path not between", value1, value2, "fullPath");
            return (Criteria) this;
        }

        public Criteria andStorageGroupIsNull() {
            addCriterion("storage_group is null");
            return (Criteria) this;
        }

        public Criteria andStorageGroupIsNotNull() {
            addCriterion("storage_group is not null");
            return (Criteria) this;
        }

        public Criteria andStorageGroupEqualTo(String value) {
            addCriterion("storage_group =", value, "storageGroup");
            return (Criteria) this;
        }

        public Criteria andStorageGroupNotEqualTo(String value) {
            addCriterion("storage_group <>", value, "storageGroup");
            return (Criteria) this;
        }

        public Criteria andStorageGroupGreaterThan(String value) {
            addCriterion("storage_group >", value, "storageGroup");
            return (Criteria) this;
        }

        public Criteria andStorageGroupGreaterThanOrEqualTo(String value) {
            addCriterion("storage_group >=", value, "storageGroup");
            return (Criteria) this;
        }

        public Criteria andStorageGroupLessThan(String value) {
            addCriterion("storage_group <", value, "storageGroup");
            return (Criteria) this;
        }

        public Criteria andStorageGroupLessThanOrEqualTo(String value) {
            addCriterion("storage_group <=", value, "storageGroup");
            return (Criteria) this;
        }

        public Criteria andStorageGroupLike(String value) {
            addCriterion("storage_group like", value, "storageGroup");
            return (Criteria) this;
        }

        public Criteria andStorageGroupNotLike(String value) {
            addCriterion("storage_group not like", value, "storageGroup");
            return (Criteria) this;
        }

        public Criteria andStorageGroupIn(List<String> values) {
            addCriterion("storage_group in", values, "storageGroup");
            return (Criteria) this;
        }

        public Criteria andStorageGroupNotIn(List<String> values) {
            addCriterion("storage_group not in", values, "storageGroup");
            return (Criteria) this;
        }

        public Criteria andStorageGroupBetween(String value1, String value2) {
            addCriterion("storage_group between", value1, value2, "storageGroup");
            return (Criteria) this;
        }

        public Criteria andStorageGroupNotBetween(String value1, String value2) {
            addCriterion("storage_group not between", value1, value2, "storageGroup");
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