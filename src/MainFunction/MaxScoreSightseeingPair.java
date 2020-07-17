package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/6/17
 * Time: 8:09
 * Description: 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *              一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 *              返回一对观光景点能取得的最高分。
 */
public class MaxScoreSightseeingPair {
    public static int maxScoreSightseeingPair(int[] A) {
        int[][] scoreIndex = new int[A.length][2];
        for (int i=0;i<A.length;i++){
            scoreIndex[i][0] = A[i];
            scoreIndex[i][1] = i;
        }
        Arrays.sort(scoreIndex,(o1, o2) -> {
            if (o1[0]==o2[0]){
                return o1[1]-o2[1];
            }else {
                return o2[0]-o1[0];
            }
        });
        int maxScore = 0;
        boolean flag = false;
        for (int i=0;i<scoreIndex.length-1;i++){
            for (int j=i+1;j<scoreIndex.length;j++){
                if (scoreIndex[i][0]+scoreIndex[j][0]<=maxScore){
                    if (j==i+1){
                        flag = true;
                    }
                    break;
                }
                maxScore = Math.max(maxScore,scoreIndex[i][0]+scoreIndex[j][0]-Math.abs(scoreIndex[i][1]-scoreIndex[j][1]));
            }
            if (flag){
                break;
            }
        }
        return maxScore;
    }

    public static void main(String[] args) {
        int i = maxScoreSightseeingPair(new int[]{3,7,2,3});
        System.out.println(i);
    }
}
