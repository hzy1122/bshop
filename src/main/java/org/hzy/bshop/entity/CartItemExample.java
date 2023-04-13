package org.hzy.bshop.entity;

import java.util.ArrayList;
import java.util.List;

public class CartItemExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    public CartItemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
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
     * This method corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
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

        public Criteria andRacketIdIsNull() {
            addCriterion("racket_id is null");
            return (Criteria) this;
        }

        public Criteria andRacketIdIsNotNull() {
            addCriterion("racket_id is not null");
            return (Criteria) this;
        }

        public Criteria andRacketIdEqualTo(Integer value) {
            addCriterion("racket_id =", value, "racketId");
            return (Criteria) this;
        }

        public Criteria andRacketIdNotEqualTo(Integer value) {
            addCriterion("racket_id <>", value, "racketId");
            return (Criteria) this;
        }

        public Criteria andRacketIdGreaterThan(Integer value) {
            addCriterion("racket_id >", value, "racketId");
            return (Criteria) this;
        }

        public Criteria andRacketIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("racket_id >=", value, "racketId");
            return (Criteria) this;
        }

        public Criteria andRacketIdLessThan(Integer value) {
            addCriterion("racket_id <", value, "racketId");
            return (Criteria) this;
        }

        public Criteria andRacketIdLessThanOrEqualTo(Integer value) {
            addCriterion("racket_id <=", value, "racketId");
            return (Criteria) this;
        }

        public Criteria andRacketIdIn(List<Integer> values) {
            addCriterion("racket_id in", values, "racketId");
            return (Criteria) this;
        }

        public Criteria andRacketIdNotIn(List<Integer> values) {
            addCriterion("racket_id not in", values, "racketId");
            return (Criteria) this;
        }

        public Criteria andRacketIdBetween(Integer value1, Integer value2) {
            addCriterion("racket_id between", value1, value2, "racketId");
            return (Criteria) this;
        }

        public Criteria andRacketIdNotBetween(Integer value1, Integer value2) {
            addCriterion("racket_id not between", value1, value2, "racketId");
            return (Criteria) this;
        }

        public Criteria andBadmintonIdIsNull() {
            addCriterion("badminton_id is null");
            return (Criteria) this;
        }

        public Criteria andBadmintonIdIsNotNull() {
            addCriterion("badminton_id is not null");
            return (Criteria) this;
        }

        public Criteria andBadmintonIdEqualTo(Integer value) {
            addCriterion("badminton_id =", value, "badmintonId");
            return (Criteria) this;
        }

        public Criteria andBadmintonIdNotEqualTo(Integer value) {
            addCriterion("badminton_id <>", value, "badmintonId");
            return (Criteria) this;
        }

        public Criteria andBadmintonIdGreaterThan(Integer value) {
            addCriterion("badminton_id >", value, "badmintonId");
            return (Criteria) this;
        }

        public Criteria andBadmintonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("badminton_id >=", value, "badmintonId");
            return (Criteria) this;
        }

        public Criteria andBadmintonIdLessThan(Integer value) {
            addCriterion("badminton_id <", value, "badmintonId");
            return (Criteria) this;
        }

        public Criteria andBadmintonIdLessThanOrEqualTo(Integer value) {
            addCriterion("badminton_id <=", value, "badmintonId");
            return (Criteria) this;
        }

        public Criteria andBadmintonIdIn(List<Integer> values) {
            addCriterion("badminton_id in", values, "badmintonId");
            return (Criteria) this;
        }

        public Criteria andBadmintonIdNotIn(List<Integer> values) {
            addCriterion("badminton_id not in", values, "badmintonId");
            return (Criteria) this;
        }

        public Criteria andBadmintonIdBetween(Integer value1, Integer value2) {
            addCriterion("badminton_id between", value1, value2, "badmintonId");
            return (Criteria) this;
        }

        public Criteria andBadmintonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("badminton_id not between", value1, value2, "badmintonId");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNull() {
            addCriterion("item_price is null");
            return (Criteria) this;
        }

        public Criteria andItemPriceIsNotNull() {
            addCriterion("item_price is not null");
            return (Criteria) this;
        }

        public Criteria andItemPriceEqualTo(Double value) {
            addCriterion("item_price =", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotEqualTo(Double value) {
            addCriterion("item_price <>", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThan(Double value) {
            addCriterion("item_price >", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("item_price >=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThan(Double value) {
            addCriterion("item_price <", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceLessThanOrEqualTo(Double value) {
            addCriterion("item_price <=", value, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceIn(List<Double> values) {
            addCriterion("item_price in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotIn(List<Double> values) {
            addCriterion("item_price not in", values, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceBetween(Double value1, Double value2) {
            addCriterion("item_price between", value1, value2, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andItemPriceNotBetween(Double value1, Double value2) {
            addCriterion("item_price not between", value1, value2, "itemPrice");
            return (Criteria) this;
        }

        public Criteria andCartIdIsNull() {
            addCriterion("cart_id is null");
            return (Criteria) this;
        }

        public Criteria andCartIdIsNotNull() {
            addCriterion("cart_id is not null");
            return (Criteria) this;
        }

        public Criteria andCartIdEqualTo(Integer value) {
            addCriterion("cart_id =", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotEqualTo(Integer value) {
            addCriterion("cart_id <>", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThan(Integer value) {
            addCriterion("cart_id >", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_id >=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThan(Integer value) {
            addCriterion("cart_id <", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThanOrEqualTo(Integer value) {
            addCriterion("cart_id <=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdIn(List<Integer> values) {
            addCriterion("cart_id in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotIn(List<Integer> values) {
            addCriterion("cart_id not in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdBetween(Integer value1, Integer value2) {
            addCriterion("cart_id between", value1, value2, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_id not between", value1, value2, "cartId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_cart_item
     *
     * @mbg.generated do_not_delete_during_merge Sat Mar 25 10:12:48 GMT+08:00 2023
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_cart_item
     *
     * @mbg.generated Sat Mar 25 10:12:48 GMT+08:00 2023
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