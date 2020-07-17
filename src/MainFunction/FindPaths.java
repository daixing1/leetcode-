package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/6
 * Time: 21:44
 * Description: 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，
 *              或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。
 *              找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
 */
public class FindPaths {
    long count;
    public int findPaths(int m, int n, int N, int i, int j) {
        count = 0;
        int[][] tmp = new int[m][n];
        tmp[i][j] = 1;
        traverse(tmp,N,i,j);
        return (int)count;

    }

    private int traverse(int[][] tmp, int n, int i, int j){
        if (i==0){
            count++;
            count %= Math.pow(10,9)+7;
        }
        if (i==tmp.length-1){
            count++;
            count %= Math.pow(10,9)+7;
        }
        if (j==0){
            count++;
            count %= Math.pow(10,9)+7;
        }
        if (j==tmp[0].length-1){
            count++;
            count %= Math.pow(10,9)+7;
        }
        if (n==0){
            return (int)count;
        }
        if (i>0&&tmp[i-1][j]!=1){
            tmp[i-1][j] = 1;
            count = Math.max(count,traverse(tmp,n-1,i-1,j));
        }
        if (i<tmp.length-1&&tmp[i+1][j]!=1){
            tmp[i+1][j] = 1;
            count = Math.max(count,traverse(tmp,n-1,i+1,j));
        }
        if (j>0&&tmp[i][j-1]!=1){
            tmp[i][j-1] = 1;
            count = Math.max(count,traverse(tmp,n-1,i,j-1));
        }
        if (j<tmp[0].length-1&&tmp[i][j+1]!=1){
            tmp[i][j+1] = 1;
            count = Math.max(count,traverse(tmp,n-1,i,j+1));
        }
        return (int)count;
    }

    public static void main(String[] args) {
        FindPaths findPaths = new FindPaths();
        int paths = findPaths.findPaths(2, 2, 2, 0, 0);
        System.out.println(paths);
    }
}
