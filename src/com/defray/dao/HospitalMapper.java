package com.defray.dao;

import java.util.List;
import java.util.Map;
import java.lang.Integer;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.defray.bean.HospitalEntity;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;


 
@Repository
public interface HospitalMapper {

	 
	public Integer insert(HospitalEntity hospital);
	public Integer update(HospitalEntity hospital);
	
	public Integer deleteByKey(@Param("key")Integer key);
	public HospitalEntity getByKey (@Param("key") Integer key);
	
	public Integer deleteByKey(@Param("key")String key);
	public HospitalEntity getByKey (@Param("key") String key);
	
	
	public List<HospitalEntity>  findEntitys(@Param("param")Map<String ,Object>  param);
	public Integer getEntitysCount(@Param("param")Map<String ,Object>  param);
		
	public PageList<HospitalEntity>  queryPaging(HospitalEntity hospitalEntity,PageBounds pageBounds);	
	
	public List<HospitalEntity> selectByModel(
			HospitalEntity hospitalEntity);	
	
}