//在这里写新的panel的样式。
Vue.component("detail-panel", {
    template: `
<el-card class="box-card detail-panel" shadow="hover" id = "detailPanel">
    <div slot="header" class="clearfix">
        <span>节点信息</span>
    </div>
    <div class="text item" v:bind = "currentNode">
        <span>{{currentNode.id}}</span>
    </div>
</el-card>
`,
    data: function () {
        return {
            currentNode:{
                "id":''
            },
            scale:1,
        }


    },
    methods: {

    },
    created: function () {

    },
})