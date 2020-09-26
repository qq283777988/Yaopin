package com.guigu.controller;
import com.guigu.service.MenuService;
import com.guigu.vo.Employee;
import com.guigu.vo.Menu;
import com.guigu.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class MenuController {
    @Autowired
    MenuService menuService;
    @RequestMapping("/querymenuall.action")
    @ResponseBody  //通知框架   返回的集合，vo，map  转成json格式  jackson.jar
    public List<Menu> querymenuall(@RequestParam(value = "id", defaultValue = "0") int id,
                                   HttpSession session)
    {
        System.out.println("----------------");
        Employee employee = (Employee) session.getAttribute("employee");
        System.out.println("***"+employee);
        return menuService.queryMenuByPidEmpid(id,employee.getEmp_id());
    }
    //授权页面  显示菜单所有数据  包含子节点的选中状态
    @RequestMapping("/querymenus.action")
    @ResponseBody
    public List<Menu> querymenus(
            @RequestParam(value = "rol_id", defaultValue = "0") int rol_id) {

        System.out.println("*****"+rol_id);
        return menuService.queryMenuByrid(rol_id);
    }
    @RequestMapping("/queryMenu.action")
    @ResponseBody
    public PageVo<Menu> queryMenu(
                                          @RequestParam(value = "page",defaultValue = "1") int page,
                                          @RequestParam(value = "rows",defaultValue = "2")int rows){
        return menuService.queryMenu(page,rows);
    }
}
