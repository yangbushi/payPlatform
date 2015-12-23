package com.defray.dao;

import java.util.List;
import java.util.Map;
import java.lang.Integer;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.defray.bean.RefundRecordEntity;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

 
@Repository
public interface RefundRecordMapper {

	 
	public Integer insert(RefundRecordEntity refundRecord);
	public Integer update(RefundRecordEntity refundRecord);
	
	public Integer deleteByKey(@Param("key")Integer key);
	public RefundRecordEntity getByKey (@Param("key") Integer key);
	
	public Integer deleteByKey(@Param("key")String key);
	public RefundRecordEntity getByKey (@Param("key") String key);
	
	
	public List<RefundRecordEntity>  findEntitys(@Param("param")Map<String ,Object>  param);
	public Integer getEntitysCount(@Param("param")Map<String ,Object>  param);
		
	public PageList<RefundRecordEntity>  queryPaging(RefundRecordEntity refundRecordEntity,PageBounds pageBounds);	
 
}