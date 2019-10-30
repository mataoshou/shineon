package com.shineon.coder.service.convert.base ;import java.util.Date;import com.shineon.coder.db.sql.pojo.RmtOperateInfo;import com.shineon.coder.service.convert.CommonData;import java.util.ArrayList;import java.util.List;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.convert.CommonItemUtils;import com.shineon.coder.service.convert.CommonItem;import com.shineon.coder.service.convert.CommonItemUtils;import org.slf4j.Logger;import org.slf4j.LoggerFactory;public class RmtOperateInfoCommonBase implements CommonItemUtils<RmtOperateInfo>{	Logger logger = LoggerFactory.getLogger(getClass());	
	private CommonData toCommonData( RmtOperateInfo pojo) {		CommonData data = new CommonData();		data.setId(pojo.getId());		data.setParent(pojo.getOperatename());		data.setSortIndex(pojo.getOperatetype());		data.setContent(pojo.getBelongsystem());		data.setCreator(pojo.getPagelocation());		data.setPtitle(pojo.getArealocation());		data.setTitle(pojo.getApplicationkey());		data.setGroup(pojo.getDescription());		data.setThumb(pojo.getReserved2());		return data;	}	
	private RmtOperateInfo toPojoData( CommonData data) {		RmtOperateInfo pojo = new RmtOperateInfo();		pojo.setId(data.getId());		pojo.setOperatename(data.getParent());		pojo.setOperatetype(data.getSortIndex());		pojo.setBelongsystem(data.getContent());		pojo.setPagelocation(data.getCreator());		pojo.setArealocation(data.getPtitle());		pojo.setApplicationkey(data.getTitle());		pojo.setDescription(data.getGroup());		pojo.setReserved2(data.getThumb());		return pojo;	}	
	public CommonItem toCommon( RmtOperateInfo pojo) {		return success(toCommonData(pojo));	}	
	public  CommonItem toCommon( List<RmtOperateInfo> pojos) {		List<CommonData> result = new ArrayList();		for(RmtOperateInfo item : pojos){			result.add(toCommonData(item));		}		return success(result);	}	
	public RmtOperateInfo toPojo( CommonItem item) {		List<CommonData> datas = item.getDatas();		if(datas ==null||datas.size()==0){logger.debug("CommonItem 中data数据为空!!"); return null;}		if(datas.size()>1){logger.debug("CommonItem 中data数据不止一条数据!!"); }		return toPojoData(datas.get(0));	}	
	public List<RmtOperateInfo> toPojoList(  CommonItem item) {		List<RmtOperateInfo> result = new ArrayList();			List<CommonData> datas = item.getDatas();			for(CommonData data : datas){				result.add(toPojoData(data));			}			return result;		}		
}