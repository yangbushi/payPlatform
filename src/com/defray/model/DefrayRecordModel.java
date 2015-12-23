package com.defray.model;

import java.util.List;
import java.util.Map;
import java.lang.Integer;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.defray.bean.DefrayRecordEntity;
import com.defray.dao.DefrayRecordDao;
import com.defray.dao.DefrayRecordMapper;


 

@Component
public class DefrayRecordModel  implements IModel{

	@Autowired
	private DefrayRecordMapper dao;
	
	public Integer insert(Object entity){
		return dao.insert((DefrayRecordEntity)entity);
	}

	public Integer update(Object entity){
		return dao.update((DefrayRecordEntity)entity);
	}

	public Integer deleteByKey( Integer key){
		return dao.deleteByKey(key);
	}
	
	public DefrayRecordEntity getByKey( Integer key){
		return dao.getByKey(key);
	}
	
	public Integer deleteByKey( String key){
		return dao.deleteByKey(key);
	}
	
	public DefrayRecordEntity getByKey( String key){
		return dao.getByKey(key);
	}
	 
	public List<DefrayRecordEntity> findEntitys(Map<String ,Object>  param){
		return dao.findEntitys(param);
	}
	public Integer getEntitysCount(Map<String ,Object>  param){
		return dao.getEntitysCount(param);
	}
	 

}

 