package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/7/21
 * Time: 20:31
 * Description: 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5]
 *              和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 *              给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）
 *              元素来获得子序列，剩下的元素保持其原始顺序。
 */
public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        if (nums.length==1||(nums.length==2&&nums[0]==nums[1])){
            return 1;
        }
        if (nums.length==2){
            return 2;
        }
        int[] diff = new int[nums.length];
        int[] dp = new int[nums.length];
        dp[0] = 1;
        diff[0] = 1;
        if (nums[0]==nums[1]){
            dp[1] = 1;
            diff[1] = 1;
        }else {
            diff[1] = nums[1]-nums[0];
            dp[1] = 2;
        }
        for (int i=2;i<nums.length;i++){
            for (int j=i-1;j>=0;j--){
                if (nums[i]==nums[j]){
                    if (dp[i]<dp[j]){
                        dp[i] = dp[j];
                        diff[i] = diff[j];
                    }
                    break;
                }
                if (j==0){
                    if (dp[i]<2){
                        dp[i] = 2;
                        diff[i] = nums[i]-nums[0];
                    }
                }
                if (diff[j]*(nums[i]-nums[j])<0){
                    if (dp[i]<dp[j]+1){
                        dp[i] = dp[j]+1;
                        diff[i] = -diff[j];
                    }
                }else if (diff[j]*(nums[i]-nums[j])>0){
                    continue;
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public int wiggleMaxLength1(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        if (nums.length==1||(nums.length==2&&nums[0]==nums[1])){
            return 1;
        }
        if (nums.length==2){
            return 2;
        }
        int[] diff = new int[nums.length];
        int[] dp = new int[nums.length];
        dp[0] = 1;
        diff[0] = 1;
        if (nums[0]==nums[1]){
            dp[1] = 1;
            diff[1] = 1;
        }else {
            diff[1] = nums[1]-nums[0];
            dp[1] = 2;
        }
        for (int i=2;i<nums.length;i++){
            for (int j=i-1;j>=0;j--){
                if (nums[i]==nums[j]){
                    if (dp[i]<dp[j]){
                        dp[i] = dp[j];
                        diff[i] = diff[j];
                    }
                    break;
                }
                if (j==0){
                    if (dp[i]<2){
                        dp[i] = 2;
                        diff[i] = nums[i]-nums[0];
                    }
                }
                if (diff[j]*(nums[i]-nums[j])<0){
                    if (dp[i]<dp[j]+1){
                        dp[i] = dp[j]+1;
                        diff[i] = -diff[j];
                    }
                }else if (diff[j]*(nums[i]-nums[j])>0){
                    dp[i] = dp[j];
                    diff[i] = diff[j];
                    break;
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        WiggleMaxLength wiggleMaxLength = new WiggleMaxLength();
        int i = wiggleMaxLength.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8});
        System.out.println(i);
    }
}
