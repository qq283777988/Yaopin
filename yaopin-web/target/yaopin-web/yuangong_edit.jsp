<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-08-20
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="ccc" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west',title:'员工信息',split:true" style="width:40%;">
        <div id="tabeditemprol">
            员工ID：<input id="eredit_id" name="emp_id" class="easyui-validatebox" readonly />  <br>
            员工名字：<input  name="emp_name" id="eredit_name" class="easyui-validatebox" data-options="required:true" />  <br>
            员工性别：<select name="emp_sex" id="eredit_sex"  class="easyui-validatebox" required="required"  >
            <option>请选择</option>
            <option>男</option>
            <option>女</option>
        </select><br>
            员工生日：<input  name="emp_birthday"  id="eredit_birthday" class="easyui-datebox" required="required" > <br>
            员工账号：<input  name="emp_user" id="eredit_user" type="text" class="easyui-validatebox" required="required"></input><br>
            员工密码：<input  name="emp_pass" id="eredit_pass" type="password" class="easyui-validatebox"  required="required"  ></input><br>
            状态：<select name="emp_state" id="eredit_state">
                        <option>在职</option>
                        <option>离职</option>
                         </select>
        </div>
    </div>
    <div data-options="region:'center',title:'员工角色信息'" style="padding:5px;width:60%;">
       <table id="emprol_edittb" ></table>
        <a id="btneditemp_edit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-save'">修改</a>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        var priv_dgvroleparam ={
            url:'queryallroles.action',
            columns:[[
                {field:'ck',checkbox:true,title:'Code',width:100},
                {field:'rol_name',title:'名字',width:100,align:'right'}
            ]],
            singleSelect:false,
        };
        $('#emprol_edittb').datagrid(priv_dgvroleparam);

        var selrows = $("#dgvemp").datagrid("getSelected");
        var id=selrows.emp_id

        $.get("queryempByempid.action",{"emp_id":id},function (data) {
            $("#eredit_id").val(data.emp_id);
            $("#eredit_name").val(data.emp_name);
            $("#eredit_sex").find("option:contains("+data.emp_sex+")").attr("selected",true);
            $("#eredit_birthday").datebox('setValue',data.emp_birthday);
            $("#eredit_user").val(data.emp_user);
            $("#eredit_pass").val(data.emp_pass);
            $("#eredit_state").find("option:contains("+data.emp_state+")").attr("selected",true);
            var rolelist=data.roles;
            var rows = $('#emprol_edittb').datagrid('getRows');
            for(var i=0;i<rows.length;i++){
                for(var j=0;j<rolelist.length;j++){
                    var name = rows[i]['rol_name'];
                    if(name==rolelist[j].rol_name){
                        $("#emprol_edittb").datagrid("selectRow", i);
                    }
                }
            }
        },"json")
        $.get("queryallrolesbyempid.action",{"emp_id":id},function (data) {

        },"json")

       //角色信息
        $("#btneditemp_edit").click(function () {
            var selrows = $("#emprol_edittb").datagrid("getSelections");
            var mids="";
            if(selrows.length ==0){
                $.messager.alert('消息','请选择一个角色！','info');
                return;
            }
            for (var i =0;i<selrows.length;i++){
                mids+= selrows[i].rol_id+",";

            }
            var json ={ "emp_id":$("#eredit_id").val(),
                "emp_name":$("#eredit_name").val(),
                "emp_sex":$("#eredit_sex").val(),
                "emp_birthday":$("#eredit_birthday").val(),
                "emp_user":$("#eredit_user").val(),
                "emp_pass":$("#eredit_pass").val(),
                "emp_state":$("#eredit_state").val(),
                "mids":mids};
            $.post("updateemp.action",json,function (data) {
                $.messager.show({
                    title:'消息',
                    msg:data,
                    timeout:5000,
                    showType:'slide'
                });
                $("#diveditemp").window("close");
                $("#dgvemp").datagrid('load',{emp_name:$("#emp_name").val(),emp_sex:$("#emp_sex").val(),emp_state:$("#emp_state").val()});
            },"text");
        });
    })
</script>
</body>
</html>
