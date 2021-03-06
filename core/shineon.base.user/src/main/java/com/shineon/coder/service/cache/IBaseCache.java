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
 * @param <commonutil>
 */
@Slf4j
public abstract class IBaseCache<POJO,CommonUtils extends CommonItemUtils<POJO>>
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
    protected abstract CommonItem updatePojoByDB(POJO pojo);

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

    CommonUtils commonutil;

    /**
     * 设置dto对象
     * @param _commonutil
     */
    protected  void setCommonutil(CommonUtils _commonutil)
    {
        this.commonutil =  _commonutil;
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

        POJO pojo = commonutil.toPojo(util.get(item));
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

            POJO pojo = commonutil.toPojo(getPojoByDB(qitem));
            if(pojo==null)return null;
            setCache(pojo,false);
            return pojo;
        }
        if(ukeys.size()>1)
        {
            log.info("缓存数据量超过1条"+qitem.toJsonString());
        }
        return commonutil.toPojo(util.get(getKey(ukeys.get(0))));
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
            if(key ==null)
            {
                key = new QueryItem();
            }

            CommonItem datas = selectListByDB(key);
            List<POJO> pojos = commonutil.toPojoList(datas);
            setCache(key,pojos,false);
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
    private void delete(POJO pojo,boolean synDB) throws Exception {
        deleteListKeys();
        String rkey = getKey(getKeyParams(pojo));
        util.delete(rkey);
        if(synDB)
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
        log.info("清理列表数据：" + keyPattern);
        util.deleteKeys(keyPattern);
    }

    /**
     * 更新缓存 删除数据,然后更新数据
     * @return
     */
    public final POJO update(POJO pojo,boolean synDB) throws Exception {
        delete(pojo,false);

        return  setCache(pojo,true);
    }


    /**
     *缓存单个pojo数据
     */
    public final POJO setCache(POJO pojo,boolean synDB) throws Exception {

        delete(pojo,false);
        if(getKeyParams(pojo)==null&&synDB)
        {
            pojo = commonutil.toPojo(updatePojoByDB(pojo));
        }
        QueryItem item = new QueryItem();
        item.setId(getKeyParams(pojo));
        return setCache(item,toList(pojo),synDB).get(0);
    }



    /**
     * 设置缓存  这个类的最核心代码区
     * @param itemKey
     * @param pojos
     * @return
     * @throws Exception
     */
    private final List<POJO> setCache(QueryItem itemKey,List<POJO> pojos,boolean synDB)throws Exception{

        String keyData = getKey(itemKey);

        if(!check(keyData))
        {
            return null;
        }
        try {
            if (lock(keyData)) {
                util.delete(keyData);
                log.info("添加缓存数据：" + keyData);

                List<String> userKeys = new ArrayList();

                for(int i=0;i<pojos.size();i++)
                {

                    POJO pojo = pojos.get(i);
                    String uKey = getKey(getKeyParams(pojo));

                    util.delete(uKey);

                    if(synDB) {
                        pojo = commonutil.toPojo(updatePojoByDB(pojo));
                        pojos.remove(i);
                        pojos.add(i,pojo);
                    }
                    util.set(uKey,commonutil.toCommon(pojo).toJsonString(),liveTime);

                    userKeys.add(getKeyParams(pojo));
                }


                util.set(keyData,basicCommonUtil.toCommon(userKeys).toJsonString(),liveTime);

                success(keyData,pojos);

                unlock(keyData);
                return pojos;
            }
        }
        catch (Exception e)
        {
            unlock(keyData);
            log.info("缓存数据更新失败："+keyData);
            e.printStackTrace();

            fail(keyData,pojos,e);
            throw e;
        }

        return pojos;
    }

    public boolean lock(String key)
    {
        String keyLock = key +".LOCK";
        return util.lock(keyLock);
    }

    public boolean lock(String key,long timeout)
    {
        String keyLock = key +".LOCK";
        return util.lock(keyLock,timeout);
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
