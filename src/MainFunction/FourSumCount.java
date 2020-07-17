package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/5/29
 * Time: 7:44
 * Description: 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，
 *              使得 A[i] + B[j] + C[k] + D[l] = 0。
 *              为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228
 *              到 228 - 1 之间，最终结果不会超过 231 - 1 。
 */
public class FourSumCount {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        int count = 0;
        for (int i=0;i<A.length;i++){
            for (int j=0;j<B.length;j++){
                for (int k=0;k<C.length;k++){
                    for (int l=0;l<D.length;l++){
                        if (A[i]+B[j]+C[k]+D[l]==0){
                            count++;
                        }else if (A[i]+B[j]+C[k]+D[l]>0){
                            return count;
                        }
                    }
                }
            }
        }
        return count;
    }

}
