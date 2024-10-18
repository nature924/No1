package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WuziEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 物资
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("wuzi")
public class WuziView extends WuziEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 物资类型的值
	*/
	@ColumnInfo(comment="物资类型的字典表值",type="varchar(200)")
	private String wuziValue;
	/**
	* 仓库的值
	*/
	@ColumnInfo(comment="仓库的字典表值",type="varchar(200)")
	private String cangkuValue;




	public WuziView() {

	}

	public WuziView(WuziEntity wuziEntity) {
		try {
			BeanUtils.copyProperties(this, wuziEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 物资类型的值
	*/
	public String getWuziValue() {
		return wuziValue;
	}
	/**
	* 设置： 物资类型的值
	*/
	public void setWuziValue(String wuziValue) {
		this.wuziValue = wuziValue;
	}
	//当前表的
	/**
	* 获取： 仓库的值
	*/
	public String getCangkuValue() {
		return cangkuValue;
	}
	/**
	* 设置： 仓库的值
	*/
	public void setCangkuValue(String cangkuValue) {
		this.cangkuValue = cangkuValue;
	}




	@Override
	public String toString() {
		return "WuziView{" +
			", wuziValue=" + wuziValue +
			", cangkuValue=" + cangkuValue +
			"} " + super.toString();
	}
}
