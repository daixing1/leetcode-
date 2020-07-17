package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/27
 * Time: 10:12
 * Description: 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *              ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *              搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *              你可以假设数组中不存在重复的元素。
 *              你的算法时间复杂度必须是 O(log n) 级别。
 */
public class Search {
    public static int search(int[] nums, int target) {
        if (nums.length==0){
            return -1;
        }
        int index = getTarget(nums,target,0,nums.length-1);
        return index;


    }

    public static int getTarget(int[] nums, int target,int left,int right){
        if (left>right){
            return -1;
        }
        int mid = (right+left)/2;
        if (nums[mid]>target){
            if (nums[mid]>nums[right]){
                if (nums[left]>target){
                    left = mid+1;
                    return getTarget(nums,target,left,right);
                }else if (nums[left]<target){
                    right = mid-1;
                    return getTarget(nums,target,left,right);
                }else {
                    return 0;
                }
            }else {
                right = mid-1;
                return getTarget(nums,target,left,right);
            }
        }else if (nums[mid]<target){
            if (nums[mid]<nums[right]){
                left = mid+1;
                return getTarget(nums,target,left,right);
            }else {
                if (nums[left]>target){
                    left = mid+1;
                    return getTarget(nums,target,left,right);
                }else if (nums[left]<target){
                    right = mid-1;
                    return getTarget(nums,target,left,right);
                }else {
                    return 0;
                }
            }
        }else {
            return mid;
        }
    }

    public static void main(String[] args) {
//        int search = search(new int[]{4,5,6,7,0,1,2}, 6);
        System.out.println(1<<2);
    }
}
