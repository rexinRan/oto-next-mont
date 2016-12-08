package com.buss.common.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.buss.common.util.IDUtils;

/**
 * 
 * 用户上传文件（非管理员上传）
 * 
 * @author Administrator
 * 
 */

@Service
public class UserFileService {

	@Value("${WIN_REAL_PATH}")
	private String winrealPath;
	@Value("${LINUX_REAL_PATH}")
	private String linuxrealPath;

	/**
	 * 用户上传文件的方法
	 * 
	 * @param uploadFile
	 * @return
	 * @throws IOException
	 */
	public Map upload(@RequestParam MultipartFile uploadFile) throws IOException {

		// 判断当前操作系统的类型
		String osName = System.getProperty("os.name");
		// SystemProperty.getSystemContent();

		File destFile = null;
		// 如果当前是windows系统
		if (osName.toLowerCase().contains("windows")) {
			destFile = new File(winrealPath);
		} else {
			destFile = new File(linuxrealPath);
		}

		// 如果路径不存在,递归创建文件夹
		if (!destFile.exists()) {
			destFile.mkdirs();
		}

		String uuid = IDUtils.getUUID();

		// 创建新的文件
		File newFile = new File(destFile, uuid);

		try {
			uploadFile.transferTo(newFile);
			String path = newFile.getAbsolutePath();

			// 返回Map数据
			Map result = new HashMap<>();
			result.put("error", 0);
			result.put("url", path);

			return result;

		} catch (Exception e) {
			e.printStackTrace();

			// 返回Map数据
			Map result = new HashMap<>();
			result.put("error", 1);
			result.put("url", "");

			return result;

		}

	}

}