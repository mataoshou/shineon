package com.shineon.coder.convert.base ;import java.util.Date;;import com.shineon.coder.db.pojo.ShineonBaseZone;;import com.shineon.coder.convert.CommonData;import java.util.ArrayList;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.convert.CommonItemUtils;import com.shineon.coder.convert.CommonItem;import org.slf4j.Logger;import org.slf4j.LoggerFactory;public class ShineonBaseZoneCommonBase {	@Autowired	CommonItemUtils utils;	Logger logger = LoggerFactory.getLogger(getClass());	
	private CommonData toCommonData( ShineonBaseZone pojo) {		CommonData data = new CommonData();		data.setContent(pojo.getZnname());		data.setCreateTime(pojo.getTimecreated());		data.setBeginTime(pojo.getTimemodified());		data.setStatus(pojo.getFlagdeleted());		data.setEndTime(pojo.getTimedeleted());		return data;	}	
	private ShineonBaseZone toPojoData( CommonData data) {		ShineonBaseZone pojo = new ShineonBaseZone();		pojo.setZnname(data.getContent());		pojo.setTimecreated(data.getCreateTime());		pojo.setTimemodified(data.getBeginTime());		pojo.setFlagdeleted(data.getStatus());		pojo.setTimedeleted(data.getEndTime());		return pojo;	}	
	public CommonItem toCommon( ShineonBaseZone pojo) {		return utils.success(toCommonData(pojo));	}	
	public  CommonItem toCommon( List<ShineonBaseZone> pojos) {		List<CommonData> result = new ArrayList();		for(ShineonBaseZone item : pojos){			result.add(toCommonData(item));		}		return utils.success(result);	}	
	public ShineonBaseZone toPojo( CommonItem item) {		List<CommonData> datas = item.getDatas();		if(datas ==null||datas.size()==0){logger.debug("CommonItem 中data数据为空!!"); return null;}		if(datas.size()>1){logger.debug("CommonItem 中data数据不止一条数据!!"); }		return toPojoData(datas.get(0));	}	
	public List<ShineonBaseZone> toPojoList(  CommonItem item) {		List<ShineonBaseZone> result = new ArrayList();			List<CommonData> datas = item.getDatas();			for(CommonData data : datas){				result.add(toPojoData(data));			}			return result;		}		
}