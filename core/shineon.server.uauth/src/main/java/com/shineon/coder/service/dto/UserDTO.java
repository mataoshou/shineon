package com.shineon.coder.service.dto ;import com.shineon.coder.service.feign.UserFeign;import org.springframework.stereotype.Service;import com.shineon.coder.service.convert.util.RmtUserInfoCommonUtil;import lombok.extern.slf4j.Slf4j;import com.shineon.coder.db.pojo.RmtUserInfo;import org.springframework.beans.factory.annotation.Autowired;import com.shineon.coder.db.pojo.QueryItem;import com.shineon.coder.service.convert.util.QueryItemCommonUtil;import com.shineon.coder.service.convert.CommonItem;import java.util.Date;import java.util.List;@Service@Slf4jpublic class UserDTO {		@Autowired	QueryItemCommonUtil queryItemCommonUtil;	@Autowired	UserFeign userFeign;	@Autowired	RmtUserInfoCommonUtil commonUtil;	public RmtUserInfo get(CommonItem item){		return commonUtil.toPojo( userFeign.get(item));	}		public RmtUserInfo edit(CommonItem item){		RmtUserInfo userInfo = commonUtil.toPojo(item);		userInfo.setModifyuserid("0");		userInfo.setModifytime(new Date());		CommonItem result = userFeign.edit(commonUtil.toCommon(userInfo));		return commonUtil.toPojo( result);	}		public List<RmtUserInfo> list(CommonItem item){		return commonUtil.toPojoList( userFeign.list(item));	}	public RmtUserInfo login(CommonItem item)	{		RmtUserInfo user = commonUtil.toPojo(item);		QueryItem queryItem = new QueryItem();		queryItem.setTitle(user.getUsername());		RmtUserInfo userInfo = commonUtil.toPojo( userFeign.getByName(queryItemCommonUtil.toCommon(queryItem)) );		if(userInfo==null) return null;		if(user.getUsername().equals(userInfo.getUsername())&&user.getUserpassword().equals(userInfo.getUserpassword()))		{			return userInfo;		}		return null;	}}