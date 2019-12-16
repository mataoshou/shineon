package com.shineon.coder.service.bo;

import com.shineon.coder.db.sql.SqlWhere;
import com.shineon.coder.db.sql.mergedao.IRmtUserInfoMapper;
import com.shineon.coder.db.sql.pojo.RmtUserInfo;
import com.shineon.coder.db.sql.property.RmtUserInfoProperty;
import com.shineon.coder.kernel.util.GuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class UserBO {

    @Autowired
    IRmtUserInfoMapper userMapper;


    public RmtUserInfo get(String id)
    {
        return userMapper.selectByPrimaryKey(id);
    }


    public List<RmtUserInfo> list()
    {
        SqlWhere where =new SqlWhere();
        where.add2(RmtUserInfoProperty.deletedFlagProperty,0);
        return userMapper.list(where.toString(),null);
    }

    public RmtUserInfo insert(RmtUserInfo user)
    {
        GuidUtil util = new GuidUtil();

//        user.setUsercode("001");

        user.setCreateuserid(user.getModifyuserid());
        user.setCreatedtime(user.getModifytime());

        user.setId(util.gen());
        userMapper.insertByCustomId(user);

        return get(user.getId());
    }

    public RmtUserInfo update(RmtUserInfo user)
    {
        userMapper.updateByPrimaryKeySelective(user);

        return get(user.getId());
    }


    public RmtUserInfo delete(RmtUserInfo user)
    {
        user.setDeletedflag((byte) 1);
        user.setDeletedtime(new Date());
        update(user);
        return get(user.getId());
    }

    public RmtUserInfo getByName(String name)
    {
        return userMapper.selectByName(name);
    }

}
