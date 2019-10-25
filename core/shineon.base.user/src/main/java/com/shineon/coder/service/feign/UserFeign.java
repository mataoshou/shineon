package com.shineon.coder.service.feign ;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.service.convert.CommonItem;import org.springframework.cloud.openfeign.FeignClient;import org.springframework.web.bind.annotation.RequestMapping;import com.shineon.coder.kernel.constant.feign.UserConstant;@FeignClient(name = UserConstant.FEIGN_SERVER_NAME,fallback = UserFeignFallBack.class)public interface UserFeign {		@RequestMapping(UserConstant. FEIGN_GET)	CommonItem get(CommonItem item);		@RequestMapping(UserConstant. FEIGN_EDIT)	CommonItem edit(CommonItem item);		@RequestMapping(UserConstant. FEIGN_LIST)	CommonItem list();}