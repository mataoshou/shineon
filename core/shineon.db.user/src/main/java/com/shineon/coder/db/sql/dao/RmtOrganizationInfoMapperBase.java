package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtOrganizationInfo;

public interface RmtOrganizationInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int insert(RmtOrganizationInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int insertSelective(RmtOrganizationInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    RmtOrganizationInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int updateByPrimaryKeySelective(RmtOrganizationInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int updateByPrimaryKey(RmtOrganizationInfo record);
}