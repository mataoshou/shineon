package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtUserLoginInfo;

public interface RmtUserLoginInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    int insert(RmtUserLoginInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    int insertSelective(RmtUserLoginInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    RmtUserLoginInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    int updateByPrimaryKeySelective(RmtUserLoginInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    int updateByPrimaryKey(RmtUserLoginInfo record);
}