<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-09-03
  Time: 1:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="dgvrktab"></table>
<div id="tbrktab">
    <a id="btnrktab" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">查看订单详情</a>
    <a id="btnrktong" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">同意入库</a>
    <a id="btnrkbutong" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">拒绝入库</a>
</div>
<div id="divxiangrktab" class="easyui-window" title="添加" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'ruku_xiang.jsp',closed:true">
</div>
<div id="divrukucangku" class="easyui-window" title="添加" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'ruku_cangku.jsp',closed:true">
</div>
<script type="text/javascript">
    var param ={
        url:'queryWarehousing.action',
        columns:[[
            {field:'ck',title:'全选',checkbox:true,width:100,height: 100},
            {field:'wah_id',title:'ID',width:100,height:100 },
            {field:'purchase',title:'订单编号',
                formatter: function(value,row,index){
                    return value.pid;
                }},
            {field:'employee',title:'审批人',width:100,height: 100,
                formatter: function(value,row,index){
                    return value.emp_name;
                }},
            {field:'wah_time',title:'时间',width:100,height: 100},
            {field:'wah_state',title:'状态',width:100,height: 100},
        ]],
        fitColumns:true,
        toolbar:'#tbrktab',
        striped:true,   //是否显示斑马线效果
        pagination:true,  //则在DataGrid控件底部显示分页工具栏。
        singleSelect:false,  //如果为true，则只允许选择一行。
        pageSize:5,   //在设置分页属性的时候初始化页面大小
        pageList:[5,10,15]   //初始化页面大小选择列表。
    };
    $("#dgvrktab").datagrid(param);
    $("#btnrktab").click(function () {
        var selrows = $("#dgvrktab").datagrid("getSelected");
        if(selrows==null){
            $.messager.alert('消息','请选择一条记录！','info');
            return;
        }
        $("#divxiangrktab").window("open");
        $("#divxiangrktab").window('refresh');
    })
   /* $("#btnrktong").click(function () {
        var selrows = $("#dgvrktab").datagrid("getSelections");
        if(selrows.length==0){
            $.messager.alert('消息','请至少选择一条记录！','info');
            return;
        }
        var mids="";
        $.messager.confirm('确认','您确认进货完成吗？',function(r){
            if (r){
                alert('确认');
                for (var i =0;i<selrows.length;i++){
                    mids+= selrows[i].wah_id+",";
                    alert(mids)
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
                $("#dgvrktab").datagrid(param);
            }
        });

    })*/
    $("#btnrktong").click(function () {
        var selrows = $("#dgvrktab").datagrid("getSelections");
        if(selrows.length==0){
            $.messager.alert('消息','请至少选择一条记录！','info');
            return;
        }
        $("#divrukucangku").window("open");

    })
    $("#btnrkbutong").click(function () {
        var selrows = $("#dgvrktab").datagrid("getSelections");
        if(selrows.length==0){
            $.messager.alert('消息','请至少选择一条记录！','info');
            return;
        }
        var mids="";
        $.messager.confirm('确认','您确认不通过吗？',function(r){
            if (r){
                for (var i =0;i<selrows.length;i++){
                    mids+= selrows[i].wah_id+",";

                }
                var json ={"mids":mids};
                $.post("updateWarehousingstates.action",json,function (data) {
                    $.messager.show({
                        title:'消息',
                        msg:data,
                        timeout:5000,
                        showType:'slide'
                    });

                },"text");
                $("#dgvrktab").datagrid(param);
            }
        });
    })
</script>
</body>
</html>
