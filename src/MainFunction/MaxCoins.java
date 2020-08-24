package MainFunction;

import java.util.List;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/7/18
 * Time: 12:38
 * Description: 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *              现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] *
 *              nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。
 *              注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *              求所能获得硬币的最大数量。
 */
public class MaxCoins {
//    int max = 0;
//    public int maxCoins(int[] nums) {
//
//    }
//
//    private void traverse(int[] nums, int count, boolean[] flag, int sum, int index){
//        if (count==nums.length+1){
//            max = Math.max(max,sum);
//            return;
//        }else {
//            sum+=
//        }
//        for (int i=0;i<nums.length;i++){
//            if (!flag[i]){
//                flag[i] = true;
//                traverse(nums,count++,flag,sum,i);
//                flag[i] = false;
//            }
//        }
//    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }

    public static void main(String[] args) {
        MaxCoins maxCoins = new MaxCoins();
        int i = maxCoins.maxCoins(new int[]{3, 1, 5, 8});
        System.out.println(i);
    }
}
