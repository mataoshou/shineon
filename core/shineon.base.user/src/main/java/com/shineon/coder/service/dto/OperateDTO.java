package com.shineon.coder.service.dto ;import org.springframework.stereotype.Service;import com.shineon.coder.service.convert.util.RmtOperateInfoCommonUtil;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.db.pojo.RmtOperateInfo;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.db.pojo.QueryItem;import com.shineon.coder.service.convert.util.QueryItemCommonUtil;import com.shineon.coder.service.convert.CommonItem;import java.util.List;import com.shineon.coder.service.cache.OperateCache;@Service@Slf4jpublic class OperateDTO {	
	@Autowired	QueryItemCommonUtil queryItemCommonUtil;	
	@Autowired	RmtOperateInfoCommonUtil commonUtil;	
	@Autowired	OperateCache cache;	
	public RmtOperateInfo get(CommonItem item) throws Exception{		QueryItem query = queryItemCommonUtil.toPojo(item);		return cache.get(query);	}	
	public RmtOperateInfo edit(CommonItem item) throws Exception{		RmtOperateInfo pojo = commonUtil.toPojo(item);		return cache.setCache(pojo,true);	}	
	public List<RmtOperateInfo> list(CommonItem item) throws Exception{		QueryItem query = queryItemCommonUtil.toPojo(item);		return cache.getListCache(query);	}	
	public void delete(CommonItem item) throws Exception{		RmtOperateInfo pojo = commonUtil.toPojo(item);		cache.delete(pojo);	}}