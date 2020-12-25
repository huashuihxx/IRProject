package com.mrgeek.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mrgeek.service.SearchService;
import com.mrgeek.utils.ContentResult;
import com.mrgeek.utils.JsonUtil;
import com.mrgeek.utils.Result;

import net.sf.json.JSONArray;

/**
 * 查询服务
* <p>Title: SearchController.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-12-18_20:47:45
* @version 1.0
 */
@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping(value = "/search",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	public ModelAndView search(@RequestParam String wd) {
		String result = null;
		try {
			result = searchService.search(wd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map = JsonUtil.jsonToPojo(result, Map.class);
		Map<String,List<Map<String, String>>> dataMap= (Map<String, List<Map<String, String>>>) map.get("data");
		List<Map<String, String>> contentResults = dataMap.get("contentResults");
		List<String> fileContentList = new ArrayList<>();
		for (Map<String, String> map2 : contentResults) {
			fileContentList.add(map2.get("fileContent"));
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("fileContentList", fileContentList);
		modelAndView.setViewName("content");
		return modelAndView;
	}
	
}
