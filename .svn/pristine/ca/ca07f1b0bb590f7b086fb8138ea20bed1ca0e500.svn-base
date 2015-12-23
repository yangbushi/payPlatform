package com.defray.dao;

import java.util.List;
import java.util.Map;
import java.lang.Integer;

import org.apache.ibatis.annotations.Param;

import com.defray.bean.AccountCbpayEntity;


 
 
public interface AccountCbpayDao {

	 
	public Integer insert(AccountCbpayEntity accountCbpay);
	public Integer update(AccountCbpayEntity accountCbpay);
	
	public Integer deleteByKey(@Param("key")Integer key);
	public AccountCbpayEntity getByKey (@Param("key") Integer key);
	
	public Integer deleteByKey(@Param("key")String key);
	public AccountCbpayEntity getByKey (@Param("key") String key);
	
	
	public List<AccountCbpayEntity>  findEntitys(@Param("param")Map<String ,Object>  param);
	public Integer getEntitysCount(@Param("param")Map<String ,Object>  param);
		
		
 
}