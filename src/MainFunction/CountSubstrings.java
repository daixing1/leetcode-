package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/26
 * Time: 11:50
 * Description: 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *              具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 */
public class CountSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i=0;i<s.length();i++){
            for (int j=i+1;j<=s.length();j++){
                if (isPalindrome(s.substring(i,j))){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean isPalindrome(String s){
        if (s.length()==1){
            return true;
        }
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length/2;i++){
            if (chars[i]!=chars[chars.length-i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("ab");
    }
}
