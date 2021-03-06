package com.shineon.coder.service.feign ;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.service.convert.CommonItem;import org.springframework.stereotype.Component;import com.shineon.coder.kernel.constant.feign.UserFeignConstant;@Component@Slf4jpublic class UserFeignFallBack implements UserFeign,BaseFallBack{	
	@Override	public CommonItem get(CommonItem item){return fail(UserFeignConstant.FEIGN_SERVER_NAME);}	
	@Override	public CommonItem edit(CommonItem item){return fail(UserFeignConstant.FEIGN_SERVER_NAME);}	
	@Override	public CommonItem list(CommonItem item){return fail(UserFeignConstant.FEIGN_SERVER_NAME);}	
	@Override	public CommonItem delete(CommonItem item){return fail(UserFeignConstant.FEIGN_SERVER_NAME);}	
	@Override	public CommonItem getbyname(CommonItem item){return fail(UserFeignConstant.FEIGN_SERVER_NAME);}}