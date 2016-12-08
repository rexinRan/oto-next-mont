package com.buss.common.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.ClientProtocolException;
import org.jweb.core.bean.MultipartNameValuePair;
import org.jweb.core.bean.UploadFileMode;
import org.jweb.core.util.DateUtil;
import org.jweb.core.util.FileUtil;
import org.jweb.core.util.HttpClientUtil;
import org.jweb.core.util.ResourceUtil;
import org.jweb.core.util.StringUtil;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;


/**
 * 用于scs上传文件的保存操作
 * @author wupan
 *
 */
public class SaveUploadFileUtil {

	/**
	 * 上传文件保存到临时目录
	 * 返回的map对象，主要包含这几个键：
	 * tempDirPath:文件存放的临时目录路径"webpage/tisdweb/upload/temp/20140327/",相对路径
	 * tempDirRealPath：c:/workspace/tisd_web/webpage/tisdweb/upload/temp/20140327/,绝对路径
	 * fileExtend:文件扩展名，如jpg,png
	 * fileName:文件在临时目录中存放时的名称，如dog.jpg
	 * fileFullName:文件全路径名，如c:/workspace/tisd_web/webpage/tisdweb/upload/temp/20140327/dog.jpg
	 * @param request
	 * @param mf
	 * @return
	 * @throws IOException
	 */
	public static UploadFileMode saveTempImg(HttpServletRequest request,
			MultipartFile mf) throws IOException {

//		Map<String, String> paramMap = new HashMap<String, String>();
		UploadFileMode uploadFileMode = new UploadFileMode();

		String tempDirPath = "upload/temp/";
		

		// 文件数据库保存路径
		String realPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ tempDirPath;

		File file = new File(realPath);
		if (!file.exists()) {
			file.mkdirs();// 创建根目录
		}
		
		//用日期分别存放临时文件，以便后期采用定时任务清理临时文件限定清理范围
		String dateDirName = DateUtil.getDataString(DateUtil.yyyyMMdd);
		tempDirPath = tempDirPath + dateDirName + "/";
		realPath += dateDirName + "/";
		file = new File(realPath);
		if (!file.exists()) {
			file.mkdir();// 创建文件时间子目录
		}
		
		uploadFileMode.setTempDirPath(tempDirPath);// 将存放临时文件的目录放入返回mode中
		uploadFileMode.setTempDirRealPath(realPath);
		
		
		// 设置文件上传路径
		String noextfilename = "";// 不带扩展名

		String fileName = mf.getOriginalFilename();// 获取文件名
		String extend = FileUtil.getExtend(fileName);// 获取文件扩展名
		uploadFileMode.setFileExtend(extend);
		
		// 重命名
		noextfilename = DateUtil.getDataString(DateUtil.yyyymmddhhmmss)
				+ StringUtil.random(8);// 自定义文件名称
		String myfilename = noextfilename + "." + extend;// 自定义文件名称

		String savePath = realPath + myfilename;// 文件保存全路径

		uploadFileMode.setFileName(myfilename);
		uploadFileMode.setFileFullName(savePath);

		File savefile = new File(savePath);

		// 文件拷贝到指定硬盘目录
		FileCopyUtils.copy(mf.getBytes(), savefile);

		return uploadFileMode;
	}
	
	/**
	 * 将saveResultMap
	 * @param saveResultMap
	 * @param request
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static UploadFileMode save2RemoteTempDir(UploadFileMode uploadFileMode) 
			throws ClientProtocolException, IOException{
		String domain = ResourceUtil.getConfigByName("file_server_domain");
		String uploadImgUri = ResourceUtil.getConfigByName("file_server_upload_img_uri");
		String uploadImgUrl = domain+uploadImgUri;
		
		
		// 做文件上传处理
		List<MultipartNameValuePair> mnvps = new ArrayList<MultipartNameValuePair>();
		String fileFullName = uploadFileMode.getFileFullName();
		if(!StringUtil.isEmpty(fileFullName)){
			File file = new File(fileFullName);
			mnvps.add(new MultipartNameValuePair("upfile", file));
		
		}
		
		String result =  HttpClientUtil.sendPost2(uploadImgUrl, mnvps);
		if(!StringUtil.isEmpty(result)){
			JSONObject jsonObj = JSONObject.parseObject(result);
			if("SUCCESS".equals(jsonObj.getString("state"))){
				String tempUrl = jsonObj.getString("url");
				uploadFileMode.setTempUrl(domain + "/" + tempUrl);
			}
		}
		return uploadFileMode;
	}
}
