package com.manager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.defray.bean.DefrayTypeEntity;
import com.defray.bean.HospitalEntity;
import com.defray.dao.HospitalMapper;
import com.manager.service.HospitalService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.herenit.hhw.dao.pojo.MyPageBounds;
import com.herenit.hhw.dao.pojo.MyResults;

public class HospitalServiceImpl implements HospitalService {
	@Autowired
	HospitalMapper hospitalMapper;
	
	@Override
	public MyResults queryPaging(HospitalEntity hospitalEntity,
			MyPageBounds myPageBounds) {
		PageBounds pageBounds = new PageBounds();
		pageBounds.setPage(myPageBounds.getPage());
		pageBounds.setLimit(myPageBounds.getLimit());
		pageBounds.setOrders(myPageBounds.getOrders());
		
		PageList<HospitalEntity> list = hospitalMapper.queryPaging(hospitalEntity,pageBounds);
		
		MyResults res = new MyResults();
		res.setLimit(list.getPaginator().getLimit());
		res.setPage(list.getPaginator().getPage());
		res.setSize(list.size());
		res.setResult(list.toArray());
		res.setTotalCount(list.getPaginator().getTotalCount());
		return res;
	}

	@Override
	public HospitalEntity selectById(Integer id) {
		return hospitalMapper.getByKey(id);
	}

	@Override
	public List<HospitalEntity> selectByModel(HospitalEntity hospitalEntity) {
		return hospitalMapper.selectByModel(hospitalEntity);
	}

	@Override
	public Integer save(HospitalEntity hospitalEntity) {
		if(hospitalEntity.getId() == null){
			hospitalEntity.setCreateTime(new Date());
			hospitalMapper.insert(hospitalEntity);
		}else{
			hospitalEntity.setUpdateTime(new Date());
			hospitalMapper.update(hospitalEntity);
		}
		return hospitalEntity.getId();
	}

	@Override
	public void deleteById(HospitalEntity hospitalEntity) {
		hospitalMapper.deleteByKey(hospitalEntity.getId());
	}

}
