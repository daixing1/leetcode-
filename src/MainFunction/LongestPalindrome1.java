package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/6/27
 * Time: 10:43
 * Description: 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *              在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *              注意:
 *                  假设字符串的长度不会超过 1010。
 */
public class LongestPalindrome1 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int res = 0;
        boolean flag = false;
        for (int n:map.values()){
            if (n%2==0){
                res+=n;
            }else {
                flag = true;
                res+=n-1;
            }
        }
        if (flag){
            return res+1;
        }
        return res;
    }
}
