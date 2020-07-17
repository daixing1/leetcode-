package MainFunction;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * User: 兴希
 * Date: 2020/6/13
 * Time: 10:39
 * Description: 假设你正在读取一串整数。每隔一段时间，你希望能找出数字 x 的秩(小于或等于 x 的值的个数)。
 *              请实现数据结构和算法来支持这些操作，也就是说：
 *              实现 track(int x) 方法，每读入一个数字都会调用该方法；
 *              实现 getRankOfNumber(int x) 方法，返回小于或等于 x 的值的个数。
 *              注意：本题相对原题稍作改动
 */
public class StreamRank {
    private TreeMap<Integer, Integer> map;
    public StreamRank() {
        map = new TreeMap<>((o1, o2) -> o2-o1);
    }

    public void track(int x) {
        boolean flag = false;
        if (map.containsKey(x)){
            flag = true;
        }else {
            flag = false;
        }
        map.put(x,map.getOrDefault(x,0)+1);
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            if (key>x){
                map.put(key,next.getValue()+1);
            }else if (!flag&&key<x){
                map.put(x,map.get(key)+1);
                break;
            }
        }
    }

    public int getRankOfNumber(int x) {
        if (map.isEmpty()){
            return 0;
        }
        if (map.containsKey(x)){
            return map.get(x);
        }
        int count = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            Integer key = next.getKey();
            if (key<x){
                count = next.getValue();
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        StreamRank streamRank = new StreamRank();
        streamRank.track(4);
        streamRank.track(3);
        streamRank.track(5);
        int rankOfNumber = streamRank.getRankOfNumber(8);
        streamRank.track(3);
        int rankOfNumber1 = streamRank.getRankOfNumber(2);
        streamRank.track(1);
        streamRank.track(5);
        int rankOfNumber2 = streamRank.getRankOfNumber(3);
        int rankOfNumber3 = streamRank.getRankOfNumber(5);
        streamRank.track(1);
        int rankOfNumber4 = streamRank.getRankOfNumber(9);
        streamRank.track(6);
        int rankOfNumber5 = streamRank.getRankOfNumber(3);
        streamRank.track(4);
        streamRank.track(1);
        int rankOfNumber6 = streamRank.getRankOfNumber(7);
        streamRank.track(9);
        streamRank.track(2);
        streamRank.track(9);
    }
}
