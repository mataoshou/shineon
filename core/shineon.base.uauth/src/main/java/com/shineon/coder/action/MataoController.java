package com.shineon.coder.action ;import com.shineon.coder.service.convert.util.ShineonUserCommonUtil;import lombok.extern.slf4j.Slf4j;import org.springframework.web.bind.annotation.RestController;import org.springframework.web.bind.annotation.RequestMapping;import com.shineon.coder.service.convert.CommonItem;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.service.dto.MataoDTO;@RestController@Slf4jpublic class MataoController extends ShineonUserCommonUtil {	
	@Autowired	MataoDTO dto;	
	@RequestMapping	public CommonItem get(){return null;}	
	@RequestMapping	public CommonItem edit(){return null;}	
	@RequestMapping	public CommonItem list(){return null;}}