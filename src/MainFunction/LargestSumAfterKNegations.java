package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/7/19
 * Time: 20:27
 * Description: 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，
 *              然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 *              以这种方式修改数组后，返回数组可能的最大和。
 */
public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for (int i=0;i<A.length;i++){
            if (A[i]<0){
                if (K>0){
                    A[i] = -A[i];
                    K--;
                }else {
                    break;
                }
            }else {
                break;
            }
        }
        if (K<=0){
            return Arrays.stream(A).sum();
        }else {
            if ((K&1)==0){
                return Arrays.stream(A).sum();
            }else {
                Arrays.sort(A);
                A[0] = -A[0];
                return Arrays.stream(A).sum();
            }
        }
    }
}
