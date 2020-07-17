package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/5
 * Time: 7:51
 * Description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class SpiralOrder {
    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length==0||matrix[0].length==0){
            return new int[0];
        }
        int count = 0;
        int len = matrix.length*matrix[0].length;
        int[] res = new int[len];
        int i=0;
        while (count<len){
            for (int j=i;j<matrix[0].length-i;j++){
                res[count++] = matrix[i][j];
            }
            if (count>=len){
                break;
            }
            for (int j=i+1;j<matrix.length-i;j++){
                res[count++] = matrix[j][matrix[0].length-1-i];
            }
            if (count>=len){
                break;
            }
            for (int j=matrix[0].length-2-i;j>=i;j--){
                res[count++] = matrix[matrix.length-1-i][j];
            }
            if (count>=len){
                break;
            }
            for (int j=matrix.length-2-i;j>i;j--){
                res[count++] = matrix[j][i];
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        System.out.println(ints);
    }
}
