package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtOperateGroupInfo;

public interface RmtOperateGroupInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_group_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_group_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int insert(RmtOperateGroupInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_group_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int insertSelective(RmtOperateGroupInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_group_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    RmtOperateGroupInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_group_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int updateByPrimaryKeySelective(RmtOperateGroupInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_group_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(RmtOperateGroupInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_group_info
     *
     * @mbggenerated Mon Dec 16 17:06:58 CST 2019
     */
    int updateByPrimaryKey(RmtOperateGroupInfo record);
}