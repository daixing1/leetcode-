package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/7/12
 * Time: 11:29
 * Description: 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *              如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *              必须原地修改，只允许使用额外常数空间。
 *              以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 *              1,2,3 → 1,3,2
 *              3,2,1 → 1,2,3
 *              1,1,5 → 1,5,1
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        int j = i+1;
        if (i>=0){
            while (j<nums.length&&nums[i]<=nums[j]){
                j++;
            }
            swap(nums,i,j-1);
        }
        reverse(nums,i+1,nums.length-1);
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j){
        int tmp = 0;
        while (i<j){
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(new int[]{3,1,2});
    }
}
