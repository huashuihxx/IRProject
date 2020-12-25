package com.mrgeek.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mrgeek.dao.AutoConsistantDao;
import com.mrgeek.dao.impl.AutoConsistantDaoImpl;
import com.mrgeek.utils.JsonUtil;

/**
 * 
* <p>Title: AutoConsistantTest.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-12-20_18:13:09
* @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*.xml")
public class AutoConsistantTest {

	@Autowired
	private AutoConsistantDao autoConsistantDao;
	
	@Test
	public void testConsistant() throws Exception {
		String term = "哈";
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
		System.out.println(consistantList);
	}
}
