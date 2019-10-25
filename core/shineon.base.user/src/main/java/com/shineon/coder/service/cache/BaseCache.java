package com.shineon.coder.service.cache;

import com.esotericsoftware.minlog.Log;
import com.shineon.coder.db.pojo.QueryItem;
import com.shineon.coder.kernel.common.cache.CacheUtil;
import com.shineon.coder.service.convert.CommonItemUtils;
import com.shineon.coder.service.dto.BasicDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public abstract class BaseCache<POJO,DTO extends CommonItemUtils<POJO>> {


    @Autowired
    CacheUtil util;

    @Autowired
    BasicDTO basicDTO;

    String cachePre ="";
    String cacheLast ="";


    /**
     * 检查是否更新缓存
     * @param key
     * @return
     */
    public abstract boolean check(String key);

    /**
     * 缓存更新成功
     * @param key
     * @param body
     * @return
     */
    public abstract boolean success(String key,String body);

    /**
     * 返回作为key值的字段值
     * @param pojo
     * @return
     */
    public abstract String getKeyParams(POJO pojo);

    public boolean setCache(QueryItem itemKey,List<POJO> pojos)throws Exception{

        String keyData = getKey(itemKey);

        if(!check(keyData))
        {
            return false;
        }

        String keyLock = keyData +".LOCK";

        try {
            if (util.lock(keyLock)) {
                util.delete(keyData);
                Log.info("添加缓存数据：" + keyData);

                List<String> userKeys = new ArrayList();

                for(POJO pojo : pojos)
                {
                    String uKey = getKey(getKeyParams(pojo));

                    util.delete(uKey);
                    util.set(uKey,dto.toCommon(pojo));

                    userKeys.add(getKeyParams(pojo));
                }


                util.set(keyData,basicDTO.toCommon(userKeys));

                success(keyData,SysCache.single.getCommonItem(keyData).toJsonString());

                util.unlock(keyLock);
                return true;
            }
        }
        catch (Exception e)
        {
            util.unlock(keyLock);
            log.info("缓存数据更新失败："+keyData);
            e.printStackTrace();
        }

        return true;
    }

    DTO dto;

    /**
     * 设置dto对象
     * @param _dto
     */
    public void setDTO(DTO _dto)
    {
        this.dto =  _dto;
    }


    /**
     * 设置修饰词
     */
    public void setCacheDecorate(String _cachePre,String _cacheLast)
    {
        this.cachePre =_cachePre;
        this.cacheLast = _cacheLast;
    }

    /**
     * 删除缓存
     */
    public void delete(String key) throws Exception {
        String rkey = getKey(key);
        util.delete(rkey);
    }


    /**
     *获取缓存数据
     */
    public POJO get(String key) throws Exception {
        String rkey = getKey(key);
        return dto.toPojo(util.get(getKey(key)));
    }

    /**
     *获取缓存数据
     */
    public POJO get(QueryItem qitem) throws Exception {
        List<String> ukeys = basicDTO.toPojoList(util.get(getKey(qitem)));
        if(ukeys==null)
        {
            log.info("缓存不存在，需要从数据库查询:" + qitem.toJsonString());
            return null;
        }
        if(ukeys.size()>1)
        {
            log.info("缓存数据量超过1条"+qitem.toJsonString());
        }
        return dto.toPojo(util.get(getKey(ukeys.get(0))));
    }


    public String getKey(String guid) throws Exception {
        return util.createCacheKey(cachePre,cacheLast,guid);
    }

    public String getKey(QueryItem item) throws Exception {
        if (item == null)
        {
            item = new QueryItem();
        }

        return util.createCacheKey(cachePre,cacheLast,item);
    }


    public List<POJO> getListCache(QueryItem key) throws Exception {
        List<String> ukeys = basicDTO.toPojoList(util.get(getKey(key)));
        return getListCache(ukeys);
    }



    public List<POJO> getListCache(List<String> ukeys) throws Exception {

        List<POJO> list = new ArrayList();
        for(String ukey:ukeys)
        {
            list.add(get(ukey));
        }

        return list;
    }

}
