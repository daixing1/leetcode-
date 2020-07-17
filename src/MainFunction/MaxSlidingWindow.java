package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/2/21
 * Time: 13:01
 * Description: 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0){
            return new int[0];
        }
        int reslut[] = new int[nums.length+1-k];
        int max = nums[0];
        int second = 0;
        int third = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<=k-1;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max = Math.max(max,nums[i]);
            if (nums[i]<max&&nums[i]>second){
                second = nums[i];
            }
            if (nums[i]<max&&nums[i]<second&&nums[i]>third){
                third = nums[i];
            }
        }
        reslut[0] = max;
        int i=0;
        int j=k-1;
        while (j<nums.length){
            i++;
            j++;
            if (j<nums.length){
                if (nums[j]>=max){
                    max = nums[j];
                    second = max;
                    third = second;
                    map.put(nums[j],map.getOrDefault(nums[j],0)+1);
                    map.put(nums[i-1],map.getOrDefault(nums[i-1],0)-1);
                }else {
                    if (nums[i-1]==max){

                    }else if (nums[i-1]==second){

                    }else {

                    }

                }
                reslut[i] = max;
            }
        }
        return reslut;
    }


}
