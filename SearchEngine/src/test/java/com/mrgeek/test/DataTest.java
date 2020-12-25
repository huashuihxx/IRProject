package com.mrgeek.test;

import java.util.ArrayList;
import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mrgeek.component.ContentResult;
import com.mrgeek.component.SearchResult;
import com.mrgeek.service.LoadDataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*.xml")
public class DataTest {

	@Autowired
	private LoadDataService loadDataService;
	
	@Autowired
	private SolrServer solrServer;
	
	@Test
	public void testLoadDataToIndexDB() throws Exception {
		
//		loadDataService.LoadDataToIndexDB();
	}
	
	@Test
	public void testSearch() throws Exception {
		String queryString = "于是席先生说了一个安神治失眠的民间土方";
		SolrQuery query = new SolrQuery();
		//设置查询条件
		query.setQuery(queryString);
		//设置默认搜索域	
		query.set("df", "file_content");
		//设置高亮
		query.setHighlight(true);
		query.addHighlightField("file_content");
		query.setHighlightSimplePre("<font class=\"skcolor_ljg\">");
		query.setHighlightSimplePost("</font>");
		
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
		System.out.println(searchResult);
	}
	
}
