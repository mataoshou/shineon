package com.shineon.coder.db.dao;

import com.shineon.coder.db.pojo.ShineonUser;
import java.util.List;

public interface ShineonUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user
     *
     * @mbggenerated Mon Jul 29 14:14:38 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user
     *
     * @mbggenerated Mon Jul 29 14:14:38 CST 2019
     */
    int insert(ShineonUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user
     *
     * @mbggenerated Mon Jul 29 14:14:38 CST 2019
     */
    ShineonUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user
     *
     * @mbggenerated Mon Jul 29 14:14:38 CST 2019
     */
    List<ShineonUser> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_user
     *
     * @mbggenerated Mon Jul 29 14:14:38 CST 2019
     */
    int updateByPrimaryKey(ShineonUser record);
}