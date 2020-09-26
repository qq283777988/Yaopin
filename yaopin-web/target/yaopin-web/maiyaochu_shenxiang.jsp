<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-09-05
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="cccccccc" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west',title:'药品详情信息',split:true" style="width:100%;">
        <div id="priv_tb">
            <table id="maiyaochushen_drutb" ></table>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        var selrows = $("#dgvmychushentab").datagrid("getSelected");
        var wid=selrows.wid
        var praram ={
            url:'queryWarehouseoutApplyZhongBywid.action?wid='+wid,
            columns:[[
                {field:'woa_zhongid',title:'ID'},
                {field:'warehouseoutApply',title:'订单编号',
                    formatter: function(value,row,index){
                        return value.woa_id;
                    }},
                {field:'warehouseoutApplyy',title:'顾客',
                    formatter: function(value,row,index){
                        return row.warehouseoutApply.customer.cus_name;
                    }},
                {field:'drug',title:'药品',
                    formatter: function(value,row,index){
                        return value.dru_name;
                    }},
                {field:'supplier',title:'供应商',
                    formatter: function(value,row,index){
                        return value.sup_name;
                    }},
                {field:'warehouse',title:'仓库',
                    formatter: function(value,row,index){
                        return value.war_name;
                    }},
                {field:'dru_jia',title:'售价',
                    formatter: function(value,row,index){
                        return row.drug.dru_jia;
                    }},
                {field:'woa_zcount',title:'总数量'},
                {field:'woa_zjia',title:'总价'}
            ]],
        };
        $('#maiyaochushen_drutb').datagrid(praram);
    })
</script>
</body>
</html>
