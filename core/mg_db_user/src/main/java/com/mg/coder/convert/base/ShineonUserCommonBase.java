//package com.mg.coder.convert.base;
//
//;
//import com.shineon.coder.db.pojo.ShineonUser;;
//import com.mg.coder.convert.CommonData;;
//
//public class ShineonUserCommonBase {
//		public CommonData shineonUserToCommon( ShineonUser item) {
//			CommonData result = new CommonData();
//			result.setId(item.getId());
//			result.setContent(item.getUsername());
//			result.setTitle(item.getDisplayname());
//			result.setParent(item.getParent());
//			result.setPtitle(item.getUsercode());
//			result.setThumb(item.getUserthumb());
//			result.setCreateTime(item.getTimecreated());
//			result.setBeginTime(item.getTimemodified());
//			result.setEndTime(item.getTimedeleted());
//			return result;
//		}
//		public ShineonUser commonToShineonUser( CommonData item) {
//			ShineonUser result = new ShineonUser();
//			result.setId(item.getId());
//			result.setUsername(item.getContent());
//			result.setDisplayname(item.getTitle());
//			result.setParent(item.getParent());
//			result.setUsercode(item.getPtitle());
//			result.setUserthumb(item.getThumb());
//			result.setTimecreated(item.getCreateTime());
//			result.setTimemodified(item.getBeginTime());
//			result.setTimedeleted(item.getEndTime());
//			return result;
//		}
//
//}
