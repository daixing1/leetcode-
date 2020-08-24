package MainFunction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/5/8
 * Time: 11:41
 * Description: 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，
 *              就返回 true ；否则返回 false 。
 */
public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length()!=B.length()||A.length()<2){
            return false;
        }
        Set<Character> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<A.length();i++){
            set.add(A.charAt(i));
            if (A.charAt(i)!=B.charAt(i)){
                list.add(i);
            }
            if (list.size()>2){
                return false;
            }

        }
        if (A.length()>set.size()&&list.size()==0){
            return true;
        }
        if (list.size()==2){
            if (A.charAt(list.get(0))==B.charAt(list.get(1))&&A.charAt(list.get(1))==B.charAt(list.get(0))){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BuddyStrings buddyStrings = new BuddyStrings();
        boolean b = buddyStrings.buddyStrings("abab", "abab");
        System.out.println(b);
    }
}
