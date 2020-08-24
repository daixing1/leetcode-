package MainFunction;

/**
 * User: 兴希
 * Date: 2020/8/3
 * Time: 20:43
 * Description: 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，
 *              其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 */
public class CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums==null||nums.length<2){
            return false;
        }

        int[] prefix = new int[nums.length+1];
        for (int i=0;i<nums.length;i++){
            prefix[i+1] = prefix[i]+nums[i];
        }
        for (int i=0;i<=nums.length-2;i++){
            for (int j = i+2; j <= nums.length; j++) {
                if (k==0){
                    if (prefix[j]-prefix[i]==0){
                        return true;
                    }
                }else if ((prefix[j]-prefix[i])%k==0){
                    return true;
                }
            }
        }
        return false;
    }
}
