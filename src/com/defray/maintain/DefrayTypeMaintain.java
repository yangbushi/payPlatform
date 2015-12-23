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
import com.defray.bean.DefrayTypeEntity;
import com.defray.dao.DefrayTypeDao;
import com.defray.dao.DefrayTypeMapper;
import com.defray.util.HttpUtil;
import com.defray.util.StringUtil;
import com.defray.util.TimeUtil;
import com.opensymphony.xwork2.ActionSupport;


 

@Controller
@Scope("prototype")
public class DefrayTypeMaintain  extends ActionSupport{

	@Autowired
	private DefrayTypeMapper dao;
	
	//ID
	private String id;
	//支付类型名称
	private String defrayTypeName;
	
	public void insert(){
		Map<String,Object> dataMap = new HashMap<String,Object>();
		if (StringUtils.isBlank(defrayTypeName)) {
		
			dataMap.put("errorcode",1);
			dataMap.put("msg", "参数错误");
			dataMap.put("ret", "");
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;			
		}


		DefrayTypeEntity defrayTypeEntity = new DefrayTypeEntity();
		defrayTypeEntity.setDefrayTypeName(defrayTypeName);
		defrayTypeEntity.setCreateTime(new Date());
		defrayTypeEntity.setIsDel(0);
		defrayTypeEntity.setUpdateTime(new Date());
		dao.insert(defrayTypeEntity);
		dataMap.put("errorcode", 0);
		dataMap.put("msg", "操作成功");
		dataMap.put("ret", defrayTypeEntity);
		HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
		return;

	}

	public void update(){
		Map<String,Object> dataMap = new HashMap<String,Object>();
		if (StringUtils.isBlank(id) 
				|| StringUtils.isBlank(defrayTypeName)) {
		
			dataMap.put("errorcode",1);
			dataMap.put("msg", "参数错误");
			dataMap.put("ret", "");
			HttpUtil.jsonOut(getRequest(), getResponse(), dataMap);
			return;			
		}
		DefrayTypeEntity defrayTypeEntity = dao.getByKey(id);
		if(null != defrayTypeEntity){
			defrayTypeEntity.setDefrayTypeName(defrayTypeName);
			defrayTypeEntity.setIsDel(0);
			defrayTypeEntity.setUpdateTime(new Date());
			dao.update(defrayTypeEntity);
			dataMap.put("errorcode", 0);
			dataMap.put("msg", "操作成功");
			dataMap.put("ret", defrayTypeEntity);
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
		DefrayTypeEntity entity = dao.getByKey(id);
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
		DefrayTypeEntity entity = dao.getByKey(id);
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
	 
	public List<DefrayTypeEntity> findEntitys(Map<String ,Object>  param){
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

	public String getDefrayTypeName() {
		return defrayTypeName;
	}

	public void setDefrayTypeName(String defrayTypeName) {
		this.defrayTypeName = defrayTypeName;
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

 