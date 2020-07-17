package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/5
 * Time: 11:11
 * Description: 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，
 *              有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 */
public class HammingWeight {
    public static int hammingWeight(int n) {
        int count = 0;
        int m = 1;
        while (n!=0){
            int i = m & n;
            if (i!=0){
                count++;
            }
            n >>=1;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = hammingWeight(123);
        System.out.println(i);
    }
}
