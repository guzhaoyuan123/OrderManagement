<template>
    <div class="home">
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
                <el-header style="text-align: left; font-size: 17px">
                    <span>订单管理</span>
                </el-header>
                <el-main>
                    <el-table :data="purData" height="350" style="width: 100%" class="table">
                        <el-table-column prop="name" label="品牌" width="180"></el-table-column>
                        <el-table-column prop="date" label="订单日期" width="200"></el-table-column>

                        <el-table-column prop="price" label="订单单价" width="180"></el-table-column>
                        <el-table-column label="购买数量" width="180">
                            <template slot-scope="scope1">
                                <el-input-number v-model="scope1.row.num" size="small" @change="handleChange" :min="1"
                                                 :max="10"></el-input-number>
                                <!-- <button @click="scope1.row.num>0?scope1.row.num--:0">-</button>&nbsp;&nbsp;
                                <span class="span1">{{scope1.row.num}}</span>&nbsp;&nbsp;
                                <button @click="scope1.row.num<10?scope1.row.num++:10">+</button> -->
                            </template>
                        </el-table-column>
                        <el-table-column label="操作" width="180">
                            <template slot-scope="a">
                                <el-button size="mini" type="danger" @click="del(a.row)">删除</el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                </el-main>
                <span class="span2" v-show="purData.length>0"
                      style="font-family: Microsoft YaHei">总价：{{sumPrice}}元</span>
            </el-container>
        </el-container>

        <!-- 可以用它的名字来找它 -->
        <router-view></router-view>
    </div>
</template>

<script>
    // @ is an alias to /src
    import HelloWorld from "@/components/HelloWorld.vue";

    var padaDate = function (value) {
        return value < 10 ? "0" + value : value;
    };

    export default {
        name: "Home",
        data() {
            return {
                purData: [{
                        id: 1,
                        name: "小米",
                        date: "",
                        price: "100",
                        num: 1
                    }]
            };
        },
        computed: {
            sumPrice: function () {
                var sum = 0;
                for (var i = 0; i < this.purData.length; i++) {
                    sum += this.purData[i].price * this.purData[i].num;
                }
                return sum;
            }
        },
        methods: {
            del(index) {
                const _this = this
                axios.delete('http://localhost:8099/shopping/deleteById/'+index.id).then(function (resp) {
                    _this.$message('删除成功');
                    window.location.reload();
                })
            },
            handleChange(value) {
                console.log(value);
            }
        },
        created() {
            const _this = this;
            axios.get('http://localhost:8099/shopping/findAll/0/100').then(function (resp) {
                // console.log(resp.data)
                _this.purData = resp.data.content
            })
        }
    };
</script>
<style scoped>
    * {
        margin: 0;
        padding: 0;
    }

    .home .table {
        margin-left: 80px;
        text-align: center;
    }

    .home .table el-table-column {
        text-align: center;
    }

    .home .span2 {
        margin-bottom: 20px;
        color: #409EFF;
    }

    .home .el-header {
        background-color: #b3c0d1;
        color: #333;
        line-height: 60px;
    }

    .home .el-aside {
        color: #333;
    }
</style>


