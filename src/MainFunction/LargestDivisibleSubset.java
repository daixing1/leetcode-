package MainFunction;

import java.lang.reflect.Array;
import java.util.*;

/**
 * User: 兴希
 * Date: 2020/8/20
 * Time: 22:36
 * Description: 给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。
 *              如果有多个目标子集，返回其中任何一个均可。
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums==null||nums.length==0){
            return new ArrayList<>();
        }
        if (nums.length==1){
            return Arrays.asList(nums[0]);
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new HashMap<>();
        list.add(nums[0]);
        map.put(nums[0],new ArrayList<>(Arrays.asList(nums[0])));
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            for (int j = i-1; j >= 0 ; j--) {
                if (n%nums[j]==0){
                    ArrayList<Integer> integers = new ArrayList<>(map.get(nums[j]));
                    if (list.size()<=integers.size()){
                        integers.add(n);
                        list = integers;
                        map.put(n,integers);
                    }
                    if (!map.containsKey(n)){
                        List<Integer> list1 = map.get(nums[j]);
                        list1.add(n);
                        map.put(n,new ArrayList<>(list1));
                    }
                    continue;
                }
                if (j==0&&!map.containsKey(n)){
                    map.put(n,new ArrayList<>(Arrays.asList(n)));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        List<Integer> list = largestDivisibleSubset.largestDivisibleSubset(new int[]{1,2,4,8,9,72});
        System.out.println(list);
    }
}
