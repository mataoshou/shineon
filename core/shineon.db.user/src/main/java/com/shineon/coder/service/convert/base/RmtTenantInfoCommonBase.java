package com.shineon.coder.service.convert.base ;import java.util.Date;import com.shineon.coder.db.sql.pojo.RmtTenantInfo;import com.shineon.coder.service.convert.CommonData;import java.util.ArrayList;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.convert.CommonItemUtils;import com.shineon.coder.service.convert.CommonItem;import com.shineon.coder.service.convert.CommonItemUtils;import org.slf4j.Logger;import org.slf4j.LoggerFactory;public class RmtTenantInfoCommonBase implements CommonItemUtils<RmtTenantInfo>{	Logger logger = LoggerFactory.getLogger(getClass());	
	private CommonData toCommonData( RmtTenantInfo pojo) {		CommonData data = new CommonData();		data.setId(pojo.getId());		data.setParentCode1(pojo.getTenantid());		data.setParent1Name(pojo.getTenantname());		data.setCreateTime(pojo.getCreatetime());		data.setParentCode2(pojo.getCreateduserid());		data.setChangerId(pojo.getOrganizationid());		data.setBeginTime(pojo.getTenantexpirydate());		data.setParent2Name(pojo.getTenantextendid());		data.setCreateId(pojo.getReserved2());		data.setCreateName(pojo.getTenantadminset());		return data;	}	
	private RmtTenantInfo toPojoData( CommonData data) {		RmtTenantInfo pojo = new RmtTenantInfo();		pojo.setId(data.getId());		pojo.setTenantid(data.getParentCode1());		pojo.setTenantname(data.getParent1Name());		pojo.setCreatetime(data.getCreateTime());		pojo.setCreateduserid(data.getParentCode2());		pojo.setOrganizationid(data.getChangerId());		pojo.setTenantexpirydate(data.getBeginTime());		pojo.setTenantextendid(data.getParent2Name());		pojo.setReserved2(data.getCreateId());		pojo.setTenantadminset(data.getCreateName());		return pojo;	}	
	public CommonItem toCommon( RmtTenantInfo pojo) {		return success(toCommonData(pojo));	}	
	public  CommonItem toCommon( List<RmtTenantInfo> pojos) {		List<CommonData> result = new ArrayList();		for(RmtTenantInfo item : pojos){			result.add(toCommonData(item));		}		return success(result);	}	
	public com.shineon.coder.db.sql.pojo.RmtTenantInfo toPojo( CommonItem item) throws Exception{		checkCommonItem(item);		List<CommonData> datas = item.getDatas();		if(datas ==null||datas.size()==0){logger.debug("CommonItem 中data数据为空!!"); return null;}		if(datas.size()>1){logger.debug("CommonItem 中data数据不止一条数据!!"); }		return toPojoData(datas.get(0));	}	
	public List<com.shineon.coder.db.sql.pojo.RmtTenantInfo> toPojoList(  CommonItem item) throws Exception{		checkCommonItem(item);		List<com.shineon.coder.db.sql.pojo.RmtTenantInfo> result = new ArrayList();			List<CommonData> datas = item.getDatas();			for(CommonData data : datas){				result.add(toPojoData(data));			}			return result;		}		
		}