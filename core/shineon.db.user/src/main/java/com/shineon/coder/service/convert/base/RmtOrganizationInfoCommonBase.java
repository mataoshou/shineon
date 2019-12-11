package com.shineon.coder.service.convert.base ;import java.util.Date;import com.shineon.coder.db.sql.pojo.RmtOrganizationInfo;import com.shineon.coder.service.convert.CommonData;import java.util.ArrayList;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.convert.CommonItemUtils;import com.shineon.coder.service.convert.CommonItem;import com.shineon.coder.service.convert.CommonItemUtils;import org.slf4j.Logger;import org.slf4j.LoggerFactory;public class RmtOrganizationInfoCommonBase implements CommonItemUtils<RmtOrganizationInfo>{	Logger logger = LoggerFactory.getLogger(getClass());	
	private CommonData toCommonData( RmtOrganizationInfo pojo) {		CommonData data = new CommonData();		data.setId(pojo.getId());		data.setParentCode1(pojo.getOrganizationid());		data.setParentCode2(pojo.getOrganizationname());		data.setCreateId(pojo.getDescription());		data.setCreateTime(pojo.getCreatedtime());		data.setCreateName(pojo.getCreateuserid());		data.setBeginTime(pojo.getModifytime());		data.setChangerId(pojo.getModifyuserid());		data.setEndTime(pojo.getDeletedtime());		data.setPtitle(pojo.getDeleteduserid());		data.setParent2Name(pojo.getReserved2());		return data;	}	
	private RmtOrganizationInfo toPojoData( CommonData data) {		RmtOrganizationInfo pojo = new RmtOrganizationInfo();		pojo.setId(data.getId());		pojo.setOrganizationid(data.getParentCode1());		pojo.setOrganizationname(data.getParentCode2());		pojo.setDescription(data.getCreateId());		pojo.setCreatedtime(data.getCreateTime());		pojo.setCreateuserid(data.getCreateName());		pojo.setModifytime(data.getBeginTime());		pojo.setModifyuserid(data.getChangerId());		pojo.setDeletedtime(data.getEndTime());		pojo.setDeleteduserid(data.getPtitle());		pojo.setReserved2(data.getParent2Name());		return pojo;	}	
	public CommonItem toCommon( RmtOrganizationInfo pojo) {		return success(toCommonData(pojo));	}	
	public  CommonItem toCommon( List<RmtOrganizationInfo> pojos) {		List<CommonData> result = new ArrayList();		for(RmtOrganizationInfo item : pojos){			result.add(toCommonData(item));		}		return success(result);	}	
	public RmtOrganizationInfo toPojo( CommonItem item) {		List<CommonData> datas = item.getDatas();		if(datas ==null||datas.size()==0){logger.debug("CommonItem 中data数据为空!!"); return null;}		if(datas.size()>1){logger.debug("CommonItem 中data数据不止一条数据!!"); }		return toPojoData(datas.get(0));	}	
	public List<RmtOrganizationInfo> toPojoList(  CommonItem item) {		List<RmtOrganizationInfo> result = new ArrayList();			List<CommonData> datas = item.getDatas();			for(CommonData data : datas){				result.add(toPojoData(data));			}			return result;		}		
}