package com.chanyun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class AppController {

	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		return "hello word";
	}
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
}
