package MainFunction;

import java.util.Arrays;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/5/29
 * Time: 9:26
 * Description: 我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：
 *              如果 x 是偶数，那么 x = x / 2
 *              如果 x 是奇数，那么 x = 3 * x + 1
 *              比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 -->
 *              4 --> 2 --> 1）。
 *              给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，
 *              如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。
 *              请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
 *              注意，题目保证对于任意整数 x （lo <= x <= hi） ，它变成 1 所需要的步数是一个 32 位有符号整数
 */
public class GetKth {
    public static int getKth(int lo, int hi, int k) {
        int[][] res = new int[hi-lo+1][2];
        for (int i=lo;i<=hi;i++){
            int weight = getWeight(i);
            res[i][0] = weight;
            res[i][1] = i;
        }
        Arrays.sort(res,(o1, o2) -> {
            if (o1[0]==o2[0]){
                return o1[1]-o2[1];
            }else {
                return o1[0]-o2[0];
            }
        });
        return res[k][0];
    }

    public static int getWeight(int n){
        int count = 0;
        while (n!=1){
            if (n%2==1){
                n=3*n+1;
            }else {
                n/=2;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int weight = getWeight(3);
        System.out.println(weight);
    }
}
