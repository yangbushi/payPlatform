package com.manager.service;

import java.util.List;

import com.defray.bean.DefrayTypeEntity;
import com.herenit.hhw.dao.pojo.MyPageBounds;
import com.herenit.hhw.dao.pojo.MyResults;

public interface DefrayTypeService {
	public MyResults queryPaging(DefrayTypeEntity defrayTypeEntity,MyPageBounds myPageBounds);
	
	/**
     * 根据id主键获取
     * @param defrayTypeEntity
     * @return
     */
    public DefrayTypeEntity selectById(Integer id);
    
    /**
     * 根据条件组合查询
     * @param defrayTypeEntity
     * @return
     */
    public List<DefrayTypeEntity> selectByDistinctDefrayTypeName(DefrayTypeEntity defrayTypeEntity);
    
    /**
     * 根据条件组合查询
     * @param defrayTypeEntity
     * @return
     */
    public List<DefrayTypeEntity> selectByModel(DefrayTypeEntity defrayTypeEntity);
    
    /**
     * 保存支付类型
     * @param defrayTypeEntity
     * @return
     */
    public Integer save(DefrayTypeEntity defrayTypeEntity);
    
    
    /**
     * 删除支付类型
     * @param defrayTypeEntity
     */
    public void deleteById(DefrayTypeEntity defrayTypeEntity);
}
