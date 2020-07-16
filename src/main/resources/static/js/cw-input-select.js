Vue.component('cw-input-select', {
    template: `

<div class="cw-input-select_wrap" onselectstart="return false" >
    <div class="cw-input-select">
        <div class="cw-input-select_box" v-on:click="selectHandle">
            <span v-html="selectedValue">{{selectedValue || '请选择'}}</span>
            <i class="cw-arrow" v-bind:class="{'up': isShowPop}"></i>
        </div>
        <div class="cw-input-select_pop" v-if="isShowPop">
            <input type="text" v-on:input="getdata" class="cw-input-select_ipt" placeholder="搜索" v-model="keyword" />
            <ul class="cw-input-select_options">
                <li v-for="option in optionsList" v-on:click="selected(option)">
                    <a v-html="option">  </a>
                </li>
            </ul>
            <span class="cw-input-select_arrow"></span>
        </div>
    </div>
</div>`,

    data: function () {
        return {
            keyword:"",
            optionsList: [],
            isShowPop: false,
            selectedValue: '', // 选中值
        }
    },
    methods: {
        // 点击基本框显示或隐藏选项列表盒子
        selectHandle: function () {
            this.isShowPop = !this.isShowPop;
        },
        hidePop: function () {
            this.isShowPop = false;
        },
        selected: function (val) {
            this.selectedValue = val;


            //正则表达式去除红色印记
            val = val.replace(new RegExp("<span style= 'color:red'>","gm"),"");
            val = val.replace(new RegExp("</span>","gm"),"");

            console.log(val)

                this.isShowPop = false;
            axios.put('writeHotSpot/',
                {"name":val})

                .then(response => (

                    console.log(response)

                ))

            window.getGraph(val);


        },
        getdata: function () {
            var keyword = this.keyword;
            console.log(keyword);
            axios.get('search/' + keyword).then(response => {
                // console.log(response.data);
                this.optionsList = response.data; //数据获得成功 vue双向绑定

            })


        },
    },
    created: function () {
        // 点全局范围收起下拉框
        var that = this;
        $('body').click(function (e) {
            console.log(e);
            if (e.target.className=='cw-input-select_wrap' || $(e.target).parents('.cw-input-select_wrap').length>0) {
                return;
            }
            that.hidePop();
        });
    },
    mounted() {
        window.selected = this.selected;
    }
})