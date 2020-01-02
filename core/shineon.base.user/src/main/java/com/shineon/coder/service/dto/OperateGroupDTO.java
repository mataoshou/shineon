package com.shineon.coder.service.dto ;import org.springframework.stereotype.Service;import com.shineon.coder.service.convert.util.RmtOperateGroupInfoCommonUtil;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.db.pojo.RmtOperateGroupInfo;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.db.pojo.QueryItem;import com.shineon.coder.service.convert.util.QueryItemCommonUtil;import com.shineon.coder.service.convert.CommonItem;import java.util.List;import com.shineon.coder.service.cache.OperateGroupCache;@Service@Slf4jpublic class OperateGroupDTO {	
	@Autowired	QueryItemCommonUtil queryItemCommonUtil;	
	@Autowired	RmtOperateGroupInfoCommonUtil commonUtil;	
	@Autowired	OperateGroupCache cache;	
	public RmtOperateGroupInfo get(CommonItem item) throws Exception{		QueryItem query = queryItemCommonUtil.toPojo(item);		return cache.get(query);	}	
	public RmtOperateGroupInfo edit(CommonItem item) throws Exception{		RmtOperateGroupInfo pojo = commonUtil.toPojo(item);		return cache.setCache(pojo,true);	}	
	public List<RmtOperateGroupInfo> list(CommonItem item) throws Exception{		QueryItem query = queryItemCommonUtil.toPojo(item);		return cache.getListCache(query);	}	
	public void delete(CommonItem item) throws Exception{		RmtOperateGroupInfo pojo = commonUtil.toPojo(item);		cache.delete(pojo);	}}