package com.buss.common.service.impl;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.file.entity.FileEntity;
import org.apache.commons.io.FileUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.hibernate.Transaction;
import org.jweb.core.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 图片、视频的文件上传方法
 * 
 * @author 荆志宝
 */
@Service
public class FileService extends CommonServiceImpl {

	@Value("${IMAGE_SERVER_URL}")
	private String ImageServerURL;

	@Value("${WIN_REAL_PATH}")
	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Map uploadFile(MultipartFile uploadFile) {
		// 在此实现图片上传
		try {
			FastDFSClient client = new FastDFSClient("classpath:client.conf");
			// 取图片的原始名称
			String filename = uploadFile.getOriginalFilename();
			// 取扩展名
			String ext = filename.substring(filename.lastIndexOf(".") + 1);
			String url = client.uploadFile(uploadFile.getBytes(), ext);
			// 拼接url
			url = ImageServerURL + url;


			// 保存到数据库中



			FileEntity fileEntity = new FileEntity();
//			fileEntity.setId(UUID.randomUUID().toString().replace("-",""));
//			fileEntity.setOutId();
			fileEntity.setDownloadUrl(url);
			fileEntity.setName(filename);
			Date date = new Date();
			fileEntity.setCreatetime(date);
			fileEntity.setUpdatetime(date);
			fileEntity.setIsDetail(0);
			this.saveOrUpdate(fileEntity);
			fileEntity = (FileEntity) this.findByExample(FileEntity.class.getName(), fileEntity).get(0);
			// 返回Map数据
			Map<String,String> result = new HashMap<String,String>();
			result.put("error", "0");
			result.put("url", url);
			result.put("fid",fileEntity.getId());



			return result;

		} catch (Exception e) {
			e.printStackTrace();
			// 返回Map数据
			Map result = new HashMap<>();
			result.put("error", 1);
			result.put("message", "上传失败");

			return result;
		}
	}

	/**
	 * 重写方法
	 * @param uploadFile
	 * @return map
	 *
	 *  王腾云
     */
	public Map upload(MultipartFile uploadFile) {
		// 返回Map数据
		Map<String,Object> result = new HashMap<String, Object>();

		// 在此实现图片上传
		try {
			FastDFSClient client = new FastDFSClient("classpath:client.conf");
			// 取图片的原始名称
			String filename = uploadFile.getOriginalFilename();
			// 取扩展名
			String ext = filename.substring(filename.lastIndexOf(".") + 1);
			String url = client.uploadFile(uploadFile.getBytes(), ext);
			// 拼接url
			url = ImageServerURL + url;


			result.put("error", "0");
			result.put("url", url);
			result.put("filename", filename);

			return result;

		} catch (Exception e) {
			e.printStackTrace();
			// 返回Map数据
			result.clear();
			result.put("error", 1);
			result.put("message", "上传失败");

			return result;
		}
	}
	/**
	 * 文件下载
	 * 卢跃跃
	 */
	public void download(HttpServletResponse res, String fileName,String fileURL) throws IOException {

		String tempPath = path + "/" + fileName;
		File file = new File(tempPath);

		try {

			URL url = new URL(fileURL);
			FileUtils.copyURLToFile(url, file);

//			res.reset();
//			res.setHeader("Content-Disposition", "attachment; filename=" + fileName);
//			res.setContentType("application/octet-stream; charset=utf-8");
//			os.write(FileUtils.readFileToByteArray(file));
//			os.flush();

			if (file.exists()) {
				InputStream ins = new FileInputStream(tempPath);
				BufferedInputStream bins = new BufferedInputStream(ins);// 放到缓冲流里面
				OutputStream outs = res.getOutputStream();// 获取文件输出IO流
				BufferedOutputStream bouts = new BufferedOutputStream(outs);
				res.setContentType("application/x-download");// 设置response内容的类型
				res.setHeader(
						"Content-disposition",
						"attachment;filename="
								+ URLEncoder.encode(fileName, "UTF-8"));// 设置头部信息
				int bytesRead = 0;
				byte[] buffer = new byte[8192];
				// 开始向网络传输文件流
				while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
					bouts.write(buffer, 0, bytesRead);
				}
				bouts.flush();// 这里一定要调用flush()方法
				ins.close();
				bins.close();
				outs.close();
				bouts.close();
			}
		}finally {

			if (file!=null && file.exists()) {
				file.delete();
			}

		}
	}
}
