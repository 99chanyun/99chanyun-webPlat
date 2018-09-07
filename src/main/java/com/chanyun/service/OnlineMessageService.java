package com.chanyun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.dao.OnlineMessageMapper;
import com.chanyun.entity.OnlineMessage;

@Service
public class OnlineMessageService {
	@Autowired
	private OnlineMessageMapper mapper;
	
	public boolean add(OnlineMessage onlineMessage){
		int i =mapper.insert(onlineMessage);
		if(i >0) return true;
		return false;
	}
}
