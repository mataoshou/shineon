package com.shineon.coder.kernel.constant.cache;public class CacheConstant {	public static final String CACHE_PACKAGE ="com.shineon.coder.service.cache";		public static final String CACHE_CONSTANT_PACKAGE ="com.shineon.coder.kernel.constant.cache";		public static final String REDIS_KEY_PRE = "SHINEON.BASE.USER.";		public static final String REDIS_KEY_LAST = "DATA";		public static long CACHE_SYS_INTERVAL = 1000*60;	public static final String  CACHE_DATE_LIST_SIGN ="000001";	public static final String  CACHE_DATE_POJO_SIGN ="000002";	public static final String  CACHE_MESSAGE_LIST_SIGN ="000003";	public static final String  CACHE_MESSAGE_POJO_SIGN ="000004";	/**	 * 缓存通用存活时长  暂定6个小时	 */	public static long CACHE_LIVE = 1000 * 60 * 60 *6;	/**	 * lock缓存存活时长	 */	public static long CACHE_LOCK_LIVE = 1000 * 30;	}