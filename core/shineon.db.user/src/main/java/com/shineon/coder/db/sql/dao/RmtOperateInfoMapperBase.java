package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtOperateInfo;

public interface RmtOperateInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int insert(RmtOperateInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int insertSelective(RmtOperateInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    RmtOperateInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int updateByPrimaryKeySelective(RmtOperateInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_operate_info
     *
     * @mbggenerated Mon Dec 02 11:28:06 CST 2019
     */
    int updateByPrimaryKey(RmtOperateInfo record);
}