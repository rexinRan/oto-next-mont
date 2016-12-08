package com.buss.common.controller;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.oss.OSSException;
import com.aliyun.openservices.oss.model.OSSObjectSummary;
import com.aliyun.openservices.oss.model.ObjectListing;
import com.buss.common.model.json.ReplyFile;
import com.buss.common.oss.OSSManageUtil;
import com.buss.common.oss.vo.ObjectSummaryVo;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jweb.core.bean.ReplyDataMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import strman.Strman;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/oss")
public class OssController {

	static Logger logger = Logger.getLogger(OssController.class);

	/***
	 * 上传文件 用@RequestParam注解来指定表单上的file为MultipartFile
	 *
	 * @param mfile
	 * @return
	 */
	@RequestMapping("fileUpload")
	@ResponseBody
	public String fileUpload(
			@RequestParam(value="bucket", required=false) String bucket,
			@RequestParam("file") MultipartFile mfile)  {
		if (!mfile.isEmpty()) { // 判断上传的文件是否为空
			OSSManageUtil oss = new OSSManageUtil();
			if(bucket==null) bucket = oss.bucketName;
			String url = null;
			try {
				url = oss.uploadFile(bucket, "test", mfile);
			} catch (OSSException oe) {
				oe.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return url;
		}
		// 重定向
		return "redirect:/index.html";
	}

	/***
	 * 列出Bucket中的Object文件
	 *
	 * @return
	 */
	@RequestMapping("fileList")
	@ResponseBody
	public ReplyDataMode fileList(HttpServletResponse response,
			@RequestParam(value="bucket", required=false) String bucket,
			@RequestParam(value="callback", required=false) String callback) {
		ReplyDataMode j = new ReplyDataMode();

		List<ObjectSummaryVo> result = new ArrayList<ObjectSummaryVo>();
		ObjectSummaryVo vo = null;
		java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		OSSManageUtil oss = new OSSManageUtil();
		if(bucket==null) bucket = oss.bucketName;
//		logger.info("fileList -> "+"bucket:"+bucket);
		// 访问远程服务器 获取文件信息
		List<OSSObjectSummary> objectSummary = oss.getFileList(bucket);
		if(objectSummary!=null){
			for (OSSObjectSummary object : objectSummary) {
				vo = new ObjectSummaryVo();
				vo.setKey(object.getKey());
				vo.setSize(oss.convertFileSize(object.getSize()));
				vo.setLastModified(format1.format(object.getLastModified()));
				result.add(vo);
			}
		}
		j.setData(result);
		j.setSuccess(true);
		j.setStatusCode(oss.urlPrefix(bucket));

		execute(callback, response, j);
		return null;
	}

	/***
	 * 列出目录下的文件和子目录(解决跨域问题)
	 *
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public List<ReplyFile> list(@RequestParam("path")  String path,
								@RequestParam(value="bucket", required=false) String bucket,
								@RequestParam(value="callback", required=false) String callback,
								HttpServletResponse response) {
		String prefix = "";
		if(path != null && !"/".equals(path)) {
			prefix = Strman.last(path, path.length()-1);
		}
		OSSManageUtil oss = new OSSManageUtil();
		if(bucket==null) bucket = oss.bucketName;

//		logger.info("list -> "+"bucket:"+bucket+" | " +"prefix:"+prefix);
		// 访问远程服务器 获取文件信息
		ObjectListing listing = oss.getFileListDelimiter(bucket, prefix);

		// 以下都是解析文件信息，并返回JSON
		java.text.DateFormat format1 = new java.text.SimpleDateFormat("yy-MM-dd HH:mm:ss");
		List<ReplyFile> result = new ArrayList<>();
		ReplyFile vo = null;
		// 遍历所有Object
		for (OSSObjectSummary object : listing.getObjectSummaries()) {
			vo = new ReplyFile();
			vo.setPath("/"+object.getKey());
			if("".equals(prefix)) {
				vo.setName(object.getKey());
			}else{
				vo.setName(Strman.last(object.getKey(), object.getKey().length()-prefix.length()));
			}
			vo.setSize(object.getSize()+"");
			vo.setDate(format1.format(object.getLastModified()));
			if(!"".equals(vo.getName())) result.add(vo);
		}
		// 遍历所有CommonPrefix
		for (String commonPrefix : listing.getCommonPrefixes()) {
//			System.out.println(commonPrefix);
			vo = new ReplyFile();
			vo.setPath("/"+commonPrefix);
			if("".equals(prefix)) {
				vo.setName(commonPrefix);
			}else{
				vo.setName(Strman.last(commonPrefix, commonPrefix.length()-prefix.length()));
			}
			if(!"".equals(vo.getName())) result.add(vo);
		}
		execute(callback, response, result);
		return null;
	}

	/***
	 * 上传文件
	 *
	 * @return
	 */
	@RequestMapping(value= "upload")
	@ResponseBody
	public void upload(@RequestParam("path") String path,
					   @RequestParam(value="bucket", required=false) String bucket,
					   HttpServletRequest request, HttpServletResponse response) {
		String key = "";
		if(path != null && !"/".equals(path)) {
			key = Strman.last(path, path.length()-1);
			key = Strman.first(key, key.length()-1);
		}
		List<String> result = new ArrayList<>();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile mfile = entity.getValue();// 获取上传文件对象
			try {
				OSSManageUtil oss = new OSSManageUtil();
				if(bucket==null) bucket = oss.bucketName;
				// 上传文件到远程服务器
				String url = oss.uploadFile(bucket, key, mfile);
//				System.out.println("#### "+ url);
//				logger.info("upload -> "+"bucket:"+bucket+" | " +"url:"+url);
				result.add(url);
			} catch (OSSException oe) {
				oe.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 如果是单传，则只循环一次
			// break;
		}
		execute(null, response, result);
	}

	/**
	 * 创建目录
	 * @param path
	 * @param name
	 * @param bucket
	 * @param response
     */
	@RequestMapping(value= "create")
	@ResponseBody
	public void create(@RequestParam("path") String path,
					   @RequestParam("name") String name,
					   @RequestParam(value="bucket", required=false) String bucket,
					   HttpServletResponse response) {
		List<String> result = new ArrayList<>();
		String key = "";

		if(path != null && !"/".equals(path)) {
			key = Strman.last(path, path.length()-1);
			key = Strman.first(key, key.length()-1);
		}
//		logger.info("create -> "+"bucket:"+bucket+" | " +"path:"+path+" | " +"key:"+key+" | " +"fileName:"+name);
		try {
			OSSManageUtil oss = new OSSManageUtil();
			if(bucket==null) bucket = oss.bucketName;
			// 上传文件到远程服务器
			String url = oss.createFile(bucket, key, name);
//			logger.info("create -> "+"bucket:"+bucket+" | " +"url:"+url);
			result.add(url);
		} catch (OSSException oe) {
			oe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		execute(null, response, result);
	}

	/***
	 * 删除文件
	 *
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public void delete(@RequestParam("path") String path,
					   @RequestParam(value="bucket", required=false) String bucket,
					   @RequestParam(value="callback", required=false) String callback,
					   HttpServletRequest request, HttpServletResponse response) {
//		String path = request.getParameter("path"); // 获取前台传入内容
		String key = "";
		if(path != null && !"/".equals(path)) {
			key = Strman.last(path, path.length()-1);
		}
		OSSManageUtil oss = new OSSManageUtil();
		if(bucket==null) bucket = oss.bucketName;
//		logger.info("delete -> "+"bucket:"+bucket+" | " +"key:"+key);
		oss.deleteFile(bucket, key);
		List<String> result = new ArrayList<>();
		result.add("");
		execute(callback, response, result);
	}

	/***
	 * 获取地址
	 *
	 * @return
	 */
	@RequestMapping("generate_sign_url")
	@ResponseBody
	public void generate_sign_url(@RequestParam("path") String path, HttpServletResponse response) {
		List<String> result = new ArrayList<>();
		try {
			String str = URLEncoder.encode(path, "UTF-8");
			str = str.replace("%2F" ,"/");;
			result.add(str);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		execute(null, response, result);
	}

	/**
	 *
	 * 下载文件
	 * @throws Exception
	 */
	@RequestMapping("download")
	public void download(@RequestParam("path") String path,
						 @RequestParam("url") String url,
						 HttpServletResponse response) throws IOException {
		//获取文件名
        String[] urlname = path.split("/");
        int len = urlname.length - 1;
        String fileName = urlname[len];
		//获取文件下载地址
		String str = URLEncoder.encode(path, "UTF-8");
		str = str.replace("%2F" ,"/");
		String fileUrl = url + str;
//		logger.info("download -> "+"fileUrl:"+fileUrl+" | " +"fileName:"+fileName);

		String downPath = "";
		String osName = System.getProperty("os.name"); // 判断当前操作系统的类型
		if (osName.toLowerCase().contains("windows")) {
			// 如果当前是windows系统
			downPath = "E:/upload/";  //本地版
		} else {
			downPath = "/opt/down/";  //服务器版
		}
		new OSSManageUtil().downUrl(downPath, fileUrl, fileName);

		String localpath = downPath + fileName;
//		System.out.println("生成文件路径：" + localpath);

		OutputStream os = response.getOutputStream();
		try {
			File file = new File(localpath);
			response.reset();
			response.setHeader("Content-disposition","attachment; filename="
					+new String(fileName.getBytes("GB2312"),"ISO-8859-1"));
			response.setContentType("application/octet-stream; charset=utf-8");
			os.write(FileUtils.readFileToByteArray(file));
			os.flush();
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}


	/**
	 * 处理jsonp跨域问题
	 * 支持GET,和简单POST请求
     */
	public void execute(String callback, HttpServletResponse response, Object result) {
		PrintWriter out = null;
		try {
			out = response.getWriter();
			Object json = JSON.toJSON(result);
			if(callback!=null)
				out.print(callback + "(" + json + ")");
			else out.write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			out.close();
		}
	}

}
