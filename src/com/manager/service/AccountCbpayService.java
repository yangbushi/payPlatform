package com.manager.service;

import com.herenit.hhw.dao.pojo.MyPageBounds;
import com.herenit.hhw.dao.pojo.MyResults;
import com.manager.pageform.AccountAlipayInfo;
import com.manager.pageform.AccountCbpayInfo;

/**
 * 
 * @ClassName: AccountCbpay
 * @Description: 中国银行支付管理接口
 * @author yufei
 * @Date 2015-9-29 下午3:39:22
 */
public interface AccountCbpayService {

	public MyResults queryPaging(MyPageBounds myPageBounds,AccountCbpayInfo accountCbpay);

	public AccountCbpayInfo selectByPrimaryKey(Integer id);
	
	public AccountCbpayInfo selectByHospitalId(String hospitalId);

	public void save(AccountCbpayInfo accountCbpay);
	
	public void update(AccountCbpayInfo accountCbpay);

	public void deleteByPrimaryKey(Integer id);
}
