/**  

* <p>Title: UserAuthorizeController.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年11月5日  

* @version 1.0  

*/ 
package com.chanyun.controller.weixin;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.chanyun.service.http.HttpAPIService;

/**  

 * <p>Title: UserAuthorizeController.java</p>  

 * <p>Description: 用户授权登陆</p>  

 * <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

 * <p>Company: www.xinpiaoyuan.com</p>  

 * @author liuyang  

 * @date 2018年11月5日  

 * @version 1.0  

 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class UserAuthorizeController {
	@Autowired
	private Environment ev;
	@Autowired
	private HttpAPIService httpAPIService;
	
	@GetMapping("getCode")
	public String getCode(HttpServletRequest request,HttpServletResponse response){
		String appID = ev.getProperty("weixin.appID");
		String redirectURL = null;
		try {
			redirectURL = URLEncoder.encode(ev.getProperty("weixin.redirectURL"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String requestUrl = String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect",
				appID, redirectURL, "snsapi_userinfo", "snsapi_userinfo");
//		String requestUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appID+"&redirect_uri="+redirectURL+"&response_type=code&scope=snsapi_userinfo&state=123#wechat_redirect";
		try {
			response.sendRedirect(requestUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String str;
//		try {
//			log.info("requesturl="+requestUrl);
//			str = httpAPIService.doGet(requestUrl);
//			log.info(str);
//			return str;
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return null;
	}
	
	@GetMapping("auth")
    public String auth(HttpServletRequest request,
                         @Param("code") String code) {
        Map<String, String> data = new HashMap();
        String appID = ev.getProperty("weixin.appID");
        String appSecret = ev.getProperty("weixin.appSecret");
        String requestUrl = String.format("https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=%s",
    				appID, appSecret, code, "authorization_code");
        try {
			String result = httpAPIService.doGet(requestUrl);
			JSONObject resultJson = JSONObject.parseObject(result);
			String openId = resultJson.getString("openid");
			String accessToken = resultJson.getString("access_token");
			String refreshToken = resultJson.getString("refresh_token");
			String userInfo = getUserInfo(openId, accessToken);
			return userInfo;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
	
	public String getUserInfo(String openId,String accessToken){
		String requestUrl = String.format("https://api.weixin.qq.com/sns/userinfo?access_token=%s&openid=%s&lang=%s", 
				accessToken, openId, "zh_CN");
		try {
			String result = httpAPIService.doGet(requestUrl);
			log.info(result);
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
