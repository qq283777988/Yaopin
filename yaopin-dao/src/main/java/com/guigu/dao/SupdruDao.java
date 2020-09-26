package com.guigu.dao;

import com.guigu.vo.Drug;
import com.guigu.vo.Role;
import com.guigu.vo.Supdru;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupdruDao {
    //查询所有根据药品ID
    public List<Supdru> queryallSupdruBydruid(int dru_id);
    //查询所有
    public List<Supdru> queryallSupdru(Supdru supdru);
    //查询所有数量
    public int querycountSupdru(Supdru supdru);
    //通过供应商药品ID查
    public List<Supdru> querySupdruBylistsupdruid(int []supdru);
    //删除供应药品
    public int deleteSupdruBydruid(int[] ids);
    //添加供应药品
    //修改供应药品
    //通过进货申请中间表ID查
    public List<Supdru> querySupdruBypua_sdzhongid(int pua_sdzhongid );
    public Supdru queryallSupdruByid(int id);
    //根据入库申请表ID查药品ID
    public List<Supdru> querySupdruBywahid(int wah_id);
    //根据出库表ID查
    public List<Supdru> querySupdruBywid(int wid);
    public Supdru querySupdruBywiddruidwarid(@Param("wid") int wid,
                                             @Param("dru_id") int dru_id,
                                             @Param("war_id") int war_id);
    //根据供应商以及药品ID查
    public Supdru queryallSupdruBysupdruid( @Param("sup_id") int sup_id,
                                      @Param("dru_id") int dru_id);
}
