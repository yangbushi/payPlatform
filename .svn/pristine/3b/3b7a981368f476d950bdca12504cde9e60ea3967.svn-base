package com.defray.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.defray.bean.AccountCbpayEntity;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.manager.pageform.AccountAlipayInfo;
import com.manager.pageform.AccountCbpayInfo;


 
@Repository 
public interface AccountCbpayMapper {

	 
	public Integer insert(AccountCbpayEntity accountCbpay);
	public Integer update(AccountCbpayEntity accountCbpay);
	
	public Integer deleteByKey(@Param("key")Integer key);
	public AccountCbpayEntity getByKey (@Param("key") Integer key);
	
	public Integer deleteByKey(@Param("key")String key);
	public AccountCbpayEntity getByKey (@Param("key") String key);
	
	
	public List<AccountCbpayEntity>  findEntitys(@Param("param")Map<String ,Object>  param);
	public Integer getEntitysCount(@Param("param")Map<String ,Object>  param);
		
	
    PageList<AccountCbpayInfo> selectByModel(AccountCbpayInfo accountCbpay,PageBounds pageBounds);
	
	PageList<AccountCbpayInfo> selectByModel(AccountCbpayInfo accountCbpay);
	
	public AccountCbpayInfo selectByPrimaryKey(Integer id);
	
	public Integer insertSelective(AccountCbpayEntity accountCbpay);
	
	public AccountCbpayInfo selectByHospitalId(String hospitalId);
 
}