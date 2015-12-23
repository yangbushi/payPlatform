 
package com.defray.maintain;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.defray.bean.AccountCbpayEntity;
import com.defray.dao.AccountCbpayDao;
import com.defray.dao.AccountCbpayMapper;
import com.defray.util.HttpUtil;
import com.defray.util.StringUtil;
import com.defray.util.TimeUtil;
import com.opensymphony.xwork2.ActionSupport;



 

@Controller
@Scope("prototype")
public class AccountCbpayMaintain extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5117284078127074175L;
	
	// 平台ID
	private String id;
	// 医院ID
	private String hospitalId;
	// 在支付平台支付方式
	private String defrayType;
	// 根证书
	private String rootCertificate;
	// 密钥(证书)
	private String keyStore;
	// 密钥(证书)密码
	private String keyPassword;
	// 密钥(证书)安装密码
	private String keyStorePassword;
	// 中国银行网关地址
	private String cbpayGateway;
	// 商户号
	private String merchantNo;
	// 支付类型
	private String payType;
	// 订单币种
	private String curCode;
	// 商户预留号码
	private String spMobile;
	// 超时时间
	private String orderTimeoutDate;
	// 删除标识(0:未删除，1:已删除)
	private Integer isDel;
	// 创建时间
	private Integer createTime;
	// 修改时间
	private Integer updateTime;

	@Autowired
	private AccountCbpayMapper dao;
	
	public void insert(){
		Map<String,Object> dataMap = new HashMap<String,Object>();
		if (StringUtils.isBlank(hospitalId) 
				|| StringUtils.isBlank(defrayType)
				|| StringUtils.isBlank(rootCertificate)
				|| StringUtils.isBlank(keyStore)
				|| StringUtils.isBlank(keyPassword)
				|| StringUtils.isBlank(keyStorePassword)
				|| StringUtils.isBlank(cbpayGateway)
				|| StringUtils.isBlank(merchantNo)
				|| StringUtils.isBlank(payType)
				|| StringUtils.isBlank(curCode)
				|| StringUtils.isBlank(spMobile)
				|| StringUtils.isBlank(orderTimeoutDate)) {
		
			dataMap.put("errorcode",1);
			dataMap.put("msg", "参数错误");
			dataMap.put("ret", "");
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;			
		}
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("hospitalId", hospitalId);
		params.put("isDel", 0);
		List<AccountCbpayEntity> list = dao.findEntitys(params);
		if(0 == list.size()){
			AccountCbpayEntity accountCbpayEntity = new AccountCbpayEntity();
			accountCbpayEntity.setCbpayGateway(cbpayGateway);
			accountCbpayEntity.setCreateTime(new Date());
			accountCbpayEntity.setCurCode(curCode);
			accountCbpayEntity.setDefrayType(defrayType);
			accountCbpayEntity.setHospitalId(hospitalId);
			accountCbpayEntity.setIsDel(0);
			accountCbpayEntity.setKeyPassword(keyPassword);
			accountCbpayEntity.setKeyStore(keyStore);
			accountCbpayEntity.setKeyStorePassword(keyStorePassword);
			accountCbpayEntity.setMerchantNo(merchantNo);
			accountCbpayEntity.setOrderTimeoutDate(StringUtil.StringToInteger(orderTimeoutDate));
			accountCbpayEntity.setPayType(payType);
			accountCbpayEntity.setRootCertificate(rootCertificate);
			accountCbpayEntity.setSpMobile(spMobile);
			accountCbpayEntity.setUpdateTime(new Date());
			dao.insert(accountCbpayEntity);
			dataMap.put("errorcode", 0);
			dataMap.put("msg", "操作成功");
			dataMap.put("ret", accountCbpayEntity);
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
				|| StringUtils.isBlank(rootCertificate)
				|| StringUtils.isBlank(keyStore)
				|| StringUtils.isBlank(keyPassword)
				|| StringUtils.isBlank(keyStorePassword)
				|| StringUtils.isBlank(cbpayGateway)
				|| StringUtils.isBlank(merchantNo)
				|| StringUtils.isBlank(payType)
				|| StringUtils.isBlank(curCode)
				|| StringUtils.isBlank(spMobile)
				|| StringUtils.isBlank(orderTimeoutDate)
				|| StringUtils.isBlank(id)) {
		
			dataMap.put("errorcode",1);
			dataMap.put("msg", "参数错误");
			dataMap.put("ret", "");
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;			
		}
		AccountCbpayEntity accountCbpayEntity = dao.getByKey(id);
		if(null != accountCbpayEntity){
			accountCbpayEntity.setCbpayGateway(cbpayGateway);
			accountCbpayEntity.setCurCode(curCode);
			accountCbpayEntity.setDefrayType(defrayType);
			accountCbpayEntity.setHospitalId(hospitalId);
			accountCbpayEntity.setIsDel(0);
			accountCbpayEntity.setKeyPassword(keyPassword);
			accountCbpayEntity.setKeyStore(keyStore);
			accountCbpayEntity.setKeyStorePassword(keyStorePassword);
			accountCbpayEntity.setMerchantNo(merchantNo);
			accountCbpayEntity.setOrderTimeoutDate(StringUtil.StringToInteger(orderTimeoutDate));
			accountCbpayEntity.setPayType(payType);
			accountCbpayEntity.setRootCertificate(rootCertificate);
			accountCbpayEntity.setSpMobile(spMobile);
			accountCbpayEntity.setUpdateTime(new Date());
			dao.update(accountCbpayEntity);
			dataMap.put("errorcode", 0);
			dataMap.put("msg", "操作成功");
			dataMap.put("ret", accountCbpayEntity);
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
		AccountCbpayEntity entity = dao.getByKey(id);
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
		AccountCbpayEntity entity = dao.getByKey(id);
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
	 
	public List<AccountCbpayEntity> findEntitys(Map<String ,Object>  param){
		return dao.findEntitys(param);
	}
	public Integer getEntitysCount(Map<String ,Object>  param){
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

	public String getOrderTimeoutDate() {
		return orderTimeoutDate;
	}

	public void setOrderTimeoutDate(String orderTimeoutDate) {
		this.orderTimeoutDate = orderTimeoutDate;
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

 