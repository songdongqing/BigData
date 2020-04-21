package com.sdq.bigdata.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PositionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PositionExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andLastLoginIsNull() {
            addCriterion("last_login is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIsNotNull() {
            addCriterion("last_login is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginEqualTo(Date value) {
            addCriterionForJDBCDate("last_login =", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginNotEqualTo(Date value) {
            addCriterionForJDBCDate("last_login <>", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginGreaterThan(Date value) {
            addCriterionForJDBCDate("last_login >", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("last_login >=", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginLessThan(Date value) {
            addCriterionForJDBCDate("last_login <", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("last_login <=", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginIn(List<Date> values) {
            addCriterionForJDBCDate("last_login in", values, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginNotIn(List<Date> values) {
            addCriterionForJDBCDate("last_login not in", values, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("last_login between", value1, value2, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("last_login not between", value1, value2, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("education like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("education not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andJobNatureIsNull() {
            addCriterion("job_nature is null");
            return (Criteria) this;
        }

        public Criteria andJobNatureIsNotNull() {
            addCriterion("job_nature is not null");
            return (Criteria) this;
        }

        public Criteria andJobNatureEqualTo(String value) {
            addCriterion("job_nature =", value, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureNotEqualTo(String value) {
            addCriterion("job_nature <>", value, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureGreaterThan(String value) {
            addCriterion("job_nature >", value, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureGreaterThanOrEqualTo(String value) {
            addCriterion("job_nature >=", value, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureLessThan(String value) {
            addCriterion("job_nature <", value, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureLessThanOrEqualTo(String value) {
            addCriterion("job_nature <=", value, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureLike(String value) {
            addCriterion("job_nature like", value, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureNotLike(String value) {
            addCriterion("job_nature not like", value, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureIn(List<String> values) {
            addCriterion("job_nature in", values, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureNotIn(List<String> values) {
            addCriterion("job_nature not in", values, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureBetween(String value1, String value2) {
            addCriterion("job_nature between", value1, value2, "jobNature");
            return (Criteria) this;
        }

        public Criteria andJobNatureNotBetween(String value1, String value2) {
            addCriterion("job_nature not between", value1, value2, "jobNature");
            return (Criteria) this;
        }

        public Criteria andFamousCompanyIsNull() {
            addCriterion("famous_company is null");
            return (Criteria) this;
        }

        public Criteria andFamousCompanyIsNotNull() {
            addCriterion("famous_company is not null");
            return (Criteria) this;
        }

        public Criteria andFamousCompanyEqualTo(Byte value) {
            addCriterion("famous_company =", value, "famousCompany");
            return (Criteria) this;
        }

        public Criteria andFamousCompanyNotEqualTo(Byte value) {
            addCriterion("famous_company <>", value, "famousCompany");
            return (Criteria) this;
        }

        public Criteria andFamousCompanyGreaterThan(Byte value) {
            addCriterion("famous_company >", value, "famousCompany");
            return (Criteria) this;
        }

        public Criteria andFamousCompanyGreaterThanOrEqualTo(Byte value) {
            addCriterion("famous_company >=", value, "famousCompany");
            return (Criteria) this;
        }

        public Criteria andFamousCompanyLessThan(Byte value) {
            addCriterion("famous_company <", value, "famousCompany");
            return (Criteria) this;
        }

        public Criteria andFamousCompanyLessThanOrEqualTo(Byte value) {
            addCriterion("famous_company <=", value, "famousCompany");
            return (Criteria) this;
        }

        public Criteria andFamousCompanyIn(List<Byte> values) {
            addCriterion("famous_company in", values, "famousCompany");
            return (Criteria) this;
        }

        public Criteria andFamousCompanyNotIn(List<Byte> values) {
            addCriterion("famous_company not in", values, "famousCompany");
            return (Criteria) this;
        }

        public Criteria andFamousCompanyBetween(Byte value1, Byte value2) {
            addCriterion("famous_company between", value1, value2, "famousCompany");
            return (Criteria) this;
        }

        public Criteria andFamousCompanyNotBetween(Byte value1, Byte value2) {
            addCriterion("famous_company not between", value1, value2, "famousCompany");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNameIsNull() {
            addCriterion("company_short_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNameIsNotNull() {
            addCriterion("company_short_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNameEqualTo(String value) {
            addCriterion("company_short_name =", value, "companyShortName");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNameNotEqualTo(String value) {
            addCriterion("company_short_name <>", value, "companyShortName");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNameGreaterThan(String value) {
            addCriterion("company_short_name >", value, "companyShortName");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_short_name >=", value, "companyShortName");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNameLessThan(String value) {
            addCriterion("company_short_name <", value, "companyShortName");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNameLessThanOrEqualTo(String value) {
            addCriterion("company_short_name <=", value, "companyShortName");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNameLike(String value) {
            addCriterion("company_short_name like", value, "companyShortName");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNameNotLike(String value) {
            addCriterion("company_short_name not like", value, "companyShortName");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNameIn(List<String> values) {
            addCriterion("company_short_name in", values, "companyShortName");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNameNotIn(List<String> values) {
            addCriterion("company_short_name not in", values, "companyShortName");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNameBetween(String value1, String value2) {
            addCriterion("company_short_name between", value1, value2, "companyShortName");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNameNotBetween(String value1, String value2) {
            addCriterion("company_short_name not between", value1, value2, "companyShortName");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNull() {
            addCriterion("salary is null");
            return (Criteria) this;
        }

        public Criteria andSalaryIsNotNull() {
            addCriterion("salary is not null");
            return (Criteria) this;
        }

        public Criteria andSalaryEqualTo(String value) {
            addCriterion("salary =", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotEqualTo(String value) {
            addCriterion("salary <>", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThan(String value) {
            addCriterion("salary >", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryGreaterThanOrEqualTo(String value) {
            addCriterion("salary >=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThan(String value) {
            addCriterion("salary <", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLessThanOrEqualTo(String value) {
            addCriterion("salary <=", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryLike(String value) {
            addCriterion("salary like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotLike(String value) {
            addCriterion("salary not like", value, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryIn(List<String> values) {
            addCriterion("salary in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotIn(List<String> values) {
            addCriterion("salary not in", values, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryBetween(String value1, String value2) {
            addCriterion("salary between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSalaryNotBetween(String value1, String value2) {
            addCriterion("salary not between", value1, value2, "salary");
            return (Criteria) this;
        }

        public Criteria andSecondTypeIsNull() {
            addCriterion("second_type is null");
            return (Criteria) this;
        }

        public Criteria andSecondTypeIsNotNull() {
            addCriterion("second_type is not null");
            return (Criteria) this;
        }

        public Criteria andSecondTypeEqualTo(String value) {
            addCriterion("second_type =", value, "secondType");
            return (Criteria) this;
        }

        public Criteria andSecondTypeNotEqualTo(String value) {
            addCriterion("second_type <>", value, "secondType");
            return (Criteria) this;
        }

        public Criteria andSecondTypeGreaterThan(String value) {
            addCriterion("second_type >", value, "secondType");
            return (Criteria) this;
        }

        public Criteria andSecondTypeGreaterThanOrEqualTo(String value) {
            addCriterion("second_type >=", value, "secondType");
            return (Criteria) this;
        }

        public Criteria andSecondTypeLessThan(String value) {
            addCriterion("second_type <", value, "secondType");
            return (Criteria) this;
        }

        public Criteria andSecondTypeLessThanOrEqualTo(String value) {
            addCriterion("second_type <=", value, "secondType");
            return (Criteria) this;
        }

        public Criteria andSecondTypeLike(String value) {
            addCriterion("second_type like", value, "secondType");
            return (Criteria) this;
        }

        public Criteria andSecondTypeNotLike(String value) {
            addCriterion("second_type not like", value, "secondType");
            return (Criteria) this;
        }

        public Criteria andSecondTypeIn(List<String> values) {
            addCriterion("second_type in", values, "secondType");
            return (Criteria) this;
        }

        public Criteria andSecondTypeNotIn(List<String> values) {
            addCriterion("second_type not in", values, "secondType");
            return (Criteria) this;
        }

        public Criteria andSecondTypeBetween(String value1, String value2) {
            addCriterion("second_type between", value1, value2, "secondType");
            return (Criteria) this;
        }

        public Criteria andSecondTypeNotBetween(String value1, String value2) {
            addCriterion("second_type not between", value1, value2, "secondType");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andAppShowIsNull() {
            addCriterion("app_show is null");
            return (Criteria) this;
        }

        public Criteria andAppShowIsNotNull() {
            addCriterion("app_show is not null");
            return (Criteria) this;
        }

        public Criteria andAppShowEqualTo(Integer value) {
            addCriterion("app_show =", value, "appShow");
            return (Criteria) this;
        }

        public Criteria andAppShowNotEqualTo(Integer value) {
            addCriterion("app_show <>", value, "appShow");
            return (Criteria) this;
        }

        public Criteria andAppShowGreaterThan(Integer value) {
            addCriterion("app_show >", value, "appShow");
            return (Criteria) this;
        }

        public Criteria andAppShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("app_show >=", value, "appShow");
            return (Criteria) this;
        }

        public Criteria andAppShowLessThan(Integer value) {
            addCriterion("app_show <", value, "appShow");
            return (Criteria) this;
        }

        public Criteria andAppShowLessThanOrEqualTo(Integer value) {
            addCriterion("app_show <=", value, "appShow");
            return (Criteria) this;
        }

        public Criteria andAppShowIn(List<Integer> values) {
            addCriterion("app_show in", values, "appShow");
            return (Criteria) this;
        }

        public Criteria andAppShowNotIn(List<Integer> values) {
            addCriterion("app_show not in", values, "appShow");
            return (Criteria) this;
        }

        public Criteria andAppShowBetween(Integer value1, Integer value2) {
            addCriterion("app_show between", value1, value2, "appShow");
            return (Criteria) this;
        }

        public Criteria andAppShowNotBetween(Integer value1, Integer value2) {
            addCriterion("app_show not between", value1, value2, "appShow");
            return (Criteria) this;
        }

        public Criteria andCompanyFullNameIsNull() {
            addCriterion("company_full_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyFullNameIsNotNull() {
            addCriterion("company_full_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyFullNameEqualTo(String value) {
            addCriterion("company_full_name =", value, "companyFullName");
            return (Criteria) this;
        }

        public Criteria andCompanyFullNameNotEqualTo(String value) {
            addCriterion("company_full_name <>", value, "companyFullName");
            return (Criteria) this;
        }

        public Criteria andCompanyFullNameGreaterThan(String value) {
            addCriterion("company_full_name >", value, "companyFullName");
            return (Criteria) this;
        }

        public Criteria andCompanyFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_full_name >=", value, "companyFullName");
            return (Criteria) this;
        }

        public Criteria andCompanyFullNameLessThan(String value) {
            addCriterion("company_full_name <", value, "companyFullName");
            return (Criteria) this;
        }

        public Criteria andCompanyFullNameLessThanOrEqualTo(String value) {
            addCriterion("company_full_name <=", value, "companyFullName");
            return (Criteria) this;
        }

        public Criteria andCompanyFullNameLike(String value) {
            addCriterion("company_full_name like", value, "companyFullName");
            return (Criteria) this;
        }

        public Criteria andCompanyFullNameNotLike(String value) {
            addCriterion("company_full_name not like", value, "companyFullName");
            return (Criteria) this;
        }

        public Criteria andCompanyFullNameIn(List<String> values) {
            addCriterion("company_full_name in", values, "companyFullName");
            return (Criteria) this;
        }

        public Criteria andCompanyFullNameNotIn(List<String> values) {
            addCriterion("company_full_name not in", values, "companyFullName");
            return (Criteria) this;
        }

        public Criteria andCompanyFullNameBetween(String value1, String value2) {
            addCriterion("company_full_name between", value1, value2, "companyFullName");
            return (Criteria) this;
        }

        public Criteria andCompanyFullNameNotBetween(String value1, String value2) {
            addCriterion("company_full_name not between", value1, value2, "companyFullName");
            return (Criteria) this;
        }

        public Criteria andIndustryLablesStrIsNull() {
            addCriterion("industry_lables_str is null");
            return (Criteria) this;
        }

        public Criteria andIndustryLablesStrIsNotNull() {
            addCriterion("industry_lables_str is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryLablesStrEqualTo(String value) {
            addCriterion("industry_lables_str =", value, "industryLablesStr");
            return (Criteria) this;
        }

        public Criteria andIndustryLablesStrNotEqualTo(String value) {
            addCriterion("industry_lables_str <>", value, "industryLablesStr");
            return (Criteria) this;
        }

        public Criteria andIndustryLablesStrGreaterThan(String value) {
            addCriterion("industry_lables_str >", value, "industryLablesStr");
            return (Criteria) this;
        }

        public Criteria andIndustryLablesStrGreaterThanOrEqualTo(String value) {
            addCriterion("industry_lables_str >=", value, "industryLablesStr");
            return (Criteria) this;
        }

        public Criteria andIndustryLablesStrLessThan(String value) {
            addCriterion("industry_lables_str <", value, "industryLablesStr");
            return (Criteria) this;
        }

        public Criteria andIndustryLablesStrLessThanOrEqualTo(String value) {
            addCriterion("industry_lables_str <=", value, "industryLablesStr");
            return (Criteria) this;
        }

        public Criteria andIndustryLablesStrLike(String value) {
            addCriterion("industry_lables_str like", value, "industryLablesStr");
            return (Criteria) this;
        }

        public Criteria andIndustryLablesStrNotLike(String value) {
            addCriterion("industry_lables_str not like", value, "industryLablesStr");
            return (Criteria) this;
        }

        public Criteria andIndustryLablesStrIn(List<String> values) {
            addCriterion("industry_lables_str in", values, "industryLablesStr");
            return (Criteria) this;
        }

        public Criteria andIndustryLablesStrNotIn(List<String> values) {
            addCriterion("industry_lables_str not in", values, "industryLablesStr");
            return (Criteria) this;
        }

        public Criteria andIndustryLablesStrBetween(String value1, String value2) {
            addCriterion("industry_lables_str between", value1, value2, "industryLablesStr");
            return (Criteria) this;
        }

        public Criteria andIndustryLablesStrNotBetween(String value1, String value2) {
            addCriterion("industry_lables_str not between", value1, value2, "industryLablesStr");
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

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andBusinessZonesStrIsNull() {
            addCriterion("business_zones_str is null");
            return (Criteria) this;
        }

        public Criteria andBusinessZonesStrIsNotNull() {
            addCriterion("business_zones_str is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessZonesStrEqualTo(String value) {
            addCriterion("business_zones_str =", value, "businessZonesStr");
            return (Criteria) this;
        }

        public Criteria andBusinessZonesStrNotEqualTo(String value) {
            addCriterion("business_zones_str <>", value, "businessZonesStr");
            return (Criteria) this;
        }

        public Criteria andBusinessZonesStrGreaterThan(String value) {
            addCriterion("business_zones_str >", value, "businessZonesStr");
            return (Criteria) this;
        }

        public Criteria andBusinessZonesStrGreaterThanOrEqualTo(String value) {
            addCriterion("business_zones_str >=", value, "businessZonesStr");
            return (Criteria) this;
        }

        public Criteria andBusinessZonesStrLessThan(String value) {
            addCriterion("business_zones_str <", value, "businessZonesStr");
            return (Criteria) this;
        }

        public Criteria andBusinessZonesStrLessThanOrEqualTo(String value) {
            addCriterion("business_zones_str <=", value, "businessZonesStr");
            return (Criteria) this;
        }

        public Criteria andBusinessZonesStrLike(String value) {
            addCriterion("business_zones_str like", value, "businessZonesStr");
            return (Criteria) this;
        }

        public Criteria andBusinessZonesStrNotLike(String value) {
            addCriterion("business_zones_str not like", value, "businessZonesStr");
            return (Criteria) this;
        }

        public Criteria andBusinessZonesStrIn(List<String> values) {
            addCriterion("business_zones_str in", values, "businessZonesStr");
            return (Criteria) this;
        }

        public Criteria andBusinessZonesStrNotIn(List<String> values) {
            addCriterion("business_zones_str not in", values, "businessZonesStr");
            return (Criteria) this;
        }

        public Criteria andBusinessZonesStrBetween(String value1, String value2) {
            addCriterion("business_zones_str between", value1, value2, "businessZonesStr");
            return (Criteria) this;
        }

        public Criteria andBusinessZonesStrNotBetween(String value1, String value2) {
            addCriterion("business_zones_str not between", value1, value2, "businessZonesStr");
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

        public Criteria andPcShowIsNull() {
            addCriterion("pc_show is null");
            return (Criteria) this;
        }

        public Criteria andPcShowIsNotNull() {
            addCriterion("pc_show is not null");
            return (Criteria) this;
        }

        public Criteria andPcShowEqualTo(Integer value) {
            addCriterion("pc_show =", value, "pcShow");
            return (Criteria) this;
        }

        public Criteria andPcShowNotEqualTo(Integer value) {
            addCriterion("pc_show <>", value, "pcShow");
            return (Criteria) this;
        }

        public Criteria andPcShowGreaterThan(Integer value) {
            addCriterion("pc_show >", value, "pcShow");
            return (Criteria) this;
        }

        public Criteria andPcShowGreaterThanOrEqualTo(Integer value) {
            addCriterion("pc_show >=", value, "pcShow");
            return (Criteria) this;
        }

        public Criteria andPcShowLessThan(Integer value) {
            addCriterion("pc_show <", value, "pcShow");
            return (Criteria) this;
        }

        public Criteria andPcShowLessThanOrEqualTo(Integer value) {
            addCriterion("pc_show <=", value, "pcShow");
            return (Criteria) this;
        }

        public Criteria andPcShowIn(List<Integer> values) {
            addCriterion("pc_show in", values, "pcShow");
            return (Criteria) this;
        }

        public Criteria andPcShowNotIn(List<Integer> values) {
            addCriterion("pc_show not in", values, "pcShow");
            return (Criteria) this;
        }

        public Criteria andPcShowBetween(Integer value1, Integer value2) {
            addCriterion("pc_show between", value1, value2, "pcShow");
            return (Criteria) this;
        }

        public Criteria andPcShowNotBetween(Integer value1, Integer value2) {
            addCriterion("pc_show not between", value1, value2, "pcShow");
            return (Criteria) this;
        }

        public Criteria andCompanySizeIsNull() {
            addCriterion("company_size is null");
            return (Criteria) this;
        }

        public Criteria andCompanySizeIsNotNull() {
            addCriterion("company_size is not null");
            return (Criteria) this;
        }

        public Criteria andCompanySizeEqualTo(String value) {
            addCriterion("company_size =", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeNotEqualTo(String value) {
            addCriterion("company_size <>", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeGreaterThan(String value) {
            addCriterion("company_size >", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeGreaterThanOrEqualTo(String value) {
            addCriterion("company_size >=", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeLessThan(String value) {
            addCriterion("company_size <", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeLessThanOrEqualTo(String value) {
            addCriterion("company_size <=", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeLike(String value) {
            addCriterion("company_size like", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeNotLike(String value) {
            addCriterion("company_size not like", value, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeIn(List<String> values) {
            addCriterion("company_size in", values, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeNotIn(List<String> values) {
            addCriterion("company_size not in", values, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeBetween(String value1, String value2) {
            addCriterion("company_size between", value1, value2, "companySize");
            return (Criteria) this;
        }

        public Criteria andCompanySizeNotBetween(String value1, String value2) {
            addCriterion("company_size not between", value1, value2, "companySize");
            return (Criteria) this;
        }

        public Criteria andStationnameIsNull() {
            addCriterion("stationname is null");
            return (Criteria) this;
        }

        public Criteria andStationnameIsNotNull() {
            addCriterion("stationname is not null");
            return (Criteria) this;
        }

        public Criteria andStationnameEqualTo(String value) {
            addCriterion("stationname =", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotEqualTo(String value) {
            addCriterion("stationname <>", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameGreaterThan(String value) {
            addCriterion("stationname >", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameGreaterThanOrEqualTo(String value) {
            addCriterion("stationname >=", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameLessThan(String value) {
            addCriterion("stationname <", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameLessThanOrEqualTo(String value) {
            addCriterion("stationname <=", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameLike(String value) {
            addCriterion("stationname like", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotLike(String value) {
            addCriterion("stationname not like", value, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameIn(List<String> values) {
            addCriterion("stationname in", values, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotIn(List<String> values) {
            addCriterion("stationname not in", values, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameBetween(String value1, String value2) {
            addCriterion("stationname between", value1, value2, "stationname");
            return (Criteria) this;
        }

        public Criteria andStationnameNotBetween(String value1, String value2) {
            addCriterion("stationname not between", value1, value2, "stationname");
            return (Criteria) this;
        }

        public Criteria andLinestaionIsNull() {
            addCriterion("linestaion is null");
            return (Criteria) this;
        }

        public Criteria andLinestaionIsNotNull() {
            addCriterion("linestaion is not null");
            return (Criteria) this;
        }

        public Criteria andLinestaionEqualTo(String value) {
            addCriterion("linestaion =", value, "linestaion");
            return (Criteria) this;
        }

        public Criteria andLinestaionNotEqualTo(String value) {
            addCriterion("linestaion <>", value, "linestaion");
            return (Criteria) this;
        }

        public Criteria andLinestaionGreaterThan(String value) {
            addCriterion("linestaion >", value, "linestaion");
            return (Criteria) this;
        }

        public Criteria andLinestaionGreaterThanOrEqualTo(String value) {
            addCriterion("linestaion >=", value, "linestaion");
            return (Criteria) this;
        }

        public Criteria andLinestaionLessThan(String value) {
            addCriterion("linestaion <", value, "linestaion");
            return (Criteria) this;
        }

        public Criteria andLinestaionLessThanOrEqualTo(String value) {
            addCriterion("linestaion <=", value, "linestaion");
            return (Criteria) this;
        }

        public Criteria andLinestaionLike(String value) {
            addCriterion("linestaion like", value, "linestaion");
            return (Criteria) this;
        }

        public Criteria andLinestaionNotLike(String value) {
            addCriterion("linestaion not like", value, "linestaion");
            return (Criteria) this;
        }

        public Criteria andLinestaionIn(List<String> values) {
            addCriterion("linestaion in", values, "linestaion");
            return (Criteria) this;
        }

        public Criteria andLinestaionNotIn(List<String> values) {
            addCriterion("linestaion not in", values, "linestaion");
            return (Criteria) this;
        }

        public Criteria andLinestaionBetween(String value1, String value2) {
            addCriterion("linestaion between", value1, value2, "linestaion");
            return (Criteria) this;
        }

        public Criteria andLinestaionNotBetween(String value1, String value2) {
            addCriterion("linestaion not between", value1, value2, "linestaion");
            return (Criteria) this;
        }

        public Criteria andMatchScoreIsNull() {
            addCriterion("match_score is null");
            return (Criteria) this;
        }

        public Criteria andMatchScoreIsNotNull() {
            addCriterion("match_score is not null");
            return (Criteria) this;
        }

        public Criteria andMatchScoreEqualTo(Double value) {
            addCriterion("match_score =", value, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreNotEqualTo(Double value) {
            addCriterion("match_score <>", value, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreGreaterThan(Double value) {
            addCriterion("match_score >", value, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("match_score >=", value, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreLessThan(Double value) {
            addCriterion("match_score <", value, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreLessThanOrEqualTo(Double value) {
            addCriterion("match_score <=", value, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreIn(List<Double> values) {
            addCriterion("match_score in", values, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreNotIn(List<Double> values) {
            addCriterion("match_score not in", values, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreBetween(Double value1, Double value2) {
            addCriterion("match_score between", value1, value2, "matchScore");
            return (Criteria) this;
        }

        public Criteria andMatchScoreNotBetween(Double value1, Double value2) {
            addCriterion("match_score not between", value1, value2, "matchScore");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andNewScoreIsNull() {
            addCriterion("new_score is null");
            return (Criteria) this;
        }

        public Criteria andNewScoreIsNotNull() {
            addCriterion("new_score is not null");
            return (Criteria) this;
        }

        public Criteria andNewScoreEqualTo(Integer value) {
            addCriterion("new_score =", value, "newScore");
            return (Criteria) this;
        }

        public Criteria andNewScoreNotEqualTo(Integer value) {
            addCriterion("new_score <>", value, "newScore");
            return (Criteria) this;
        }

        public Criteria andNewScoreGreaterThan(Integer value) {
            addCriterion("new_score >", value, "newScore");
            return (Criteria) this;
        }

        public Criteria andNewScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("new_score >=", value, "newScore");
            return (Criteria) this;
        }

        public Criteria andNewScoreLessThan(Integer value) {
            addCriterion("new_score <", value, "newScore");
            return (Criteria) this;
        }

        public Criteria andNewScoreLessThanOrEqualTo(Integer value) {
            addCriterion("new_score <=", value, "newScore");
            return (Criteria) this;
        }

        public Criteria andNewScoreIn(List<Integer> values) {
            addCriterion("new_score in", values, "newScore");
            return (Criteria) this;
        }

        public Criteria andNewScoreNotIn(List<Integer> values) {
            addCriterion("new_score not in", values, "newScore");
            return (Criteria) this;
        }

        public Criteria andNewScoreBetween(Integer value1, Integer value2) {
            addCriterion("new_score between", value1, value2, "newScore");
            return (Criteria) this;
        }

        public Criteria andNewScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("new_score not between", value1, value2, "newScore");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("district is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("district =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("district <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("district >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("district >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("district <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("district <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("district like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("district not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("district in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("district not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("district between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("district not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andFinanceStageIsNull() {
            addCriterion("finance_stage is null");
            return (Criteria) this;
        }

        public Criteria andFinanceStageIsNotNull() {
            addCriterion("finance_stage is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceStageEqualTo(String value) {
            addCriterion("finance_stage =", value, "financeStage");
            return (Criteria) this;
        }

        public Criteria andFinanceStageNotEqualTo(String value) {
            addCriterion("finance_stage <>", value, "financeStage");
            return (Criteria) this;
        }

        public Criteria andFinanceStageGreaterThan(String value) {
            addCriterion("finance_stage >", value, "financeStage");
            return (Criteria) this;
        }

        public Criteria andFinanceStageGreaterThanOrEqualTo(String value) {
            addCriterion("finance_stage >=", value, "financeStage");
            return (Criteria) this;
        }

        public Criteria andFinanceStageLessThan(String value) {
            addCriterion("finance_stage <", value, "financeStage");
            return (Criteria) this;
        }

        public Criteria andFinanceStageLessThanOrEqualTo(String value) {
            addCriterion("finance_stage <=", value, "financeStage");
            return (Criteria) this;
        }

        public Criteria andFinanceStageLike(String value) {
            addCriterion("finance_stage like", value, "financeStage");
            return (Criteria) this;
        }

        public Criteria andFinanceStageNotLike(String value) {
            addCriterion("finance_stage not like", value, "financeStage");
            return (Criteria) this;
        }

        public Criteria andFinanceStageIn(List<String> values) {
            addCriterion("finance_stage in", values, "financeStage");
            return (Criteria) this;
        }

        public Criteria andFinanceStageNotIn(List<String> values) {
            addCriterion("finance_stage not in", values, "financeStage");
            return (Criteria) this;
        }

        public Criteria andFinanceStageBetween(String value1, String value2) {
            addCriterion("finance_stage between", value1, value2, "financeStage");
            return (Criteria) this;
        }

        public Criteria andFinanceStageNotBetween(String value1, String value2) {
            addCriterion("finance_stage not between", value1, value2, "financeStage");
            return (Criteria) this;
        }

        public Criteria andIsHotHireIsNull() {
            addCriterion("is_hot_hire is null");
            return (Criteria) this;
        }

        public Criteria andIsHotHireIsNotNull() {
            addCriterion("is_hot_hire is not null");
            return (Criteria) this;
        }

        public Criteria andIsHotHireEqualTo(Integer value) {
            addCriterion("is_hot_hire =", value, "isHotHire");
            return (Criteria) this;
        }

        public Criteria andIsHotHireNotEqualTo(Integer value) {
            addCriterion("is_hot_hire <>", value, "isHotHire");
            return (Criteria) this;
        }

        public Criteria andIsHotHireGreaterThan(Integer value) {
            addCriterion("is_hot_hire >", value, "isHotHire");
            return (Criteria) this;
        }

        public Criteria andIsHotHireGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_hot_hire >=", value, "isHotHire");
            return (Criteria) this;
        }

        public Criteria andIsHotHireLessThan(Integer value) {
            addCriterion("is_hot_hire <", value, "isHotHire");
            return (Criteria) this;
        }

        public Criteria andIsHotHireLessThanOrEqualTo(Integer value) {
            addCriterion("is_hot_hire <=", value, "isHotHire");
            return (Criteria) this;
        }

        public Criteria andIsHotHireIn(List<Integer> values) {
            addCriterion("is_hot_hire in", values, "isHotHire");
            return (Criteria) this;
        }

        public Criteria andIsHotHireNotIn(List<Integer> values) {
            addCriterion("is_hot_hire not in", values, "isHotHire");
            return (Criteria) this;
        }

        public Criteria andIsHotHireBetween(Integer value1, Integer value2) {
            addCriterion("is_hot_hire between", value1, value2, "isHotHire");
            return (Criteria) this;
        }

        public Criteria andIsHotHireNotBetween(Integer value1, Integer value2) {
            addCriterion("is_hot_hire not between", value1, value2, "isHotHire");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
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

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andDeliverIsNull() {
            addCriterion("deliver is null");
            return (Criteria) this;
        }

        public Criteria andDeliverIsNotNull() {
            addCriterion("deliver is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverEqualTo(Integer value) {
            addCriterion("deliver =", value, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverNotEqualTo(Integer value) {
            addCriterion("deliver <>", value, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverGreaterThan(Integer value) {
            addCriterion("deliver >", value, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverGreaterThanOrEqualTo(Integer value) {
            addCriterion("deliver >=", value, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverLessThan(Integer value) {
            addCriterion("deliver <", value, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverLessThanOrEqualTo(Integer value) {
            addCriterion("deliver <=", value, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverIn(List<Integer> values) {
            addCriterion("deliver in", values, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverNotIn(List<Integer> values) {
            addCriterion("deliver not in", values, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverBetween(Integer value1, Integer value2) {
            addCriterion("deliver between", value1, value2, "deliver");
            return (Criteria) this;
        }

        public Criteria andDeliverNotBetween(Integer value1, Integer value2) {
            addCriterion("deliver not between", value1, value2, "deliver");
            return (Criteria) this;
        }

        public Criteria andSkillLablesStrIsNull() {
            addCriterion("skill_lables_str is null");
            return (Criteria) this;
        }

        public Criteria andSkillLablesStrIsNotNull() {
            addCriterion("skill_lables_str is not null");
            return (Criteria) this;
        }

        public Criteria andSkillLablesStrEqualTo(String value) {
            addCriterion("skill_lables_str =", value, "skillLablesStr");
            return (Criteria) this;
        }

        public Criteria andSkillLablesStrNotEqualTo(String value) {
            addCriterion("skill_lables_str <>", value, "skillLablesStr");
            return (Criteria) this;
        }

        public Criteria andSkillLablesStrGreaterThan(String value) {
            addCriterion("skill_lables_str >", value, "skillLablesStr");
            return (Criteria) this;
        }

        public Criteria andSkillLablesStrGreaterThanOrEqualTo(String value) {
            addCriterion("skill_lables_str >=", value, "skillLablesStr");
            return (Criteria) this;
        }

        public Criteria andSkillLablesStrLessThan(String value) {
            addCriterion("skill_lables_str <", value, "skillLablesStr");
            return (Criteria) this;
        }

        public Criteria andSkillLablesStrLessThanOrEqualTo(String value) {
            addCriterion("skill_lables_str <=", value, "skillLablesStr");
            return (Criteria) this;
        }

        public Criteria andSkillLablesStrLike(String value) {
            addCriterion("skill_lables_str like", value, "skillLablesStr");
            return (Criteria) this;
        }

        public Criteria andSkillLablesStrNotLike(String value) {
            addCriterion("skill_lables_str not like", value, "skillLablesStr");
            return (Criteria) this;
        }

        public Criteria andSkillLablesStrIn(List<String> values) {
            addCriterion("skill_lables_str in", values, "skillLablesStr");
            return (Criteria) this;
        }

        public Criteria andSkillLablesStrNotIn(List<String> values) {
            addCriterion("skill_lables_str not in", values, "skillLablesStr");
            return (Criteria) this;
        }

        public Criteria andSkillLablesStrBetween(String value1, String value2) {
            addCriterion("skill_lables_str between", value1, value2, "skillLablesStr");
            return (Criteria) this;
        }

        public Criteria andSkillLablesStrNotBetween(String value1, String value2) {
            addCriterion("skill_lables_str not between", value1, value2, "skillLablesStr");
            return (Criteria) this;
        }

        public Criteria andPositionAdvantageIsNull() {
            addCriterion("position_advantage is null");
            return (Criteria) this;
        }

        public Criteria andPositionAdvantageIsNotNull() {
            addCriterion("position_advantage is not null");
            return (Criteria) this;
        }

        public Criteria andPositionAdvantageEqualTo(String value) {
            addCriterion("position_advantage =", value, "positionAdvantage");
            return (Criteria) this;
        }

        public Criteria andPositionAdvantageNotEqualTo(String value) {
            addCriterion("position_advantage <>", value, "positionAdvantage");
            return (Criteria) this;
        }

        public Criteria andPositionAdvantageGreaterThan(String value) {
            addCriterion("position_advantage >", value, "positionAdvantage");
            return (Criteria) this;
        }

        public Criteria andPositionAdvantageGreaterThanOrEqualTo(String value) {
            addCriterion("position_advantage >=", value, "positionAdvantage");
            return (Criteria) this;
        }

        public Criteria andPositionAdvantageLessThan(String value) {
            addCriterion("position_advantage <", value, "positionAdvantage");
            return (Criteria) this;
        }

        public Criteria andPositionAdvantageLessThanOrEqualTo(String value) {
            addCriterion("position_advantage <=", value, "positionAdvantage");
            return (Criteria) this;
        }

        public Criteria andPositionAdvantageLike(String value) {
            addCriterion("position_advantage like", value, "positionAdvantage");
            return (Criteria) this;
        }

        public Criteria andPositionAdvantageNotLike(String value) {
            addCriterion("position_advantage not like", value, "positionAdvantage");
            return (Criteria) this;
        }

        public Criteria andPositionAdvantageIn(List<String> values) {
            addCriterion("position_advantage in", values, "positionAdvantage");
            return (Criteria) this;
        }

        public Criteria andPositionAdvantageNotIn(List<String> values) {
            addCriterion("position_advantage not in", values, "positionAdvantage");
            return (Criteria) this;
        }

        public Criteria andPositionAdvantageBetween(String value1, String value2) {
            addCriterion("position_advantage between", value1, value2, "positionAdvantage");
            return (Criteria) this;
        }

        public Criteria andPositionAdvantageNotBetween(String value1, String value2) {
            addCriterion("position_advantage not between", value1, value2, "positionAdvantage");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNull() {
            addCriterion("position_name is null");
            return (Criteria) this;
        }

        public Criteria andPositionNameIsNotNull() {
            addCriterion("position_name is not null");
            return (Criteria) this;
        }

        public Criteria andPositionNameEqualTo(String value) {
            addCriterion("position_name =", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotEqualTo(String value) {
            addCriterion("position_name <>", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThan(String value) {
            addCriterion("position_name >", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameGreaterThanOrEqualTo(String value) {
            addCriterion("position_name >=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThan(String value) {
            addCriterion("position_name <", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLessThanOrEqualTo(String value) {
            addCriterion("position_name <=", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameLike(String value) {
            addCriterion("position_name like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotLike(String value) {
            addCriterion("position_name not like", value, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameIn(List<String> values) {
            addCriterion("position_name in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotIn(List<String> values) {
            addCriterion("position_name not in", values, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameBetween(String value1, String value2) {
            addCriterion("position_name between", value1, value2, "positionName");
            return (Criteria) this;
        }

        public Criteria andPositionNameNotBetween(String value1, String value2) {
            addCriterion("position_name not between", value1, value2, "positionName");
            return (Criteria) this;
        }

        public Criteria andIsSchoolJobIsNull() {
            addCriterion("is_school_job is null");
            return (Criteria) this;
        }

        public Criteria andIsSchoolJobIsNotNull() {
            addCriterion("is_school_job is not null");
            return (Criteria) this;
        }

        public Criteria andIsSchoolJobEqualTo(Integer value) {
            addCriterion("is_school_job =", value, "isSchoolJob");
            return (Criteria) this;
        }

        public Criteria andIsSchoolJobNotEqualTo(Integer value) {
            addCriterion("is_school_job <>", value, "isSchoolJob");
            return (Criteria) this;
        }

        public Criteria andIsSchoolJobGreaterThan(Integer value) {
            addCriterion("is_school_job >", value, "isSchoolJob");
            return (Criteria) this;
        }

        public Criteria andIsSchoolJobGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_school_job >=", value, "isSchoolJob");
            return (Criteria) this;
        }

        public Criteria andIsSchoolJobLessThan(Integer value) {
            addCriterion("is_school_job <", value, "isSchoolJob");
            return (Criteria) this;
        }

        public Criteria andIsSchoolJobLessThanOrEqualTo(Integer value) {
            addCriterion("is_school_job <=", value, "isSchoolJob");
            return (Criteria) this;
        }

        public Criteria andIsSchoolJobIn(List<Integer> values) {
            addCriterion("is_school_job in", values, "isSchoolJob");
            return (Criteria) this;
        }

        public Criteria andIsSchoolJobNotIn(List<Integer> values) {
            addCriterion("is_school_job not in", values, "isSchoolJob");
            return (Criteria) this;
        }

        public Criteria andIsSchoolJobBetween(Integer value1, Integer value2) {
            addCriterion("is_school_job between", value1, value2, "isSchoolJob");
            return (Criteria) this;
        }

        public Criteria andIsSchoolJobNotBetween(Integer value1, Integer value2) {
            addCriterion("is_school_job not between", value1, value2, "isSchoolJob");
            return (Criteria) this;
        }

        public Criteria andAggregatePositionIdsStrIsNull() {
            addCriterion("aggregate_position_ids_str is null");
            return (Criteria) this;
        }

        public Criteria andAggregatePositionIdsStrIsNotNull() {
            addCriterion("aggregate_position_ids_str is not null");
            return (Criteria) this;
        }

        public Criteria andAggregatePositionIdsStrEqualTo(String value) {
            addCriterion("aggregate_position_ids_str =", value, "aggregatePositionIdsStr");
            return (Criteria) this;
        }

        public Criteria andAggregatePositionIdsStrNotEqualTo(String value) {
            addCriterion("aggregate_position_ids_str <>", value, "aggregatePositionIdsStr");
            return (Criteria) this;
        }

        public Criteria andAggregatePositionIdsStrGreaterThan(String value) {
            addCriterion("aggregate_position_ids_str >", value, "aggregatePositionIdsStr");
            return (Criteria) this;
        }

        public Criteria andAggregatePositionIdsStrGreaterThanOrEqualTo(String value) {
            addCriterion("aggregate_position_ids_str >=", value, "aggregatePositionIdsStr");
            return (Criteria) this;
        }

        public Criteria andAggregatePositionIdsStrLessThan(String value) {
            addCriterion("aggregate_position_ids_str <", value, "aggregatePositionIdsStr");
            return (Criteria) this;
        }

        public Criteria andAggregatePositionIdsStrLessThanOrEqualTo(String value) {
            addCriterion("aggregate_position_ids_str <=", value, "aggregatePositionIdsStr");
            return (Criteria) this;
        }

        public Criteria andAggregatePositionIdsStrLike(String value) {
            addCriterion("aggregate_position_ids_str like", value, "aggregatePositionIdsStr");
            return (Criteria) this;
        }

        public Criteria andAggregatePositionIdsStrNotLike(String value) {
            addCriterion("aggregate_position_ids_str not like", value, "aggregatePositionIdsStr");
            return (Criteria) this;
        }

        public Criteria andAggregatePositionIdsStrIn(List<String> values) {
            addCriterion("aggregate_position_ids_str in", values, "aggregatePositionIdsStr");
            return (Criteria) this;
        }

        public Criteria andAggregatePositionIdsStrNotIn(List<String> values) {
            addCriterion("aggregate_position_ids_str not in", values, "aggregatePositionIdsStr");
            return (Criteria) this;
        }

        public Criteria andAggregatePositionIdsStrBetween(String value1, String value2) {
            addCriterion("aggregate_position_ids_str between", value1, value2, "aggregatePositionIdsStr");
            return (Criteria) this;
        }

        public Criteria andAggregatePositionIdsStrNotBetween(String value1, String value2) {
            addCriterion("aggregate_position_ids_str not between", value1, value2, "aggregatePositionIdsStr");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIsNull() {
            addCriterion("publisher_id is null");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIsNotNull() {
            addCriterion("publisher_id is not null");
            return (Criteria) this;
        }

        public Criteria andPublisherIdEqualTo(Integer value) {
            addCriterion("publisher_id =", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotEqualTo(Integer value) {
            addCriterion("publisher_id <>", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdGreaterThan(Integer value) {
            addCriterion("publisher_id >", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("publisher_id >=", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdLessThan(Integer value) {
            addCriterion("publisher_id <", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdLessThanOrEqualTo(Integer value) {
            addCriterion("publisher_id <=", value, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdIn(List<Integer> values) {
            addCriterion("publisher_id in", values, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotIn(List<Integer> values) {
            addCriterion("publisher_id not in", values, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdBetween(Integer value1, Integer value2) {
            addCriterion("publisher_id between", value1, value2, "publisherId");
            return (Criteria) this;
        }

        public Criteria andPublisherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("publisher_id not between", value1, value2, "publisherId");
            return (Criteria) this;
        }

        public Criteria andResumeProcessDayIsNull() {
            addCriterion("resume_process_day is null");
            return (Criteria) this;
        }

        public Criteria andResumeProcessDayIsNotNull() {
            addCriterion("resume_process_day is not null");
            return (Criteria) this;
        }

        public Criteria andResumeProcessDayEqualTo(Integer value) {
            addCriterion("resume_process_day =", value, "resumeProcessDay");
            return (Criteria) this;
        }

        public Criteria andResumeProcessDayNotEqualTo(Integer value) {
            addCriterion("resume_process_day <>", value, "resumeProcessDay");
            return (Criteria) this;
        }

        public Criteria andResumeProcessDayGreaterThan(Integer value) {
            addCriterion("resume_process_day >", value, "resumeProcessDay");
            return (Criteria) this;
        }

        public Criteria andResumeProcessDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("resume_process_day >=", value, "resumeProcessDay");
            return (Criteria) this;
        }

        public Criteria andResumeProcessDayLessThan(Integer value) {
            addCriterion("resume_process_day <", value, "resumeProcessDay");
            return (Criteria) this;
        }

        public Criteria andResumeProcessDayLessThanOrEqualTo(Integer value) {
            addCriterion("resume_process_day <=", value, "resumeProcessDay");
            return (Criteria) this;
        }

        public Criteria andResumeProcessDayIn(List<Integer> values) {
            addCriterion("resume_process_day in", values, "resumeProcessDay");
            return (Criteria) this;
        }

        public Criteria andResumeProcessDayNotIn(List<Integer> values) {
            addCriterion("resume_process_day not in", values, "resumeProcessDay");
            return (Criteria) this;
        }

        public Criteria andResumeProcessDayBetween(Integer value1, Integer value2) {
            addCriterion("resume_process_day between", value1, value2, "resumeProcessDay");
            return (Criteria) this;
        }

        public Criteria andResumeProcessDayNotBetween(Integer value1, Integer value2) {
            addCriterion("resume_process_day not between", value1, value2, "resumeProcessDay");
            return (Criteria) this;
        }

        public Criteria andThirdTypeIsNull() {
            addCriterion("third_type is null");
            return (Criteria) this;
        }

        public Criteria andThirdTypeIsNotNull() {
            addCriterion("third_type is not null");
            return (Criteria) this;
        }

        public Criteria andThirdTypeEqualTo(String value) {
            addCriterion("third_type =", value, "thirdType");
            return (Criteria) this;
        }

        public Criteria andThirdTypeNotEqualTo(String value) {
            addCriterion("third_type <>", value, "thirdType");
            return (Criteria) this;
        }

        public Criteria andThirdTypeGreaterThan(String value) {
            addCriterion("third_type >", value, "thirdType");
            return (Criteria) this;
        }

        public Criteria andThirdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("third_type >=", value, "thirdType");
            return (Criteria) this;
        }

        public Criteria andThirdTypeLessThan(String value) {
            addCriterion("third_type <", value, "thirdType");
            return (Criteria) this;
        }

        public Criteria andThirdTypeLessThanOrEqualTo(String value) {
            addCriterion("third_type <=", value, "thirdType");
            return (Criteria) this;
        }

        public Criteria andThirdTypeLike(String value) {
            addCriterion("third_type like", value, "thirdType");
            return (Criteria) this;
        }

        public Criteria andThirdTypeNotLike(String value) {
            addCriterion("third_type not like", value, "thirdType");
            return (Criteria) this;
        }

        public Criteria andThirdTypeIn(List<String> values) {
            addCriterion("third_type in", values, "thirdType");
            return (Criteria) this;
        }

        public Criteria andThirdTypeNotIn(List<String> values) {
            addCriterion("third_type not in", values, "thirdType");
            return (Criteria) this;
        }

        public Criteria andThirdTypeBetween(String value1, String value2) {
            addCriterion("third_type between", value1, value2, "thirdType");
            return (Criteria) this;
        }

        public Criteria andThirdTypeNotBetween(String value1, String value2) {
            addCriterion("third_type not between", value1, value2, "thirdType");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoIsNull() {
            addCriterion("company_logo is null");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoIsNotNull() {
            addCriterion("company_logo is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoEqualTo(String value) {
            addCriterion("company_logo =", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoNotEqualTo(String value) {
            addCriterion("company_logo <>", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoGreaterThan(String value) {
            addCriterion("company_logo >", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoGreaterThanOrEqualTo(String value) {
            addCriterion("company_logo >=", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoLessThan(String value) {
            addCriterion("company_logo <", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoLessThanOrEqualTo(String value) {
            addCriterion("company_logo <=", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoLike(String value) {
            addCriterion("company_logo like", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoNotLike(String value) {
            addCriterion("company_logo not like", value, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoIn(List<String> values) {
            addCriterion("company_logo in", values, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoNotIn(List<String> values) {
            addCriterion("company_logo not in", values, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoBetween(String value1, String value2) {
            addCriterion("company_logo between", value1, value2, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andCompanyLogoNotBetween(String value1, String value2) {
            addCriterion("company_logo not between", value1, value2, "companyLogo");
            return (Criteria) this;
        }

        public Criteria andPositionLablesStrIsNull() {
            addCriterion("position_lables_str is null");
            return (Criteria) this;
        }

        public Criteria andPositionLablesStrIsNotNull() {
            addCriterion("position_lables_str is not null");
            return (Criteria) this;
        }

        public Criteria andPositionLablesStrEqualTo(String value) {
            addCriterion("position_lables_str =", value, "positionLablesStr");
            return (Criteria) this;
        }

        public Criteria andPositionLablesStrNotEqualTo(String value) {
            addCriterion("position_lables_str <>", value, "positionLablesStr");
            return (Criteria) this;
        }

        public Criteria andPositionLablesStrGreaterThan(String value) {
            addCriterion("position_lables_str >", value, "positionLablesStr");
            return (Criteria) this;
        }

        public Criteria andPositionLablesStrGreaterThanOrEqualTo(String value) {
            addCriterion("position_lables_str >=", value, "positionLablesStr");
            return (Criteria) this;
        }

        public Criteria andPositionLablesStrLessThan(String value) {
            addCriterion("position_lables_str <", value, "positionLablesStr");
            return (Criteria) this;
        }

        public Criteria andPositionLablesStrLessThanOrEqualTo(String value) {
            addCriterion("position_lables_str <=", value, "positionLablesStr");
            return (Criteria) this;
        }

        public Criteria andPositionLablesStrLike(String value) {
            addCriterion("position_lables_str like", value, "positionLablesStr");
            return (Criteria) this;
        }

        public Criteria andPositionLablesStrNotLike(String value) {
            addCriterion("position_lables_str not like", value, "positionLablesStr");
            return (Criteria) this;
        }

        public Criteria andPositionLablesStrIn(List<String> values) {
            addCriterion("position_lables_str in", values, "positionLablesStr");
            return (Criteria) this;
        }

        public Criteria andPositionLablesStrNotIn(List<String> values) {
            addCriterion("position_lables_str not in", values, "positionLablesStr");
            return (Criteria) this;
        }

        public Criteria andPositionLablesStrBetween(String value1, String value2) {
            addCriterion("position_lables_str between", value1, value2, "positionLablesStr");
            return (Criteria) this;
        }

        public Criteria andPositionLablesStrNotBetween(String value1, String value2) {
            addCriterion("position_lables_str not between", value1, value2, "positionLablesStr");
            return (Criteria) this;
        }

        public Criteria andFirstTypeIsNull() {
            addCriterion("first_type is null");
            return (Criteria) this;
        }

        public Criteria andFirstTypeIsNotNull() {
            addCriterion("first_type is not null");
            return (Criteria) this;
        }

        public Criteria andFirstTypeEqualTo(String value) {
            addCriterion("first_type =", value, "firstType");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNotEqualTo(String value) {
            addCriterion("first_type <>", value, "firstType");
            return (Criteria) this;
        }

        public Criteria andFirstTypeGreaterThan(String value) {
            addCriterion("first_type >", value, "firstType");
            return (Criteria) this;
        }

        public Criteria andFirstTypeGreaterThanOrEqualTo(String value) {
            addCriterion("first_type >=", value, "firstType");
            return (Criteria) this;
        }

        public Criteria andFirstTypeLessThan(String value) {
            addCriterion("first_type <", value, "firstType");
            return (Criteria) this;
        }

        public Criteria andFirstTypeLessThanOrEqualTo(String value) {
            addCriterion("first_type <=", value, "firstType");
            return (Criteria) this;
        }

        public Criteria andFirstTypeLike(String value) {
            addCriterion("first_type like", value, "firstType");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNotLike(String value) {
            addCriterion("first_type not like", value, "firstType");
            return (Criteria) this;
        }

        public Criteria andFirstTypeIn(List<String> values) {
            addCriterion("first_type in", values, "firstType");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNotIn(List<String> values) {
            addCriterion("first_type not in", values, "firstType");
            return (Criteria) this;
        }

        public Criteria andFirstTypeBetween(String value1, String value2) {
            addCriterion("first_type between", value1, value2, "firstType");
            return (Criteria) this;
        }

        public Criteria andFirstTypeNotBetween(String value1, String value2) {
            addCriterion("first_type not between", value1, value2, "firstType");
            return (Criteria) this;
        }

        public Criteria andFormatCreateTimeIsNull() {
            addCriterion("format_create_time is null");
            return (Criteria) this;
        }

        public Criteria andFormatCreateTimeIsNotNull() {
            addCriterion("format_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andFormatCreateTimeEqualTo(String value) {
            addCriterion("format_create_time =", value, "formatCreateTime");
            return (Criteria) this;
        }

        public Criteria andFormatCreateTimeNotEqualTo(String value) {
            addCriterion("format_create_time <>", value, "formatCreateTime");
            return (Criteria) this;
        }

        public Criteria andFormatCreateTimeGreaterThan(String value) {
            addCriterion("format_create_time >", value, "formatCreateTime");
            return (Criteria) this;
        }

        public Criteria andFormatCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("format_create_time >=", value, "formatCreateTime");
            return (Criteria) this;
        }

        public Criteria andFormatCreateTimeLessThan(String value) {
            addCriterion("format_create_time <", value, "formatCreateTime");
            return (Criteria) this;
        }

        public Criteria andFormatCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("format_create_time <=", value, "formatCreateTime");
            return (Criteria) this;
        }

        public Criteria andFormatCreateTimeLike(String value) {
            addCriterion("format_create_time like", value, "formatCreateTime");
            return (Criteria) this;
        }

        public Criteria andFormatCreateTimeNotLike(String value) {
            addCriterion("format_create_time not like", value, "formatCreateTime");
            return (Criteria) this;
        }

        public Criteria andFormatCreateTimeIn(List<String> values) {
            addCriterion("format_create_time in", values, "formatCreateTime");
            return (Criteria) this;
        }

        public Criteria andFormatCreateTimeNotIn(List<String> values) {
            addCriterion("format_create_time not in", values, "formatCreateTime");
            return (Criteria) this;
        }

        public Criteria andFormatCreateTimeBetween(String value1, String value2) {
            addCriterion("format_create_time between", value1, value2, "formatCreateTime");
            return (Criteria) this;
        }

        public Criteria andFormatCreateTimeNotBetween(String value1, String value2) {
            addCriterion("format_create_time not between", value1, value2, "formatCreateTime");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNull() {
            addCriterion("position_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNotNull() {
            addCriterion("position_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIdEqualTo(Integer value) {
            addCriterion("position_id =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotEqualTo(Integer value) {
            addCriterion("position_id <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThan(Integer value) {
            addCriterion("position_id >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("position_id >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThan(Integer value) {
            addCriterion("position_id <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThanOrEqualTo(Integer value) {
            addCriterion("position_id <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIn(List<Integer> values) {
            addCriterion("position_id in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotIn(List<Integer> values) {
            addCriterion("position_id not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdBetween(Integer value1, Integer value2) {
            addCriterion("position_id between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("position_id not between", value1, value2, "positionId");
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

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andApproveIsNull() {
            addCriterion("approve is null");
            return (Criteria) this;
        }

        public Criteria andApproveIsNotNull() {
            addCriterion("approve is not null");
            return (Criteria) this;
        }

        public Criteria andApproveEqualTo(Integer value) {
            addCriterion("approve =", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotEqualTo(Integer value) {
            addCriterion("approve <>", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveGreaterThan(Integer value) {
            addCriterion("approve >", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveGreaterThanOrEqualTo(Integer value) {
            addCriterion("approve >=", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveLessThan(Integer value) {
            addCriterion("approve <", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveLessThanOrEqualTo(Integer value) {
            addCriterion("approve <=", value, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveIn(List<Integer> values) {
            addCriterion("approve in", values, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotIn(List<Integer> values) {
            addCriterion("approve not in", values, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveBetween(Integer value1, Integer value2) {
            addCriterion("approve between", value1, value2, "approve");
            return (Criteria) this;
        }

        public Criteria andApproveNotBetween(Integer value1, Integer value2) {
            addCriterion("approve not between", value1, value2, "approve");
            return (Criteria) this;
        }

        public Criteria andIndustryFieldIsNull() {
            addCriterion("industry_field is null");
            return (Criteria) this;
        }

        public Criteria andIndustryFieldIsNotNull() {
            addCriterion("industry_field is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryFieldEqualTo(String value) {
            addCriterion("industry_field =", value, "industryField");
            return (Criteria) this;
        }

        public Criteria andIndustryFieldNotEqualTo(String value) {
            addCriterion("industry_field <>", value, "industryField");
            return (Criteria) this;
        }

        public Criteria andIndustryFieldGreaterThan(String value) {
            addCriterion("industry_field >", value, "industryField");
            return (Criteria) this;
        }

        public Criteria andIndustryFieldGreaterThanOrEqualTo(String value) {
            addCriterion("industry_field >=", value, "industryField");
            return (Criteria) this;
        }

        public Criteria andIndustryFieldLessThan(String value) {
            addCriterion("industry_field <", value, "industryField");
            return (Criteria) this;
        }

        public Criteria andIndustryFieldLessThanOrEqualTo(String value) {
            addCriterion("industry_field <=", value, "industryField");
            return (Criteria) this;
        }

        public Criteria andIndustryFieldLike(String value) {
            addCriterion("industry_field like", value, "industryField");
            return (Criteria) this;
        }

        public Criteria andIndustryFieldNotLike(String value) {
            addCriterion("industry_field not like", value, "industryField");
            return (Criteria) this;
        }

        public Criteria andIndustryFieldIn(List<String> values) {
            addCriterion("industry_field in", values, "industryField");
            return (Criteria) this;
        }

        public Criteria andIndustryFieldNotIn(List<String> values) {
            addCriterion("industry_field not in", values, "industryField");
            return (Criteria) this;
        }

        public Criteria andIndustryFieldBetween(String value1, String value2) {
            addCriterion("industry_field between", value1, value2, "industryField");
            return (Criteria) this;
        }

        public Criteria andIndustryFieldNotBetween(String value1, String value2) {
            addCriterion("industry_field not between", value1, value2, "industryField");
            return (Criteria) this;
        }

        public Criteria andCompanyLabelListStrIsNull() {
            addCriterion("company_label_list_str is null");
            return (Criteria) this;
        }

        public Criteria andCompanyLabelListStrIsNotNull() {
            addCriterion("company_label_list_str is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyLabelListStrEqualTo(String value) {
            addCriterion("company_label_list_str =", value, "companyLabelListStr");
            return (Criteria) this;
        }

        public Criteria andCompanyLabelListStrNotEqualTo(String value) {
            addCriterion("company_label_list_str <>", value, "companyLabelListStr");
            return (Criteria) this;
        }

        public Criteria andCompanyLabelListStrGreaterThan(String value) {
            addCriterion("company_label_list_str >", value, "companyLabelListStr");
            return (Criteria) this;
        }

        public Criteria andCompanyLabelListStrGreaterThanOrEqualTo(String value) {
            addCriterion("company_label_list_str >=", value, "companyLabelListStr");
            return (Criteria) this;
        }

        public Criteria andCompanyLabelListStrLessThan(String value) {
            addCriterion("company_label_list_str <", value, "companyLabelListStr");
            return (Criteria) this;
        }

        public Criteria andCompanyLabelListStrLessThanOrEqualTo(String value) {
            addCriterion("company_label_list_str <=", value, "companyLabelListStr");
            return (Criteria) this;
        }

        public Criteria andCompanyLabelListStrLike(String value) {
            addCriterion("company_label_list_str like", value, "companyLabelListStr");
            return (Criteria) this;
        }

        public Criteria andCompanyLabelListStrNotLike(String value) {
            addCriterion("company_label_list_str not like", value, "companyLabelListStr");
            return (Criteria) this;
        }

        public Criteria andCompanyLabelListStrIn(List<String> values) {
            addCriterion("company_label_list_str in", values, "companyLabelListStr");
            return (Criteria) this;
        }

        public Criteria andCompanyLabelListStrNotIn(List<String> values) {
            addCriterion("company_label_list_str not in", values, "companyLabelListStr");
            return (Criteria) this;
        }

        public Criteria andCompanyLabelListStrBetween(String value1, String value2) {
            addCriterion("company_label_list_str between", value1, value2, "companyLabelListStr");
            return (Criteria) this;
        }

        public Criteria andCompanyLabelListStrNotBetween(String value1, String value2) {
            addCriterion("company_label_list_str not between", value1, value2, "companyLabelListStr");
            return (Criteria) this;
        }

        public Criteria andResumeProcessRateIsNull() {
            addCriterion("resume_process_rate is null");
            return (Criteria) this;
        }

        public Criteria andResumeProcessRateIsNotNull() {
            addCriterion("resume_process_rate is not null");
            return (Criteria) this;
        }

        public Criteria andResumeProcessRateEqualTo(Integer value) {
            addCriterion("resume_process_rate =", value, "resumeProcessRate");
            return (Criteria) this;
        }

        public Criteria andResumeProcessRateNotEqualTo(Integer value) {
            addCriterion("resume_process_rate <>", value, "resumeProcessRate");
            return (Criteria) this;
        }

        public Criteria andResumeProcessRateGreaterThan(Integer value) {
            addCriterion("resume_process_rate >", value, "resumeProcessRate");
            return (Criteria) this;
        }

        public Criteria andResumeProcessRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("resume_process_rate >=", value, "resumeProcessRate");
            return (Criteria) this;
        }

        public Criteria andResumeProcessRateLessThan(Integer value) {
            addCriterion("resume_process_rate <", value, "resumeProcessRate");
            return (Criteria) this;
        }

        public Criteria andResumeProcessRateLessThanOrEqualTo(Integer value) {
            addCriterion("resume_process_rate <=", value, "resumeProcessRate");
            return (Criteria) this;
        }

        public Criteria andResumeProcessRateIn(List<Integer> values) {
            addCriterion("resume_process_rate in", values, "resumeProcessRate");
            return (Criteria) this;
        }

        public Criteria andResumeProcessRateNotIn(List<Integer> values) {
            addCriterion("resume_process_rate not in", values, "resumeProcessRate");
            return (Criteria) this;
        }

        public Criteria andResumeProcessRateBetween(Integer value1, Integer value2) {
            addCriterion("resume_process_rate between", value1, value2, "resumeProcessRate");
            return (Criteria) this;
        }

        public Criteria andResumeProcessRateNotBetween(Integer value1, Integer value2) {
            addCriterion("resume_process_rate not between", value1, value2, "resumeProcessRate");
            return (Criteria) this;
        }

        public Criteria andWorkYearIsNull() {
            addCriterion("work_year is null");
            return (Criteria) this;
        }

        public Criteria andWorkYearIsNotNull() {
            addCriterion("work_year is not null");
            return (Criteria) this;
        }

        public Criteria andWorkYearEqualTo(String value) {
            addCriterion("work_year =", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearNotEqualTo(String value) {
            addCriterion("work_year <>", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearGreaterThan(String value) {
            addCriterion("work_year >", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearGreaterThanOrEqualTo(String value) {
            addCriterion("work_year >=", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearLessThan(String value) {
            addCriterion("work_year <", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearLessThanOrEqualTo(String value) {
            addCriterion("work_year <=", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearLike(String value) {
            addCriterion("work_year like", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearNotLike(String value) {
            addCriterion("work_year not like", value, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearIn(List<String> values) {
            addCriterion("work_year in", values, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearNotIn(List<String> values) {
            addCriterion("work_year not in", values, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearBetween(String value1, String value2) {
            addCriterion("work_year between", value1, value2, "workYear");
            return (Criteria) this;
        }

        public Criteria andWorkYearNotBetween(String value1, String value2) {
            addCriterion("work_year not between", value1, value2, "workYear");
            return (Criteria) this;
        }

        public Criteria andImStateIsNull() {
            addCriterion("im_state is null");
            return (Criteria) this;
        }

        public Criteria andImStateIsNotNull() {
            addCriterion("im_state is not null");
            return (Criteria) this;
        }

        public Criteria andImStateEqualTo(String value) {
            addCriterion("im_state =", value, "imState");
            return (Criteria) this;
        }

        public Criteria andImStateNotEqualTo(String value) {
            addCriterion("im_state <>", value, "imState");
            return (Criteria) this;
        }

        public Criteria andImStateGreaterThan(String value) {
            addCriterion("im_state >", value, "imState");
            return (Criteria) this;
        }

        public Criteria andImStateGreaterThanOrEqualTo(String value) {
            addCriterion("im_state >=", value, "imState");
            return (Criteria) this;
        }

        public Criteria andImStateLessThan(String value) {
            addCriterion("im_state <", value, "imState");
            return (Criteria) this;
        }

        public Criteria andImStateLessThanOrEqualTo(String value) {
            addCriterion("im_state <=", value, "imState");
            return (Criteria) this;
        }

        public Criteria andImStateLike(String value) {
            addCriterion("im_state like", value, "imState");
            return (Criteria) this;
        }

        public Criteria andImStateNotLike(String value) {
            addCriterion("im_state not like", value, "imState");
            return (Criteria) this;
        }

        public Criteria andImStateIn(List<String> values) {
            addCriterion("im_state in", values, "imState");
            return (Criteria) this;
        }

        public Criteria andImStateNotIn(List<String> values) {
            addCriterion("im_state not in", values, "imState");
            return (Criteria) this;
        }

        public Criteria andImStateBetween(String value1, String value2) {
            addCriterion("im_state between", value1, value2, "imState");
            return (Criteria) this;
        }

        public Criteria andImStateNotBetween(String value1, String value2) {
            addCriterion("im_state not between", value1, value2, "imState");
            return (Criteria) this;
        }

        public Criteria andSubwaylineIsNull() {
            addCriterion("subwayline is null");
            return (Criteria) this;
        }

        public Criteria andSubwaylineIsNotNull() {
            addCriterion("subwayline is not null");
            return (Criteria) this;
        }

        public Criteria andSubwaylineEqualTo(String value) {
            addCriterion("subwayline =", value, "subwayline");
            return (Criteria) this;
        }

        public Criteria andSubwaylineNotEqualTo(String value) {
            addCriterion("subwayline <>", value, "subwayline");
            return (Criteria) this;
        }

        public Criteria andSubwaylineGreaterThan(String value) {
            addCriterion("subwayline >", value, "subwayline");
            return (Criteria) this;
        }

        public Criteria andSubwaylineGreaterThanOrEqualTo(String value) {
            addCriterion("subwayline >=", value, "subwayline");
            return (Criteria) this;
        }

        public Criteria andSubwaylineLessThan(String value) {
            addCriterion("subwayline <", value, "subwayline");
            return (Criteria) this;
        }

        public Criteria andSubwaylineLessThanOrEqualTo(String value) {
            addCriterion("subwayline <=", value, "subwayline");
            return (Criteria) this;
        }

        public Criteria andSubwaylineLike(String value) {
            addCriterion("subwayline like", value, "subwayline");
            return (Criteria) this;
        }

        public Criteria andSubwaylineNotLike(String value) {
            addCriterion("subwayline not like", value, "subwayline");
            return (Criteria) this;
        }

        public Criteria andSubwaylineIn(List<String> values) {
            addCriterion("subwayline in", values, "subwayline");
            return (Criteria) this;
        }

        public Criteria andSubwaylineNotIn(List<String> values) {
            addCriterion("subwayline not in", values, "subwayline");
            return (Criteria) this;
        }

        public Criteria andSubwaylineBetween(String value1, String value2) {
            addCriterion("subwayline between", value1, value2, "subwayline");
            return (Criteria) this;
        }

        public Criteria andSubwaylineNotBetween(String value1, String value2) {
            addCriterion("subwayline not between", value1, value2, "subwayline");
            return (Criteria) this;
        }

        public Criteria andAdWordIsNull() {
            addCriterion("ad_word is null");
            return (Criteria) this;
        }

        public Criteria andAdWordIsNotNull() {
            addCriterion("ad_word is not null");
            return (Criteria) this;
        }

        public Criteria andAdWordEqualTo(Integer value) {
            addCriterion("ad_word =", value, "adWord");
            return (Criteria) this;
        }

        public Criteria andAdWordNotEqualTo(Integer value) {
            addCriterion("ad_word <>", value, "adWord");
            return (Criteria) this;
        }

        public Criteria andAdWordGreaterThan(Integer value) {
            addCriterion("ad_word >", value, "adWord");
            return (Criteria) this;
        }

        public Criteria andAdWordGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_word >=", value, "adWord");
            return (Criteria) this;
        }

        public Criteria andAdWordLessThan(Integer value) {
            addCriterion("ad_word <", value, "adWord");
            return (Criteria) this;
        }

        public Criteria andAdWordLessThanOrEqualTo(Integer value) {
            addCriterion("ad_word <=", value, "adWord");
            return (Criteria) this;
        }

        public Criteria andAdWordIn(List<Integer> values) {
            addCriterion("ad_word in", values, "adWord");
            return (Criteria) this;
        }

        public Criteria andAdWordNotIn(List<Integer> values) {
            addCriterion("ad_word not in", values, "adWord");
            return (Criteria) this;
        }

        public Criteria andAdWordBetween(Integer value1, Integer value2) {
            addCriterion("ad_word between", value1, value2, "adWord");
            return (Criteria) this;
        }

        public Criteria andAdWordNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_word not between", value1, value2, "adWord");
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