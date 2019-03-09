package com.mxl.najc.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.mxl.najc.entity.AdVo;
import com.mxl.najc.entity.BrandVo;
import com.mxl.najc.entity.CategoryVo;
import com.mxl.najc.entity.ChannelVo;
import com.mxl.najc.entity.GoodsVo;
import com.mxl.najc.entity.TopicVo;
import com.mxl.najc.service.ApiAdService;
import com.mxl.najc.service.ApiCategoryService;
import com.mxl.najc.service.ApiChannelService;
import com.mxl.najc.service.BrandService;
import com.mxl.najc.service.GoodsService;
import com.mxl.najc.service.TopicService;

/**
 * 作者: @author mxl <br>
 * 时间: 2019年3月7日 下午8:55:18<br>
 * 描述: IndexController.java <br>
 */
@RestController
@RequestMapping("/wxApi/index")
public class IndexController {
	
	@Autowired
	private GoodsService goodsService;
	@Autowired
    private TopicService topicService;
	@Autowired
    private BrandService brandService;
	@Autowired
    private ApiAdService adService;
    @Autowired
    private ApiChannelService channelService;
    @Autowired
    private ApiCategoryService categoryService;
	
	@RequestMapping("/newGoods")
	public Map<String, Object> getUsers() {
		//新商品信息
		Map<String, Object> resultObj = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("is_new", 1);
        param.put("is_delete", 0);
        PageHelper.startPage(0, 4, false);
        List<GoodsVo> newGoods = goodsService.queryList(param);
        resultObj.put("newGoodsList", newGoods);
		return resultObj;
	}
	@RequestMapping("/hotGoods")
	public Map<String, Object> hotGoods() {//新热门商品信息
		Map<String, Object> resultObj = new HashMap<String, Object>();
	        //
	    Map<String, Object> param = new HashMap<String, Object>();
	    param.put("is_hot", "1");
	    param.put("is_delete", 0);
	    PageHelper.startPage(0, 3, false);
	    List<GoodsVo> hotGoods = goodsService.queryHotGoodsList(param);
	    resultObj.put("hotGoodsList", hotGoods);
	    return resultObj;
	 }
	@RequestMapping("/topic")
	 public Map<String, Object> topic() {
	    Map<String, Object> resultObj = new HashMap<String, Object>();
	        //
	    Map<String, Object> param = new HashMap<String, Object>();
	    param.put("offset", 0);
	    param.put("limit", 3);
	    List<TopicVo> topicList = topicService.queryList(param);
	    resultObj.put("topicList", topicList);
	    return resultObj;
	   }
	@RequestMapping("/brand")
    public Map<String, Object> brand() {
        Map<String, Object> resultObj = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("is_new", 1);
        param.put("sidx", "new_sort_order ");
        param.put("order", "asc ");
        param.put("offset", 0);
        param.put("limit", 4);
        List<BrandVo> brandList = brandService.queryList(param);
        resultObj.put("brandList", brandList);
        return resultObj;
    }
	@RequestMapping("/category")
	 public Map<String, Object> category() {
	        Map<String, Object> resultObj = new HashMap<String, Object>();
	        //
	        Map<String, Object> param = new HashMap<String, Object>();
	        param = new HashMap<String, Object>();
	        param.put("parent_id", 0);
	        param.put("notName", "推荐");//<>
	        List<CategoryVo> categoryList = categoryService.queryList(param);
	        List<Map<String, Object>> newCategoryList = new ArrayList<>();

	        for (CategoryVo categoryItem : categoryList) {
	            param.remove("fields");
	            param.put("parent_id", categoryItem.getId());
	            List<CategoryVo> categoryEntityList = categoryService.queryList(param);
	            List<Integer> childCategoryIds = null;
	            if (categoryEntityList != null && categoryEntityList.size() > 0) {
	                childCategoryIds = new ArrayList<>();
	                for (CategoryVo categoryEntity : categoryEntityList) {
	                    childCategoryIds.add(categoryEntity.getId());
	                }
	            }
	            param = new HashMap<String, Object>();
	            param.put("categoryIds", childCategoryIds);
	            param.put("fields", "id as id, name as name, list_pic_url as list_pic_url, retail_price as retail_price");
	            PageHelper.startPage(0, 7, false);
	            List<GoodsVo> categoryGoods = goodsService.queryList(param);
	            Map<String, Object> newCategory = new HashMap<String, Object>();
	            newCategory.put("id", categoryItem.getId());
	            newCategory.put("name", categoryItem.getName());
	            newCategory.put("goodsList", categoryGoods);
	            newCategoryList.add(newCategory);
	        }
	        resultObj.put("categoryList", newCategoryList);
	        return resultObj;
	    }

	    @RequestMapping("/banner")
	    public Map<String, Object> banner() {
	        Map<String, Object> resultObj = new HashMap<String, Object>();
	        Map<String, Object> param = new HashMap<String, Object>();
	        param.put("ad_position_id", 1);
	        List<AdVo> banner = adService.queryList(param);
	        resultObj.put("banner", banner);
	        return resultObj;
	    }
	    @RequestMapping("/channel")
	    public Map<String, Object> channel() {
	        Map<String, Object> resultObj = new HashMap<String, Object>();
	        //
	        Map<String, Object> param = new HashMap<String, Object>();
	        param = new HashMap<String, Object>();
	        param.put("sidx", "sort_order ");
	        param.put("order", "asc ");
	        List<ChannelVo> channel = channelService.queryList(param);
	        resultObj.put("channel", channel);
	        //

	        return resultObj;
	    }
}
