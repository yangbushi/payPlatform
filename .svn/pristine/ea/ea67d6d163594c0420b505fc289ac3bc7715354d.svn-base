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

import com.defray.bean.DefrayTypeEntity;
import com.defray.bean.HospitalEntity;
import com.defray.dao.HospitalDao;
import com.defray.dao.HospitalMapper;
import com.defray.util.HttpUtil;
import com.defray.util.StringUtil;
import com.defray.util.TimeUtil;
import com.opensymphony.xwork2.ActionSupport;


 

@Controller
@Scope("prototype")
public class HospitalMaintain extends ActionSupport{

	@Autowired
	private HospitalMapper dao;
	
	//平台ID
	private String id;
	// 医院ID
	private String hospitalId;
	// 医院名称
	private String hospitalName;
	// 支付方式
	private String defrayType;
	
	public void insert(){
		Map<String,Object> dataMap = new HashMap<String,Object>();
		if (StringUtils.isBlank(hospitalId)
				|| StringUtils.isBlank(hospitalName)
				|| StringUtils.isBlank(defrayType)) {
		
			dataMap.put("errorcode",1);
			dataMap.put("msg", "参数错误");
			dataMap.put("ret", "");
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;			
		}


		HospitalEntity hospitalEntity = new HospitalEntity();
		hospitalEntity.setCreateTime(new Date());
		hospitalEntity.setDefrayType(defrayType);
		hospitalEntity.setHospitalId(hospitalId);
		hospitalEntity.setHospitalName(hospitalName);
		hospitalEntity.setIsDel(0);
		hospitalEntity.setUpdateTime(new Date());
		dao.insert(hospitalEntity);
		dataMap.put("errorcode", 0);
		dataMap.put("msg", "操作成功");
		dataMap.put("ret", hospitalEntity);
		HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
		return;

	}

	public void update(){
		Map<String,Object> dataMap = new HashMap<String,Object>();
		if (StringUtils.isBlank(id) 
				|| StringUtils.isBlank(hospitalId)
				|| StringUtils.isBlank(hospitalName)
				|| StringUtils.isBlank(defrayType)) {
		
			dataMap.put("errorcode",1);
			dataMap.put("msg", "参数错误");
			dataMap.put("ret", "");
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;			
		}
		HospitalEntity hospitalEntity = dao.getByKey(id);
		if(null != hospitalEntity){
			hospitalEntity.setDefrayType(defrayType);
			hospitalEntity.setHospitalId(hospitalId);
			hospitalEntity.setHospitalName(hospitalName);
			hospitalEntity.setIsDel(0);
			hospitalEntity.setUpdateTime(new Date());
			dao.update(hospitalEntity);
			dataMap.put("errorcode", 0);
			dataMap.put("msg", "操作成功");
			dataMap.put("ret", hospitalEntity);
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
		HospitalEntity entity = dao.getByKey(id);
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
		HospitalEntity entity = dao.getByKey(id);
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
	 
	public List<HospitalEntity> findEntitys(Map<String ,Object>  param){
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

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getDefrayType() {
		return defrayType;
	}

	public void setDefrayType(String defrayType) {
		this.defrayType = defrayType;
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

 