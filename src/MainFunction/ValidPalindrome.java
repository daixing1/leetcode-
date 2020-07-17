package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/19
 * Time: 8:40
 * Description: 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class ValidPalindrome {
    public static boolean validPalindrome(String s) {
        for (int i=0;i<s.length()/2;i++){
            if (s.charAt(i)!=s.charAt(s.length()-1-i)){
                boolean flag1 = isPalindrome(s.substring(0, i) + s.substring(i + 1, s.length()));
                boolean flag2 = isPalindrome(s.substring(0, s.length()-1-i) + s.substring(s.length()-i, s.length()));
                return flag1||flag2;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s){
        for (int i=0;i<s.length()/2;i++){
            if (s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }


}
