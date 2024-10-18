package com.entity.vo;

import com.entity.WuziShenqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 物资申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wuzi_shenqing")
public class WuziShenqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "xuesheng_id")
    private Integer xueshengId;


    /**
     * 物资申请编号
     */

    @TableField(value = "wuzi_shenqing_uuid_number")
    private String wuziShenqingUuidNumber;


    /**
     * 物资申请类型
     */

    @TableField(value = "wuzi_shenqing_types")
    private Integer wuziShenqingTypes;


    /**
     * 申请缘由
     */

    @TableField(value = "wuzi_shenqing_content")
    private String wuziShenqingContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 申请数量
     */

    @TableField(value = "sheqing_number")
    private Integer sheqingNumber;


    /**
     * 预计归还时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yujiguihuan_time")
    private Date yujiguihuanTime;


    /**
     * 申请状态
     */

    @TableField(value = "wuzi_shenqing_zhuangtai_types")
    private Integer wuziShenqingZhuangtaiTypes;


    /**
     * 审核状态
     */

    @TableField(value = "wuzi_shenqing_yesno_types")
    private Integer wuziShenqingYesnoTypes;


    /**
     * 审核意见
     */

    @TableField(value = "wuzi_shenqing_yesno_text")
    private String wuziShenqingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "wuzi_shenqing_shenhe_time")
    private Date wuziShenqingShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：用户
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 获取：用户
	 */

    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 设置：物资申请编号
	 */
    public String getWuziShenqingUuidNumber() {
        return wuziShenqingUuidNumber;
    }


    /**
	 * 获取：物资申请编号
	 */

    public void setWuziShenqingUuidNumber(String wuziShenqingUuidNumber) {
        this.wuziShenqingUuidNumber = wuziShenqingUuidNumber;
    }
    /**
	 * 设置：物资申请类型
	 */
    public Integer getWuziShenqingTypes() {
        return wuziShenqingTypes;
    }


    /**
	 * 获取：物资申请类型
	 */

    public void setWuziShenqingTypes(Integer wuziShenqingTypes) {
        this.wuziShenqingTypes = wuziShenqingTypes;
    }
    /**
	 * 设置：申请缘由
	 */
    public String getWuziShenqingContent() {
        return wuziShenqingContent;
    }


    /**
	 * 获取：申请缘由
	 */

    public void setWuziShenqingContent(String wuziShenqingContent) {
        this.wuziShenqingContent = wuziShenqingContent;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：申请数量
	 */
    public Integer getSheqingNumber() {
        return sheqingNumber;
    }


    /**
	 * 获取：申请数量
	 */

    public void setSheqingNumber(Integer sheqingNumber) {
        this.sheqingNumber = sheqingNumber;
    }
    /**
	 * 设置：预计归还时间
	 */
    public Date getYujiguihuanTime() {
        return yujiguihuanTime;
    }


    /**
	 * 获取：预计归还时间
	 */

    public void setYujiguihuanTime(Date yujiguihuanTime) {
        this.yujiguihuanTime = yujiguihuanTime;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getWuziShenqingZhuangtaiTypes() {
        return wuziShenqingZhuangtaiTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setWuziShenqingZhuangtaiTypes(Integer wuziShenqingZhuangtaiTypes) {
        this.wuziShenqingZhuangtaiTypes = wuziShenqingZhuangtaiTypes;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getWuziShenqingYesnoTypes() {
        return wuziShenqingYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setWuziShenqingYesnoTypes(Integer wuziShenqingYesnoTypes) {
        this.wuziShenqingYesnoTypes = wuziShenqingYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getWuziShenqingYesnoText() {
        return wuziShenqingYesnoText;
    }


    /**
	 * 获取：审核意见
	 */

    public void setWuziShenqingYesnoText(String wuziShenqingYesnoText) {
        this.wuziShenqingYesnoText = wuziShenqingYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getWuziShenqingShenheTime() {
        return wuziShenqingShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setWuziShenqingShenheTime(Date wuziShenqingShenheTime) {
        this.wuziShenqingShenheTime = wuziShenqingShenheTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
