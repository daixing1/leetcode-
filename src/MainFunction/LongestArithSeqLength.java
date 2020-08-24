package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/8/22
 * Time: 21:11
 * Description: 给定一个整数数组 A，返回 A 中最长等差子序列的长度。
 *              回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中
 *              0 <= i_1 < i_2 < ... < i_k <= A.length - 1。
 *              并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。
 */
public class LongestArithSeqLength {
    public int longestArithSeqLength(int[] A) {
        int max = 0;
        int len = A.length;
        if (len==2){
            return len;
        }
        Map<Integer,Map<Integer,Integer>> mapMap = new HashMap<>();
        Map<Integer,Integer> map = new HashMap<>();
        map.put(A[1]-A[0],2);
        mapMap.put(1,map);
        max = 2;
        for (int i = 2; i < len; i++) {
            Map<Integer,Integer> map1 = new HashMap<>();
            mapMap.put(i,map1);
            int j = i-1;
            while (j>0){
                int diff = A[i]-A[j];
                Map<Integer, Integer> map2 = mapMap.get(j);
                if (map2.containsKey(diff)){
                    map1.put(diff,map2.get(diff)+1);
                }else {
                    map1.put(diff,2);
                }
                max = Math.max(max,map1.get(diff));
                j--;
            }
            if (j==0){
                if (!map1.containsKey(A[i]-A[j])){
                    map1.put(A[i]-A[j],2);
                }
            }
        }
        return max;
    }
//[22,8,57,41,36,46,42,28,42,14,9,43,27,51,0,0,38,50,31,60,29,31,20,23,37,53,27,1,47,42,28,31,10,35,39,
// 12,15,6,35,31,45,21,30,19,5,5,4,18,38,51,10,7,20,38,28,53,15,55,60,56,43,48,34,53,54,55,14,9,56,52]
    public static void main(String[] args) {
        LongestArithSeqLength longestArithSeqLength = new LongestArithSeqLength();
        int i = longestArithSeqLength.longestArithSeqLength(new int[]
                {22,8,57,41,36,46,42,28,42,14,9,43,27,51,0,0,38,50,31,60,29,31,20,
                        23,37,53,27,1,47,42,28,31,10,35,39,12,15,6,35,31,45,21,30,19,5,5,4,18,
                        38,51,10,7,20,38,28,53,15,55,60,56,43,48,34,53,54,55,14,9,56,52});
        System.out.println(i);
    }
}
