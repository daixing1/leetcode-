package MainFunction;

import java.util.Arrays;
import java.util.Comparator;

/**
 * User: 兴希
 * Date: 2020/6/11
 * Time: 15:49
 * Description: 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
 */
public class MinMoves {
    public static int minMoves(int[] nums) {
        int min = Arrays.stream(nums).boxed().min(Comparator.comparingInt(o->o)).get();
        long sum = Arrays.stream(nums).boxed().mapToInt(o->o).sum();
        return (int)(sum-min*nums.length);
    }

    public static void main(String[] args) {
        int i = minMoves(new int[]{1,1,2147483647});
        System.out.println(i);
    }
}
