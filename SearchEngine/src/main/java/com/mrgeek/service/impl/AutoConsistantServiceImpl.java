package com.mrgeek.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrgeek.dao.AutoConsistantDao;
import com.mrgeek.service.AutoConsistantService;
import com.mrgeek.utils.JsonUtil;

@Service
public class AutoConsistantServiceImpl implements AutoConsistantService {

	@Autowired
	private AutoConsistantDao autoConsistantDao;
	
	@Override
	@SuppressWarnings("unchecked")
	public String getTerms(String term) throws Exception {
		String terms = autoConsistantDao.getTerms(term);
		Map<String,Map<String, Object>> map = JsonUtil.jsonToPojo(terms, Map.class);
		List<Object> list = (List<Object>) map.get("terms").get("file_content");
		List<String>consistantList = new ArrayList<>();
		int i=0;
		for (Object object : list) {
			if (i%2==0) {
				consistantList.add((String)object);
			}
			i++;
		}
		return JsonUtil.objectToJson(consistantList);
	}

}
