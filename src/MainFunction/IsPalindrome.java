package MainFunction;

/**
 * User: 兴希
 * Date: 2020/2/26
 * Time: 11:22
 * Description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }else {
            int y=reverse(x);
            if (x==y){
                return true;
            }else {
                return false;
            }
        }
    }

    public int reverse(int x){
        int y=0;
        while (x>=10) {
            int pop = x % 10;
            x = x / 10;
            y = y * 10 + pop;
        }
        y = y * 10 + x;
        return y;
    }
}
