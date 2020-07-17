package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/13
 * Time: 9:41
 * Description: 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 */
public class NumTrees {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2;i<=n;i++){
            for (int j=1;j<=i;j++){
                dp[i] += dp[i-j]*dp[j-1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
        int i = numTrees.numTrees(4);
        System.out.println(i);
    }
}
