package MainFunction;

import java.util.Arrays;
import java.util.Comparator;

/**
 * User: 兴希
 * Date: 2020/6/25
 * Time: 10:23
 * Description: 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。
 *              注意:
 *                  数组长度 n 满足以下条件:
 *                  1 ≤ n ≤ 1000
 *                  1 ≤ m ≤ min(50, n)
 */
public class SplitArray {
    public int splitArray(int[] nums, int m) {
        if (m==nums.length){
            return Arrays.stream(nums).max().getAsInt();
        }
        int[][] dp = new int[nums.length+1][m+1];
        for (int[] arr:dp){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
//        int max = 0;
//        for (int i=0;i<m;i++){
//            max = Math.max(max,nums[i]);
//            dp[i][i] = max;
//        }
        int[] prefix = new int[nums.length+1];
        for (int i=0;i<nums.length;i++){
            prefix[i+1] = prefix[i]+nums[i];
        }
        dp[0][0] = 0;
        for (int i=1;i<=nums.length;i++){
            for (int j=1;j<=Math.min(i,m);j++){
                for (int k=0;k<i;k++){
                    dp[i][j] = Math.min(Math.max(dp[k][j-1],prefix[i]-prefix[k]),dp[i][j]);
                }
            }
        }
        return dp[nums.length][m];
    }

    public int splitArray1(int[] nums, int m) {
        int min = Arrays.stream(nums).max().getAsInt();
        int max = Arrays.stream(nums).sum();
        if (nums.length==m){
            return min;
        }
        if (m==1){
            return max;
        }
        boolean flag = false;
        int sum = 0;
        int count = 0;
        while (min<max){
            sum = 0;
            count = 0;
            int mid = (max+min)/2;
            for (int i=0;i<nums.length;i++){
                sum+=nums[i];
                if (sum>mid){
                    sum = nums[i];
                    count++;
                    if (count>m){
                        break;
                    }
                }
            }
            count++;
            if (count>m){
                min = mid+1;
            }else if (count<=m){
                max = mid;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        SplitArray splitArray = new SplitArray();
        int i = splitArray.splitArray1(new int[]{7,2,5,10,8}, 2);
        System.out.println(i);
    }
}
