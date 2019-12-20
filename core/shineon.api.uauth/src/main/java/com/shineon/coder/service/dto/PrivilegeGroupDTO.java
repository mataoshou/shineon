package com.shineon.coder.service.dto ;import org.springframework.stereotype.Service;import com.shineon.coder.service.convert.util.RmtPrivilegeGroupInfoCommonUtil;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.db.pojo.RmtPrivilegeGroupInfo;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.db.pojo.QueryItem;import com.shineon.coder.service.convert.util.QueryItemCommonUtil;import com.shineon.coder.service.convert.CommonItem;import com.shineon.coder.db.common.ApiResultItem;import com.shineon.coder.service.feign.PrivilegeGroupFeign;@Service@Slf4jpublic class PrivilegeGroupDTO {		@Autowired	QueryItemCommonUtil queryItemCommonUtil;		@Autowired	PrivilegeGroupFeign feign;		@Autowired	RmtPrivilegeGroupInfoCommonUtil commonUtil;		public ApiResultItem get(CommonItem item) throws Exception{		QueryItem query = queryItemCommonUtil.toPojo(item);		CommonItem result =  feign.get(item);		return new ApiResultItem(result ,commonUtil.toPojo(result));	}		public ApiResultItem edit(CommonItem item) throws Exception{		QueryItem query = queryItemCommonUtil.toPojo(item);		CommonItem result =  feign.edit(item);		return new ApiResultItem(result ,commonUtil.toPojo(result));	}		public ApiResultItem list(CommonItem item) throws Exception{		QueryItem query = queryItemCommonUtil.toPojo(item);		CommonItem result =  feign.list(item);		return  new ApiResultItem(result ,commonUtil.toPojoList(result));	}		public ApiResultItem delete(CommonItem item) throws Exception{		QueryItem query = queryItemCommonUtil.toPojo(item);		CommonItem result =  feign.delete(item);		return new ApiResultItem(result ,commonUtil.toPojo(result));	}}