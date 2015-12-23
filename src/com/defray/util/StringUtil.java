package com.defray.util;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public final class StringUtil {
	private static final Logger LOG = LogManager.getLogger(StringUtil.class);
	private static long sequenceId = System.currentTimeMillis();
	private static String addrIp;

	private static char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
			'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
			'Y', 'Z', '!', '@', '#', '$', '%', '^', '&', '*', '~', '|' }; // 72个字符集

	/**
	 * 获得随机密码数组
	 * 
	 * @param type
	 *            随机密码类型 type=1, 数字; type=2, 非数字; type=3, 所有字符, type=4 数字和英文小写字母
	 * @param passLength
	 *            随机密码长度
	 * @param count
	 *            随机密码个数
	 * @return 随机密码数组
	 */
	public static String[] getRandomPasswords(int type, int passLength,
			int count) {
		String[] passwords = new String[count];// 新建一个长度为指定需要密码个数的字符串数组
		Random random = new Random();
		if (type == 1) {
			for (int i = 0; i < count; i++) {// 外循环 从0开始为密码数组赋值 也就是开始一个一个的生成密码
				StringBuilder password = new StringBuilder("");// 保存生成密码的变量
				for (int m = 1; m <= passLength; m++) {// 内循环 从1开始到密码长度 正式开始生成密码
					password.append(chars[random.nextInt(10)]);// 为密码变量随机增加上面字符中的一个
				}
				passwords[i] = password.toString();// 将生成出来的密码赋值给密码数组
			}
		} else if (type == 2) {
			for (int i = 0; i < count; i++) {// 外循环 从0开始为密码数组赋值 也就是开始一个一个的生成密码
				StringBuilder password = new StringBuilder("");// 保存生成密码的变量
				for (int m = 1; m <= passLength; m++) {// 内循环 从1开始到密码长度 正式开始生成密码
					password.append(chars[random.nextInt(53) + 10]);// 为密码变量随机增加上面字符中的一个
				}
				passwords[i] = password.toString();// 将生成出来的密码赋值给密码数组
			}
		} else if (type == 3) {
			for (int i = 0; i < count; i++) {// 外循环 从0开始为密码数组赋值 也就是开始一个一个的生成密码
				StringBuilder password = new StringBuilder("");// 保存生成密码的变量
				for (int m = 1; m <= passLength; m++) {// 内循环 从1开始到密码长度 正式开始生成密码
					password.append(chars[random.nextInt(72)]);// 为密码变量随机增加上面字符中的一个
				}
				passwords[i] = password.toString();// 将生成出来的密码赋值给密码数组
			}
		} else if (type == 4) {
			for (int i = 0; i < count; i++) {// 外循环 从0开始为密码数组赋值 也就是开始一个一个的生成密码
				StringBuilder password = new StringBuilder("");// 保存生成密码的变量
				for (int m = 1; m <= passLength; m++) {// 内循环 从1开始到密码长度 正式开始生成密码
					password.append(chars[random.nextInt(36)]);// 为密码变量随机增加上面字符中的一个
				}
				passwords[i] = password.toString();// 将生成出来的密码赋值给密码数组
			}
		} else {
			LOG.error("type参数输入错误!");
			System.out.println("type参数输入错误!");
		}

		return passwords;
	}

	/**
	 * 获得单个随机密码
	 * 
	 * @param type
	 *            随机密码类型 type=1, 数字; type=2, 非数字; type=3, 所有字符; type=4,
	 *            数字和英文小写字母
	 * @param passLength
	 *            随机密码长度
	 * @return 随机密码
	 * 
	 */
	public static String getRandomPassword(int type, int passLength) {
		return getRandomPasswords(type, passLength, 1)[0];
	}

	/**
	 * 获得单个随机密码
	 * 
	 * @param type = 3
	 *            随机密码类型 type=1, 数字; type=2, 非数字; type=3, 所有字符; type=4,
	 *            数字和英文小写字母
	 * @param passLength
	 *            随机密码长度
	 * @return 随机密码
	 */
	public static String getRandomPassword(int passLength) {
		return getRandomPassword(3, passLength);
	}

	public static synchronized String getNextId() {
		sequenceId++;
		if (addrIp == null) {
			try {
				InetAddress addr = InetAddress.getLocalHost();
				addrIp = addr.getHostAddress().toString().replace(".", "");

			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				addrIp = ((Double) Math.random()).toString().substring(2, 14);
			}
		}
//		System.out.println("sequenceId=" + addrIp + sequenceId);
		return "ID" + addrIp + sequenceId;
	}

	/* 将list转为以split分割的字符串，首尾都包含分割符，比如：|a|b|c|d| */
	public static <T> String listToString(List<T> list, String split) {
		StringBuffer buf = new StringBuffer();
		buf.append(split);
		for (T t : list) {
			buf.append(t.toString());
			buf.append(split);
		}
		return buf.toString();
	}

	public static String getUtf8(String str) {
		return getUtf8(str, "ISO-8859-1");
	}

	public static String getUtf8(String str, String encoding) {
		if (isEmpty(str)) {
			return null;
		}
		try {
			return new String(str.getBytes(encoding), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param str
	 * @param len
	 * @return 取str的最多len位，若str的长度小于len，返回全部
	 */
	public static String getSummary(String str, Integer len) {
		if (str == null || str.length() <= len) {
			return str;
		}

		return str.substring(0, len - 3) + "...";

	}

	/* 将array转为以split分割的字符串，首尾都包含分割符，比如：|a|b|c|d| */
	public static <T> String arrayToString(T[] array, String split) {
		StringBuffer buf = new StringBuffer();
		buf.append(split);
		for (T t : array) {
			buf.append(t.toString());
			buf.append(split);
		}
		return buf.toString();
	}

	/* 将字符串转为Integer，作空指针和首尾空检查,如果异常，返回缺省值defaultValue */
	public static Integer StringToInteger(String str, Integer defaultValue) {
		if (StringUtil.isEmpty(str))
			return defaultValue;

		try {
			return Integer.valueOf(str.trim());
		} catch (Exception e) {
			// e.printStackTrace();
			LOG.error("StringToInteger canot deal with arg:[" + str
					+ "] ,and will renturn defaultValue " + defaultValue);
			return defaultValue;
		}

	}

	public static Integer StringToInteger(String str) {
		return StringToInteger(str, 0);
	}

	public static boolean isEmpty(String value, boolean trim, char... trimChars) {
		if (trim)
			return value == null || trim(value, trimChars).length() <= 0;
		return value == null || value.length() <= 0;
	}

	public static boolean isEmpty(String value, boolean trim) {
		return isEmpty(value, trim, ' ');
	}

	public static boolean isEmpty(String value) {
		return isEmpty(value, false);
	}

	public static String nullSafeString(String value) {
		return value == null ? "" : value;
	}

	public static String trim(String value) {
		return trim(3, value, ' ');
	}

	public static String trim(String value, char... chars) {
		return trim(3, value, chars);
	}

	public static String trimStart(String value, char... chars) {
		return trim(1, value, chars);
	}

	public static String trimEnd(String value, char... chars) {
		return trim(2, value, chars);
	}

	private static String trim(int mode, String value, char... chars) {
		if (value == null || value.length() <= 0)
			return value;

		int startIndex = 0, endIndex = value.length(), index = 0;
		if (mode == 1 || mode == 3) {
			// trim头部
			while (index < endIndex) {
				if (contains(chars, value.charAt(index++))) {
					startIndex++;
					continue;
				}
				break;
			}
		}

		if (startIndex >= endIndex)
			return "";

		if (mode == 2 || mode == 3) {
			// trim尾部
			index = endIndex - 1;
			while (index >= 0) {
				if (contains(chars, value.charAt(index--))) {
					endIndex--;
					continue;
				}
				break;
			}
		}

		if (startIndex >= endIndex)
			return "";

		return value.substring(startIndex, endIndex);
	}

	private static boolean contains(char[] chars, char chr) {
		if (chars == null || chars.length <= 0)
			return false;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == chr)
				return true;
		}
		return false;
	}

	public static String URLDecode(String str) {
		if (str == null)
			return "";
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOG.error("URLDecode UnsupportedEncodingException" + str);
			return str;
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("URLDecode Exception" + str);
			return str;
		}
	}

	/**
	 * 判断输入的字符串是否为自然数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		
		if(str == null || "".equals(str)) {
			return false;
		}
		
		Pattern pattern = Pattern.compile("^0$|(^(\\+)?[1-9]([0-9]*))");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
	
	/**
	 * 判断输入的字符串是否为菜单选项(4位内数字)
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isMenuNum(String str) {
		
		if(str == null || "".equals(str)) {
			return false;
		}
		
		Pattern pattern = Pattern.compile("^0$|(^[1-9]([0-9]{0,3}))");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}
	
	public static String ifEmptyThenDefault(String str, String defaultStr) {
		if(isEmpty(str)) {
			return defaultStr;
		}
		return str;
	}
	/**
	 * 判断两个字符串是否相等
	 * @return
	 */
	public static boolean ifStringEqual(String str1,String str2){
		if(str1.equals(str2)){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 判断一个int是否为空
	 * @param i
	 * @return
	 */
	public static boolean ifIntNull(Integer i){
		if(i == null){
			return true;
		}else{
			return false;	
		}
	}

	/**
     * 字符串左边补充“0”
     *
     * @param str
     *            待补充的字符串
     * @param strLength
     *            最终长度
     * @param padChar
     *            补充的字符串
     * @return
     */
    public static String leftPad(String str, int strLength) {
        return leftPad(str, strLength, '0');
    }

    /**
     * 字符串左边补充
     *
     * @param str
     *            待补充的字符串
     * @param strLength
     *            最终长度
     * @param padChar
     *            补充的字符串
     * @return
     */
    public static String leftPad(String str, int strLength, char padChar) {
        int strLen = StringUtil.getGBLen(str);
        if (strLen < strLength) {
            while (strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                sb.append(padChar).append(str);
                str = sb.toString();
                strLen = StringUtil.getGBLen(str);
            }
        }
        return str;
    }

    /**
     * 字符串右边补充“0”
     *
     * @param str
     *            待补充的字符串
     * @param strLength
     *            最终长度
     * @param padChar
     *            补充的字符串
     * @return
     */
    public static String rightPad(String str, int strLength) {
        return rightPad(str, strLength, '0');
    }

    /**
     * 字符串右边补充
     *
     * @param str
     *            待补充的字符串
     * @param strLength
     *            最终长度
     * @param padChar
     *            补充的字符串
     * @return
     */
    public static String rightPad(String str, int strLength, char padChar) {
        int strLen = str.length();
        if (strLen < strLength) {
            while (strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                sb.append(str).append("0");
                str = sb.toString();
                strLen = str.length();
            }
        }
        return str;
    }

    /**
     * 返回gb2312编码的长度，即一个中文占2个字节。
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static int getGBLen(String str) {

        return getLen(str, "gb18030");

    }

    /**
     * 返回utf-8编码的长度，即一个中文占3个字节。
     *
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     */
    public static int getUTF8Len(String str) {

        return getLen(str, "utf-8");

    }

    /**
     * 获取字符串长度，null返回0
     *
     * @param str
     * @return
     */
    public static int getLen(String str, String charset) {
        if (str == null) {
            return 0;
        }

        try {
            return str.getBytes(charset).length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 获取字符串长度，null返回0
     *
     * @param str
     * @return
     */
    public static int getLen(String str) {
        return getLen(str, DefaultConfConst.CHARSET);
    }

    public static String bytesToHexString(byte[] src) {

        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString().toUpperCase();
    }

    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        }
        return d;
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /**
     * 将指定字符串src，以每两个字符分割转换为16进制形式 如："2B44EFD9" --> byte[]{0x2B, 0x44, 0xEF,
     * 0xD9} UTF-8编码
     *
     * @param src
     *            String
     * @return byte[]
     */
    public static byte[] HexString2Bytes(String src) {
        return HexString2Bytes(src,"utf-8");
    }

    /**
     * 将指定字符串src，以每两个字符分割转换为16进制形式 如："2B44EFD9" --> byte[]{0x2B, 0x44, 0xEF,
     * 0xD9}
     *
     * @param src
     *            String
     * @return byte[]
     */
    public static byte[] HexString2Bytes(String src, String charset) {
        int len = src.length() / 2;
        byte[] ret = new byte[len];
        byte[] tmp;
        try {
            tmp = src.getBytes(charset);
            for (int i = 0; i < len; i++) {
                ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * 将两个ASCII字符合成一个字节； 如："EF"--> 0xEF
     *
     * @param src0
     *            byte
     * @param src1
     *            byte
     * @return byte
     */
    public static byte uniteBytes(byte src0, byte src1) {
        byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 })).byteValue();
        _b0 = (byte) (_b0 << 4);
        byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 })).byteValue();
        byte ret = (byte) (_b0 ^ _b1);
        return ret;
    }

    /**
     * 生成随即密码带字符
     *
     * @param pwd_len
     *            生成的密码的总长度
     * @return 密码的字符串
     */
    public static String genRandomStr(int pwd_len) {
        // 35是因为数组是从0开始的，26个字母+10个数字
        final int maxNum = 36;
        int i; // 生成的随机数
        int count = 0; // 生成的密码的长度

        char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        //char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < pwd_len) {
            // 生成随机数，取绝对值，防止生成负数，

            i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }

        return pwd.toString();
    }

    /**
     * 获取字符串的内容 null 返回""
     * @param str
     * @return
     */
    public static String getStringText(String str){
        return str == null ? "" : str;
    }

    /**
     * 按字节截取字符串
     *
     * @param orignal
     *            原始字符串
     * @param count
     *            截取位数
     * @return 截取后的字符串
     * @throws UnsupportedEncodingException
     *             使用了JAVA不支持的编码格式
     */
    public static String substring(String orignal,int idx, int count){
        // 原始字符不为null，也不是空字符串
        if (orignal != null && !"".equals(orignal)) {
            // 将原始字符串转换为GBK编码格式
            //orignal = new String(orignal.getBytes(), "GBK");
            // 要截取的字节数大于0，且小于原始字符串的字节数
            int pos = 0;
            try {
                if (count > 0 && count <= orignal.getBytes("GBK").length) {
                    StringBuffer buff = new StringBuffer();
                    char c;
                    for (int i = 0; i < count ; i++) {
                        pos++;
                        c = orignal.charAt(i);
                        if(pos > idx){
                            buff.append(c);
                        }

                        if (isChineseChar(c)) {
                            // 遇到中文汉字，截取字节总数减1
                            --count;
                            pos++;
                        }
                    }
                    return buff.toString();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return orignal;
    }

    /**
     * 判断是否是一个中文汉字
     *
     * @param c
     *            字符
     * @return true表示是中文汉字，false表示是英文字母
     * @throws UnsupportedEncodingException
     *             使用了JAVA不支持的编码格式
     */
    public static boolean isChineseChar(char c)
            throws UnsupportedEncodingException {
        // 如果字节数大于1，是汉字
        // 以这种方式区别英文字母和中文汉字并不是十分严谨，但在这个题目中，这样判断已经足够了
        return String.valueOf(c).getBytes().length > 1;
    }
	
	public static void main(String[] args) {
		
	}
	
	
}