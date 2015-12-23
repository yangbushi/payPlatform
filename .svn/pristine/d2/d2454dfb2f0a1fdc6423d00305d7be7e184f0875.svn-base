package com.manager.service;

import com.herenit.hhw.dao.pojo.MyPageBounds;
import com.herenit.hhw.dao.pojo.MyResults;
import com.manager.pageform.AccountAlipayInfo;

/**
 * 
 * @ClassName: AccountAlipayService
 * @Description: 阿里支付管理接口
 * @author yufei
 * @Date 2015-9-29 下午3:39:31
 */
public interface AccountAlipayService {

	
	public MyResults queryPaging(MyPageBounds myPageBounds,AccountAlipayInfo accountAlipay);

	public AccountAlipayInfo selectByPrimaryKey(Integer id);
	
	public AccountAlipayInfo selectByHospitalId(String hospitalId);

	public void save(AccountAlipayInfo accountAlipay);
	
	public void update(AccountAlipayInfo accountAlipay);

	public void deleteByPrimaryKey(Integer id);
	
}
