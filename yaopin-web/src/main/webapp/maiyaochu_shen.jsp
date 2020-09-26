<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-09-05
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="dgvmychushentab"></table>
<div id="tbmychushentab">
    <a id="btnmychushentab" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">查看订单详情</a>
    <a id="btnmychushentongcha" href="#" class="easyui-linkbutton"  data-options="iconCls:'icon-add'">自动化订单</a>
    <a id="btnmychushentong" href="#" class="easyui-linkbutton" style="display: none" data-options="iconCls:'icon-add'">出库</a>
    <a id="btnmychushenbutong" href="#" class="easyui-linkbutton" style="display: none" data-options="iconCls:'icon-add'">缺货</a>
</div>
<div id="divxiangmychushentab" class="easyui-window" title="详情" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'maiyaochu_shenxiang.jsp',closed:true">
</div>
<script type="text/javascript">
    var param ={
        url:'queryWarehouseout.action',
        columns:[[
            {field:'ck',title:'全选',checkbox:true,width:100,height: 100},
            {field:'wid',title:'ID',width:100,height:100 },
            {field:'warehouseoutApply',title:'订单编号',
                formatter: function(value,row,index){
                    return value.woa_id;
                }},
            {field:'employee',title:'审批人',width:100,height: 100,
                formatter: function(value,row,index){
                    return value.emp_name;
                }},
            {field:'woa_shentime',title:'时间',width:100,height: 100},
            {field:'woa_zhuang',title:'状态',width:100,height: 100},
        ]],

        toolbar:'#tbmychushentab',
        striped:true,   //是否显示斑马线效果
        pagination:true,  //则在DataGrid控件底部显示分页工具栏。
        singleSelect:true,  //如果为true，则只允许选择一行。
        pageSize:5,   //在设置分页属性的时候初始化页面大小
        pageList:[5,10,15]   //初始化页面大小选择列表。
    };
    $("#dgvmychushentab").datagrid(param);
    $("#btnmychushentab").click(function () {
        var selrows = $("#dgvmychushentab").datagrid("getSelected");
        if(selrows==null){
            $.messager.alert('消息','请选择一条记录！','info');
            return;
        }
        $("#divxiangmychushentab").window("open");
        $("#divxiangmychushentab").window('refresh');
    })
    $("#btnmychushentongcha").click(function () {
        var selrows = $("#dgvmychushentab").datagrid("getSelected");
           /* $("#btnmychushentong").css('display','inline')*/
        $.post("chuku.action",{"wid":selrows.wid},function (data) {
            alert(data)
            $("#dgvmychushentab").datagrid(param);
        },"text");


    })
</script>
</body>
</html>
