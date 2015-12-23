package com.defray.util;

import java.util.UUID;

public class RandomUtil {
	
	/**
	 * 生成唯一数
	 * @return
	 */
	public static String getUUID() {
		  UUID uuid = UUID.randomUUID();
		  String str = uuid.toString();
		  // 去掉"-"符号
		  String unique = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);
		  return unique;
	}

}
