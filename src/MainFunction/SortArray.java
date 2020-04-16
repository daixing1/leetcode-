package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/3/31
 * Time: 10:32
 * Description: 给你一个整数数组 nums，将该数组升序排列。
 */
public class SortArray {
    public int[] sortArray(int[] nums) {
        if (nums.length==0){
            return nums;
        }
        int left=0,right=nums.length-1;
        int[] ints = quickSort(nums, 0, nums.length - 1);
        return ints;
    }

    public int[] quickSort(int[] nums, int start, int end){
        int bond = nums[start];
        boolean flag = false;
        int i = start;
        int j = end;
        while (i<j){
            if (!flag&&nums[j]<bond){
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                flag = true;
                i++;
            }else if (!flag&&nums[j]>=bond){
                j--;
            }else if (flag&&nums[i]>bond){
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                flag = false;
                j--;
            }else if (flag&&nums[i]<=bond){
                i++;
            }
        }
        if (i-1>start){
            nums = quickSort(nums,start,i-1);
        }
        if (j+1<end){
            nums = quickSort(nums,j+1,end);
        }
        return nums;
    }
}
