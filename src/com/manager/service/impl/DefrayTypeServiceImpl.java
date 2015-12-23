package com.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.defray.bean.DefrayTypeEntity;
import com.defray.dao.DefrayTypeMapper;
import com.manager.service.DefrayTypeService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.herenit.hhw.dao.pojo.MyPageBounds;
import com.herenit.hhw.dao.pojo.MyResults;

public class DefrayTypeServiceImpl implements DefrayTypeService{
	@Autowired
	public DefrayTypeMapper defrayTypeMapper;
	
	@Override
	public MyResults queryPaging(DefrayTypeEntity defrayTypeEntity,
			MyPageBounds myPageBounds) {
		PageBounds pageBounds = new PageBounds();
		pageBounds.setPage(myPageBounds.getPage());
		pageBounds.setLimit(myPageBounds.getLimit());
		pageBounds.setOrders(myPageBounds.getOrders());
		
		PageList<DefrayTypeEntity> list = defrayTypeMapper.queryPaging(defrayTypeEntity,pageBounds);
		
		MyResults res = new MyResults();
		res.setLimit(list.getPaginator().getLimit());
		res.setPage(list.getPaginator().getPage());
		res.setSize(list.size());
		res.setResult(list.toArray());
		res.setTotalCount(list.getPaginator().getTotalCount());
		return res;
	}

	@Override
	public DefrayTypeEntity selectById(Integer id) {
		return defrayTypeMapper.getByKey(id);
	}

	@Override
	public List<DefrayTypeEntity> selectByDistinctDefrayTypeName(
			DefrayTypeEntity defrayTypeEntity) {
		return defrayTypeMapper.selectByDistinctDefrayTypeName(defrayTypeEntity);
	}

	@Override
	public Integer save(DefrayTypeEntity defrayTypeEntity) {
		if(defrayTypeEntity.getId() == null){
			defrayTypeEntity.setCreateTime(new Date());
			defrayTypeMapper.insert(defrayTypeEntity);
		}else{
			defrayTypeEntity.setUpdateTime(new Date());
			defrayTypeMapper.update(defrayTypeEntity);
		}
		return defrayTypeEntity.getId();
	}

	@Override
	public void deleteById(DefrayTypeEntity defrayTypeEntity) {
		defrayTypeEntity.setIsDel(1);
		defrayTypeMapper.update(defrayTypeEntity);
	}

	@Override
	public List<DefrayTypeEntity> selectByModel(
			DefrayTypeEntity defrayTypeEntity) {
		return defrayTypeMapper.selectByModel(defrayTypeEntity);
	}

}
