package com.mrgeek.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mrgeek.dao.DataDao;
import com.mrgeek.service.LoadDataService;

/**
 * 将数据加载进索引库
* <p>Title: LoadDataToIndexDB.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-12-13_20:43:30
* @version 1.0
 */
@Service
public class LoadDataServiceImpl implements LoadDataService{

	@Autowired 
	private DataDao dataDao;

	@Value("${FILEPATH}")
	private String filePath;
	/**
	 * 加载数据到索引库中
	* <p>Title: LoadDataToIndexDB<／p>
	* <p>Description: <／p>
	 */
	@SuppressWarnings("static-access")
	public void LoadDataToIndexDB() {
		dataDao.LoadDataToIndexDB(filePath);
	}
	
}
