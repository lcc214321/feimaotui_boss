package org.egg.model.DO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PubOrderExample extends LimitExample{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PubOrderExample() {
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

        public Criteria andWeigthIsNull() {
            addCriterion("weigth is null");
            return (Criteria) this;
        }

        public Criteria andWeigthIsNotNull() {
            addCriterion("weigth is not null");
            return (Criteria) this;
        }

        public Criteria andWeigthEqualTo(String value) {
            addCriterion("weigth =", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthNotEqualTo(String value) {
            addCriterion("weigth <>", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthGreaterThan(String value) {
            addCriterion("weigth >", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthGreaterThanOrEqualTo(String value) {
            addCriterion("weigth >=", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthLessThan(String value) {
            addCriterion("weigth <", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthLessThanOrEqualTo(String value) {
            addCriterion("weigth <=", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthLike(String value) {
            addCriterion("weigth like", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthNotLike(String value) {
            addCriterion("weigth not like", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthIn(List<String> values) {
            addCriterion("weigth in", values, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthNotIn(List<String> values) {
            addCriterion("weigth not in", values, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthBetween(String value1, String value2) {
            addCriterion("weigth between", value1, value2, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthNotBetween(String value1, String value2) {
            addCriterion("weigth not between", value1, value2, "weigth");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andKdTypeIsNull() {
            addCriterion("kd_type is null");
            return (Criteria) this;
        }

        public Criteria andKdTypeIsNotNull() {
            addCriterion("kd_type is not null");
            return (Criteria) this;
        }

        public Criteria andKdTypeEqualTo(String value) {
            addCriterion("kd_type =", value, "kdType");
            return (Criteria) this;
        }

        public Criteria andKdTypeNotEqualTo(String value) {
            addCriterion("kd_type <>", value, "kdType");
            return (Criteria) this;
        }

        public Criteria andKdTypeGreaterThan(String value) {
            addCriterion("kd_type >", value, "kdType");
            return (Criteria) this;
        }

        public Criteria andKdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("kd_type >=", value, "kdType");
            return (Criteria) this;
        }

        public Criteria andKdTypeLessThan(String value) {
            addCriterion("kd_type <", value, "kdType");
            return (Criteria) this;
        }

        public Criteria andKdTypeLessThanOrEqualTo(String value) {
            addCriterion("kd_type <=", value, "kdType");
            return (Criteria) this;
        }

        public Criteria andKdTypeLike(String value) {
            addCriterion("kd_type like", value, "kdType");
            return (Criteria) this;
        }

        public Criteria andKdTypeNotLike(String value) {
            addCriterion("kd_type not like", value, "kdType");
            return (Criteria) this;
        }

        public Criteria andKdTypeIn(List<String> values) {
            addCriterion("kd_type in", values, "kdType");
            return (Criteria) this;
        }

        public Criteria andKdTypeNotIn(List<String> values) {
            addCriterion("kd_type not in", values, "kdType");
            return (Criteria) this;
        }

        public Criteria andKdTypeBetween(String value1, String value2) {
            addCriterion("kd_type between", value1, value2, "kdType");
            return (Criteria) this;
        }

        public Criteria andKdTypeNotBetween(String value1, String value2) {
            addCriterion("kd_type not between", value1, value2, "kdType");
            return (Criteria) this;
        }

        public Criteria andAddressGetIsNull() {
            addCriterion("address_get is null");
            return (Criteria) this;
        }

        public Criteria andAddressGetIsNotNull() {
            addCriterion("address_get is not null");
            return (Criteria) this;
        }

        public Criteria andAddressGetEqualTo(String value) {
            addCriterion("address_get =", value, "addressGet");
            return (Criteria) this;
        }

        public Criteria andAddressGetNotEqualTo(String value) {
            addCriterion("address_get <>", value, "addressGet");
            return (Criteria) this;
        }

        public Criteria andAddressGetGreaterThan(String value) {
            addCriterion("address_get >", value, "addressGet");
            return (Criteria) this;
        }

        public Criteria andAddressGetGreaterThanOrEqualTo(String value) {
            addCriterion("address_get >=", value, "addressGet");
            return (Criteria) this;
        }

        public Criteria andAddressGetLessThan(String value) {
            addCriterion("address_get <", value, "addressGet");
            return (Criteria) this;
        }

        public Criteria andAddressGetLessThanOrEqualTo(String value) {
            addCriterion("address_get <=", value, "addressGet");
            return (Criteria) this;
        }

        public Criteria andAddressGetLike(String value) {
            addCriterion("address_get like", value, "addressGet");
            return (Criteria) this;
        }

        public Criteria andAddressGetNotLike(String value) {
            addCriterion("address_get not like", value, "addressGet");
            return (Criteria) this;
        }

        public Criteria andAddressGetIn(List<String> values) {
            addCriterion("address_get in", values, "addressGet");
            return (Criteria) this;
        }

        public Criteria andAddressGetNotIn(List<String> values) {
            addCriterion("address_get not in", values, "addressGet");
            return (Criteria) this;
        }

        public Criteria andAddressGetBetween(String value1, String value2) {
            addCriterion("address_get between", value1, value2, "addressGet");
            return (Criteria) this;
        }

        public Criteria andAddressGetNotBetween(String value1, String value2) {
            addCriterion("address_get not between", value1, value2, "addressGet");
            return (Criteria) this;
        }

        public Criteria andGetLongitudeIsNull() {
            addCriterion("get_longitude is null");
            return (Criteria) this;
        }

        public Criteria andGetLongitudeIsNotNull() {
            addCriterion("get_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andGetLongitudeEqualTo(String value) {
            addCriterion("get_longitude =", value, "getLongitude");
            return (Criteria) this;
        }

        public Criteria andGetLongitudeNotEqualTo(String value) {
            addCriterion("get_longitude <>", value, "getLongitude");
            return (Criteria) this;
        }

        public Criteria andGetLongitudeGreaterThan(String value) {
            addCriterion("get_longitude >", value, "getLongitude");
            return (Criteria) this;
        }

        public Criteria andGetLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("get_longitude >=", value, "getLongitude");
            return (Criteria) this;
        }

        public Criteria andGetLongitudeLessThan(String value) {
            addCriterion("get_longitude <", value, "getLongitude");
            return (Criteria) this;
        }

        public Criteria andGetLongitudeLessThanOrEqualTo(String value) {
            addCriterion("get_longitude <=", value, "getLongitude");
            return (Criteria) this;
        }

        public Criteria andGetLongitudeLike(String value) {
            addCriterion("get_longitude like", value, "getLongitude");
            return (Criteria) this;
        }

        public Criteria andGetLongitudeNotLike(String value) {
            addCriterion("get_longitude not like", value, "getLongitude");
            return (Criteria) this;
        }

        public Criteria andGetLongitudeIn(List<String> values) {
            addCriterion("get_longitude in", values, "getLongitude");
            return (Criteria) this;
        }

        public Criteria andGetLongitudeNotIn(List<String> values) {
            addCriterion("get_longitude not in", values, "getLongitude");
            return (Criteria) this;
        }

        public Criteria andGetLongitudeBetween(String value1, String value2) {
            addCriterion("get_longitude between", value1, value2, "getLongitude");
            return (Criteria) this;
        }

        public Criteria andGetLongitudeNotBetween(String value1, String value2) {
            addCriterion("get_longitude not between", value1, value2, "getLongitude");
            return (Criteria) this;
        }

        public Criteria andGetLatitudeIsNull() {
            addCriterion("get_latitude is null");
            return (Criteria) this;
        }

        public Criteria andGetLatitudeIsNotNull() {
            addCriterion("get_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andGetLatitudeEqualTo(String value) {
            addCriterion("get_latitude =", value, "getLatitude");
            return (Criteria) this;
        }

        public Criteria andGetLatitudeNotEqualTo(String value) {
            addCriterion("get_latitude <>", value, "getLatitude");
            return (Criteria) this;
        }

        public Criteria andGetLatitudeGreaterThan(String value) {
            addCriterion("get_latitude >", value, "getLatitude");
            return (Criteria) this;
        }

        public Criteria andGetLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("get_latitude >=", value, "getLatitude");
            return (Criteria) this;
        }

        public Criteria andGetLatitudeLessThan(String value) {
            addCriterion("get_latitude <", value, "getLatitude");
            return (Criteria) this;
        }

        public Criteria andGetLatitudeLessThanOrEqualTo(String value) {
            addCriterion("get_latitude <=", value, "getLatitude");
            return (Criteria) this;
        }

        public Criteria andGetLatitudeLike(String value) {
            addCriterion("get_latitude like", value, "getLatitude");
            return (Criteria) this;
        }

        public Criteria andGetLatitudeNotLike(String value) {
            addCriterion("get_latitude not like", value, "getLatitude");
            return (Criteria) this;
        }

        public Criteria andGetLatitudeIn(List<String> values) {
            addCriterion("get_latitude in", values, "getLatitude");
            return (Criteria) this;
        }

        public Criteria andGetLatitudeNotIn(List<String> values) {
            addCriterion("get_latitude not in", values, "getLatitude");
            return (Criteria) this;
        }

        public Criteria andGetLatitudeBetween(String value1, String value2) {
            addCriterion("get_latitude between", value1, value2, "getLatitude");
            return (Criteria) this;
        }

        public Criteria andGetLatitudeNotBetween(String value1, String value2) {
            addCriterion("get_latitude not between", value1, value2, "getLatitude");
            return (Criteria) this;
        }

        public Criteria andScoNoIsNull() {
            addCriterion("sco_no is null");
            return (Criteria) this;
        }

        public Criteria andScoNoIsNotNull() {
            addCriterion("sco_no is not null");
            return (Criteria) this;
        }

        public Criteria andScoNoEqualTo(String value) {
            addCriterion("sco_no =", value, "scoNo");
            return (Criteria) this;
        }

        public Criteria andScoNoNotEqualTo(String value) {
            addCriterion("sco_no <>", value, "scoNo");
            return (Criteria) this;
        }

        public Criteria andScoNoGreaterThan(String value) {
            addCriterion("sco_no >", value, "scoNo");
            return (Criteria) this;
        }

        public Criteria andScoNoGreaterThanOrEqualTo(String value) {
            addCriterion("sco_no >=", value, "scoNo");
            return (Criteria) this;
        }

        public Criteria andScoNoLessThan(String value) {
            addCriterion("sco_no <", value, "scoNo");
            return (Criteria) this;
        }

        public Criteria andScoNoLessThanOrEqualTo(String value) {
            addCriterion("sco_no <=", value, "scoNo");
            return (Criteria) this;
        }

        public Criteria andScoNoLike(String value) {
            addCriterion("sco_no like", value, "scoNo");
            return (Criteria) this;
        }

        public Criteria andScoNoNotLike(String value) {
            addCriterion("sco_no not like", value, "scoNo");
            return (Criteria) this;
        }

        public Criteria andScoNoIn(List<String> values) {
            addCriterion("sco_no in", values, "scoNo");
            return (Criteria) this;
        }

        public Criteria andScoNoNotIn(List<String> values) {
            addCriterion("sco_no not in", values, "scoNo");
            return (Criteria) this;
        }

        public Criteria andScoNoBetween(String value1, String value2) {
            addCriterion("sco_no between", value1, value2, "scoNo");
            return (Criteria) this;
        }

        public Criteria andScoNoNotBetween(String value1, String value2) {
            addCriterion("sco_no not between", value1, value2, "scoNo");
            return (Criteria) this;
        }

        public Criteria andAddressServicesIsNull() {
            addCriterion("address_services is null");
            return (Criteria) this;
        }

        public Criteria andAddressServicesIsNotNull() {
            addCriterion("address_services is not null");
            return (Criteria) this;
        }

        public Criteria andAddressServicesEqualTo(String value) {
            addCriterion("address_services =", value, "addressServices");
            return (Criteria) this;
        }

        public Criteria andAddressServicesNotEqualTo(String value) {
            addCriterion("address_services <>", value, "addressServices");
            return (Criteria) this;
        }

        public Criteria andAddressServicesGreaterThan(String value) {
            addCriterion("address_services >", value, "addressServices");
            return (Criteria) this;
        }

        public Criteria andAddressServicesGreaterThanOrEqualTo(String value) {
            addCriterion("address_services >=", value, "addressServices");
            return (Criteria) this;
        }

        public Criteria andAddressServicesLessThan(String value) {
            addCriterion("address_services <", value, "addressServices");
            return (Criteria) this;
        }

        public Criteria andAddressServicesLessThanOrEqualTo(String value) {
            addCriterion("address_services <=", value, "addressServices");
            return (Criteria) this;
        }

        public Criteria andAddressServicesLike(String value) {
            addCriterion("address_services like", value, "addressServices");
            return (Criteria) this;
        }

        public Criteria andAddressServicesNotLike(String value) {
            addCriterion("address_services not like", value, "addressServices");
            return (Criteria) this;
        }

        public Criteria andAddressServicesIn(List<String> values) {
            addCriterion("address_services in", values, "addressServices");
            return (Criteria) this;
        }

        public Criteria andAddressServicesNotIn(List<String> values) {
            addCriterion("address_services not in", values, "addressServices");
            return (Criteria) this;
        }

        public Criteria andAddressServicesBetween(String value1, String value2) {
            addCriterion("address_services between", value1, value2, "addressServices");
            return (Criteria) this;
        }

        public Criteria andAddressServicesNotBetween(String value1, String value2) {
            addCriterion("address_services not between", value1, value2, "addressServices");
            return (Criteria) this;
        }

        public Criteria andSerLongitudeIsNull() {
            addCriterion("ser_longitude is null");
            return (Criteria) this;
        }

        public Criteria andSerLongitudeIsNotNull() {
            addCriterion("ser_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andSerLongitudeEqualTo(String value) {
            addCriterion("ser_longitude =", value, "serLongitude");
            return (Criteria) this;
        }

        public Criteria andSerLongitudeNotEqualTo(String value) {
            addCriterion("ser_longitude <>", value, "serLongitude");
            return (Criteria) this;
        }

        public Criteria andSerLongitudeGreaterThan(String value) {
            addCriterion("ser_longitude >", value, "serLongitude");
            return (Criteria) this;
        }

        public Criteria andSerLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("ser_longitude >=", value, "serLongitude");
            return (Criteria) this;
        }

        public Criteria andSerLongitudeLessThan(String value) {
            addCriterion("ser_longitude <", value, "serLongitude");
            return (Criteria) this;
        }

        public Criteria andSerLongitudeLessThanOrEqualTo(String value) {
            addCriterion("ser_longitude <=", value, "serLongitude");
            return (Criteria) this;
        }

        public Criteria andSerLongitudeLike(String value) {
            addCriterion("ser_longitude like", value, "serLongitude");
            return (Criteria) this;
        }

        public Criteria andSerLongitudeNotLike(String value) {
            addCriterion("ser_longitude not like", value, "serLongitude");
            return (Criteria) this;
        }

        public Criteria andSerLongitudeIn(List<String> values) {
            addCriterion("ser_longitude in", values, "serLongitude");
            return (Criteria) this;
        }

        public Criteria andSerLongitudeNotIn(List<String> values) {
            addCriterion("ser_longitude not in", values, "serLongitude");
            return (Criteria) this;
        }

        public Criteria andSerLongitudeBetween(String value1, String value2) {
            addCriterion("ser_longitude between", value1, value2, "serLongitude");
            return (Criteria) this;
        }

        public Criteria andSerLongitudeNotBetween(String value1, String value2) {
            addCriterion("ser_longitude not between", value1, value2, "serLongitude");
            return (Criteria) this;
        }

        public Criteria andSerLatitudeIsNull() {
            addCriterion("ser_latitude is null");
            return (Criteria) this;
        }

        public Criteria andSerLatitudeIsNotNull() {
            addCriterion("ser_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andSerLatitudeEqualTo(String value) {
            addCriterion("ser_latitude =", value, "serLatitude");
            return (Criteria) this;
        }

        public Criteria andSerLatitudeNotEqualTo(String value) {
            addCriterion("ser_latitude <>", value, "serLatitude");
            return (Criteria) this;
        }

        public Criteria andSerLatitudeGreaterThan(String value) {
            addCriterion("ser_latitude >", value, "serLatitude");
            return (Criteria) this;
        }

        public Criteria andSerLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("ser_latitude >=", value, "serLatitude");
            return (Criteria) this;
        }

        public Criteria andSerLatitudeLessThan(String value) {
            addCriterion("ser_latitude <", value, "serLatitude");
            return (Criteria) this;
        }

        public Criteria andSerLatitudeLessThanOrEqualTo(String value) {
            addCriterion("ser_latitude <=", value, "serLatitude");
            return (Criteria) this;
        }

        public Criteria andSerLatitudeLike(String value) {
            addCriterion("ser_latitude like", value, "serLatitude");
            return (Criteria) this;
        }

        public Criteria andSerLatitudeNotLike(String value) {
            addCriterion("ser_latitude not like", value, "serLatitude");
            return (Criteria) this;
        }

        public Criteria andSerLatitudeIn(List<String> values) {
            addCriterion("ser_latitude in", values, "serLatitude");
            return (Criteria) this;
        }

        public Criteria andSerLatitudeNotIn(List<String> values) {
            addCriterion("ser_latitude not in", values, "serLatitude");
            return (Criteria) this;
        }

        public Criteria andSerLatitudeBetween(String value1, String value2) {
            addCriterion("ser_latitude between", value1, value2, "serLatitude");
            return (Criteria) this;
        }

        public Criteria andSerLatitudeNotBetween(String value1, String value2) {
            addCriterion("ser_latitude not between", value1, value2, "serLatitude");
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

        public Criteria andModifiedDateIsNull() {
            addCriterion("modified_date is null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateIsNotNull() {
            addCriterion("modified_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifiedDateEqualTo(Date value) {
            addCriterion("modified_date =", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateNotEqualTo(Date value) {
            addCriterion("modified_date <>", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateGreaterThan(Date value) {
            addCriterion("modified_date >", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modified_date >=", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateLessThan(Date value) {
            addCriterion("modified_date <", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateLessThanOrEqualTo(Date value) {
            addCriterion("modified_date <=", value, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateIn(List<Date> values) {
            addCriterion("modified_date in", values, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateNotIn(List<Date> values) {
            addCriterion("modified_date not in", values, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateBetween(Date value1, Date value2) {
            addCriterion("modified_date between", value1, value2, "modifiedDate");
            return (Criteria) this;
        }

        public Criteria andModifiedDateNotBetween(Date value1, Date value2) {
            addCriterion("modified_date not between", value1, value2, "modifiedDate");
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

        public Criteria andConfirmCodeIsNull() {
            addCriterion("confirm_code is null");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeIsNotNull() {
            addCriterion("confirm_code is not null");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeEqualTo(String value) {
            addCriterion("confirm_code =", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeNotEqualTo(String value) {
            addCriterion("confirm_code <>", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeGreaterThan(String value) {
            addCriterion("confirm_code >", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeGreaterThanOrEqualTo(String value) {
            addCriterion("confirm_code >=", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeLessThan(String value) {
            addCriterion("confirm_code <", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeLessThanOrEqualTo(String value) {
            addCriterion("confirm_code <=", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeLike(String value) {
            addCriterion("confirm_code like", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeNotLike(String value) {
            addCriterion("confirm_code not like", value, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeIn(List<String> values) {
            addCriterion("confirm_code in", values, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeNotIn(List<String> values) {
            addCriterion("confirm_code not in", values, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeBetween(String value1, String value2) {
            addCriterion("confirm_code between", value1, value2, "confirmCode");
            return (Criteria) this;
        }

        public Criteria andConfirmCodeNotBetween(String value1, String value2) {
            addCriterion("confirm_code not between", value1, value2, "confirmCode");
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

        public Criteria andWuliuNoIsNull() {
            addCriterion("wuliu_no is null");
            return (Criteria) this;
        }

        public Criteria andWuliuNoIsNotNull() {
            addCriterion("wuliu_no is not null");
            return (Criteria) this;
        }

        public Criteria andWuliuNoEqualTo(String value) {
            addCriterion("wuliu_no =", value, "wuliuNo");
            return (Criteria) this;
        }

        public Criteria andWuliuNoNotEqualTo(String value) {
            addCriterion("wuliu_no <>", value, "wuliuNo");
            return (Criteria) this;
        }

        public Criteria andWuliuNoGreaterThan(String value) {
            addCriterion("wuliu_no >", value, "wuliuNo");
            return (Criteria) this;
        }

        public Criteria andWuliuNoGreaterThanOrEqualTo(String value) {
            addCriterion("wuliu_no >=", value, "wuliuNo");
            return (Criteria) this;
        }

        public Criteria andWuliuNoLessThan(String value) {
            addCriterion("wuliu_no <", value, "wuliuNo");
            return (Criteria) this;
        }

        public Criteria andWuliuNoLessThanOrEqualTo(String value) {
            addCriterion("wuliu_no <=", value, "wuliuNo");
            return (Criteria) this;
        }

        public Criteria andWuliuNoLike(String value) {
            addCriterion("wuliu_no like", value, "wuliuNo");
            return (Criteria) this;
        }

        public Criteria andWuliuNoNotLike(String value) {
            addCriterion("wuliu_no not like", value, "wuliuNo");
            return (Criteria) this;
        }

        public Criteria andWuliuNoIn(List<String> values) {
            addCriterion("wuliu_no in", values, "wuliuNo");
            return (Criteria) this;
        }

        public Criteria andWuliuNoNotIn(List<String> values) {
            addCriterion("wuliu_no not in", values, "wuliuNo");
            return (Criteria) this;
        }

        public Criteria andWuliuNoBetween(String value1, String value2) {
            addCriterion("wuliu_no between", value1, value2, "wuliuNo");
            return (Criteria) this;
        }

        public Criteria andWuliuNoNotBetween(String value1, String value2) {
            addCriterion("wuliu_no not between", value1, value2, "wuliuNo");
            return (Criteria) this;
        }

        public Criteria andWuliuJsonIsNull() {
            addCriterion("wuliu_json is null");
            return (Criteria) this;
        }

        public Criteria andWuliuJsonIsNotNull() {
            addCriterion("wuliu_json is not null");
            return (Criteria) this;
        }

        public Criteria andWuliuJsonEqualTo(String value) {
            addCriterion("wuliu_json =", value, "wuliuJson");
            return (Criteria) this;
        }

        public Criteria andWuliuJsonNotEqualTo(String value) {
            addCriterion("wuliu_json <>", value, "wuliuJson");
            return (Criteria) this;
        }

        public Criteria andWuliuJsonGreaterThan(String value) {
            addCriterion("wuliu_json >", value, "wuliuJson");
            return (Criteria) this;
        }

        public Criteria andWuliuJsonGreaterThanOrEqualTo(String value) {
            addCriterion("wuliu_json >=", value, "wuliuJson");
            return (Criteria) this;
        }

        public Criteria andWuliuJsonLessThan(String value) {
            addCriterion("wuliu_json <", value, "wuliuJson");
            return (Criteria) this;
        }

        public Criteria andWuliuJsonLessThanOrEqualTo(String value) {
            addCriterion("wuliu_json <=", value, "wuliuJson");
            return (Criteria) this;
        }

        public Criteria andWuliuJsonLike(String value) {
            addCriterion("wuliu_json like", value, "wuliuJson");
            return (Criteria) this;
        }

        public Criteria andWuliuJsonNotLike(String value) {
            addCriterion("wuliu_json not like", value, "wuliuJson");
            return (Criteria) this;
        }

        public Criteria andWuliuJsonIn(List<String> values) {
            addCriterion("wuliu_json in", values, "wuliuJson");
            return (Criteria) this;
        }

        public Criteria andWuliuJsonNotIn(List<String> values) {
            addCriterion("wuliu_json not in", values, "wuliuJson");
            return (Criteria) this;
        }

        public Criteria andWuliuJsonBetween(String value1, String value2) {
            addCriterion("wuliu_json between", value1, value2, "wuliuJson");
            return (Criteria) this;
        }

        public Criteria andWuliuJsonNotBetween(String value1, String value2) {
            addCriterion("wuliu_json not between", value1, value2, "wuliuJson");
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