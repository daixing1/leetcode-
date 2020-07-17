package MainFunction;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/7/17
 * Time: 10:37
 * Description: 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额
 *              所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
public class CoinChange {
    Set<Integer> set;
    int count;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount==0){
            return 0;
        }
        if (amount<coins[0]){
            return -1;
        }
        count = 0;
        set = new HashSet<>();
        for (int n:coins){
            set.add(n);
        }
        int n = amount/coins[0];
        int m = amount/coins[coins.length-1];
        for (int i=Math.max(m,1);i<=n;i++){
            if (traverse(amount,i)){
                return i;
            }
        }
        return -1;
    }

    private boolean traverse(int sum, int m){
        if (m==1){
            return set.contains(sum);
        }
        for (int n:set){
            if (traverse(sum-n,m-1)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int i = coinChange.coinChange(new int[]{1,2147483647}, 2);
        System.out.println(i);
    }
}
