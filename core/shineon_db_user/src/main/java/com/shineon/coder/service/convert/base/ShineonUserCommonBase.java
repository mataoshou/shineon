package com.shineon.coder.service.convert.base ;import java.util.Date;;import com.shineon.coder.db.sql.pojo.ShineonUser;;import com.shineon.coder.service.convert.CommonData;import java.util.ArrayList;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.convert.CommonItemUtils;import com.shineon.coder.service.convert.CommonItem;import org.slf4j.Logger;import org.slf4j.LoggerFactory;public class ShineonUserCommonBase {	@Autowired	CommonItemUtils utils;	Logger logger = LoggerFactory.getLogger(getClass());	
	private CommonData toCommonData( ShineonUser pojo) {		CommonData data = new CommonData();		data.setId(pojo.getId());		data.setName(pojo.getUsername());		data.setContent(pojo.getPassword());		data.setTitle(pojo.getDisplayname());		data.setParent(pojo.getParent());		data.setGroup(pojo.getRegion());		data.setPtitle(pojo.getUsercode());		data.setThumb(pojo.getUserthumb());		data.setCreateTime(pojo.getTimecreated());		data.setBeginTime(pojo.getTimemodified());		data.setEndTime(pojo.getTimedeleted());		return data;	}	
	private ShineonUser toPojoData( CommonData data) {		ShineonUser pojo = new ShineonUser();		pojo.setId(data.getId());		pojo.setUsername(data.getName());		pojo.setPassword(data.getContent());		pojo.setDisplayname(data.getTitle());		pojo.setParent(data.getParent());		pojo.setRegion(data.getGroup());		pojo.setUsercode(data.getPtitle());		pojo.setUserthumb(data.getThumb());		pojo.setTimecreated(data.getCreateTime());		pojo.setTimemodified(data.getBeginTime());		pojo.setTimedeleted(data.getEndTime());		return pojo;	}	
	public CommonItem toCommon( ShineonUser pojo) {		return utils.success(toCommonData(pojo));	}	
	public  CommonItem toCommon( List<ShineonUser> pojos) {		List<CommonData> result = new ArrayList();		for(ShineonUser item : pojos){			result.add(toCommonData(item));		}		return utils.success(result);	}	
	public ShineonUser toPojo( CommonItem item) {		List<CommonData> datas = item.getDatas();		if(datas ==null||datas.size()==0){logger.debug("CommonItem 中data数据为空!!"); return null;}		if(datas.size()>1){logger.debug("CommonItem 中data数据不止一条数据!!"); }		return toPojoData(datas.get(0));	}	
	public List<ShineonUser> toPojoList(  CommonItem item) {		List<ShineonUser> result = new ArrayList();			List<CommonData> datas = item.getDatas();			for(CommonData data : datas){				result.add(toPojoData(data));			}			return result;		}		
}