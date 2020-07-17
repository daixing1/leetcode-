package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/6/28
 * Time: 11:32
 * Description: 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length==1){
            return new int[]{nums[0]};
        }
        Arrays.sort(nums);
        Map<Integer,List<Integer>> map = new TreeMap<>((o1, o2) -> o2-o1);
        int count = 1;
        int num = nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i]==num){
                count++;
            }else {
                if (map.containsKey(count)){
                    map.get(count).add(num);
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    map.put(count,list);
                }
                count = 1;
                num = nums[i];
            }
            if (i==nums.length-1){
                if (map.containsKey(count)){
                    map.get(count).add(num);
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    map.put(count,list);
                }
            }
        }
        int[] res = new int[k];
        Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
        int index = 0;
        while (iterator.hasNext()){
            Map.Entry<Integer, List<Integer>> next = iterator.next();
            List<Integer> value = next.getValue();
            for (int n:value){
                res[index] = n;
                index++;
                if (index>=k){
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = topKFrequent(new int[]{1, 1, 1}, 1);
        System.out.println();
    }
}
