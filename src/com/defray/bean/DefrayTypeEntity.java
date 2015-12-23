package com.defray.bean;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;

 
public class DefrayTypeEntity implements Serializable{

	/** Comment for <code>serialVersionUID</code> */
	private static final long serialVersionUID = -1L;

	//========== properties ==========
	
	//ID
	private Integer id;
	private String defrayTypeCode;
	//支付类型名称
	private String defrayTypeName;
	//创建时间
	private Date createTime;
	//修改时间
	private Date updateTime;
	//删除标识（0：未删除，1：已删除）
	private Integer isDel;

    //========== getters and setters ==========
    
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDefrayTypeName() {
		return defrayTypeName;
	}
	
	public void setDefrayTypeName(String defrayTypeName) {
		this.defrayTypeName = defrayTypeName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getIsDel() {
		return isDel;
	}
	
	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public String getDefrayTypeCode() {
		return defrayTypeCode;
	}

	public void setDefrayTypeCode(String defrayTypeCode) {
		this.defrayTypeCode = defrayTypeCode;
	}

	/**
	* 重载toString方法
	* @return
	*
	* @see java.lang.Object#toString()
	*/
	@Override
    public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

