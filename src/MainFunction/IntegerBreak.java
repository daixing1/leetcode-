package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/30
 * Time: 23:07
 * Description: 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n==2){
            return 1;
        }
        if (n==3){
            return 2;
        }
        int m = n/3;
        n = n%3;
        if (n==0){
            return (int)Math.pow(3,m);
        }else if (n==1){
            return (int)Math.pow(3,m-1)*4;
        }else {
            return (int)Math.pow(3,m)*2;
        }
    }
}
