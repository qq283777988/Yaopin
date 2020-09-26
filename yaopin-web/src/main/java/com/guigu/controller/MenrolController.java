package com.guigu.controller;

import com.guigu.service.MenrolService;
import com.guigu.service.MenuService;
import com.guigu.vo.Menrol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MenrolController {
    @Autowired
    MenrolService menrolService;
    @RequestMapping(value = "/shouquan.action",produces = "text/json;charset=utf-8")
    @ResponseBody
    public String shouquan(int rol_id,String mids){

        System.out.println("角色id："+rol_id);

        String[] midss = mids.split(",");   //演示需要  该代码 放入service层

        System.out.println(Arrays.toString(midss));
    List<Menrol> mjiace=menrolService.queryMenrolByrid(rol_id);
        System.out.println("权限表中的实体"+mjiace);
       List<Menrol> menrolList=new ArrayList<>();
       if(mjiace!=null){
           int num=menrolService.deleteMenroluByridmid(rol_id);
       }
        for(String s:midss){
            Menrol menrol=new Menrol();
            menrol.setMen_id(Integer.parseInt(s));
            menrol.setRol_id(rol_id);
            menrolList.add(menrol);
        }
        System.out.println("添加list"+menrolList);
        int numm=menrolService.addMenurolByridmid(menrolList);
        System.out.println("添加num"+numm);
        if(numm==midss.length){
            return "授权成功";
        }
        return "授权失败";

    }
}
