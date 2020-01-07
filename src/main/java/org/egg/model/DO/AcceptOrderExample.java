package org.egg.model.DO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcceptOrderExample extends LimitExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AcceptOrderExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNull() {
            addCriterion("user_no is null");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNotNull() {
            addCriterion("user_no is not null");
            return (Criteria) this;
        }

        public Criteria andUserNoEqualTo(String value) {
            addCriterion("user_no =", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotEqualTo(String value) {
            addCriterion("user_no <>", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThan(String value) {
            addCriterion("user_no >", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("user_no >=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThan(String value) {
            addCriterion("user_no <", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThanOrEqualTo(String value) {
            addCriterion("user_no <=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLike(String value) {
            addCriterion("user_no like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotLike(String value) {
            addCriterion("user_no not like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoIn(List<String> values) {
            addCriterion("user_no in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotIn(List<String> values) {
            addCriterion("user_no not in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoBetween(String value1, String value2) {
            addCriterion("user_no between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotBetween(String value1, String value2) {
            addCriterion("user_no not between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andPubOrderNoIsNull() {
            addCriterion("pub_order_no is null");
            return (Criteria) this;
        }

        public Criteria andPubOrderNoIsNotNull() {
            addCriterion("pub_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andPubOrderNoEqualTo(String value) {
            addCriterion("pub_order_no =", value, "pubOrderNo");
            return (Criteria) this;
        }

        public Criteria andPubOrderNoNotEqualTo(String value) {
            addCriterion("pub_order_no <>", value, "pubOrderNo");
            return (Criteria) this;
        }

        public Criteria andPubOrderNoGreaterThan(String value) {
            addCriterion("pub_order_no >", value, "pubOrderNo");
            return (Criteria) this;
        }

        public Criteria andPubOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("pub_order_no >=", value, "pubOrderNo");
            return (Criteria) this;
        }

        public Criteria andPubOrderNoLessThan(String value) {
            addCriterion("pub_order_no <", value, "pubOrderNo");
            return (Criteria) this;
        }

        public Criteria andPubOrderNoLessThanOrEqualTo(String value) {
            addCriterion("pub_order_no <=", value, "pubOrderNo");
            return (Criteria) this;
        }

        public Criteria andPubOrderNoLike(String value) {
            addCriterion("pub_order_no like", value, "pubOrderNo");
            return (Criteria) this;
        }

        public Criteria andPubOrderNoNotLike(String value) {
            addCriterion("pub_order_no not like", value, "pubOrderNo");
            return (Criteria) this;
        }

        public Criteria andPubOrderNoIn(List<String> values) {
            addCriterion("pub_order_no in", values, "pubOrderNo");
            return (Criteria) this;
        }

        public Criteria andPubOrderNoNotIn(List<String> values) {
            addCriterion("pub_order_no not in", values, "pubOrderNo");
            return (Criteria) this;
        }

        public Criteria andPubOrderNoBetween(String value1, String value2) {
            addCriterion("pub_order_no between", value1, value2, "pubOrderNo");
            return (Criteria) this;
        }

        public Criteria andPubOrderNoNotBetween(String value1, String value2) {
            addCriterion("pub_order_no not between", value1, value2, "pubOrderNo");
            return (Criteria) this;
        }

        public Criteria andTimeDelayIsNull() {
            addCriterion("time_delay is null");
            return (Criteria) this;
        }

        public Criteria andTimeDelayIsNotNull() {
            addCriterion("time_delay is not null");
            return (Criteria) this;
        }

        public Criteria andTimeDelayEqualTo(Date value) {
            addCriterion("time_delay =", value, "timeDelay");
            return (Criteria) this;
        }

        public Criteria andTimeDelayNotEqualTo(Date value) {
            addCriterion("time_delay <>", value, "timeDelay");
            return (Criteria) this;
        }

        public Criteria andTimeDelayGreaterThan(Date value) {
            addCriterion("time_delay >", value, "timeDelay");
            return (Criteria) this;
        }

        public Criteria andTimeDelayGreaterThanOrEqualTo(Date value) {
            addCriterion("time_delay >=", value, "timeDelay");
            return (Criteria) this;
        }

        public Criteria andTimeDelayLessThan(Date value) {
            addCriterion("time_delay <", value, "timeDelay");
            return (Criteria) this;
        }

        public Criteria andTimeDelayLessThanOrEqualTo(Date value) {
            addCriterion("time_delay <=", value, "timeDelay");
            return (Criteria) this;
        }

        public Criteria andTimeDelayIn(List<Date> values) {
            addCriterion("time_delay in", values, "timeDelay");
            return (Criteria) this;
        }

        public Criteria andTimeDelayNotIn(List<Date> values) {
            addCriterion("time_delay not in", values, "timeDelay");
            return (Criteria) this;
        }

        public Criteria andTimeDelayBetween(Date value1, Date value2) {
            addCriterion("time_delay between", value1, value2, "timeDelay");
            return (Criteria) this;
        }

        public Criteria andTimeDelayNotBetween(Date value1, Date value2) {
            addCriterion("time_delay not between", value1, value2, "timeDelay");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNull() {
            addCriterion("cancel_reason is null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNotNull() {
            addCriterion("cancel_reason is not null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonEqualTo(String value) {
            addCriterion("cancel_reason =", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotEqualTo(String value) {
            addCriterion("cancel_reason <>", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThan(String value) {
            addCriterion("cancel_reason >", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_reason >=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThan(String value) {
            addCriterion("cancel_reason <", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThanOrEqualTo(String value) {
            addCriterion("cancel_reason <=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLike(String value) {
            addCriterion("cancel_reason like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotLike(String value) {
            addCriterion("cancel_reason not like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIn(List<String> values) {
            addCriterion("cancel_reason in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotIn(List<String> values) {
            addCriterion("cancel_reason not in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonBetween(String value1, String value2) {
            addCriterion("cancel_reason between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotBetween(String value1, String value2) {
            addCriterion("cancel_reason not between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andAmoutIsNull() {
            addCriterion("amout is null");
            return (Criteria) this;
        }

        public Criteria andAmoutIsNotNull() {
            addCriterion("amout is not null");
            return (Criteria) this;
        }

        public Criteria andAmoutEqualTo(BigDecimal value) {
            addCriterion("amout =", value, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutNotEqualTo(BigDecimal value) {
            addCriterion("amout <>", value, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutGreaterThan(BigDecimal value) {
            addCriterion("amout >", value, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amout >=", value, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutLessThan(BigDecimal value) {
            addCriterion("amout <", value, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amout <=", value, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutIn(List<BigDecimal> values) {
            addCriterion("amout in", values, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutNotIn(List<BigDecimal> values) {
            addCriterion("amout not in", values, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amout between", value1, value2, "amout");
            return (Criteria) this;
        }

        public Criteria andAmoutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amout not between", value1, value2, "amout");
            return (Criteria) this;
        }

        public Criteria andPubPriceIsNull() {
            addCriterion("pub_price is null");
            return (Criteria) this;
        }

        public Criteria andPubPriceIsNotNull() {
            addCriterion("pub_price is not null");
            return (Criteria) this;
        }

        public Criteria andPubPriceEqualTo(BigDecimal value) {
            addCriterion("pub_price =", value, "pubPrice");
            return (Criteria) this;
        }

        public Criteria andPubPriceNotEqualTo(BigDecimal value) {
            addCriterion("pub_price <>", value, "pubPrice");
            return (Criteria) this;
        }

        public Criteria andPubPriceGreaterThan(BigDecimal value) {
            addCriterion("pub_price >", value, "pubPrice");
            return (Criteria) this;
        }

        public Criteria andPubPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pub_price >=", value, "pubPrice");
            return (Criteria) this;
        }

        public Criteria andPubPriceLessThan(BigDecimal value) {
            addCriterion("pub_price <", value, "pubPrice");
            return (Criteria) this;
        }

        public Criteria andPubPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pub_price <=", value, "pubPrice");
            return (Criteria) this;
        }

        public Criteria andPubPriceIn(List<BigDecimal> values) {
            addCriterion("pub_price in", values, "pubPrice");
            return (Criteria) this;
        }

        public Criteria andPubPriceNotIn(List<BigDecimal> values) {
            addCriterion("pub_price not in", values, "pubPrice");
            return (Criteria) this;
        }

        public Criteria andPubPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pub_price between", value1, value2, "pubPrice");
            return (Criteria) this;
        }

        public Criteria andPubPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pub_price not between", value1, value2, "pubPrice");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNull() {
            addCriterion("created_date is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIsNotNull() {
            addCriterion("created_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDateEqualTo(Date value) {
            addCriterion("created_date =", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotEqualTo(Date value) {
            addCriterion("created_date <>", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThan(Date value) {
            addCriterion("created_date >", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("created_date >=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThan(Date value) {
            addCriterion("created_date <", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateLessThanOrEqualTo(Date value) {
            addCriterion("created_date <=", value, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateIn(List<Date> values) {
            addCriterion("created_date in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotIn(List<Date> values) {
            addCriterion("created_date not in", values, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateBetween(Date value1, Date value2) {
            addCriterion("created_date between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andCreatedDateNotBetween(Date value1, Date value2) {
            addCriterion("created_date not between", value1, value2, "createdDate");
            return (Criteria) this;
        }

        public Criteria andFinishedDateIsNull() {
            addCriterion("finished_date is null");
            return (Criteria) this;
        }

        public Criteria andFinishedDateIsNotNull() {
            addCriterion("finished_date is not null");
            return (Criteria) this;
        }

        public Criteria andFinishedDateEqualTo(Date value) {
            addCriterion("finished_date =", value, "finishedDate");
            return (Criteria) this;
        }

        public Criteria andFinishedDateNotEqualTo(Date value) {
            addCriterion("finished_date <>", value, "finishedDate");
            return (Criteria) this;
        }

        public Criteria andFinishedDateGreaterThan(Date value) {
            addCriterion("finished_date >", value, "finishedDate");
            return (Criteria) this;
        }

        public Criteria andFinishedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("finished_date >=", value, "finishedDate");
            return (Criteria) this;
        }

        public Criteria andFinishedDateLessThan(Date value) {
            addCriterion("finished_date <", value, "finishedDate");
            return (Criteria) this;
        }

        public Criteria andFinishedDateLessThanOrEqualTo(Date value) {
            addCriterion("finished_date <=", value, "finishedDate");
            return (Criteria) this;
        }

        public Criteria andFinishedDateIn(List<Date> values) {
            addCriterion("finished_date in", values, "finishedDate");
            return (Criteria) this;
        }

        public Criteria andFinishedDateNotIn(List<Date> values) {
            addCriterion("finished_date not in", values, "finishedDate");
            return (Criteria) this;
        }

        public Criteria andFinishedDateBetween(Date value1, Date value2) {
            addCriterion("finished_date between", value1, value2, "finishedDate");
            return (Criteria) this;
        }

        public Criteria andFinishedDateNotBetween(Date value1, Date value2) {
            addCriterion("finished_date not between", value1, value2, "finishedDate");
            return (Criteria) this;
        }

        public Criteria andMofiedDateIsNull() {
            addCriterion("mofied_date is null");
            return (Criteria) this;
        }

        public Criteria andMofiedDateIsNotNull() {
            addCriterion("mofied_date is not null");
            return (Criteria) this;
        }

        public Criteria andMofiedDateEqualTo(Date value) {
            addCriterion("mofied_date =", value, "mofiedDate");
            return (Criteria) this;
        }

        public Criteria andMofiedDateNotEqualTo(Date value) {
            addCriterion("mofied_date <>", value, "mofiedDate");
            return (Criteria) this;
        }

        public Criteria andMofiedDateGreaterThan(Date value) {
            addCriterion("mofied_date >", value, "mofiedDate");
            return (Criteria) this;
        }

        public Criteria andMofiedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("mofied_date >=", value, "mofiedDate");
            return (Criteria) this;
        }

        public Criteria andMofiedDateLessThan(Date value) {
            addCriterion("mofied_date <", value, "mofiedDate");
            return (Criteria) this;
        }

        public Criteria andMofiedDateLessThanOrEqualTo(Date value) {
            addCriterion("mofied_date <=", value, "mofiedDate");
            return (Criteria) this;
        }

        public Criteria andMofiedDateIn(List<Date> values) {
            addCriterion("mofied_date in", values, "mofiedDate");
            return (Criteria) this;
        }

        public Criteria andMofiedDateNotIn(List<Date> values) {
            addCriterion("mofied_date not in", values, "mofiedDate");
            return (Criteria) this;
        }

        public Criteria andMofiedDateBetween(Date value1, Date value2) {
            addCriterion("mofied_date between", value1, value2, "mofiedDate");
            return (Criteria) this;
        }

        public Criteria andMofiedDateNotBetween(Date value1, Date value2) {
            addCriterion("mofied_date not between", value1, value2, "mofiedDate");
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