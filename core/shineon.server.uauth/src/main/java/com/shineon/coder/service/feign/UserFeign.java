package com.shineon.coder.service.feign ;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.service.convert.CommonItem;import org.springframework.cloud.openfeign.FeignClient;import org.springframework.web.bind.annotation.RequestMapping;import com.shineon.coder.kernel.constant.feign.UserFeignConstant;@FeignClient(name = UserFeignConstant.FEIGN_SERVER_NAME,fallback = UserFeignFallBack.class)public interface UserFeign {	
	@RequestMapping(UserFeignConstant. FEIGN_GET)	CommonItem get(CommonItem item);	
	@RequestMapping(UserFeignConstant. FEIGN_EDIT)	CommonItem edit(CommonItem item);	
	@RequestMapping(UserFeignConstant. FEIGN_LIST)	CommonItem list(CommonItem item);	
	@RequestMapping(UserFeignConstant. FEIGN_DELETE)	CommonItem delete(CommonItem item);	
	@RequestMapping(UserFeignConstant. FEIGN_GETBYNAME)	CommonItem getbyname(CommonItem item);}