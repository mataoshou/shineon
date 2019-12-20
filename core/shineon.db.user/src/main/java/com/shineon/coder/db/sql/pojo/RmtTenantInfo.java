package com.shineon.coder.db.sql.pojo;

import java.util.Date;

public class RmtTenantInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_tenant_info.id
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_tenant_info.tenantID
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    private String tenantid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_tenant_info.tenantCode
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    private Integer tenantcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_tenant_info.tenantName
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    private String tenantname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_tenant_info.tenantType
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    private Byte tenanttype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_tenant_info.tenantState
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    private Byte tenantstate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_tenant_info.createTime
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_tenant_info.createdUserID
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    private String createduserid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_tenant_info.organizationID
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    private String organizationid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_tenant_info.tenantExpiryDate
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    private Date tenantexpirydate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_tenant_info.tenantExtendID
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    private String tenantextendid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_tenant_info.reserved1
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    private Integer reserved1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_tenant_info.reserved2
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    private String reserved2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_tenant_info.tenantAdminSet
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    private String tenantadminset;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_tenant_info.id
     *
     * @return the value of rmt_tenant_info.id
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_tenant_info.id
     *
     * @param id the value for rmt_tenant_info.id
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_tenant_info.tenantID
     *
     * @return the value of rmt_tenant_info.tenantID
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public String getTenantid() {
        return tenantid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_tenant_info.tenantID
     *
     * @param tenantid the value for rmt_tenant_info.tenantID
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public void setTenantid(String tenantid) {
        this.tenantid = tenantid == null ? null : tenantid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_tenant_info.tenantCode
     *
     * @return the value of rmt_tenant_info.tenantCode
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public Integer getTenantcode() {
        return tenantcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_tenant_info.tenantCode
     *
     * @param tenantcode the value for rmt_tenant_info.tenantCode
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public void setTenantcode(Integer tenantcode) {
        this.tenantcode = tenantcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_tenant_info.tenantName
     *
     * @return the value of rmt_tenant_info.tenantName
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public String getTenantname() {
        return tenantname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_tenant_info.tenantName
     *
     * @param tenantname the value for rmt_tenant_info.tenantName
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public void setTenantname(String tenantname) {
        this.tenantname = tenantname == null ? null : tenantname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_tenant_info.tenantType
     *
     * @return the value of rmt_tenant_info.tenantType
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public Byte getTenanttype() {
        return tenanttype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_tenant_info.tenantType
     *
     * @param tenanttype the value for rmt_tenant_info.tenantType
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public void setTenanttype(Byte tenanttype) {
        this.tenanttype = tenanttype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_tenant_info.tenantState
     *
     * @return the value of rmt_tenant_info.tenantState
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public Byte getTenantstate() {
        return tenantstate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_tenant_info.tenantState
     *
     * @param tenantstate the value for rmt_tenant_info.tenantState
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public void setTenantstate(Byte tenantstate) {
        this.tenantstate = tenantstate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_tenant_info.createTime
     *
     * @return the value of rmt_tenant_info.createTime
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_tenant_info.createTime
     *
     * @param createtime the value for rmt_tenant_info.createTime
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_tenant_info.createdUserID
     *
     * @return the value of rmt_tenant_info.createdUserID
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public String getCreateduserid() {
        return createduserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_tenant_info.createdUserID
     *
     * @param createduserid the value for rmt_tenant_info.createdUserID
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public void setCreateduserid(String createduserid) {
        this.createduserid = createduserid == null ? null : createduserid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_tenant_info.organizationID
     *
     * @return the value of rmt_tenant_info.organizationID
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public String getOrganizationid() {
        return organizationid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_tenant_info.organizationID
     *
     * @param organizationid the value for rmt_tenant_info.organizationID
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public void setOrganizationid(String organizationid) {
        this.organizationid = organizationid == null ? null : organizationid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_tenant_info.tenantExpiryDate
     *
     * @return the value of rmt_tenant_info.tenantExpiryDate
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public Date getTenantexpirydate() {
        return tenantexpirydate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_tenant_info.tenantExpiryDate
     *
     * @param tenantexpirydate the value for rmt_tenant_info.tenantExpiryDate
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public void setTenantexpirydate(Date tenantexpirydate) {
        this.tenantexpirydate = tenantexpirydate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_tenant_info.tenantExtendID
     *
     * @return the value of rmt_tenant_info.tenantExtendID
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public String getTenantextendid() {
        return tenantextendid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_tenant_info.tenantExtendID
     *
     * @param tenantextendid the value for rmt_tenant_info.tenantExtendID
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public void setTenantextendid(String tenantextendid) {
        this.tenantextendid = tenantextendid == null ? null : tenantextendid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_tenant_info.reserved1
     *
     * @return the value of rmt_tenant_info.reserved1
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public Integer getReserved1() {
        return reserved1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_tenant_info.reserved1
     *
     * @param reserved1 the value for rmt_tenant_info.reserved1
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public void setReserved1(Integer reserved1) {
        this.reserved1 = reserved1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_tenant_info.reserved2
     *
     * @return the value of rmt_tenant_info.reserved2
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public String getReserved2() {
        return reserved2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_tenant_info.reserved2
     *
     * @param reserved2 the value for rmt_tenant_info.reserved2
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2 == null ? null : reserved2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_tenant_info.tenantAdminSet
     *
     * @return the value of rmt_tenant_info.tenantAdminSet
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public String getTenantadminset() {
        return tenantadminset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_tenant_info.tenantAdminSet
     *
     * @param tenantadminset the value for rmt_tenant_info.tenantAdminSet
     *
     * @mbggenerated Fri Dec 20 14:44:36 CST 2019
     */
    public void setTenantadminset(String tenantadminset) {
        this.tenantadminset = tenantadminset == null ? null : tenantadminset.trim();
    }
}