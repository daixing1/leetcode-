package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/5/15
 * Time: 9:53
 * Description: 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。
 *              这样的坡的宽度为 j - i。
 *              找出 A 中的坡的最大宽度，如果不存在，返回 0
 */
public class MaxWidthRamp {
    public static int maxWidthRamp(int[] A) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<A.length;i++){
            for (int n:map.keySet()){
                if (A[i]>=A[n]){
                    map.put(n,i-n);
                }
            }
            map.put(i,0);
        }
        int res = map.values().stream().max(Integer::compareTo).get();
        return res;
    }

    public static void main(String[] args) {
        int i = maxWidthRamp(new int[]{9,8,1,0,1,9,4,0,4,1});
        System.out.println(i);
    }
}
