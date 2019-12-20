package com.shineon.coder.service.feign ;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.service.convert.CommonItem;import org.springframework.cloud.openfeign.FeignClient;import org.springframework.web.bind.annotation.RequestMapping;import com.shineon.coder.kernel.constant.feign.OrganizationConstant;@FeignClient(name = OrganizationConstant.FEIGN_SERVER_NAME,fallback = OrganizationFeignFallBack.class)public interface OrganizationFeign {		@RequestMapping(OrganizationConstant.FEIGN_GET)	CommonItem get(CommonItem item);		@RequestMapping(OrganizationConstant. FEIGN_EDIT)	CommonItem edit(CommonItem item);		@RequestMapping(OrganizationConstant. FEIGN_LIST)	CommonItem list(CommonItem item);		@RequestMapping(OrganizationConstant. FEIGN_DELETE)	CommonItem delete(CommonItem item);}