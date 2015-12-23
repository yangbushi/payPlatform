package com.manager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.defray.dao.AccountCbpayMapper;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.herenit.hhw.dao.pojo.MyPageBounds;
import com.herenit.hhw.dao.pojo.MyResults;
import com.manager.pageform.AccountAlipayInfo;
import com.manager.pageform.AccountCbpayInfo;
import com.manager.service.AccountCbpayService;

/**
 * 
 * @ClassName: AccountCbpayImpl
 * @Description: 中国银行支付管理接口实现
 * @author yufei
 * @Date 2015-9-29 下午3:41:46
 */
@Service("accountCbpayService")
public class AccountCbpayServiceImpl implements AccountCbpayService{

	@Autowired
	AccountCbpayMapper accountCbpayDao;
	
	@Override
	public MyResults queryPaging(MyPageBounds myPageBounds,
			AccountCbpayInfo accountCbpay) {
		
		PageBounds pageBounds = new PageBounds();
		pageBounds.setPage(myPageBounds.getPage());
		pageBounds.setLimit(myPageBounds.getLimit());
		pageBounds.setOrders(myPageBounds.getOrders());
		//PageList<SmsInvoker> list = invokerMapper.queryPaging(smsInvoker,pageBounds);
		PageList<AccountCbpayInfo> list = accountCbpayDao.selectByModel(accountCbpay, pageBounds);
		MyResults res = new MyResults();
		res.setLimit(list.getPaginator().getLimit());
		res.setPage(list.getPaginator().getPage());
		res.setSize(list.size());
		res.setResult(list.toArray());
		res.setTotalCount(list.getPaginator().getTotalCount());
		return res;
	}

	@Override
	public AccountCbpayInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return accountCbpayDao.selectByPrimaryKey(id);
	}

	@Override
	public void save(AccountCbpayInfo accountCbpay) {
		// TODO Auto-generated method stub
		accountCbpayDao.insertSelective(accountCbpay);
	}

	@Override
	public void update(AccountCbpayInfo accountCbpay) {
		// TODO Auto-generated method stub
		accountCbpayDao.update(accountCbpay);
	}

	@Override
	public void deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		accountCbpayDao.deleteByKey(id);
	}

	@Override
	public AccountCbpayInfo selectByHospitalId(String hospitalId) {
		// TODO Auto-generated method stub
		return accountCbpayDao.selectByHospitalId(hospitalId);
	}

}
