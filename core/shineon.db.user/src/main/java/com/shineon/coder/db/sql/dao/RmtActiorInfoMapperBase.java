package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtActiorInfo;

public interface RmtActiorInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_actior_info
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_actior_info
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int insert(RmtActiorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_actior_info
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int insertSelective(RmtActiorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_actior_info
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    RmtActiorInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_actior_info
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int updateByPrimaryKeySelective(RmtActiorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_actior_info
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(RmtActiorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_actior_info
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int updateByPrimaryKey(RmtActiorInfo record);
}