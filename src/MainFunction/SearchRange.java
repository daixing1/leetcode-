package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/1
 * Time: 14:41
 * Description: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *              你的算法时间复杂度必须是 O(log n) 级别。
 *              如果数组中不存在目标值，返回 [-1, -1]
 */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        int low = 0;
        int high = nums.length-1;
        int mid = (low+high)/2;
        while (low<=high){
            mid = (low+high)/2;
            if (nums[mid]>target){
                high = mid-1;
            }else if (nums[mid]<target){
                low = mid+1;
            }else {
                for (int i=mid;i>=0;i--){
                    if (nums[i]==target){
                        res[0] = i;
                        break;
                    }
                }
                for (int i=mid;i<nums.length;i++){
                    if (nums[i]==target){
                        res[1] = i;
                        break;
                    }
                }
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = searchRange(new int[]{1}, 1);
        System.out.println(ints);
    }
}
