package com.shineon.coder.db.pojo;

import java.util.Date;

public class ShineonUserAttached {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user_attached.id
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user_attached.userId
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user_attached.timeLastLogin
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    private Date timelastlogin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user_attached.ipLastLogin
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    private Date iplastlogin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user_attached.state
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    private Byte state;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user_attached.id
     *
     * @return the value of shineon_user_attached.id
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user_attached.id
     *
     * @param id the value for shineon_user_attached.id
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user_attached.userId
     *
     * @return the value of shineon_user_attached.userId
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user_attached.userId
     *
     * @param userid the value for shineon_user_attached.userId
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user_attached.timeLastLogin
     *
     * @return the value of shineon_user_attached.timeLastLogin
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    public Date getTimelastlogin() {
        return timelastlogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user_attached.timeLastLogin
     *
     * @param timelastlogin the value for shineon_user_attached.timeLastLogin
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    public void setTimelastlogin(Date timelastlogin) {
        this.timelastlogin = timelastlogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user_attached.ipLastLogin
     *
     * @return the value of shineon_user_attached.ipLastLogin
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    public Date getIplastlogin() {
        return iplastlogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user_attached.ipLastLogin
     *
     * @param iplastlogin the value for shineon_user_attached.ipLastLogin
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    public void setIplastlogin(Date iplastlogin) {
        this.iplastlogin = iplastlogin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user_attached.state
     *
     * @return the value of shineon_user_attached.state
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    public Byte getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user_attached.state
     *
     * @param state the value for shineon_user_attached.state
     *
     * @mbggenerated Fri Sep 20 10:23:44 CST 2019
     */
    public void setState(Byte state) {
        this.state = state;
    }
}