package com.shineon.coder.service.convert.base ;import java.util.Date;import com.shineon.coder.db.pojo.RmtUserInfo;import com.shineon.coder.service.convert.CommonData;import java.util.ArrayList;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.convert.CommonItemUtils;import com.shineon.coder.service.convert.CommonItem;import com.shineon.coder.service.convert.CommonItemUtils;import org.slf4j.Logger;import org.slf4j.LoggerFactory;public class RmtUserInfoCommonBase implements CommonItemUtils<RmtUserInfo>{	Logger logger = LoggerFactory.getLogger(getClass());	
	private CommonData toCommonData( RmtUserInfo pojo) {		CommonData data = new CommonData();		data.setId(pojo.getId());		data.setParentCode1(pojo.getUsercode());		data.setParent1Name(pojo.getUsername());		data.setParentCode2(pojo.getUserpassword());		data.setChangerId(pojo.getDisplayname());		data.setThumb(pojo.getUserthumb());		data.setCreateId(pojo.getWorkcode());		data.setParent2Name(pojo.getOganizationid());		data.setCreateName(pojo.getDepartmentid());		data.setPtitle(pojo.getUserextendid());		data.setCreateTime(pojo.getCreatedtime());		data.setTitle(pojo.getCreateuserid());		data.setBeginTime(pojo.getModifytime());		data.setContent(pojo.getModifyuserid());		data.setEndTime(pojo.getDeletedtime());		return data;	}	
	private RmtUserInfo toPojoData( CommonData data) {		RmtUserInfo pojo = new RmtUserInfo();		pojo.setId(data.getId());		pojo.setUsercode(data.getParentCode1());		pojo.setUsername(data.getParent1Name());		pojo.setUserpassword(data.getParentCode2());		pojo.setDisplayname(data.getChangerId());		pojo.setUserthumb(data.getThumb());		pojo.setWorkcode(data.getCreateId());		pojo.setOganizationid(data.getParent2Name());		pojo.setDepartmentid(data.getCreateName());		pojo.setUserextendid(data.getPtitle());		pojo.setCreatedtime(data.getCreateTime());		pojo.setCreateuserid(data.getTitle());		pojo.setModifytime(data.getBeginTime());		pojo.setModifyuserid(data.getContent());		pojo.setDeletedtime(data.getEndTime());		return pojo;	}	
	public CommonItem toCommon( RmtUserInfo pojo) {		return success(toCommonData(pojo));	}	
	public  CommonItem toCommon( List<RmtUserInfo> pojos) {		List<CommonData> result = new ArrayList();		for(RmtUserInfo item : pojos){			result.add(toCommonData(item));		}		return success(result);	}	
	public RmtUserInfo toPojo( CommonItem item) {		List<CommonData> datas = item.getDatas();		if(datas ==null||datas.size()==0){logger.debug("CommonItem 中data数据为空!!"); return null;}		if(datas.size()>1){logger.debug("CommonItem 中data数据不止一条数据!!"); }		return toPojoData(datas.get(0));	}	
	public List<RmtUserInfo> toPojoList(  CommonItem item) {		List<RmtUserInfo> result = new ArrayList();			List<CommonData> datas = item.getDatas();			for(CommonData data : datas){				result.add(toPojoData(data));			}			return result;		}		
}