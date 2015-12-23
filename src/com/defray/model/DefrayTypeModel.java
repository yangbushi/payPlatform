package com.defray.model;

import java.util.List;
import java.util.Map;
import java.lang.Integer;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.defray.bean.DefrayTypeEntity;
import com.defray.dao.DefrayTypeDao;
import com.defray.dao.DefrayTypeMapper;


 

@Component
public class DefrayTypeModel  implements IModel{

	@Autowired
	private DefrayTypeMapper dao;
	
	public Integer insert(Object entity){
		return dao.insert((DefrayTypeEntity)entity);
	}

	public Integer update(Object entity){
		return dao.update((DefrayTypeEntity)entity);
	}

	public Integer deleteByKey( Integer key){
		return dao.deleteByKey(key);
	}
	
	public DefrayTypeEntity getByKey( Integer key){
		return dao.getByKey(key);
	}
	
	public Integer deleteByKey( String key){
		return dao.deleteByKey(key);
	}
	
	public DefrayTypeEntity getByKey( String key){
		return dao.getByKey(key);
	}
	 
	public List<DefrayTypeEntity> findEntitys(Map<String ,Object>  param){
		return dao.findEntitys(param);
	}
	public Integer getEntitysCount(Map<String ,Object>  param){
		return dao.getEntitysCount(param);
	}
	 

}

 