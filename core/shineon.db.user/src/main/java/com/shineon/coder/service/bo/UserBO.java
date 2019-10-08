package com.shineon.coder.service.bo;

import com.shineon.coder.db.sql.SqlWhere;
import com.shineon.coder.db.sql.mergedao.IShineonUserMapper;
import com.shineon.coder.db.sql.pojo.ShineonUser;
import com.shineon.coder.db.sql.property.ShineonUserProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserBO {

    @Autowired
    IShineonUserMapper userMapper;


    public ShineonUser getUser(int id)
    {
        return userMapper.selectByPrimaryKey(id);
    }


    public List<ShineonUser> list()
    {
        SqlWhere where =new SqlWhere();
        where.add2(ShineonUserProperty.flagDeletedProperty,0);
        return userMapper.list(where.toString(),null);
    }

    public void add(ShineonUser user)
    {
        userMapper.insert(user);
    }

    public void update(ShineonUser user)
    {
        userMapper.updateByPrimaryKey(user);
    }

}
