package com.buss.utils;

import com.buss.common.service.impl.FastDFSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 图片、视频的文件上传方法
 * 
 * @author 荆志宝
 */
@Service
public class FileService {

	@Value("#{settings['IMAGE_SERVER_URL']}")
	private String ImageServerURL;


	public Map uploadFile(MultipartFile uploadFile) {
		// 在此实现图片上传
		try {
			FastDFSClient client = new FastDFSClient("classpath:conf/client.conf");
			// 取图片的原始名称
			String filename = uploadFile.getOriginalFilename();
			// 取扩展名
			String ext = filename.substring(filename.lastIndexOf(".") + 1);
			String url = client.uploadFile(uploadFile.getBytes(), ext);
			// 拼接url
			url = ImageServerURL + url;


			// 保存到数据库中



//			FileEntity fileEntity = new FileEntity();
////			fileEntity.setId(UUID.randomUUID().toString().replace("-",""));
////			fileEntity.setOutId();
//			fileEntity.setDownloadUrl(url);
//			fileEntity.setName(filename);
//			Date date = new Date();
//			fileEntity.setCreatetime(date);
//			fileEntity.setUpdatetime(date);
//			fileEntity.setIsDetail(0);
//			this.saveOrUpdate(fileEntity);
//			fileEntity = (FileEntity) this.findByExample(FileEntity.class.getName(), fileEntity).get(0);
			// 返回Map数据
			Map<String,String> result = new HashMap<String,String>();
			result.put("error", "0");
			result.put("url", url);
//			result.put("fid",fileEntity.getId());



			return result;

		} catch (Exception e) {
			e.printStackTrace();
			// 返回Map数据
			Map result = new HashMap();
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
			FastDFSClient client = new FastDFSClient("classpath:conf/client.conf");
			// 取图片的原始名称
			String filename = uploadFile.getOriginalFilename();
			// 取扩展名
			String ext = filename.substring(filename.lastIndexOf(".") + 1);
			String url = client.uploadFile(uploadFile.getBytes(), ext);
			result.put("uri", url);
			// 拼接url

			url = ImageServerURL + url;


			result.put("error", "0");
			result.put("url", url);
			result.put("filename", filename);
			result.put("fileType", ext);
			result.put("size", uploadFile.getSize());
			result.put("state","0");

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
}
