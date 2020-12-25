package com.mrgeek.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sound.sampled.Line;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * 分割文件工具类：技术验证
* <p>Title: SplitFileTest.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-12-12_11:23:32
* @version 1.0
 */
public class SplitFileTest {

	@Test
	public void testSplitFile() throws Exception {
		String filePath = "/home/mrgeek/document/测试数据.txt";
		FileInputStream fis = new FileInputStream(filePath);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		
		int i=1;
		String constPath = "/home/mrgeek/document/tempdir/";
		String targetFilePath = constPath+i+".txt";
		i++;
		
		FileOutputStream fos = new FileOutputStream(targetFilePath,true);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		String line;
		while ((line=br.readLine())!=null) {
			if (line.equals("")) {
				System.out.println("第"+(i-1)+"个文件生成完毕");
				targetFilePath = constPath+i+".txt";
				bw.close();
				fos = new FileOutputStream(targetFilePath);
				bw = new BufferedWriter(new OutputStreamWriter(fos));
				i++;
			}
			if (!line.equals("")) {
				bw.write(line+System.lineSeparator());
			}
		}
		br.close();
		bw.close();
	}
	
	@Test
	public void test1() throws Exception {
		String a = "   aaa";
		System.out.println(a.trim());
		System.out.println(StringUtils.isEmpty(a.trim()));
	}
}

























