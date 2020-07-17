package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/5/6
 * Time: 11:41
 * Description: 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 */
public class SortedSquares {
    public int[] sortedSquares(int[] A) {
//        int[] res = new int[A.length];
        if (A.length==0){
            return A;
        }
        for (int i=0;i<A.length;i++){
            A[i] = (int)Math.pow(A[i],2);
        }
        Arrays.sort(A);
        return A;
    }
}
