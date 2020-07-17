package MainFunction;

import com.sun.source.tree.SynchronizedTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.SynchronousQueue;

/**
 * User: 兴希
 * Date: 2020/6/26
 * Time: 9:01
 * Description: 给定一个正整数数组 nums。
 *              找出该数组内乘积小于 k 的连续的子数组的个数。
 */
public class NumSubarrayProductLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = numSubarrayProductLessThanK(new int[]{1,1,1}, 2);
        System.out.println(i);
    }
}
