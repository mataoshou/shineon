package com.shineon.coder.service.feign ;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.service.convert.CommonItem;import org.springframework.stereotype.Component;import com.shineon.coder.kernel.constant.feign.PrivilegeFeignConstant;@Component@Slf4jpublic class PrivilegeFeignFallBack implements PrivilegeFeign,BaseFallBack{	
	@Override	public CommonItem get(CommonItem item){return fail(PrivilegeFeignConstant.FEIGN_SERVER_NAME);}	
	@Override	public CommonItem edit(CommonItem item){return fail(PrivilegeFeignConstant.FEIGN_SERVER_NAME);}	
	@Override	public CommonItem list(CommonItem item){return fail(PrivilegeFeignConstant.FEIGN_SERVER_NAME);}	
	@Override	public CommonItem delete(CommonItem item){return fail(PrivilegeFeignConstant.FEIGN_SERVER_NAME);}}