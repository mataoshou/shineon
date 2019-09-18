package com.shineon.coder.db.dao;

import com.shineon.coder.db.pojo.ShineonBaseRegion;

public interface ShineonBaseRegionMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_base_region
     *
     * @mbggenerated Wed Sep 18 15:16:53 CST 2019
     */
    int deleteByPrimaryKey(Long rgid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_base_region
     *
     * @mbggenerated Wed Sep 18 15:16:53 CST 2019
     */
    int insert(ShineonBaseRegion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_base_region
     *
     * @mbggenerated Wed Sep 18 15:16:53 CST 2019
     */
    int insertSelective(ShineonBaseRegion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_base_region
     *
     * @mbggenerated Wed Sep 18 15:16:53 CST 2019
     */
    ShineonBaseRegion selectByPrimaryKey(Long rgid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_base_region
     *
     * @mbggenerated Wed Sep 18 15:16:53 CST 2019
     */
    int updateByPrimaryKeySelective(ShineonBaseRegion record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table shineon_base_region
     *
     * @mbggenerated Wed Sep 18 15:16:53 CST 2019
     */
    int updateByPrimaryKey(ShineonBaseRegion record);
}