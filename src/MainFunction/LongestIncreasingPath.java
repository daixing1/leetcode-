package MainFunction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/7/26
 * Time: 20:31
 * Description: 给定一个整数矩阵，找出最长递增路径的长度。
 *              对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 */
public class LongestIncreasingPath {
    Map<String, Integer> map;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        map = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i=0;i<m;i++){
            Arrays.fill(dp[i],1);
        }
        int max = 0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (map.containsKey(i+"#"+j)){
                    max = Math.max(max,map.get(i+"#"+j));
                }else {
                    max = Math.max(max,getMaxIncreasing(matrix,i,j));
                }
            }
        }
        return max;
    }

    private int getMaxIncreasing(int[][] nums,int i, int j){
        int len1=1,len2=1,len3=1,len4=1;
        if (i-1>=0&&nums[i-1][j]>nums[i][j]){
            if (map.containsKey((i-1)+"#"+j)){
                len1 = map.get((i-1)+"#"+j)+1;
            }else {
                len1 = getMaxIncreasing(nums,i-1,j)+1;
                map.put((i-1)+"#"+j,len1-1);
            }
        }
        if (j-1>=0&&nums[i][j-1]>nums[i][j]){
            if (map.containsKey(i+"#"+(j-1))){
                len2 = map.get(i+"#"+(j-1))+1;
            }else {
                len2 = getMaxIncreasing(nums,i,j-1)+1;
                map.put(i+"#"+(j-1),len2-1);
            }
        }
        if (i+1<nums.length&&nums[i+1][j]>nums[i][j]){
            if (map.containsKey((i+1)+"#"+j)){
                len3 = map.get((i+1)+"#"+j)+1;
            }else {
                len3 = getMaxIncreasing(nums,i+1,j)+1;
                map.put((i+1)+"#"+j,len3-1);
            }
        }
        if (j+1<nums[0].length&&nums[i][j+1]>nums[i][j]){
            if (map.containsKey(i+"#"+(j+1))){
                len4 = map.get(i+"#"+(j+1))+1;
            }else {
                len4 = getMaxIncreasing(nums,i,j+1)+1;
                map.put(i+"#"+(j+1),len4-1);
            }
        }
        map.put(i+"#"+j,Math.max(len1,Math.max(len2,Math.max(len3,len4))));
        return Math.max(len1,Math.max(len2,Math.max(len3,len4)));
    }

//    public int longestIncreasingPath1(int[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return 0;
//        }
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            Arrays.fill(dp[i], 1);
//        }
//        for (int i=0;i<m;i++){
//            for (int j=0;j<n;j++){
//
//            }
//        }
//    }

    public static void main(String[] args) {
        LongestIncreasingPath longestIncreasingPath = new LongestIncreasingPath();
        int i = longestIncreasingPath.longestIncreasingPath(new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}});
        System.out.println(i);
    }

}
