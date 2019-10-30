package com.shineon.coder.service.bo;

import com.shineon.coder.db.sql.mergedao.IRmtOrganizationChartInfoMapper;
import com.shineon.coder.db.sql.pojo.RmtOrganizationChartInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizationBO {

    @Autowired
    private IRmtOrganizationChartInfoMapper organizationChartInfoMapper;

    public List<RmtOrganizationChartInfo> list() {
        List<RmtOrganizationChartInfo> list = organizationChartInfoMapper.list(null, null);


        return list;
    }
}
