package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/7/13
 * Time: 22:08
 * Description: 我们定义「顺次数」为：每一位上的数字都比前一位上的数字大 1 的整数。
 *              请你返回由 [low, high] 范围内所有顺次数组成的 有序 列表（从小到大排序）。
 */
public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        int n = 0;
        int num = low;
        while (num>=10){
            n++;
            num/=10;
        }
        int m = num;
        List<Integer> list = new ArrayList<>();
        int last = 0;
        boolean flag = false;
        while (last<high){
            flag = false;
            for (int i=1;i<=n;i++){
                if (num+n>9){
                    n++;
                    num = 1;
                    m = num;
                    flag = true;
                    break;
                }
                m = m*10+num+i;
            }
            if (!flag){
                if (m>low){
                    list.add(m);
                }
                last = m;
                num++;
                m = num;
            }
        }
        if (last>high){
            list.remove(list.size()-1);
        }
        return list;
    }

    public List<Integer> sequentialDigits1(int low, int high) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(2,Arrays.asList(12,23,34,45,56,67,78,89));
        map.put(3,Arrays.asList(123,234,345,456,567,678,789));
        map.put(4,Arrays.asList(1234,2345,3456,4567,5678,6789));
        map.put(5,Arrays.asList(12345,23456,34567,45678,56789));
        map.put(6,Arrays.asList(123456,234567,345678,456789));
        map.put(7,Arrays.asList(1234567,2345678,3456789));
        map.put(8,Arrays.asList(12345678,23456789));
        map.put(9,Arrays.asList(123456789));
        int nl = 0;
        int numl = low;
        while (numl >= 10) {
            nl++;
            numl /= 10;
        }
        int nh = 0;
        int numh = high;
        while (numh >= 10) {
            nh++;
            numh /= 10;
        }
        nl++;
        nh++;
        List<Integer> res = new ArrayList<>();
        if (nh==nl){
            if (map.get(nh)!=null){
                for (int n:map.get(nh)){
                    if (n>=low&&n<=high){
                        res.add(n);
                    }
                }
            }
            return res;
        }
        List<Integer> list = map.get(nl++);
        if (list!=null){
            for (int n:list){
                if (n>=low){
                    res.add(n);
                }
            }
        }
        while (nl++<nh){
            res.addAll(map.get(nl-1));
        }
        List<Integer> list1 = map.get(nh);
        if (list1!=null){
            for (int n:list1){
                if (n<=high){
                    res.add(n);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SequentialDigits sequentialDigits = new SequentialDigits();
        List<Integer> list = sequentialDigits.sequentialDigits1(100 ,300);
        System.out.println(list);
    }
}
