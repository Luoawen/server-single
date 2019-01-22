package com.alankin.ucenter.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserLocationExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public UserLocationExample() {
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

        public Criteria andCurrNationIsNull() {
            addCriterion("curr_nation is null");
            return (Criteria) this;
        }

        public Criteria andCurrNationIsNotNull() {
            addCriterion("curr_nation is not null");
            return (Criteria) this;
        }

        public Criteria andCurrNationEqualTo(String value) {
            addCriterion("curr_nation =", value, "currNation");
            return (Criteria) this;
        }

        public Criteria andCurrNationNotEqualTo(String value) {
            addCriterion("curr_nation <>", value, "currNation");
            return (Criteria) this;
        }

        public Criteria andCurrNationGreaterThan(String value) {
            addCriterion("curr_nation >", value, "currNation");
            return (Criteria) this;
        }

        public Criteria andCurrNationGreaterThanOrEqualTo(String value) {
            addCriterion("curr_nation >=", value, "currNation");
            return (Criteria) this;
        }

        public Criteria andCurrNationLessThan(String value) {
            addCriterion("curr_nation <", value, "currNation");
            return (Criteria) this;
        }

        public Criteria andCurrNationLessThanOrEqualTo(String value) {
            addCriterion("curr_nation <=", value, "currNation");
            return (Criteria) this;
        }

        public Criteria andCurrNationLike(String value) {
            addCriterion("curr_nation like", value, "currNation");
            return (Criteria) this;
        }

        public Criteria andCurrNationNotLike(String value) {
            addCriterion("curr_nation not like", value, "currNation");
            return (Criteria) this;
        }

        public Criteria andCurrNationIn(List<String> values) {
            addCriterion("curr_nation in", values, "currNation");
            return (Criteria) this;
        }

        public Criteria andCurrNationNotIn(List<String> values) {
            addCriterion("curr_nation not in", values, "currNation");
            return (Criteria) this;
        }

        public Criteria andCurrNationBetween(String value1, String value2) {
            addCriterion("curr_nation between", value1, value2, "currNation");
            return (Criteria) this;
        }

        public Criteria andCurrNationNotBetween(String value1, String value2) {
            addCriterion("curr_nation not between", value1, value2, "currNation");
            return (Criteria) this;
        }

        public Criteria andCurrProvinceIsNull() {
            addCriterion("curr_province is null");
            return (Criteria) this;
        }

        public Criteria andCurrProvinceIsNotNull() {
            addCriterion("curr_province is not null");
            return (Criteria) this;
        }

        public Criteria andCurrProvinceEqualTo(String value) {
            addCriterion("curr_province =", value, "currProvince");
            return (Criteria) this;
        }

        public Criteria andCurrProvinceNotEqualTo(String value) {
            addCriterion("curr_province <>", value, "currProvince");
            return (Criteria) this;
        }

        public Criteria andCurrProvinceGreaterThan(String value) {
            addCriterion("curr_province >", value, "currProvince");
            return (Criteria) this;
        }

        public Criteria andCurrProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("curr_province >=", value, "currProvince");
            return (Criteria) this;
        }

        public Criteria andCurrProvinceLessThan(String value) {
            addCriterion("curr_province <", value, "currProvince");
            return (Criteria) this;
        }

        public Criteria andCurrProvinceLessThanOrEqualTo(String value) {
            addCriterion("curr_province <=", value, "currProvince");
            return (Criteria) this;
        }

        public Criteria andCurrProvinceLike(String value) {
            addCriterion("curr_province like", value, "currProvince");
            return (Criteria) this;
        }

        public Criteria andCurrProvinceNotLike(String value) {
            addCriterion("curr_province not like", value, "currProvince");
            return (Criteria) this;
        }

        public Criteria andCurrProvinceIn(List<String> values) {
            addCriterion("curr_province in", values, "currProvince");
            return (Criteria) this;
        }

        public Criteria andCurrProvinceNotIn(List<String> values) {
            addCriterion("curr_province not in", values, "currProvince");
            return (Criteria) this;
        }

        public Criteria andCurrProvinceBetween(String value1, String value2) {
            addCriterion("curr_province between", value1, value2, "currProvince");
            return (Criteria) this;
        }

        public Criteria andCurrProvinceNotBetween(String value1, String value2) {
            addCriterion("curr_province not between", value1, value2, "currProvince");
            return (Criteria) this;
        }

        public Criteria andCurrCityIsNull() {
            addCriterion("curr_city is null");
            return (Criteria) this;
        }

        public Criteria andCurrCityIsNotNull() {
            addCriterion("curr_city is not null");
            return (Criteria) this;
        }

        public Criteria andCurrCityEqualTo(String value) {
            addCriterion("curr_city =", value, "currCity");
            return (Criteria) this;
        }

        public Criteria andCurrCityNotEqualTo(String value) {
            addCriterion("curr_city <>", value, "currCity");
            return (Criteria) this;
        }

        public Criteria andCurrCityGreaterThan(String value) {
            addCriterion("curr_city >", value, "currCity");
            return (Criteria) this;
        }

        public Criteria andCurrCityGreaterThanOrEqualTo(String value) {
            addCriterion("curr_city >=", value, "currCity");
            return (Criteria) this;
        }

        public Criteria andCurrCityLessThan(String value) {
            addCriterion("curr_city <", value, "currCity");
            return (Criteria) this;
        }

        public Criteria andCurrCityLessThanOrEqualTo(String value) {
            addCriterion("curr_city <=", value, "currCity");
            return (Criteria) this;
        }

        public Criteria andCurrCityLike(String value) {
            addCriterion("curr_city like", value, "currCity");
            return (Criteria) this;
        }

        public Criteria andCurrCityNotLike(String value) {
            addCriterion("curr_city not like", value, "currCity");
            return (Criteria) this;
        }

        public Criteria andCurrCityIn(List<String> values) {
            addCriterion("curr_city in", values, "currCity");
            return (Criteria) this;
        }

        public Criteria andCurrCityNotIn(List<String> values) {
            addCriterion("curr_city not in", values, "currCity");
            return (Criteria) this;
        }

        public Criteria andCurrCityBetween(String value1, String value2) {
            addCriterion("curr_city between", value1, value2, "currCity");
            return (Criteria) this;
        }

        public Criteria andCurrCityNotBetween(String value1, String value2) {
            addCriterion("curr_city not between", value1, value2, "currCity");
            return (Criteria) this;
        }

        public Criteria andCurrDistrictIsNull() {
            addCriterion("curr_district is null");
            return (Criteria) this;
        }

        public Criteria andCurrDistrictIsNotNull() {
            addCriterion("curr_district is not null");
            return (Criteria) this;
        }

        public Criteria andCurrDistrictEqualTo(String value) {
            addCriterion("curr_district =", value, "currDistrict");
            return (Criteria) this;
        }

        public Criteria andCurrDistrictNotEqualTo(String value) {
            addCriterion("curr_district <>", value, "currDistrict");
            return (Criteria) this;
        }

        public Criteria andCurrDistrictGreaterThan(String value) {
            addCriterion("curr_district >", value, "currDistrict");
            return (Criteria) this;
        }

        public Criteria andCurrDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("curr_district >=", value, "currDistrict");
            return (Criteria) this;
        }

        public Criteria andCurrDistrictLessThan(String value) {
            addCriterion("curr_district <", value, "currDistrict");
            return (Criteria) this;
        }

        public Criteria andCurrDistrictLessThanOrEqualTo(String value) {
            addCriterion("curr_district <=", value, "currDistrict");
            return (Criteria) this;
        }

        public Criteria andCurrDistrictLike(String value) {
            addCriterion("curr_district like", value, "currDistrict");
            return (Criteria) this;
        }

        public Criteria andCurrDistrictNotLike(String value) {
            addCriterion("curr_district not like", value, "currDistrict");
            return (Criteria) this;
        }

        public Criteria andCurrDistrictIn(List<String> values) {
            addCriterion("curr_district in", values, "currDistrict");
            return (Criteria) this;
        }

        public Criteria andCurrDistrictNotIn(List<String> values) {
            addCriterion("curr_district not in", values, "currDistrict");
            return (Criteria) this;
        }

        public Criteria andCurrDistrictBetween(String value1, String value2) {
            addCriterion("curr_district between", value1, value2, "currDistrict");
            return (Criteria) this;
        }

        public Criteria andCurrDistrictNotBetween(String value1, String value2) {
            addCriterion("curr_district not between", value1, value2, "currDistrict");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
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

        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
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