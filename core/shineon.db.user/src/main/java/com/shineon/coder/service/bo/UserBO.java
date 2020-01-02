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

        user.setCreateuserid("0");
        user.setCreatedtime(new Date());
        user.setModifyuserid("0");
        user.setModifytime(new Date());
        user.setDeletedflag((byte) 0);

        user.setId(util.gen());
        userMapper.insertByCustomId(user);

        return get(user.getId());
    }

    public RmtUserInfo update(RmtUserInfo user)
    {
        userMapper.updateByPrimaryKeySelective(user);

        return get(user.getId());
    }


    public boolean delete(String id)
    {

        RmtUserInfo userInfo = get(id);

        userInfo.setDeletedflag((byte) 1);
        userInfo.setDeletedtime(new Date());
        update(userInfo);
        return false;
    }


    public RmtUserInfo getbyname(String name)
    {
        return userMapper.selectByName(name);
    }

}
