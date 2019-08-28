package com.mg.coder.nodb.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public abstract class BaseDao<T> {

    @Autowired
    MongoTemplate template;

    /**
     * 插入数据
     * @param t
     * @return
     */
    public T insert(T t)
    {
        return template.insert(t);
    }

    /**
     * 删除数据
     * @param t
     */
    public void delete(T t){
         template.remove(t);
    }

    /**
     * h获取单个数据
     * @param key
     * @param cl
     * @return
     */
    public T get(String key,Class cl){
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(key));
        return (T) template.findOne(query,cl);
    }

    /**
     * 获取所有数据
     * @param cl
     * @return
     */
    public List<T> findall(Class cl){
        return template.findAll(cl);
    }


}
