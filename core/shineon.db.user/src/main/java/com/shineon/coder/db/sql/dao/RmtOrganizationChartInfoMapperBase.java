package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtOrganizationChartInfo;

public interface RmtOrganizationChartInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_chart_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_chart_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int insert(RmtOrganizationChartInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_chart_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int insertSelective(RmtOrganizationChartInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_chart_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    RmtOrganizationChartInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_chart_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int updateByPrimaryKeySelective(RmtOrganizationChartInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_chart_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int updateByPrimaryKey(RmtOrganizationChartInfo record);
}