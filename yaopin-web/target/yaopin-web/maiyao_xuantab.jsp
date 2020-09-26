<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-09-04
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="ccc" class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west',title:'请选择用户',split:true" style="width:20%;">
        <div id="priv_tb">
            <table id="yonghutb" ></table>
        </div>

        <%-- <table id="priv_dgvrole"></table>--%>
    </div>
    <div data-options="region:'center',title:'请选择药品'" style="padding:5px;width:80%;">
        <!--  显示所有的菜单信息  tree   状态-->
        <table id="dgvmaiyaodru"></table><br>
        总价<span id="mzjia"></span><a id="btnmaiyaodru" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确认出售</a>
    </div>
</div>
<script type="text/javascript">
    function numberBlur(self){
        var td=$(self).parent().parent().prev();
        var tdd=$(self).parent().parent().next();
        var count=parseFloat(self.value);
        var jinjia=parseFloat(td.find("div").text());
        var z=count*jinjia;
        tdd.find("span").text(z)
        var zjia=0;
        $("span[name='pua_zjia']").each(function(i){
            let trr = $(this).parent().parent().parent();
            if(trr.find("input[type='checkbox']:checked").length > 0){
                zjia=zjia+parseFloat($(this).text())
            }
        })
        $("#mzjia").html(zjia)
    }
    $(function () {
        var priv_yongparam ={
            url:'queryallCustomer.action',
            columns:[[
                {field:'ck',checkbox:true,title:'Code'},
                {field:'cus_id',title:'ID'},
                {field:'cus_name',title:'名字',align:'right'},
            ]],
            singleSelect:true,  //如果为true，则只允许选择一行。
        };
        $('#yonghutb').datagrid(priv_yongparam);

        var selrows = $("#m_dgvdru").datagrid("getSelections");
        var ids = "";
        for (var i = 0; i < selrows.length; i++) {
            ids += selrows[i].dru_id + ",";
        }
        //页面加载完成  初始化表格数据
        var param = {
            url: 'queryDrugBydruidduo.action?ids=' + ids,
            columns: [[
                {field: 'ck', title: '全选', checkbox: true },
                {field: 'dru_id', title: '编号'},
                {field: 'dru_name', title: '名字'},
                {
                    field: 'dru_image', title: '图片', width: 100, align: 'right',
                    formatter: function (value) {
                        return '<img  style="width: 100px;height: 100px"  src="' + value + '">';
                    }
                },
                {field: 'dru_jia', title: '价格', width: 100, align: 'right'},
                {
                    field: 'count', title: '数量', width: 100, height: 100,
                    formatter: function () {
                        return " <input type='number' onchange='numberBlur(this)' name='pua_count' style='width: 50px' value='1' class='num'oninput='if(value<1)value=1'  >";
                    }
                },
                {
                    field: 'danzjia', title: '小计', width: 100, height: 50,
                    formatter: function () {
                        return " <span  name='pua_zjia' style='width: 50px'   ></span>";
                    }
                },
                {
                    field: 'suppliers', title: '供应商', width: 100,
                    formatter: function (value) {
                        console.log(value)
                        let select = "<select name='xia_sup_id'>";
                        for (var i = 0; i < value.length; i++) {

                            select += "<option value='" + value[i].sup_id + "'>" + value[i].sup_name + "</option>";
                        }
                        return select + "</select>";
                    }
                },
                {
                    field: 'warehouses', title: '仓库', width: 100,
                    formatter: function (value) {
                        console.log(value)
                        let select = "<select name='xia_war_id'>";
                        $.ajax({
                            url: "queryWarehousee.action",
                            async: false,
                            success: function (data) {
                                for (var i = 0; i < data.length; i++) {

                                    select += "<option value='" + data[i].war_id + "'>" + data[i].war_name + "</option>";
                                }
                            }
                        });

                        return select + "</select>";
                    }
                },
            ]],
            singleSelect: false,  //如果为true，则只允许选择一行。
            onLoadSuccess:function () {
                var chuzjia=0;
                var rows=$("#dgvmaiyaodru").datagrid("getRows");
                for(var i=0;i<rows.length;i++){
                    var jin_dan=parseFloat(rows[i]['dru_jia']);//获取指定列
                    var count=parseFloat($("input[name='pua_count']").eq(i).val());
                    pua_zjia=jin_dan*count
                    $("span[name='pua_zjia']").eq(i).text(pua_zjia)
                    chuzjia=chuzjia+pua_zjia
                    $("#mzjia").html(chuzjia)
                }
            },
            onCheck:function () {
                var zzjia=0;
                $("span[name='pua_zjia']").each(function(i){
                    let trr = $(this).parent().parent().parent();
                    if(trr.find("input[type='checkbox']:checked").length > 0){
                        zzjia=zzjia+parseFloat($(this).text())
                    }
                })
                $("#mzjia").html(zzjia)
            },
            onUncheck:function () {
                var zzjia=0;
                $("span[name='pua_zjia']").each(function(i){
                    let trr = $(this).parent().parent().parent();
                    if(trr.find("input[type='checkbox']:checked").length > 0){
                        zzjia=zzjia+parseFloat($(this).text())
                    }
                })
                $("#mzjia").html(zzjia)
            }
        };
        $("#dgvmaiyaodru").datagrid(param);

        $("#btnmaiyaodru").click(function () {
            var selrowssc = $("#yonghutb").datagrid("getSelected");
            if(selrowssc==null){
                $.messager.alert('消息','请选择一个用户！','info');
                return;
            }
            var selrowss = $("#dgvmaiyaodru").datagrid("getSelections");
            if(selrowss.length==0){
                $.messager.alert('消息','请选择一条记录！','info');
                return;
            }
            var mids ="";
            //所有药品ID
            for (var i =0;i<selrowss.length;i++){
                mids+= selrowss[i].dru_id+",";
            }
            //数量
            var countlist ="";
            var zcount=0;
            $("input[name='pua_count']").each(function(i){
                let tr = $(this).parent().parent().parent();
                if(tr.find("input[type='checkbox']:checked").length > 0){
                    countlist+= $(this).val()+",";
                    zcount=zcount+parseInt($(this).val())
                }
            })

            //小计
            var zjialist="";
            var zjia=0;
            $("span[name='pua_zjia']").each(function(i){
                let trr = $(this).parent().parent().parent();
                if(trr.find("input[type='checkbox']:checked").length > 0){
                    zjialist+= $(this).text()+",";
                    zjia=zjia+parseFloat($(this).text())
                }
            })
            $("#mzjia").html(zjia)

            //仓库--
            var canglist = "";
            $("select[name='xia_war_id']").each(function (i) {
                let tr = $(this).parent().parent().parent();
                if (tr.find("input[type='checkbox']:checked").length > 0) {
                    canglist += $(this).val() + ",";
                }
            })
            //供应商--
            var gonglist = "";
            $("select[name='xia_sup_id']").each(function (i) {
                let tr = $(this).parent().parent().parent();
                if (tr.find("input[type='checkbox']:checked").length > 0) {
                    gonglist += $(this).val() + ",";
                }
            })
            var json ={"cus_id":selrowssc.cus_id,
                "mids":mids,
                "countlist":countlist,
                "zjialist":zjialist,
                "zcount":zcount,
                "zjia":zjia,
                "canglist":canglist,
                "gonglist":gonglist
            };
            $.post("addWarehouseoutApplyZhong.action",json,function (data) {
                $.messager.show({
                    title:'消息',
                    msg:data,
                    timeout:5000,
                    showType:'slide'
                });
                $("#m_divmaiyaosupdru").window("close");

            },"text");
            $("input[name='pua_count']").treegrid("change");
        })
    })
</script>
</body>
</html>
