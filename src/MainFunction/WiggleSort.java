package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/5/20
 * Time: 22:51
 * Description: 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序
 */
public class WiggleSort {
    public void wiggleSort(int[] nums) {
        int tmp = 0;
        Arrays.sort(nums);
        int pos = 1;
        for (int i=nums.length-1;i<nums.length;i--){
            tmp = nums[i];
            for (int j=i-1;j>=pos;j--){
                nums[j+1] = nums[j];
            }
            nums[pos] = tmp;
            pos+=2;
        }
    }

    public static void main(String[] args) {
        WiggleSort wiggleSort = new WiggleSort();
        wiggleSort.wiggleSort(new int[]{4,5,5,6});
    }
}
