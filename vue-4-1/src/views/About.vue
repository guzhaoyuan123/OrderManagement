<template>
    <div class="about">
        <el-container style="height: 500px; border: 1px solid #eee">
            <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
                <el-menu router :default-active="$route.path" :default-openeds="['1', '3']">
                    <el-submenu index="1">
                        <template slot="title">
                            <i class="el-icon-message"></i>导航
                        </template>
                        <el-menu-item-group>
                            <el-menu-item index="/Home">购物车列表</el-menu-item>
                            <el-menu-item index="/About">新增订单</el-menu-item>
                        </el-menu-item-group>
                    </el-submenu>
                </el-menu>
            </el-aside>
            <el-container>
                <el-main>
                    <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px"
                             class="demo-ruleForm">

                        <el-form-item label="商品名称：" prop="name">
                            <el-input v-model="ruleForm.name">

                            </el-input>
                        </el-form-item>

                        <el-form-item label="价格：" prop="price">
                            <el-input v-model="ruleForm.price">

                            </el-input>
                        </el-form-item>

                        <el-form-item label="数量：" prop="num">
                            <el-input v-model="ruleForm.num">
                            </el-input>
                        </el-form-item>


<!--                        <el-form-item label="时间：" prop="date" >-->
<!--                            <el-input v-model="ruleForm.date">-->
<!--                            {{ruleForm.date}}</el-input>-->
<!--                        </el-form-item>-->


                        <el-form-item>
                            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                            <el-button @click="resetForm('ruleForm')">重置</el-button>
                        </el-form-item>
                    </el-form>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>


<script>
    export default {
        data() {
            return {
                nowTime: '',
                ruleForm: {
                    name: '',
                    date: '',
                    price: '',
                    num: '',
                },
                rules: {
                    name: [
                        {required: true, message: '商品名不能为空', trigger: 'blur'}
                    ],
                    price: [
                        {required: true, message: '不能为空', trigger: 'blur'}
                    ],
                    num: [
                        {required: true, message: '数量不能为空', trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.post('http://localhost:8099/shopping/save', this.ruleForm).then(function (resp) {
                            if (resp.data == "success") {
                                _this.$message('添加成功');

                                // _this.$router.push('/BookManage')
                            }

                        })
                    } else {
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        },
        created() {
            var date = new Date();
            var seperator1 = "-";
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            var currentdate = year + seperator1 + month + seperator1 + strDate + - +date.getHours() + ":" + date.getMinutes();

            this.ruleForm.date= currentdate;

            console.log(this.ruleForm.date)
        }
    }
</script>

<style>
    .about .el-aside {
        color: #333;
    }
</style>

