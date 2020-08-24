package MainFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/8/15
 * Time: 21:41
 * Description: 给你一个 m * n 的整数矩阵 mat ，请你将同一条对角线上的元素（从左上到右下）按升序排序后，返回排好序的矩阵。
 */
public class DiagonalSort {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        for (int i=m-1;i>=0;i--){
            List<Integer> list = new ArrayList<>();
            int j = 0;
            int k = i;
            while (k<m&&j<n){
                list.add(mat[k][j]);
                k++;
                j++;
            }
            Collections.sort(list);
            j = 0;
            k = i;
            while (k<m&&j<n){
                res[k][j] = list.get(0);
                list.remove(0);
                k++;
                j++;
            }
        }
        for (int i=n-1;i>0;i--){
            List<Integer> list = new ArrayList<>();
            int j = 0;
            int k = i;
            while (k<n&&j<m){
                list.add(mat[j][k]);
                k++;
                j++;
            }
            Collections.sort(list);
            j = 0;
            k = i;
            while (k<n&&j<m){
                res[j][k] = list.get(0);
                list.remove(0);
                k++;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DiagonalSort diagonalSort = new DiagonalSort();
        int[][] ints = diagonalSort.diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}});
        System.out.println();
    }
}
