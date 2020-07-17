package MainFunction;

import java.util.List;

/**
 * User: 兴希
 * Date: 2020/4/23
 * Time: 10:33
 * Description: 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
 *              下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 *              在下一行选择的元素和当前行所选元素最多相隔一列。
 */
public class MinFallingPathSum {
    int min = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] A) {
        dfs(A,-1,0,0);
        return min;
    }

    public void dfs(int[][] A, int col, int len, int sum){
        if (sum>=min){
            return;
        }
        if (len==A.length){
            if (sum<min){
                min = sum;
            }
            return;
        }
        for (int i=0;i<A.length;i++){
            if (col==i){
                continue;
            }
            sum+=A[len][i];
            dfs(A,i,len+1,sum);
            sum-=A[len][i];
        }
    }

    public static void main(String[] args) {
        MinFallingPathSum minFallingPathSum = new MinFallingPathSum();
        int i = minFallingPathSum.minFallingPathSum(new int[][]{
                {-2,-18,31,-10,-71,82,47,56,-14,42},
                {-95,3,65,-7,64,75,-51,97,-66,-28},
                {36,3,-62,38,15,51,-58,-90,-23,-63},
                {58,-26,-42,-66,21,99,-94,-95,-90,89},
                {83,-66,-42,-45,43,85,51,-86,65,-39},
                {56,9,9,95,-56,-77,-2,20,78,17},
                {78,-13,-55,55,-7,43,-98,-89,38,90},
                {32,44,-47,81,-1,-55,-5,16,-81,17},
                {-87,82,2,86,-88,-58,-91,-79,44,-9},
                {-96,-14,-52,-8,12,38,84,77,-51,52}});
        System.out.println(i);
    }


}
