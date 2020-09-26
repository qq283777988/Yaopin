<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-09-05
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="dgvmyshentab"></table>
<div id="tbmyshentab">
    <a id="btnmyshentab" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">查看订单详情</a>
    <a id="btnmyshentong" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">审批通过</a>
    <a id="btnmyshenbutong" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">审批不通过</a>
</div>
<div id="divxiangmyshentab" class="easyui-window" title="详情" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'maiyaoshen_shenxiang.jsp',closed:true">
</div>
<script type="text/javascript">
    var param ={
        url:'queryWarehouseoutApply.action',
        columns:[[
            {field:'ck',title:'全选',checkbox:true,width:100,height: 100},
            {field:'woa_id',title:'订单编号',width:100,height:100 },
            {field:'customer',title:'顾客',width:100,height:100 ,
                formatter: function(value,row,index){
                    return value.cus_name;
                }},
            {field:'woa_zcount',title:'总数量',width:100,height:100 },
            {field:'woa_zjia',title:'总价',width:100,height:100 },
            {field:'employee',title:'申请人',width:100,height: 100,
                formatter: function(value,row,index){
                    return value.emp_name;
                }},
            {field:'woa_time',title:'申请时间',width:100,height: 100},
            {field:'woa_state',title:'申请状态',width:100,height: 100}
        ]],
        fitColumns:true,
        toolbar:'#tbmyshentab',
        striped:true,   //是否显示斑马线效果
        pagination:true,  //则在DataGrid控件底部显示分页工具栏。
        singleSelect:false,  //如果为true，则只允许选择一行。
        pageSize:5,   //在设置分页属性的时候初始化页面大小
        pageList:[5,10,15]   //初始化页面大小选择列表。
    };
    $("#dgvmyshentab").datagrid(param);
    $("#btnmyshentab").click(function () {
        var selrows = $("#dgvmyshentab").datagrid("getSelected");
        if(selrows==null){
            $.messager.alert('消息','请选择一条记录！','info');
            return;
        }
        $("#divxiangmyshentab").window("open");
        $("#divxiangmyshentab").window('refresh');
    })
    $("#btnmyshentong").click(function () {
        var selrows = $("#dgvmyshentab").datagrid("getSelections");
        if(selrows.length==0){
            $.messager.alert('消息','请至少选择一条记录！','info');
            return;
        }
        var mids="";
        $.messager.confirm('确认','您确认通过吗？',function(r){
            if (r){

                for (var i =0;i<selrows.length;i++){
                    mids+= selrows[i].woa_id+",";

                }
                var json ={"mids":mids};
                $.post("addWarehouseout.action",json,function (data) {
                    $.messager.show({
                        title:'消息',
                        msg:data,
                        timeout:5000,
                        showType:'slide'
                    });
                    $("#dgvmyshentab").datagrid(param);
                },"text");

            }
        });

    })
    $("#btnmyshenbutong").click(function () {
        var selrows = $("#dgvmyshentab").datagrid("getSelections");
        if(selrows.length==0){
            $.messager.alert('消息','请至少选择一条记录！','info');
            return;
        }
        var mids="";
        $.messager.confirm('确认','您确认不通过吗？',function(r){
            if (r){

                for (var i =0;i<selrows.length;i++){
                    mids+= selrows[i].woa_id+",";

                }
                var json ={"mids":mids};
                $.post("updateWarehouseoutApplyzhuangs.action",json,function (data) {
                    $.messager.show({
                        title:'消息',
                        msg:data,
                        timeout:5000,
                        showType:'slide'
                    });
                    $("#dgvmyshentab").datagrid(param);
                },"text");

            }
        });
    })
</script>
</body>
</html>
