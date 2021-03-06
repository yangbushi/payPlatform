<%@page import="java.util.Date"%>
<%
/* *
 *功能：手机网页支付接入页
 *版本：3.3
 *日期：2012-08-14
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

 *************************注意*****************
 *如果您在接口集成过程中遇到问题，可以按照下面的途径来解决
 *1、商户服务中心（https://b.alipay.com/support/helperApply.htm?action=consultationApply），提交申请集成协助，我们会有专业的技术工程师主动联系您协助解决
 *2、商户帮助中心（http://help.alipay.com/support/232511-16307/0-16307.htm?sh=Y&info_type=9）
 *3、支付宝论坛（http://club.alipay.com/read-htm-tid-8681712.html）
 *如果不想使用扩展功能请把扩展功能参数赋空值。
 **********************************************
 */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.net.URLDecoder"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.unionpay.acp.DemoBase"%>
<%@ page import="com.unionpay.acp.sdk.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
		<title>银联手机网页支付</title>
	</head>
	<%
	/**
	 * 参数初始化
	 * 在java main 方式运行时必须每次都执行加载
	 * 如果是在web应用开发里,这个方写在可使用监听的方式写入缓存,无须在这出现
	 */
	//SDKConfig.getConfig().loadPropertiesFromSrc();// 从classpath加载acp_sdk.properties文件

	/**
	 * 组装请求报文
	 */
	Map<String, String> data = new HashMap<String, String>();
	// 版本号
	data.put("version", "5.0.0");
	// 字符集编码 默认"UTF-8"
	data.put("encoding", "UTF-8");
	// 签名方法 01 RSA
	data.put("signMethod", "01");
	// 交易类型 01-消费
	data.put("txnType", "01");
	// 交易子类型 01:自助消费 02:订购 03:分期付款
	data.put("txnSubType", "01");
	// 业务类型
	data.put("bizType", "000201");
	// 渠道类型，07-PC，08-手机
	data.put("channelType", "08");
	// 前台通知地址 ，控件接入方式无作用
	data.put("frontUrl", "http://115.236.176.107:8088/hr-hos-pay/acpFrontUrl.do");
	// 后台通知地址
	data.put("backUrl", "http://115.236.176.107:8088/hr-hos-pay/acpBackUrl.do");
	// 接入类型，商户接入填0 0- 商户 ， 1： 收单， 2：平台商户
	data.put("accessType", "0");
	// 商户号码，请改成自己的商户号
	data.put("merId", "777290058117352");//6216261000000000018
	// 商户订单号，8-40位数字字母
	data.put("orderId", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
	// 订单发送时间，取系统时间
	data.put("txnTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
	// 交易金额，单位分
	data.put("txnAmt", "1");
	// 交易币种
	data.put("currencyCode", "156");
	// 请求方保留域，透传字段，查询、通知、对账文件中均会原样出现
	// data.put("reqReserved", "透传信息");
	// 订单描述，可不上送，上送时控件中会显示该信息
	// data.put("orderDesc", "订单描述");

	Map<String, String> submitFromData = DemoBase.signData(data);

	// 交易请求url 从配置文件读取
	String requestFrontUrl = "https://101.231.204.80:5000/gateway/api/frontTransReq.do";
	//String requestFrontUrl = SDKConfig.getConfig().loadPropertiesFromSrc();
	
	/**
	 * 创建表单
	 */
	String html = DemoBase.createHtml(requestFrontUrl, submitFromData);
	out.println(html);
	%>
	<body>
	</body>
</html>
