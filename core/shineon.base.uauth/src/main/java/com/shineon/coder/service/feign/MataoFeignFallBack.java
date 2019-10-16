package com.shineon.coder.service.feign ;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.service.convert.CommonItem;import org.springframework.stereotype.Component;import com.shineon.coder.kernel.constant.feign.MataoConstant;@Component@Slf4jpublic class MataoFeignFallBack implements MataoFeign,BaseFallBack{	
	@Override	public CommonItem get(){return fail(MataoConstant.FEIGN_SERVER_NAME);}	
	@Override	public CommonItem edit(){return fail(MataoConstant.FEIGN_SERVER_NAME);}	
	@Override	public CommonItem list(){return fail(MataoConstant.FEIGN_SERVER_NAME);}}