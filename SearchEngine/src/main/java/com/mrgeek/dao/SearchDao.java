package com.mrgeek.dao;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;

import com.mrgeek.component.SearchResult;

/**
 * 提供搜索服务
* <p>Title: SearchDao.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-12-18_11:25:08
* @version 1.0
 */
public interface SearchDao {

	public SearchResult search(SolrQuery query) throws SolrServerException;
}
