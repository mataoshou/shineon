package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtUserLoginInfo;

public interface RmtUserLoginInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login_info
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login_info
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    int insert(RmtUserLoginInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login_info
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    int insertSelective(RmtUserLoginInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login_info
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    RmtUserLoginInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login_info
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    int updateByPrimaryKeySelective(RmtUserLoginInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_login_info
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    int updateByPrimaryKey(RmtUserLoginInfo record);
}