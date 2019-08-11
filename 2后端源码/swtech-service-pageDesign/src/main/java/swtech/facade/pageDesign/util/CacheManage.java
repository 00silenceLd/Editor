package swtech.facade.pageDesign.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author:张宇
 * 2017.12.27
 */
public class CacheManage {

    private static Logger logger = LoggerFactory.getLogger(CacheManage.class);

    private static Map<String, Cache> caches = new ConcurrentHashMap();

    /**
     * 存入缓存
     * @param key
     * @param cache
     */
    public static void putCache(String key, Cache cache) {
        caches.put(key, cache);
    }

    /**
     * 存入缓存
     * @param key
     * @param
     */
    public static void putCache(String key, Object datas, long timeOut) {
        timeOut = timeOut > 0 ? timeOut : 0L;
        putCache(key, new Cache(datas, timeOut, System.currentTimeMillis()));
    }

    /**
     * 获取对应缓存
     * @param key
     * @return
     */
    public static Cache getCacheByKey(String key) {
        if (isContains(key)) {
            return caches.get(key);
        }
        return null;
    }

    /**
     * 获取对应缓存
     * @param key
     * @return
     */
    public static Object getCacheDataByKey(String key) {
        if (isContains(key)) {
            return caches.get(key).getDatas();
        }
        return null;
    }

    /**
     * 获取所有缓存
     * @param
     * @return
     */
    public static Map<String, Cache> getCacheAll() {
        return caches;
    }

    /**
     * 判断是否在缓存中
     * @param key
     * @return true false
     */
    public static boolean isContains(String key) {
        return caches.containsKey(key);
    }


    /**
     * 清除对应缓存
     * @param key
     */
    public static void clearByKey(String key) {
        if (isContains(key)) {
            caches.remove(key);
        }
    }

    /**
     * 缓存是否超时失效
     * @param key
     * @return
     */
    public static boolean isTimeOut(String key) {
        if (!caches.containsKey(key)) {
            return true;
        }
        Cache cache = caches.get(key);
        long timeOut = cache.getTimeOut();
        long lastRefreshTime = cache.getLastRefeshTime();
        if (timeOut == 0 || System.currentTimeMillis() - lastRefreshTime >= timeOut) {
            clearByKey(key);
            return true;
        }
        return false;
    }



    public static void main(String[] args){

        CacheManage cacheManage = new CacheManage();

        //1.判断key是否失效 true失效 false未失效
        if (cacheManage.isTimeOut("abc")){
            //往数据库拿数据


            //失效创建key
            cacheManage.putCache("abc", "test", 10 * 1000L);
        }else{
            //return 数据
            cacheManage.getCacheDataByKey("abc");
        }

    }
}
