package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/7/18
 * Time: 11:25
 * Description: 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class CanPartition {
    boolean flag = false;
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum%2==1){
            return false;
        }
        traverse(nums,0,sum>>1,new boolean[nums.length]);
        return flag;
    }

//    private boolean isValid(int[] nums,int target){
//        Arrays.sort(nums);
//        int low = 0;
//        int high =
//    }

    private void traverse(int[] nums, int index, int sum, boolean[] state){
        if (sum==0){
            flag = true;
            return;
        }
        if (sum<0){
            return;
        }
        for (int i=index;i<nums.length;i++){
            if (flag){
                return;
            }
            if (!state[i]){
                state[i] = true;
                traverse(nums,index+1,sum-nums[i], state);
                state[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        CanPartition partition = new CanPartition();
        boolean b = partition.canPartition(new int[]{1,2,5});
        System.out.println(b);
    }
}
