<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-08-20
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
姓名：<input type="text" name="emp_name" id="emp_name">
性别：<select name="emp_sex" id="emp_sex"  >
        <option>请选择</option>
        <option>男</option>
        <option>女</option>
     </select>
状态：<select name="emp_state" id="emp_state">
    <option>请选择</option>
    <option>在职</option>
    <option>离职</option>
</select>
<a id="btnsearchemp" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
<br>
<div id="tbemp">
    <a id="btnaddemp" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
    <a id="btneditemp" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a>
    <a id="btndelemp" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>
</div>
<table id="dgvemp"></table>
<!-- 添加窗口-->
<div id="divaddemp" class="easyui-window" title="添加" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'yuangong_add.jsp',closed:true">
</div>
<!-- 编辑窗口-->
<div id="diveditemp" class="easyui-window" title="编辑" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'yuangong_edit.jsp',closed:true">
</div>
<script type="text/javascript">
    //页面加载完成  初始化表格数据
    var param ={
        url:'queryEmployee.action',
        columns:[[
            {field:'ck',title:'全选',checkbox:true,width:100},
            {field:'emp_id',title:'编号',width:40 },
            {field:'emp_name',title:'名字',width:50},
            {field:'emp_sex',title:'性别',width:30,align:'right'},
            {field:'emp_birthday',title:'生日',width:50,align:'right' },
            {field:'emp_state',title:'状态',width:40,align:'right'},
            {field:'roles',title:'角色',width:100,align:'left',
                formatter:function(value){
                var str="";
                $(value).each(function (i) {
                    if(value.length>1){
                        str+=" "+value[i].rol_name+" ";
                    }else{
                        str+=value[i].rol_name;
                    }
                })
                    return  str;
                }
            }
        ]],
        fitColumns:true,
        toolbar:'#tbemp',
        striped:true,   //是否显示斑马线效果
        pagination:true,  //则在DataGrid控件底部显示分页工具栏。
        rownumbers:true,   //如果为true，则显示一个行号列。
        singleSelect:false,  //如果为true，则只允许选择一行。
        pageSize:5,   //在设置分页属性的时候初始化页面大小
        pageList:[5,10,15]   //初始化页面大小选择列表。
    };
    $("#dgvemp").datagrid(param);
    //条件查询
    $("#btnsearchemp").click(function () {
        //调用datagrid load方法 传递要查询的数据给后端
        //刷新绑定地址  额外传递参数
     $("#dgvemp").datagrid('load',{emp_name:$("#emp_name").val(),emp_sex:$("#emp_sex").val(),emp_state:$("#emp_state").val()});
    });
    //添加按钮  绑定事件  打开添加窗口
    $("#btnaddemp").click(function () {
        $("#divaddemp").window("open");
        $("#divaddemp").window('refresh');
    });
    //修改按钮  绑定事件  打开修改窗口
    $("#btneditemp").click(function () {
        //获取所有选中行的记录数组
        var selrows = $("#dgvemp").datagrid("getSelected");

        if(selrows==null){

            $.messager.alert('消息','请选择一条记录！','info');
            return;
        }
        $("#diveditemp").window("open");
        $("#diveditemp").window('refresh');
    });
    //删除按钮  绑定事件
    $("#btndelemp").click(function () {

        //获取所有选中行的记录数组
        var selrows = $("#dgvemp").datagrid("getSelections");
        if(selrows.length ==0){
            $.messager.alert('消息','请选择一条记录！','info');
            return;
        }
        $.messager.confirm('确认对话框', '您确认删除这些记录吗？', function(r){
            if (r){
                //获取当前选中的记录的id
                var ids = "";
                for(var i = 0;i<selrows.length;i++){
                    ids += selrows[i].emp_id+",";
                }

                $.get("deleteemp.action",{"ids":ids},function(data){
                    //弹出结果消息
                    $.messager.show({
                        title:'消息',
                        msg:data.msg,
                        timeout:5000,
                        showType:'slide'
                    });
                    //刷新表格数据
                    $("#dgvemp").datagrid('load',{emp_name:$("#emp_name").val(),emp_sex:$("#emp_sex").val(),emp_state:$("#emp_state").val()});
                },"json");
            }
        });
    });
</script>
</body>
</html>
