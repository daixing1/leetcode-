package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/7/25
 * Time: 10:30
 * Description: 给定一个整数数组 A，你可以从某一起始索引出发，跳跃一定次数。在你跳跃的过程中，第 1、3、5... 次跳跃称为奇数跳跃，而第 2、4、6... 次跳跃称为偶数跳跃。
 *              你可以按以下方式从索引 i 向后跳转到索引 j（其中 i < j）：
 *              在进行奇数跳跃时（如，第 1，3，5... 次跳跃），你将会跳到索引 j，使得 A[i] <= A[j]，
 *              A[j] 是可能的最小值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
 *              在进行偶数跳跃时（如，第 2，4，6... 次跳跃），你将会跳到索引 j，使得 A[i] >= A[j]，
 *              A[j] 是可能的最大值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
 *              （对于某些索引 i，可能无法进行合乎要求的跳跃。）
 *              如果从某一索引开始跳跃一定次数（可能是 0 次或多次），就可以到达数组的末尾（索引 A.length - 1），
 *              那么该索引就会被认为是好的起始索引。
 *              返回好的起始索引的数量。
 */
public class OddEvenJumps {
//    public int oddEvenJumps(int[] A) {
//        if (A==null||A.length==0){
//            return 0;
//        }
//        int n = A.length;
//        int res = 1;
//        int step = 1;
//        Map<String, Boolean> map = new HashMap<>();
//        boolean[][] dp = new boolean[n][2];
//        dp[n-1][0] = dp[n-1][1] = true;
//        for (int i=n-2;i>=0;i--){
//            step = 1;
//            int k = i;
//            for (int j = i+1;j<n;j++){
//                if ((step&1)==1&&A[j]>=A[k]){
//                    step++;
//                    k = getNextIndex(A,j,A[k],true);
//                    if (k==-1){
//
//                    }
//                }
//                if ((step&1)==0&&A[j]<=A[k]){
//                    step++;
//                    k = j;
//                }
//            }
//            if (k)
//        }
//    }
//
//    //flag=ture 取index后大于n的最小值
//    //flag=false 取index后小于n的最大值
//    private int getNextIndex(int[] nums,int index, int n, boolean flag){
//        int num = n;
//        int pos = -1;
//        for (int i=index;i<nums.length;i++){
//            if (nums[i]==n){
//                if (pos==-1){
//                    pos = i;
//                }
//            }
//            if (flag&&nums[i]>=n){
//                if (num>nums[i]){
//                    num = nums[i];
//                    pos = i;
//                }
//            }
//            if (!flag&&nums[i]<=n){
//                if (num<nums[i]){
//                    num = nums[i];
//                    pos = i;
//                }
//            }
//        }
//        return pos;
//    }
}
