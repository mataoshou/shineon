package com.shineon.coder.service.convert.base ;import java.util.Date;import com.shineon.coder.db.sql.pojo.RmtActiorInfo;import com.shineon.coder.service.convert.CommonData;import java.util.ArrayList;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.convert.CommonItemUtils;import com.shineon.coder.service.convert.CommonItem;import com.shineon.coder.service.convert.CommonItemUtils;import org.slf4j.Logger;import org.slf4j.LoggerFactory;public class RmtActiorInfoCommonBase implements CommonItemUtils<RmtActiorInfo>{	Logger logger = LoggerFactory.getLogger(getClass());	
	private CommonData toCommonData( RmtActiorInfo pojo) {		CommonData data = new CommonData();		data.setId(pojo.getId());		data.setParentCode1(pojo.getActorname());		data.setCreateTime(pojo.getCreatetime());		data.setParentCode2(pojo.getDescription());		data.setCreateName(pojo.getSystemactorflag());		data.setCreateId(pojo.getReserved2());		data.setChangerId(pojo.getPrivilegegroup());		return data;	}	
	private RmtActiorInfo toPojoData( CommonData data) {		RmtActiorInfo pojo = new RmtActiorInfo();		pojo.setId(data.getId());		pojo.setActorname(data.getParentCode1());		pojo.setCreatetime(data.getCreateTime());		pojo.setDescription(data.getParentCode2());		pojo.setSystemactorflag(data.getCreateName());		pojo.setReserved2(data.getCreateId());		pojo.setPrivilegegroup(data.getChangerId());		return pojo;	}	
	public CommonItem toCommon( RmtActiorInfo pojo) {		return success(toCommonData(pojo));	}	
	public  CommonItem toCommon( List<RmtActiorInfo> pojos) {		List<CommonData> result = new ArrayList();		for(RmtActiorInfo item : pojos){			result.add(toCommonData(item));		}		return success(result);	}	
	public com.shineon.coder.db.sql.pojo.RmtActiorInfo toPojo( CommonItem item) throws Exception{		checkCommonItem(item);		List<CommonData> datas = item.getDatas();		if(datas ==null||datas.size()==0){logger.debug("CommonItem 中data数据为空!!"); return null;}		if(datas.size()>1){logger.debug("CommonItem 中data数据不止一条数据!!"); }		return toPojoData(datas.get(0));	}	
	public List<com.shineon.coder.db.sql.pojo.RmtActiorInfo> toPojoList(  CommonItem item) throws Exception{		checkCommonItem(item);		List<com.shineon.coder.db.sql.pojo.RmtActiorInfo> result = new ArrayList();			List<CommonData> datas = item.getDatas();			for(CommonData data : datas){				result.add(toPojoData(data));			}			return result;		}		
		}