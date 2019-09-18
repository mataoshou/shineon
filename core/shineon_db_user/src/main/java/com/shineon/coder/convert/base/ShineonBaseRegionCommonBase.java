package com.shineon.coder.convert.base ;

import java.util.Date;;
import com.shineon.coder.db.pojo.ShineonBaseRegion;;
import com.shineon.coder.convert.CommonData;;

public class ShineonBaseRegionCommonBase {
		public CommonData shineonBaseRegionToCommon( ShineonBaseRegion item) {
			CommonData result = new CommonData();
			result.setContent(item.getRgname());
			result.setCreateTime(item.getTimecreated());
			result.setBeginTime(item.getTimemodified());
			result.setStatus(item.getFlagdeleted());
			result.setEndTime(item.getTimedeleted());
			return result;
		}
		public ShineonBaseRegion commonToShineonBaseRegion( CommonData item) {
			ShineonBaseRegion result = new ShineonBaseRegion();
			result.setRgname(item.getContent());
			result.setTimecreated(item.getCreateTime());
			result.setTimemodified(item.getBeginTime());
			result.setFlagdeleted(item.getStatus());
			result.setTimedeleted(item.getEndTime());
			return result;
		}

}
