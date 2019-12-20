package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtDepartmentInfo;

public interface RmtDepartmentInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_info
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_info
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    int insert(RmtDepartmentInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_info
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    int insertSelective(RmtDepartmentInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_info
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    RmtDepartmentInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_info
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    int updateByPrimaryKeySelective(RmtDepartmentInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_department_info
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    int updateByPrimaryKey(RmtDepartmentInfo record);
}