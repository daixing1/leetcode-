package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/13
 * Time: 10:19
 * Description: 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
 *              并按照红色、白色、蓝色顺序排列。
 *              此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *              注意:
 *                  不能使用代码库中的排序函数来解决这道题
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int tmp = 0;
        int index = 0;
        int red = 0;
        int blue = nums.length-1;
        while (index<=blue){
            if (nums[index]==0){
                if (index!=red){
                    swap(nums,index,red);
                }
                red++;
                index++;
                continue;
            }
            if (nums[index]==1){
                index++;
                continue;
            }
            if (nums[index]==2){
                swap(nums,index,blue);
                blue--;
                continue;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        sortColors.sortColors(new int[]{2,0,1});
    }
}
