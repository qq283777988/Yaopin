<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-08-20
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<form id="addempform" method="post">
    员工名字：<input  name="emp_name" class="easyui-validatebox" data-options="required:true" />  <br>
    员工性别：<select name="emp_sex"  class="easyui-validatebox" required="required"  >
                <option>请选择</option>
                <option>男</option>
                <option>女</option>
             </select><br>
    员工生日：<input  name="emp_birthday" class="easyui-datebox" required="required" > <br>
    员工账号：<input  name="emp_user" type="text" class="easyui-validatebox" required="required"></input><br>
    员工密码：<input  name="emp_pass" type="password" class="easyui-validatebox"  required="required"  ></input><br>
    员工角色：&lt;%&ndash;<input id="er_rol_id" name="rol_id" >&ndash;%&gt;
    <table id="emprol_tb" ></table>
</form>--%>
<table id="emprol_addtb" ></table>
<div id="tabaddemprol">
    员工名字：<input  name="emp_name" id="eradd_name" class="easyui-validatebox" data-options="required:true" />  <br>
    员工性别：<select name="emp_sex" id="eradd_sex"  class="easyui-validatebox" required="required"  >
    <option>请选择</option>
    <option>男</option>
    <option>女</option>
</select><br>
    员工生日：<input  name="emp_birthday"  id="eradd_birthday" class="easyui-datebox" required="required" > <br>
    员工账号：<input  name="emp_user" id="eradd_user" type="text" class="easyui-validatebox" required="required"></input><br>
    员工密码：<input  name="emp_pass" id="eradd_pass" type="password" class="easyui-validatebox"  required="required"  ></input><br>
    员工角色选择：

</div>

<a id="btnaddemp_add" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">添加</a>
<script type="text/javascript">
    //加载角色信息列表的
    var priv_dgvroleparam ={
        url:'queryallroles.action',
        columns:[[
            {field:'ck',checkbox:true,title:'Code',width:100},
            {field:'rol_id',title:'ID',width:100},
            {field:'rol_name',title:'名字',width:100,align:'right'}
        ]],
        toolbar:'#tabaddemprol',
        singleSelect:false,
    };
    $('#emprol_addtb').datagrid(priv_dgvroleparam);
   /* $("#er_rol_id").combobox({
        url:'queryallroles.action',
        valueField:'rol_id',
        textField:'rol_name',
        onSelect:function (recod) {
            alert(recod.rol_id)
        /!*    $('#shi').combobox('clear'); //先清空下拉框数据
            //重新加载新的数据
            $('#shi').combobox('reload','queryShiByPid.action?pid='+recod.provinceId);*!/
        }
    });
    */
    $("#btnaddemp_add").click(function () {
    /*    $('#addempform').form('submit', {
            url:"addemp.action",
            onSubmit: function(){
                return $(this).form("validate");
            },
            success:function(data){
                //弹出结果消息
                $.messager.show({
                    title:'消息',
                    msg:data,
                    timeout:5000,
                    showType:'slide'
                });
                //关闭当前添加窗口
                $("#divaddemp").window("close");
                //刷新后台表格数据
                $("#dgvemp").datagrid('load',{emp_name:$("#emp_name").val(),emp_sex:$("#emp_sex").val(),emp_state:$("#emp_state").val()});
            }
        });*/
        //获取多个角色
        var selrows = $("#emprol_addtb").datagrid("getSelections");
        var mids="";
        if(selrows.length ==0){
            $.messager.alert('消息','请选择一个角色！','info');
            return;
        }
        for (var i =0;i<selrows.length;i++){
            mids+= selrows[i].rol_id+",";

        }
        var json ={"emp_name":$("#eradd_name").val(),
            "emp_sex":$("#eradd_sex").val(),
            "emp_birthday":$("#eradd_birthday").val(),
            "emp_user":$("#eradd_user").val(),
            "emp_pass":$("#eradd_pass").val(),
            "mids":mids};
        $.post("addemp.action",json,function (data) {
            $.messager.show({
                title:'消息',
                msg:data,
                timeout:5000,
                showType:'slide'
            });
            $("#divaddemp").window("close");
            $("#dgvemp").datagrid('load',{emp_name:$("#emp_name").val(),emp_sex:$("#emp_sex").val(),emp_state:$("#emp_state").val()});
        },"text");
        //获取员工信息
        //提交
    });
</script>
</body>
</html>
