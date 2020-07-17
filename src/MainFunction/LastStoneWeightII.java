package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/28
 * Time: 11:24
 * Description: 有一堆石头，每块石头的重量都是正整数。
 *              每一回合，从中选出 任意 两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。
 *              那么粉碎的可能结果如下：
 *                  如果 x == y，那么两块石头都会被完全粉碎；
 *                  如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 *              最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。
 */
public class LastStoneWeightII {
    public static int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int n:stones){
            sum+=n;
        }
        int[][] dp = new int[stones.length+1][sum/2+1];
        for (int i=1;i<=stones.length;i++){
            int curWeight = stones[i-1];
            for (int j=0;j<=sum/2;j++){
                if (j>=curWeight){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-curWeight]+curWeight);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return sum-2*dp[stones.length][sum/2];
    }

    public static void main(String[] args) {
        int i = lastStoneWeightII(new int[]{31, 26, 33, 21, 40});
        System.out.println(i);
    }
}
