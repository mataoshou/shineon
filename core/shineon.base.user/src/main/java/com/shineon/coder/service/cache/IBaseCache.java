package com.shineon.coder.service.cache;

import com.shineon.coder.db.pojo.QueryItem;
import com.shineon.coder.kernel.common.cache.CacheUtil;
import com.shineon.coder.kernel.constant.cache.CacheConstant;
import com.shineon.coder.service.convert.BasicCommonUtil;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.CommonItemUtils;
import com.shineon.coder.service.convert.util.QueryItemCommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

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
public abstract class IBaseCache<POJO,DTO extends CommonItemUtils<POJO>>
        implements ApplicationListener<ApplicationReadyEvent> {


    @Autowired
    CacheUtil util;

    @Autowired
    BasicCommonUtil basicCommonUtil;

    @Autowired
    QueryItemCommonUtil queryItemCommonUtil;

    ///////////////////////////////////////////////////常量区////////////////////////////////////////////////////////
    String cachePre ="";
    String cacheLast ="";

    private long liveTime = CacheConstant.CACHE_LIVE;

    public void setLiveTime(long live)
    {
        liveTime = live;
    }

    String list_sign = CacheConstant.CACHE_DATE_LIST_SIGN;

    String pojo_sign = CacheConstant.CACHE_DATE_POJO_SIGN;

    public void setList_sign(String list_sign) {
        this.list_sign = list_sign;
    }

    public void setPojo_sign(String pojo_sign) {
        this.pojo_sign = pojo_sign;
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////  自定义区域  ////////////////////////////////////////////////////////////
    /**
     * 检查是否更新缓存
     * @param key
     * @return
     */
    protected abstract boolean check(String key);

    /**
     * 缓存更新成功
     * @param key
     * @param pojos
     * @return
     */
    protected abstract boolean success(String key,List<POJO> pojos);


    /**
     * 缓存更新成功
     * @param key
     * @param pojos
     * @return
     */
    protected abstract boolean fail(String key,List<POJO> pojos,Exception e);

    /**
     * 返回作为key值的字段值
     * @param pojo
     * @return
     */
    protected abstract String getKeyParams(POJO pojo);

    /**
     * 缓存中没有数据，从数据库中获取 列表数据
     * @param queryItem
     * @return
     */
    protected abstract CommonItem selectListByDB(QueryItem queryItem);


    /**
     * 更新缓存前，需要更新数据库的数据
     * @param pojo
     * @return
     */
    protected abstract void updatePojoByDB(POJO pojo);

    /**
     * 更新缓存前，需要更新数据库的数据
     * @param pojo
     * @return
     */
    protected abstract void deletePojoByDB(POJO pojo);


    /**
     * 缓存中没有数据，从数据库中获取 单个数据
     * @param queryItem
     * @return
     */
    protected abstract CommonItem getPojoByDB(QueryItem queryItem);


    protected abstract void initCache();



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

   //////////////////////////////////////////初始化区域/////////////////////////////////////////////////////////////

    DTO dto;

    /**
     * 设置dto对象
     * @param _dto
     */
    protected  void setDTO(DTO _dto)
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

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////操作区域//////////////////////////////////////////////////////////////


    /**
     *获取缓存数据
     * 私有方法，不对外开放
     */
    private POJO getPOJO(String key) throws Exception {
        String item = getKey(key);

        POJO pojo = dto.toPojo(util.get(item));
        if(pojo==null)
        {
            QueryItem queryItem =queryItemCommonUtil.createPojo(getKeyParams(pojo));

            pojo = get(queryItem);

        }
        return pojo;
    }


    /**
     *获取缓存数据
     */
    public final POJO get(QueryItem qitem) throws Exception {
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
    public final String getKey(QueryItem item) throws Exception {
        if (item == null)
        {
            item = new QueryItem();
        }

        return util.createCacheKey(cachePre,cacheLast,item,list_sign);
    }

    /**
     * 获取缓存列表数据
     * @param key
     * @return
     * @throws Exception
     */
    public final List<POJO> getListCache(QueryItem key) throws Exception {
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
    public final List<POJO> getListCache(List<String> ukeys) throws Exception {

        List<POJO> list = new ArrayList();
        for(String ukey:ukeys)
        {
            list.add(getPOJO(ukey));
        }
        return list;
    }


        /**
     * 删除单个pojo的缓存
     */
    private void delete(POJO pojo,boolean deleteDB) throws Exception {
        deleteListKeys();
        String rkey = getKey(getKeyParams(pojo));
        util.delete(rkey);
        if(deleteDB)
        {
            deletePojoByDB(pojo);
        }
    }

    /**
     * 删除单个pojo的缓存
     */
    public final void delete(POJO pojo) throws Exception {
        delete(pojo,true);
    }

    /**
     * 删除所有列表数据的缓存
     * 私有方法，不对外开放
     */
    private  void deleteListKeys()
    {
        String keyPattern =  cachePre + "." + list_sign +"*";
        util.deleteKeys(keyPattern);
    }

    /**
     * 更新缓存 删除数据,然后更新数据
     * @return
     */
    public final boolean update(POJO pojo) throws Exception {

        delete(pojo,false);
        setCache(pojo);

        return true;
    }


    /**
     *缓存单个pojo数据
     */
    public final boolean setCache(POJO pojo) throws Exception {
        QueryItem item = new QueryItem();
        item.setId(getKeyParams(pojo));
        return setCache(item,toList(pojo));
    }


    /**
     * 设置缓存  这个类的最核心代码区
     * @param itemKey
     * @param pojos
     * @return
     * @throws Exception
     */
    public final boolean setCache(QueryItem itemKey,List<POJO> pojos)throws Exception{

        String keyData = getKey(itemKey);

        if(!check(keyData))
        {
            return false;
        }
        try {
            if (lock(keyData)) {
                util.delete(keyData);
                log.info("添加缓存数据：" + keyData);

                List<String> userKeys = new ArrayList();

                for(POJO pojo : pojos)
                {
                    String uKey = getKey(getKeyParams(pojo));

                    util.delete(uKey);

                    updatePojoByDB(pojo);
                    util.set(uKey,dto.toCommon(pojo).toJsonString(),liveTime);

                    userKeys.add(getKeyParams(pojo));
                }


                util.set(keyData,basicCommonUtil.toCommon(userKeys).toJsonString(),liveTime);

                success(keyData,pojos);

                unlock(keyData);
                return true;
            }
        }
        catch (Exception e)
        {
            unlock(keyData);
            log.info("缓存数据更新失败："+keyData);
            e.printStackTrace();

            fail(keyData,pojos,e);
        }

        return true;
    }

    public boolean lock(String key)
    {
        String keyLock = key +".LOCK";
        return util.lock(keyLock);
    }

    public boolean unlock(String key)
    {
        String keyLock = key +".LOCK";
        return util.unlock(keyLock);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////////////////辅助方法///////////////////////////////////////////////////////////
    /**
     * 获取单个缓存数据
     * @param guid
     * @return
     * @throws Exception
     */
    public String getKey(String guid) throws Exception {
        return util.createCacheKey(cachePre,pojo_sign,cacheLast,guid);
    }

    public List<POJO> toList(POJO pojo)
    {
        List<POJO> list = new ArrayList<POJO>();
        list.add(pojo);
        return list;
    }


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        initCache();
    }
}
