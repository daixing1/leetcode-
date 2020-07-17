package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/26
 * Time: 9:56
 * Description: 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵
 */
public class GenerateMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int m = 1;
        int count = 0;
        while (m<=n*n){
            for (int i=count;i<n-count;i++){
                res[count][i] = m++;
            }
            for (int i=count+1;i<n-count;i++){
                res[i][n-1-count] = m++;
            }
            for (int i=n-2-count;i>=count;i--){
                res[n-1-count][i] = m++;
            }
            for (int i = n-2-count;i>=count+1;i--){
                res[i][count] = m++;
            }
            count++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(3);
        System.out.println(ints);
    }
}
