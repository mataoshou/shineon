package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtTenantChartInfo;

public interface RmtTenantChartInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_chart_info
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_chart_info
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int insert(RmtTenantChartInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_chart_info
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int insertSelective(RmtTenantChartInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_chart_info
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    RmtTenantChartInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_chart_info
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int updateByPrimaryKeySelective(RmtTenantChartInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_chart_info
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int updateByPrimaryKey(RmtTenantChartInfo record);
}