package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 物资申请
 *
 * @author 
 * @email
 */
@TableName("wuzi_shenqing")
public class WuziShenqingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public WuziShenqingEntity() {

	}

	public WuziShenqingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "xuesheng_id")

    private Integer xueshengId;


    /**
     * 物资
     */
    @ColumnInfo(comment="物资",type="int(11)")
    @TableField(value = "wuzi_id")

    private Integer wuziId;


    /**
     * 物资申请编号
     */
    @ColumnInfo(comment="物资申请编号",type="varchar(200)")
    @TableField(value = "wuzi_shenqing_uuid_number")

    private String wuziShenqingUuidNumber;


    /**
     * 物资申请类型
     */
    @ColumnInfo(comment="物资申请类型",type="int(11)")
    @TableField(value = "wuzi_shenqing_types")

    private Integer wuziShenqingTypes;


    /**
     * 申请缘由
     */
    @ColumnInfo(comment="申请缘由",type="text")
    @TableField(value = "wuzi_shenqing_content")

    private String wuziShenqingContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 申请数量
     */
    @ColumnInfo(comment="申请数量",type="int(11)")
    @TableField(value = "sheqing_number")

    private Integer sheqingNumber;


    /**
     * 预计归还时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预计归还时间",type="timestamp")
    @TableField(value = "yujiguihuan_time")

    private Date yujiguihuanTime;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "wuzi_shenqing_zhuangtai_types")

    private Integer wuziShenqingZhuangtaiTypes;


    /**
     * 审核状态
     */
    @ColumnInfo(comment="审核状态",type="int(11)")
    @TableField(value = "wuzi_shenqing_yesno_types")

    private Integer wuziShenqingYesnoTypes;


    /**
     * 审核意见
     */
    @ColumnInfo(comment="审核意见",type="text")
    @TableField(value = "wuzi_shenqing_yesno_text")

    private String wuziShenqingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "wuzi_shenqing_shenhe_time")

    private Date wuziShenqingShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：用户
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }
    /**
	 * 设置：用户
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：物资
	 */
    public Integer getWuziId() {
        return wuziId;
    }
    /**
	 * 设置：物资
	 */

    public void setWuziId(Integer wuziId) {
        this.wuziId = wuziId;
    }
    /**
	 * 获取：物资申请编号
	 */
    public String getWuziShenqingUuidNumber() {
        return wuziShenqingUuidNumber;
    }
    /**
	 * 设置：物资申请编号
	 */

    public void setWuziShenqingUuidNumber(String wuziShenqingUuidNumber) {
        this.wuziShenqingUuidNumber = wuziShenqingUuidNumber;
    }
    /**
	 * 获取：物资申请类型
	 */
    public Integer getWuziShenqingTypes() {
        return wuziShenqingTypes;
    }
    /**
	 * 设置：物资申请类型
	 */

    public void setWuziShenqingTypes(Integer wuziShenqingTypes) {
        this.wuziShenqingTypes = wuziShenqingTypes;
    }
    /**
	 * 获取：申请缘由
	 */
    public String getWuziShenqingContent() {
        return wuziShenqingContent;
    }
    /**
	 * 设置：申请缘由
	 */

    public void setWuziShenqingContent(String wuziShenqingContent) {
        this.wuziShenqingContent = wuziShenqingContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：申请数量
	 */
    public Integer getSheqingNumber() {
        return sheqingNumber;
    }
    /**
	 * 设置：申请数量
	 */

    public void setSheqingNumber(Integer sheqingNumber) {
        this.sheqingNumber = sheqingNumber;
    }
    /**
	 * 获取：预计归还时间
	 */
    public Date getYujiguihuanTime() {
        return yujiguihuanTime;
    }
    /**
	 * 设置：预计归还时间
	 */

    public void setYujiguihuanTime(Date yujiguihuanTime) {
        this.yujiguihuanTime = yujiguihuanTime;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getWuziShenqingZhuangtaiTypes() {
        return wuziShenqingZhuangtaiTypes;
    }
    /**
	 * 设置：申请状态
	 */

    public void setWuziShenqingZhuangtaiTypes(Integer wuziShenqingZhuangtaiTypes) {
        this.wuziShenqingZhuangtaiTypes = wuziShenqingZhuangtaiTypes;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getWuziShenqingYesnoTypes() {
        return wuziShenqingYesnoTypes;
    }
    /**
	 * 设置：审核状态
	 */

    public void setWuziShenqingYesnoTypes(Integer wuziShenqingYesnoTypes) {
        this.wuziShenqingYesnoTypes = wuziShenqingYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getWuziShenqingYesnoText() {
        return wuziShenqingYesnoText;
    }
    /**
	 * 设置：审核意见
	 */

    public void setWuziShenqingYesnoText(String wuziShenqingYesnoText) {
        this.wuziShenqingYesnoText = wuziShenqingYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getWuziShenqingShenheTime() {
        return wuziShenqingShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setWuziShenqingShenheTime(Date wuziShenqingShenheTime) {
        this.wuziShenqingShenheTime = wuziShenqingShenheTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "WuziShenqing{" +
            ", id=" + id +
            ", xueshengId=" + xueshengId +
            ", wuziId=" + wuziId +
            ", wuziShenqingUuidNumber=" + wuziShenqingUuidNumber +
            ", wuziShenqingTypes=" + wuziShenqingTypes +
            ", wuziShenqingContent=" + wuziShenqingContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", sheqingNumber=" + sheqingNumber +
            ", yujiguihuanTime=" + DateUtil.convertString(yujiguihuanTime,"yyyy-MM-dd") +
            ", wuziShenqingZhuangtaiTypes=" + wuziShenqingZhuangtaiTypes +
            ", wuziShenqingYesnoTypes=" + wuziShenqingYesnoTypes +
            ", wuziShenqingYesnoText=" + wuziShenqingYesnoText +
            ", wuziShenqingShenheTime=" + DateUtil.convertString(wuziShenqingShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
