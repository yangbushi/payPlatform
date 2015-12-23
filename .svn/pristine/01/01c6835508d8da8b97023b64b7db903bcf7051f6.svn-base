package com.defray.model;

import java.util.List;
import java.util.Map;


/** 
 * 所有model都实现该接口，提供基本的增删改查
 */
public interface IModel {
	
	public Integer insert(Object entity);
	public Integer update(Object entity);

	public Object getByKey( Integer key);
	public Integer deleteByKey( Integer key);
	
	public List<?> findEntitys(Map<String ,Object>  param);
	public Integer getEntitysCount(Map<String ,Object>  param);
	 
}
