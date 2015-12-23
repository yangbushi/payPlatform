package com.alipay.config;


/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓getTotalFee
		// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088101568349711";
	
	//收款支付宝账号
	public static String seller_email = "alipay-test05@alipay.com";
	// 交易安全检验码，由数字和字母组成的32位字符串
	// 如果签名方式设置为“MD5”时，请设置该参数
	public static String key = "k5bmyuwbrz5svkn4wbzo6osvtyzm5x8k";
								
								
	 // 商户的私钥
    // 如果签名方式设置为“0001”时，请设置该参数
	//public static String private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALkCftxYKovteEu9N99K60x05AvhMVlCwp5zPw0xZUIrqZRT0pkBQbeyapvArKPlApAu2pL9C/PzejEjuIpTvdQASxKGGGLc2mbmrol5XZ55ELHjvtgH+PZJn7whVGW5vWapJJUgLE+FmICG7/W1JIbCW60lOx8AHHQmLVOmmcoDAgMBAAECgYAJoz2kkNs2itpXZ7X/ZdG4G+a9T6/YbIfi5TIFp+sUdV3SIkO4QL6BqUOwdWsI5qcph6dPPOtge/CDms7ENfSPfeNeJErnVpFl/gSngvEALKvdRH16nu25N+asdD25qdupb/bQ9KMEl0AKML/MArPlbixkIvsT265g7Vdnl4UKMQJBAPBHL3wjLGa7kSS14UmJhQCXc3todk5ySq7TOUidZ+7siEOsBvEmg1Llx4Q/w6e1nRlo82MLmxKFX0rR7/Ve158CQQDFHYeVDWK+DRiwOe30Gg1Y+hK9UJl7tlmZTqi4dSlQo+4r3PeBDwD3tl0rVM5vOJ0FCyXI196afRdHAtYzW4MdAkEAz0RIxOe+hHwmTymJxhqXnZQHrRvGehMDM13Hm0kU/7gQL3f0oQ8c12SZQA6VI1V5yBKNaRH42fgs5GjGer4udwJAc3WcmV5B3HjnYTJNg5JPBzNUDrhLbv+c9APzKDjYfnfHZsID6ADV3ENhx6PhV5ydvPqOo1pu9acYH2w189dCsQJBAM82cV9eZSA4EyqZ7OEQkQ42Tn0leLV3i7Q1s0jq1irsmtYaY4XAtxdd6TBQnVQmW4Upl035fkvFTx2ChgC5M/A=";
	public static String private_key = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBALJLXefbKH9gkpJpGWQLq161xDuYxYlXBsi1wNDN3T161hbNTOtqqoGvweBi3HqN2w9LBSUeG7bPiE0ITVIRNWy2Wz2tLvD2vCOcOoH9hzBXwqTLmEI6/co+kZx4i+4i0k2xQVehyiah3ChMWpLl+HEz6gTXWzwy0yNaUwJzKuqVAgMBAAECgYBob2UODn1mPzcbs5w/0eYLkATls9LhY6yBnJTYuf1BqdYFfTP1IYHGfSDfQolK8BTEnHjjCQPKzT1VgetoitPzYvdpVHs7mZ/y/xmVOwhauhMuf8V9Q7hsi8xiWkoE05dL1HOUjSJ62FfuK3yxQSc/p0tD+YwGKOk1JuxKLS77gQJBAOROaKeyVp7MP4aco3JQcoetzaVTNJungKyP92BBEATe2lfQkuKAFyFsfhk0b4UT9+L6fwVY02s4Db6Hk0hWDG0CQQDH6/CapkuerqPHAGeRtkNOFNYrZDPkmczPU3gu22YRmYGfR5Nd9WvAcAxXTRr9f4Dtob5JMX4dDNAXt5SpnC3JAkB9Sd468S6B9LqD59/2ctl3RdUN/ixnozOE/3iU9P+SfK279TU2YW7QI9bLhDATCtNFV4xvZcCYHWnFfmdAEiC9AkByazJ1EB/PXZwWVMDxwCKdGYfJpbudZfi138u05ZRxFi39fvV0nPViWb52aIa99q9PUXaaZV0MOz0Nld/bgqshAkANfCrULoQSME+XeosNcXMAl4VEuery4sm8enZyiH4DE4G6Q0ObIOr6lvhJlGqfGPoiZlsIHpoAeW1c0oQxWYzz";
	// 支付宝的公钥
    // 如果签名方式设置为“0001”时，请设置该参数(私钥公钥都是没有空格和换行的)
	//public static String ali_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC65t90Pk3Z+nNaWLTCvaReVF7W/4e3IuaI9OeAYZH6RG2GgcwJN6kYr+j4VD4VD5u5E3yU3W2rAoBLst/nDvI/edjw+u/SieGYXpqLIa9L7bIi5sB2QPikJ8Q1+7swNCXjCsIwji2/4/cvDjYAj+IpsXGPw83HOVYonoJSRl5P6QIDAQAB";
	public static String ali_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCC4o8U+apUy66ruZ8D1jesX9JZ/EQUYUFO2c0xi8OYInW7229D89nHhTUpfyUP/qxPsrDTHCmePoJpFInGS4d9t0W3r84xjCE90d1nwT01opn+5UBNyFboI1vsk4xO7nb/IokvSVtYHcY4z9mQqlHRflL3FqPVDWZ37er6JGw4XwIDAQAB";


	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "\\mnt\\logs\\hospay\\alipay_log\\";

	// 字符编码格式 目前支持  utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式，选择项：0001(RSA)、MD5
	public static String sign_type = "0001";
	// 无线的产品中，签名方式为rsa时，sign_type需赋值为0001而不是RSA
	
	public static String sign_type_md5 = "MD5";

}
