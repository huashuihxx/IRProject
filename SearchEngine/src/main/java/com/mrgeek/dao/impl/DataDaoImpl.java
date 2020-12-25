package com.mrgeek.dao.impl;

import java.io.File;
import java.io.IOException;

import javax.xml.crypto.Data;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mrgeek.dao.DataDao;
import com.mrgeek.utils.FileUtil;

/**
 * 对数据进行一些处理
* <p>Title: DataDao.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-12-13_20:07:58
* @version 1.0
 */
@Component
public class DataDaoImpl implements DataDao{

	@Autowired
	private SolrServer solrServer;
	
//	static{
//		String filePath = "/home/mrgeek/document/测试数据.txt";
//		FileUtil.SplitFile(filePath);
//	}
	
	/**
	 * 将所有的文件的内容导入索引库
	* <p>Title: LoadDataToIndexDB<／p>
	* <p>Description: <／p>
	* @param filePath 数据源的文件夹路径
	 */
	public void LoadDataToIndexDB(String filePath) {
		//获取到某一路径下的所有txt文件
		File filesDir = new File(filePath);
		File[] files = filesDir.listFiles();
		
		for (File file : files) {
			//获取到文件名
			String fileName = file.getName();
			//判断是否为txt文件
			if (fileName.endsWith(".txt")) {
				//创建document对象
				SolrInputDocument document = new SolrInputDocument();
				//添加域
				document.addField("filename",file.getName());
				document.addField("file_content", FileUtil.LoadFileToString(file));
				try {
					solrServer.add(document);
					solrServer.commit();
				} catch (SolrServerException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
