package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.WuziShenqingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 物资申请
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("wuzi_shenqing")
public class WuziShenqingView extends WuziShenqingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 物资申请类型的值
	*/
	@ColumnInfo(comment="物资申请类型的字典表值",type="varchar(200)")
	private String wuziShenqingValue;
	/**
	* 申请状态的值
	*/
	@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
	private String wuziShenqingZhuangtaiValue;
	/**
	* 审核状态的值
	*/
	@ColumnInfo(comment="审核状态的字典表值",type="varchar(200)")
	private String wuziShenqingYesnoValue;

	//级联表 物资
		/**
		* 物资编号
		*/

		@ColumnInfo(comment="物资编号",type="varchar(200)")
		private String wuziUuidNumber;
		/**
		* 物资名称
		*/

		@ColumnInfo(comment="物资名称",type="varchar(200)")
		private String wuziName;
		/**
		* 物资照片
		*/

		@ColumnInfo(comment="物资照片",type="varchar(200)")
		private String wuziPhoto;
		/**
		* 单位
		*/

		@ColumnInfo(comment="单位",type="varchar(200)")
		private String wuziDanwei;
		/**
		* 物资类型
		*/
		@ColumnInfo(comment="物资类型",type="int(11)")
		private Integer wuziTypes;
			/**
			* 物资类型的值
			*/
			@ColumnInfo(comment="物资类型的字典表值",type="varchar(200)")
			private String wuziValue;
		/**
		* 物资数量
		*/

		@ColumnInfo(comment="物资数量",type="int(11)")
		private Integer wuziKucunNumber;
		/**
		* 警戒值
		*/

		@ColumnInfo(comment="警戒值",type="int(11)")
		private Integer wuziYuzhi;
		/**
		* 仓库
		*/
		@ColumnInfo(comment="仓库",type="int(11)")
		private Integer cangkuTypes;
			/**
			* 仓库的值
			*/
			@ColumnInfo(comment="仓库的字典表值",type="varchar(200)")
			private String cangkuValue;
		/**
		* 物资介绍
		*/

		@ColumnInfo(comment="物资介绍",type="text")
		private String wuziContent;
	//级联表 用户
		/**
		* 学号
		*/

		@ColumnInfo(comment="学号",type="varchar(200)")
		private String xueshengUuidNumber;
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String xueshengName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String xueshengPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String xueshengIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String xueshengPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String xueshengEmail;
		/**
		* 用户住址
		*/

		@ColumnInfo(comment="用户住址",type="varchar(200)")
		private String xueshengAddress;



	public WuziShenqingView() {

	}

	public WuziShenqingView(WuziShenqingEntity wuziShenqingEntity) {
		try {
			BeanUtils.copyProperties(this, wuziShenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 物资申请类型的值
	*/
	public String getWuziShenqingValue() {
		return wuziShenqingValue;
	}
	/**
	* 设置： 物资申请类型的值
	*/
	public void setWuziShenqingValue(String wuziShenqingValue) {
		this.wuziShenqingValue = wuziShenqingValue;
	}
	//当前表的
	/**
	* 获取： 申请状态的值
	*/
	public String getWuziShenqingZhuangtaiValue() {
		return wuziShenqingZhuangtaiValue;
	}
	/**
	* 设置： 申请状态的值
	*/
	public void setWuziShenqingZhuangtaiValue(String wuziShenqingZhuangtaiValue) {
		this.wuziShenqingZhuangtaiValue = wuziShenqingZhuangtaiValue;
	}
	//当前表的
	/**
	* 获取： 审核状态的值
	*/
	public String getWuziShenqingYesnoValue() {
		return wuziShenqingYesnoValue;
	}
	/**
	* 设置： 审核状态的值
	*/
	public void setWuziShenqingYesnoValue(String wuziShenqingYesnoValue) {
		this.wuziShenqingYesnoValue = wuziShenqingYesnoValue;
	}


	//级联表的get和set 物资

		/**
		* 获取： 物资编号
		*/
		public String getWuziUuidNumber() {
			return wuziUuidNumber;
		}
		/**
		* 设置： 物资编号
		*/
		public void setWuziUuidNumber(String wuziUuidNumber) {
			this.wuziUuidNumber = wuziUuidNumber;
		}

		/**
		* 获取： 物资名称
		*/
		public String getWuziName() {
			return wuziName;
		}
		/**
		* 设置： 物资名称
		*/
		public void setWuziName(String wuziName) {
			this.wuziName = wuziName;
		}

		/**
		* 获取： 物资照片
		*/
		public String getWuziPhoto() {
			return wuziPhoto;
		}
		/**
		* 设置： 物资照片
		*/
		public void setWuziPhoto(String wuziPhoto) {
			this.wuziPhoto = wuziPhoto;
		}

		/**
		* 获取： 单位
		*/
		public String getWuziDanwei() {
			return wuziDanwei;
		}
		/**
		* 设置： 单位
		*/
		public void setWuziDanwei(String wuziDanwei) {
			this.wuziDanwei = wuziDanwei;
		}
		/**
		* 获取： 物资类型
		*/
		public Integer getWuziTypes() {
			return wuziTypes;
		}
		/**
		* 设置： 物资类型
		*/
		public void setWuziTypes(Integer wuziTypes) {
			this.wuziTypes = wuziTypes;
		}


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

		/**
		* 获取： 物资数量
		*/
		public Integer getWuziKucunNumber() {
			return wuziKucunNumber;
		}
		/**
		* 设置： 物资数量
		*/
		public void setWuziKucunNumber(Integer wuziKucunNumber) {
			this.wuziKucunNumber = wuziKucunNumber;
		}

		/**
		* 获取： 警戒值
		*/
		public Integer getWuziYuzhi() {
			return wuziYuzhi;
		}
		/**
		* 设置： 警戒值
		*/
		public void setWuziYuzhi(Integer wuziYuzhi) {
			this.wuziYuzhi = wuziYuzhi;
		}
		/**
		* 获取： 仓库
		*/
		public Integer getCangkuTypes() {
			return cangkuTypes;
		}
		/**
		* 设置： 仓库
		*/
		public void setCangkuTypes(Integer cangkuTypes) {
			this.cangkuTypes = cangkuTypes;
		}


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

		/**
		* 获取： 物资介绍
		*/
		public String getWuziContent() {
			return wuziContent;
		}
		/**
		* 设置： 物资介绍
		*/
		public void setWuziContent(String wuziContent) {
			this.wuziContent = wuziContent;
		}
	//级联表的get和set 用户

		/**
		* 获取： 学号
		*/
		public String getXueshengUuidNumber() {
			return xueshengUuidNumber;
		}
		/**
		* 设置： 学号
		*/
		public void setXueshengUuidNumber(String xueshengUuidNumber) {
			this.xueshengUuidNumber = xueshengUuidNumber;
		}

		/**
		* 获取： 用户姓名
		*/
		public String getXueshengName() {
			return xueshengName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setXueshengName(String xueshengName) {
			this.xueshengName = xueshengName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getXueshengPhone() {
			return xueshengPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setXueshengPhone(String xueshengPhone) {
			this.xueshengPhone = xueshengPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getXueshengIdNumber() {
			return xueshengIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setXueshengIdNumber(String xueshengIdNumber) {
			this.xueshengIdNumber = xueshengIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getXueshengPhoto() {
			return xueshengPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setXueshengPhoto(String xueshengPhoto) {
			this.xueshengPhoto = xueshengPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getXueshengEmail() {
			return xueshengEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setXueshengEmail(String xueshengEmail) {
			this.xueshengEmail = xueshengEmail;
		}

		/**
		* 获取： 用户住址
		*/
		public String getXueshengAddress() {
			return xueshengAddress;
		}
		/**
		* 设置： 用户住址
		*/
		public void setXueshengAddress(String xueshengAddress) {
			this.xueshengAddress = xueshengAddress;
		}


	@Override
	public String toString() {
		return "WuziShenqingView{" +
			", wuziShenqingValue=" + wuziShenqingValue +
			", wuziShenqingZhuangtaiValue=" + wuziShenqingZhuangtaiValue +
			", wuziShenqingYesnoValue=" + wuziShenqingYesnoValue +
			", xueshengUuidNumber=" + xueshengUuidNumber +
			", xueshengName=" + xueshengName +
			", xueshengPhone=" + xueshengPhone +
			", xueshengIdNumber=" + xueshengIdNumber +
			", xueshengPhoto=" + xueshengPhoto +
			", xueshengEmail=" + xueshengEmail +
			", xueshengAddress=" + xueshengAddress +
			", wuziUuidNumber=" + wuziUuidNumber +
			", wuziName=" + wuziName +
			", wuziPhoto=" + wuziPhoto +
			", wuziDanwei=" + wuziDanwei +
			", wuziKucunNumber=" + wuziKucunNumber +
			", wuziYuzhi=" + wuziYuzhi +
			", wuziContent=" + wuziContent +
			"} " + super.toString();
	}
}
