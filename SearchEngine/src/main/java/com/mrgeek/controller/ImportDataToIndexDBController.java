package com.mrgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrgeek.component.Result;
import com.mrgeek.service.LoadDataService;

/**
 * 发布服务，对外提供导入数据到索引库的功能
* <p>Title: ImportDataToIndexDBController.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-12-18_11:02:46
* @version 1.0
 */
@Controller
public class ImportDataToIndexDBController {

	@Autowired
	private LoadDataService loadDataService;
	
	@RequestMapping("/importData")
	@ResponseBody
	public Result importData() {
		loadDataService.LoadDataToIndexDB();
		return Result.ok();
	}
	
}
