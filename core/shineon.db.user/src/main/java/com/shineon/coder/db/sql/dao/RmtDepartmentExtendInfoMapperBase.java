package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtDepartmentExtendInfo;

public interface RmtDepartmentExtendInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Mon Oct 28 16:10:59 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Mon Oct 28 16:10:59 CST 2019
     */
    int insert(RmtDepartmentExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Mon Oct 28 16:10:59 CST 2019
     */
    int insertSelective(RmtDepartmentExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Mon Oct 28 16:10:59 CST 2019
     */
    RmtDepartmentExtendInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Mon Oct 28 16:10:59 CST 2019
     */
    int updateByPrimaryKeySelective(RmtDepartmentExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Mon Oct 28 16:10:59 CST 2019
     */
    int updateByPrimaryKey(RmtDepartmentExtendInfo record);
}