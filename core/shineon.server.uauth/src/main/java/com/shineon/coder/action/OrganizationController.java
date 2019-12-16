package com.shineon.coder.action ;import com.shineon.coder.service.convert.util.RmtOrganizationInfoCommonUtil;import lombok.extern.slf4j.Slf4j;import org.springframework.web.bind.annotation.RestController;import org.springframework.web.bind.annotation.RequestMapping;import com.shineon.coder.service.convert.CommonItem;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.dto.OrganizationDTO;import com.shineon.coder.kernel.constant.action.OrganizationActionConstant;import org.springframework.web.bind.annotation.RequestBody;@RestController@Slf4jpublic class OrganizationController {	
	@Autowired	OrganizationDTO dto;	
	@Autowired	RmtOrganizationInfoCommonUtil commonUtil;	
	@RequestMapping(OrganizationActionConstant.ACTION_GET)	public CommonItem get(@RequestBody CommonItem item) throws Exception{		return commonUtil.toCommon(dto.get(item));	}	
	@RequestMapping(OrganizationActionConstant.ACTION_EDIT)	public CommonItem edit(@RequestBody CommonItem item) throws Exception{		return commonUtil.toCommon(dto.edit(item));	}	
	@RequestMapping(OrganizationActionConstant.ACTION_LIST)	public CommonItem list(@RequestBody CommonItem item) throws Exception{		return commonUtil.toCommon(dto.list(item));	}	
	@RequestMapping(OrganizationActionConstant.ACTION_DELETE)	public CommonItem delete(@RequestBody CommonItem item) throws Exception{		return commonUtil.toCommon(dto.delete(item));	}}