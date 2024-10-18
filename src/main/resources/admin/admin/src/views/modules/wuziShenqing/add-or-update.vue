<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                >
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='wuzi'">
                    <el-form-item class="select" v-if="type!='info'"  label="物资" prop="wuziId">
                        <el-select v-model="ruleForm.wuziId" :disabled="ro.wuziId" filterable placeholder="请选择物资" @change="wuziChange">
                            <el-option
                                    v-for="(item,index) in wuziOptions"
                                    v-bind:key="item.id"
                                    :label="item.wuziName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='wuzi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="物资编号" prop="wuziUuidNumber">
                        <el-input v-model="wuziForm.wuziUuidNumber"
                                  placeholder="物资编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="物资编号" prop="wuziUuidNumber">
                            <el-input v-model="ruleForm.wuziUuidNumber"
                                      placeholder="物资编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='wuzi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="物资名称" prop="wuziName">
                        <el-input v-model="wuziForm.wuziName"
                                  placeholder="物资名称" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="物资名称" prop="wuziName">
                            <el-input v-model="ruleForm.wuziName"
                                      placeholder="物资名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='wuzi' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.wuziPhoto" label="物资照片" prop="wuziPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (wuziForm.wuziPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.wuziPhoto" label="物资照片" prop="wuziPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.wuziPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='wuzi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="单位" prop="wuziDanwei">
                        <el-input v-model="wuziForm.wuziDanwei"
                                  placeholder="单位" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="单位" prop="wuziDanwei">
                            <el-input v-model="ruleForm.wuziDanwei"
                                      placeholder="单位" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='wuzi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="物资类型" prop="wuziValue">
                        <el-input v-model="wuziForm.wuziValue"
                                  placeholder="物资类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="物资类型" prop="wuziValue">
                            <el-input v-model="ruleForm.wuziValue"
                                      placeholder="物资类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='wuzi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="物资数量" prop="wuziKucunNumber">
                        <el-input v-model="wuziForm.wuziKucunNumber"
                                  placeholder="物资数量" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="物资数量" prop="wuziKucunNumber">
                            <el-input v-model="ruleForm.wuziKucunNumber"
                                      placeholder="物资数量" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='wuzi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="警戒值" prop="wuziYuzhi">
                        <el-input v-model="wuziForm.wuziYuzhi"
                                  placeholder="警戒值" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="警戒值" prop="wuziYuzhi">
                            <el-input v-model="ruleForm.wuziYuzhi"
                                      placeholder="警戒值" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='wuzi' ">
                    <el-form-item class="input" v-if="type!='info'"  label="仓库" prop="cangkuValue">
                        <el-input v-model="wuziForm.cangkuValue"
                                  placeholder="仓库" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="仓库" prop="cangkuValue">
                            <el-input v-model="ruleForm.cangkuValue"
                                      placeholder="仓库" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xuesheng'">
                    <el-form-item class="select" v-if="type!='info'"  label="用户" prop="xueshengId">
                        <el-select v-model="ruleForm.xueshengId" :disabled="ro.xueshengId" filterable placeholder="请选择用户" @change="xueshengChange">
                            <el-option
                                    v-for="(item,index) in xueshengOptions"
                                    v-bind:key="item.id"
                                    :label="item.xueshengName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='xuesheng' ">
                    <el-form-item class="input" v-if="type!='info'"  label="学号" prop="xueshengUuidNumber">
                        <el-input v-model="xueshengForm.xueshengUuidNumber"
                                  placeholder="学号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="学号" prop="xueshengUuidNumber">
                            <el-input v-model="ruleForm.xueshengUuidNumber"
                                      placeholder="学号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xuesheng' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户姓名" prop="xueshengName">
                        <el-input v-model="xueshengForm.xueshengName"
                                  placeholder="用户姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户姓名" prop="xueshengName">
                            <el-input v-model="ruleForm.xueshengName"
                                      placeholder="用户姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xuesheng' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户手机号" prop="xueshengPhone">
                        <el-input v-model="xueshengForm.xueshengPhone"
                                  placeholder="用户手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户手机号" prop="xueshengPhone">
                            <el-input v-model="ruleForm.xueshengPhone"
                                      placeholder="用户手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xuesheng' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户身份证号" prop="xueshengIdNumber">
                        <el-input v-model="xueshengForm.xueshengIdNumber"
                                  placeholder="用户身份证号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户身份证号" prop="xueshengIdNumber">
                            <el-input v-model="ruleForm.xueshengIdNumber"
                                      placeholder="用户身份证号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='xuesheng' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.xueshengPhoto" label="用户头像" prop="xueshengPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (xueshengForm.xueshengPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.xueshengPhoto" label="用户头像" prop="xueshengPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.xueshengPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xuesheng' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户邮箱" prop="xueshengEmail">
                        <el-input v-model="xueshengForm.xueshengEmail"
                                  placeholder="用户邮箱" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户邮箱" prop="xueshengEmail">
                            <el-input v-model="ruleForm.xueshengEmail"
                                      placeholder="用户邮箱" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='xuesheng' ">
                    <el-form-item class="input" v-if="type!='info'"  label="用户住址" prop="xueshengAddress">
                        <el-input v-model="xueshengForm.xueshengAddress"
                                  placeholder="用户住址" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="用户住址" prop="xueshengAddress">
                            <el-input v-model="ruleForm.xueshengAddress"
                                      placeholder="用户住址" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="xueshengId" name="xueshengId" type="hidden">
            <input id="wuziId" name="wuziId" type="hidden">
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="物资申请编号" prop="wuziShenqingUuidNumber">
                       <el-input v-model="ruleForm.wuziShenqingUuidNumber"
                                 placeholder="物资申请编号" clearable  :readonly="ro.wuziShenqingUuidNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="物资申请编号" prop="wuziShenqingUuidNumber">
                           <el-input v-model="ruleForm.wuziShenqingUuidNumber"
                                     placeholder="物资申请编号" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'"  label="物资申请类型" prop="wuziShenqingTypes">
                        <el-select v-model="ruleForm.wuziShenqingTypes" :disabled="ro.wuziShenqingTypes" placeholder="请选择物资申请类型">
                            <el-option
                                v-for="(item,index) in wuziShenqingTypesOptions"
                                v-bind:key="item.codeIndex"
                                :label="item.indexName"
                                :value="item.codeIndex">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="物资申请类型" prop="wuziShenqingValue">
                        <el-input v-model="ruleForm.wuziShenqingValue"
                            placeholder="物资申请类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item v-if="type!='info'"  label="申请缘由" prop="wuziShenqingContent">
                        <editor style="min-width: 200px; max-width: 600px;"
                                v-model="ruleForm.wuziShenqingContent"
                                class="editor"
                                action="file/upload">
                        </editor>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.wuziShenqingContent" label="申请缘由" prop="wuziShenqingContent">
                            <span v-html="ruleForm.wuziShenqingContent"></span>
                        </el-form-item>
                    </div>
                </el-col>
               <el-col :span="12">
                   <el-form-item class="input" v-if="type!='info'"  label="申请数量" prop="sheqingNumber">
                       <el-input v-model="ruleForm.sheqingNumber"
                                 placeholder="申请数量" clearable  :readonly="ro.sheqingNumber"></el-input>
                   </el-form-item>
                   <div v-else-if="type=='info'">
                       <el-form-item class="input" label="申请数量" prop="sheqingNumber">
                           <el-input v-model="ruleForm.sheqingNumber"
                                     placeholder="申请数量" readonly></el-input>
                       </el-form-item>
                   </div>
               </el-col>
                <el-col :span="12">
                    <el-form-item v-if="type!='info'"  class="input" label="预计归还时间" prop="yujiguihuanTime">
                        <el-date-picker
                                value-format="yyyy-MM-dd HH:mm:ss"
                                v-model="ruleForm.yujiguihuanTime"
                                type="datetime"
                                placeholder="预计归还时间"
                                :disabled="ro.yujiguihuanTime">
                        </el-date-picker>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.yujiguihuanTime" label="预计归还时间" prop="yujiguihuanTime">
                            <span v-html="ruleForm.yujiguihuanTime"></span>
                        </el-form-item>
                    </div>
                </el-col>

                <el-col :span="12" v-if="type=='info'">
                    <div>
                        <el-form-item class="input" label="申请状态" prop="wuziShenqingZhuangtaiValue">
                        <el-input v-model="ruleForm.wuziShenqingZhuangtaiValue"
                            placeholder="申请状态" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.wuziShenqingYesnoTypes" label="审核状态" prop="wuziShenqingYesnoTypes">
                        <el-input v-model="ruleForm.wuziShenqingYesnoValue" placeholder="审核状态" readonly></el-input>
                    </el-form-item>
                </div>
            </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.wuziShenqingYesnoText" label="审核意见" prop="wuziShenqingYesnoText">
                        <span v-html="ruleForm.wuziShenqingYesnoText"></span>
                    </el-form-item>
                </div>
            </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.wuziShenqingShenheTime" label="审核时间" prop="wuziShenqingShenheTime">
                        <span v-html="ruleForm.wuziShenqingShenheTime"></span>
                    </el-form-item>
                </div>
            </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                wuziForm: {},
                xueshengForm: {},
                ro:{
                    xueshengId: false,
                    wuziId: false,
                    wuziShenqingUuidNumber: false,
                    wuziShenqingTypes: false,
                    wuziShenqingContent: false,
                    insertTime: false,
                    sheqingNumber: false,
                    yujiguihuanTime: false,
                    wuziShenqingZhuangtaiTypes: false,
                    wuziShenqingYesnoTypes: false,
                    wuziShenqingYesnoText: false,
                    wuziShenqingShenheTime: false,
                },
                ruleForm: {
                    xueshengId: '',
                    wuziId: '',
                    wuziShenqingUuidNumber: new Date().getTime(),
                    wuziShenqingTypes: '',
                    wuziShenqingContent: '',
                    insertTime: '',
                    sheqingNumber: '',
                    yujiguihuanTime: '',
                    wuziShenqingZhuangtaiTypes: '',
                    wuziShenqingYesnoTypes: '',
                    wuziShenqingYesnoText: '',
                    wuziShenqingShenheTime: '',
                },
                wuziShenqingTypesOptions : [],
                wuziShenqingZhuangtaiTypesOptions : [],
                wuziShenqingYesnoTypesOptions : [],
                wuziOptions : [],
                xueshengOptions : [],
                rules: {
                   xueshengId: [
                              { required: true, message: '用户不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   wuziId: [
                              { required: true, message: '物资不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   wuziShenqingUuidNumber: [
                              { required: true, message: '物资申请编号不能为空', trigger: 'blur' },
                          ],
                   wuziShenqingTypes: [
                              { required: true, message: '物资申请类型不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   wuziShenqingContent: [
                              { required: true, message: '申请缘由不能为空', trigger: 'blur' },
                          ],
                   insertTime: [
                              { required: true, message: '申请时间不能为空', trigger: 'blur' },
                          ],
                   sheqingNumber: [
                              { required: true, message: '申请数量不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   yujiguihuanTime: [
                              { required: true, message: '预计归还时间不能为空', trigger: 'blur' },
                          ],
                   wuziShenqingZhuangtaiTypes: [
                              { required: true, message: '申请状态不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   wuziShenqingYesnoTypes: [
                              { required: true, message: '审核状态不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   wuziShenqingYesnoText: [
                              { required: true, message: '审核意见不能为空', trigger: 'blur' },
                          ],
                   wuziShenqingShenheTime: [
                              { required: true, message: '审核时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=wuzi_shenqing_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.wuziShenqingTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=wuzi_shenqing_zhuangtai_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.wuziShenqingZhuangtaiTypesOptions = data.data.list;
                    }
                });
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=wuzi_shenqing_yesno_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.wuziShenqingYesnoTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `wuzi/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.wuziOptions = data.data.list;
            }
         });
         this.$http({
             url: `xuesheng/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.xueshengOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            wuziChange(id){
                this.$http({
                    url: `wuzi/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.wuziForm = data.data;
                    }
                });
            },
            xueshengChange(id){
                this.$http({
                    url: `xuesheng/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.xueshengForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `wuziShenqing/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.wuziChange(data.data.wuziId)
                        _this.xueshengChange(data.data.xueshengId)
                        _this.ruleForm.wuziShenqingContent = _this.ruleForm.wuziShenqingContent.replaceAll("src=\"upload/","src=\""+this.$base.url+"upload/");
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.ruleForm.wuziShenqingContent = this.ruleForm.wuziShenqingContent.replaceAll(this.$base.url,"");
                        this.$http({
                            url:`wuziShenqing/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.wuziShenqingCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.wuziShenqingCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}</style>

