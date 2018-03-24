$(function () {
//select2 多选
    $("#rid").select2({
        language: "zh-CN", //设置 提示语言
        maximumSelectionLength: 3,  //设置最多可以选择多少项
        //width: "100%", //设置下拉框的宽度
        placeholder: "请选择",
        tags: true,
    });
    formValidator();
    init();
})

function init () {
    $('#merchantList-table').bootstrapTable({
        url: "${path }/merchant/getMerchantList",
        method:"post",
        dataType: "json",
        contentType: "application/x-www-form-urlencoded",
        striped:true,//隔行变色
        cache:false,  //是否使用缓存
        showColumns:false,// 列
        toobar:'#toolbar',
        pagination: true, //分页
        sortable: false, //是否启用排序
        singleSelect: false,
        search:false, //显示搜索框
        buttonsAlign: "right", //按钮对齐方式
        showRefresh:false,//是否显示刷新按钮
        sidePagination: "server", //服务端处理分页
        pageSize : 5, //默认每页条数
        pageNumber : 1, //默认分页
        pageList : [ 10, 20, 50, 100, 200, 500 ],//分页数
        toolbar:"#toolbar",
        showColumns : false, //显示隐藏列
        uniqueId: "id", //每一行的唯一标识，一般为主键列
        queryParamsType:'',
        queryParams: queryParams,//传递参数（*）
        columns : [{
            field : "id",
            title : "商户编号",
            align : "center",
            valign : "middle",
            sortable : "true"
        }, {
            field : "merchant_name",
            title : "商户名称",
            align : "center",
            valign : "middle",
            sortable : "true"
        }, {
            field : "merchant_code",
            title : "商户编码",
            align : "center",
            valign : "middle",
            sortable : "true"
        },{
            field: 'operate',
            title: '操作',
            class : 'col-md-2',
            align: 'center',
            valign: 'middle',
            formatter: operateFormatter,
        }],
        formatLoadingMessage : function() {
            return "请稍等，正在加载中...";
        },
        formatNoMatches : function() {
            return '无符合条件的记录';
        }
    });

    //得到查询的参数
    function queryParams (params) {
        var temp = {
            pageSize: params.pageSize,  //页面大小
            pageNumber: params.pageNumber, //页码
            merchantCode: $("#merchant_code").val(),
            merchantName:$("#merchant_name").val(),
        };
        return temp;
    };
}


function operateFormatter(value, row, index) {
    return ['<shiro:hasPermission name="merchantManager:add"><button type="button" class=" btn btn-warning" onclick="getRole('+row.id+')">角色</button></shiro:hasPermission>',
        '<shiro:hasPermission name="merchantManager:update"><button type="button" class=" btn btn-info" onclick="openUpdateModal('+row.id+')">修改</button></shiro:hasPermission>',
        '<shiro:hasPermission name="merchantManager:delete"><button class=" btn btn-danger" type="button" onclick="deleteMerchant('+row.id+')">删除</button></shiro:hasPermission>'
    ].join('');
}