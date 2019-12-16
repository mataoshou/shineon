package com.shineon.coder.service.bo;

import com.shineon.coder.db.sql.mergedao.IRmtOrganizationInfoMapper;
import com.shineon.coder.db.sql.pojo.RmtOrganizationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizationBO {

    @Autowired
    private IRmtOrganizationInfoMapper organizationInfoMapper;

    public List<RmtOrganizationInfo> list(String parent) {



        List<RmtOrganizationInfo> list = organizationInfoMapper.list(null, null);
        return list;
    }




}
