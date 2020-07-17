package MainFunction;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/5/24
 * Time: 10:54
 * Description: 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数
 */
public class LargestNumber {
    public static String largestNumber(int[] nums) {
        if (nums.length==0){
            return "";
        }
        if (nums.length==1){
            return String.valueOf(nums[0]);
        }
        List<Integer> collect = Arrays.stream(nums).boxed().sorted((o1, o2) -> {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            return (s2+s1).compareTo(s1+s2);
        }).collect(Collectors.toList());
        if (collect.get(0)==0){
            return "0";
        }
//        Collections.sort(collect,(o1, o2) -> {
//            String s1 = String.valueOf(o1);
//            String s2 = String.valueOf(o2);
//            if (!s1.equals(s2)&&s2.startsWith(s1)){
//                if (s2.charAt(s1.length())==s1.charAt(0)){
//                    return s1.length()-s2.length();
//                }
//                return s2.charAt(s1.length())-s1.charAt(0);
//            }
//            return 0;
//        });
        String res = "";
        for (Integer n:collect){
            res+=n;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = largestNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247});
        System.out.println(s);
    }
}
