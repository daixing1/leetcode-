package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/14
 * Time: 10:24
 * Description: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 *              找出那个只出现了一次的元素。
 *              说明：
 *                  你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int n:nums){
            res^=n;
        }
        return res;
    }
}
