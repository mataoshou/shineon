package com.shineon.coder.service.bo;

import com.shineon.coder.db.sql.mergedao.IRmtPrivilegeInfoMapper;
import com.shineon.coder.db.sql.pojo.RmtPrivilegeInfo;
import com.shineon.coder.kernel.util.GuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrivilegeBO {

    @Autowired
    private IRmtPrivilegeInfoMapper mapper;

    private GuidUtil util = new GuidUtil();

    public List<RmtPrivilegeInfo> list() {

        List<RmtPrivilegeInfo> list = mapper.list(null, null);
        return list;
    }

    public RmtPrivilegeInfo get(String id)
    {
        return mapper.selectByPrimaryKey(id);
    }


    public RmtPrivilegeInfo insert(RmtPrivilegeInfo organization)
    {

        organization.setId(util.gen());

        mapper.insertByCustomId(organization);

        return get(organization.getId());
    }


    public RmtPrivilegeInfo update(RmtPrivilegeInfo organization)
    {
        mapper.updateByPrimaryKeySelective(organization);
        return get(organization.getId());
    }

    public boolean delete(String id)
    {
        int index = mapper.deleteByPrimaryKey(id);
        if(index>0)return true;
        return false;
    }
}
