package com.mxl.najc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mxl.najc.dao.TopicMapper;
import com.mxl.najc.entity.TopicVo;

import java.util.List;
import java.util.Map;


@Service
public class TopicService {
    @Autowired
    private TopicMapper topicDao;


    public TopicVo queryObject(Integer id) {
        return topicDao.queryObject(id);
    }


    public List<TopicVo> queryList(Map<String, Object> map) {
        return topicDao.queryList(map);
    }


    public int queryTotal(Map<String, Object> map) {
        return topicDao.queryTotal(map);
    }


    public void save(TopicVo topic) {
        topicDao.save(topic);
    }


    public void update(TopicVo topic) {
        topicDao.update(topic);
    }


    public void delete(Integer id) {
        topicDao.delete(id);
    }


    public void deleteBatch(Integer[] ids) {
        topicDao.deleteBatch(ids);
    }

}
