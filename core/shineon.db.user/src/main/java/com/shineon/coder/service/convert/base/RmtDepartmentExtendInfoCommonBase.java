package com.shineon.coder.service.convert.base ;import java.util.Date;import com.shineon.coder.db.sql.pojo.RmtDepartmentExtendInfo;import com.shineon.coder.service.convert.CommonData;import java.util.ArrayList;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.convert.CommonItemUtils;import com.shineon.coder.service.convert.CommonItem;import com.shineon.coder.service.convert.CommonItemUtils;import org.slf4j.Logger;import org.slf4j.LoggerFactory;public class RmtDepartmentExtendInfoCommonBase implements CommonItemUtils<RmtDepartmentExtendInfo>{	Logger logger = LoggerFactory.getLogger(getClass());	
	private CommonData toCommonData( RmtDepartmentExtendInfo pojo) {		CommonData data = new CommonData();		data.setId(pojo.getId());		data.setParent(pojo.getDepartmentid());		data.setCreator(pojo.getDepartmentabbr());		data.setSortIndex(pojo.getWorkernumber());		data.setTitle(pojo.getReserved2());		return data;	}	
	private RmtDepartmentExtendInfo toPojoData( CommonData data) {		RmtDepartmentExtendInfo pojo = new RmtDepartmentExtendInfo();		pojo.setId(data.getId());		pojo.setDepartmentid(data.getParent());		pojo.setDepartmentabbr(data.getCreator());		pojo.setWorkernumber(data.getSortIndex());		pojo.setReserved2(data.getTitle());		return pojo;	}	
	public CommonItem toCommon( RmtDepartmentExtendInfo pojo) {		return success(toCommonData(pojo));	}	
	public  CommonItem toCommon( List<RmtDepartmentExtendInfo> pojos) {		List<CommonData> result = new ArrayList();		for(RmtDepartmentExtendInfo item : pojos){			result.add(toCommonData(item));		}		return success(result);	}	
	public RmtDepartmentExtendInfo toPojo( CommonItem item) {		List<CommonData> datas = item.getDatas();		if(datas ==null||datas.size()==0){logger.debug("CommonItem 中data数据为空!!"); return null;}		if(datas.size()>1){logger.debug("CommonItem 中data数据不止一条数据!!"); }		return toPojoData(datas.get(0));	}	
	public List<RmtDepartmentExtendInfo> toPojoList(  CommonItem item) {		List<RmtDepartmentExtendInfo> result = new ArrayList();			List<CommonData> datas = item.getDatas();			for(CommonData data : datas){				result.add(toPojoData(data));			}			return result;		}		
}