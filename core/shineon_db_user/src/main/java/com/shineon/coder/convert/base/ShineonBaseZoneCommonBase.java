package com.shineon.coder.convert.base ;

import java.util.Date;;
import com.shineon.coder.db.pojo.ShineonBaseZone;;
import com.shineon.coder.convert.CommonData;;

public class ShineonBaseZoneCommonBase {
		public CommonData shineonBaseZoneToCommon( ShineonBaseZone item) {
			CommonData result = new CommonData();
			result.setContent(item.getZnname());
			result.setCreateTime(item.getTimecreated());
			result.setBeginTime(item.getTimemodified());
			result.setStatus(item.getFlagdeleted());
			result.setEndTime(item.getTimedeleted());
			return result;
		}
		public ShineonBaseZone commonToShineonBaseZone( CommonData item) {
			ShineonBaseZone result = new ShineonBaseZone();
			result.setZnname(item.getContent());
			result.setTimecreated(item.getCreateTime());
			result.setTimemodified(item.getBeginTime());
			result.setFlagdeleted(item.getStatus());
			result.setTimedeleted(item.getEndTime());
			return result;
		}

}
