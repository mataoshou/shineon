package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtUserLogin;

public interface RmtUserLoginMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int insert(RmtUserLogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int insertSelective(RmtUserLogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    RmtUserLogin selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int updateByPrimaryKeySelective(RmtUserLogin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    int updateByPrimaryKey(RmtUserLogin record);
}