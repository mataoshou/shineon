package com.shineon.coder.server;

import com.shineon.coder.db.dao.ShineonUserMapper;
import com.shineon.coder.db.pojo.ShineonUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServer implements BaseServer<ShineonUser> {

    @Autowired
    ShineonUserMapper userMapper;


    @Override
    public ShineonUser getItem(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List listItem() {
        return null;
    }

    @Override
    public int insertItem(ShineonUser shineonUser) {
        return userMapper.insert(shineonUser);
    }

    @Override
    public int deleteItem(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateItem(ShineonUser shineonUser) {
        userMapper.updateByPrimaryKey(shineonUser);
    }
}
