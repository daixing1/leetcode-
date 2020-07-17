package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/5/26
 * Time: 10:10
 * Description: 给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），
 *              然后把数位和相等的数字放到同一个组中。
 *              请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个
 */
public class CountLargestGroup {
    public static int countLargestGroup(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=1;i<=n;i++){
            if (map.containsKey(getAnd(i))){
                map.get(getAnd(i)).add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(getAnd(i),list);
            }
        }
        int max = map.values().stream().max(Comparator.comparingInt(List::size)).get().size();
        return (int)map.values().stream().filter(o1->o1.size()==max).count();
    }

    public static int getAnd(int n){
        int res = 0;
        while (n>0){
            res+=n%10;
            n/=10;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = countLargestGroup(13);
        System.out.println(i);
    }
}
