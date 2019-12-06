package com.shineon.coder.service.bo;

import com.shineon.coder.db.sql.SqlWhere;
import com.shineon.coder.db.sql.mergedao.IRmtUserInfoMapper;
import com.shineon.coder.db.sql.pojo.RmtUserInfo;
import com.shineon.coder.db.sql.property.RmtUserInfoProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserBO {

    @Autowired
    IRmtUserInfoMapper userMapper;


    public RmtUserInfo get(String id)
    {
        return userMapper.selectByPrimaryKey(id);
    }


    public List<RmtUserInfo> list(int status)
    {
        SqlWhere where =new SqlWhere();
        where.add2(RmtUserInfoProperty.deletedFlagProperty,0);
        return userMapper.list(where.toString(),null);
    }

    public void add(RmtUserInfo user)
    {
        userMapper.insert(user);
    }

    public void update(RmtUserInfo user)
    {
        userMapper.updateByPrimaryKey(user);
    }

    public RmtUserInfo getByName(String name)
    {
        return userMapper.selectByName(name);
    }

}
