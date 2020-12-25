package com.mrgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
* @date 2020-12-20_18:41:56
* @version 1.0
 */
@Controller
public class AutoConsistantController {

	@Autowired
	private AutoConsistantService autoConsistantService;
	
	@RequestMapping(value = "/terms",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getTerms(@RequestParam String term) {
		String result = null;
		try {
			result = autoConsistantService.getTerms(term);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
