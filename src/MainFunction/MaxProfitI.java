package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/10
 * Time: 9:01
 * Description: 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *              设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *                  你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *                  卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 */
public class MaxProfitI {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }

    /**
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * 返回获得利润的最大值。
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费
     * @param prices, fee
     */
    public int maxProfit(int[] prices, int fee) {
        //dp[i][0]代表持有该股票，dp[i][1]代表不持有
        int length = prices.length;
        if (length==0){
            return 0;
        }
        int[][] dp = new int[length][2];
        dp[0][0] = -prices[0];
        for (int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]-fee);
        }
        return dp[length-1][1];
    }

    public static void main(String[] args) {
        MaxProfitI maxProfitI = new MaxProfitI();
        int i = maxProfitI.maxProfit(new int[]{1, 3, 2, 8, 4, 9},2);
        System.out.println(i);
    }
}
