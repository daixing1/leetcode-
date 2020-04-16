package MainFunction;

/**
 * User: 兴希
 * Date: 2020/2/26
 * Time: 23:42
 * Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
//        String rs = reverse(s);
        String res = "";
        for (int i=0;i<s.length();i++){
//            for (int j=0;j<rs.length();j++){
                for (int k=1;k+i<s.length();k++){
                    String substring = s.substring(i, k + i);
                    if (substring.equals(reverse(substring))&&substring.length()>res.length()){
                        res = substring;
                    }
                }
//            }
        }
        return res;
    }

    public String reverse(String s){
        char[] chars = s.toCharArray();
        String res = "";
        for (int i=chars.length;i>0;i--){
            res+=chars[i-1];
        }
        return res;
    }
}
