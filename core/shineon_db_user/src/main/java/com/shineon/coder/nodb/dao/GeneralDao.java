package com.shineon.coder.nodb.dao;

import com.shineon.coder.nodb.pojo.GenerallItem;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class GeneralDao extends BaseDao<GenerallItem> {

    /**
     * 模糊查询
     * @param str
     * @return
     */
    public List<GenerallItem> findall(String str)
    {
        Pattern pattern = Pattern.compile(".*?aaaa.*");

        Criteria criteria=Criteria.where("content").regex(pattern);

        Query query = new Query(criteria);
        return   template.find(query,GenerallItem.class);
    }

    public List<GenerallItem> findall(int type)
    {
        Criteria criteria = Criteria.where("type").gte(type);
        Query query = new Query(criteria);
        return   template.find(query,GenerallItem.class);
    }
}
