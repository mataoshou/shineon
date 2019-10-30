package com.shineon.coder.action ;import com.shineon.coder.db.pojo.QueryItem;import com.shineon.coder.kernel.constant.action.UserActionConstant;import com.shineon.coder.service.convert.CommonItem;import com.shineon.coder.service.convert.util.QueryItemCommonUtil;import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;import com.shineon.coder.service.dto.UserDTO;import lombok.extern.slf4j.Slf4j;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.RestController;@RestController@Slf4jpublic class UserController {		@Autowired	UserDTO dto;		@Autowired	RmtUserInfoCommonUtil commonUtil;		@Autowired	QueryItemCommonUtil queryItemCommonUtil;		@RequestMapping(UserActionConstant.ACTION_GET)	public CommonItem get(CommonItem item){		QueryItem query = queryItemCommonUtil.toPojo(item);		return null;	}		@RequestMapping(UserActionConstant.ACTION_EDIT)	public CommonItem edit(CommonItem item){		QueryItem query = queryItemCommonUtil.toPojo(item);		return null;	}		@RequestMapping(UserActionConstant.ACTION_LIST)	public CommonItem list(CommonItem item){		QueryItem query = queryItemCommonUtil.toPojo(item);		return commonUtil.toCommon(dto.list(query));	}}