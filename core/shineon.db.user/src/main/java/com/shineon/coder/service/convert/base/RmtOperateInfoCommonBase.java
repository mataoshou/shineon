package com.shineon.coder.service.convert.base ;import java.util.Date;import com.shineon.coder.db.sql.pojo.RmtOperateInfo;import com.shineon.coder.service.convert.CommonData;import java.util.ArrayList;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.convert.CommonItemUtils;import com.shineon.coder.service.convert.CommonItem;import com.shineon.coder.service.convert.CommonItemUtils;import org.slf4j.Logger;import org.slf4j.LoggerFactory;public class RmtOperateInfoCommonBase implements CommonItemUtils<RmtOperateInfo>{	Logger logger = LoggerFactory.getLogger(getClass());	
	private CommonData toCommonData( RmtOperateInfo pojo) {		CommonData data = new CommonData();		data.setId(pojo.getId());		data.setParentCode1(pojo.getOperatename());		data.setParentCode2(pojo.getBelongsystem());		data.setChangerId(pojo.getPagelocation());		data.setParent1Name(pojo.getArealocation());		data.setParent2Name(pojo.getApplicationkey());		data.setCreateId(pojo.getDescription());		data.setCreateName(pojo.getReserved2());		return data;	}	
	private RmtOperateInfo toPojoData( CommonData data) {		RmtOperateInfo pojo = new RmtOperateInfo();		pojo.setId(data.getId());		pojo.setOperatename(data.getParentCode1());		pojo.setBelongsystem(data.getParentCode2());		pojo.setPagelocation(data.getChangerId());		pojo.setArealocation(data.getParent1Name());		pojo.setApplicationkey(data.getParent2Name());		pojo.setDescription(data.getCreateId());		pojo.setReserved2(data.getCreateName());		return pojo;	}	
	public CommonItem toCommon( RmtOperateInfo pojo) {		return success(toCommonData(pojo));	}	
	public  CommonItem toCommon( List<RmtOperateInfo> pojos) {		List<CommonData> result = new ArrayList();		for(RmtOperateInfo item : pojos){			result.add(toCommonData(item));		}		return success(result);	}	
	public com.shineon.coder.db.sql.pojo.RmtOperateInfo toPojo( CommonItem item) throws Exception{		checkCommonItem(item);		List<CommonData> datas = item.getDatas();		if(datas ==null||datas.size()==0){logger.debug("CommonItem 中data数据为空!!"); return null;}		if(datas.size()>1){logger.debug("CommonItem 中data数据不止一条数据!!"); }		return toPojoData(datas.get(0));	}	
	public List<com.shineon.coder.db.sql.pojo.RmtOperateInfo> toPojoList(  CommonItem item) throws Exception{		checkCommonItem(item);		List<com.shineon.coder.db.sql.pojo.RmtOperateInfo> result = new ArrayList();			List<CommonData> datas = item.getDatas();			for(CommonData data : datas){				result.add(toPojoData(data));			}			return result;		}		
		}