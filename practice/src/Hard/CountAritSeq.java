package Hard;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2019/12/15
 * Time: 19:45
 * Description: 求给出数组中数能组成等差数列的个数
 */
public class CountAritSeq {
    public static int numberOfArithmeticSlices(int[] A) {
        List<Integer> sort = sort(A);
        if (A.length<3){
            return 0;
        }else if (A.length==3){
            if (sort.get(2)-sort.get(1)==sort.get(1)-sort.get(0)){
                return 1;
            }else {
                return 0;
            }
        }else {
            for (int i=0;i<A.length;i++){

            }
            AtomicInteger result = new AtomicInteger();
            Map<Integer,List<List<Integer>>> map = new HashMap<>();
            for (int i=0;i<A.length-1;i++){
                for (int j = i+1;j<A.length;j++){
                    Integer sub = A[j]-A[i];
                    if (!map.containsKey(sub)){
                        List<List<Integer>> lists = new ArrayList<>();
                        List<Integer> nums = new ArrayList<>();
                        nums.add(A[i]);
                        nums.add(A[j]);
                        lists.add(nums);
                        map.put(sub,lists);
                    }else {
                        List<List<Integer>> lists = map.get(sub);
                        int finalJ = j;
                        int finalI = i;
                        for (int k=0;k<lists.size();k++){

                        }
                        AtomicBoolean flag = new AtomicBoolean(false);
                        lists.forEach(e ->{
                            if (e.get(e.size()-1)-e.get(e.size()-2)==A[finalJ]-e.get(e.size()-1)){
                                e.add(A[finalJ]);
                                flag.set(true);
                            }
                        });
                        if (!flag.get()){
                            List<Integer> nums = new ArrayList<>();
                            nums.add(A[finalI]);
                            nums.add(A[finalJ]);
                            lists.add(nums);
                        }

                    }
                }
            }
            map.forEach((k,v)->{
                v.forEach(e ->{
                    int n = e.size();
                    if (n>=3){
                        result.addAndGet(calSum(n));
                    }
                });
            });
            return result.get();
        }
    }

    public static int calSum(int n){
        if (n>2){
            return (n-1)*(n-2)/2;
        }else {
            return 0;
        }
    }

    public static List<Integer> sort(int[] A){
        List<Integer> a = new ArrayList<>();
        for (int num:A){
            a.add(num);
        }
        return a.stream().sorted().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int i = numberOfArithmeticSlices(new int[]{1,1,1,1});
        System.out.println(i);
    }
}
