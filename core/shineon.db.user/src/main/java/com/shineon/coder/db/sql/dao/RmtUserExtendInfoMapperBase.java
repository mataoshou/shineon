package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtUserExtendInfo;

public interface RmtUserExtendInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_extend_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_extend_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int insert(RmtUserExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_extend_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int insertSelective(RmtUserExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_extend_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    RmtUserExtendInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_extend_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int updateByPrimaryKeySelective(RmtUserExtendInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_extend_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int updateByPrimaryKey(RmtUserExtendInfo record);
}