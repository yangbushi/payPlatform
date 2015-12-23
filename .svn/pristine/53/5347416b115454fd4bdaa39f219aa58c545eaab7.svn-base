package com.defray.model;

import java.util.List;
import java.util.Map;
import java.lang.Integer;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.defray.bean.RefundRecordEntity;
import com.defray.dao.RefundRecordDao;
import com.defray.dao.RefundRecordMapper;


 

@Component
public class RefundRecordModel  implements IModel{

	@Autowired
	private RefundRecordMapper dao;
	
	public Integer insert(Object entity){
		return dao.insert((RefundRecordEntity)entity);
	}

	public Integer update(Object entity){
		return dao.update((RefundRecordEntity)entity);
	}

	public Integer deleteByKey( Integer key){
		return dao.deleteByKey(key);
	}
	
	public RefundRecordEntity getByKey( Integer key){
		return dao.getByKey(key);
	}
	
	public Integer deleteByKey( String key){
		return dao.deleteByKey(key);
	}
	
	public RefundRecordEntity getByKey( String key){
		return dao.getByKey(key);
	}
	 
	public List<RefundRecordEntity> findEntitys(Map<String ,Object>  param){
		return dao.findEntitys(param);
	}
	public Integer getEntitysCount(Map<String ,Object>  param){
		return dao.getEntitysCount(param);
	}
	 

}

 