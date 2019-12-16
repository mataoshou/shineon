package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtTenantExtendInfo;

public interface RmtTenantExtendInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_extend_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_extend_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int insert(RmtTenantExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_extend_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int insertSelective(RmtTenantExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_extend_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    RmtTenantExtendInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_extend_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int updateByPrimaryKeySelective(RmtTenantExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_extend_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int updateByPrimaryKey(RmtTenantExtendInfo record);
}