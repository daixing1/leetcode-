package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/28
 * Time: 10:04
 * Description: 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *              要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        int sum = 0;
        int first = 1;
        for (int n:nums){
            sum^=n;
        }
        while ((sum&first)==0){
            first=first<<1;
        }
        for (int n:nums){
            if ((first&n)==0){
                res[0]^=n;
            }else {
                res[1]^=n;
            }
        }
        return res;
    }
}
