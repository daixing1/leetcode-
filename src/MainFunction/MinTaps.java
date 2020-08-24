package MainFunction;

import java.util.List;

/**
 * User: 兴希
 * Date: 2020/7/25
 * Time: 20:25
 * Description: 在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。
 *              花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。
 *              给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i]
 *              （下标从 0 开始）表示：如果打开点 i 处的水龙头，可以灌溉的区域为 [i -  ranges[i], i + ranges[i]] 。
 *              请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。
 */
public class MinTaps {
    public int minTaps(int n, int[] ranges) {
        int[][] region = new int[ranges.length][2];
        int[][][] dp = new int[n+1][n+1][2];
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
//        List<int[]>
        int count = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i=0;i<ranges.length;i++){
            if (ranges[i]==0){
                continue;
            }
            region[i] = new int[]{i-ranges[i],i+ranges[i]};
            if (region[i][0]<=0&&region[i][1]>=n){
                return 1;
            }
            if (region[i][0]<=0&&region[i][1]>=right){
                count = 1;
                left = region[i][0];
                right = region[i][1];
                continue;
            }
            if (region[i][0]<=right){
                if (region[i][1]>=n){
                    count++;
                    min = Math.min(count,min);
                    count = 0;
                    left = 0;
                    right = 0;
                    continue;
                }else if (region[i][1]<=right){
                    continue;
                }else {
                    count++;
                    right = region[i][1];
                }
            }

        }
        if (min==Integer.MAX_VALUE){
            return -1;
        }

//        for (int i=0;i<n+1;i++){
//            for (int j=i+1;j<n+1;i++){
//                dp[i][j] = new int[]{Math.min(dp[i][j-1][0],region[j][0]),Math.max(dp[i][j-1][1],region[j][1])};
//                if (dp[i][j][0]<=0&&dp[i][j][1]>=n){
//                    min = Math.min(min,j-i);
//                }
//            }
//        }
        return min;
    }

    private int countNoZero(int[] ranges,int m,int n){
        int count = 0;
        for (int i = m;i<=n;i++){
            if (ranges[i]!=0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinTaps minTaps = new MinTaps();
        int i = minTaps.minTaps(9, new int[]{
                0,5,0,3,3,3,1,4,0,4});
        System.out.println(i);
    }
}
