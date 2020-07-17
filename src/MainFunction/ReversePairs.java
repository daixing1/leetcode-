package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/24
 * Time: 17:19
 * Description: 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 *              输入一个数组，求出这个数组中的逆序对的总数。
 */
public class ReversePairs {
    public static int reversePairs(int[] nums) {
        int count = 0;
        for (int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]>nums[j]){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = reversePairs(new int[]{7, 5, 6, 4});
        System.out.println(i);
    }
}
