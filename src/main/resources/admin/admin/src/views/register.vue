<template>
    <div>
        <div class="container">
            <div class="login-form">
                <h1 class="h1" style="color:#000;fontSize:28px;">仓库管理系统注册</h1>
                <el-form class="rgs-form">
                    <el-form-item label="账号" class="input">
                        <el-input v-model="ruleForm.username" autocomplete="off" placeholder="账号"  />
                    </el-form-item>
                    <el-form-item label="密码" class="input">
                        <el-input type="password" v-model="ruleForm.password" autocomplete="off" show-password/>
                    </el-form-item>
                    <el-form-item label="重复密码" class="input">
                        <el-input type="passwo   rd" v-model="ruleForm.repetitionPassword" autocomplete="off" show-password/>
                    </el-form-item>
                        <el-form-item label="仓库管理员姓名" class="input" v-if="tableName=='laoshi'">
                            <el-input v-model="ruleForm.laoshiName" autocomplete="off" placeholder="仓库管理员姓名"  />
                        </el-form-item>
                        <el-form-item label="仓库管理员手机号" class="input" v-if="tableName=='laoshi'">
                            <el-input v-model="ruleForm.laoshiPhone" autocomplete="off" placeholder="仓库管理员手机号"  />
                        </el-form-item>
                        <el-form-item label="仓库管理员身份证号" class="input" v-if="tableName=='laoshi'">
                            <el-input v-model="ruleForm.laoshiIdNumber" autocomplete="off" placeholder="仓库管理员身份证号"  />
                        </el-form-item>
                        <!--
                            <el-form-item v-if="laoshiPhotoFlag">
                            </el-form-item>
                            <el-form-item label="仓库管理员头像" class="input" v-if="tableName=='laoshi'">
                                    <file-upload
                                        tip="点击上传仓库管理员头像"
                                        action="file/upload"
                                        :limit="1"
                                        :multiple="true"
                                        :fileUrls="ruleForm.laoshiPhoto?$base.url+ruleForm.laoshiPhoto:''"
                                        @change="laoshiPhotoUploadChange"
                                    ></file-upload>
                           </el-form-item>
                        -->
                        <el-form-item label="仓库管理员邮箱" class="input" v-if="tableName=='laoshi'">
                            <el-input v-model="ruleForm.laoshiEmail" autocomplete="off" placeholder="仓库管理员邮箱"  />
                        </el-form-item>
                        <!--
                            <el-form-item label="仓库管理员住址" class="input" v-if="tableName=='laoshi'">
                                <el-input v-model="ruleForm.laoshiAddress" autocomplete="off" placeholder="仓库管理员住址"  />
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="创建时间" class="input" v-if="tableName=='laoshi'">
                                <el-input v-model="ruleForm.createTime" autocomplete="off" placeholder="创建时间"  />
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="学号" class="input" v-if="tableName=='xuesheng'">
                                <el-input v-model="ruleForm.xueshengUuidNumber" autocomplete="off" placeholder="学号"  />
                           </el-form-item>
                        -->
                        <el-form-item label="用户姓名" class="input" v-if="tableName=='xuesheng'">
                            <el-input v-model="ruleForm.xueshengName" autocomplete="off" placeholder="用户姓名"  />
                        </el-form-item>
                        <el-form-item label="用户手机号" class="input" v-if="tableName=='xuesheng'">
                            <el-input v-model="ruleForm.xueshengPhone" autocomplete="off" placeholder="用户手机号"  />
                        </el-form-item>
                        <el-form-item label="用户身份证号" class="input" v-if="tableName=='xuesheng'">
                            <el-input v-model="ruleForm.xueshengIdNumber" autocomplete="off" placeholder="用户身份证号"  />
                        </el-form-item>
                        <!--
                            <el-form-item v-if="xueshengPhotoFlag">
                            </el-form-item>
                            <el-form-item label="用户头像" class="input" v-if="tableName=='xuesheng'">
                                    <file-upload
                                        tip="点击上传用户头像"
                                        action="file/upload"
                                        :limit="1"
                                        :multiple="true"
                                        :fileUrls="ruleForm.xueshengPhoto?$base.url+ruleForm.xueshengPhoto:''"
                                        @change="xueshengPhotoUploadChange"
                                    ></file-upload>
                           </el-form-item>
                        -->
                        <el-form-item label="用户邮箱" class="input" v-if="tableName=='xuesheng'">
                            <el-input v-model="ruleForm.xueshengEmail" autocomplete="off" placeholder="用户邮箱"  />
                        </el-form-item>
                        <!--
                            <el-form-item label="用户住址" class="input" v-if="tableName=='xuesheng'">
                                <el-input v-model="ruleForm.xueshengAddress" autocomplete="off" placeholder="用户住址"  />
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="创建时间" class="input" v-if="tableName=='xuesheng'">
                                <el-input v-model="ruleForm.createTime" autocomplete="off" placeholder="创建时间"  />
                           </el-form-item>
                        -->
                    <div style="display: flex;flex-wrap: wrap;width: 100%;justify-content: center;">
                        <el-button class="btn" type="primary" @click="login()">注册</el-button>
                        <el-button class="btn close" type="primary" @click="close()">取消</el-button>
                    </div>
                </el-form>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                ruleForm: {
                },
                tableName:"",
                rules: {},
                sexTypesOptions : [],
                laoshiPhotoFlag:false,//用于刷新文件上传
                xueshengPhotoFlag:false,//用于刷新文件上传
            };
        },
        mounted(){
            let table = this.$storage.get("loginTable");
            this.tableName = table;

            //级联表的下拉框查询

        },
        methods: {
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            laoshiPhotoUploadChange(fileUrls) {
               this.ruleForm.laoshiPhoto = fileUrls;
                if(this.laoshiPhotoFlag){
                    this.laoshiPhotoFlag=false;
                }else{
                    this.laoshiPhotoFlag=true;
                }
            },
            xueshengPhotoUploadChange(fileUrls) {
               this.ruleForm.xueshengPhoto = fileUrls;
                if(this.xueshengPhotoFlag){
                    this.xueshengPhotoFlag=false;
                }else{
                    this.xueshengPhotoFlag=true;
                }
            },
            close(){
                this.$router.push({ path: "/login" });
            },
            // 注册
            login() {

                            if((!this.ruleForm.username)){
                                this.$message.error('账号不能为空');
                                return
                            }
                            if((!this.ruleForm.password)){
                                this.$message.error('密码不能为空');
                                return
                            }
                            if((!this.ruleForm.repetitionPassword)){
                                this.$message.error('重复密码不能为空');
                                return
                            }
                            if(this.ruleForm.repetitionPassword != this.ruleForm.password){
                                this.$message.error('密码和重复密码不一致');
                                return
                            }
                            if((!this.ruleForm.laoshiName)&& 'laoshi'==this.tableName){
                                this.$message.error('仓库管理员姓名不能为空');
                                return
                            }
                             if('laoshi' == this.tableName && this.ruleForm.laoshiPhone&&(!this.$validate.isMobile(this.ruleForm.laoshiPhone))){
                                 this.$message.error('手机应输入手机格式');
                                 return
                             }
                            if((!this.ruleForm.laoshiIdNumber)&& 'laoshi'==this.tableName){
                                this.$message.error('仓库管理员身份证号不能为空');
                                return
                            }
                            // laoshi 中的 仓库管理员头像 判空处理
                            // if('laoshi' == this.tableName && (this.ruleForm.laoshiPhoto== null ||this.ruleForm.laoshiPhoto== "")){
                            //     this.$message.error("仓库管理员头像不能为空");
                            //     return
                            // }
                            if('laoshi' == this.tableName && this.ruleForm.laoshiEmail&&(!this.$validate.isEmail(this.ruleForm.laoshiEmail))){
                                this.$message.error("邮箱应输入邮件格式");
                                return
                            }
                            // laoshi 中的 仓库管理员住址 判空处理
                            // if('laoshi' == this.tableName && (this.ruleForm.laoshiAddress== null ||this.ruleForm.laoshiAddress== "")){
                            //     this.$message.error("仓库管理员住址不能为空");
                            //     return
                            // }
                            // laoshi 中的 创建时间 判空处理
                            // if('laoshi' == this.tableName && (this.ruleForm.createTime== null ||this.ruleForm.createTime== "")){
                            //     this.$message.error("创建时间不能为空");
                            //     return
                            // }
                            // xuesheng 中的 学号 判空处理
                            // if('xuesheng' == this.tableName && (this.ruleForm.xueshengUuidNumber== null ||this.ruleForm.xueshengUuidNumber== "")){
                            //     this.$message.error("学号不能为空");
                            //     return
                            // }
                            if((!this.ruleForm.xueshengName)&& 'xuesheng'==this.tableName){
                                this.$message.error('用户姓名不能为空');
                                return
                            }
                             if('xuesheng' == this.tableName && this.ruleForm.xueshengPhone&&(!this.$validate.isMobile(this.ruleForm.xueshengPhone))){
                                 this.$message.error('手机应输入手机格式');
                                 return
                             }
                            if((!this.ruleForm.xueshengIdNumber)&& 'xuesheng'==this.tableName){
                                this.$message.error('用户身份证号不能为空');
                                return
                            }
                            // xuesheng 中的 用户头像 判空处理
                            // if('xuesheng' == this.tableName && (this.ruleForm.xueshengPhoto== null ||this.ruleForm.xueshengPhoto== "")){
                            //     this.$message.error("用户头像不能为空");
                            //     return
                            // }
                            if('xuesheng' == this.tableName && this.ruleForm.xueshengEmail&&(!this.$validate.isEmail(this.ruleForm.xueshengEmail))){
                                this.$message.error("邮箱应输入邮件格式");
                                return
                            }
                            // xuesheng 中的 用户住址 判空处理
                            // if('xuesheng' == this.tableName && (this.ruleForm.xueshengAddress== null ||this.ruleForm.xueshengAddress== "")){
                            //     this.$message.error("用户住址不能为空");
                            //     return
                            // }
                            // xuesheng 中的 创建时间 判空处理
                            // if('xuesheng' == this.tableName && (this.ruleForm.createTime== null ||this.ruleForm.createTime== "")){
                            //     this.$message.error("创建时间不能为空");
                            //     return
                            // }
                this.$http({
                    url: `${this.tableName}/register`,
                    method: "post",
                    data:this.ruleForm
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                    this.$message({
                        message: "注册成功,请登录后在个人中心页面补充个人数据",
                        type: "success",
                        duration: 1500,
                        onClose: () => {
                        this.$router.replace({ path: "/login" });
                }
                });
                } else {
                    this.$message.error(data.msg);
                }
            });
            }
        }
    };
</script>
<style lang="scss" scoped>
	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.h1 {
		margin-top: 10px;
	}

	body {
		padding: 0;
		margin: 0;
	}


	.nk-navigation {
		margin-top: 15px;

		a {
			display: inline-block;
			color: #fff;
			background: rgba(255, 255, 255, .2);
			width: 100px;
			height: 50px;
			border-radius: 30px;
			text-align: center;
			display: flex;
			align-items: center;
			margin: 0 auto;
			justify-content: center;
			padding: 0 20px;
		}

		.icon {
			margin-left: 10px;
			width: 30px;
			height: 30px;
		}
	}

	.register-container {
		margin-top: 10px;

		a {
			display: inline-block;
			color: #fff;
			max-width: 500px;
			height: 50px;
			border-radius: 30px;
			text-align: center;
			display: flex;
			align-items: center;
			margin: 0 auto;
			justify-content: center;
			padding: 0 20px;

			div {
				margin-left: 10px;
			}
		}
	}

	.container {
		height: 100vh;
		background-position: center center;
		background-size: cover;
		background-repeat: no-repeat;
		background-image: url(/cangkuguanlixitong/img/back-img-bg.jpg);



		.login-form {
			right: 50%;
			top: 50%;
			transform: translate3d(50%, -50%, 0);
			border-radius: 10px;
			background-color: rgba(255,255,255,.5);
			font-size: 14px;
			font-weight: 500;
      box-sizing: border-box;

			width: 420px;
			height: auto;
			padding: 15px;
			margin: 0 auto;
			border-radius: 30px;
			border-width: 10px;
			border-style: solid;
			border-color: var(--publicMainColor);
			background-color: rgba(240, 240, 255, 1);
			box-shadow: 0 0 0px rgba(255,0,0,.1);

			.h1 {
				width: 90%;
				height: auto;
				line-height:auto;
				color: #000;
				font-size: 28px;
				padding: 0;
				margin: 20px auto;
				border-radius: 0;
				border-width: 0;
				border-style: solid;
				border-color: rgba(255,0,0,0);
				background-color: rgba(255,0,0,0);
				box-shadow: 0 0 6px rgba(255,0,0,0);
				text-align: center;
			}

			.rgs-form {
				display: flex;
				flex-direction: column;
				justify-content: center;
				align-items: center;

        .el-form-item {
          width: 100%;
          display: flex;

          & /deep/ .el-form-item__content {
            flex: 1;
            display: flex;
          }
        }

				.input {
          width: 100%;
          height:auto;
          padding: 0;
          margin: 0 0 12px 0;
          border-radius: 0;
          border-width: 0;
          border-style: solid;
          border-color: rgba(255,0,0,0);
          background-color: rgba(255,0,0,0);
          box-shadow: 0 0 6px rgba(255,0,0,0);

					& /deep/ .el-form-item__label {
            width: 84px;
            line-height:44px;
            color: #606266;
            font-size: 14px;
            padding: 0 10px 0 0;
            margin: 0;
            border-radius: 0;
            border-width: 0;
            border-style: solid;
            border-color: rgba(255,0,0,0);
            background-color: rgba(255,0,0,0);
            box-shadow: 0 0 6px rgba(255,0,0,0);
					}

					& /deep/ .el-input__inner {
            width: 100%;
            height: 44px;
            line-height:44px;
            color: #606266;
            font-size: 14px;
            padding: 0 12px;
            margin: 0;
            border-radius: 4px;
            border-width: 1px;
            border-style: solid;
            border-color: #606266;
            background-color: #fff;
            box-shadow: 0 0 6px rgba(255,0,0,0);
            text-align: left;
					}
				}

        .send-code {
          & /deep/ .el-input__inner {
            width: 200px;
            height: 44px;
            line-height:44px;
            color: #606266;
            font-size: 14px;
            padding: 0 12px;
            margin: 0;
            border-radius: 0;
            border-width: 1;
            border-style: solid;
            border-color: #606266;
            background-color: #fff;
            box-shadow: 0 0 6px rgba(255,0,0,0);
            text-align: left;
          }

          .register-code {
            margin: 0;
            padding: 0;
            width: 86px;
            height: 44px;
            line-height:44px;
            color: #fff;
            font-size: 14px;
            border-width: 1px 1px 1px 0;
            border-style: solid;
            border-color: rgba(0, 0, 0, 1);
            border-radius: 0;
            background-color: var(--publicSubColor);
            box-shadow: 0 0 6px rgba(255,0,0,0);
          }
        }

				.btn {
					margin: 0 10px;
          padding: 0;
					width: 88px;
					height: 44px;
          line-height:44px;
					color: #fff;
					font-size: 14px;
					border-width: 1px;
					border-style: solid;
					border-color: var(--publicMainColor);
					border-radius: 4px;
					background-color: var(--publicMainColor);
          box-shadow: 0 0 6px rgba(255,0,0,0);
				}

				.close {
          margin: 0 10px;
          padding: 0;
          width: 88px;
          height: 44px;
          line-height:44px;
          color: var(--publicMainColor);
          font-size: 14px;
          border-width: 1px;
          border-style: solid;
          border-color: var(--publicMainColor);
          border-radius: 4px;
          background-color: #FFF;
          box-shadow: 0 0 6px rgba(255,0,0,0);
				}

			}
		}
	}
</style>


