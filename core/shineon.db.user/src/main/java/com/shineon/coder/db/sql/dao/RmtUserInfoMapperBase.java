package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtUserInfo;

public interface RmtUserInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int insert(RmtUserInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int insertSelective(RmtUserInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    RmtUserInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int updateByPrimaryKeySelective(RmtUserInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int updateByPrimaryKey(RmtUserInfo record);
}