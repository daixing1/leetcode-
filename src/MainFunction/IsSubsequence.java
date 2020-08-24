package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/27
 * Time: 20:19
 * Description: 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *              你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串
 *              （长度 <=100）。
 *              字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 *              （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int j=0;
        for (int i=0;i<s.length();i++,j++){
            while (j<t.length()&&t.charAt(j)!=s.charAt(i)){
                j++;
            }
            if (j>=t.length()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        boolean subsequence = isSubsequence.isSubsequence("abc", "ahbgda");
        System.out.println(subsequence);
    }
}
