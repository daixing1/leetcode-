package MainFunction;

import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/5/10
 * Time: 10:28
 * Description: 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 *              你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 *              给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[i].length;j++){
                if (i==0&&j==0){
                    dp[i][j] = grid[i][j];
                }else if (i==0){
                    dp[i][j] = dp[i][j-1]+grid[i][j];
                }else if (j==0){
                    dp[i][j] = dp[i-1][j]+grid[i][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
