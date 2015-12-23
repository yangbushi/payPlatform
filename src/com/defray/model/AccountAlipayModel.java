package com.defray.model;

import java.util.List;
import java.util.Map;
import java.lang.Integer;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.defray.bean.AccountAlipayEntity;
import com.defray.dao.AccountAlipayDao;
import com.defray.dao.AccountAlipayMapper;



 

@Component
public class AccountAlipayModel  implements IModel{

	@Autowired
	private AccountAlipayMapper dao;
	
	public Integer insert(Object entity){
		return dao.insert((AccountAlipayEntity)entity);
	}

	public Integer update(Object entity){
		return dao.update((AccountAlipayEntity)entity);
	}

	public Integer deleteByKey( Integer key){
		return dao.deleteByKey(key);
	}
	
	public AccountAlipayEntity getByKey( Integer key){
		return dao.getByKey(key);
	}
	
	public Integer deleteByKey( String key){
		return dao.deleteByKey(key);
	}
	
	public AccountAlipayEntity getByKey( String key){
		return dao.getByKey(key);
	}
	 
	public List<AccountAlipayEntity> findEntitys(Map<String ,Object>  param){
		return dao.findEntitys(param);
	}
	public Integer getEntitysCount(Map<String ,Object>  param){
		return dao.getEntitysCount(param);
	}

	public AccountAlipayEntity getByHosId(String hosId) {
		return dao.getByHosId(hosId);
	}
	 

}

 