package com.shineon.coder.db.dao ;

import com.shineon.coder.db.pojo.ShineonUser;;
import java.util.List;;

public interface ShineonUserMapperExtern {
    List<ShineonUser> list(String where,String order);
}
