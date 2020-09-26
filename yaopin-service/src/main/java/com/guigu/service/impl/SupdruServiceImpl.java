package com.guigu.service.impl;

import com.github.pagehelper.PageHelper;
import com.guigu.dao.SupdruDao;
import com.guigu.dao.WardruDao;
import com.guigu.service.SupdruService;
import com.guigu.vo.Employee;
import com.guigu.vo.PageVo;
import com.guigu.vo.Supdru;
import com.guigu.vo.Wardru;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SupdruServiceImpl  implements SupdruService {
    @Autowired
    SupdruDao supdruDao;


    @Override
    public List<Supdru> queryallSupdruBydruid(int dru_id) {
        return supdruDao.queryallSupdruBydruid(dru_id);
    }

    @Override
    public PageVo<Supdru> querySupdru(Supdru supdru, int page, int rows) {
        PageVo<Supdru> pageVo = new PageVo<>();
        //在需要分页的代码调用前 执行以下代码
        PageHelper.startPage(page, rows);
        //获取分页后 显示的数据集合
        pageVo.setRows(supdruDao.queryallSupdru(supdru));
        //获取总的记录数量
        System.out.println("shu"+supdruDao.querycountSupdru(supdru));
        pageVo.setTotal(supdruDao.querycountSupdru(supdru));

        return pageVo;
    }

    @Override
    public List<Supdru> querySupdruBylistsupdruid(int[] supdru) {
        return supdruDao.querySupdruBylistsupdruid(supdru);
    }


    @Override
    public int deleteSupdruBydruid(int[] ids) {
        return supdruDao.deleteSupdruBydruid(ids);
    }

    @Override
    public List<Supdru> querySupdruBypua_sdzhongid(int pua_sdzhongid) {
        return supdruDao.querySupdruBypua_sdzhongid(pua_sdzhongid);
    }

    @Override
    public Supdru queryallSupdruByid(int id) {
        return supdruDao.queryallSupdruByid(id);
    }

    @Override
    public List<Supdru> querySupdruBywahid(int wah_id) {
        return supdruDao.querySupdruBywahid(wah_id);
    }

    @Override
    public List<Supdru> querySupdruBywid(int wid) {
        return supdruDao.querySupdruBywid(wid);
    }

    @Override
    public Supdru queryallSupdruBysupdruid(int sup_id, int dru_id) {
        return supdruDao.queryallSupdruBysupdruid(sup_id,dru_id);
    }

    @Override
    public Supdru querySupdruBywiddruidwarid(int wid, int dru_id, int war_id) {
        return supdruDao.querySupdruBywiddruidwarid(wid,dru_id,war_id);
    }
}
