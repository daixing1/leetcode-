package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/20
 * Time: 15:49
 * Description: 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，
 *              在子字符串中都恰好出现了偶数次
 */
public class FindTheLongestSubstring {
    public static int findTheLongestSubstring(String s) {
        int max = 0;
        for (int j=0;j<s.length();j++){
            int countA = 0,countE = 0, countI = 0,countO = 0,countU = 0;
            for (int i=j;i<s.length();i++){
                if (s.charAt(i)=='a'){
                    countA++;
                }
                if (s.charAt(i)=='e'){
                    countE++;
                }
                if (s.charAt(i)=='i'){
                    countI++;
                }
                if (s.charAt(i)=='o'){
                    countO++;
                }
                if (s.charAt(i)=='u'){
                    countU++;
                }
                if (countA%2==0&&countE%2==0&&countI%2==0&&countO%2==0&&countU%2==0){
                    max = Math.max(i-j+1,max);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = findTheLongestSubstring("leetcodeisgreat");
        System.out.println(n);
    }
}
