package com.shineon.coder.service.convert.base ;import java.util.Date;;import com.shineon.coder.db.pojo.RmtUserInfo;;import com.shineon.coder.service.convert.CommonData;import java.util.ArrayList;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.convert.CommonItemUtils;import com.shineon.coder.service.convert.CommonItem;import com.shineon.coder.service.convert.CommonItemUtils;import org.slf4j.Logger;import org.slf4j.LoggerFactory;public class RmtUserInfoCommonBase implements CommonItemUtils<RmtUserInfo>{	Logger logger = LoggerFactory.getLogger(getClass());	
	private CommonData toCommonData( RmtUserInfo pojo) {		CommonData data = new CommonData();		data.setId(pojo.getId());		data.setCreator(pojo.getUsercode());		data.setParent(pojo.getUsername());		data.setGroup(pojo.getUserpassword());		data.setTitle(pojo.getDisplayname());		data.setThumb(pojo.getUserthumb());		data.setPtitle(pojo.getUsermark());		data.setCreateTime(pojo.getCreatedtime());		data.setBeginTime(pojo.getModifiedtime());		data.setEndTime(pojo.getDeletedtime());		return data;	}	
	private RmtUserInfo toPojoData( CommonData data) {		RmtUserInfo pojo = new RmtUserInfo();		pojo.setId(data.getId());		pojo.setUsercode(data.getCreator());		pojo.setUsername(data.getParent());		pojo.setUserpassword(data.getGroup());		pojo.setDisplayname(data.getTitle());		pojo.setUserthumb(data.getThumb());		pojo.setUsermark(data.getPtitle());		pojo.setCreatedtime(data.getCreateTime());		pojo.setModifiedtime(data.getBeginTime());		pojo.setDeletedtime(data.getEndTime());		return pojo;	}	
	public CommonItem toCommon( RmtUserInfo pojo) {		return success(toCommonData(pojo));	}	
	public  CommonItem toCommon( List<RmtUserInfo> pojos) {		List<CommonData> result = new ArrayList();		for(RmtUserInfo item : pojos){			result.add(toCommonData(item));		}		return success(result);	}	
	public RmtUserInfo toPojo( CommonItem item) {		List<CommonData> datas = item.getDatas();		if(datas ==null||datas.size()==0){logger.debug("CommonItem 中data数据为空!!"); return null;}		if(datas.size()>1){logger.debug("CommonItem 中data数据不止一条数据!!"); }		return toPojoData(datas.get(0));	}	
	public List<RmtUserInfo> toPojoList(  CommonItem item) {		List<RmtUserInfo> result = new ArrayList();			List<CommonData> datas = item.getDatas();			for(CommonData data : datas){				result.add(toPojoData(data));			}			return result;		}		
}