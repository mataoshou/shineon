package com.shineon.coder.service.bo;

import com.shineon.coder.db.sql.SqlWhere;
import com.shineon.coder.db.sql.mergedao.IRmtOrganizationInfoMapper;
import com.shineon.coder.db.sql.pojo.RmtOrganizationInfo;
import com.shineon.coder.db.sql.property.RmtOrganizationInfoProperty;
import com.shineon.coder.kernel.util.GuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class OrganizationBO {

    @Autowired
    private IRmtOrganizationInfoMapper organizationInfoMapper;

    public List<RmtOrganizationInfo> list() {

        SqlWhere where =new SqlWhere();
        where.add2(RmtOrganizationInfoProperty.deletedFlagProperty,0);
        List<RmtOrganizationInfo> list = organizationInfoMapper.list(where.toString(), null);
        return list;
    }

    public RmtOrganizationInfo get(String id)
    {
        return organizationInfoMapper.selectByPrimaryKey(id);
    }


    public RmtOrganizationInfo insert(RmtOrganizationInfo organization)
    {
        GuidUtil util = new GuidUtil();
        organization.setCreateuserid("0");
        organization.setCreatedtime(new Date());
        organization.setModifyuserid("0");
        organization.setModifytime(new Date());
        organization.setId(util.gen());

        if(organization.getOrganizationcode()==null)
        {
            organization.setOrganizationcode(1);
        }
        organization.setDeletedflag((byte) 0);

        organizationInfoMapper.insertByCustomId(organization);

        return get(organization.getId());
    }


    public RmtOrganizationInfo update(RmtOrganizationInfo organization)
    {
        organizationInfoMapper.updateByPrimaryKeySelective(organization);
        return get(organization.getId());
    }



    public boolean delete(String id){
        RmtOrganizationInfo organizationInfo =get(id);
        organizationInfo.setDeletedflag((byte) 1);
        organizationInfo.setDeletedtime(new Date());
        update(organizationInfo);
        return false;
    }

}
