package com.shineon.coder.db.dao ;

import com.shineon.coder.db.pojo.ShineonBaseZone;;
import java.util.List;;

public interface ShineonBaseZoneMapperExtern {
    List<ShineonBaseZone> list(String where,String order);
}
