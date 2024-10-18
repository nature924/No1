<template>
<div class="content">
  <div style="width: 100%;height: 100%" v-if="sessionTable!='users'">
    <div class="text main-text">欢迎使用 {{this.$project.projectName}}</div>
  </div>
  <div style="width: 100%;height: 100%;display:flex " v-if="sessionTable=='users'">
    <div style="width: 50%;height: 100%">
        <div id="statistic1" style="width:100%;height:600px;"></div>
    </div>
    <div style="width: 50%;height: 100%">
      <el-date-picker
          v-model="echartsDate"
          type="month"
          placeholder="选择月">
      </el-date-picker>
      <el-button @click="chartDialog2()">查询</el-button>
        <div id="statistic2" style="width:100%;height:600px;"></div>
    </div>
  </div>

</div>
</template>
<script>
import router from '@/router/router-static'
export default {
  data() {
    return {
      sessionTable : "",//登录账户所在表名
      role : "",//权限
      userId:"",//当前登录人的id

      echartsDate: new Date(),//echarts的时间查询字段


    };
  },
  mounted(){

    //获取当前登录用户的信息
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    this.userId = this.$storage.get("userId");

    this.init();
    this.chartDialog1();
    this.chartDialog2();
  },
  methods:{
    chartDialog1() {
      let _this = this;
      this.$nextTick(()=>{
        var statistic = this.$echarts.init(document.getElementById("statistic1"),'macarons');
        let params = {
          tableName: "wuzi",
          groupColumn: "wuzi_types",
        }
        this.$http({
          url: "newSelectGroupCount",//pieSum pieCount
          method: "get",
          params: params
        }).then(({data}) => {
          if (data && data.code === 0) {
            let res = data.data;
            let xAxis = [];
            let yAxis = [];
            let pArray = []
            var option = {};
            for(let i=0;i<res.length;i++){
              xAxis.push(res[i].name);
              yAxis.push(res[i].value);
              pArray.push({
                value: res[i].value,
                name: res[i].name
              })
              option = {
                title: {
                  text: '物资类型分布图',
                  left: 'center'
                },
                tooltip: {
                  trigger: 'item',
                  formatter: '{b} : {c} ({d}%)'
                },
                legend: {
                  orient: 'vertical',
                  left: 'left'
                },
                series: [
                  {
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: pArray,
                    emphasis: {
                      itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                      }
                    }
                  }
                ]
              };
            }
            statistic.setOption(option,true);
            window.onresize = function() {
              statistic.resize();
            };
          }
        });
      })
    },
    chartDialog2() {
      let _this = this;
      this.$nextTick(()=>{
        var statistic = this.$echarts.init(document.getElementById("statistic2"),'macarons');

        var year = _this.echartsDate.getFullYear();
        var month = _this.echartsDate.getMonth() + 1 < 10 ? '0' + (_this.echartsDate.getMonth() + 1) : _this.echartsDate.getMonth() + 1;
        var riqi=year + "-" + month;

        this.$http({
          url: "pieSum",//pieSum pieCount
          method: "get",
          params: {
            riqi :riqi
          }
        }).then(({data}) => {
          if (data && data.code === 0) {
            let res = data.data;
            let xAxis = [];
            let yAxis = [];
            let pArray = []
            var option = {};
            for(let i=0;i<res.length;i++){
              xAxis.push(res[i].name);
              yAxis.push(res[i].value);
              pArray.push({
                value: res[i].value,
                name: res[i].name
              })
              option = {
                title: {
                  text: '物资月度申请统计报表',
                  left: 'center'
                },
                tooltip: {
                  trigger: 'item',
                  formatter: '{b} : {c} ({d}%)'
                },
                legend: {
                  orient: 'vertical',
                  left: 'left'
                },
                series: [
                  {
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: pArray,
                    emphasis: {
                      itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                      }
                    }
                  }
                ]
              };
            }
            statistic.setOption(option,true);
            window.onresize = function() {
              statistic.resize();
            };
          }
        });
      })
    },
    init(){
        if(this.$storage.get('Token')){
        this.$http({
            url: `${this.$storage.get('sessionTable')}/session`,
            method: "get"
        }).then(({ data }) => {
            if (data && data.code != 0) {
            router.push({ name: 'login' })
            }
        });
        }else{
            router.push({ name: 'login' })
        }
    }
  }
};
</script>

<style lang="scss" scoped>
.content {
  display: flex;
  align-items: center;
  flex-direction: column;
  width: 100%;
  height: 100%;
  min-height: 500px;
  text-align: center;
  .main-text{
    font-size: 38px;
    font-weight: bold;
    margin-top: 15%;
  }
  .text {
    font-size: 24px;
    font-weight: bold;
    color: #333;
  }
}
</style>