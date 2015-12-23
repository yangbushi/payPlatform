package com.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.defray.bean.RefundRecordEntity;
import com.defray.dao.RefundRecordMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.herenit.hhw.dao.pojo.MyPageBounds;
import com.herenit.hhw.dao.pojo.MyResults;
import com.manager.service.RefundRecordService;
public class RefundRecordServiceImpl implements RefundRecordService{
	@Autowired
	public RefundRecordMapper refundRecordMapper;

	@Override
	public MyResults queryPaging(RefundRecordEntity refundRecordEntity,
			MyPageBounds myPageBounds) {
		PageBounds pageBounds = new PageBounds();
		pageBounds.setPage(myPageBounds.getPage());
		pageBounds.setLimit(myPageBounds.getLimit());
		pageBounds.setOrders(myPageBounds.getOrders());
		
		PageList<RefundRecordEntity> list = refundRecordMapper.queryPaging(refundRecordEntity,pageBounds);
		
		MyResults res = new MyResults();
		res.setLimit(list.getPaginator().getLimit());
		res.setPage(list.getPaginator().getPage());
		res.setSize(list.size());
		res.setResult(list.toArray());
		res.setTotalCount(list.getPaginator().getTotalCount());
		return res;
	}

}