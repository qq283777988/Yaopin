<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-08-24
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

药品名称：<input type="text" name="dru_name" id="dru_name" >
药品类型：<input id="dru_typename" name="dru_typename" >
药品剂型：<input id="dru_jiname" name="dru_jiname" >
药品供应商:<input id="sup_id" name="sup_id"><br>
药品仓库:<input id="war_id" name="war_id">
<a id="btnsearchdru" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
<br>
<div id="tbdru">
    <a id="btnadddru" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
   <a id="btneditdru" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</a>
    <a id="btndeldru" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">删除</a>

</div>
<table id="dgvdru"></table>
<!-- 添加窗口-->
<div id="divadddru" class="easyui-window" title="添加" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'drug_add.jsp',closed:true">
</div>
<!-- 编辑窗口-->
<div id="diveditdru" class="easyui-window" title="编辑" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'drug_edit.jsp',closed:true">
</div>

<script type="text/javascript">


     $(function () {
         $("#dru_typename").combobox({
             url:'queryDrugType.action',
             valueField:'dru_typename',
             textField:'dru_typename',
         });
         $("#dru_jiname").combobox({
             url:'queryDrugJI.action',
             valueField:'dru_jiname',
             textField:'dru_jiname',
         });
         $("#sup_id").combobox({
             url:'querySupplierr.action',
             valueField:'sup_id',
             textField:'sup_name',
         });
         $("#war_id").combobox({
             url:'queryWarehousee.action',
             valueField:'war_id',
             textField:'war_name',
         });

         //页面加载完成  初始化表格数据
         var param ={
             url:'queryDrug.action',
             columns:[[
                 {field:'ck',title:'全选',checkbox:true,width:10,height: 100},
                 {field:'dru_id',title:'编号',width:100,height: 100},

                 {field:'dru_name',title:'名字',width:100,height: 100},
                 {field:'dru_image',title:'图片',width:100,align:'right',height: 100,
                     formatter:function(value){
                         return  '<img  style="width: 100px;height: 100px"  src="'+value+'">';
                     }},
                 {field:'dru_gui',title:'规格',width:100,align:'right',height:100 },
                 {field:'dru_time',title:'时间',width:100,align:'right',height: 100},
                 {field:'dru_gong',title:'功效',width:100,align:'right',height: 100},
                 {field:'dru_jia',title:'价格',width:100,align:'right',height: 100},
                 {field:'drugType',title:'类型',width:100,align:'right',height: 100,
                     formatter: function(value,row,index){
                         return value.dru_typename;
                     }},
                 {field:'drugJI',title:'剂型',width:100,align:'right',height: 100,
                     formatter: function(value,row,index){
                         return value.dru_jiname;
                     }},
                /* {field:'ku_cun',title:'库存',align:'right'}*/
               /*  {
                     field: 'ku_cun', title: '库存', align: 'right',
                     formatter: function (value, row, index) {
                         var ku_cun;
                         var json = {"dru_id": row.dru_id};
                             $.ajax({
                                 url: "queryDrugkucun.action",
                                 data: json,
                                 dataType: "text",
                                 async: false,
                                 success: function (data) {
                                     ku_cun = data;
                                 }
                             });
                             return ku_cun;
                     }
                 }*/
                 /*   {field:'but',title:'编辑',width:100,align:'right',height: 100,
                        formatter: function(){
                            return " <a id='btnchasupwardru'  href='#' class='easyui-linkbutton' data-options='iconCls:'icon-edit''>编辑</a>";
                        }},*/
             ]],
             fitColumns:true,
             toolbar:'#tbdru',
             striped:true,   //是否显示斑马线效果
             pagination:true,  //则在DataGrid控件底部显示分页工具栏。
             singleSelect:false,  //如果为true，则只允许选择一行。
             pageSize:5,   //在设置分页属性的时候初始化页面大小
             pageList:[5,10,15]  //初始化页面大小选择列表。

         };
         $("#dgvdru").datagrid(param,{dru_name:$("#dru_name").val(),
             dru_typename:$("#dru_typename").val(),
             dru_jiname:$("#dru_jiname").val(),
             sup_id:$("#sup_id").val(),
             war_id:$("#war_id").val()
         });
         //条件查询
         $("#btnsearchdru").click(function () {
             //调用datagrid load方法 传递要查询的数据给后端
             //刷新绑定地址  额外传递参数
             $("#dgvdru").datagrid('load',{dru_name:$("#dru_name").val(),
                 dru_typename:$("#dru_typename").val(),
                 dru_jiname:$("#dru_jiname").val(),
                 sup_id:$("#sup_id").val(),
                 war_id:$("#war_id").val()
             });

         });



     })
</script>
</body>
</html>
