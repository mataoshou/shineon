package com.shineon.coder.service.cache;

import com.shineon.coder.db.pojo.QueryItem;
import com.shineon.coder.kernel.common.cache.CacheUtil;
import com.shineon.coder.kernel.constant.cache.CacheConstant;
import com.shineon.coder.service.convert.BasicCommonUtil;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.CommonItemUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/**
 * 缓存的基础类
 * 待改进部分  缓存的删除和编辑
 *
 * @param <POJO>
 * @param <DTO>
 */
@Slf4j
public abstract class BaseCache<POJO,DTO extends CommonItemUtils<POJO>> {


    @Autowired
    CacheUtil util;

    @Autowired
    BasicCommonUtil basicCommonUtil;

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
     * @param pojos
     * @return
     */
    public abstract boolean success(String key,List<POJO> pojos);


    /**
     * 缓存更新成功
     * @param key
     * @param pojos
     * @return
     */
    public abstract boolean fail(String key,List<POJO> pojos,Exception e);

    /**
     * 返回作为key值的字段值
     * @param pojo
     * @return
     */
    public abstract String getKeyParams(POJO pojo);

    /**
     * 缓存中没有数据，从数据库中获取 列表数据
     * @param queryItem
     * @return
     */
    public abstract CommonItem selectListByDB(QueryItem queryItem);


    /**
     * 缓存中没有数据，从数据库中获取 单个数据
     * @param queryItem
     * @return
     */
    public abstract CommonItem getPojoByDB(QueryItem queryItem);

    /**
     * 设置缓存  这个类的最核心代码区
     * @param itemKey
     * @param pojos
     * @return
     * @throws Exception
     */
    public boolean setCache(QueryItem itemKey, List<POJO> pojos)throws Exception{

        String keyData = getKey(itemKey);

        if(!check(keyData))
        {
            return false;
        }

        String keyLock = keyData +".LOCK";

        try {
            if (util.lock(keyLock)) {
                util.delete(keyData);
                log.info("添加缓存数据：" + keyData);

                List<String> userKeys = new ArrayList();

                for(POJO pojo : pojos)
                {
                    String uKey = getKey(getKeyParams(pojo));

                    util.delete(uKey);
                    util.set(uKey,dto.toCommon(pojo).toJsonString(), CacheConstant.CACHE_LIVE);

                    userKeys.add(getKeyParams(pojo));
                }


                util.set(keyData,basicCommonUtil.toCommon(userKeys).toJsonString(), CacheConstant.CACHE_LIVE);

                success(keyData,pojos);

                util.unlock(keyLock);
                return true;
            }
        }
        catch (Exception e)
        {
            util.unlock(keyLock);
            log.info("缓存数据更新失败："+keyData);
            e.printStackTrace();

            fail(keyData,pojos,e);
        }

        return true;
    }

    DTO dto;

    /**
     * 设置dto对象
     * @param _dto
     */
    protected void setDTO(DTO _dto)
    {
        this.dto =  _dto;
    }


    /**
     * 设置修饰词
     */
    protected void setCacheDecorate(String _cachePre,String _cacheLast)
    {
        this.cachePre =_cachePre;
        this.cacheLast = _cacheLast;
    }

    /**
     * 删除单个pojo的缓存
     */
    public void delete(String key) throws Exception {
        deleteListKeys();
        String rkey = getKey(key);
        util.delete(rkey);
    }

    /**
     * 删除所有列表数据的缓存
     * 私有方法，不对外开放
     */
    private void deleteListKeys()
    {
        String keyPattern =  cachePre + "." + CacheConstant.CACHE_LIST_PRE +"*";
        util.deleteKeys(keyPattern);
    }


    /**
     *获取缓存数据
     * 私有方法，不对外开放
     */
    private POJO getPOJO(String key) throws Exception {
        String item = getKey(key);

        POJO pojo = dto.toPojo(util.get(item));
        if(pojo==null)
        {
            QueryItem queryItem = new QueryItem();
            queryItem.setId(getKeyParams(pojo));

            pojo = get(queryItem);

        }
        return pojo;
    }

    /**
     *缓存单个pojo数据
     */
    public boolean setCache(POJO pojo) throws Exception {
        QueryItem item = new QueryItem();
        item.setId(getKeyParams(pojo));
        return setCache(item,toList(pojo));
    }

    public List<POJO> toList(POJO pojo)
    {
        List<POJO> list = new ArrayList<POJO>();
        list.add(pojo);
        return list;
    }


    /**
     * 更新缓存 会删除所有的列表数据
     * //////////////////////////////////////待改进为删除相关的列表数据/////////////////////////////////
     * @return
     */
    public POJO update(String key) throws Exception {

        deleteListKeys();
        return getPOJO(key);
    }

    /**
     *获取缓存数据
     */
    public POJO get(QueryItem qitem) throws Exception {
        CommonItem commonItem = util.get(getKey(qitem));
        List<String> ukeys = null;
        if(commonItem!=null)
        {
            ukeys = basicCommonUtil.toPojoList(commonItem);
        }

        if(ukeys==null)
        {
            log.info("缓存不存在，需要从数据库查询:" + qitem.toJsonString());
            POJO pojo = dto.toPojo(getPojoByDB(qitem));
            if(pojo==null)return null;
            setCache(pojo);
            return pojo;
        }
        if(ukeys.size()>1)
        {
            log.info("缓存数据量超过1条"+qitem.toJsonString());
        }
        return dto.toPojo(util.get(getKey(ukeys.get(0))));
    }



    /**
     * 获取单个缓存数据
     * @param item
     * @return
     * @throws Exception
     */
    public String getKey(QueryItem item) throws Exception {
        if (item == null)
        {
            item = new QueryItem();
        }

        return util.createCacheKey(cachePre,cacheLast,item);
    }

    /**
     * 获取缓存列表数据
     * @param key
     * @return
     * @throws Exception
     */
    public List<POJO> getListCache(QueryItem key) throws Exception {
        CommonItem item = util.get(getKey(key));
        if(item == null)
        {
            List<POJO> pojos = dto.toPojoList(selectListByDB(key));
            setCache(key,pojos);
            return pojos;
        }
        else {
            List<String> ukeys = basicCommonUtil.toPojoList(item);
            return getListCache(ukeys);
        }
    }


    /**
     * 获取缓存列表数据
     * @param ukeys
     * @return
     * @throws Exception
     */
    public List<POJO> getListCache(List<String> ukeys) throws Exception {

        List<POJO> list = new ArrayList();
        for(String ukey:ukeys)
        {
            list.add(getPOJO(ukey));
        }
        return list;
    }

    /**
     * 获取单个缓存数据
     * @param guid
     * @return
     * @throws Exception
     */
    public String getKey(String guid) throws Exception {
        return util.createCacheKey(cachePre,cacheLast,guid);
    }

}
