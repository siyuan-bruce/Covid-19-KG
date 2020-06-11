//在这里写新的panel的样式。
Vue.component("detail-panel", {
    template: `
<el-card class="box-card detail-panel" shadow="hover" id = "detailPanel">
    <div slot="header" class="clearfix">
        <span>节点信息</span>
    </div>
    <div class="text item" v:bind = "currentNode">
        <div v-for="(v,k) in currentNode">{{k}}:{{v}}</div>
    </div>
</el-card>
<style scoped>
    .detail-panel {
        position: fixed;
        right: 10px;
        top: 40px;
        border-radius: 4px;
        width: 200px;
        cursor: pointer;
    }
</style>
`,
    data: function () {
        return {
            currentNode:{
            },
            scale:1,
        }


    },
    methods: {

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
