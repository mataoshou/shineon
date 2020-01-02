package com.shineon.coder.service.convert.base ;import java.util.Date;import com.shineon.coder.db.sql.pojo.RmtUserExtendInfo;import com.shineon.coder.service.convert.CommonData;import java.util.ArrayList;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.convert.CommonItemUtils;import com.shineon.coder.service.convert.CommonItem;import com.shineon.coder.service.convert.CommonItemUtils;import org.slf4j.Logger;import org.slf4j.LoggerFactory;public class RmtUserExtendInfoCommonBase implements CommonItemUtils<RmtUserExtendInfo>{	Logger logger = LoggerFactory.getLogger(getClass());	
	private CommonData toCommonData( RmtUserExtendInfo pojo) {		CommonData data = new CommonData();		data.setId(pojo.getId());		data.setParentCode1(pojo.getUserid());		data.setParent1Name(pojo.getRealname());		data.setParent2Name(pojo.getSpellname());		data.setParentCode2(pojo.getPostname());		data.setCreateName(pojo.getDutiesname());		data.setCreateId(pojo.getOfficeaddress());		data.setContent(pojo.getMobilephone());		data.setPtitle(pojo.getOfficetelephone());		data.setTitle(pojo.getEmail());		data.setChangerId(pojo.getOfficecode());		data.setThumb(pojo.getDescription());		return data;	}	
	private RmtUserExtendInfo toPojoData( CommonData data) {		RmtUserExtendInfo pojo = new RmtUserExtendInfo();		pojo.setId(data.getId());		pojo.setUserid(data.getParentCode1());		pojo.setRealname(data.getParent1Name());		pojo.setSpellname(data.getParent2Name());		pojo.setPostname(data.getParentCode2());		pojo.setDutiesname(data.getCreateName());		pojo.setOfficeaddress(data.getCreateId());		pojo.setMobilephone(data.getContent());		pojo.setOfficetelephone(data.getPtitle());		pojo.setEmail(data.getTitle());		pojo.setOfficecode(data.getChangerId());		pojo.setDescription(data.getThumb());		return pojo;	}	
	public CommonItem toCommon( RmtUserExtendInfo pojo) {		return success(toCommonData(pojo));	}	
	public  CommonItem toCommon( List<RmtUserExtendInfo> pojos) {		List<CommonData> result = new ArrayList();		for(RmtUserExtendInfo item : pojos){			result.add(toCommonData(item));		}		return success(result);	}	
	public com.shineon.coder.db.sql.pojo.RmtUserExtendInfo toPojo( CommonItem item) throws Exception{		checkCommonItem(item);		List<CommonData> datas = item.getDatas();		if(datas ==null||datas.size()==0){logger.debug("CommonItem 中data数据为空!!"); return null;}		if(datas.size()>1){logger.debug("CommonItem 中data数据不止一条数据!!"); }		return toPojoData(datas.get(0));	}	
	public List<com.shineon.coder.db.sql.pojo.RmtUserExtendInfo> toPojoList(  CommonItem item) throws Exception{		checkCommonItem(item);		List<com.shineon.coder.db.sql.pojo.RmtUserExtendInfo> result = new ArrayList();			List<CommonData> datas = item.getDatas();			for(CommonData data : datas){				result.add(toPojoData(data));			}			return result;		}		
		}