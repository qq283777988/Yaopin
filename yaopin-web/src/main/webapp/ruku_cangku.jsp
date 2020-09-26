<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-09-03
  Time: 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="cc" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west',title:'供应商详情信息',split:true" style="width:100%;">
        <div id="priv_tb">
            药品仓库:<input id="war_idd" name="war_id">
            <a id="btnruku" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">入库</a>
        </div>
    </div>
</div>
<script type="text/javascript">
    $("#war_idd").combobox({
        url:'queryWarehousee.action',
        valueField:'war_id',
        textField:'war_name',
    });
    $("#btnruku").click(function () {
      var war_id=  $("#war_idd").val()
        var selrows = $("#dgvrktab").datagrid("getSelections");
        var mids ="";
        for (var i =0;i<selrows.length;i++){
            mids+= selrows[i].wah_id+",";
        }

        var json ={"mids":mids,"war_id":war_id};

      $.post("ruku.action",json,function (data) {
            $.messager.show({
                title:'消息',
                msg:data,
                timeout:5000,
                showType:'slide'
            });
            $("#divrukucangku").window("close");
        },"text");
    })
</script>
</body>
</html>
