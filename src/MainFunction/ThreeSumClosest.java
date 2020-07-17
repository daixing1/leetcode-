package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/6/24
 * Time: 8:52
 * Description: No Description
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i=0;i<nums.length-2;i++){
            int low = i+1;
            int high = nums.length-1;
            while (low<high){
                if (Math.abs(nums[i]+nums[low]+nums[high]-target)<=min){
                    min = Math.abs(nums[i]+nums[low]+nums[high]-target);
                    low++;
                    high--;
                }else {

                }
            }
        }
        return min;
    }
}
