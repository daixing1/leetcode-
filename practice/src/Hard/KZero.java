package Hard;

/**
 * User: 兴希
 * Date: 2019/12/21
 * Time: 16:14
 * Description: f(x) 是 x! 末尾是0的数量。（回想一下 x! = 1 * 2 * 3 * ... * x，且0! = 1）
 *              例如， f(3) = 0 ，因为3! = 6的末尾没有0；而 f(11) = 2 ，
 *              因为11!= 39916800末端有2个0。给定 K，找出多少个非负整数x ，有 f(x) = K 的性质。
 */
public class KZero {
    public static int preimageSizeFZF(long K) {
        long low = 0;
        long high = K*5;
        return cal(low,high,K);

    }

    public static int cal(long low, long high, long K){
        if (low>=high){
            int count = calZero(low);
            if (count==K){
                return 5;
            }else {
                return 0;
            }
        }else {
            if (calZero((low+high)/2)<K){
                return cal((high+low)/2+1,high,K);
            }else if (calZero((low+high)/2)>K){
                return cal(low,(high+low)/2-1,K);
            }else{
                return 5;
            }
        }
    }

    public static int calZero(long x){
        int count = 0;
        while (x>=5){
            x/=5;
            count+=x;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = preimageSizeFZF(1000000000);
        System.out.println(i);
    }


    /**
     * 计算数字阶乘末尾0的个数
     * @param x
     * @return
     */
//    public int calcuZero(int x){
//        int factorial = factorial(x);
//        char[] chars = String.valueOf(factorial).toCharArray();
//        int count = 0;
//        for (int i= chars.length-1;i>=0;i--){
//            if (chars[i]=='0'){
//                count++;
//            }else {
//                break;
//            }
//        }
//        return count;
//    }

//    public int factorial(int x){
//        if (x==0){
//            return 1;
//        }else {
//            return x*factorial(x-1);
//        }
//    }
}
