package com.shineon.coder.db.dao ;

import com.shineon.coder.db.pojo.ShineonUserAttached;;
import java.util.List;;

public interface ShineonUserAttachedMapperExtern {
    List<ShineonUserAttached> list(String where,String order);
}
