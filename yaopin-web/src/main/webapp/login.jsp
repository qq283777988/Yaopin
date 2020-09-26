<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-08-18
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 3个js  2个css -->
    <!-- jquery -->
    <script type="text/javascript" src="js/jquery.min.js" ></script>
    <!-- easyui -->
    <script type="text/javascript" src="js/jquery.easyui.min.js" ></script>
    <!-- 语言包 -->
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js" ></script>
    <!-- 主体样式 -->
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <!-- 图标样式 -->
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
</head>
<body>


<div id="win" class="easyui-window" title="登陆功能" style="width:300px;height:200px"
     data-options="iconCls:' icon-color_wheel ',modal:true">
    <form method="post" id="loginform">
        <table>
            <tr><td>用户名</td><td><input type="text" name="emp_user"></td></tr>
            <tr><td>密码</td><td><input type="password" name="emp_pass"></td></tr>
            <tr><td colspan="2">
                <a id="btnlogin" class="easyui-linkbutton" data-options="iconCls:'icon-save'">登录</a>
            </td></tr>
        </table>
    </form>
</div>
<script type="text/javascript">
  $("#btnlogin").click(function () {

      // call 'submit' method of form plugin to submit the form
      $("#loginform").form('submit', {
          url:"login.action",
          onSubmit: function(){
              return true;
          },
          success:function(data){
              if(data=="登录失败"){
                  alert(data);
              }else{
                  window.location="main.jsp";
              }
          }
      });
  });
</script>
</body>
</html>
