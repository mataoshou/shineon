package com.shineon.coder.db.sql.dao ;import com.shineon.coder.db.sql.pojo.RmtUserInfo;import java.util.List;public interface RmtUserInfoMapperExtern {	 List<RmtUserInfo> list(String where,String order);	 RmtUserInfo selectByName(String name);	int insertUser(RmtUserInfo user);}