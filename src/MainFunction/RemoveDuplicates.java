package MainFunction;

/**
 * User: 兴希
 * Date: 2019/12/29
 * Time: 12:55
 * Description: 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *              不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int item = nums[0];
        int count = 1;
        int length = nums.length;
        for (int i=1;i<length;i++){
            if (nums[i]==item){
                count++;
            }else {
                item = nums[i];
                count = 1;
            }
            if (count>2){
                for (int j=i+1;j<nums.length;j++){
                    nums[j-1] = nums[j];
                }
                length--;
                i--;
            }

        }
        return length;
    }

    /**
     *      给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现1次，返回移除后数组的新长度。
     *      不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     */

    public static int removeDuplicates1(int[] nums) {
        int item = nums[0];
        int count = 0;
        int length = nums.length;
        for (int i=1;i<length;i++){
            if (nums[i]==item){
                count++;
            }else {
                if (count>0){
                    for (int j=i;j<length;j++){
                        nums[j-count] = nums[j];
                    }
                    length-=count;
                    i-=count;
                }
                count = 0;
                item = nums[i];
            }
        }
        return length;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int count = 0;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]==nums[i+1]){
                count++;
            }
        }
        return nums.length-count;
    }


    public static void main(String[] args) {
        int length = removeDuplicates2(new int[]{0,0});
        System.out.println(length);
    }
}
