<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-09-02
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="dgvjhtab"></table>
<div id="tbjhtab">
    <a id="btnjhtab" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">查看订单详情</a>
    <a id="btnjhtong" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">进货完成</a>
    <a id="btnjhbutong" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">取消进货</a>
</div>
<div id="divxiangjhtab" class="easyui-window" title="添加" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'jinhuo_xiang.jsp',closed:true">
</div>
<script type="text/javascript">
    var param ={
        url:'queryPurchase.action',
        columns:[[
            {field:'ck',title:'全选',checkbox:true,width:100,height: 100},
            {field:'pid',title:'ID',width:100,height:100 },
            {field:'purchaseApply',title:'订单编号',
                formatter: function(value,row,index){
                    return value.pua_id;
                }},
            {field:'employee',title:'审批人',width:100,height: 100,
                formatter: function(value,row,index){
                    return value.emp_name;
                }},
            {field:'pua_shentime',title:'时间',width:100,height: 100},
            {field:'pua_zhuang',title:'状态',width:100,height: 100},
        ]],

        toolbar:'#tbjhtab',
        striped:true,   //是否显示斑马线效果
        pagination:true,  //则在DataGrid控件底部显示分页工具栏。
        singleSelect:false,  //如果为true，则只允许选择一行。
        pageSize:5,   //在设置分页属性的时候初始化页面大小
        pageList:[5,10,15]   //初始化页面大小选择列表。
    };
    $("#dgvjhtab").datagrid(param);
    $("#btnjhtab").click(function () {
        var selrows = $("#dgvjhtab").datagrid("getSelected");
        if(selrows==null){
            $.messager.alert('消息','请选择一条记录！','info');
            return;
        }
        $("#divxiangjhtab").window("open");
        $("#divxiangjhtab").window('refresh');
    })
    $("#btnjhtong").click(function () {
        var selrows = $("#dgvjhtab").datagrid("getSelections");
        if(selrows.length==0){
            $.messager.alert('消息','请至少选择一条记录！','info');
            return;
        }
        var mids="";
        $.messager.confirm('确认','您确认进货完成吗？',function(r){
            if (r){

                for (var i =0;i<selrows.length;i++){
                    mids+= selrows[i].pid+",";
                }
                var json ={"mids":mids};
               $.post("addwarehousing.action",json,function (data) {
                    $.messager.show({
                        title:'消息',
                        msg:data,
                        timeout:5000,
                        showType:'slide'
                    });

                },"text");
                $("#dgvjhtab").datagrid(param);
            }
        });

    })
    $("#btnjhbutong").click(function () {
        var selrows = $("#dgvjhtab").datagrid("getSelections");
        if(selrows.length==0){
            $.messager.alert('消息','请至少选择一条记录！','info');
            return;
        }
        var mids="";
        $.messager.confirm('确认','您确认不通过吗？',function(r){
            if (r){

                for (var i =0;i<selrows.length;i++){
                    mids+= selrows[i].pid+",";

                }
                var json ={"mids":mids};
               $.post("updatePurchasezhuangs.action",json,function (data) {
                    $.messager.show({
                        title:'消息',
                        msg:data,
                        timeout:5000,
                        showType:'slide'
                    });

                },"text");
                $("#dgvjhtab").datagrid(param);
            }
        });



    })
</script>
</body>
</html>
