package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtOrganizationDepartmentInfo;

public interface RmtOrganizationDepartmentInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_department_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_department_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int insert(RmtOrganizationDepartmentInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_department_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int insertSelective(RmtOrganizationDepartmentInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_department_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    RmtOrganizationDepartmentInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_department_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int updateByPrimaryKeySelective(RmtOrganizationDepartmentInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_organization_department_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int updateByPrimaryKey(RmtOrganizationDepartmentInfo record);
}