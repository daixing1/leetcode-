package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/12
 * Time: 20:25
 * Description: 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，
 *              并返回该子网格中的元素数量。如果不存在，则返回 0。
 */
public class Largest1BorderedSquareI {
    public int largest1BorderedSquare(int[][] grid) {
        if (grid.length==1||grid[0].length==1){
            return 1;
        }
        int[][] left = new int[grid.length+1][grid[0].length+1];
        int[][] up = new int[grid.length+1][grid[0].length+1];
        int a = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]==1){
                    left[i+1][j+1] = left[i+1][j]+1;
                    up[i+1][j+1] = up[i][j+1]+1;
                    int edge = Math.min(left[i+1][j+1],up[i+1][j+1]);
                    for (int k=edge;k>0;k--){
                        if (left[i-k+2][j+1]>=k&&up[i+1][j-k+2]>=k){
                            a = Math.max(a,k);
                            break;
                        }
                    }
                }
            }
        }
        return a*a;
    }

    public static void main(String[] args) {
        Largest1BorderedSquareI largest1BorderedSquareI = new Largest1BorderedSquareI();
        int i = largest1BorderedSquareI.largest1BorderedSquare(new int[][]{
                {1, 1, 1,1},
                {0, 1, 0,1},
                {1, 1, 1,1},
                {1, 1, 1,1}
        });
        System.out.println(i);
    }
}
