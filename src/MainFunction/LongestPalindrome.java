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

    public static String longestPalindrome1(String s) {
        if (s==null||s.length()==0){
            return "";
        }
        String[][] dp = new String[s.length()][s.length()];
        for (int i=0;i<s.length();i++){
            dp[i][i] = String.valueOf(s.charAt(i));
        }
        for (int i=s.length()-1;i>=0;i--){
            for (int j =i+1;j<s.length()-1;j++){
                if (s.charAt(j)==s.charAt(i)){
                    dp[i][j] = s.charAt(j)+dp[i+1][j-1]+s.charAt(i);
                }else {
                    if (dp[i+1][j].length()>dp[i][j-1].length()){
                        dp[i][j] = dp[i+1][j];
                    }else {
                        dp[i][j] = dp[i][j-1];
                    }
                }
            }
        }
        String res = "";
        for (String tmp:dp[0]){
            if (res.length()<tmp.length()){
                res = tmp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String babad = longestPalindrome1("babad");
        System.out.println(babad);
    }
}
