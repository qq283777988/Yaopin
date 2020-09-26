<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-08-27
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="cc" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west',title:'供应商详情信息',split:true" style="width:50%;">
        <div id="priv_tb">
            <table id="drusup_xiangqingtb" ></table>
        </div>

       <%-- <table id="priv_dgvrole"></table>--%>
    </div>
    <div data-options="region:'center',title:'仓库详情信息'" style="padding:5px;width:50%;">
        <!--  显示所有的菜单信息  tree   状态-->
        <table id="druwar_xiangqingtb" ></table>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        var selrows = $("#m_dgvdru").datagrid("getSelected");
        var dru_id=selrows.dru_id
        var priv_drusupparam ={
            url:'queryallSupdru.action?dru_id='+dru_id,
            columns:[[
                {field:'id',title:'ID'},
                {field:'supplier',title:'供应商',align:'right',
                    formatter: function(value,row,index){
                        return value.sup_name;
                    }},
         /*       {field:'drug',title:'药品',align:'right',
                    formatter: function(value,row,index){
                        return value.dru_name;
                    }},*/
                {field:'jin_dan',title:'单价',align:'right'}
            ]],
            fitColumns:true
        };
        $('#drusup_xiangqingtb').datagrid(priv_drusupparam);

        var selrows = $("#m_dgvdru").datagrid("getSelected");
        var dru_id=selrows.dru_id
        var priv_druwarparam ={
            url:'queryallWardru.action?dru_id='+dru_id,
            columns:[[
                {field:'id',title:'ID'},
                {field:'warehouse',title:'仓库',align:'right',
                    formatter: function(value,row,index){
                        return value.war_name;
                    }},
            /*    { field:'drug',title:'药品',align:'right',
                    formatter: function(value,row,index){
                        return value.dru_name;
                    }},*/
                {field:'ku_cun',title:'库存',align:'right'}
            ]],
            fitColumns:true
        };
        $('#druwar_xiangqingtb').datagrid(priv_druwarparam);
    })
</script>
</body>
</html>
