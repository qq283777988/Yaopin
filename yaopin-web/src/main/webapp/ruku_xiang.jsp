<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-09-03
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="cc" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west',title:'供应商药品详情信息',split:true" style="width:100%;">
        <div id="priv_tb">
            <table id="rk_supdrutb" ></table>
        </div>
    </div>
</div>
<script type="text/javascript">
    var selrows = $("#dgvrktab").datagrid("getSelected");
    var pua_id=selrows.purchase.purchaseApply.pua_id

    var praram ={
        url:'queryPurchaseApplyZhongBypuaid.action?pua_id='+pua_id,
        columns:[[
            {field:'pua_sdzhongid',title:'ID'},
            {field:'supdruu',title:'供应商',
                formatter: function(value,row,index){
                    return row.supdru.supplier.sup_name;
                }},
            {field:'supdru',title:'药品',
                formatter: function(value,row,index){
                    return value.drug.dru_name;
                }},
            {field:'pua_zcount',title:'总数量'},
            {field:'pua_zjia',title:'总价'},
        ]],
        fitColumns:true
    };
    $('#rk_supdrutb').datagrid(praram);
</script>
</body>
</html>
