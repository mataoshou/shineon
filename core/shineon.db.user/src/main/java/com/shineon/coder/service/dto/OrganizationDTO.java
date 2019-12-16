package com.shineon.coder.service.dto ;import com.shineon.coder.service.bo.OrganizationBO;import org.springframework.stereotype.Service;import com.shineon.coder.service.convert.util.RmtOrganizationInfoCommonUtil;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.db.sql.pojo.RmtOrganizationInfo;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.db.pojo.QueryItem;import com.shineon.coder.service.convert.util.QueryItemCommonUtil;import com.shineon.coder.service.convert.CommonItem;import java.util.List;@Service@Slf4jpublic class OrganizationDTO {	@Autowired	QueryItemCommonUtil queryItemCommonUtil;	@Autowired	OrganizationBO bo;	@Autowired	RmtOrganizationInfoCommonUtil commonUtil;	public RmtOrganizationInfo get(CommonItem item) throws Exception {		QueryItem query = queryItemCommonUtil.toPojo(item);		RmtOrganizationInfo organizationInfo = bo.get(query.getId());		if(organizationInfo==null) throw new Exception("数据不存在！");		return organizationInfo;	}	public RmtOrganizationInfo edit(CommonItem item) throws Exception {		RmtOrganizationInfo organizationInfo = commonUtil.toPojo(item);		if(organizationInfo.getId() ==null||organizationInfo.getId().equals("0")) {			bo.insert(organizationInfo);		}		else{			bo.update(organizationInfo);		}		return bo.get(organizationInfo.getId());	}	public List<RmtOrganizationInfo> list(CommonItem item) throws Exception {		QueryItem query = queryItemCommonUtil.toPojo(item);		return bo.list();	}}