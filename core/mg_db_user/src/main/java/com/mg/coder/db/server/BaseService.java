package com.mg.coder.db.server;

import com.mg.coder.db.dao.MgBaseRegionMapper;
import com.mg.coder.db.dao.MgBaseUserMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    protected MgBaseUserMapper userMapper;

    @Autowired
    protected MgBaseRegionMapper regionMapper;

}
