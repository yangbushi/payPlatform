package com.manager.service;

import com.defray.bean.RefundRecordEntity;
import com.herenit.hhw.dao.pojo.MyPageBounds;
import com.herenit.hhw.dao.pojo.MyResults;

public interface RefundRecordService {
	
	public MyResults queryPaging(RefundRecordEntity refundRecordEntity,MyPageBounds myPageBounds);
}
