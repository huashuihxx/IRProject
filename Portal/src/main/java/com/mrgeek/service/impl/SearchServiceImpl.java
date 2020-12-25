package com.mrgeek.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mrgeek.service.SearchService;
import com.mrgeek.utils.HttpClientUtil;
import com.mrgeek.utils.Result;
import com.mrgeek.utils.SearchResult;

/**
* <p>Title: SearchServiceImpl.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-12-18_20:34:37
* @version 1.0
 */
@Service
public class SearchServiceImpl implements SearchService{
	
	@Value("${SERVER_URL}")
	private String SERVER_URL;
	
	@Override
	public String search(String query) throws Exception {
		Map<String, String>param = new HashMap<>();
		param.put("queryString", query);
		String doGet = HttpClientUtil.doGet(SERVER_URL, param);
		//对查询到的JSON数据进行处理,取出兀余
//		Result result = Result.format(doGet);
//		SearchResult data = (SearchResult) result.getData();
//		return data;
		return doGet;
	}

}
