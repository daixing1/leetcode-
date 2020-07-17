package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/15
 * Time: 8:30
 * Description: 给定一个未排序的整数数组，找到最长递增子序列的个数。
 */
public class FindNumberOfLIS {
    public static int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int j=0;
        int max = 1;
        int count = 1;
        for (int i=1;i<nums.length;i++){
            j = i-1;
            while (j>=0&&nums[i]<=nums[j]){
                j--;
            }
            if (j<0){
                dp[i] = 1;
            }else {
                dp[i] = dp[j]+1;
            }
            if (dp[i]>max){
                max = dp[i];
                count = 1;
            }else if (dp[i]==max){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int numberOfLIS = findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2});
        System.out.println(numberOfLIS);
    }
}
