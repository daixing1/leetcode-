package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/26
 * Time: 8:30
 * Description: 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 *              可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
