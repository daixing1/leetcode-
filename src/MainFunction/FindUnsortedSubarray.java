package MainFunction;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;


/**
 * User: 兴希
 * Date: 2020/7/14
 * Time: 10:43
 * Description: 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *              你找到的子数组应是最短的，请输出它的长度
 */
public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums==null||nums.length<2){
            return 0;
        }
        int[] arr = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        int left = 0;
        int right = nums.length-1;
        for (;left<nums.length;left++){
            if (nums[left]!=arr[left]){
                break;
            }
        }
        for (;right>left;right--){
            if (nums[right]!=arr[right]){
                break;
            }
        }

        return right-left+1;
    }

    public static void main(String[] args) {
        FindUnsortedSubarray findUnsortedSubarray = new FindUnsortedSubarray();
        int unsortedSubarray = findUnsortedSubarray.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
        System.out.println(unsortedSubarray);
    }
}
