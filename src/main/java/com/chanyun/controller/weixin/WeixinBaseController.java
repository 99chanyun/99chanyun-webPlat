/**  

* <p>Title: WeixinBaseController.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

* <p>Company: www.xinpiaoyuan.com</p>  

* @author liuyang  

* @date 2018年11月5日  

* @version 1.0  

*/ 
package com.chanyun.controller.weixin;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.apache.http.protocol.HTTP;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**  

 * <p>Title: WeixinBaseController.java</p>  

 * <p>Description: 微信接口开发基础类</p>  

 * <p>Copyright: Copyright (c) 2018 鑫票源商务资讯有限公司</p>  

 * <p>Company: www.xinpiaoyuan.com</p>  

 * @author liuyang  

 * @date 2018年11月5日  

 * @version 1.0  

 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinBaseController {
	
	@GetMapping("configUrl")
	@ResponseBody
	public String configUrl(HttpServletRequest request){
		//微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp，nonce参数
        String signature = request.getParameter("signature");
        //时间戳
        String timestamp = request.getParameter("timestamp");
        //随机数
        String nonce = request.getParameter("nonce");
        //随机字符串
        String echostr = request.getParameter("echostr");
		log.info("signature=="+signature+" timestamp = "+timestamp+" nonce = "+nonce+" echostr = "+echostr);
		return echostr;
	}

}
