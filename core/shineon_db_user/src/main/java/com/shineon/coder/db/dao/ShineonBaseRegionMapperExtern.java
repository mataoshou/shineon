package com.shineon.coder.db.dao ;

import com.shineon.coder.db.pojo.ShineonBaseRegion;;
import java.util.List;;

public interface ShineonBaseRegionMapperExtern {
    List<ShineonBaseRegion> list(String where,String order);
}
