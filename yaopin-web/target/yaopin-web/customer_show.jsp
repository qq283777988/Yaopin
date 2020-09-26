<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-09-07
  Time: 6:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="tbcus">
    <a id="btnaddcus" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
    <a id="btneditcus" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a>
    <a id="btndelcus" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
</div>
<table id="dgvcus"></table>
<script type="text/javascript">
    //页面加载完成  初始化表格数据
    var param ={
        url:'queryCustomer.action',
        columns:[[
            {field:'ck',title:'全选',checkbox:true,width:100,height: 100},
            {field:'cus_id',title:'编号',width:100,height:100 },
            {field:'cus_name',title:'名字',width:100,height: 100},
            {field:'cus_dian',title:'电话',width:100,height: 100},
            {field:'cus_lei',title:'类型',width:100,height: 100},
            {field:'cus_di',title:'地址',width:100,height: 100},
        ]],
        fitColumns:true,
        toolbar:'#tbcus',
        striped:true,   //是否显示斑马线效果
        pagination:true,  //则在DataGrid控件底部显示分页工具栏。
        rownumbers:true,   //如果为true，则显示一个行号列。
        singleSelect:false,  //如果为true，则只允许选择一行。
        pageSize:5,   //在设置分页属性的时候初始化页面大小
        pageList:[5,10,15]   //初始化页面大小选择列表。
    };
    $("#dgvcus").datagrid(param);
</script>
</body>
</html>
