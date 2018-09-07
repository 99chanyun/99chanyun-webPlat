package com.chanyun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.Headers.ContentSecurityPolicyMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

import com.chanyun.common.Constants;
import com.chanyun.entity.OnlineMessage;
import com.chanyun.service.OnlineMessageService;

@Controller
@RequestMapping(value="/api")
public class OnlineMessageController extends BaseController {
	@Autowired
	private OnlineMessageService onlineMessageService;
	
	@ResponseBody
	@RequestMapping("/onlineMessage")
	public String onlineMessage(@RequestBody OnlineMessage entity){
		boolean result = onlineMessageService.add(entity);
		if(result)
			return returnBaseResult(Constants.RESULT_CODE_SUCCESS, "成功");
		return returnBaseResult(Constants.RESULT_CODE_FAIL, "失败");
	}
}
