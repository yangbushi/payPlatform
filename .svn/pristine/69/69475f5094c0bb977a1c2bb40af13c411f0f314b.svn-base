package com.defray.dao;

import java.util.List;
import java.util.Map;
import java.lang.Integer;

import org.apache.ibatis.annotations.Param;

import com.defray.bean.DefrayTypeEntity;


 
 
public interface DefrayTypeDao {

	 
	public Integer insert(DefrayTypeEntity defrayType);
	public Integer update(DefrayTypeEntity defrayType);
	
	public Integer deleteByKey(@Param("key")Integer key);
	public DefrayTypeEntity getByKey (@Param("key") Integer key);
	
	public Integer deleteByKey(@Param("key")String key);
	public DefrayTypeEntity getByKey (@Param("key") String key);
	
	
	public List<DefrayTypeEntity>  findEntitys(@Param("param")Map<String ,Object>  param);
	public Integer getEntitysCount(@Param("param")Map<String ,Object>  param);
		
		
 
}