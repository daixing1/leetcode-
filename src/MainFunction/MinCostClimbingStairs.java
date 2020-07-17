package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/12
 * Time: 20:27
 * Description: 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *              每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *              您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost==null||cost.length<2){
            return 0;
        }
        int[] dp = new int[cost.length];
        dp[1] = Math.min(cost[0],cost[1]);
        for (int i=2;i<cost.length;i++){
            dp[i] = Math.min(dp[i-2]+cost[i-1],dp[i-1]+cost[i]);
        }
        return dp[cost.length-1];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int i = minCostClimbingStairs.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println(i);
    }
}
