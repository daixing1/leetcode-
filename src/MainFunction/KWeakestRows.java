package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/5/16
 * Time: 12:46
 * Description: 给你一个大小为 m * n 的方阵 mat，方阵由若干军人和平民组成，分别用 1 和 0 表示。
 *              请你返回方阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。
 *              如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i
 *              行的战斗力比第 j 行弱。
 *              军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 */
public class KWeakestRows {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Integer> power = new ArrayList<>();
        List<Integer> index = new ArrayList<>();
        for (int i=0;i<mat.length;i++){
            int count = 0;
            for (int j=0;j<mat[i].length;j++){
                if (mat[i][j]==0){
                    break;
                }
                count++;
            }
            power.add(count);
            index.add(i);
        }
        index.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (power.get(o1) == power.get(o2)){
                    return o1=o2;
                }
                return power.get(o1) - power.get(o2);
            }
        });
        int[] res = new int[k];
        for (int i=0;i<k;i++){
            res[i] = index.get(i);
        }
        return res;
    }
}
