
/**
 * 商品
 */
$(function (){
    //select2 多选
    $("#category_id").select2({
        language: "zh-CN", //设置 提示语言
        maximumSelectionLength: 1,  //设置最多可以选择多少项
        placeholder: "请选择",
        tags: true
    });
    Product.formValidator();
    Product.init();
});


var Product = function (){
    return{
        init:function (){
            $('#product-table').bootstrapTable({
                url: "product/getProductList",
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
                queryParams: Product.queryParams,//传递参数（*）
                columns : [{
                    field : "id",
                    title : "商品编号",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                }, {
                    field : "name",
                    title : "商品名称",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "product_image_url",
                    title : "图片",
                    align : "center",
                    valign : "middle",
                    formatter: function(value,row,index){
                        return '<img  src="'+value+'" class="img-rounded" style="height:40px;width:40px;" >';
                    }
                }, {
                    field : "categoryName",
                    title : "所属分类",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "price",
                    title : "现价",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "original_price",
                    title : "原价",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field : "sold_num",
                    title : "已售笔数",
                    align : "center",
                    valign : "middle",
                    sortable : "true"
                },{
                    field: 'operate',
                    title: '操作',
                    class : 'col-md-2',
                    align: 'center',
                    valign: 'middle',
                    formatter: Product.operateFormatter,
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
                name: $("#name").val(),//商品名称
            };
            return temp;
        },
        operateFormatter:function(value, row, index){
            return [
                '<shiro:hasPermission name="productManager:update"><button type="button" class=" btn btn-info" onclick="Product.openUpdateModal('+row.id+')">修改</button></shiro:hasPermission>',
                '<shiro:hasPermission name="productManager:delete"><button class=" btn btn-danger" type="button" onclick="product.deleteproduct('+row.id+')">删除</button></shiro:hasPermission>'
            ].join('');
        },
        //修改前，打开模态框
        openUpdateModal:function(id){
            $.ajax({
                url:'product/getproductById',
                dataType:'json',
                type:'post',
                data:{
                    id:id
                },
                success:function(data){
                    $("#update_id").val(data.product.id);
                    $("#update_product_name").val(data.product.productName);
                    $("#update_product_code").val(data.product.productCode);
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
        //修改商品
        updateproduct:function(){
            if($("#updateForm").data("bootstrapValidator").validate().isValid()){
                $.ajax({
                    url:'product/updateproduct',
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
                            product.closeDlg();
                            $("#product-table").bootstrapTable('refresh');
                        }else{
                            $.alert({
                                title: '提示信息！',
                                content: '修改失败！',
                                type: 'red'
                            });
                        }
                       
                    }
                });
            }
        },
        //删除
        deleteproduct:function(id){
            $.confirm({
                title: '提示信息!',
                content: '您确定要删除这个商户吗？',
                type: 'blue',
                typeAnimated: true,
                buttons: {
                    确定: {
                        action: function(){
                            $.ajax({
                                url:'product/deleteproduct',
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
                                    $("#product-table").bootstrapTable('refresh');
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
        	//加载所有类别
        	 $.ajax({
                 url:'product/getCategory',
                 dataType:'json',
                 type:'post',
                 traditional:true,
                 success:function(data){
                     $("#category_id").empty();
                     $.each(data.category,function(index,items){
                         $("#category_id").append("<option value='"+items.id+"'>"+items.name+"</option>");
                     });
                 },
                 error:function(){
                     $.alert({
                         title: '提示信息！',
                         content: '请求失败！',
                         type: 'red'
                     });
                 }
             })
            $("#addDlg").modal('show');
        },
        //添加商品
        saveProduct:function(){
            if($("#addForm").data('bootstrapValidator').validate().isValid()){
               alert(true)
            	$.ajax({
                    url:'product/saveproduct',
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
                        $("#product-table").bootstrapTable('refresh');
                        product.closeDlg();
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
        	  $("#addDlg").modal('hide');
              $("#updateDlg").modal('hide');
              $('#addForm').data('bootstrapValidator', null);
              $('#updateForm').data('bootstrapValidator', null);
              Product.formValidator();
        },
        formValidator:function () {
            $("#addForm").bootstrapValidator({
                fields:{
                    name:{
                        validators:{
                            notEmpty:{
                                message:"商品名称不能为空"
                            },
                            stringLength:{
                                max:10,
                                message:"字符长度不能超过10个字符"
                            }
                        }
                    },
                    category_id:{
                        validators:{
                            notEmpty:{
                                message:"商品类别不能为空"
                            }
                        }
                    },
                    price:{
                        validators:{
                            notEmpty:{
                                message:"商品价格不能为空"
                            },
                            numeric: {
                            	message: '只能输入数字'
                            }  
                        }
                    }
                }
            
            });


            $("#updateForm").bootstrapValidator({
                fields:{
                    productName:{
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
        searchProduct:function () {
            $("#product-table").bootstrapTable('refresh');
        },
        //清空
        empty:function () {
            $("#name").val('');
            $("#product-table").bootstrapTable('refresh');
        }
    }
}();





//修改前，打开模态框
function openUpdateModal(id){

}
//修改商品
function updateproduct(){

}
//删除
function deleteproduct(id){

}


//添加，打开模态框
function openDlg(){
};

//添加商品
function saveproduct(){
}

//关闭模态框
function closeDlg(){
};

function formValidator(){
}

//搜索
function searchproduct() {
}
//清空
function empty(){
}