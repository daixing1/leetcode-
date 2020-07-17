package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/15
 * Time: 9:30
 * Description: 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数
 */
public class SubarraySum {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i=0;i<nums.length;i++){
            int sum = 0;
            for (int j=i;j<nums.length;j++){
                sum+=nums[j];
                if (sum==k){
                    count++;
                    break;
                }else if (sum>k){
                    break;
                }
            }
        }
        return count;
    }
}
