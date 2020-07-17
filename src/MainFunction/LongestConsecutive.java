package MainFunction;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * User: 兴希
 * Date: 2020/6/6
 * Time: 9:50
 * Description: 给定一个未排序的整数数组，找出最长连续序列的长度。
 *              要求算法的时间复杂度为 O(n)。
 */
public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        for (int i=0;i<nums.length;i++){
            queue.add(nums[i]);
        }
        int tmp = queue.poll();
        int max = 0;
        int len = 1;
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            if (poll == tmp+1){
                len++;
                tmp = poll;
                continue;
            }else if (poll==tmp){
                continue;
            }else {
                max = Math.max(len,max);
                tmp = poll;
                len = 1;
            }
        }
        return Math.max(max,len);
    }

    public static void main(String[] args) {
        int i = longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6});
    }
}
