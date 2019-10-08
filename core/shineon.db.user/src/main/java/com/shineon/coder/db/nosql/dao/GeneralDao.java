package com.shineon.coder.db.nosql.dao;

import com.shineon.coder.db.nosql.pojo.GeneralItem;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class GeneralDao extends BaseDao<GeneralItem> {

    /**
     * 模糊查询
     * @param str
     * @return
     */
    public List<GeneralItem> findall(String str)
    {
        Pattern pattern = Pattern.compile(".*?aaaa.*");

        Criteria criteria=Criteria.where("content").regex(pattern);

        Query query = new Query(criteria);
        return   template.find(query, GeneralItem.class);
    }

    public List<GeneralItem> findall(int type)
    {
        Criteria criteria = Criteria.where("type").gte(type);
        Query query = new Query(criteria);
        return   template.find(query, GeneralItem.class);
    }
}
