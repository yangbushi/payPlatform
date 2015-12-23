package com.defray.bean;

public class ChinaConstructionInfoBean implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2115679141089722699L;
	//	MERCHANTID	商户代码	CHAR(15)	由建行统一分配
	private String merchantid;
	//	POSID	商户柜台代码	CHAR(9)	由建行统一分配，缺省为000000000
	private String posid;
	//	BRANCHID	分行代码	CHAR(9)	由建行统一指定
	private String branchid;
	//	ORDERID	定单号	CHAR(30)	由商户提供，最长30位,按实际长度给出
	private String orderid;
	//	PAYMENT	付款金额	NUMBER(16,2)	由商户提供，按实际金额给出
	private String payment;
	//	CURCODE	币种	CHAR(2)	缺省为01－人民币
	//	（只支持人民币支付）
	private String curcode;
	//	REMARK1	备注1	CHAR(30)	网银不处理，直接传到城综网
	private String remark1;
	//	REMARK2	备注2	CHAR(30)	网银不处理，直接传到城综网
	private String remark2;
	//	PUB32	密钥	CHAR(30)	复用商户公钥前30位，只在MD5摘要时使用，不作为参数传递。
	//	TXCODE	交易码	CHAR(6)	由建行统一分配为520100
	private String txcode;
	//	MAC	MAC校验域	CHAR(32)	采用标准MD5算法，由商户实现
	private String mac;
	
	
	public String getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(String merchantid) {
		this.merchantid = merchantid;
	}
	public String getPosid() {
		return posid;
	}
	public void setPosid(String posid) {
		this.posid = posid;
	}
	public String getBranchid() {
		return branchid;
	}
	public void setBranchid(String branchid) {
		this.branchid = branchid;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getCurcode() {
		return curcode;
	}
	public void setCurcode(String curcode) {
		this.curcode = curcode;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public String getTxcode() {
		return txcode;
	}
	public void setTxcode(String txcode) {
		this.txcode = txcode;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}	
	
}
