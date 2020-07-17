package MainFunction;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * User: 兴希
 * Date: 2020/7/10
 * Time: 11:07
 * Description: 你有一块棋盘，棋盘上有一些格子已经坏掉了。你还有无穷块大小为1 * 2的多米诺骨牌，
 *              你想把这些骨牌不重叠地覆盖在完好的格子上，请找出你最多能在棋盘上放多少块骨牌？这些骨牌可以横着或者竖着放。
 *              输入：n, m代表棋盘的大小；broken是一个b * 2的二维数组，其中每个元素代表棋盘上每一个坏掉的格子的位置。
 *              输出：一个整数，代表最多能在棋盘上放的骨牌数。
 */
public class Domino {
    public int domino(int n, int m, int[][] broken) {
        int[][] board = new int[n][m];
        for (int[] a : broken){
            board[a[0]][a[1]] = -1;
        }
        int count = 0;
        //横向
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (j+1<m&&board[i][j]==0&&board[i][j+1]==0){
                    count++;
                    board[i][j]=1;
                    board[i][j+1]=1;
                }
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (i+1<n&&board[i][j]==0&&board[i+1][j]==0){
                    count++;
                    board[i][j]=1;
                    board[i+1][j]=1;
                }
            }
        }
        int sum = 0;
        board = new int[n][m];
        for (int[] a : broken){
            board[a[0]][a[1]] = -1;
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (i+1<n&&board[i][j]==0&&board[i+1][j]==0){
                    sum++;
                    board[i][j]=1;
                    board[i+1][j]=1;
                }
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (j+1<m&&board[i][j]==0&&board[i][j+1]==0){
                    sum++;
                    board[i][j]=1;
                    board[i][j+1]=1;
                }
            }
        }
        return Math.max(count,sum);
    }

    public static void main(String[] args) {
        Domino domino = new Domino();
        int domino1 = domino.domino(2, 3, new int[][]{{1, 1}, {1, 2}});
        System.out.println(domino1);
    }
}
