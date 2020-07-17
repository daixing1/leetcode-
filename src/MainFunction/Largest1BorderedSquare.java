package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/25
 * Time: 10:55
 * Description: 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，
 *              并返回该子网格中的元素数量。如果不存在，则返回 0。
 */
public class Largest1BorderedSquare {
    public static int largest1BorderedSquare(int[][] grid) {
        int[][] tmp = new int[grid.length][grid[0].length];
        int[][] tmp1 = new int[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (j==0){
                    tmp[i][j] = grid[i][j];
                }else {
                    tmp[i][j] = tmp[i][j-1]+grid[i][j];
                }
            }
        }
        int res = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (i==0){
                    tmp1[i][j] = Math.min(grid[i][j],tmp[i][j]);
                }else {
                    tmp1[i][j] = Math.min(tmp1[i][j]+grid[i][j],tmp[i][j]);
                }
                res = Math.max((int)Math.pow(tmp1[i][j],2),res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int i = largest1BorderedSquare(new int[][]{{1,1,1},{1,0,1},{1,1,1}});
        System.out.println(i);
    }
}
