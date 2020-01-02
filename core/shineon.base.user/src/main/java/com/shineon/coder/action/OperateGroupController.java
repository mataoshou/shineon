package com.shineon.coder.action ;import com.shineon.coder.service.convert.util.RmtOperateGroupInfoCommonUtil;import lombok.extern.slf4j.Slf4j;import org.springframework.web.bind.annotation.RestController;import org.springframework.web.bind.annotation.RequestMapping;import com.shineon.coder.service.convert.CommonItem;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.dto.OperateGroupDTO;import com.shineon.coder.kernel.constant.action.OperateGroupControllerConstant;import org.springframework.web.bind.annotation.RequestBody;@RestController@Slf4jpublic class OperateGroupController {	
	@Autowired	OperateGroupDTO dto;	
	@Autowired	RmtOperateGroupInfoCommonUtil commonUtil;	
	@RequestMapping(OperateGroupControllerConstant.ACTION_GET)	public CommonItem get(@RequestBody CommonItem item)throws Exception{		return commonUtil.toCommon(dto.get(item));	}	
	@RequestMapping(OperateGroupControllerConstant.ACTION_EDIT)	public CommonItem edit(@RequestBody CommonItem item)throws Exception{		return commonUtil.toCommon(dto.edit(item));	}	
	@RequestMapping(OperateGroupControllerConstant.ACTION_LIST)	public CommonItem list(@RequestBody CommonItem item)throws Exception{		return commonUtil.toCommon(dto.list(item));	}	
	@RequestMapping(OperateGroupControllerConstant.ACTION_DELETE)	public CommonItem delete(@RequestBody CommonItem item) throws Exception{		dto.delete(item);		return commonUtil.success();	}}