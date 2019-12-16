package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtOrganizationExtendInfo;

public interface RmtOrganizationExtendInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_extend_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_extend_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int insert(RmtOrganizationExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_extend_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int insertSelective(RmtOrganizationExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_extend_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    RmtOrganizationExtendInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_extend_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int updateByPrimaryKeySelective(RmtOrganizationExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_extend_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int updateByPrimaryKey(RmtOrganizationExtendInfo record);
}