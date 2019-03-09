package com.mxl.najc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mxl.najc.dao.GoodsMapper;
import com.mxl.najc.entity.GoodsVo;

import java.util.List;
import java.util.Map;


@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsDao;


    public GoodsVo queryObject(Integer id) {
        return goodsDao.queryObject(id);
    }


    public List<GoodsVo> queryList(Map<String, Object> map) {
        return goodsDao.queryList(map);
    }
    
    public List<GoodsVo> queryKillList() {
        return goodsDao.queryKillList();
    }


    public int queryTotal(Map<String, Object> map) {
        return goodsDao.queryTotal(map);
    }


    public void save(GoodsVo goods) {
        goodsDao.save(goods);
    }


    public void update(GoodsVo goods) {
        goodsDao.update(goods);
    }


    public void delete(Integer id) {
        goodsDao.delete(id);
    }


    public void deleteBatch(Integer[] ids) {
        goodsDao.deleteBatch(ids);
    }

    public List<GoodsVo> queryHotGoodsList(Map<String, Object> map) {
        return goodsDao.queryHotGoodsList(map);
    }

    public List<GoodsVo> queryCatalogProductList(Map<String, Object> map) {
        return goodsDao.queryCatalogProductList(map);
    }

    public List<GoodsVo> queryFxList(Map<String, Object> map) {
        return goodsDao.queryFxList(map);
    }
}
