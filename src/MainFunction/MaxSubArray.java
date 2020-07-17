package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/3
 * Time: 10:25
 * Description: 给定一个整数数组nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int maxSum = nums[0];
        int sum = nums[0];
        for (int i=1;i<nums.length;i++){
            if (nums[i]<0){
                maxSum = Math.max(sum,maxSum);
            }
            if (sum+nums[i]<nums[i]){
                sum = nums[i];
            }else {
                sum+=nums[i];
            }
        }
        return Math.max(sum,maxSum);
    }

    public static void main(String[] args) {
        int i = maxSubArray(new int[]{1,2});
        System.out.println(i);
    }
}
