package com.shineon.coder.db.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShineonUserAttachedExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
    public ShineonUserAttachedExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
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

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andTimelastloginIsNull() {
            addCriterion("timeLastLogin is null");
            return (Criteria) this;
        }

        public Criteria andTimelastloginIsNotNull() {
            addCriterion("timeLastLogin is not null");
            return (Criteria) this;
        }

        public Criteria andTimelastloginEqualTo(Date value) {
            addCriterion("timeLastLogin =", value, "timelastlogin");
            return (Criteria) this;
        }

        public Criteria andTimelastloginNotEqualTo(Date value) {
            addCriterion("timeLastLogin <>", value, "timelastlogin");
            return (Criteria) this;
        }

        public Criteria andTimelastloginGreaterThan(Date value) {
            addCriterion("timeLastLogin >", value, "timelastlogin");
            return (Criteria) this;
        }

        public Criteria andTimelastloginGreaterThanOrEqualTo(Date value) {
            addCriterion("timeLastLogin >=", value, "timelastlogin");
            return (Criteria) this;
        }

        public Criteria andTimelastloginLessThan(Date value) {
            addCriterion("timeLastLogin <", value, "timelastlogin");
            return (Criteria) this;
        }

        public Criteria andTimelastloginLessThanOrEqualTo(Date value) {
            addCriterion("timeLastLogin <=", value, "timelastlogin");
            return (Criteria) this;
        }

        public Criteria andTimelastloginIn(List<Date> values) {
            addCriterion("timeLastLogin in", values, "timelastlogin");
            return (Criteria) this;
        }

        public Criteria andTimelastloginNotIn(List<Date> values) {
            addCriterion("timeLastLogin not in", values, "timelastlogin");
            return (Criteria) this;
        }

        public Criteria andTimelastloginBetween(Date value1, Date value2) {
            addCriterion("timeLastLogin between", value1, value2, "timelastlogin");
            return (Criteria) this;
        }

        public Criteria andTimelastloginNotBetween(Date value1, Date value2) {
            addCriterion("timeLastLogin not between", value1, value2, "timelastlogin");
            return (Criteria) this;
        }

        public Criteria andIplastloginIsNull() {
            addCriterion("ipLastLogin is null");
            return (Criteria) this;
        }

        public Criteria andIplastloginIsNotNull() {
            addCriterion("ipLastLogin is not null");
            return (Criteria) this;
        }

        public Criteria andIplastloginEqualTo(Date value) {
            addCriterion("ipLastLogin =", value, "iplastlogin");
            return (Criteria) this;
        }

        public Criteria andIplastloginNotEqualTo(Date value) {
            addCriterion("ipLastLogin <>", value, "iplastlogin");
            return (Criteria) this;
        }

        public Criteria andIplastloginGreaterThan(Date value) {
            addCriterion("ipLastLogin >", value, "iplastlogin");
            return (Criteria) this;
        }

        public Criteria andIplastloginGreaterThanOrEqualTo(Date value) {
            addCriterion("ipLastLogin >=", value, "iplastlogin");
            return (Criteria) this;
        }

        public Criteria andIplastloginLessThan(Date value) {
            addCriterion("ipLastLogin <", value, "iplastlogin");
            return (Criteria) this;
        }

        public Criteria andIplastloginLessThanOrEqualTo(Date value) {
            addCriterion("ipLastLogin <=", value, "iplastlogin");
            return (Criteria) this;
        }

        public Criteria andIplastloginIn(List<Date> values) {
            addCriterion("ipLastLogin in", values, "iplastlogin");
            return (Criteria) this;
        }

        public Criteria andIplastloginNotIn(List<Date> values) {
            addCriterion("ipLastLogin not in", values, "iplastlogin");
            return (Criteria) this;
        }

        public Criteria andIplastloginBetween(Date value1, Date value2) {
            addCriterion("ipLastLogin between", value1, value2, "iplastlogin");
            return (Criteria) this;
        }

        public Criteria andIplastloginNotBetween(Date value1, Date value2) {
            addCriterion("ipLastLogin not between", value1, value2, "iplastlogin");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table shineon_user_attached
     *
     * @mbggenerated do_not_delete_during_merge Thu Jun 20 16:36:21 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Thu Jun 20 16:36:21 CST 2019
     */
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