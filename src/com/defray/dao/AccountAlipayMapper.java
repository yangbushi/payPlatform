package com.defray.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.defray.bean.AccountAlipayEntity;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.manager.pageform.AccountAlipayInfo;


@Repository
public interface AccountAlipayMapper {

	 
	public Integer insert(AccountAlipayEntity accountAlipay);
	public Integer update(AccountAlipayEntity accountAlipay);
	
	public Integer deleteByKey(@Param("key")Integer key);
	public AccountAlipayEntity getByKey (@Param("key") Integer key);
	
	public Integer deleteByKey(@Param("key")String key);
	public AccountAlipayEntity getByKey (@Param("key") String key);
	
	
	public List<AccountAlipayEntity>  findEntitys(@Param("param")Map<String ,Object>  param);
	public Integer getEntitysCount(@Param("param")Map<String ,Object>  param);
	public AccountAlipayEntity getByHosId(@Param("hosId")String hosId);
	
	
	
	PageList<AccountAlipayInfo> selectByModel(AccountAlipayInfo accountAlipay,PageBounds pageBounds);
	
	PageList<AccountAlipayInfo> selectByModel(AccountAlipayInfo accountAlipay);
	
	public AccountAlipayInfo selectByPrimaryKey(Integer id);
	
	public Integer insertSelective(AccountAlipayEntity accountAlipay);
	
	public AccountAlipayInfo selectByHospitalId(String hospitalId);
		
 
}