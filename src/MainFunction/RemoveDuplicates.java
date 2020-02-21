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

    public static void main(String[] args) {
        int length = removeDuplicates(new int[]{1,1,1,2,2,3});
        System.out.println(length);
    }
}
