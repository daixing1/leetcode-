package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/17
 * Time: 9:46
 * Description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 *              如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *              你可以假设数组中无重复元素。
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while (low<high){
            int mid = (low+high)/2;
            if (nums[mid]>target){
                high = mid-1;
            }else if (nums[mid]<target){
                low = mid+1;
            }else {
                return mid;
            }
        }
        if (nums[low]<target){
            return low+1;
        }
        return low;
    }

    public static void main(String[] args) {
        SearchInsert searchInsert = new SearchInsert();
        int i = searchInsert.searchInsert(new int[]{1,3,5,6}, 7);
        System.out.println(i);
    }
}
