package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/5/9
 * Time: 10:27
 * Description: 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差
 */
public class SubtractProductAndSum {
    public static int subtractProductAndSum(int n) {
        if (n==0){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        int i=10;
        int sum = 0;
        int mul = 1;
        while (n>=10){
            sum+=n%i;
            mul*=n%i;
            n/=i;
        }
        sum+=n;
        mul*=n;
        return mul-sum;
    }

    public static void main(String[] args) {
        int i = subtractProductAndSum(234);
        System.out.println(i);
    }
}
