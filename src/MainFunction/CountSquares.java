package MainFunction;

/**
 * User: 兴希
 * Date: 2020/8/19
 * Time: 15:27
 * Description: 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 */
public class CountSquares {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int count = 0;
        for (int i=0;i<m;i++){
            for (int j = 0; j < n; j++) {
                if (i==0||j==0){
                    dp[i][j] = matrix[i][j];
                    if (dp[i][j]==1){
                        count++;
                    }
                    continue;
                }
                if (matrix[i][j]==1){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    count+=dp[i][j];
                }
            }
        }
        return count;
    }
}
