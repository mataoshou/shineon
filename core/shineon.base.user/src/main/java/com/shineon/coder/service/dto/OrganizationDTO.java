package com.shineon.coder.service.dto ;import org.springframework.stereotype.Service;import com.shineon.coder.service.convert.util.RmtOrganizationInfoCommonUtil;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.db.pojo.RmtOrganizationInfo;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.db.pojo.QueryItem;import com.shineon.coder.service.convert.util.QueryItemCommonUtil;import com.shineon.coder.service.convert.CommonItem;import java.util.List;import com.shineon.coder.service.cache.OrganizationCache;@Service@Slf4jpublic class OrganizationDTO {	
	@Autowired	QueryItemCommonUtil queryItemCommonUtil;	
	@Autowired	RmtOrganizationInfoCommonUtil commonUtil;	
	@Autowired	OrganizationCache cache;	
	public RmtOrganizationInfo get(CommonItem item) throws Exception{		QueryItem query = queryItemCommonUtil.toPojo(item);		return cache.get(query);	}	
	public RmtOrganizationInfo edit(CommonItem item) throws Exception{		RmtOrganizationInfo pojo = commonUtil.toPojo(item);		return cache.setCache(pojo,true);	}	
	public List<RmtOrganizationInfo> list(CommonItem item) throws Exception{		QueryItem query = queryItemCommonUtil.toPojo(item);		return cache.getListCache(query);	}	
	public void delete(CommonItem item) throws Exception{		RmtOrganizationInfo pojo = commonUtil.toPojo(item);		cache.delete(pojo);	}}