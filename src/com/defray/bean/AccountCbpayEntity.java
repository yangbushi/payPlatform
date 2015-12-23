package com.defray.bean;


import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;

 
public class AccountCbpayEntity implements Serializable{

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -1L;

	//========== properties ==========
	
	//平台ID
	private Integer id;
	//医院ID
	private String hospitalId;
	//在支付平台支付方式
	private String defrayType;
	//根证书
	private String rootCertificate;
	//密钥(证书)
	private String keyStore;
	//密钥(证书)密码
	private String keyPassword;
	//密钥(证书)安装密码
	private String keyStorePassword;
	//中国银行网关地址
	private String cbpayGateway;
	//商户号
	private String merchantNo;
	//支付类型
	private String payType;
	//订单币种
	private String curCode;
	//商户预留号码
	private String spMobile;
	//超时时间
	private Integer orderTimeoutDate;
	//删除标识(0:未删除，1:已删除)
	private Integer isDel;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;

	
	//扩展字段
	private long outTradeNo;
	private String orderNote;
	private String orderAmount;
	private String orderNo;
	private String orderTime;
	private String orderTimeOut;
	private String orderUrl;
	private String signData;
	
    //========== getters and setters ==========
    
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getDefrayType() {
		return defrayType;
	}
	
	public void setDefrayType(String defrayType) {
		this.defrayType = defrayType;
	}
	public String getRootCertificate() {
		return rootCertificate;
	}
	
	public void setRootCertificate(String rootCertificate) {
		this.rootCertificate = rootCertificate;
	}
	public String getKeyStore() {
		return keyStore;
	}
	
	public void setKeyStore(String keyStore) {
		this.keyStore = keyStore;
	}
	public String getKeyPassword() {
		return keyPassword;
	}
	
	public void setKeyPassword(String keyPassword) {
		this.keyPassword = keyPassword;
	}
	public String getKeyStorePassword() {
		return keyStorePassword;
	}
	
	public void setKeyStorePassword(String keyStorePassword) {
		this.keyStorePassword = keyStorePassword;
	}
	public String getCbpayGateway() {
		return cbpayGateway;
	}
	
	public void setCbpayGateway(String cbpayGateway) {
		this.cbpayGateway = cbpayGateway;
	}
	public String getMerchantNo() {
		return merchantNo;
	}
	
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getPayType() {
		return payType;
	}
	
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getCurCode() {
		return curCode;
	}
	
	public void setCurCode(String curCode) {
		this.curCode = curCode;
	}
	public String getSpMobile() {
		return spMobile;
	}
	
	public void setSpMobile(String spMobile) {
		this.spMobile = spMobile;
	}
	public Integer getOrderTimeoutDate() {
		return orderTimeoutDate;
	}
	
	public void setOrderTimeoutDate(Integer orderTimeoutDate) {
		this.orderTimeoutDate = orderTimeoutDate;
	}
	public Integer getIsDel() {
		return isDel;
	}
	
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public long getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(long outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderTimeOut() {
		return orderTimeOut;
	}

	public void setOrderTimeOut(String orderTimeOut) {
		this.orderTimeOut = orderTimeOut;
	}

	public String getOrderUrl() {
		return orderUrl;
	}

	public void setOrderUrl(String orderUrl) {
		this.orderUrl = orderUrl;
	}

	public String getSignData() {
		return signData;
	}

	public void setSignData(String signData) {
		this.signData = signData;
	}

	public String getOrderNote() {
		return orderNote;
	}

	public void setOrderNote(String orderNote) {
		this.orderNote = orderNote;
	}

	public String getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	* 重载toString方法
	* @return
	*
	* @see java.lang.Object#toString()
	*/
	@Override
    public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

