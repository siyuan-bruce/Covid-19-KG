//在这里写新的panel的样式。
// import Vue from 'vue.min'
// import ElementUI from 'element-ui';
// import ("https://cdn.bootcss.com/element-ui/2.10.1/index.js") as ElementUI;
// import 'element-ui/lib/theme-chalk/index.css';
// Vue.use(ElementUI);

Vue.component("detail-panel", {
    template: `
        <div class="detail-panel">
            <el-card class="box-card" shadow="hover" id = "detailPanel" style="     
              /*.text {*/
              /*  font-size: 14px;*/
              /*}*/
              
              /*.item {*/
              /*  padding: 18px 0;*/
              /*}*/
              
              /*.box-card {*/
              /*  position: fixed;*/
              /*  right: 10px;*/
              /*  top: 40px;*/
              /*  border-radius: 4px;*/
              /*  width: 200px;*/
              /*  cursor: pointer;*/
              /*}    */

            ">
                <div slot="header" class="clearfix">
                    <span>节点信息</span>
                </div>
                <div class="text item" v:bind = "currentNode" >
                    <table>
                        <tbody>
                            <tr v-for="(v,k) in currentNode">
                                <td class="detail-info">{{k}}</td>
                                <td class="detail-info">{{v}}</td>
                            </tr>
                        </tbody>
                    </table>
                    <el-form ref="form" label-width="0px" v-show="ifShow">
                      <el-form-item>
                        <el-select v-model="currentType" placeholder="请选择查询关系">
                          <el-option v-for="(type,i) in relationshipTypes" :label="i" :value="type" :key="type"></el-option>
                        </el-select>
                      </el-form-item>
                      <el-form-item>
                        <el-button type="primary" @click="onSubmit">查询关系</el-button>
                      </el-form-item>
                    </el-form>
                </div>
            </el-card>
        </div>
    `,
    data: function () {
        return {
            ifShow : false,
            currentNode:{
            },
            currentType:'',
            relationshipTypes:['适用人群'],
            scale:1,
        }


    },
    methods: {
        onSubmit(){
            var _this = this;
            if(this.currentType === ""){
                this.$message.error('未选择任何类型');
                return
            }else{
                axios.get('api/node/query/'+_this.currentType+'/'+_this.currentNode.name)
                    .then(function (response) {
                        if(response.status == 200){
                            _this.$emit('update',response.data,_this.currentNode,_this.currentType)
                        }
                    })
                    .catch(function (error) {
                        console.log(error)
                    })
            }
            console.log(this.currentType)
        }
    },
    created: function () {

    },
});
    // .style.cssText = 'position: fixed'
    // .style.cssText = 'right: 10px'
    // .style.cssText = 'top: 40px'
    // .style.cssText = 'border-radius: 4px'
    // .style.cssText = 'width: 200px'
    // .style.cssText = 'cursor: pointer'
