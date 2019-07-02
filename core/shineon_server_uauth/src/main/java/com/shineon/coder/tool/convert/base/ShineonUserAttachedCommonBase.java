package com.shineon.coder.tool.convert.base ;

import java.util.Date;
import com.shineon.coder.db.pojo.ShineonUserAttached;
import com.shineon.coder.tool.convert.CommonItem;

public class ShineonUserAttachedCommonBase {

	public CommonItem shineonUserAttachedToCommon( ShineonUserAttached item) {
		CommonItem result = new CommonItem();
		result.setId(item.getId());
		result.setParent(item.getUserid());
		result.setCreateTime(item.getTimelastlogin());
		result.setBeginTime(item.getIplastlogin());
		return result;
	}
	public ShineonUserAttached commonToShineonUserAttached( CommonItem item) {
		ShineonUserAttached result = new ShineonUserAttached();
		result.setId(item.getId());
		result.setUserid(item.getParent());
		result.setTimelastlogin(item.getCreateTime());
		result.setIplastlogin(item.getBeginTime());
		return result;
	}

}
