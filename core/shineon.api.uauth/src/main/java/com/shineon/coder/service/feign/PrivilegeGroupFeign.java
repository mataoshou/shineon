package com.shineon.coder.service.feign ;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.service.convert.CommonItem;import org.springframework.cloud.openfeign.FeignClient;import org.springframework.web.bind.annotation.RequestMapping;import com.shineon.coder.kernel.constant.feign.PrivilegeGroupConstant;@FeignClient(name = PrivilegeGroupConstant.FEIGN_SERVER_NAME,fallback = PrivilegeGroupFeignFallBack.class)public interface PrivilegeGroupFeign {	
	@RequestMapping(PrivilegeGroupConstant. FEIGN_GET)	CommonItem get(CommonItem item);	
	@RequestMapping(PrivilegeGroupConstant. FEIGN_EDIT)	CommonItem edit(CommonItem item);	
	@RequestMapping(PrivilegeGroupConstant. FEIGN_LIST)	CommonItem list(CommonItem item);	
	@RequestMapping(PrivilegeGroupConstant. FEIGN_DELETE)	CommonItem delete(CommonItem item);}