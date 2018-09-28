package com.chanyun.common;

/**
 * @Description:基础常量类
 * @author liuyang
 * @data  2017-6-18 上午1:10:41
 *
 */
public class Constants {
	
	/**
	 * 返回码-成功
	 */
	public final static String RESULT_CODE_SUCCESS="0000";
	
	/**
	 * 返回码-失败
	 */
	public final static String RESULT_CODE_FAIL="0001";
	
	/**
	 *返回码-参数较验错误
	 */
	public final static String RESULT_CODE_CHECK_FAIL="0002";
	
	/**
	 * 佛门动态
	 */
	public final static int NEWS_TYPE_DYNAMIC=0;
	/**
	 * 政策法规
	 */
	public final static int NEWS_TYPE_STATUTE=1;
	/**
	 * 佛学入门
	 */
	public final static int NEWS_TYPE_BUDDHISM=2;
	/**
	 * 法事法会
	 */
	public final static int NEWS_TYPE_CEREMONIES=3;
//	public final static int NEWS_TYPE_DYNAMIC=4;
	/**
	 * 活动
	 */
	public final static int NEWS_TYPE_ACTIVITY=5;
	
	/**
	 * 用户登陆，sessison存储key
	 */
	public final static String USER_LOGIN_SESSION_KEY = "userAccount";
	
	/**
	 * 订单状态 申请
	 */
	public final static int MERITS_STATUS_APPLY=0;
	
	/**
	 * 订单状态 申请支付
	 */
	public final static int MERITS_STATUS_APPLY_PAY=1;
	
	/**
	 * 订单状态 已支付
	 */
	public final static int MERITS_STATUS_PAY=2;
	
	
	/**
	 * 订单状态  已完成
	 */
	public final static int MERITS_STATUS_COMPLETION=3;
	
	/**
	 * 订单状态 未完成
	 */
	public final static int MERITS_STATUS_FAIL=4;
	
	/**
	 * 订单状态 退款
	 */
	public final static int MERITS_STATUS_REFUND=5;
	
	/**
	 * 订单状态 订单异常
	 */
	public final static int MERITS_STATUS_EXCEPTION=9;
	
	/**
	 * 订单编号前缀
	 */
	public final static String MERITS_NUMBER_PREFIX="GD";
}
