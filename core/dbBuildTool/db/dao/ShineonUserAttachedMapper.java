package com.shineon.coder.db.dao;

import com.shineon.coder.db.pojo.ShineonUserAttached;

public interface ShineonUserAttachedMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Wed Sep 18 14:22:51 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Wed Sep 18 14:22:51 CST 2019
     */
    int insert(ShineonUserAttached record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Wed Sep 18 14:22:51 CST 2019
     */
    int insertSelective(ShineonUserAttached record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Wed Sep 18 14:22:51 CST 2019
     */
    ShineonUserAttached selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Wed Sep 18 14:22:51 CST 2019
     */
    int updateByPrimaryKeySelective(ShineonUserAttached record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user_attached
     *
     * @mbggenerated Wed Sep 18 14:22:51 CST 2019
     */
    int updateByPrimaryKey(ShineonUserAttached record);
}