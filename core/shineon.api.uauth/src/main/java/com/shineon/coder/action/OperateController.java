package com.shineon.coder.action ;import com.shineon.coder.service.convert.util.RmtOperateInfoCommonUtil;import lombok.extern.slf4j.Slf4j;import org.springframework.web.bind.annotation.RestController;import org.springframework.web.bind.annotation.RequestMapping;import com.shineon.coder.service.convert.CommonItem;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.dto.OperateDTO;import com.shineon.coder.kernel.constant.action.OperateControllerConstant;import org.springframework.web.bind.annotation.RequestBody;import com.alibaba.fastjson.JSONObject;import com.shineon.coder.db.common.ApiResultItem;import com.shineon.coder.db.pojo.RmtOperateInfo;@RestController@Slf4jpublic class OperateController {	
	@Autowired	OperateDTO dto;	
	@Autowired	RmtOperateInfoCommonUtil commonUtil;	
	@RequestMapping(OperateControllerConstant.ACTION_GET)	public ApiResultItem get(@RequestBody JSONObject params) throws Exception{		RmtOperateInfo pojo = new RmtOperateInfo();		pojo.setId(params.getString("id"));		return dto.get(commonUtil.toCommon(pojo));	}	
	@RequestMapping(OperateControllerConstant.ACTION_EDIT)	public ApiResultItem edit(@RequestBody JSONObject params) throws Exception{		RmtOperateInfo pojo = new RmtOperateInfo();		pojo.setId(params.getString("id"));		pojo.setOperatename(params.getString("operatename"));		pojo.setOperatetype(params.getInteger("operatetype"));		pojo.setBelongsystem(params.getString("belongsystem"));		pojo.setPagelocation(params.getString("pagelocation"));		pojo.setArealocation(params.getString("arealocation"));		pojo.setApplicationkey(params.getString("applicationkey"));		pojo.setVisibility(params.getInteger("visibility"));		pojo.setOperability(params.getInteger("operability"));		pojo.setIsrequiredfield(params.getInteger("isrequiredfield"));		pojo.setDescription(params.getString("description"));		pojo.setReserved1(params.getInteger("reserved1"));		pojo.setReserved2(params.getString("reserved2"));		return dto.edit(commonUtil.toCommon(pojo));	}	
	@RequestMapping(OperateControllerConstant.ACTION_LIST)	public ApiResultItem list(@RequestBody JSONObject params) throws Exception{		return dto.list(commonUtil.success());	}	
	@RequestMapping(OperateControllerConstant.ACTION_DELETE)	public ApiResultItem delete(@RequestBody JSONObject params) throws Exception{		RmtOperateInfo pojo = new RmtOperateInfo();		pojo.setId(params.getString("id"));		return dto.delete(commonUtil.toCommon(pojo));	}}