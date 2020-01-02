package com.shineon.coder.service.dto ;import org.springframework.stereotype.Service;import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.db.pojo.RmtUserInfo;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.db.pojo.QueryItem;import com.shineon.coder.service.convert.util.QueryItemCommonUtil;import com.shineon.coder.service.convert.CommonItem;import java.util.List;import com.shineon.coder.service.cache.UserCache;@Service@Slf4jpublic class UserDTO {	
	@Autowired	QueryItemCommonUtil queryItemCommonUtil;	
	@Autowired	RmtUserInfoCommonUtil commonUtil;	
	@Autowired	UserCache cache;	
	public RmtUserInfo get(CommonItem item) throws Exception{		QueryItem query = queryItemCommonUtil.toPojo(item);		return cache.get(query);	}	
	public RmtUserInfo edit(CommonItem item) throws Exception{		RmtUserInfo pojo = commonUtil.toPojo(item);		return cache.setCache(pojo,true);	}	
	public List<RmtUserInfo> list(CommonItem item) throws Exception{		QueryItem query = queryItemCommonUtil.toPojo(item);		return cache.getListCache(query);	}	
	public void delete(CommonItem item) throws Exception{		RmtUserInfo pojo = commonUtil.toPojo(item);		cache.delete(pojo);	}	
	public RmtUserInfo getbyname(CommonItem item) throws Exception{		QueryItem query = queryItemCommonUtil.toPojo(item);		return cache.get(query);	}}