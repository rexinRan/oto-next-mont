package com.buss.common.model.json;

import java.io.Serializable;

/***
 */
public class ReplyFile implements Serializable {

	/** 文件路径 */
	private String path;
	/** 文件名 */
	private String name;
	/** 大小 */
	private String size;
	/** 上传时间 */
	private String date;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}