package MainFunction;

import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/5/10
 * Time: 10:11
 * Description: 最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：
 *                  Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
 *                  Paste (粘贴) : 你可以粘贴你上一次复制的字符。
 *              给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 
 *              个 'A' 的最少操作次数。
 */
public class MinSteps {
    public int minSteps(int n) {
        if (n<2){
            return 0;
        }
        if (n%2==0){
            return minSteps(n/2)+2;
        }
        int m = getMaxMul(n);
        if (m==n){
            return n;
        }else {
            return minSteps(m)+n/m;
        }
    }

    private int getMaxMul(int n){
        for (int i=n-2;i>1;i--){
            if (n%i==0){
                return i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        MinSteps minSteps = new MinSteps();
        int i = minSteps.minSteps(9);
        System.out.println(i);
    }
}
