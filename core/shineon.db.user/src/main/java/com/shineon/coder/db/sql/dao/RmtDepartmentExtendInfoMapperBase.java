package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtDepartmentExtendInfo;

public interface RmtDepartmentExtendInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    int insert(RmtDepartmentExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    int insertSelective(RmtDepartmentExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    RmtDepartmentExtendInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    int updateByPrimaryKeySelective(RmtDepartmentExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_extend_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    int updateByPrimaryKey(RmtDepartmentExtendInfo record);
}