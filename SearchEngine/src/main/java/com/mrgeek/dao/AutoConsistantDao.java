package com.mrgeek.dao;

import java.io.IOException;

import org.apache.http.ParseException;

/**
 * 获取solr分词库中的分词结果
* <p>Title: KeyWordDao.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-12-19_22:46:08
* @version 1.0
 */
public interface AutoConsistantDao {

	/**
	 * 调用/terms 方法,获取到指定的 terms
	* <p>Title: getTerms<／p>
	* <p>Description: <／p>
	* @param term
	* @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public String getTerms(String term) throws ParseException, IOException;
}
