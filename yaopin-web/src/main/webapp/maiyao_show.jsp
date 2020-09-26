<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-09-04
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
药品名称：<input type="text" name="dru_name" id="m_dru_name" >
药品类型：<input name="dru_typename" id="m_dru_typename" >
药品剂型：<input name="dru_jiname" id="m_dru_jiname" >
药品供应商:<input name="sup_id" id="m_sup_id"><br>
药品仓库:<input name="war_id" id="m_war_id">
<a id="m_btnsearchdru" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
<br>
<div id="m_tbdru">
    <a id="m_btnchasupwardru" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">查看详情</a>
    <a id="m_btnmaiyaosupdru" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'">出售</a>
</div>
<table id="m_dgvdru"></table>
<!-- 详情窗口-->
<div id="m_divchasupwardru" class="easyui-window" title="详情" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'drug_xiangqing.jsp',closed:true">
</div>
<!-- 编辑窗口-->
<div id="m_divmaiyaosupdru" class="easyui-window" title="出售" style="width:600px;height:400px"
     data-options="iconCls:'icon-add',modal:true,href:'maiyao_xuantab.jsp',closed:true">
</div>
<script type="text/javascript">
    $(function () {
        $("#m_dru_typename").combobox({
            url:'queryDrugType.action',
            valueField:'dru_typename',
            textField:'dru_typename',
        });
        $("#m_dru_jiname").combobox({
            url:'queryDrugJI.action',
            valueField:'dru_jiname',
            textField:'dru_jiname',
        });
        $("#m_sup_id").combobox({
            url:'querySupplierr.action',
            valueField:'sup_id',
            textField:'sup_name',
        });
        $("#m_war_id").combobox({
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

                /*   {field:'but',title:'编辑',width:100,align:'right',height: 100,
                       formatter: function(){
                           return " <a id='btnchasupwardru'  href='#' class='easyui-linkbutton' data-options='iconCls:'icon-edit''>编辑</a>";
                       }},*/
            ]],
            fitColumns:true,
            toolbar:'#m_tbdru',
            striped:true,   //是否显示斑马线效果
            pagination:true,  //则在DataGrid控件底部显示分页工具栏。
            singleSelect:false,  //如果为true，则只允许选择一行。
            pageSize:5,   //在设置分页属性的时候初始化页面大小
            pageList:[5,10,15]  //初始化页面大小选择列表。

        };
        $("#m_dgvdru").datagrid(param,{dru_name:$("#m_dru_name").val(),
            dru_typename:$("#m_dru_typename").val(),
            dru_jiname:$("#m_dru_jiname").val(),
            sup_id:$("#m_sup_id").val(),
            war_id:$("#m_war_id").val()
        });
        //条件查询
        $("#m_btnsearchdru").click(function () {
            //调用datagrid load方法 传递要查询的数据给后端
            //刷新绑定地址  额外传递参数
            $("#m_dgvdru").datagrid('load',{dru_name:$("#m_dru_name").val(),
                dru_typename:$("#m_dru_typename").val(),
                dru_jiname:$("#m_dru_jiname").val(),
                sup_id:$("#m_sup_id").val(),
                war_id:$("#m_war_id").val()
            });

        });
        //详情
        $("#m_btnchasupwardru").click(function () {
            //获取所有选中行的记录数组
            var selrows = $("#m_dgvdru").datagrid("getSelected");
            if(selrows==null){

                $.messager.alert('消息','请选择一条记录！','info');
                return;
            }
            $("#m_divchasupwardru").window("open");
            $("#m_divchasupwardru").window('refresh');
        });
        //购买
        $("#m_btnmaiyaosupdru").click(function () {
            //获取所有选中行的记录数组
            var selrows = $("#m_dgvdru").datagrid("getSelections");
            if(selrows==null){

                $.messager.alert('消息','请选择一条记录！','info');
                return;
            }
            $("#m_divmaiyaosupdru").window("open");
            $("#m_divmaiyaosupdru").window('refresh');
        });
    })
</script>
</body>
</html>
