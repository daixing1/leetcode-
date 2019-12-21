package Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2019/12/15
 * Time: 17:45
 * Description: 超级丑数：在给出的整数数组经过变换后（数组内的数可以互相乘），选出第n小的数，任何情况第一位都是1
 *              如｛2,7,13,19｝ n= 12，变换后的数组｛1,2,4,7,8,13,14,16,19,21,26,28｝所以最后输出28
 */
public class SuperUgly {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] idxs = new int[primes.length];
        int[] dp = new int[n];//dp[i]由min{primes[j] * dp[idxs[j]]},j=[0,n)得到
        int i = 1;
        dp[0] = 1;
        while(i < n){
            int j = 0,min = Integer.MAX_VALUE;
            for(int num:primes){
                if(num * dp[idxs[j]] < min) min = num * dp[idxs[j]];
                j++;
            }
            dp[i] = min;
            j = 0;
            for(int num:primes){
                if(min == num * dp[idxs[j]]) idxs[j]++;
                j++;
            }
            i++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int n = nthSuperUglyNumber(12,new int[]{2,7,13,19});
        System.out.println(n);
    }
}
