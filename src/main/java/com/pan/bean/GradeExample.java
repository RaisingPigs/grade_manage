package com.pan.bean;

import java.util.ArrayList;
import java.util.List;

public class GradeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GradeExample() {
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

        public Criteria andSIdIsNull() {
            addCriterion("s_id is null");
            return (Criteria) this;
        }

        public Criteria andSIdIsNotNull() {
            addCriterion("s_id is not null");
            return (Criteria) this;
        }

        public Criteria andSIdEqualTo(Integer value) {
            addCriterion("s_id =", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotEqualTo(Integer value) {
            addCriterion("s_id <>", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThan(Integer value) {
            addCriterion("s_id >", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("s_id >=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThan(Integer value) {
            addCriterion("s_id <", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdLessThanOrEqualTo(Integer value) {
            addCriterion("s_id <=", value, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdIn(List<Integer> values) {
            addCriterion("s_id in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotIn(List<Integer> values) {
            addCriterion("s_id not in", values, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdBetween(Integer value1, Integer value2) {
            addCriterion("s_id between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andSIdNotBetween(Integer value1, Integer value2) {
            addCriterion("s_id not between", value1, value2, "sId");
            return (Criteria) this;
        }

        public Criteria andJavaIsNull() {
            addCriterion("java is null");
            return (Criteria) this;
        }

        public Criteria andJavaIsNotNull() {
            addCriterion("java is not null");
            return (Criteria) this;
        }

        public Criteria andJavaEqualTo(Integer value) {
            addCriterion("java =", value, "java");
            return (Criteria) this;
        }

        public Criteria andJavaNotEqualTo(Integer value) {
            addCriterion("java <>", value, "java");
            return (Criteria) this;
        }

        public Criteria andJavaGreaterThan(Integer value) {
            addCriterion("java >", value, "java");
            return (Criteria) this;
        }

        public Criteria andJavaGreaterThanOrEqualTo(Integer value) {
            addCriterion("java >=", value, "java");
            return (Criteria) this;
        }

        public Criteria andJavaLessThan(Integer value) {
            addCriterion("java <", value, "java");
            return (Criteria) this;
        }

        public Criteria andJavaLessThanOrEqualTo(Integer value) {
            addCriterion("java <=", value, "java");
            return (Criteria) this;
        }

        public Criteria andJavaIn(List<Integer> values) {
            addCriterion("java in", values, "java");
            return (Criteria) this;
        }

        public Criteria andJavaNotIn(List<Integer> values) {
            addCriterion("java not in", values, "java");
            return (Criteria) this;
        }

        public Criteria andJavaBetween(Integer value1, Integer value2) {
            addCriterion("java between", value1, value2, "java");
            return (Criteria) this;
        }

        public Criteria andJavaNotBetween(Integer value1, Integer value2) {
            addCriterion("java not between", value1, value2, "java");
            return (Criteria) this;
        }

        public Criteria andCIsNull() {
            addCriterion("c is null");
            return (Criteria) this;
        }

        public Criteria andCIsNotNull() {
            addCriterion("c is not null");
            return (Criteria) this;
        }

        public Criteria andCEqualTo(Integer value) {
            addCriterion("c =", value, "c");
            return (Criteria) this;
        }

        public Criteria andCNotEqualTo(Integer value) {
            addCriterion("c <>", value, "c");
            return (Criteria) this;
        }

        public Criteria andCGreaterThan(Integer value) {
            addCriterion("c >", value, "c");
            return (Criteria) this;
        }

        public Criteria andCGreaterThanOrEqualTo(Integer value) {
            addCriterion("c >=", value, "c");
            return (Criteria) this;
        }

        public Criteria andCLessThan(Integer value) {
            addCriterion("c <", value, "c");
            return (Criteria) this;
        }

        public Criteria andCLessThanOrEqualTo(Integer value) {
            addCriterion("c <=", value, "c");
            return (Criteria) this;
        }

        public Criteria andCIn(List<Integer> values) {
            addCriterion("c in", values, "c");
            return (Criteria) this;
        }

        public Criteria andCNotIn(List<Integer> values) {
            addCriterion("c not in", values, "c");
            return (Criteria) this;
        }

        public Criteria andCBetween(Integer value1, Integer value2) {
            addCriterion("c between", value1, value2, "c");
            return (Criteria) this;
        }

        public Criteria andCNotBetween(Integer value1, Integer value2) {
            addCriterion("c not between", value1, value2, "c");
            return (Criteria) this;
        }

        public Criteria andCppIsNull() {
            addCriterion("cpp is null");
            return (Criteria) this;
        }

        public Criteria andCppIsNotNull() {
            addCriterion("cpp is not null");
            return (Criteria) this;
        }

        public Criteria andCppEqualTo(Integer value) {
            addCriterion("cpp =", value, "cpp");
            return (Criteria) this;
        }

        public Criteria andCppNotEqualTo(Integer value) {
            addCriterion("cpp <>", value, "cpp");
            return (Criteria) this;
        }

        public Criteria andCppGreaterThan(Integer value) {
            addCriterion("cpp >", value, "cpp");
            return (Criteria) this;
        }

        public Criteria andCppGreaterThanOrEqualTo(Integer value) {
            addCriterion("cpp >=", value, "cpp");
            return (Criteria) this;
        }

        public Criteria andCppLessThan(Integer value) {
            addCriterion("cpp <", value, "cpp");
            return (Criteria) this;
        }

        public Criteria andCppLessThanOrEqualTo(Integer value) {
            addCriterion("cpp <=", value, "cpp");
            return (Criteria) this;
        }

        public Criteria andCppIn(List<Integer> values) {
            addCriterion("cpp in", values, "cpp");
            return (Criteria) this;
        }

        public Criteria andCppNotIn(List<Integer> values) {
            addCriterion("cpp not in", values, "cpp");
            return (Criteria) this;
        }

        public Criteria andCppBetween(Integer value1, Integer value2) {
            addCriterion("cpp between", value1, value2, "cpp");
            return (Criteria) this;
        }

        public Criteria andCppNotBetween(Integer value1, Integer value2) {
            addCriterion("cpp not between", value1, value2, "cpp");
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