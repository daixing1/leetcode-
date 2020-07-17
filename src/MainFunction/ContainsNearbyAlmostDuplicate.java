package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/21
 * Time: 8:42
 * Description: 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 
 *              的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ
 */
public class ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (Math.abs(j-i)<=k&&Math.abs((long)nums[j]-(long)nums[i])<=t){
                    return true;
                }
            }
        }
        return false;
    }
}
