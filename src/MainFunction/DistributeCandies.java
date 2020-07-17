package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/5/29
 * Time: 7:21
 * Description: 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
 *              你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        int len = candies.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int c:candies){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        return (int)Math.min(len/2,map.size());
    }
}
