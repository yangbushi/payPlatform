package com.defray.model;

import java.util.List;
import java.util.Map;
import java.lang.Integer;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.defray.bean.HospitalEntity;
import com.defray.dao.HospitalDao;
import com.defray.dao.HospitalMapper;


 

@Component
public class HospitalModel  implements IModel{

	@Autowired
	private HospitalMapper dao;
	
	public Integer insert(Object entity){
		return dao.insert((HospitalEntity)entity);
	}

	public Integer update(Object entity){
		return dao.update((HospitalEntity)entity);
	}

	public Integer deleteByKey( Integer key){
		return dao.deleteByKey(key);
	}
	
	public HospitalEntity getByKey( Integer key){
		return dao.getByKey(key);
	}
	
	public Integer deleteByKey( String key){
		return dao.deleteByKey(key);
	}
	
	public HospitalEntity getByKey( String key){
		return dao.getByKey(key);
	}
	 
	public List<HospitalEntity> findEntitys(Map<String ,Object>  param){
		return dao.findEntitys(param);
	}
	public Integer getEntitysCount(Map<String ,Object>  param){
		return dao.getEntitysCount(param);
	}
	 

}

 