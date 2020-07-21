//在这里写新的panel的样式。
Vue.component("hot-spot", {
    template: `
<el-card class="box-card hot-spot" id = "hot-spot" style="width: 20%">
  <div slot="header" class="clearfix">
    <span>热搜榜</span>
<!--    <el-button style="float: right; padding: 3px 0" type="text">换一批</el-button>-->
  </div>
  <div v-for="(o,index) in hotspot" :key="o" class="text item" v-on:click="getselected(o)" style="text-align: left">
    <a >{{index+1+ "  " + o }}</a>
  </div>
</el-card>
`,

    data: function () {
        return {
            hotspot:[],
        }

    },


    methods: {
        getdata: function () {
            var keyword = this.keyword;
            // console.log(keyword);
            if (keyword!=""){
            axios.get('/searchHotSpot').then(response => {
                // console.log(response.data);
                this.hotspot = response.data; //数据获得成功 vue双向绑定

            })
            }
        },

        getselected:function(val){
            window.selected(val);
        }
    },

    created: function () {
        this.getdata();
    },

});

