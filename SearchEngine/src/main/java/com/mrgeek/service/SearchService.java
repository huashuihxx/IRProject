package com.mrgeek.service;

import org.apache.solr.client.solrj.SolrServerException;

import com.mrgeek.component.Result;

public interface SearchService {
	
	public Result searchResult(String keyword) throws SolrServerException;
}
