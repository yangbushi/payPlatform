 
package com.defray.model;

import java.util.List;
import java.util.Map;
import java.lang.Integer;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.defray.bean.AccountCbpayEntity;
import com.defray.dao.AccountCbpayDao;
import com.defray.dao.AccountCbpayMapper;



 

@Component
public class AccountCbpayModel  implements IModel{

	@Autowired
	private AccountCbpayMapper dao;
	
	public Integer insert(Object entity){
		return dao.insert((AccountCbpayEntity)entity);
	}

	public Integer update(Object entity){
		return dao.update((AccountCbpayEntity)entity);
	}

	public Integer deleteByKey( Integer key){
		return dao.deleteByKey(key);
	}
	
	public AccountCbpayEntity getByKey( Integer key){
		return dao.getByKey(key);
	}
	
	public Integer deleteByKey( String key){
		return dao.deleteByKey(key);
	}
	
	public AccountCbpayEntity getByKey( String key){
		return dao.getByKey(key);
	}
	 
	public List<AccountCbpayEntity> findEntitys(Map<String ,Object>  param){
		return dao.findEntitys(param);
	}
	public Integer getEntitysCount(Map<String ,Object>  param){
		return dao.getEntitysCount(param);
	}
	 

}

 