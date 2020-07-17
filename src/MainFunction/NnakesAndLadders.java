package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/7
 * Time: 10:34
 * Description: 在一块 N x N 的棋盘 board 上，从棋盘的左下角开始，每一行交替方向，按从 1 到 N*N 的数字给方格编号。
 *              例如，对于一块 6 x 6 大小的棋盘，可以编号如下：
 *              玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
 *              每一次从方格 x 起始的移动都由以下部分组成：
 *                  你选择一个目标方块 S，它的编号是 x+1，x+2，x+3，x+4，x+5，或者 x+6，只要这个数字 <= N*N。
 *                  如果 S 有一个蛇或梯子，你就移动到那个蛇或梯子的目的地。否则，你会移动到 S。 
 *                  在 r 行 c 列上的方格里有 “蛇” 或 “梯子”；如果 board[r][c] != -1，
 *                  那个蛇或梯子的目的地将会是 board[r][c]。
 *              注意，你每次移动最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，你也不会继续移动。
 *              返回达到方格 N*N 所需的最少移动次数，如果不可能，则返回 -1。
 */
public class NnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        Integer[] dp = new Integer[board.length*board.length];
        int[] boards = new int[board.length*board.length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board.length;j++){
                if (i%2==0){
                    boards[i*board.length+j] = board[i][j];
                }else {
                    boards[(i+1)*board.length-j-1] = board[i][j];
                }
            }
        }
        dp[0] = 0;
        return 0;
    }

    public int countSteps(int n,int[] board,Integer[] dp){
        for (int i=1;i<=6;i++){
//            if ()
            if (board[i+n]==-1){
                dp[i+n] = getMin(dp[Math.max(0,i+n-1)],Math.max(0,i+n-2),Math.max(0,i+n-3),
                        Math.max(0,i+n-4),Math.max(0,i+n-5),Math.max(0,i+n-6))+1;
            }else {
                dp[board[i+n]]=getMin(dp[Math.max(0,i+n-1)],Math.max(0,i+n-2),Math.max(0,i+n-3),
                        Math.max(0,i+n-4),Math.max(0,i+n-5),Math.max(0,i+n-6))+1;
            }
        }
        return 0;
    }

    public int getMin(int n1,int n2,int n3,int n4,int n5,int n6){
        return Math.min(Math.min(Math.min(n1,n2),Math.min(n3,n4)),Math.min(n5,n6));
    }
}
