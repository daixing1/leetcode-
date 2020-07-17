package MainFunction;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * User: 兴希
 * Date: 2020/6/25
 * Time: 9:55
 * Description: 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
 *              1. set(string key, string value, int timestamp)
 *              存储键 key、值 value，以及给定的时间戳 timestamp。
 *              2. get(string key, int timestamp)
 *              返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中timestamp_prev<=timestamp。
 *              如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 *              如果没有值，则返回空字符串（""）。
 */
public class TimeMap {
    /** Initialize your data structure here. */
    Map<String, Map<Integer, String>> mapMap;
    public TimeMap() {
        mapMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (mapMap.containsKey(key)){
            Map<Integer, String> integerStringMap = mapMap.get(key);
            integerStringMap.put(timestamp,value);
        }else {
            Map<Integer, String> map = new TreeMap<>((o1, o2) -> o2-o1);
            map.put(timestamp,value);
            mapMap.put(key,map);
        }
    }

    public String get(String key, int timestamp) {
        if (!mapMap.containsKey(key)){
            return "";
        }else {
            Map<Integer, String> map = mapMap.get(key);
            Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Integer, String> next = iterator.next();
                if (next.getKey()<=timestamp){
                    return next.getValue();
                }
            }
            return "";
        }
    }
}
