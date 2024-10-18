package com.dao;

import com.entity.WuziShenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WuziShenqingView;

/**
 * 物资申请 Dao 接口
 *
 * @author 
 */
public interface WuziShenqingDao extends BaseMapper<WuziShenqingEntity> {

   List<WuziShenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
