package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/8
 * Time: 11:13
 * Description: 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class Exchange {
    public static int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int tmp = 0;
        while (left<right){
            while (left<nums.length&&nums[left]%2==1){
                left++;
            }
            if (left>=right||left>=nums.length){
                return nums;
            }
            tmp = nums[left];
            while (right>=0&&nums[right]%2==0){
                right--;
            }
            if (right<=left||right<0){
                return nums;
            }
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] exchange = exchange(new int[]{1, 11, 14});
        System.out.println();
    }
}
