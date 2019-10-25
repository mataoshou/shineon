package com.shineon.coder.db.sql.pojo;

public class RmtPrivilegeGroup {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_privilege_group.id
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_privilege_group.privilegeGroupName
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    private String privilegegroupname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_privilege_group.privilegeGroupType
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    private Integer privilegegrouptype;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_privilege_group.description
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_privilege_group.showOrder
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    private Integer showorder;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rmt_privilege_group.privilegeSet
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    private String privilegeset;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_privilege_group.id
     *
     * @return the value of rmt_privilege_group.id
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_privilege_group.id
     *
     * @param id the value for rmt_privilege_group.id
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_privilege_group.privilegeGroupName
     *
     * @return the value of rmt_privilege_group.privilegeGroupName
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    public String getPrivilegegroupname() {
        return privilegegroupname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_privilege_group.privilegeGroupName
     *
     * @param privilegegroupname the value for rmt_privilege_group.privilegeGroupName
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    public void setPrivilegegroupname(String privilegegroupname) {
        this.privilegegroupname = privilegegroupname == null ? null : privilegegroupname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_privilege_group.privilegeGroupType
     *
     * @return the value of rmt_privilege_group.privilegeGroupType
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    public Integer getPrivilegegrouptype() {
        return privilegegrouptype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_privilege_group.privilegeGroupType
     *
     * @param privilegegrouptype the value for rmt_privilege_group.privilegeGroupType
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    public void setPrivilegegrouptype(Integer privilegegrouptype) {
        this.privilegegrouptype = privilegegrouptype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_privilege_group.description
     *
     * @return the value of rmt_privilege_group.description
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_privilege_group.description
     *
     * @param description the value for rmt_privilege_group.description
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_privilege_group.showOrder
     *
     * @return the value of rmt_privilege_group.showOrder
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    public Integer getShoworder() {
        return showorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_privilege_group.showOrder
     *
     * @param showorder the value for rmt_privilege_group.showOrder
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    public void setShoworder(Integer showorder) {
        this.showorder = showorder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rmt_privilege_group.privilegeSet
     *
     * @return the value of rmt_privilege_group.privilegeSet
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    public String getPrivilegeset() {
        return privilegeset;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rmt_privilege_group.privilegeSet
     *
     * @param privilegeset the value for rmt_privilege_group.privilegeSet
     *
     * @mbggenerated Wed Oct 23 14:59:54 CST 2019
     */
    public void setPrivilegeset(String privilegeset) {
        this.privilegeset = privilegeset == null ? null : privilegeset.trim();
    }
}