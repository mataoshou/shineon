package com.shineon.coder.service.dto ;import com.shineon.coder.service.convert.util.QueryItemCommonUtil;import org.springframework.stereotype.Service;import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.db.pojo.RmtUserInfo;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.feign.UserFeign;import com.shineon.coder.db.pojo.QueryItem;@Service@Slf4jpublic class UserDTO {		@Autowired	UserFeign service;	@Autowired	QueryItemCommonUtil queryItemCommonUtil;	@Autowired	RmtUserInfoCommonUtil commonUtil;	public RmtUserInfo get(QueryItem item){return commonUtil.toPojo(service.get(queryItemCommonUtil.toCommon(item)));}		public RmtUserInfo edit(QueryItem item){return null;}		public RmtUserInfo list(QueryItem item){return null;}}