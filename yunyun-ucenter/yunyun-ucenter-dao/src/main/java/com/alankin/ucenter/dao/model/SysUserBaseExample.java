package com.alankin.ucenter.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SysUserBaseExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public SysUserBaseExample() {
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

        public Criteria andUserRoleIsNull() {
            addCriterion("user_role is null");
            return (Criteria) this;
        }

        public Criteria andUserRoleIsNotNull() {
            addCriterion("user_role is not null");
            return (Criteria) this;
        }

        public Criteria andUserRoleEqualTo(Byte value) {
            addCriterion("user_role =", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotEqualTo(Byte value) {
            addCriterion("user_role <>", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThan(Byte value) {
            addCriterion("user_role >", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleGreaterThanOrEqualTo(Byte value) {
            addCriterion("user_role >=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThan(Byte value) {
            addCriterion("user_role <", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleLessThanOrEqualTo(Byte value) {
            addCriterion("user_role <=", value, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleIn(List<Byte> values) {
            addCriterion("user_role in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotIn(List<Byte> values) {
            addCriterion("user_role not in", values, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleBetween(Byte value1, Byte value2) {
            addCriterion("user_role between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andUserRoleNotBetween(Byte value1, Byte value2) {
            addCriterion("user_role not between", value1, value2, "userRole");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceIsNull() {
            addCriterion("register_source is null");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceIsNotNull() {
            addCriterion("register_source is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceEqualTo(Byte value) {
            addCriterion("register_source =", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceNotEqualTo(Byte value) {
            addCriterion("register_source <>", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceGreaterThan(Byte value) {
            addCriterion("register_source >", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("register_source >=", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceLessThan(Byte value) {
            addCriterion("register_source <", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceLessThanOrEqualTo(Byte value) {
            addCriterion("register_source <=", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceIn(List<Byte> values) {
            addCriterion("register_source in", values, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceNotIn(List<Byte> values) {
            addCriterion("register_source not in", values, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceBetween(Byte value1, Byte value2) {
            addCriterion("register_source between", value1, value2, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceNotBetween(Byte value1, Byte value2) {
            addCriterion("register_source not between", value1, value2, "registerSource");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("real_name is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("real_name is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("real_name =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("real_name <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("real_name >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("real_name >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("real_name <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("real_name <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("real_name like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("real_name not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("real_name in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("real_name not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("real_name between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("real_name not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNull() {
            addCriterion("nick_name is null");
            return (Criteria) this;
        }

        public Criteria andNickNameIsNotNull() {
            addCriterion("nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andNickNameEqualTo(String value) {
            addCriterion("nick_name =", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotEqualTo(String value) {
            addCriterion("nick_name <>", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThan(String value) {
            addCriterion("nick_name >", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("nick_name >=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThan(String value) {
            addCriterion("nick_name <", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLessThanOrEqualTo(String value) {
            addCriterion("nick_name <=", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameLike(String value) {
            addCriterion("nick_name like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotLike(String value) {
            addCriterion("nick_name not like", value, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameIn(List<String> values) {
            addCriterion("nick_name in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotIn(List<String> values) {
            addCriterion("nick_name not in", values, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameBetween(String value1, String value2) {
            addCriterion("nick_name between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andNickNameNotBetween(String value1, String value2) {
            addCriterion("nick_name not between", value1, value2, "nickName");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Boolean value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Boolean value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Boolean value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Boolean value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Boolean value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Boolean> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Boolean> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Boolean value1, Boolean value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Long value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Long value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Long value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Long value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Long value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Long value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Long> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Long> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Long value1, Long value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Long value1, Long value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNull() {
            addCriterion("signature is null");
            return (Criteria) this;
        }

        public Criteria andSignatureIsNotNull() {
            addCriterion("signature is not null");
            return (Criteria) this;
        }

        public Criteria andSignatureEqualTo(String value) {
            addCriterion("signature =", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotEqualTo(String value) {
            addCriterion("signature <>", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThan(String value) {
            addCriterion("signature >", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("signature >=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThan(String value) {
            addCriterion("signature <", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLessThanOrEqualTo(String value) {
            addCriterion("signature <=", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureLike(String value) {
            addCriterion("signature like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotLike(String value) {
            addCriterion("signature not like", value, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureIn(List<String> values) {
            addCriterion("signature in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotIn(List<String> values) {
            addCriterion("signature not in", values, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureBetween(String value1, String value2) {
            addCriterion("signature between", value1, value2, "signature");
            return (Criteria) this;
        }

        public Criteria andSignatureNotBetween(String value1, String value2) {
            addCriterion("signature not between", value1, value2, "signature");
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

        public Criteria andMobileBindTimeIsNull() {
            addCriterion("mobile_bind_time is null");
            return (Criteria) this;
        }

        public Criteria andMobileBindTimeIsNotNull() {
            addCriterion("mobile_bind_time is not null");
            return (Criteria) this;
        }

        public Criteria andMobileBindTimeEqualTo(Integer value) {
            addCriterion("mobile_bind_time =", value, "mobileBindTime");
            return (Criteria) this;
        }

        public Criteria andMobileBindTimeNotEqualTo(Integer value) {
            addCriterion("mobile_bind_time <>", value, "mobileBindTime");
            return (Criteria) this;
        }

        public Criteria andMobileBindTimeGreaterThan(Integer value) {
            addCriterion("mobile_bind_time >", value, "mobileBindTime");
            return (Criteria) this;
        }

        public Criteria andMobileBindTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mobile_bind_time >=", value, "mobileBindTime");
            return (Criteria) this;
        }

        public Criteria andMobileBindTimeLessThan(Integer value) {
            addCriterion("mobile_bind_time <", value, "mobileBindTime");
            return (Criteria) this;
        }

        public Criteria andMobileBindTimeLessThanOrEqualTo(Integer value) {
            addCriterion("mobile_bind_time <=", value, "mobileBindTime");
            return (Criteria) this;
        }

        public Criteria andMobileBindTimeIn(List<Integer> values) {
            addCriterion("mobile_bind_time in", values, "mobileBindTime");
            return (Criteria) this;
        }

        public Criteria andMobileBindTimeNotIn(List<Integer> values) {
            addCriterion("mobile_bind_time not in", values, "mobileBindTime");
            return (Criteria) this;
        }

        public Criteria andMobileBindTimeBetween(Integer value1, Integer value2) {
            addCriterion("mobile_bind_time between", value1, value2, "mobileBindTime");
            return (Criteria) this;
        }

        public Criteria andMobileBindTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("mobile_bind_time not between", value1, value2, "mobileBindTime");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBindTimeIsNull() {
            addCriterion("email_bind_time is null");
            return (Criteria) this;
        }

        public Criteria andEmailBindTimeIsNotNull() {
            addCriterion("email_bind_time is not null");
            return (Criteria) this;
        }

        public Criteria andEmailBindTimeEqualTo(Integer value) {
            addCriterion("email_bind_time =", value, "emailBindTime");
            return (Criteria) this;
        }

        public Criteria andEmailBindTimeNotEqualTo(Integer value) {
            addCriterion("email_bind_time <>", value, "emailBindTime");
            return (Criteria) this;
        }

        public Criteria andEmailBindTimeGreaterThan(Integer value) {
            addCriterion("email_bind_time >", value, "emailBindTime");
            return (Criteria) this;
        }

        public Criteria andEmailBindTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("email_bind_time >=", value, "emailBindTime");
            return (Criteria) this;
        }

        public Criteria andEmailBindTimeLessThan(Integer value) {
            addCriterion("email_bind_time <", value, "emailBindTime");
            return (Criteria) this;
        }

        public Criteria andEmailBindTimeLessThanOrEqualTo(Integer value) {
            addCriterion("email_bind_time <=", value, "emailBindTime");
            return (Criteria) this;
        }

        public Criteria andEmailBindTimeIn(List<Integer> values) {
            addCriterion("email_bind_time in", values, "emailBindTime");
            return (Criteria) this;
        }

        public Criteria andEmailBindTimeNotIn(List<Integer> values) {
            addCriterion("email_bind_time not in", values, "emailBindTime");
            return (Criteria) this;
        }

        public Criteria andEmailBindTimeBetween(Integer value1, Integer value2) {
            addCriterion("email_bind_time between", value1, value2, "emailBindTime");
            return (Criteria) this;
        }

        public Criteria andEmailBindTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("email_bind_time not between", value1, value2, "emailBindTime");
            return (Criteria) this;
        }

        public Criteria andFaceIsNull() {
            addCriterion("face is null");
            return (Criteria) this;
        }

        public Criteria andFaceIsNotNull() {
            addCriterion("face is not null");
            return (Criteria) this;
        }

        public Criteria andFaceEqualTo(String value) {
            addCriterion("face =", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceNotEqualTo(String value) {
            addCriterion("face <>", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceGreaterThan(String value) {
            addCriterion("face >", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceGreaterThanOrEqualTo(String value) {
            addCriterion("face >=", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceLessThan(String value) {
            addCriterion("face <", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceLessThanOrEqualTo(String value) {
            addCriterion("face <=", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceLike(String value) {
            addCriterion("face like", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceNotLike(String value) {
            addCriterion("face not like", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceIn(List<String> values) {
            addCriterion("face in", values, "face");
            return (Criteria) this;
        }

        public Criteria andFaceNotIn(List<String> values) {
            addCriterion("face not in", values, "face");
            return (Criteria) this;
        }

        public Criteria andFaceBetween(String value1, String value2) {
            addCriterion("face between", value1, value2, "face");
            return (Criteria) this;
        }

        public Criteria andFaceNotBetween(String value1, String value2) {
            addCriterion("face not between", value1, value2, "face");
            return (Criteria) this;
        }

        public Criteria andFace200IsNull() {
            addCriterion("face200 is null");
            return (Criteria) this;
        }

        public Criteria andFace200IsNotNull() {
            addCriterion("face200 is not null");
            return (Criteria) this;
        }

        public Criteria andFace200EqualTo(String value) {
            addCriterion("face200 =", value, "face200");
            return (Criteria) this;
        }

        public Criteria andFace200NotEqualTo(String value) {
            addCriterion("face200 <>", value, "face200");
            return (Criteria) this;
        }

        public Criteria andFace200GreaterThan(String value) {
            addCriterion("face200 >", value, "face200");
            return (Criteria) this;
        }

        public Criteria andFace200GreaterThanOrEqualTo(String value) {
            addCriterion("face200 >=", value, "face200");
            return (Criteria) this;
        }

        public Criteria andFace200LessThan(String value) {
            addCriterion("face200 <", value, "face200");
            return (Criteria) this;
        }

        public Criteria andFace200LessThanOrEqualTo(String value) {
            addCriterion("face200 <=", value, "face200");
            return (Criteria) this;
        }

        public Criteria andFace200Like(String value) {
            addCriterion("face200 like", value, "face200");
            return (Criteria) this;
        }

        public Criteria andFace200NotLike(String value) {
            addCriterion("face200 not like", value, "face200");
            return (Criteria) this;
        }

        public Criteria andFace200In(List<String> values) {
            addCriterion("face200 in", values, "face200");
            return (Criteria) this;
        }

        public Criteria andFace200NotIn(List<String> values) {
            addCriterion("face200 not in", values, "face200");
            return (Criteria) this;
        }

        public Criteria andFace200Between(String value1, String value2) {
            addCriterion("face200 between", value1, value2, "face200");
            return (Criteria) this;
        }

        public Criteria andFace200NotBetween(String value1, String value2) {
            addCriterion("face200 not between", value1, value2, "face200");
            return (Criteria) this;
        }

        public Criteria andSrcfaceIsNull() {
            addCriterion("srcface is null");
            return (Criteria) this;
        }

        public Criteria andSrcfaceIsNotNull() {
            addCriterion("srcface is not null");
            return (Criteria) this;
        }

        public Criteria andSrcfaceEqualTo(String value) {
            addCriterion("srcface =", value, "srcface");
            return (Criteria) this;
        }

        public Criteria andSrcfaceNotEqualTo(String value) {
            addCriterion("srcface <>", value, "srcface");
            return (Criteria) this;
        }

        public Criteria andSrcfaceGreaterThan(String value) {
            addCriterion("srcface >", value, "srcface");
            return (Criteria) this;
        }

        public Criteria andSrcfaceGreaterThanOrEqualTo(String value) {
            addCriterion("srcface >=", value, "srcface");
            return (Criteria) this;
        }

        public Criteria andSrcfaceLessThan(String value) {
            addCriterion("srcface <", value, "srcface");
            return (Criteria) this;
        }

        public Criteria andSrcfaceLessThanOrEqualTo(String value) {
            addCriterion("srcface <=", value, "srcface");
            return (Criteria) this;
        }

        public Criteria andSrcfaceLike(String value) {
            addCriterion("srcface like", value, "srcface");
            return (Criteria) this;
        }

        public Criteria andSrcfaceNotLike(String value) {
            addCriterion("srcface not like", value, "srcface");
            return (Criteria) this;
        }

        public Criteria andSrcfaceIn(List<String> values) {
            addCriterion("srcface in", values, "srcface");
            return (Criteria) this;
        }

        public Criteria andSrcfaceNotIn(List<String> values) {
            addCriterion("srcface not in", values, "srcface");
            return (Criteria) this;
        }

        public Criteria andSrcfaceBetween(String value1, String value2) {
            addCriterion("srcface between", value1, value2, "srcface");
            return (Criteria) this;
        }

        public Criteria andSrcfaceNotBetween(String value1, String value2) {
            addCriterion("srcface not between", value1, value2, "srcface");
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

        public Criteria andPushTokenIsNull() {
            addCriterion("push_token is null");
            return (Criteria) this;
        }

        public Criteria andPushTokenIsNotNull() {
            addCriterion("push_token is not null");
            return (Criteria) this;
        }

        public Criteria andPushTokenEqualTo(String value) {
            addCriterion("push_token =", value, "pushToken");
            return (Criteria) this;
        }

        public Criteria andPushTokenNotEqualTo(String value) {
            addCriterion("push_token <>", value, "pushToken");
            return (Criteria) this;
        }

        public Criteria andPushTokenGreaterThan(String value) {
            addCriterion("push_token >", value, "pushToken");
            return (Criteria) this;
        }

        public Criteria andPushTokenGreaterThanOrEqualTo(String value) {
            addCriterion("push_token >=", value, "pushToken");
            return (Criteria) this;
        }

        public Criteria andPushTokenLessThan(String value) {
            addCriterion("push_token <", value, "pushToken");
            return (Criteria) this;
        }

        public Criteria andPushTokenLessThanOrEqualTo(String value) {
            addCriterion("push_token <=", value, "pushToken");
            return (Criteria) this;
        }

        public Criteria andPushTokenLike(String value) {
            addCriterion("push_token like", value, "pushToken");
            return (Criteria) this;
        }

        public Criteria andPushTokenNotLike(String value) {
            addCriterion("push_token not like", value, "pushToken");
            return (Criteria) this;
        }

        public Criteria andPushTokenIn(List<String> values) {
            addCriterion("push_token in", values, "pushToken");
            return (Criteria) this;
        }

        public Criteria andPushTokenNotIn(List<String> values) {
            addCriterion("push_token not in", values, "pushToken");
            return (Criteria) this;
        }

        public Criteria andPushTokenBetween(String value1, String value2) {
            addCriterion("push_token between", value1, value2, "pushToken");
            return (Criteria) this;
        }

        public Criteria andPushTokenNotBetween(String value1, String value2) {
            addCriterion("push_token not between", value1, value2, "pushToken");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Boolean value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Boolean value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Boolean value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Boolean value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Boolean value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Boolean> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Boolean> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Boolean value1, Boolean value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andWchatIdIsNull() {
            addCriterion("wchat_id is null");
            return (Criteria) this;
        }

        public Criteria andWchatIdIsNotNull() {
            addCriterion("wchat_id is not null");
            return (Criteria) this;
        }

        public Criteria andWchatIdEqualTo(String value) {
            addCriterion("wchat_id =", value, "wchatId");
            return (Criteria) this;
        }

        public Criteria andWchatIdNotEqualTo(String value) {
            addCriterion("wchat_id <>", value, "wchatId");
            return (Criteria) this;
        }

        public Criteria andWchatIdGreaterThan(String value) {
            addCriterion("wchat_id >", value, "wchatId");
            return (Criteria) this;
        }

        public Criteria andWchatIdGreaterThanOrEqualTo(String value) {
            addCriterion("wchat_id >=", value, "wchatId");
            return (Criteria) this;
        }

        public Criteria andWchatIdLessThan(String value) {
            addCriterion("wchat_id <", value, "wchatId");
            return (Criteria) this;
        }

        public Criteria andWchatIdLessThanOrEqualTo(String value) {
            addCriterion("wchat_id <=", value, "wchatId");
            return (Criteria) this;
        }

        public Criteria andWchatIdLike(String value) {
            addCriterion("wchat_id like", value, "wchatId");
            return (Criteria) this;
        }

        public Criteria andWchatIdNotLike(String value) {
            addCriterion("wchat_id not like", value, "wchatId");
            return (Criteria) this;
        }

        public Criteria andWchatIdIn(List<String> values) {
            addCriterion("wchat_id in", values, "wchatId");
            return (Criteria) this;
        }

        public Criteria andWchatIdNotIn(List<String> values) {
            addCriterion("wchat_id not in", values, "wchatId");
            return (Criteria) this;
        }

        public Criteria andWchatIdBetween(String value1, String value2) {
            addCriterion("wchat_id between", value1, value2, "wchatId");
            return (Criteria) this;
        }

        public Criteria andWchatIdNotBetween(String value1, String value2) {
            addCriterion("wchat_id not between", value1, value2, "wchatId");
            return (Criteria) this;
        }

        public Criteria andWchatQrcodeIsNull() {
            addCriterion("wchat_qrcode is null");
            return (Criteria) this;
        }

        public Criteria andWchatQrcodeIsNotNull() {
            addCriterion("wchat_qrcode is not null");
            return (Criteria) this;
        }

        public Criteria andWchatQrcodeEqualTo(Long value) {
            addCriterion("wchat_qrcode =", value, "wchatQrcode");
            return (Criteria) this;
        }

        public Criteria andWchatQrcodeNotEqualTo(Long value) {
            addCriterion("wchat_qrcode <>", value, "wchatQrcode");
            return (Criteria) this;
        }

        public Criteria andWchatQrcodeGreaterThan(Long value) {
            addCriterion("wchat_qrcode >", value, "wchatQrcode");
            return (Criteria) this;
        }

        public Criteria andWchatQrcodeGreaterThanOrEqualTo(Long value) {
            addCriterion("wchat_qrcode >=", value, "wchatQrcode");
            return (Criteria) this;
        }

        public Criteria andWchatQrcodeLessThan(Long value) {
            addCriterion("wchat_qrcode <", value, "wchatQrcode");
            return (Criteria) this;
        }

        public Criteria andWchatQrcodeLessThanOrEqualTo(Long value) {
            addCriterion("wchat_qrcode <=", value, "wchatQrcode");
            return (Criteria) this;
        }

        public Criteria andWchatQrcodeIn(List<Long> values) {
            addCriterion("wchat_qrcode in", values, "wchatQrcode");
            return (Criteria) this;
        }

        public Criteria andWchatQrcodeNotIn(List<Long> values) {
            addCriterion("wchat_qrcode not in", values, "wchatQrcode");
            return (Criteria) this;
        }

        public Criteria andWchatQrcodeBetween(Long value1, Long value2) {
            addCriterion("wchat_qrcode between", value1, value2, "wchatQrcode");
            return (Criteria) this;
        }

        public Criteria andWchatQrcodeNotBetween(Long value1, Long value2) {
            addCriterion("wchat_qrcode not between", value1, value2, "wchatQrcode");
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