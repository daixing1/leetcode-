package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/26
 * Time: 9:07
 * Description: 求出大于或等于 N 的最小回文素数。
 *              回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 *              例如，2，3，5，7，11 以及 13 是素数。
 *              回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 *              例如，12321 是回文数
 */
public class PrimePalindrome {
    public int primePalindrome(int N) {
        for (int i = N;i<2*Math.pow(10,8);i++){
            if (String.valueOf(i).length()==8){
                continue;
            }
            if (isPrime(i)&&isPalindrome(i)){
                return i;
            }
        }
        return -1;
    }

    public boolean isPrime(int n){
        if (n<2){
            return false;
        }
        for (int i=2;i<=Math.sqrt(n);i++){
            if (n%i==0){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(int n){
        String s = String.valueOf(n);
        if (s.length()==1){
            return true;
        }
        for (int i=0;i<s.length()/2;i++){
            if (s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
