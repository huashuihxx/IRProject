package com.mrgeek.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mrgeek.component.ContentResult;
import com.mrgeek.component.SearchResult;
import com.mrgeek.dao.SearchDao;
@Component
public class SearchDaoImpl implements SearchDao {

	@Autowired
	private SolrServer solrServer;
	
	@Override
	public SearchResult search(SolrQuery query) throws SolrServerException {
		//执行查询
		QueryResponse response = solrServer.query(query);
		//取查询结果列表
		SolrDocumentList solrDocumentList = response.getResults();
		List<ContentResult> contentResults = new ArrayList<>();
		for (SolrDocument solrDocument : solrDocumentList) {
			//创建一个SearchResult对象
			ContentResult contentResult = new ContentResult();
			contentResult.setFilename((String) solrDocument.get("filename"));
			contentResult.setFileContent((String) solrDocument.get("file_content"));
			//添加到列表
			contentResults.add(contentResult);
		}
		SearchResult searchResult = new SearchResult();
		searchResult.setContentResults(contentResults);
		return searchResult;
	}

	
}
