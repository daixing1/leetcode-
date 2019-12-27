package MainFunction;

import java.util.Arrays;
import java.util.Collection;

/**
 * User: 兴希
 * Date: 2019/12/26
 * Time: 19:38
 * Description: 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，
 *              其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
 */
public class MinMoves2 {
    public static int minMoves2(int[] nums) {
        int[] array = Arrays.stream(nums).sorted().toArray();
        int n = array.length/2;
        int mid = array[n];
        int step = 0;
        for (int i=0;i<array.length;i++){
            step += Math.abs(array[i]-mid);
        }
        return step;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1,2,3};
        minMoves2(num);
    }
}
