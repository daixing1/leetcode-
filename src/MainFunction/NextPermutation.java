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
        if (nums==null||nums.length<2){
            return;
        }
        int tmp = nums[0];
        boolean flag = true;
        for (int i=1;i<nums.length;i++){
            if (tmp<nums[i]){
                flag = false;
                break;
            }
            tmp = nums[i];
        }
        if (flag){
            for (int i=0;i<nums.length/2;i++){
                tmp = nums[i];
                nums[i] = nums[nums.length-1-i];
                nums[nums.length-1-i] = tmp;
            }
            return;
        }
        for (int i=nums.length-1;i>=0;i--){
            tmp = nums[i];
            for (int j=i-1;j>=0;j--){
                if (tmp>nums[j]){
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    Arrays.sort(nums,j+1,nums.length);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(new int[]{3,1,2});
    }
}
