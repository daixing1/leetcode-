package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/27
 * Time: 20:42
 * Description: 我们正在玩一个猜数游戏，游戏规则如下：
 *              我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。
 *              每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。
 *              然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。
 *              直到你猜到我选的数字，你才算赢得了这个游戏。
 */
public class GetMoneyAmount {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        if (n==2){
            return 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int minres = Integer.MAX_VALUE;
                for (int piv = start + 1; piv < start + len - 1; piv++) {
                    int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                    minres = Math.min(res, minres);
                }
                dp[start][start + len - 1] = minres;
            }

        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        GetMoneyAmount getMoneyAmount = new GetMoneyAmount();
        int moneyAmount = getMoneyAmount.getMoneyAmount(2);
        System.out.println(moneyAmount);
    }
}
