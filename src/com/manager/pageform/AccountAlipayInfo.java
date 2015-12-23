package com.manager.pageform;

import java.io.Serializable;

import com.defray.bean.AccountAlipayEntity;

/**
 * 
 * @ClassName: AccountAlipayInfo
 * @Description: 阿里支付页面展示类
 * @author yufei
 * @Date 2015-9-30 上午9:54:36
 */
public class AccountAlipayInfo extends AccountAlipayEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8522825531447906995L;

	private String hospitalName;
	
	private String defrayTypeName;

	public String getDefrayTypeName() {
		return defrayTypeName;
	}

	public void setDefrayTypeName(String defrayTypeName) {
		this.defrayTypeName = defrayTypeName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	
}
