package com.chanyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chanyun.dao.BodhisattvaMapper;
import com.chanyun.entity.Bodhisattva;
import com.chanyun.service.BodhisattvaService;

@Service
public class BodhisattaServiceImpl implements BodhisattvaService {
	@Autowired
	private BodhisattvaMapper mapper;
	@Override
	public List<Bodhisattva> queryBodhisattvaListByTempleId(int templeId) {
		Bodhisattva params = new Bodhisattva();
		params.setTempleId(templeId);
		List<Bodhisattva> result = mapper.queryByParams(params);
		return result;
	}

}
