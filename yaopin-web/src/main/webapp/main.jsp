<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-08-19
  Time: 0:47
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
<div id="cc" class="easyui-layout" data-options="fit:true" style="width:600px;height:400px;">
    <div data-options="region:'north',split:true" style="height:100px;">

        <h1>药品管理系统</h1>
        欢迎你，${employee.emp_name}


    </div>
    <!--			<div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
-->
    <!--			<div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>
-->
    <div id="clist" data-options="region:'west',title:'菜单管理',split:true" style="width:150px;">

        <!-- 左边区域  放置  菜单-->
        <ul id="menutree"></ul>

    </div>
    <div data-options="region:'center'" style="padding:5px;background:#eee;">
        <!--中间区域  显示选项卡 -->
        <div id="tt" class="easyui-tabs" data-options="fit:true" style="width:500px;height:250px;">
            <div title="首页" style="padding:20px;display:none;">
                欢迎使用本系统
            </div>

        </div>

    </div>
</div>
<script type="text/javascript">

    var treeparam={
        url:"querymenuall.action",
        onClick: function(node){
            var url = node.attributes.url;
            //根节点  不进行任何操作
            if(url ==undefined){
                return;
            }

            //判断是否打开了
            var res = $("#tt").tabs('exists', node.text);

            if (res) {
                //打开  选中已打开
                $("#tt").tabs('select', node.text);
            } else {
                //未打开  添加选项卡
                $("#tt").tabs('add', {title: node.text, closable: true, href: url});
            }
        }
    };
    $("#menutree").tree(treeparam);


</script>
</body>
</html>
