package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/7
 * Time: 15:37
 * Description: 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 */
public class Rotate {
    public static void rotate(int[][] matrix) {
        for (int i=0;i<matrix.length;i++){
            for (int j=i+1;j<matrix[i].length;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length-j-1];
                matrix[i][matrix[i].length-j-1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
