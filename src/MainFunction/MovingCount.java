package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/8
 * Time: 9:24
 * Description: 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 *              它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 *              例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 *              因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class MovingCount {
    public static int movingCount(int m, int n, int k) {
        int count = 0;
        int[][] flag = new int[m][n];
//        flag[0][0] = 1;
//        count++;
        ;
        return dfs(0,0,0,0,flag,k);
    }

    public static int dfs(int i, int j, int si, int sj, int[][] flag, int k) {
        if(i < 0 || i >= flag.length || j < 0 || j >= flag[0].length || k < si + sj || flag[i][j]==1) return 0;
        flag[i][j] = 1;
        return 1 + dfs(i + 1, j, sumDigita(i+1), sj,flag,k) + dfs(i, j + 1, si, sumDigita(j+1),flag,k);
    }


    public static int sumDigita(int num){
        int res = 0;
        while (num>10){
            res+=num%10;
            num = num/10;
        }
        res+=num;
        return res;
    }

    public static void main(String[] args) {
        int i = movingCount(38, 15, 9);
        System.out.println(i);
    }
}
