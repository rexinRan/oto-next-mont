package com.buss.common.util;

import java.util.Random;
import java.util.UUID;

/**
 * 各种id生成策略
 */
public class IDUtils {


	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		Random random = new Random();
		int end3 = random.nextInt(999);
		// 如果不足三位前面补0
		String str = millis + String.format("%03d", end3);

		return str;
	}

	/**
	 * 文章id生成
	 */
	public static long getArticleId() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		// 加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		// 如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}

	public static String getRandomNumberByNum(int num) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			long randomNum = Math.round(Math.floor(Math.random() * 10.0D));
			sb.append(randomNum);
		}
		return sb.toString();
	}

	/**
	 * 生成数字字符串类型的id
	 */
	public static String getNumStringId() {
		long id = getArticleId();
		return String.valueOf(id);
	}

	/**
	 * 生成UUID字符串ID
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
