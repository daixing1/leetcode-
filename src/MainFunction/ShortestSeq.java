package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/6/7
 * Time: 10:04
 * Description: 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，
 *              其出现顺序无关紧要。
 *              返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 */
public class ShortestSeq {
    public static int[] shortestSeq(int[] big, int[] small) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a:small){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        Map<Integer, Integer> map1 = (Map<Integer, Integer>) ((HashMap<Integer, Integer>) map).clone();
        int start = 0, end = 0;
        int min = Integer.MAX_VALUE;
        int[] res = new int[2];
        for (int i=0;i<big.length;i++){
            if (map1.containsKey(big[i])){
                if (map1.get(big[i])<2){
                    map1.remove(big[i]);
                    if (map1.size()==0){
                        end = i;
                        Map<Integer, Integer> map2 = (Map<Integer, Integer>) ((HashMap<Integer, Integer>) map).clone();
                        for (int j=i;j>=0;j--){
                            if (map2.containsKey(big[j])){
                                if (map2.get(big[j])<2){
                                    map2.remove(big[j]);
                                    if (map2.size()==0){
                                        start = j;
                                        break;
                                    }
                                }
                            }
                        }
                        if (min>end-start+1){
                            min = end-start+1;
                            res[0] = start;
                            res[1] = end;
                        }
                        i = start;
                        map1 = (Map<Integer, Integer>) ((HashMap<Integer, Integer>) map).clone();
                    }
                }else {
                    map.put(big[i],map.get(big[i])-1);
                }
            }
        }
        if (res[1]==0){
            return new int[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = shortestSeq(new int[]{1,2,3}, new int[]{1, 2, 3});
        System.out.println(ints);
    }
}
