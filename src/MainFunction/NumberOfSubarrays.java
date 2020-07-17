package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/4/21
 * Time: 9:57
 * Description: 给你一个整数数组 nums 和一个整数 k。
 *              如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *              请返回这个数组中「优美子数组」的数目。
 */
public class NumberOfSubarrays {
    public static int numberOfSubarrays(int[] nums, int k) {
        int count =0;
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (nums[i]%2==1){
                list.add(i);
            }
        }
        if (list.size()<k){
            return 0;
        }
        if (list.size()==k){
            return (list.get(0)+1)*(nums.length-list.get(k-1));
        }
        for (int i=0;i+k-1<list.size();i++){
            if (i==0){
                count+=(list.get(0)+1)*(list.get(k)-list.get(k-1));
                continue;
            }
            if (i+k<list.size()){
                count+=(list.get(i)-list.get(i-1))*(list.get(i+k)-list.get(i+k-1));
                continue;
            }
            if (i+k-1==list.size()-1){
                count+=(list.get(i)-list.get(i-1))*(nums.length-list.get(i+k-1));
                continue;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2}, 2);
    }
}
