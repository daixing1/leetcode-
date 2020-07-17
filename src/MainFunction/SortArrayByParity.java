package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/7
 * Time: 11:18
 * Description: 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *              你可以返回满足此条件的任何数组作为答案。
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int start=0;
        int end = A.length-1;
        int tmp = 0;
        while (start<end){
            if (A[start]%2==0){
                start++;
                continue;
            }else {
                tmp = A[start];
                A[start] = A[end];
                A[end] = tmp;
                end--;
            }
        }
        return A;
    }
}
