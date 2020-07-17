package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/4
 * Time: 10:09
 * Description: 给定一个非负整数数组，你最初位于数组的第一个位置。
 *              数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *              你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class Jump {
    public static int jump(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int[] count = new int[nums.length];
//        for (int i=0;i<nums[0];i++){
//            count[i+1]=1;
//        }
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<=i+nums[i]&&j<nums.length;j++){
                if (count[j]!=0){
                    count[j] = Math.min(Math.min(count[j-1]+1,count[i]+1),count[j]);
                }else {
                    count[j] = Math.min(count[j-1]+1,count[i]+1);
                }

            }
        }
        return count[nums.length-1];
    }

    public static int jump1(int[] nums){
        int count = 0;
        int maxPos = 0;
        int end = 0;
        for (int i=0;i<nums.length-1;i++){
            maxPos = Math.max(maxPos,i+nums[i]);

            if (i==end){
                end = maxPos;
                count++;
            }
            if (maxPos>=nums.length){
                return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int jump = jump1(new int[]{1,2,3,4,5});
        System.out.println(jump);
    }
}
