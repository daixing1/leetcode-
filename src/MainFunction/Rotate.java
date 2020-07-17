package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/7
 * Time: 15:37
 * Description: 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *              说明：
 *                  你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
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

    public static void rotate1(int[][] matrix) {
        int tmp = 0;
        for (int i=0;i<matrix.length/2;i++){
            for (int j=i;j<matrix.length-1-i;j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-j][i];
                matrix[matrix.length-1-j][i] = matrix[matrix.length-1-i][matrix.length-1-j];
                matrix[matrix.length-1-i][matrix.length-1-j] = matrix[j][matrix.length-1-i];
                matrix[j][matrix.length-1-i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        rotate1(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
    }
}
