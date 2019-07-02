package com.shineon.coder.tool.convert.base ;

import java.util.Date;
import com.shineon.coder.db.pojo.ShineonUser;
import com.shineon.coder.tool.convert.CommonItem;

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
		result.setContent(item.getPassword());
		result.setPtitle(item.getTelephone());
		result.setThumb(item.getUsermark());
		result.setCreateTime(item.getTimelimit());
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
		result.setPassword(item.getContent());
		result.setTelephone(item.getPtitle());
		result.setUsermark(item.getThumb());
		result.setTimelimit(item.getCreateTime());
		return result;
	}

}
