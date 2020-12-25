package com.mrgeek.dao.impl;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mrgeek.dao.AutoConsistantDao;
import com.mrgeek.utils.HttpClientUtil;

@Component
public class AutoConsistantDaoImpl implements AutoConsistantDao {
	
	@Value("${AUTO_CONSISTANT_URL}")
	private String AUTO_CONSISTANT_URL;

	@Override
	public String getTerms(String term) throws ParseException, IOException {
		
		HashMap<String, String> param = new HashMap<>();
		param.put("wt", "json");
		param.put("terms.fl", "file_content");
		param.put("indent", "true");
		param.put("terms.prefix", term);
		String doGet = HttpClientUtil.doGet(AUTO_CONSISTANT_URL, param);
		return doGet;
	}

}
