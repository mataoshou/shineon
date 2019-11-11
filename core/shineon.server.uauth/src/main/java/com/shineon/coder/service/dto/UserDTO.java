package com.shineon.coder.service.dto ;import com.shineon.coder.service.convert.util.QueryItemCommonUtil;import org.springframework.stereotype.Service;import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.db.pojo.RmtUserInfo;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.feign.UserFeign;import com.shineon.coder.db.pojo.QueryItem;import java.util.List;@Service@Slf4jpublic class UserDTO {		@Autowired	UserFeign userFeign;	@Autowired	QueryItemCommonUtil commonUtil;	@Autowired	RmtUserInfoCommonUtil userInfoCommonUtil;	public RmtUserInfo get(QueryItem item){		return userInfoCommonUtil.toPojo( userFeign.get(commonUtil.toCommon(item)));	}	public RmtUserInfo edit(QueryItem item)  {		return userInfoCommonUtil.toPojo( userFeign.edit(commonUtil.toCommon(item)));	}	public List<RmtUserInfo> list(QueryItem item) {		item = new QueryItem();		return userInfoCommonUtil.toPojoList( userFeign.list(commonUtil.toCommon(item)));	}}