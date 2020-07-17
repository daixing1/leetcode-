package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/9
 * Time: 10:58
 * Description: 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *              我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，总满足 array[i] <= array[i + 1]
 */
public class CheckPossibility {
    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        if (nums.length==1){
            return true;
        }
        if (nums[0]>nums[1]){
            nums[0] = nums[1];
            count++;
        }
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]<=nums[i+1]){
                continue;
            }else {
                if (i+2<nums.length&&nums[i]>nums[i+2]){
                    return false;
                }
                count++;
            }
        }
        if (count<2){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean b = checkPossibility(new int[]{-1,4,2,3});
        System.out.println(b);
    }
}
