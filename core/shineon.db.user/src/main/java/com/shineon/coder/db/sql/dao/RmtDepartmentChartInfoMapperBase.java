package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtDepartmentChartInfo;

public interface RmtDepartmentChartInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_chart_info
     *
     * @mbggenerated Mon Oct 28 16:10:59 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_chart_info
     *
     * @mbggenerated Mon Oct 28 16:10:59 CST 2019
     */
    int insert(RmtDepartmentChartInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_chart_info
     *
     * @mbggenerated Mon Oct 28 16:10:59 CST 2019
     */
    int insertSelective(RmtDepartmentChartInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_chart_info
     *
     * @mbggenerated Mon Oct 28 16:10:59 CST 2019
     */
    RmtDepartmentChartInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_chart_info
     *
     * @mbggenerated Mon Oct 28 16:10:59 CST 2019
     */
    int updateByPrimaryKeySelective(RmtDepartmentChartInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_chart_info
     *
     * @mbggenerated Mon Oct 28 16:10:59 CST 2019
     */
    int updateByPrimaryKey(RmtDepartmentChartInfo record);
}