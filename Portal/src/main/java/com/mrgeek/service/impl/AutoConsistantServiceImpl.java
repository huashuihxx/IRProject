package com.mrgeek.service.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mrgeek.service.AutoConsistantService;
import com.mrgeek.utils.HttpClientUtil;

@Service
public class AutoConsistantServiceImpl implements AutoConsistantService {
	
	@Value("${AUTO_CONSISTANT_URL}")
	private String AUTO_CONSISTANT_URL;
	
	@Override
	public String getTerms(String term) throws Exception {
		HashMap<String, String> param = new HashMap<>();
		param.put("term", term);
		String doGet = HttpClientUtil.doGet(AUTO_CONSISTANT_URL, param);
		return doGet;
	}

}
