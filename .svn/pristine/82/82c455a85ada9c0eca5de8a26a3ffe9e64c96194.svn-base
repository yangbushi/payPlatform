package com.defray.maintain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Integer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.defray.bean.AccountAlipayEntity;
import com.defray.dao.AccountAlipayDao;
import com.defray.dao.AccountAlipayMapper;
import com.defray.util.HttpUtil;
import com.defray.util.StringUtil;
import com.defray.util.TimeUtil;
import com.opensymphony.xwork2.ActionSupport;



 

@Controller
@Scope("prototype")
public class AccountAlipayMaintain extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6981639447299680249L;
	// 平台ID
	private String id;
	// 医院ID
	private String hospitalId;
	// 在支付平台支付方式
	private String defrayType;
	// 合作身份者ID
	private String partner;
	// 支付宝收款账号
	private String sellerEmail;
	// 交易安全检验码,签名方式设置为“MD5”时设置该参数
	private String md5Key;
	// 商户的私钥,签名方式设置为“0001”时设置该参数
	private String privateKey;
	// 支付宝的公钥,签名方式设置为“0001”时设置该参数
	private String aliPublicKey;
	// 调试用，创建TXT日志文件夹路径
	private String logPath;
	// 字符编码格式 目前支持 utf-8
	private String inputCharset;
	// 签名方式，选择项：0001(RSA)、MD5
	private String signType;
	// 支付宝网关地址
	private String alipayGateway;
	// 返回格式 "xml"不需要修改
	private String format;
	// 版本 "2.0"不需要修改
	private String v;
	// 交易自动关闭时间(单位:分钟)
	private String payExpire;
	// 删除标识(0:未删除，1:已删除)
	private Integer isDel;
	// 创建时间
	private Integer createTime;
	// 修改时间
	private Integer updateTime;
	private String page;
	private String pageSize;
	
	@Autowired
	private AccountAlipayMapper dao;
	
	public void insert(){
		Map<String,Object> dataMap = new HashMap<String,Object>();
		if (StringUtils.isBlank(hospitalId) 
				|| StringUtils.isBlank(defrayType)
				|| StringUtils.isBlank(partner)
				|| StringUtils.isBlank(sellerEmail)
				|| StringUtils.isBlank(md5Key)
				|| StringUtils.isBlank(privateKey)
				|| StringUtils.isBlank(aliPublicKey)
				|| StringUtils.isBlank(logPath)
				|| StringUtils.isBlank(inputCharset)
				|| StringUtils.isBlank(signType)
				|| StringUtils.isBlank(alipayGateway)
				|| StringUtils.isBlank(format)
				|| StringUtils.isBlank(v)
				|| StringUtils.isBlank(payExpire)) {
		
			dataMap.put("errorcode",1);
			dataMap.put("msg", "参数错误");
			dataMap.put("ret", "");
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;			
		}
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("hospitalId", hospitalId);
		params.put("isDel", 0);
		List<AccountAlipayEntity> list = dao.findEntitys(params);
		if(0 == list.size()){
			AccountAlipayEntity accountAlipayEntity = new AccountAlipayEntity();
			accountAlipayEntity.setAlipayGateway(alipayGateway);
			accountAlipayEntity.setAliPublicKey(aliPublicKey);
			accountAlipayEntity.setDefrayType(defrayType);
			accountAlipayEntity.setFormat(format);
			accountAlipayEntity.setHospitalId(hospitalId);
			accountAlipayEntity.setInputCharset(inputCharset);
			accountAlipayEntity.setIsDel(0);
			accountAlipayEntity.setLogPath(logPath);
			accountAlipayEntity.setMd5Key(md5Key);
			accountAlipayEntity.setPartner(partner);
			accountAlipayEntity.setPayExpire(payExpire);
			accountAlipayEntity.setPrivateKey(privateKey);
			accountAlipayEntity.setSellerEmail(sellerEmail);
			accountAlipayEntity.setSignType(signType);
			accountAlipayEntity.setUpdateTime(new Date());
			accountAlipayEntity.setV(v);
			dao.insert(accountAlipayEntity);
			dataMap.put("errorcode", 0);
			dataMap.put("msg", "操作成功");
			dataMap.put("ret", accountAlipayEntity);
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;	
		}else{
			dataMap.put("errorcode", 2);
			dataMap.put("msg", "已存在记录");
			dataMap.put("ret", "");
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;
		}
	}

	public void update(){
		Map<String,Object> dataMap = new HashMap<String,Object>();
		if (StringUtils.isBlank(hospitalId) 
				|| StringUtils.isBlank(defrayType)
				|| StringUtils.isBlank(partner)
				|| StringUtils.isBlank(sellerEmail)
				|| StringUtils.isBlank(md5Key)
				|| StringUtils.isBlank(privateKey)
				|| StringUtils.isBlank(aliPublicKey)
				|| StringUtils.isBlank(logPath)
				|| StringUtils.isBlank(inputCharset)
				|| StringUtils.isBlank(signType)
				|| StringUtils.isBlank(alipayGateway)
				|| StringUtils.isBlank(format)
				|| StringUtils.isBlank(v)
				|| StringUtils.isBlank(payExpire)
				|| StringUtils.isBlank(id)) {
		
			dataMap.put("errorcode",1);
			dataMap.put("msg", "参数错误");
			dataMap.put("ret", "");
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;			
		}
		AccountAlipayEntity accountAlipayEntity = dao.getByKey(id);
		if(null != accountAlipayEntity){
			
			accountAlipayEntity.setAlipayGateway(alipayGateway);
			accountAlipayEntity.setAliPublicKey(aliPublicKey);
			accountAlipayEntity.setCreateTime(new Date());
			accountAlipayEntity.setDefrayType(defrayType);
			accountAlipayEntity.setFormat(format);
			accountAlipayEntity.setHospitalId(hospitalId);
			accountAlipayEntity.setInputCharset(inputCharset);
			accountAlipayEntity.setIsDel(0);
			accountAlipayEntity.setLogPath(logPath);
			accountAlipayEntity.setMd5Key(md5Key);
			accountAlipayEntity.setPartner(partner);
			accountAlipayEntity.setPayExpire(payExpire);
			accountAlipayEntity.setPrivateKey(privateKey);
			accountAlipayEntity.setSellerEmail(sellerEmail);
			accountAlipayEntity.setSignType(signType);
			accountAlipayEntity.setUpdateTime(new Date());
			accountAlipayEntity.setV(v);
			dao.update(accountAlipayEntity);
			dataMap.put("errorcode", 0);
			dataMap.put("msg", "操作成功");
			dataMap.put("ret", accountAlipayEntity);
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;	
		}else{
			dataMap.put("errorcode", 2);
			dataMap.put("msg", "记录异常");
			dataMap.put("ret", "");
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;
		}

	}

	public void deleteByKey(){
		Map<String,Object> dataMap = new HashMap<String,Object>();
		if (null == id) {
		
			dataMap.put("errorcode",1);
			dataMap.put("msg", "参数错误");
			dataMap.put("ret", "");
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;			
		}
		AccountAlipayEntity entity = dao.getByKey(id);
		if(null != entity){
			entity.setIsDel(1);
			dao.update(entity);
			dataMap.put("errorcode", 0);
			dataMap.put("msg", "操作成功");
			dataMap.put("ret", entity);
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;	
		}else{
			dataMap.put("errorcode", 2);
			dataMap.put("msg", "记录异常");
			dataMap.put("ret", "");
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;
		}

	}
	
	public void getByKey(){
		Map<String,Object> dataMap = new HashMap<String,Object>();
		if (null == id) {
		
			dataMap.put("errorcode",1);
			dataMap.put("msg", "参数错误");
			dataMap.put("ret", "");
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;			
		}
		AccountAlipayEntity entity = dao.getByKey(id);
		if(null != entity){
			dataMap.put("errorcode", 0);
			dataMap.put("msg", "操作成功");
			dataMap.put("ret", entity);
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;	
		}else{
			dataMap.put("errorcode", 2);
			dataMap.put("msg", "记录异常");
			dataMap.put("ret", "");
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;
		}

	}
	 
	public void findEntitys(){
		Map<String,Object> dataMap = new HashMap<String,Object>();
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isDel", 0);
		Integer totalCount = getEntitysCount(params);
		if(!StringUtils.isBlank(hospitalId)){
			params.put("hospitalId", hospitalId);
		}

		if(StringUtils.isBlank(pageSize)){
			pageSize = "10";
		}
		
		if(StringUtils.isBlank(page)){
			page = "1";
		}
		params.put("pageNum", stringToInt(pageSize));
		params.put("start", (stringToInt(page)-1)*stringToInt(pageSize));
		
		List<AccountAlipayEntity> list = new ArrayList<AccountAlipayEntity>();
		list = dao.findEntitys(params);
		if(list.size() > 0){
			dataMap.put("errorcode", 0);
			dataMap.put("msg", "操作成功");
			dataMap.put("ret", list);
			dataMap.put("totalCount", totalCount);
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;	
		}else{
			dataMap.put("errorcode", 2);
			dataMap.put("msg", "记录异常");
			dataMap.put("ret", "");
			dataMap.put("totalCount", totalCount);
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;
		}

	}
	
	private static int stringToInt(String intstr) {
		Integer integer;
		try{
			integer = Integer.valueOf(intstr);
		}catch(NumberFormatException e){
			integer = 1;
		}
		return integer.intValue();
	}
	
	private Integer getEntitysCount(Map<String ,Object>  param){
		return dao.getEntitysCount(param);
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	/**
     * 获得response
     */
    private HttpServletResponse getResponse() {
        return ServletActionContext.getResponse();
    }

    /**
     * 获得request
     */
    private HttpServletRequest getRequest() {
        return ServletActionContext.getRequest();
    }
}

 