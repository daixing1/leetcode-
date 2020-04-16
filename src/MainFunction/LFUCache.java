package MainFunction;

import DataStructure.LFU;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/4/5
 * Time: 9:47
 * Description: 设计并实现最不经常使用（LFU）缓存的数据结构。它应该支持以下操作：get 和 put。
 *              get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 *              put(key, value) - 如果键不存在，请设置或插入值。当缓存达到其容量时，它应该在插入新项目之前，
 *              使最不经常使用的项目无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，
 *              最近最少使用的键将被去除。
 */
public class LFUCache {
    private int capacity;
    private Map<Integer, LFU> map = new HashMap<>();
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (capacity==0){
            return -1;
        }else if (!map.containsKey(key)){
            return -1;
        }else {
            LFU lfu = map.get(key);
            lfu.setCnt(lfu.getCnt()+1);
            lfu.setTime(new Date());
            return map.get(key).getValue();
        }
    }

    public void put(int key, int value) {
        if (map.size()<capacity){
            LFU lfu = new LFU();
            lfu.setCnt(0);
            lfu.setKey(key);
            lfu.setValue(value);
            lfu.setTime(new Date());
            map.put(key,lfu);
            capacity++;
        }else {
            int mcnt = Integer.MAX_VALUE;
            Date mtime = new Date();
            for (Map.Entry<Integer, LFU> entry:map.entrySet()){
                if (mcnt > entry.getValue().getCnt()){
//                    mcnt
                }
            }
        }
    }
}
