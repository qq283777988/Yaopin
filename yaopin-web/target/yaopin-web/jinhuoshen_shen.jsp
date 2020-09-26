<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-08-31
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="dgvjhshendru"></table><br>
总价<span id="zjia"></span><a id="btnjhshendru" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">申请进货</a>
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
        $("#zjia").html(zjia)
    }
    $(function () {
        var selrows = $("#dgvjhshowdru").datagrid("getSelections");
        var ids = "";
        for(var i = 0;i<selrows.length;i++){
            ids += selrows[i].id+",";
        }

        //页面加载完成  初始化表格数据
        var param ={
            url:'querySupdruBylistsupdruid.action?ids='+ids,
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
                {field:'count',title:'数量',width:50,height: 100,
                    formatter: function(){
                        return " <input type='number' onchange='numberBlur(this)' name='pua_count' style='width: 50px' value='1' class='num'oninput='if(value<1)value=1'  >";
                    }},
                {field:'danzjia',title:'小计',width:50,height: 100,
                    formatter: function(){
                        return " <span  name='pua_zjia' style='width: 50px'   ></span>";
                    }},

            ]],
            fitColumns:true,
            singleSelect:false,  //如果为true，则只允许选择一行。
            onLoadSuccess:function () {
                var chuzjia=0;
                var rows=$("#dgvjhshendru").datagrid("getRows");
                for(var i=0;i<rows.length;i++){
                    var jin_dan=parseFloat(rows[i]['jin_dan']);//获取指定列
                    var count=parseFloat($("input[name='pua_count']").eq(i).val());
                    pua_zjia=jin_dan*count
                    $("span[name='pua_zjia']").eq(i).text(pua_zjia)
                    chuzjia=chuzjia+pua_zjia
                    $("#zjia").html(chuzjia)
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
                $("#zjia").html(zzjia)
            },
            onUncheck:function () {
                var zzjia=0;
                $("span[name='pua_zjia']").each(function(i){
                    let trr = $(this).parent().parent().parent();
                    if(trr.find("input[type='checkbox']:checked").length > 0){
                        zzjia=zzjia+parseFloat($(this).text())
                    }
                })
                $("#zjia").html(zzjia)
            }
        };
        $("#dgvjhshendru").datagrid(param);


        //申请进货按钮
        $("#btnjhshendru").click(function () {
            //获取所有选中行的记录数组
            var selrowss = $("#dgvjhshendru").datagrid("getSelections");
            if(selrowss.length==0){
                $.messager.alert('消息','请选择一条记录！','info');
                return;
            }
            var mids ="";
            for (var i =0;i<selrowss.length;i++){
                mids+= selrowss[i].id+",";
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
            //总价
            var zjialist="";
            var zjia=0;
          $("span[name='pua_zjia']").each(function(i){
                let trr = $(this).parent().parent().parent();
                if(trr.find("input[type='checkbox']:checked").length > 0){
                    zjialist+= $(this).text()+",";
                    zjia=zjia+parseFloat($(this).text())
                }
            })
            $("#zjia").html(zjia)


            var json ={"mids":mids,
                "countlist":countlist,
                "zjialist":zjialist,
                "zcount":zcount,
                "zjia":zjia};

            $.post("addPurchaseApplyZhong.action",json,function (data) {
                $.messager.show({
                    title:'消息',
                    msg:data,
                    timeout:5000,
                    showType:'slide'
                });
                $("#divjhshendru").window("close");

            },"text");
            $("input[name='pua_count']").treegrid("change");
        });
    })

</script>
</body>
</html>
