package MainFunction;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * User: 兴希
 * Date: 2020/5/24
 * Time: 10:19
 * Description: 我们有一个项的集合，其中第 i 项的值为 values[i]，标签为 labels[i]。
 *              我们从这些项中选出一个子集 S，这样一来：
 *                  |S|(S项的个数) <= num_wanted
 *                  对于任意的标签 L，子集 S 中标签为 L 的项的数目总满足 <= use_limit。
 *                  返回子集 S 的最大可能的 和
 */
public class LargestValsFromLabels {
    public static int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int res = 0;
        int tmp = 0;
        for (int i=0;i<values.length;i++){
            for (int j=0;j<values.length-1-i;j++){
                if (values[j]<values[j+1]){
                    tmp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = tmp;
                    tmp = labels[j];
                    labels[j] = labels[j+1];
                    labels[j+1] = tmp;
                }
            }
        }
        for (int i=0;i<values.length;i++){
            map.put(labels[i],map.getOrDefault(labels[i],0)+1);
            if (map.getOrDefault(labels[i],0)>use_limit){
                continue;
            }
            res+=values[i];
            count++;
            if (count>=num_wanted){
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int i = largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 1, 2, 2, 3}, 3, 1);
        System.out.println(i);
    }
}
