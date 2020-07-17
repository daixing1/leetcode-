package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/5
 * Time: 10:29
 * Description: 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 *              每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，
 *              当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *              答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class CuttingRope {
    public int cuttingRope(int n) {
        if (n<=3){
            return n-1;
        }
        int i = n % 3;
        int i1 = n / 3;
        int res = 1;
        while (i1-->1){
            res*=3;
            res%=1000000007;
        }
        if (i==0){
            return res*3%1000000007;
        }else if (i==1){
            return res*4%1000000007;
        }else {
            return res*6%1000000007;
        }
    }



    public static void main(String[] args) {
        CuttingRope cuttingRope = new CuttingRope();
        int i = cuttingRope.cuttingRope(120);
        System.out.println(i);
    }
}
