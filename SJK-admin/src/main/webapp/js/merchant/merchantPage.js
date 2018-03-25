
/**
 * 用户
 */
$(function (){
    //select2 多选
    $("#rid").select2({
        language: "zh-CN", //设置 提示语言
        maximumSelectionLength: 3,  //设置最多可以选择多少项
        //width: "100%", //设置下拉框的宽度
        placeholder: "请选择",
        tags: true,
    });
    Merchant.formValidator();
    Merchant.init();
});


var Merchant = function (){
    return{
        init:function (){
            $('#merchant-table').bootstrapTable({
                url: "merchant/getMerchantList",
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
                queryParams: Merchant.queryParams,//传递参数（*）
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
                    formatter: Merchant.operateFormatter,
                }],
                formatLoadingMessage : function() {
                    return "请稍等，正在加载中...";
                },
                formatNoMatches : function() {
                    return '无符合条件的记录';
                }
            });
        },
        queryParams:function(params){
            var temp = {
                pageSize: params.pageSize,  //页面大小
                pageNumber: params.pageNumber, //页码
                merchantCode: $("#merchant_code").val(),
                merchantName:$("#merchant_name").val(),
            };
            return temp;
        },
        operateFormatter:function(value, row, index){
            return ['<shiro:hasPermission name="merchantManager:add"><button type="button" class=" btn btn-warning" onclick="Merchant.getRole('+row.id+')">角色</button></shiro:hasPermission>',
                '<shiro:hasPermission name="merchantManager:update"><button type="button" class=" btn btn-info" onclick="Merchant.openUpdateModal('+row.id+')">修改</button></shiro:hasPermission>',
                '<shiro:hasPermission name="merchantManager:delete"><button class=" btn btn-danger" type="button" onclick="Merchant.deleteMerchant('+row.id+')">删除</button></shiro:hasPermission>'
            ].join('');
        },
        //角色分配
        getRole:function(id){
            $("#merchantId").val(id);
            $.ajax({
                url:'merchant/getRole',
                dataType:'json',
                type:'post',
                traditional:true,
                data:{
                    id:id
                },
                success:function(data){
                    $("#rid").empty();
                    $.each(data.role,function(index,items){
                        $("#rid").append("<option value='"+items.id+"'>"+items.roleName+"</option>");
                    });
                    if((data.userRole!=null)){
                        $.each(data.userRole,function(index,items){
                            $("#rid").val(data.userRole).trigger("change");//select2 选中
                        });
                    }else{
                        $("#rid").val(0).trigger("change");
                    }
                },
                error:function(){
                    $.alert({
                        title: '提示信息！',
                        content: '请求失败！',
                        type: 'red'
                    });
                }
            })
            $("#roleDlg").modal('show');
        },
        //保存修改角色
        saveRole:function(){
            var merchantId=$("#merchantId").val();

            var rids=$("#rid").val();//select2 获取多选值
            $.ajax({
                url:'merchant/updateMerchantRole',
                dataType:'json',
                type:'post',
                traditional:true,
                data:{
                    merchantId:merchantId,
                    rid:rids
                },
                success:function(data){
                    if(data){
                        $.alert({
                            title: '提示信息！',
                            content: '保存成功！',
                            type: 'blue'
                        });
                    }else{
                        $.alert({
                            title: '提示信息！',
                            content: '保存失败！',
                            type: 'red'
                        });
                    }
                    closeDlg();
                    $('#merchant-table').bootstrapTable('refresh');
                }
            })
        },
        //修改前，打开模态框
        openUpdateModal:function(id){
            $.ajax({
                url:'merchant/getMerchantById',
                dataType:'json',
                type:'post',
                data:{
                    id:id
                },
                success:function(data){
                    $("#update_id").val(data.merchant.id);
                    $("#update_merchant_name").val(data.merchant.merchantName);
                    $("#update_merchant_code").val(data.merchant.merchantCode);
                    $("#updateDlg").modal('show');
                },
                error:function(){
                    $.alert({
                        title: '提示信息！',
                        content: '请求失败！',
                        type: 'red'
                    });
                }
            });
        },
        //修改用户
        updateMerchant:function(){
            if($("#updateForm").data("bootstrapValidator").validate().isValid()){
                $.ajax({
                    url:'merchant/updateMerchant',
                    dataType:'json',
                    type:'post',
                    data:$("#updateForm").serialize(),
                    success:function(data){
                        if(data){
                            $.alert({
                                title: '提示信息！',
                                content: '修改成功！',
                                type: 'blue'
                            });
                        }else{
                            $.alert({
                                title: '提示信息！',
                                content: '修改失败！',
                                type: 'red'
                            });
                        }
                        closeDlg();
                        $("#merchant-table").bootstrapTable('refresh');
                    }
                });
            }
        },
        //删除
        deleteMerchant:function(id){
            $.confirm({
                title: '提示信息!',
                content: '您确定要删除这个商户吗？',
                type: 'blue',
                typeAnimated: true,
                buttons: {
                    确定: {
                        action: function(){
                            $.ajax({
                                url:'merchant/deleteMerchant',
                                dataType:'json',
                                type:'post',
                                data:{
                                    id:id
                                },
                                success:function(data){
                                    if(data){
                                        $.alert({
                                            title: '提示信息！',
                                            content: '删除成功!',
                                            type: 'blue'
                                        });
                                    }else{
                                        $.alert({
                                            title: '提示信息！',
                                            content: '删除失败!',
                                            type: 'red'
                                        });
                                    }
                                    $("#merchant-table").bootstrapTable('refresh');
                                },
                                error:function(){
                                    $.alert({
                                        title: '提示信息！',
                                        content: '请求失败！',
                                        type: 'red'
                                    });
                                }
                            });
                        }
                    },
                    取消: function () {
                    }
                }
            });
        },
        //添加，打开模态框
        openDlg:function(){
            $("#addDlg").modal('show');
        },
        //添加用户
        saveMerchant:function(){
            if($("#addForm").data('bootstrapValidator').validate().isValid()){
                $.ajax({
                    url:'merchant/saveMerchant',
                    type:'post',
                    dataType:'json',
                    data:$("#addForm").serialize(),
                    success:function(data){
                        if(data>0){
                            $.alert({
                                title: '提示信息！',
                                content: '添加成功!',
                                type: 'blue'
                            });
                        }else{
                            $.alert({
                                title: '提示信息！',
                                content: '添加失败！',
                                type: 'red'
                            });
                        }
                        $("#merchant-table").bootstrapTable('refresh');
                        closeDlg();
                    },
                    error:function(){
                        $.alert({
                            title: '提示信息！',
                            content: '请求失败！',
                            type: 'red'
                        });
                    }
                });
            }
        },
        //关闭模态框
        closeDlg:function () {
            $("#roleDlg").modal('hide');
            $("#updateDlg").modal('hide');
            $("#addDlg").modal('hide');
            $('#addForm').data('bootstrapValidator', null);
            $('#updateForm').data('bootstrapValidator', null);
            Merchant.formValidator();
        },
        formValidator:function () {
            $("#addForm").bootstrapValidator({
                fields:{
                    merchantName:{
                        validators:{
                            notEmpty:{
                                message:"管理员名称不能为空"
                            },
                            stringLength:{
                                max:20,
                                message:"字符长度不能超过20个字符"
                            }
                        }
                    },
                    merchantCode:{
                        validators:{
                            notEmpty:{
                                message:"管理员账号不能为空"
                            },
                            stringLength:{
                                max:20,
                                message:"字符长度不能超过20个字符"
                            }
                        }
                    }
                }
            });


            $("#updateForm").bootstrapValidator({
                fields:{
                    merchantName:{
                        validators:{
                            notEmpty:{
                                message:"管理员名称不能为空"
                            },
                            stringLength:{
                                max:20,
                                message:"字符长度不能超过20个字符"
                            }
                        }
                    }
                }
            });
        },
        //搜索
        searchMerchant:function () {
            $("#merchant-table").bootstrapTable('refresh');
        },
        //清空
        empty:function () {
            $("#merchant_code").val('');
            $("#merchant_name").val('');
            $("#merchant-table").bootstrapTable('refresh');
        }
    }
}();




//角色分配
function getRole(id){

}
//保存修改角色
function saveRole(){

};

//修改前，打开模态框
function openUpdateModal(id){

}
//修改用户
function updateMerchant(){

}
//删除
function deleteMerchant(id){

}


//添加，打开模态框
function openDlg(){
};

//添加用户
function saveMerchant(){
}

//关闭模态框
function closeDlg(){
};

function formValidator(){
}

//搜索
function searchMerchant() {
}
//清空
function empty(){
}