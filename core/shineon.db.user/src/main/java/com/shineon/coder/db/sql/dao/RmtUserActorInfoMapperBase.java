package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtUserActorInfo;

public interface RmtUserActorInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_actor_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_actor_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int insert(RmtUserActorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_actor_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int insertSelective(RmtUserActorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_actor_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    RmtUserActorInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_actor_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int updateByPrimaryKeySelective(RmtUserActorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_actor_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int updateByPrimaryKey(RmtUserActorInfo record);
}