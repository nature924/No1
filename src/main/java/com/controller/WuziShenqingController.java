
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 物资申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wuziShenqing")
public class WuziShenqingController {
    private static final Logger logger = LoggerFactory.getLogger(WuziShenqingController.class);

    private static final String TABLE_NAME = "wuziShenqing";

    @Autowired
    private WuziShenqingService wuziShenqingService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private LaoshiService laoshiService;//仓库管理员
    @Autowired
    private WuziService wuziService;//物资
    @Autowired
    private XueshengService xueshengService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        else if("仓库管理员".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = wuziShenqingService.queryPage(params);

        //字典表数据转换
        List<WuziShenqingView> list =(List<WuziShenqingView>)page.getList();
        for(WuziShenqingView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WuziShenqingEntity wuziShenqing = wuziShenqingService.selectById(id);
        if(wuziShenqing !=null){
            //entity转view
            WuziShenqingView view = new WuziShenqingView();
            BeanUtils.copyProperties( wuziShenqing , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            XueshengEntity xuesheng = xueshengService.selectById(wuziShenqing.getXueshengId());
            if(xuesheng != null){
            BeanUtils.copyProperties( xuesheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xueshengId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXueshengId(xuesheng.getId());
            }
            //级联表 物资
            //级联表
            WuziEntity wuzi = wuziService.selectById(wuziShenqing.getWuziId());
            if(wuzi != null){
            BeanUtils.copyProperties( wuzi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xueshengId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setWuziId(wuzi.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WuziShenqingEntity wuziShenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wuziShenqing:{}",this.getClass().getName(),wuziShenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role)){
            wuziShenqing.setWuziShenqingZhuangtaiTypes(1);
            wuziShenqing.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }

        WuziEntity wuziEntity = wuziService.selectById(wuziShenqing.getWuziId());
        if(wuziEntity == null){
            return R.error("查不到物资");
        }
        if(wuziEntity.getWuziKucunNumber()<wuziShenqing.getSheqingNumber())
            return R.error("申请数量大于库存数量,请核实后再申请");
        wuziShenqing.setInsertTime(new Date());
            wuziShenqing.setWuziShenqingYesnoTypes(1);
            wuziShenqing.setCreateTime(new Date());
            wuziShenqingService.insert(wuziShenqing);
            return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WuziShenqingEntity wuziShenqing, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wuziShenqing:{}",this.getClass().getName(),wuziShenqing.toString());
        WuziShenqingEntity oldWuziShenqingEntity = wuziShenqingService.selectById(wuziShenqing.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            wuziShenqing.setXueshengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            wuziShenqingService.updateById(wuziShenqing);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody WuziShenqingEntity wuziShenqingEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,wuziShenqingEntity:{}",this.getClass().getName(),wuziShenqingEntity.toString());

        WuziShenqingEntity oldWuziShenqing = wuziShenqingService.selectById(wuziShenqingEntity.getId());//查询原先数据

        if(wuziShenqingEntity.getWuziShenqingYesnoTypes() == 2){//通过
            wuziShenqingEntity.setWuziShenqingZhuangtaiTypes(3);

            WuziEntity wuziEntity = wuziService.selectById(oldWuziShenqing.getWuziId());
            if(wuziEntity == null){
                return R.error("查不到物资");
            }
            int balance = wuziEntity.getWuziKucunNumber() - oldWuziShenqing.getSheqingNumber();
            if(balance<0)
                return R.error("申请数量大于库存数量,请核实后再同意");
            wuziEntity.setWuziKucunNumber(balance);
            wuziService.updateById(wuziEntity);
        }else if(wuziShenqingEntity.getWuziShenqingYesnoTypes() == 3){//拒绝
            wuziShenqingEntity.setWuziShenqingZhuangtaiTypes(2);
        }
        wuziShenqingEntity.setWuziShenqingShenheTime(new Date());//审核时间
        wuziShenqingService.updateById(wuziShenqingEntity);//审核

        return R.ok();
    }




    /**
     * 归还
     */
    @RequestMapping("/guihuan")
    public R guihuan(Integer id, HttpServletRequest request){

        WuziShenqingEntity oldWuziShenqing = wuziShenqingService.selectById(id);//查询原先数据


            WuziEntity wuziEntity = wuziService.selectById(oldWuziShenqing.getWuziId());
            if(wuziEntity == null){
                return R.error("查不到物资");
            }
            wuziEntity.setWuziKucunNumber(wuziEntity.getWuziKucunNumber() + oldWuziShenqing.getSheqingNumber());
            wuziService.updateById(wuziEntity);

        oldWuziShenqing.setWuziShenqingZhuangtaiTypes(4);
        wuziShenqingService.updateById(oldWuziShenqing);
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WuziShenqingEntity> oldWuziShenqingList =wuziShenqingService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        wuziShenqingService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer xueshengId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<WuziShenqingEntity> wuziShenqingList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            WuziShenqingEntity wuziShenqingEntity = new WuziShenqingEntity();
//                            wuziShenqingEntity.setXueshengId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            wuziShenqingEntity.setWuziId(Integer.valueOf(data.get(0)));   //物资 要改的
//                            wuziShenqingEntity.setWuziShenqingUuidNumber(data.get(0));                    //物资申请编号 要改的
//                            wuziShenqingEntity.setWuziShenqingTypes(Integer.valueOf(data.get(0)));   //物资申请类型 要改的
//                            wuziShenqingEntity.setWuziShenqingContent("");//详情和图片
//                            wuziShenqingEntity.setInsertTime(date);//时间
//                            wuziShenqingEntity.setSheqingNumber(Integer.valueOf(data.get(0)));   //申请数量 要改的
//                            wuziShenqingEntity.setYujiguihuanTime(sdf.parse(data.get(0)));          //预计归还时间 要改的
//                            wuziShenqingEntity.setWuziShenqingZhuangtaiTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            wuziShenqingEntity.setWuziShenqingYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            wuziShenqingEntity.setWuziShenqingYesnoText(data.get(0));                    //审核意见 要改的
//                            wuziShenqingEntity.setWuziShenqingShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            wuziShenqingEntity.setCreateTime(date);//时间
                            wuziShenqingList.add(wuziShenqingEntity);


                            //把要查询是否重复的字段放入map中
                                //物资申请编号
                                if(seachFields.containsKey("wuziShenqingUuidNumber")){
                                    List<String> wuziShenqingUuidNumber = seachFields.get("wuziShenqingUuidNumber");
                                    wuziShenqingUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> wuziShenqingUuidNumber = new ArrayList<>();
                                    wuziShenqingUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("wuziShenqingUuidNumber",wuziShenqingUuidNumber);
                                }
                        }

                        //查询是否重复
                         //物资申请编号
                        List<WuziShenqingEntity> wuziShenqingEntities_wuziShenqingUuidNumber = wuziShenqingService.selectList(new EntityWrapper<WuziShenqingEntity>().in("wuzi_shenqing_uuid_number", seachFields.get("wuziShenqingUuidNumber")));
                        if(wuziShenqingEntities_wuziShenqingUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(WuziShenqingEntity s:wuziShenqingEntities_wuziShenqingUuidNumber){
                                repeatFields.add(s.getWuziShenqingUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [物资申请编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        wuziShenqingService.insertBatch(wuziShenqingList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

