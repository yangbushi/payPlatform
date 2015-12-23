package com.defray.dao;

import java.util.List;
import java.util.Map;
import java.lang.Integer;

import org.apache.ibatis.annotations.Param;

import com.defray.bean.DefrayRecordEntity;


 
 
public interface DefrayRecordDao {

	 
	public Integer insert(DefrayRecordEntity defrayRecord);
	public Integer update(DefrayRecordEntity defrayRecord);
	
	public Integer deleteByKey(@Param("key")Integer key);
	public DefrayRecordEntity getByKey (@Param("key") Integer key);
	
	public Integer deleteByKey(@Param("key")String key);
	public DefrayRecordEntity getByKey (@Param("key") String key);
	
	
	public List<DefrayRecordEntity>  findEntitys(@Param("param")Map<String ,Object>  param);
	public Integer getEntitysCount(@Param("param")Map<String ,Object>  param);
		
		
 
}