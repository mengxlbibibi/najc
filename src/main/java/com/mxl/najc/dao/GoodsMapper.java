package com.mxl.najc.dao;

import java.util.List;
import java.util.Map;

import com.mxl.najc.entity.GoodsVo;

/**
 * 作者: @author mxl <br>
 * 时间: 2019年3月7日 下午8:50:07<br>
 * 描述: GoodsMapper.java <br>
 */
public interface GoodsMapper extends BaseDao<GoodsVo> {
	 List<Map<String, Object>> queryAll();
	 List<GoodsVo> queryHotGoodsList(Map<String, Object> params);
	 List<GoodsVo> queryCatalogProductList(Map<String, Object> params);
	 List<GoodsVo> queryKillList();
	 List<GoodsVo> queryFxList(Map<String, Object> map);
}
