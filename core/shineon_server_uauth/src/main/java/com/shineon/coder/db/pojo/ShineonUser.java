package com.shineon.coder.db.pojo;

import java.util.Date;

public class ShineonUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.id
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.username
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.password
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.displayName
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private String displayname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.parent
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private Integer parent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.usercode
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private String usercode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.userthumb
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private String userthumb;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.telephone
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private String telephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.usermark
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private String usermark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.userType
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private Byte usertype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.admin
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private Byte admin;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.timeCreated
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private Date timecreated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.timeModified
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private Date timemodified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.timeDeleted
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private Date timedeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.flagDeleted
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private Byte flagdeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.timeLimit
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private Date timelimit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column shineon_user.countLimit
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    private Byte countlimit;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.id
     *
     * @return the value of shineon_user.id
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.id
     *
     * @param id the value for shineon_user.id
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.username
     *
     * @return the value of shineon_user.username
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.username
     *
     * @param username the value for shineon_user.username
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.password
     *
     * @return the value of shineon_user.password
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.password
     *
     * @param password the value for shineon_user.password
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.displayName
     *
     * @return the value of shineon_user.displayName
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public String getDisplayname() {
        return displayname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.displayName
     *
     * @param displayname the value for shineon_user.displayName
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setDisplayname(String displayname) {
        this.displayname = displayname == null ? null : displayname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.parent
     *
     * @return the value of shineon_user.parent
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public Integer getParent() {
        return parent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.parent
     *
     * @param parent the value for shineon_user.parent
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setParent(Integer parent) {
        this.parent = parent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.usercode
     *
     * @return the value of shineon_user.usercode
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public String getUsercode() {
        return usercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.usercode
     *
     * @param usercode the value for shineon_user.usercode
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.userthumb
     *
     * @return the value of shineon_user.userthumb
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public String getUserthumb() {
        return userthumb;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.userthumb
     *
     * @param userthumb the value for shineon_user.userthumb
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setUserthumb(String userthumb) {
        this.userthumb = userthumb == null ? null : userthumb.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.telephone
     *
     * @return the value of shineon_user.telephone
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.telephone
     *
     * @param telephone the value for shineon_user.telephone
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.usermark
     *
     * @return the value of shineon_user.usermark
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public String getUsermark() {
        return usermark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.usermark
     *
     * @param usermark the value for shineon_user.usermark
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setUsermark(String usermark) {
        this.usermark = usermark == null ? null : usermark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.userType
     *
     * @return the value of shineon_user.userType
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public Byte getUsertype() {
        return usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.userType
     *
     * @param usertype the value for shineon_user.userType
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setUsertype(Byte usertype) {
        this.usertype = usertype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.admin
     *
     * @return the value of shineon_user.admin
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public Byte getAdmin() {
        return admin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.admin
     *
     * @param admin the value for shineon_user.admin
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setAdmin(Byte admin) {
        this.admin = admin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.timeCreated
     *
     * @return the value of shineon_user.timeCreated
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public Date getTimecreated() {
        return timecreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.timeCreated
     *
     * @param timecreated the value for shineon_user.timeCreated
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setTimecreated(Date timecreated) {
        this.timecreated = timecreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.timeModified
     *
     * @return the value of shineon_user.timeModified
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public Date getTimemodified() {
        return timemodified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.timeModified
     *
     * @param timemodified the value for shineon_user.timeModified
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setTimemodified(Date timemodified) {
        this.timemodified = timemodified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.timeDeleted
     *
     * @return the value of shineon_user.timeDeleted
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public Date getTimedeleted() {
        return timedeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.timeDeleted
     *
     * @param timedeleted the value for shineon_user.timeDeleted
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setTimedeleted(Date timedeleted) {
        this.timedeleted = timedeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.flagDeleted
     *
     * @return the value of shineon_user.flagDeleted
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public Byte getFlagdeleted() {
        return flagdeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.flagDeleted
     *
     * @param flagdeleted the value for shineon_user.flagDeleted
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setFlagdeleted(Byte flagdeleted) {
        this.flagdeleted = flagdeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.timeLimit
     *
     * @return the value of shineon_user.timeLimit
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public Date getTimelimit() {
        return timelimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.timeLimit
     *
     * @param timelimit the value for shineon_user.timeLimit
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setTimelimit(Date timelimit) {
        this.timelimit = timelimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column shineon_user.countLimit
     *
     * @return the value of shineon_user.countLimit
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public Byte getCountlimit() {
        return countlimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column shineon_user.countLimit
     *
     * @param countlimit the value for shineon_user.countLimit
     *
     * @mbggenerated Fri Jun 21 10:16:57 CST 2019
     */
    public void setCountlimit(Byte countlimit) {
        this.countlimit = countlimit;
    }
}