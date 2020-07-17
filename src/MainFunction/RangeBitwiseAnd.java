package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/20
 * Time: 10:09
 * Description: 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与
 *              （包含 m, n 两端点）。
 */
public class RangeBitwiseAnd {
    public static int rangeBitwiseAnd(int m, int n) {
        if (m==0){
            return 0;
        }
        while (n>m){
            n = n&(n-1);
        }
        return n;
    }

    public static void main(String[] args) {
        int i = rangeBitwiseAnd(2147483646, 2147483647);
    }
}
