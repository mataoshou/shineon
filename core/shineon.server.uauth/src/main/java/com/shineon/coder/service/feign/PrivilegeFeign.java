package com.shineon.coder.service.feign ;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.service.convert.CommonItem;import org.springframework.cloud.openfeign.FeignClient;import org.springframework.web.bind.annotation.RequestMapping;import com.shineon.coder.kernel.constant.feign.PrivilegeConstant;@FeignClient(name = PrivilegeConstant.FEIGN_SERVER_NAME,fallback = PrivilegeFeignFallBack.class)public interface PrivilegeFeign {	
	@RequestMapping(PrivilegeConstant. FEIGN_GET)	CommonItem get(CommonItem item);	
	@RequestMapping(PrivilegeConstant. FEIGN_EDIT)	CommonItem edit(CommonItem item);	
	@RequestMapping(PrivilegeConstant. FEIGN_LIST)	CommonItem list(CommonItem item);	
	@RequestMapping(PrivilegeConstant. FEIGN_DELETE)	CommonItem delete(CommonItem item);}