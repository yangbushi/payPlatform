package com.defray.bean;


import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;

 
public class AccountAlipayEntity implements Serializable{

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -1L;

	//========== properties ==========
	
	//平台ID
	private Integer id;
	//医院ID
	private String hospitalId;
	//在支付平台支付方式
	private String defrayType;
	//合作身份者ID
	private String partner;
	//支付宝收款账号
	private String sellerEmail;
	//交易安全检验码,签名方式设置为“MD5”时设置该参数
	private String md5Key;
	//商户的私钥,签名方式设置为“0001”时设置该参数
	private String privateKey;
	//支付宝的公钥,签名方式设置为“0001”时设置该参数
	private String aliPublicKey;
	//调试用，创建TXT日志文件夹路径
	private String logPath;
	//字符编码格式 目前支持  utf-8
	private String inputCharset;
	//签名方式，选择项：0001(RSA)、MD5
	private String signType;
	//支付宝网关地址
	private String alipayGateway;
	//返回格式 "xml"不需要修改
	private String format;
	//版本 "2.0"不需要修改
	private String v;
	//交易自动关闭时间(单位:分钟)
	private String payExpire;
	//删除标识(0:未删除，1:已删除)
	private Integer isDel;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;

	//扩展字段
	private long outTradeNo;
	private String subject;
	private String totalFee;
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
	public String getPartner() {
		return partner;
	}
	
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public String getMd5Key() {
		return md5Key;
	}
	
	public void setMd5Key(String md5Key) {
		this.md5Key = md5Key;
	}
	public String getPrivateKey() {
		return privateKey;
	}
	
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	public String getAliPublicKey() {
		return aliPublicKey;
	}
	
	public void setAliPublicKey(String aliPublicKey) {
		this.aliPublicKey = aliPublicKey;
	}
	public String getLogPath() {
		return logPath;
	}
	
	public void setLogPath(String logPath) {
		this.logPath = logPath;
	}
	public String getInputCharset() {
		return inputCharset;
	}
	
	public void setInputCharset(String inputCharset) {
		this.inputCharset = inputCharset;
	}
	public String getSignType() {
		return signType;
	}
	
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getAlipayGateway() {
		return alipayGateway;
	}
	
	public void setAlipayGateway(String alipayGateway) {
		this.alipayGateway = alipayGateway;
	}
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	public String getV() {
		return v;
	}
	
	public void setV(String v) {
		this.v = v;
	}
	public String getPayExpire() {
		return payExpire;
	}
	
	public void setPayExpire(String payExpire) {
		this.payExpire = payExpire;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
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

