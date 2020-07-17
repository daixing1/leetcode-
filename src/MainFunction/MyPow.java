package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/8
 * Time: 10:14
 * Description: 实现函数double Power(double base, int exponent)，求base的exponent次方。
 *              不得使用库函数，同时不需要考虑大数问题。
 */
public class MyPow {
    public static double myPow(double x, int n) {
        if (n==0){
            return 1;
        }
        if (n==1){
            return x;
        }
        if (n==-1){
            return 1/x;
        }
        long p = Math.abs((long)n);
        double res = 1;
        double tmp = 1;
        while (p>1){
            if (p%2==0){
                x*=x;
                p/=2;
            }else {
                tmp*=x;
                p--;
            }
        }
        x*=tmp;
        if (n<0){
            return 1.0/x;
        }
        return x;
    }

    public static void main(String[] args) {
        double v = myPow(2,
                -2147483648);
        System.out.println(v);
    }
}
