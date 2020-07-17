package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/1
 * Time: 9:17
 * Description: 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度
 */
public class FindLength {
    public int findLength(int[] A, int[] B) {
        int maxLen = 0;
        int tmp = 0;
        for (int i=0;i<A.length;i++){
            for (int j=0;j<B.length;j++) {
                if (A[i] == B[j]) {
                    int a = i;
                    int b = j;
                    while (a < A.length && b < B.length && A[a] == B[b]) {
                        a++;
                        b++;
                    }
                    maxLen = Math.max(maxLen,b-j+1);
                }
            }
        }
        return maxLen;
    }
}
