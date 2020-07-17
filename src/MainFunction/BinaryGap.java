package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/29
 * Time: 10:36
 * Description: 给定一个正整数 N，找到并返回 N 的二进制表示中两个连续的 1 之间的最长距离。
 *              如果没有两个连续的 1，返回 0
 */
public class BinaryGap {
    public static int binaryGap(int N) {
        int tmp = 0;
        int max = 0;
        while (N>0){
            int res = N&1;
            if (res==1){
                max = Math.max(max,tmp);
                tmp = 1;
            }else {
                if (tmp!=0){
                    tmp++;
                }
            }
            N = N>>1;
        }
        return max;
    }

    public static void main(String[] args) {
        int i = binaryGap(22);
        System.out.println(i);
    }
}
