<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-08-31
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>
<body>
药品供应商:<input id="jhshen_sup_id" name="sup_id"><br>
药品名称:<input id="jhshen_dru_id" name="dru_id">
<a id="btnsearchjhshendru" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a><br>
<div id="tbjhshendru">
    <a id="btnjhshensupdru" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">申请进货</a>
</div>
<table id="dgvjhshowdru"></table>
<div id="divjhshendru" class="easyui-window" title="进货申请" style="width:900px;height:500px"
     data-options="iconCls:'icon-add',modal:true,href:'jinhuoshen_shen.jsp',closed:true">
</div>
<script type="text/javascript">
    $("#jhshen_sup_id").combobox({
        url:'querySupplierr.action',
        valueField:'sup_id',
        textField:'sup_name',
    });
    $("#jhshen_dru_id").combobox({
        url:'queryDrugg.action',
        valueField:'dru_id',
        textField:'dru_name',
    });

    //页面加载完成  初始化表格数据
    var param ={
        url:'queryallSupdru.action',
        columns:[[
            {field:'ck',title:'全选',checkbox:true,width:100,height: 100},
            {field:'id',title:'编号',width:100,height:100 },
            {field:'supplier',title:'供应商',width:100,height: 100,
                formatter: function(value,row,index){
                    return value.sup_name;
                }},
            {field:'drug',title:'药品',width:100,height: 100,
                formatter: function(value,row,index){
                    return value.dru_name;
                }},
            {field:'jin_dan',title:'进价',width:100,height: 100},
        ]],
        fitColumns:true,
        toolbar:'#tbjhshendru',
        striped:true,   //是否显示斑马线效果
        pagination:true,  //则在DataGrid控件底部显示分页工具栏。
        singleSelect:false,  //如果为true，则只允许选择一行。
        pageSize:3,   //在设置分页属性的时候初始化页面大小
        pageList:[3,10,15]   //初始化页面大小选择列表。
    };
    $("#dgvjhshowdru").datagrid(param,{
        sup_id:$("#jhshen_sup_id").val(),
        dru_id:$("#jhshen_dru_id").val()
    });
    //条件查询
    $("#btnsearchjhshendru").click(function () {

        //调用datagrid load方法 传递要查询的数据给后端
        //刷新绑定地址  额外传递参数
        $("#dgvjhshowdru").datagrid('load',{

            sup_id:$("#jhshen_sup_id").val(),
            dru_id:$("#jhshen_dru_id").val()
        });
    });
    //申请进货窗口
    $("#btnjhshensupdru").click(function () {
        //获取所有选中行的记录数组
        var selrows = $("#dgvjhshowdru").datagrid("getSelections");
        if(selrows.length==0){
            $.messager.alert('消息','请选择一条记录！','info');
            return;
        }
                $("#divjhshendru").window("open");
                $("#divjhshendru").window('refresh');
    });
</script>
</body>
</html>
