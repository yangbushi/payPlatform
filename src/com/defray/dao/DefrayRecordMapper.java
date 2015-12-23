package com.defray.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.defray.bean.DefrayRecordEntity;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;


 
@Repository
public interface DefrayRecordMapper {

	 
	public Integer insert(DefrayRecordEntity defrayRecord);
	public Integer update(DefrayRecordEntity defrayRecord);
	
	public Integer deleteByKey(@Param("key")Integer key);
	public DefrayRecordEntity getByKey (@Param("key") Integer key);
	
	public Integer deleteByKey(@Param("key")String key);
	public DefrayRecordEntity getByKey (@Param("key") String key);
	
	
	public List<DefrayRecordEntity>  findEntitys(@Param("param")Map<String ,Object>  param);
	
	public PageList<DefrayRecordEntity>  queryPaging(DefrayRecordEntity defrayRecord,PageBounds pageBounds);
	public Integer getEntitysCount(@Param("param")Map<String ,Object>  param);
		
}