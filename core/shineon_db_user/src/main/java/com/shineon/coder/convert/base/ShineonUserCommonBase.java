package com.shineon.coder.convert.base ;

import java.util.Date;;
import com.shineon.coder.db.pojo.ShineonUser;;
import com.shineon.coder.convert.CommonItem;;

public class ShineonUserCommonBase {
		public CommonItem shineonUserToCommon( ShineonUser item) {
			CommonItem result = new CommonItem();
			result.setId(item.getId());
			result.setContent(item.getUsername());
			result.setTitle(item.getDisplayname());
			result.setParent(item.getParent());
			result.setPtitle(item.getUsercode());
			result.setThumb(item.getUserthumb());
			result.setCreateTime(item.getTimecreated());
			result.setBeginTime(item.getTimemodified());
			result.setEndTime(item.getTimedeleted());
			return result;
		}
		public ShineonUser commonToShineonUser( CommonItem item) {
			ShineonUser result = new ShineonUser();
			result.setId(item.getId());
			result.setUsername(item.getContent());
			result.setDisplayname(item.getTitle());
			result.setParent(item.getParent());
			result.setUsercode(item.getPtitle());
			result.setUserthumb(item.getThumb());
			result.setTimecreated(item.getCreateTime());
			result.setTimemodified(item.getBeginTime());
			result.setTimedeleted(item.getEndTime());
			return result;
		}

}
