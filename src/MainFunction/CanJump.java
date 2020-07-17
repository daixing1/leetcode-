package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/11
 * Time: 15:41
 * Description: 给定一个非负整数数组，你最初位于数组的第一个位置。
 *              数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *              判断你是否能够到达最后一个位置。
 */
public class CanJump {
    public static boolean canJump(int[] nums) {
        if (nums.length==1){
            return true;
        }
        boolean[] flag = new boolean[nums.length];
        int index = 0;
        for (int i=0;i<nums.length;i++){
            index = Math.max(index,nums[i]+i);
            if (i!=nums.length-1&&index==i){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = canJump(new int[]{3, 2, 1, 0, 4});
        System.out.println(b);
    }
}
