//在这里写新的panel的样式。
Vue.component("guidance", {
    template: `

<el-button @click="drawer = true" type="primary" style="margin-left: 16px; left: 10px">
  点我打开
</el-button>

<el-drawer
  title="我是标题"
  :visible.sync="drawer"
  :with-header="false">
  <span>我来啦!</span>
</el-drawer>


<!--<el-button @click="drawer = true" type="primary" style="margin-left: 16px;">-->
<!--  使用指南-->
<!--</el-button>-->


<!--<el-drawer title="使用指南" :visible.sync="drawer" :with-header="false">-->
<!--  <div style=>&nbsp;Covid-19知识图谱知识指南：</div>-->
<!--  <div>1. 顶部搜索框可供你搜索你想查找的节点信息，你可以搜索并选择你想要的节点。</div><br>-->
<!--  <div>2. 左侧为热搜榜可以让你快速看到截止目前人们搜索的热点。</div><br>-->
<!--  <div>3. 右侧为节点详细信息，选中知识图谱中的节点后，你可以选择关系，并点击查询关系看到节点之间的联系。</div><br>-->
<!--  <div>4. 当新的节点出现在图谱中时，你可以再次点击新的节点，查询新的关系。</div><br>-->
<!--</el-drawer>-->


`,


    data() {
        return {
            drawer: false,
        };
    }



});

