package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/6
 * Time: 20:00
 * Description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *              机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *              现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */
public class UniquePathsWithObstacles {
    int count;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        if (obstacleGrid.length * obstacleGrid[0].length == 1){
            if (obstacleGrid[0][0] == 1) {
                return 0;
            } else {
                return 1;
            }
        }
        if (obstacleGrid[0][0]==1){
            return 0;
        }
        count = 0;
        traverse(obstacleGrid,0,0);
        return count;

    }

    private void traverse(int[][] obstacleGrid, int m, int n){
        if (m==obstacleGrid.length-1&&n==obstacleGrid[0].length-1){
            count++;
            return;
        }
        if (m<obstacleGrid.length-1&&obstacleGrid[m+1][n]!=1){
            traverse(obstacleGrid,m+1,n);
        }
        if (n<obstacleGrid[0].length-1&&obstacleGrid[m][n+1]!=1){
            traverse(obstacleGrid,m,n+1);
        }
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        int i = uniquePathsWithObstacles.uniquePathsWithObstacles(new int[][]{{1, 0}});
        System.out.println(i);
    }
}
