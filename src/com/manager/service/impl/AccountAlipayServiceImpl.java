package com.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defray.dao.AccountAlipayMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.herenit.hhw.dao.pojo.MyPageBounds;
import com.herenit.hhw.dao.pojo.MyResults;
import com.manager.pageform.AccountAlipayInfo;
import com.manager.service.AccountAlipayService;

/**
 * 
 * @ClassName: AccountAlipayServiceImpl
 * @Description: 阿里支付管理接口实现
 * @author yufei
 * @Date 2015-9-29 下午3:41:51
 */
@Service("accountAlipayService")
public class AccountAlipayServiceImpl implements AccountAlipayService{

	@Autowired
	AccountAlipayMapper accountAlipayDao;

	@Override
	public MyResults queryPaging(MyPageBounds myPageBounds,
			AccountAlipayInfo accountAlipay) {
		// TODO Auto-generated method stub
		PageBounds pageBounds = new PageBounds();
		pageBounds.setPage(myPageBounds.getPage());
		pageBounds.setLimit(myPageBounds.getLimit());
		pageBounds.setOrders(myPageBounds.getOrders());
		//PageList<SmsInvoker> list = invokerMapper.queryPaging(smsInvoker,pageBounds);
		PageList<AccountAlipayInfo> list = accountAlipayDao.selectByModel(accountAlipay, pageBounds);
		MyResults res = new MyResults();
		res.setLimit(list.getPaginator().getLimit());
		res.setPage(list.getPaginator().getPage());
		res.setSize(list.size());
		res.setResult(list.toArray());
		res.setTotalCount(list.getPaginator().getTotalCount());
		return res;
	}

	@Override
	public AccountAlipayInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return accountAlipayDao.selectByPrimaryKey(id);
	}

	@Override
	public void save(AccountAlipayInfo accountAlipay) {
		// TODO Auto-generated method stub
		accountAlipayDao.insertSelective(accountAlipay);
	}

	@Override
	public void update(AccountAlipayInfo accountAlipay) {
		// TODO Auto-generated method stub
		accountAlipayDao.update(accountAlipay);
	}

	@Override
	public void deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		accountAlipayDao.deleteByKey(id);
	}

	@Override
	public AccountAlipayInfo selectByHospitalId(String hospitalId) {
		// TODO Auto-generated method stub
		return accountAlipayDao.selectByHospitalId(hospitalId);
	}

}
