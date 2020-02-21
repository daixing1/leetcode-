package MainFunction;

/**
 * User: 兴希
 * Date: 2020/2/21
 * Time: 13:01
 * Description: 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0){
            return new int[]{};
        }
        int reslut[] = new int[nums.length+1-k];
        for (int i=k-1; i<nums.length; i++){
            int[] numbers = new int[k];
            for (int j=0;j<k;j++){
                numbers[j] = nums[i-k+1];
            }
            int n = getMax(numbers);
            reslut[i-k+1]=n;
        }
        return reslut;
    }

    public int getMax(int[] nums){
        int max = nums[0];
        for (int n : nums){
            if (n>max){
                max = n;
            }
        }
        return max;
    }
}
