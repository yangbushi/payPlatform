<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />
<title>支付台</title>
<link rel="stylesheet" type="text/css" href="css/master.css" />


<script type="text/javascript" src="js/jquery-1.11.0.js"></script>
<script type="text/javascript">
	(function() {
		$.MsgBox = {
			Alert : function(title, msg) {
				GenerateHtml("alert", title, msg);
				btnOk(); //alert只是弹出消息，因此没必要用到回调函数callback
				btnNo();
			},
			Confirm : function(title, msg, callback) {
				GenerateHtml("confirm", title, msg);
				btnOk(callback);
				btnNo();
			}
		}

		//生成Html
		var GenerateHtml = function(type, title, msg) {

			var _html = "";

			_html += '<div id="mb_box"></div><div id="mb_con"><span id="mb_tit">'
					+ title + '</span>';
			_html += '<a id="mb_ico">x</a><div id="mb_msg">' + msg
					+ '</div><div id="mb_btnbox">';

			if (type == "alert") {
				_html += '<input id="mb_btn_ok" type="button" value="确定" />';
			}
			if (type == "confirm") {
				_html += '<input id="mb_btn_ok" type="button" value="确定" />';
				_html += '<input id="mb_btn_no" type="button" value="取消" />';
			}
			_html += '</div></div>';

			//必须先将_html添加到body，再设置Css样式
			$("body").append(_html);
			GenerateCss();
		}

		//生成Css
		var GenerateCss = function() {

			$("#mb_box").css({
				width : '100%',
				height : '100%',
				zIndex : '99999',
				position : 'fixed',
				bottom : '0',
				right : '0',
				filter : 'Alpha(opacity=60)',
				backgroundColor : 'black',
				top : '0',
				left : '0',
				opacity : '0.6'
			});

			$("#mb_con").css({
				zIndex : '999999',
				width : '260px',
				position : 'fixed',
				backgroundColor : 'White',
				borderRadius : '15px'
			});

			$("#mb_tit").css({
				display : 'block',
				fontSize : '14px',
				color : '#444',
				padding : '10px 15px',
				backgroundColor : '#DDD',
				borderRadius : '15px 15px 0 0',
				borderBottom : '3px solid #009BFE',
				fontWeight : 'bold'
			});

			$("#mb_msg").css({
				padding : '20px',
				lineHeight : '20px',
				borderBottom : '1px dashed #DDD',
				fontSize : '18px',
				fontWeight : 'bold'
			});

			$("#mb_ico").css({
				display : 'block',
				position : 'absolute',
				right : '10px',
				top : '9px',
				border : '1px solid Gray',
				width : '18px',
				height : '18px',
				textAlign : 'center',
				lineHeight : '16px',
				cursor : 'pointer',
				borderRadius : '12px',
				fontFamily : '微软雅黑'
			});

			$("#mb_btnbox").css({
				margin : '15px 0 10px 0',
				textAlign : 'center'
			});
			$("#mb_btn_ok,#mb_btn_no").css({
				width : '85px',
				height : '30px',
				color : 'white',
				border : 'none'
			});
			$("#mb_btn_ok").css({
				backgroundColor : '#168bbb'
			});
			$("#mb_btn_no").css({
				backgroundColor : 'gray',
				marginLeft : '20px'
			});

			//右上角关闭按钮hover样式
			$("#mb_ico").hover(function() {
				$(this).css({
					backgroundColor : 'Red',
					color : 'White'
				});
			}, function() {
				$(this).css({
					backgroundColor : '#DDD',
					color : 'black'
				});
			});

			var _widht = document.documentElement.clientWidth; //屏幕宽
			var _height = document.documentElement.clientHeight; //屏幕高

			var boxWidth = $("#mb_con").width();
			var boxHeight = $("#mb_con").height();

			//让提示框居中
			$("#mb_con").css({
				top : (_height - boxHeight) / 2 + "px",
				left : (_widht - boxWidth) / 2 + "px"
			});
		}

		//确定按钮事件
		var btnOk = function(callback) {
			$("#mb_btn_ok").click(function() {
				$("#mb_box,#mb_con").remove();
				if (typeof (callback) == 'function') {
					callback();
				}
			});
		}

		//取消按钮事件
		var btnNo = function() {
			$("#mb_btn_no,#mb_ico").click(function() {
				$("#mb_box,#mb_con").remove();
			});
		}
	})();
</script>
<script type="text/javascript">
	function goDefray() {

		if ($("input[name='payType']:checked").val()) {
			var payType = $("input[name='payType']:checked").val();
			if ("10" == payType) {
				document.alipayform.submit();
			}else if("3" == payType){
				document.chinaBankform.submit();
			}else if("11" == payType){
				document.unionpayform.submit();
			}else if("4" == payType){
				document.chinaConstructionBankform.submit();
			}else{
				$.MsgBox.Alert("温馨提示", "请选择支付方式！");
			}
		} else {
			//alert("请选择支付方式！");
			$.MsgBox.Alert("温馨提示", "请选择支付方式！");
		}

	}
	$(document).ready(function() {
		$("ul li").click(function() {
			var jqRadio = $(this).find("input[name='payType']");
			var flag = jqRadio.is(":checked");
			if (!flag) {
				jqRadio.prop("checked", true);
			}
		});
	});
</script>
</HEAD>
<BODY>
	<div class="div_wrap">
		<div class="div_title">请选择支付方式</div>
		<div class="div_payment">
			<div>
				<ul class="list">
				<!-- 支付宝 -->
				<s:if test="defrayTypes.contains(',10,')" >
				  <li><span class="left"><img src="images/logo_zfb.png"
							width="50" height="31" /></span> <span class="div_zfb"> <span
							class="div_paymentname"> 支付宝WAP支付 </span><br /> <span
							class="div_prompt">支持支付宝余额、卡通</span>
					</span> <span class="right"> <input type="radio" value="10"
							name="payType" /></span></li>
				</s:if>
				<s:else>
				  <li style="display: none"><span class="left"><img src="images/logo_zfb.png"
							width="50" height="31" /></span> <span class="div_zfb"> <span
							class="div_paymentname"> 支付宝WAP支付 </span><br /> <span
							class="div_prompt">支持支付宝余额、卡通</span>
					</span> <span class="right"> <input type="radio" value="10"
							name="payType" /></span></li>
				</s:else>					
				<!-- 中国银行-->	
				<s:if test="defrayTypes.contains(',3,')" >
				  <li><span class="left"><img
							src="images/logo_zgyh.png" width="68" height="31" /></span> <span><span
							class="div_paymentname">中国银行手机支付</span></span> <span class="right"><input
							type="radio" value="3" name="payType" /></span></li>
				</s:if>
				<s:else>
				  <li style="display: none"><span class="left"><img
							src="images/logo_zgyh.png" width="68" height="31" /></span> <span><span
							class="div_paymentname">中国银行手机支付</span></span> <span class="right"><input
							type="radio" value="3" name="payType" /></span></li>
				</s:else>
				<!-- 银联支付-->	
				<s:if test="defrayTypes.contains(',11,')" >
				  <li><span class="left"><img
							src="images/logo_yl.png" width="68" height="31" /></span> <span><span
							class="div_paymentname">银联支付</span></span> <span class="right"><input
							type="radio" value="11" name="payType" /></span></li>
				</s:if>
				<s:else>
				  <li style="display: none"><span class="left"><img
							src="images/logo_yl.png" width="68" height="31" /></span> <span><span
							class="div_paymentname">银联支付</span></span> <span class="right"><input
							type="radio" value="11" name="payType" /></span></li>
				</s:else>		
				<!-- 建行支付-->	
				<s:if test="defrayTypes.contains(',4,')" >
				  <li><span class="left"><img
							src="" width="68" height="31" /></span> <span><span
							class="div_paymentname">建行支付</span></span> <span class="right"><input
							type="radio" value="4" name="payType" /></span></li>
				</s:if>
				<s:else>
				  <li style="display: none"><span class="left"><img
							src="" width="68" height="31" /></span> <span><span
							class="div_paymentname">建行支付</span></span> <span class="right"><input
							type="radio" value="4" name="payType" /></span></li>
				</s:else>			
				</ul>
			</div>
		</div>
	</div>
	<div class="div_button">
		<button class="btn_save" onclick="goDefray()">立即支付</button>
	</div>


	<form name="alipayform" action="jsp/alipay.jsp" method="post" >                       					
		<!--商户订单号-->
		<input size="30" type="hidden" name="WIDout_trade_no" VALUE="<s:property value="#request.accountAlipayEntity.outTradeNo"/>"/>						
		<!--订单名称-->
		<input size="30" type="hidden" name="WIDsubject" VALUE="<s:property value="#request.accountAlipayEntity.subject"/>" />					
        <!--付款金额-->
        <input size="30" type="hidden" name="WIDtotal_fee"  VALUE="<s:property value="#request.accountAlipayEntity.totalFee"/>" />
        <!---->
        <input size="30" type="hidden" name="WIDpay_expire"  VALUE="<s:property value="#request.accountAlipayEntity.payExpire"/>" />
        <!---->
        <input size="30" type="hidden" name="WIDseller_email"  VALUE="<s:property value="#request.accountAlipayEntity.sellerEmail"/>" />
        <!---->
        <input size="30" type="hidden" name="WIDpartner"  VALUE="<s:property value="#request.accountAlipayEntity.partner"/>" />
        <!---->
        <input size="30" type="hidden" name="WIDsign_type"  VALUE="<s:property value="#request.accountAlipayEntity.signType"/>" />                                              
	</form>
	<form name="unionpayform" action="jsp/unionpay.jsp" method="post" >                       					
		                                              
	</form>
	<!-- https://ebspay.boc.cn/ http://180.168.146.79/PGWPortal/B2CMobileRecvOrder.do-->
	<FORM name="chinaBankform" METHOD="POST" ACTION="https://ebspay.boc.cn/PGWPortal/B2CMobileRecvOrder.do">
		<!--01.商户号-->
		<INPUT TYPE="HIDDEN" SIZE="20" ID="merchantNo" NAME="merchantNo" VALUE="<s:property value="#request.accountCbpayEntity.merchantNo"/>"><BR/>
		<!--02.支付类型-->
		<INPUT TYPE="HIDDEN" SIZE="10" ID="payType" NAME="payType" VALUE="<s:property value="#request.accountCbpayEntity.payType"/>"><BR/>
		<!--03.商户订单号-->
		<INPUT TYPE="HIDDEN" SIZE="19" ID="orderNo" NAME="orderNo" VALUE="<s:property value="#request.accountCbpayEntity.orderNo"/>"><BR/>
		<!--04.订单币种-->
		<INPUT TYPE="HIDDEN" SIZE="3" ID="curCode" NAME="curCode" VALUE="<s:property value="#request.accountCbpayEntity.curCode"/>"><BR/>
		<!--05.订单金额-->
		<INPUT TYPE="HIDDEN" SIZE="13" ID="orderAmount" NAME="orderAmount" VALUE="<s:property value="#request.accountCbpayEntity.orderAmount"/>"><BR/>
		<!--06.订单时间-->
		<INPUT TYPE="HIDDEN" SIZE="14" ID="orderTime" NAME="orderTime" VALUE="<s:property value="#request.accountCbpayEntity.orderTime"/>"><BR/>
		<!--07.订单说明-->
		<INPUT TYPE="HIDDEN" SIZE="30" ID="orderNote" NAME="orderNote" VALUE="<s:property value="#request.accountCbpayEntity.orderNote"/>"><BR/>
		<!--08.商户接收通知URL-->
		<INPUT TYPE="HIDDEN" SIZE="100" ID="orderUrl" NAME="orderUrl" VALUE="<s:property value="#request.accountCbpayEntity.orderUrl"/>"><BR/>
		
		<INPUT TYPE="HIDDEN" SIZE="54" ID="spMobile" NAME="spMobile" VALUE="<s:property value="#request.accountCbpayEntity.spMobile"/>"><BR/>  
		
		<!--09.超时时间 -->
		<INPUT TYPE="HIDDEN" SIZE="14" ID="orderTimeoutDate" NAME="orderTimeoutDate" VALUE="<s:property value="#request.accountCbpayEntity.orderTimeOut"/>"><BR/>
		<!--10.商户签名数据-->
		<INPUT TYPE="HIDDEN" ID="signData" NAME="signData" VALUE="<s:property value="#request.accountCbpayEntity.signData"/>"><BR/>
	</FORM>
	
	<FORM name="chinaConstructionBankform" METHOD="POST" ACTION="https://ibsbjstar.ccb.com.cn/app/ccbMain.do">
	
		<INPUT TYPE="HIDDEN" SIZE="15" ID="MERCHANTID" NAME="MERCHANTID" VALUE="<s:property value="#request.chinaConstructionInfoBean.merchantid"/>"><BR/>

		<INPUT TYPE="HIDDEN" SIZE="9" ID="POSID" NAME="POSID" VALUE="<s:property value="#request.chinaConstructionInfoBean.posid"/>"><BR/>

		<INPUT TYPE="HIDDEN" SIZE="9" ID="BRANCHID" NAME="BRANCHID" VALUE="<s:property value="#request.chinaConstructionInfoBean.branchid"/>"><BR/>

		<INPUT TYPE="HIDDEN" SIZE="30" ID="ORDERID" NAME="ORDERID" VALUE="<s:property value="#request.chinaConstructionInfoBean.orderid"/>"><BR/>

		<INPUT TYPE="HIDDEN" SIZE="16" ID="PAYMENT" NAME="PAYMENT" VALUE="<s:property value="#request.chinaConstructionInfoBean.payment"/>"><BR/>

		<INPUT TYPE="HIDDEN" SIZE="2" ID="CURCODE" NAME="CURCODE" VALUE="<s:property value="#request.chinaConstructionInfoBean.curcode"/>"><BR/>

		<INPUT TYPE="HIDDEN" SIZE="30" ID="REMARK1" NAME="REMARK1" VALUE="<s:property value="#request.chinaConstructionInfoBean.remark1"/>"><BR/>

		<INPUT TYPE="HIDDEN" SIZE="30" ID="REMARK2" NAME="REMARK2" VALUE="<s:property value="#request.chinaConstructionInfoBean.remark2"/>"><BR/>
		
		<INPUT TYPE="HIDDEN" SIZE="6" ID="TXCODE" NAME="TXCODE" VALUE="<s:property value="#request.chinaConstructionInfoBean.txcode"/>"><BR/>  
		
		<INPUT TYPE="HIDDEN" SIZE="32" ID="MAC" NAME="MAC" VALUE="<s:property value="#request.chinaConstructionInfoBean.mac"/>"><BR/>

	</FORM>

</BODY>
</html>
