package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/27
 * Time: 8:24
 * Description: 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        StringBuilder  sb = new StringBuilder("0".repeat(nums.length));
        for (int n:nums){
            if (n>0&&n<=nums.length){
                sb.replace(n-1,n,"1");
            }
        }
        for (int i=0;i<sb.length();i++){
            if (sb.charAt(i)=='0'){
                return i+1;
            }
        }
        return nums.length+1;
    }

    public static void main(String[] args) {
        int i = firstMissingPositive(new int[]{3,4,1,-1});
        System.out.println(i);
    }
}
