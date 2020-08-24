package MainFunction;

import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/8/1
 * Time: 20:41
 * Description: 给定由若干 0 和 1 组成的矩阵 matrix，从中选出任意数量的列并翻转其上的 每个 单元格。
 *              翻转后，单元格的值从 0 变成 1，或者从 1 变为 0 。
 *              返回经过一些翻转后，行上所有值都相等的最大行数。
 */
public class MaxEqualRowsAfterFlips {
    //对每列统计相同和相反的行数取较大值
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        if (matrix[0].length==1){
            return matrix.length;
        }
        int max = 1;
        int count = 1;
        for (int i=0;i<matrix.length;i++){
            count = 1;
            for (int j=0;j<matrix.length;j++){
                if (i==j){
                    continue;
                }
                int flag = isSameOrReverse(matrix[i], matrix[j]);
                if (flag!=0){
                    count++;
                }
            }
            max = Math.max(max,count);
        }
        return max;
    }

    //是否相同或相反，相同返回1，相反返回-1，既不相同又不相反返回0
    private int isSameOrReverse(int[] a,int[] b){
        int flag = 0;
        for (int i=0;i<a.length;i++){
            if (a[i]==b[i]){
                if (flag==-1){
                    return 0;
                }else {
                    flag = 1;
                }
            }else {
                if (flag==1){
                    return 0;
                }else {
                    flag = -1;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        MaxEqualRowsAfterFlips maxEqualRowsAfterFlips = new MaxEqualRowsAfterFlips();
        int i = maxEqualRowsAfterFlips.maxEqualRowsAfterFlips(new int[][]{
                {0,1},{1,1}
        });
        System.out.println(i);
    }
}
