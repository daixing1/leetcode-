package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/13
 * Time: 9:09
 * Description: 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int[][] left = new int[matrix.length][matrix[0].length];
        int maxArea = 0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]=='1'){
                    left[i][j] = j==0?1:left[i][j-1]+1;
                    int maxWidth = left[i][j];
                    for (int k=i;k>=0;k--){
                        maxWidth = Math.min(maxWidth,left[k][j]);
                        maxArea = Math.max(maxArea,(i-k+1)*maxWidth);
                    }
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        int i = maximalRectangle.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        });
        System.out.println(i);
    }
}
