package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/28
 * Time: 8:41
 * Description: 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，
 *              并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int[] prefix = new int[nums.length+1];
        for (int i=0;i<nums.length;i++){
            prefix[i+1] = prefix[i]+nums[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i=0;i<nums.length;i++){
            for (int j = i+1;j<prefix.length;j++){
                if (prefix[j]-prefix[i]>=s){
                    min = Math.min(min,j-i+1);
                    break;
                }
                if (j-i+1>=min){
                    break;
                }
            }
        }
        if (min==Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}
