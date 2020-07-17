package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/5/8
 * Time: 11:41
 * Description: 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，
 *              就返回 true ；否则返回 false 。
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length()!=B.length()){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<A.length();i++){
            if (A.charAt(i)!=B.charAt(i)){
                list.add(i);
            }
        }
        return true;
    }
}
