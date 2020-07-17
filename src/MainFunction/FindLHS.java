package MainFunction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/5/4
 * Time: 11:17
 * Description: 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 *              现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。
 */
public class FindLHS {
    public int findLHS(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int n:nums){
            if (map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }else {
                map.put(n,1);
            }
        }
        if (map.size()==1){
            return 0;
        }
        int max = 0;
        List<Integer> collect = map.keySet().stream().sorted().collect(Collectors.toList());
        for (int i=0;i<collect.size()-1;i++){
            if (collect.get(i+1)-collect.get(i)==1){
                max = Math.max(max,map.get(collect.get(i+1))+map.get(collect.get(i)));
            }
        }
        return max;
    }

    public static int findLHS1(int[] nums) {
        int start = 0;
        int end = 0;

        Arrays.sort(nums);
        int tmp = nums[0];
        int max = 0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]==tmp){
                continue;
            }else if (nums[i]-tmp==1){
                end = i;
            }else if (nums[i]-tmp!=1){
                max = Math.max(max,end-start+1);
                tmp = nums[i-1];
                start = i;
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int lhs1 = findLHS1(new int[]{1, 3, 2, 2, 5, 2, 3, 7});
        System.out.println(lhs1);
    }
}
