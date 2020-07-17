package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/21
 * Time: 9:14
 * Description: 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *              请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]==target){
                    return true;
                }
                if (matrix[i][j]>target){
                    break;
                }
            }
        }
        return false;
    }
}
