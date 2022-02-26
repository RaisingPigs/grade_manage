package com.pan.bean;

import java.util.ArrayList;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAdmIdIsNull() {
            addCriterion("adm_id is null");
            return (Criteria) this;
        }

        public Criteria andAdmIdIsNotNull() {
            addCriterion("adm_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdmIdEqualTo(Integer value) {
            addCriterion("adm_id =", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdNotEqualTo(Integer value) {
            addCriterion("adm_id <>", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdGreaterThan(Integer value) {
            addCriterion("adm_id >", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("adm_id >=", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdLessThan(Integer value) {
            addCriterion("adm_id <", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdLessThanOrEqualTo(Integer value) {
            addCriterion("adm_id <=", value, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdIn(List<Integer> values) {
            addCriterion("adm_id in", values, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdNotIn(List<Integer> values) {
            addCriterion("adm_id not in", values, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdBetween(Integer value1, Integer value2) {
            addCriterion("adm_id between", value1, value2, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmIdNotBetween(Integer value1, Integer value2) {
            addCriterion("adm_id not between", value1, value2, "admId");
            return (Criteria) this;
        }

        public Criteria andAdmNameIsNull() {
            addCriterion("adm_name is null");
            return (Criteria) this;
        }

        public Criteria andAdmNameIsNotNull() {
            addCriterion("adm_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdmNameEqualTo(String value) {
            addCriterion("adm_name =", value, "admName");
            return (Criteria) this;
        }

        public Criteria andAdmNameNotEqualTo(String value) {
            addCriterion("adm_name <>", value, "admName");
            return (Criteria) this;
        }

        public Criteria andAdmNameGreaterThan(String value) {
            addCriterion("adm_name >", value, "admName");
            return (Criteria) this;
        }

        public Criteria andAdmNameGreaterThanOrEqualTo(String value) {
            addCriterion("adm_name >=", value, "admName");
            return (Criteria) this;
        }

        public Criteria andAdmNameLessThan(String value) {
            addCriterion("adm_name <", value, "admName");
            return (Criteria) this;
        }

        public Criteria andAdmNameLessThanOrEqualTo(String value) {
            addCriterion("adm_name <=", value, "admName");
            return (Criteria) this;
        }

        public Criteria andAdmNameLike(String value) {
            addCriterion("adm_name like", value, "admName");
            return (Criteria) this;
        }

        public Criteria andAdmNameNotLike(String value) {
            addCriterion("adm_name not like", value, "admName");
            return (Criteria) this;
        }

        public Criteria andAdmNameIn(List<String> values) {
            addCriterion("adm_name in", values, "admName");
            return (Criteria) this;
        }

        public Criteria andAdmNameNotIn(List<String> values) {
            addCriterion("adm_name not in", values, "admName");
            return (Criteria) this;
        }

        public Criteria andAdmNameBetween(String value1, String value2) {
            addCriterion("adm_name between", value1, value2, "admName");
            return (Criteria) this;
        }

        public Criteria andAdmNameNotBetween(String value1, String value2) {
            addCriterion("adm_name not between", value1, value2, "admName");
            return (Criteria) this;
        }

        public Criteria andAdmSexIsNull() {
            addCriterion("adm_sex is null");
            return (Criteria) this;
        }

        public Criteria andAdmSexIsNotNull() {
            addCriterion("adm_sex is not null");
            return (Criteria) this;
        }

        public Criteria andAdmSexEqualTo(String value) {
            addCriterion("adm_sex =", value, "admSex");
            return (Criteria) this;
        }

        public Criteria andAdmSexNotEqualTo(String value) {
            addCriterion("adm_sex <>", value, "admSex");
            return (Criteria) this;
        }

        public Criteria andAdmSexGreaterThan(String value) {
            addCriterion("adm_sex >", value, "admSex");
            return (Criteria) this;
        }

        public Criteria andAdmSexGreaterThanOrEqualTo(String value) {
            addCriterion("adm_sex >=", value, "admSex");
            return (Criteria) this;
        }

        public Criteria andAdmSexLessThan(String value) {
            addCriterion("adm_sex <", value, "admSex");
            return (Criteria) this;
        }

        public Criteria andAdmSexLessThanOrEqualTo(String value) {
            addCriterion("adm_sex <=", value, "admSex");
            return (Criteria) this;
        }

        public Criteria andAdmSexLike(String value) {
            addCriterion("adm_sex like", value, "admSex");
            return (Criteria) this;
        }

        public Criteria andAdmSexNotLike(String value) {
            addCriterion("adm_sex not like", value, "admSex");
            return (Criteria) this;
        }

        public Criteria andAdmSexIn(List<String> values) {
            addCriterion("adm_sex in", values, "admSex");
            return (Criteria) this;
        }

        public Criteria andAdmSexNotIn(List<String> values) {
            addCriterion("adm_sex not in", values, "admSex");
            return (Criteria) this;
        }

        public Criteria andAdmSexBetween(String value1, String value2) {
            addCriterion("adm_sex between", value1, value2, "admSex");
            return (Criteria) this;
        }

        public Criteria andAdmSexNotBetween(String value1, String value2) {
            addCriterion("adm_sex not between", value1, value2, "admSex");
            return (Criteria) this;
        }

        public Criteria andAdmAgeIsNull() {
            addCriterion("adm_age is null");
            return (Criteria) this;
        }

        public Criteria andAdmAgeIsNotNull() {
            addCriterion("adm_age is not null");
            return (Criteria) this;
        }

        public Criteria andAdmAgeEqualTo(Integer value) {
            addCriterion("adm_age =", value, "admAge");
            return (Criteria) this;
        }

        public Criteria andAdmAgeNotEqualTo(Integer value) {
            addCriterion("adm_age <>", value, "admAge");
            return (Criteria) this;
        }

        public Criteria andAdmAgeGreaterThan(Integer value) {
            addCriterion("adm_age >", value, "admAge");
            return (Criteria) this;
        }

        public Criteria andAdmAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("adm_age >=", value, "admAge");
            return (Criteria) this;
        }

        public Criteria andAdmAgeLessThan(Integer value) {
            addCriterion("adm_age <", value, "admAge");
            return (Criteria) this;
        }

        public Criteria andAdmAgeLessThanOrEqualTo(Integer value) {
            addCriterion("adm_age <=", value, "admAge");
            return (Criteria) this;
        }

        public Criteria andAdmAgeIn(List<Integer> values) {
            addCriterion("adm_age in", values, "admAge");
            return (Criteria) this;
        }

        public Criteria andAdmAgeNotIn(List<Integer> values) {
            addCriterion("adm_age not in", values, "admAge");
            return (Criteria) this;
        }

        public Criteria andAdmAgeBetween(Integer value1, Integer value2) {
            addCriterion("adm_age between", value1, value2, "admAge");
            return (Criteria) this;
        }

        public Criteria andAdmAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("adm_age not between", value1, value2, "admAge");
            return (Criteria) this;
        }

        public Criteria andAdmFacultyIsNull() {
            addCriterion("adm_faculty is null");
            return (Criteria) this;
        }

        public Criteria andAdmFacultyIsNotNull() {
            addCriterion("adm_faculty is not null");
            return (Criteria) this;
        }

        public Criteria andAdmFacultyEqualTo(String value) {
            addCriterion("adm_faculty =", value, "admFaculty");
            return (Criteria) this;
        }

        public Criteria andAdmFacultyNotEqualTo(String value) {
            addCriterion("adm_faculty <>", value, "admFaculty");
            return (Criteria) this;
        }

        public Criteria andAdmFacultyGreaterThan(String value) {
            addCriterion("adm_faculty >", value, "admFaculty");
            return (Criteria) this;
        }

        public Criteria andAdmFacultyGreaterThanOrEqualTo(String value) {
            addCriterion("adm_faculty >=", value, "admFaculty");
            return (Criteria) this;
        }

        public Criteria andAdmFacultyLessThan(String value) {
            addCriterion("adm_faculty <", value, "admFaculty");
            return (Criteria) this;
        }

        public Criteria andAdmFacultyLessThanOrEqualTo(String value) {
            addCriterion("adm_faculty <=", value, "admFaculty");
            return (Criteria) this;
        }

        public Criteria andAdmFacultyLike(String value) {
            addCriterion("adm_faculty like", value, "admFaculty");
            return (Criteria) this;
        }

        public Criteria andAdmFacultyNotLike(String value) {
            addCriterion("adm_faculty not like", value, "admFaculty");
            return (Criteria) this;
        }

        public Criteria andAdmFacultyIn(List<String> values) {
            addCriterion("adm_faculty in", values, "admFaculty");
            return (Criteria) this;
        }

        public Criteria andAdmFacultyNotIn(List<String> values) {
            addCriterion("adm_faculty not in", values, "admFaculty");
            return (Criteria) this;
        }

        public Criteria andAdmFacultyBetween(String value1, String value2) {
            addCriterion("adm_faculty between", value1, value2, "admFaculty");
            return (Criteria) this;
        }

        public Criteria andAdmFacultyNotBetween(String value1, String value2) {
            addCriterion("adm_faculty not between", value1, value2, "admFaculty");
            return (Criteria) this;
        }

        public Criteria andAdmDepartmentIsNull() {
            addCriterion("adm_department is null");
            return (Criteria) this;
        }

        public Criteria andAdmDepartmentIsNotNull() {
            addCriterion("adm_department is not null");
            return (Criteria) this;
        }

        public Criteria andAdmDepartmentEqualTo(String value) {
            addCriterion("adm_department =", value, "admDepartment");
            return (Criteria) this;
        }

        public Criteria andAdmDepartmentNotEqualTo(String value) {
            addCriterion("adm_department <>", value, "admDepartment");
            return (Criteria) this;
        }

        public Criteria andAdmDepartmentGreaterThan(String value) {
            addCriterion("adm_department >", value, "admDepartment");
            return (Criteria) this;
        }

        public Criteria andAdmDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("adm_department >=", value, "admDepartment");
            return (Criteria) this;
        }

        public Criteria andAdmDepartmentLessThan(String value) {
            addCriterion("adm_department <", value, "admDepartment");
            return (Criteria) this;
        }

        public Criteria andAdmDepartmentLessThanOrEqualTo(String value) {
            addCriterion("adm_department <=", value, "admDepartment");
            return (Criteria) this;
        }

        public Criteria andAdmDepartmentLike(String value) {
            addCriterion("adm_department like", value, "admDepartment");
            return (Criteria) this;
        }

        public Criteria andAdmDepartmentNotLike(String value) {
            addCriterion("adm_department not like", value, "admDepartment");
            return (Criteria) this;
        }

        public Criteria andAdmDepartmentIn(List<String> values) {
            addCriterion("adm_department in", values, "admDepartment");
            return (Criteria) this;
        }

        public Criteria andAdmDepartmentNotIn(List<String> values) {
            addCriterion("adm_department not in", values, "admDepartment");
            return (Criteria) this;
        }

        public Criteria andAdmDepartmentBetween(String value1, String value2) {
            addCriterion("adm_department between", value1, value2, "admDepartment");
            return (Criteria) this;
        }

        public Criteria andAdmDepartmentNotBetween(String value1, String value2) {
            addCriterion("adm_department not between", value1, value2, "admDepartment");
            return (Criteria) this;
        }

        public Criteria andAdmPhoneIsNull() {
            addCriterion("adm_phone is null");
            return (Criteria) this;
        }

        public Criteria andAdmPhoneIsNotNull() {
            addCriterion("adm_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAdmPhoneEqualTo(String value) {
            addCriterion("adm_phone =", value, "admPhone");
            return (Criteria) this;
        }

        public Criteria andAdmPhoneNotEqualTo(String value) {
            addCriterion("adm_phone <>", value, "admPhone");
            return (Criteria) this;
        }

        public Criteria andAdmPhoneGreaterThan(String value) {
            addCriterion("adm_phone >", value, "admPhone");
            return (Criteria) this;
        }

        public Criteria andAdmPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("adm_phone >=", value, "admPhone");
            return (Criteria) this;
        }

        public Criteria andAdmPhoneLessThan(String value) {
            addCriterion("adm_phone <", value, "admPhone");
            return (Criteria) this;
        }

        public Criteria andAdmPhoneLessThanOrEqualTo(String value) {
            addCriterion("adm_phone <=", value, "admPhone");
            return (Criteria) this;
        }

        public Criteria andAdmPhoneLike(String value) {
            addCriterion("adm_phone like", value, "admPhone");
            return (Criteria) this;
        }

        public Criteria andAdmPhoneNotLike(String value) {
            addCriterion("adm_phone not like", value, "admPhone");
            return (Criteria) this;
        }

        public Criteria andAdmPhoneIn(List<String> values) {
            addCriterion("adm_phone in", values, "admPhone");
            return (Criteria) this;
        }

        public Criteria andAdmPhoneNotIn(List<String> values) {
            addCriterion("adm_phone not in", values, "admPhone");
            return (Criteria) this;
        }

        public Criteria andAdmPhoneBetween(String value1, String value2) {
            addCriterion("adm_phone between", value1, value2, "admPhone");
            return (Criteria) this;
        }

        public Criteria andAdmPhoneNotBetween(String value1, String value2) {
            addCriterion("adm_phone not between", value1, value2, "admPhone");
            return (Criteria) this;
        }

        public Criteria andAdmUsernameIsNull() {
            addCriterion("adm_username is null");
            return (Criteria) this;
        }

        public Criteria andAdmUsernameIsNotNull() {
            addCriterion("adm_username is not null");
            return (Criteria) this;
        }

        public Criteria andAdmUsernameEqualTo(String value) {
            addCriterion("adm_username =", value, "admUsername");
            return (Criteria) this;
        }

        public Criteria andAdmUsernameNotEqualTo(String value) {
            addCriterion("adm_username <>", value, "admUsername");
            return (Criteria) this;
        }

        public Criteria andAdmUsernameGreaterThan(String value) {
            addCriterion("adm_username >", value, "admUsername");
            return (Criteria) this;
        }

        public Criteria andAdmUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("adm_username >=", value, "admUsername");
            return (Criteria) this;
        }

        public Criteria andAdmUsernameLessThan(String value) {
            addCriterion("adm_username <", value, "admUsername");
            return (Criteria) this;
        }

        public Criteria andAdmUsernameLessThanOrEqualTo(String value) {
            addCriterion("adm_username <=", value, "admUsername");
            return (Criteria) this;
        }

        public Criteria andAdmUsernameLike(String value) {
            addCriterion("adm_username like", value, "admUsername");
            return (Criteria) this;
        }

        public Criteria andAdmUsernameNotLike(String value) {
            addCriterion("adm_username not like", value, "admUsername");
            return (Criteria) this;
        }

        public Criteria andAdmUsernameIn(List<String> values) {
            addCriterion("adm_username in", values, "admUsername");
            return (Criteria) this;
        }

        public Criteria andAdmUsernameNotIn(List<String> values) {
            addCriterion("adm_username not in", values, "admUsername");
            return (Criteria) this;
        }

        public Criteria andAdmUsernameBetween(String value1, String value2) {
            addCriterion("adm_username between", value1, value2, "admUsername");
            return (Criteria) this;
        }

        public Criteria andAdmUsernameNotBetween(String value1, String value2) {
            addCriterion("adm_username not between", value1, value2, "admUsername");
            return (Criteria) this;
        }

        public Criteria andAdmPasswordIsNull() {
            addCriterion("adm_password is null");
            return (Criteria) this;
        }

        public Criteria andAdmPasswordIsNotNull() {
            addCriterion("adm_password is not null");
            return (Criteria) this;
        }

        public Criteria andAdmPasswordEqualTo(String value) {
            addCriterion("adm_password =", value, "admPassword");
            return (Criteria) this;
        }

        public Criteria andAdmPasswordNotEqualTo(String value) {
            addCriterion("adm_password <>", value, "admPassword");
            return (Criteria) this;
        }

        public Criteria andAdmPasswordGreaterThan(String value) {
            addCriterion("adm_password >", value, "admPassword");
            return (Criteria) this;
        }

        public Criteria andAdmPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("adm_password >=", value, "admPassword");
            return (Criteria) this;
        }

        public Criteria andAdmPasswordLessThan(String value) {
            addCriterion("adm_password <", value, "admPassword");
            return (Criteria) this;
        }

        public Criteria andAdmPasswordLessThanOrEqualTo(String value) {
            addCriterion("adm_password <=", value, "admPassword");
            return (Criteria) this;
        }

        public Criteria andAdmPasswordLike(String value) {
            addCriterion("adm_password like", value, "admPassword");
            return (Criteria) this;
        }

        public Criteria andAdmPasswordNotLike(String value) {
            addCriterion("adm_password not like", value, "admPassword");
            return (Criteria) this;
        }

        public Criteria andAdmPasswordIn(List<String> values) {
            addCriterion("adm_password in", values, "admPassword");
            return (Criteria) this;
        }

        public Criteria andAdmPasswordNotIn(List<String> values) {
            addCriterion("adm_password not in", values, "admPassword");
            return (Criteria) this;
        }

        public Criteria andAdmPasswordBetween(String value1, String value2) {
            addCriterion("adm_password between", value1, value2, "admPassword");
            return (Criteria) this;
        }

        public Criteria andAdmPasswordNotBetween(String value1, String value2) {
            addCriterion("adm_password not between", value1, value2, "admPassword");
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