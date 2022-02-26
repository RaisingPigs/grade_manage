package com.pan.bean;

import java.util.ArrayList;
import java.util.List;

public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
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

        public Criteria andTchIdIsNull() {
            addCriterion("tch_id is null");
            return (Criteria) this;
        }

        public Criteria andTchIdIsNotNull() {
            addCriterion("tch_id is not null");
            return (Criteria) this;
        }

        public Criteria andTchIdEqualTo(Integer value) {
            addCriterion("tch_id =", value, "tchId");
            return (Criteria) this;
        }

        public Criteria andTchIdNotEqualTo(Integer value) {
            addCriterion("tch_id <>", value, "tchId");
            return (Criteria) this;
        }

        public Criteria andTchIdGreaterThan(Integer value) {
            addCriterion("tch_id >", value, "tchId");
            return (Criteria) this;
        }

        public Criteria andTchIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tch_id >=", value, "tchId");
            return (Criteria) this;
        }

        public Criteria andTchIdLessThan(Integer value) {
            addCriterion("tch_id <", value, "tchId");
            return (Criteria) this;
        }

        public Criteria andTchIdLessThanOrEqualTo(Integer value) {
            addCriterion("tch_id <=", value, "tchId");
            return (Criteria) this;
        }

        public Criteria andTchIdIn(List<Integer> values) {
            addCriterion("tch_id in", values, "tchId");
            return (Criteria) this;
        }

        public Criteria andTchIdNotIn(List<Integer> values) {
            addCriterion("tch_id not in", values, "tchId");
            return (Criteria) this;
        }

        public Criteria andTchIdBetween(Integer value1, Integer value2) {
            addCriterion("tch_id between", value1, value2, "tchId");
            return (Criteria) this;
        }

        public Criteria andTchIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tch_id not between", value1, value2, "tchId");
            return (Criteria) this;
        }

        public Criteria andTchNameIsNull() {
            addCriterion("tch_name is null");
            return (Criteria) this;
        }

        public Criteria andTchNameIsNotNull() {
            addCriterion("tch_name is not null");
            return (Criteria) this;
        }

        public Criteria andTchNameEqualTo(String value) {
            addCriterion("tch_name =", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameNotEqualTo(String value) {
            addCriterion("tch_name <>", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameGreaterThan(String value) {
            addCriterion("tch_name >", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameGreaterThanOrEqualTo(String value) {
            addCriterion("tch_name >=", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameLessThan(String value) {
            addCriterion("tch_name <", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameLessThanOrEqualTo(String value) {
            addCriterion("tch_name <=", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameLike(String value) {
            addCriterion("tch_name like", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameNotLike(String value) {
            addCriterion("tch_name not like", value, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameIn(List<String> values) {
            addCriterion("tch_name in", values, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameNotIn(List<String> values) {
            addCriterion("tch_name not in", values, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameBetween(String value1, String value2) {
            addCriterion("tch_name between", value1, value2, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchNameNotBetween(String value1, String value2) {
            addCriterion("tch_name not between", value1, value2, "tchName");
            return (Criteria) this;
        }

        public Criteria andTchSexIsNull() {
            addCriterion("tch_sex is null");
            return (Criteria) this;
        }

        public Criteria andTchSexIsNotNull() {
            addCriterion("tch_sex is not null");
            return (Criteria) this;
        }

        public Criteria andTchSexEqualTo(String value) {
            addCriterion("tch_sex =", value, "tchSex");
            return (Criteria) this;
        }

        public Criteria andTchSexNotEqualTo(String value) {
            addCriterion("tch_sex <>", value, "tchSex");
            return (Criteria) this;
        }

        public Criteria andTchSexGreaterThan(String value) {
            addCriterion("tch_sex >", value, "tchSex");
            return (Criteria) this;
        }

        public Criteria andTchSexGreaterThanOrEqualTo(String value) {
            addCriterion("tch_sex >=", value, "tchSex");
            return (Criteria) this;
        }

        public Criteria andTchSexLessThan(String value) {
            addCriterion("tch_sex <", value, "tchSex");
            return (Criteria) this;
        }

        public Criteria andTchSexLessThanOrEqualTo(String value) {
            addCriterion("tch_sex <=", value, "tchSex");
            return (Criteria) this;
        }

        public Criteria andTchSexLike(String value) {
            addCriterion("tch_sex like", value, "tchSex");
            return (Criteria) this;
        }

        public Criteria andTchSexNotLike(String value) {
            addCriterion("tch_sex not like", value, "tchSex");
            return (Criteria) this;
        }

        public Criteria andTchSexIn(List<String> values) {
            addCriterion("tch_sex in", values, "tchSex");
            return (Criteria) this;
        }

        public Criteria andTchSexNotIn(List<String> values) {
            addCriterion("tch_sex not in", values, "tchSex");
            return (Criteria) this;
        }

        public Criteria andTchSexBetween(String value1, String value2) {
            addCriterion("tch_sex between", value1, value2, "tchSex");
            return (Criteria) this;
        }

        public Criteria andTchSexNotBetween(String value1, String value2) {
            addCriterion("tch_sex not between", value1, value2, "tchSex");
            return (Criteria) this;
        }

        public Criteria andTchAgeIsNull() {
            addCriterion("tch_age is null");
            return (Criteria) this;
        }

        public Criteria andTchAgeIsNotNull() {
            addCriterion("tch_age is not null");
            return (Criteria) this;
        }

        public Criteria andTchAgeEqualTo(Integer value) {
            addCriterion("tch_age =", value, "tchAge");
            return (Criteria) this;
        }

        public Criteria andTchAgeNotEqualTo(Integer value) {
            addCriterion("tch_age <>", value, "tchAge");
            return (Criteria) this;
        }

        public Criteria andTchAgeGreaterThan(Integer value) {
            addCriterion("tch_age >", value, "tchAge");
            return (Criteria) this;
        }

        public Criteria andTchAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("tch_age >=", value, "tchAge");
            return (Criteria) this;
        }

        public Criteria andTchAgeLessThan(Integer value) {
            addCriterion("tch_age <", value, "tchAge");
            return (Criteria) this;
        }

        public Criteria andTchAgeLessThanOrEqualTo(Integer value) {
            addCriterion("tch_age <=", value, "tchAge");
            return (Criteria) this;
        }

        public Criteria andTchAgeIn(List<Integer> values) {
            addCriterion("tch_age in", values, "tchAge");
            return (Criteria) this;
        }

        public Criteria andTchAgeNotIn(List<Integer> values) {
            addCriterion("tch_age not in", values, "tchAge");
            return (Criteria) this;
        }

        public Criteria andTchAgeBetween(Integer value1, Integer value2) {
            addCriterion("tch_age between", value1, value2, "tchAge");
            return (Criteria) this;
        }

        public Criteria andTchAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("tch_age not between", value1, value2, "tchAge");
            return (Criteria) this;
        }

        public Criteria andTchClassIsNull() {
            addCriterion("tch_class is null");
            return (Criteria) this;
        }

        public Criteria andTchClassIsNotNull() {
            addCriterion("tch_class is not null");
            return (Criteria) this;
        }

        public Criteria andTchClassEqualTo(Integer value) {
            addCriterion("tch_class =", value, "tchClass");
            return (Criteria) this;
        }

        public Criteria andTchClassNotEqualTo(Integer value) {
            addCriterion("tch_class <>", value, "tchClass");
            return (Criteria) this;
        }

        public Criteria andTchClassGreaterThan(Integer value) {
            addCriterion("tch_class >", value, "tchClass");
            return (Criteria) this;
        }

        public Criteria andTchClassGreaterThanOrEqualTo(Integer value) {
            addCriterion("tch_class >=", value, "tchClass");
            return (Criteria) this;
        }

        public Criteria andTchClassLessThan(Integer value) {
            addCriterion("tch_class <", value, "tchClass");
            return (Criteria) this;
        }

        public Criteria andTchClassLessThanOrEqualTo(Integer value) {
            addCriterion("tch_class <=", value, "tchClass");
            return (Criteria) this;
        }

        public Criteria andTchClassIn(List<Integer> values) {
            addCriterion("tch_class in", values, "tchClass");
            return (Criteria) this;
        }

        public Criteria andTchClassNotIn(List<Integer> values) {
            addCriterion("tch_class not in", values, "tchClass");
            return (Criteria) this;
        }

        public Criteria andTchClassBetween(Integer value1, Integer value2) {
            addCriterion("tch_class between", value1, value2, "tchClass");
            return (Criteria) this;
        }

        public Criteria andTchClassNotBetween(Integer value1, Integer value2) {
            addCriterion("tch_class not between", value1, value2, "tchClass");
            return (Criteria) this;
        }

        public Criteria andCNameIsNull() {
            addCriterion("c_name is null");
            return (Criteria) this;
        }

        public Criteria andCNameIsNotNull() {
            addCriterion("c_name is not null");
            return (Criteria) this;
        }

        public Criteria andCNameEqualTo(String value) {
            addCriterion("c_name =", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotEqualTo(String value) {
            addCriterion("c_name <>", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThan(String value) {
            addCriterion("c_name >", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThanOrEqualTo(String value) {
            addCriterion("c_name >=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThan(String value) {
            addCriterion("c_name <", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThanOrEqualTo(String value) {
            addCriterion("c_name <=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLike(String value) {
            addCriterion("c_name like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotLike(String value) {
            addCriterion("c_name not like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameIn(List<String> values) {
            addCriterion("c_name in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotIn(List<String> values) {
            addCriterion("c_name not in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameBetween(String value1, String value2) {
            addCriterion("c_name between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotBetween(String value1, String value2) {
            addCriterion("c_name not between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andTchPwdIsNull() {
            addCriterion("tch_pwd is null");
            return (Criteria) this;
        }

        public Criteria andTchPwdIsNotNull() {
            addCriterion("tch_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andTchPwdEqualTo(String value) {
            addCriterion("tch_pwd =", value, "tchPwd");
            return (Criteria) this;
        }

        public Criteria andTchPwdNotEqualTo(String value) {
            addCriterion("tch_pwd <>", value, "tchPwd");
            return (Criteria) this;
        }

        public Criteria andTchPwdGreaterThan(String value) {
            addCriterion("tch_pwd >", value, "tchPwd");
            return (Criteria) this;
        }

        public Criteria andTchPwdGreaterThanOrEqualTo(String value) {
            addCriterion("tch_pwd >=", value, "tchPwd");
            return (Criteria) this;
        }

        public Criteria andTchPwdLessThan(String value) {
            addCriterion("tch_pwd <", value, "tchPwd");
            return (Criteria) this;
        }

        public Criteria andTchPwdLessThanOrEqualTo(String value) {
            addCriterion("tch_pwd <=", value, "tchPwd");
            return (Criteria) this;
        }

        public Criteria andTchPwdLike(String value) {
            addCriterion("tch_pwd like", value, "tchPwd");
            return (Criteria) this;
        }

        public Criteria andTchPwdNotLike(String value) {
            addCriterion("tch_pwd not like", value, "tchPwd");
            return (Criteria) this;
        }

        public Criteria andTchPwdIn(List<String> values) {
            addCriterion("tch_pwd in", values, "tchPwd");
            return (Criteria) this;
        }

        public Criteria andTchPwdNotIn(List<String> values) {
            addCriterion("tch_pwd not in", values, "tchPwd");
            return (Criteria) this;
        }

        public Criteria andTchPwdBetween(String value1, String value2) {
            addCriterion("tch_pwd between", value1, value2, "tchPwd");
            return (Criteria) this;
        }

        public Criteria andTchPwdNotBetween(String value1, String value2) {
            addCriterion("tch_pwd not between", value1, value2, "tchPwd");
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