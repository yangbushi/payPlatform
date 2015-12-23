package com.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.defray.bean.DefrayRecordEntity;
import com.defray.dao.DefrayRecordMapper;
import com.manager.service.DefrayRecordService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.herenit.hhw.dao.pojo.MyPageBounds;
import com.herenit.hhw.dao.pojo.MyResults;
public class DefrayRecordServiceImpl implements DefrayRecordService{
	@Autowired
	public DefrayRecordMapper defrayRecordMapper;

	@Override
	public MyResults queryPaging(DefrayRecordEntity defrayRecordEntity,
			MyPageBounds myPageBounds) {
		PageBounds pageBounds = new PageBounds();
		pageBounds.setPage(myPageBounds.getPage());
		pageBounds.setLimit(myPageBounds.getLimit());
		pageBounds.setOrders(myPageBounds.getOrders());
		
		PageList<DefrayRecordEntity> list = defrayRecordMapper.queryPaging(defrayRecordEntity,pageBounds);
		
		MyResults res = new MyResults();
		res.setLimit(list.getPaginator().getLimit());
		res.setPage(list.getPaginator().getPage());
		res.setSize(list.size());
		res.setResult(list.toArray());
		res.setTotalCount(list.getPaginator().getTotalCount());
		return res;
	}

}
