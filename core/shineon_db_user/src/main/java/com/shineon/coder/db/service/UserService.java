package com.shineon.coder.db.service;

import com.shineon.coder.db.SqlWhere;
import com.shineon.coder.db.pojo.ShineonUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserService extends BaseService {

    public ShineonUser getUser(Integer id)
    {
        return shineonUserMapper.selectByPrimaryKey(id);
    }

    public List<ShineonUser> listUserByIds(List<Integer> ids)
    {
        SqlWhere where = new SqlWhere();
        where.addIn("id",ids.toArray());
        return shineonUserMapper.list(where.toString(),null);
    }

    public List<ShineonUser> listUser(String  order)
    {

        return shineonUserMapper.list(null,order);
    }

}
