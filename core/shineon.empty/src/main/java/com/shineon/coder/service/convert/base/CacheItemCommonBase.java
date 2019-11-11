package com.shineon.coder.service.convert.base;import com.shineon.coder.db.pojo.CacheItem;import com.shineon.coder.service.convert.CommonData;import com.shineon.coder.service.convert.CommonItem;import com.shineon.coder.service.convert.CommonItemUtils;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import java.util.ArrayList;import java.util.List;public class CacheItemCommonBase implements CommonItemUtils<CacheItem> {	Logger logger = LoggerFactory.getLogger(getClass());		private CommonData toCommonData(CacheItem pojo) {		CommonData data = new CommonData();		data.setParent(pojo.getName());		data.setBegin(pojo.getCreateTime());		data.setEnd(pojo.getLastModified());		return data;	}		private CacheItem toPojoData( CommonData data) {		CacheItem pojo = new CacheItem();		pojo.setName(data.getParent());		pojo.setCreateTime(data.getBegin());		pojo.setLastModified(data.getEnd());		return pojo;	}		public CommonItem toCommon(CacheItem pojo) {		return success(toCommonData(pojo));	}		public CommonItem toCommon(List<CacheItem> pojos) {		List<CommonData> result = new ArrayList();		for(CacheItem item : pojos){			result.add(toCommonData(item));		}		return success(result);	}		public CacheItem toPojo( CommonItem item) {		List<CommonData> datas = item.getDatas();		if(datas ==null||datas.size()==0){logger.debug("CommonItem 中data数据为空!!"); return null;}		if(datas.size()>1){logger.debug("CommonItem 中data数据不止一条数据!!"); }		return toPojoData(datas.get(0));	}		public List<CacheItem> toPojoList(  CommonItem item) {		List<CacheItem> result = new ArrayList();			List<CommonData> datas = item.getDatas();			for(CommonData data : datas){				result.add(toPojoData(data));			}			return result;		}		}