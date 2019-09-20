package com.shineon.coder.db.dao;

import com.shineon.coder.db.pojo.ShineonBaseZone;

public interface ShineonBaseZoneMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_base_zone
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    int deleteByPrimaryKey(Long znid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_base_zone
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    int insert(ShineonBaseZone record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_base_zone
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    int insertSelective(ShineonBaseZone record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_base_zone
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    ShineonBaseZone selectByPrimaryKey(Long znid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_base_zone
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    int updateByPrimaryKeySelective(ShineonBaseZone record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_base_zone
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    int updateByPrimaryKey(ShineonBaseZone record);
}