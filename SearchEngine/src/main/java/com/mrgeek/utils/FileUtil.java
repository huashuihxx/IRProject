package com.mrgeek.utils;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 对文件进行分割
* <p>Title: SplitFileUtil.java<／p>
* <p>Description: <／p>
* <p>Copyright: Copyright (c) 2020<／p>
* <p>Company: CUIT<／p>
* @author MrGeek
* @date 2020-12-12_04:31:27
* @version 1.0
 */
public class FileUtil {

	/**
	 * 对文件内容进行分割，分割为多个小文件
	* <p>Title: SplitFile<／p>
	* <p>Description: <／p>
	* @param filePath 需要分割的文件的绝对路径
	 */
	public static void SplitFile(String filePath) {
		FileInputStream fis = null;
		BufferedReader br = null;
		FileOutputStream fos = null;
		BufferedWriter bw = null;
		try {
			fis = new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fis));
			
			int i=1;
			String constPath = "/home/mrgeek/document/tempdir/";
			String targetFilePath = constPath+i+".txt";
			i++;
			
			fos = new FileOutputStream(targetFilePath);
			bw = new BufferedWriter(new OutputStreamWriter(fos));
			
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
			File file = new File(targetFilePath);
			file.delete();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * 将txt文件的内容加载进String字符串中
	* <p>Title: LoadFileToString<／p>
	* <p>Description: <／p>
	* @param filePath 需要被加载的文件的路径
	 */
	public static String LoadFileToString(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			StringBuffer sb = new StringBuffer();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			br.close();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
