package com.guigu.service.impl;

import com.guigu.dao.MenrolDao;
import com.guigu.dao.MenuDao;
import com.guigu.service.MenrolService;
import com.guigu.vo.Menrol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenrolServiceImpl implements MenrolService {
    @Autowired
    MenrolDao menrolDao;
    @Override
    public int deleteMenroluByridmid(int rol_id) {
        return menrolDao.deleteMenroluByridmid(rol_id);
    }

    @Override
    public int addMenurolByridmid(List<Menrol> menrolList) {
        return menrolDao.addMenurolByridmid(menrolList);
    }

    @Override
    public List<Menrol> queryMenrolByrid(int rol_id) {
        return menrolDao.queryMenrolByrid(rol_id);
    }
}
