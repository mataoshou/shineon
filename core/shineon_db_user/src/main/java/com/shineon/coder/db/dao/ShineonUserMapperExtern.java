package com.shineon.coder.db.dao ;


import com.shineon.coder.db.pojo.ShineonUser;

public interface ShineonUserMapperExtern {
    ShineonUser selectById(Integer id);
}
