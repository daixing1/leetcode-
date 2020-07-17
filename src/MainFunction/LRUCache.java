package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/5/25
 * Time: 8:29
 * Description: 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作：
 *              获取数据 get 和 写入数据 put 。
 *              获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 *              写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组
 *              「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，
 *              从而为新的数据值留出空间
 */
public class LRUCache {

    private int capacity;
    private int time = 0;
    private Map<Integer, Integer> map = new HashMap<>();
//    private Map<Integer, Integer> timeMap = new TreeMap<>();
    private List<Integer> list = new ArrayList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            list.remove((Object)key);
            list.add(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (list.size()<capacity){
            if (map.containsKey(key)){
                list.remove((Object)key);
                list.add(key);
            }else {
                list.add(key);
            }
            map.put(key,value);
        }else {
            if (map.containsKey(key)){
                list.remove((Object)key);
                list.add(key);
            }else {
                Integer deKey = list.get(0);
                list.remove(0);
                list.add(key);
                map.remove(deKey);
            }
            map.put(key,value);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.get(4);
        lruCache.get(3);
        lruCache.get(2);
        lruCache.get(1);
        lruCache.put(5,5);
        lruCache.get(1);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.get(4);
        lruCache.get(5);
    }
}
