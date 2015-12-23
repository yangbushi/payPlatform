package com.manager.service;

import java.util.List;

import com.defray.bean.HospitalEntity;
import com.herenit.hhw.dao.pojo.MyPageBounds;
import com.herenit.hhw.dao.pojo.MyResults;

public interface HospitalService {
	public MyResults queryPaging(HospitalEntity hospitalEntity,MyPageBounds myPageBounds);
	
	/**
     * 根据id主键获取
     * @param hospitalEntity
     * @return
     */
    public HospitalEntity selectById(Integer id);
    
    /**
     * 根据条件组合查询
     * @param hospitalEntity
     * @return
     */
    public List<HospitalEntity> selectByModel(HospitalEntity hospitalEntity);
    
    /**
     * 保存医院支付类型
     * @param hospitalEntity
     * @return
     */
    public Integer save(HospitalEntity hospitalEntity);
    
    
    /**
     * 删除医院支付类型
     * @param hospitalEntity
     */
    public void deleteById(HospitalEntity hospitalEntity);
}
