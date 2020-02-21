package MainFunction;

import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/2/20
 * Time: 11:56
 * Description: No Description
 */
public class BalancedString {
    public static int balancedString(String s) {
        int[] count = new int[26];
        int length = s.length();
        char[] chars = s.toCharArray();
        for (char c:chars){
            count[c-'A']++;
        }
        int right = 0;
        int left = 0;
        int min = length;
        while (right<length+1){
            int maxcount = Math.max(Math.max(Math.max(count['Q'-'A'],count['W'-'A']),count['E'-'A']),count['R'-'A']);
            if (maxcount>length/4){
                right++;
                if (right>length){
                    break;
                }
                count[chars[right-1]-'A']--;
                continue;
            }
            min = Math.min(min,right-left);
            if (min==0){
                break;
            }
            count[chars[left]-'A']++;
            left++;
        }
        return min;
    }

    public static void main(String[] args) {
        int qqwe = balancedString("WQWRQQQW");
        System.out.println(qqwe);
    }
}
