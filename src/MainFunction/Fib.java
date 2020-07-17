package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/23
 * Time: 10:17
 * Description: 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 *                  F(0) = 0,   F(1) = 1
 *                  F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *              斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *              答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Fib {
    public static int fib(int n) {
        int[] res = new int[n+1];
        if (n>1){
            res[1] = 1;
        }else{
            return n;
        }
        for (int i=2;i<n+1;i++){
            res[i] = (res[i-1]+res[i-2])%1000000007;
        }
        return res[n];
    }

    public static void main(String[] args) {
        int fib = fib(48);
        System.out.println(fib);
    }
}
