package com.shineon.coder.service.bo;


import com.shineon.coder.db.sql.mergedao.IRmtDepartmentInfoMapper;
import com.shineon.coder.db.sql.pojo.RmtDepartmentInfo;
import com.shineon.coder.kernel.util.GuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartmentBo {

    @Autowired
    IRmtDepartmentInfoMapper departmentInfoMapper;


    public RmtDepartmentInfo get(String id)
    {
        return departmentInfoMapper.selectByPrimaryKey(id);
    }


    public RmtDepartmentInfo add(RmtDepartmentInfo departmentInfo)
    {
        GuidUtil util = new GuidUtil();
        String id = util.gen();
        departmentInfo.setId(id);
        departmentInfoMapper.insertSelective(departmentInfo);
        return departmentInfoMapper.selectByPrimaryKey(id);
    }

    public RmtDepartmentInfo update(RmtDepartmentInfo departmentInfo)
    {
        departmentInfoMapper.updateByPrimaryKeySelective(departmentInfo);
        return departmentInfoMapper.selectByPrimaryKey(departmentInfo.getId());
    }


    public List<RmtDepartmentInfo> list()
    {
        return departmentInfoMapper.list(null,null);
    }

}
