//package com.mg.coder.convert.base;
//
//;
//import com.shineon.coder.db.pojo.ShineonUserAttached;;
//import com.mg.coder.convert.CommonData;;
//
//public class ShineonUserAttachedCommonBase {
//		public CommonData shineonUserAttachedToCommon( ShineonUserAttached item) {
//			CommonData result = new CommonData();
//			result.setId(item.getId());
//			result.setParent(item.getUserid());
//			result.setCreateTime(item.getTimelastlogin());
//			result.setBeginTime(item.getIplastlogin());
//			return result;
//		}
//		public ShineonUserAttached commonToShineonUserAttached( CommonData item) {
//			ShineonUserAttached result = new ShineonUserAttached();
//			result.setId(item.getId());
//			result.setUserid(item.getParent());
//			result.setTimelastlogin(item.getCreateTime());
//			result.setIplastlogin(item.getBeginTime());
//			return result;
//		}
//
//}
