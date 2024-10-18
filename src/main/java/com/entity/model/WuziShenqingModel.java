package com.entity.model;

import com.entity.WuziShenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 物资申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WuziShenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer xueshengId;


    /**
     * 物资申请编号
     */
    private String wuziShenqingUuidNumber;


    /**
     * 物资申请类型
     */
    private Integer wuziShenqingTypes;


    /**
     * 申请缘由
     */
    private String wuziShenqingContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 申请数量
     */
    private Integer sheqingNumber;


    /**
     * 预计归还时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yujiguihuanTime;


    /**
     * 申请状态
     */
    private Integer wuziShenqingZhuangtaiTypes;


    /**
     * 审核状态
     */
    private Integer wuziShenqingYesnoTypes;


    /**
     * 审核意见
     */
    private String wuziShenqingYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date wuziShenqingShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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

    }
