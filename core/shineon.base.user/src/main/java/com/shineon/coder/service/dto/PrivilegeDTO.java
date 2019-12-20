package com.shineon.coder.service.dto ;import com.shineon.coder.service.cache.PrivilegeCache;import org.springframework.stereotype.Service;import com.shineon.coder.service.convert.util.RmtPrivilegeInfoCommonUtil;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.db.pojo.RmtPrivilegeInfo;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.db.pojo.QueryItem;import com.shineon.coder.service.convert.util.QueryItemCommonUtil;import com.shineon.coder.service.convert.CommonItem;import java.util.List;@Service@Slf4jpublic class PrivilegeDTO {	@Autowired	PrivilegeCache cache;	@Autowired	QueryItemCommonUtil queryItemCommonUtil;	@Autowired	RmtPrivilegeInfoCommonUtil commonUtil;		public RmtPrivilegeInfo get(CommonItem item) throws Exception{		QueryItem query = queryItemCommonUtil.toPojo(item);		return cache.get(query);	}		public RmtPrivilegeInfo edit(CommonItem item) throws Exception{		RmtPrivilegeInfo privilegeInfo = commonUtil.toPojo(item);		return cache.setCache(privilegeInfo,true);	}		public List<RmtPrivilegeInfo> list(CommonItem item) throws Exception{		QueryItem query = queryItemCommonUtil.toPojo(item);		return cache.getListCache(query);	}		public void delete(CommonItem item) throws Exception{		RmtPrivilegeInfo privilegeInfo = commonUtil.toPojo(item);		cache.delete(privilegeInfo);	}}