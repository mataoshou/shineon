package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtUserActorInfo;

public interface RmtUserActorInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_actor_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_actor_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    int insert(RmtUserActorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_actor_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    int insertSelective(RmtUserActorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_actor_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    RmtUserActorInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_actor_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    int updateByPrimaryKeySelective(RmtUserActorInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_user_actor_info
     *
     * @mbggenerated Thu Jan 02 15:35:06 CST 2020
     */
    int updateByPrimaryKey(RmtUserActorInfo record);
}