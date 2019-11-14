package com.shineon.coder.db.sql.dao;

import com.shineon.coder.db.sql.pojo.RmtPrivilegeInfo;

public interface RmtPrivilegeInfoMapperBase {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_privilege_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_privilege_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int insert(RmtPrivilegeInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_privilege_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int insertSelective(RmtPrivilegeInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_privilege_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    RmtPrivilegeInfo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_privilege_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int updateByPrimaryKeySelective(RmtPrivilegeInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_privilege_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int updateByPrimaryKeyWithBLOBs(RmtPrivilegeInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table rmt_privilege_info
     *
     * @mbggenerated Fri Nov 08 17:30:18 CST 2019
     */
    int updateByPrimaryKey(RmtPrivilegeInfo record);
}