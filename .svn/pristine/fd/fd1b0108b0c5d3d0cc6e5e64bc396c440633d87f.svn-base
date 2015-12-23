package com.defray.dao;

import java.util.List;
import java.util.Map;
import java.lang.Integer;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.defray.bean.DefrayTypeEntity;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;


 
@Repository
public interface DefrayTypeMapper {

	 
	public Integer insert(DefrayTypeEntity defrayType);
	public Integer update(DefrayTypeEntity defrayType);
	
	public Integer deleteByKey(@Param("key")Integer key);
	public DefrayTypeEntity getByKey (@Param("key") Integer key);
	
	public Integer deleteByKey(@Param("key")String key);
	public DefrayTypeEntity getByKey (@Param("key") String key);
	
	
	public List<DefrayTypeEntity>  findEntitys(@Param("param")Map<String ,Object>  param);
	public Integer getEntitysCount(@Param("param")Map<String ,Object>  param);
		
	public PageList<DefrayTypeEntity>  queryPaging(DefrayTypeEntity defrayType,PageBounds pageBounds);	
	
	public List<DefrayTypeEntity> selectByDistinctDefrayTypeName(
			DefrayTypeEntity defrayTypeEntity);
	
	public List<DefrayTypeEntity> selectByModel(
			DefrayTypeEntity defrayTypeEntity);
	
}