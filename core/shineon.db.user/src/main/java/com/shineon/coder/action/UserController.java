package com.shineon.coder.action ;import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;import lombok.extern.slf4j.Slf4j;import org.springframework.web.bind.annotation.RestController;import org.springframework.web.bind.annotation.RequestMapping;import com.shineon.coder.service.convert.CommonItem;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.dto.UserDTO;import com.shineon.coder.kernel.constant.action.UserActionConstant;@RestController@Slf4jpublic class UserController extends RmtUserInfoCommonUtil {		@Autowired	UserDTO dto;		@RequestMapping(UserActionConstant.ACTION_GET)	public CommonItem get(String id){return dto.toCommon(dto.get(id));}		@RequestMapping(UserActionConstant.ACTION_EDIT)	public CommonItem edit(){return null;}		@RequestMapping(UserActionConstant.ACTION_LIST)	public CommonItem list(){return null;}}