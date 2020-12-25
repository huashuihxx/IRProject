package com.mrgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrgeek.service.AutoConsistantService;

/**
 * 
* <p>Title: AutoConsistantController.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-12-20_19:06:51
* @version 1.0
 */
@Controller
public class AutoConsistantController {

	@Autowired
	private AutoConsistantService autoConsistantService;
	
	@RequestMapping(value = "/terms",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getTerms(@RequestParam String term) {
		String terms = null;
		try {
			terms = autoConsistantService.getTerms(term);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return terms;
	}
	
}
