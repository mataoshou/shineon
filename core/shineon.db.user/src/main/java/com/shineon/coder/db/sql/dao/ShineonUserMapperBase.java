package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.ShineonUser;

public interface ShineonUserMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user
     *
     * @mbggenerated Tue Oct 08 17:01:35 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user
     *
     * @mbggenerated Tue Oct 08 17:01:35 CST 2019
     */
    int insert(ShineonUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user
     *
     * @mbggenerated Tue Oct 08 17:01:35 CST 2019
     */
    int insertSelective(ShineonUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user
     *
     * @mbggenerated Tue Oct 08 17:01:35 CST 2019
     */
    ShineonUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user
     *
     * @mbggenerated Tue Oct 08 17:01:35 CST 2019
     */
    int updateByPrimaryKeySelective(ShineonUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user
     *
     * @mbggenerated Tue Oct 08 17:01:35 CST 2019
     */
    int updateByPrimaryKey(ShineonUser record);
}