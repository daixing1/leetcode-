package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/21
 * Time: 11:08
 * Description: 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
 *              另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci
 *              分别表示指定的行和列（从 0 开始编号）。
 *              你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
 *              请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
 */
public class OddCells {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] res = new int[n][m];
        for (int[] arr:indices){
            for (int i=0;i<m;i++){
                res[arr[0]][i]+=1;
            }
            for (int i=0;i<n;i++){
                res[i][arr[1]]+=1;
            }
        }
        int count = 0;
        for (int[] arr:res){
            for (int num:arr){
                if (num%2==1){
                    count++;
                }
            }
        }
        return count;
    }
}
