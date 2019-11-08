package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtTenantInfo;

public interface RmtTenantInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int insert(RmtTenantInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int insertSelective(RmtTenantInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    RmtTenantInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int updateByPrimaryKeySelective(RmtTenantInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(RmtTenantInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_tenant_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int updateByPrimaryKey(RmtTenantInfo record);
}