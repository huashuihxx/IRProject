package com.mrgeek.service;

import java.io.IOException;

import org.apache.http.ParseException;

import com.mrgeek.utils.SearchResult;

/**
 * 调用查询服务，进行查询
* <p>Title: SearchService.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-12-18_20:33:12
* @version 1.0
 */
public interface SearchService {

	public String search(String query) throws Exception;
}
