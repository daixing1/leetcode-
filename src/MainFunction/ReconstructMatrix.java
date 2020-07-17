package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/4/21
 * Time: 11:20
 * Description: 给你一个 2 行 n 列的二进制数组：
 *                  矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
 *                  第 0 行的元素之和为 upper。
 *                  第 1 行的元素之和为 lower。
 *                  第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
 *              你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。
 *              如果有多个不同的答案，那么任意一个都可以通过本题。
 *              如果不存在符合要求的答案，就请返回一个空的二维数组。
 */
public class ReconstructMatrix {
    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] tmp = new int[2][colsum.length];
        int count = 0;
        for (int i=0;i<colsum.length;i++){
            if (colsum[i]==2){
                tmp[0][i] = 1;
                tmp[1][i] = 1;
                count++;
            }
        }
        if (upper<count||lower<count||upper>colsum.length||lower>colsum.length){
            return new ArrayList<>();
        }
        for (int i=0,j=0;i<upper-count;){
            while (j<colsum.length){

                if (tmp[0][j]==1){
                    j++;
                    continue;
                }
                if (tmp[0][j]==0&&colsum[j]==1){
                    tmp[0][j]=1;
                    j++;
                    i++;
                    break;
                }
                j++;
            }
            if (j==colsum.length&&i<upper-count){
                return new ArrayList<>();
            }
        }
        for (int i=0,k=0;i<lower-count;){
            while (k<colsum.length){
                if (tmp[1][k]==1){
                    k++;
                    continue;
                }
                if (tmp[1][k]==0&&tmp[0][k]==0&&colsum[k]==1) {
                    tmp[1][k]=1;
                    k++;
                    i++;
                    break;
                }
                k++;
            }
            if (k==colsum.length&&i<lower-count){
                return new ArrayList<>();
            }
        }
        for (int i=0;i<colsum.length;i++){
            if (tmp[0][i]+tmp[1][i]==colsum[i]){
                continue;
            }
            if (tmp[0][i]+tmp[1][i]!=colsum[i]){
                return new ArrayList<>();
            }
        }
        List<Integer> up = Arrays.stream(tmp[0]).boxed().collect(Collectors.toList());
        List<Integer> low = Arrays.stream(tmp[1]).boxed().collect(Collectors.toList());
        res.add(up);
        res.add(low);
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = reconstructMatrix(15, 15, new int[]{2,1,0,1,1,1,1,0,1,2,1,2,1,0,1});
    }
}
