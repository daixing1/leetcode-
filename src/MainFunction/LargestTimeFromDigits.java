package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/5/30
 * Time: 22:15
 * Description: 给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
 *              最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
 *              以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。
 */
public class LargestTimeFromDigits {
    public String largestTimeFromDigits(int[] A) {
        String res = "";
        Map<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
//            list.add(i)
        }
        return res;
    }

    public boolean isValid(List<Integer> list){
        if (list.get(0)<3&&list.get(2)<6){
            if (list.get(0)==2&&list.get(1)<4){
                return true;
            }else if (list.get(0)<2){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
