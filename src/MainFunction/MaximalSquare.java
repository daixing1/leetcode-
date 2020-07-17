package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/8
 * Time: 9:43
 * Description: 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */
public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]=='1'){
                    max = Math.max(calSquare(matrix,i,j),max);
                }
            }
        }
        return max;
    }

    public static int calSquare(char[][] matrix,int m,int n){
        int s = matrix.length;
        for (int i=m;i<matrix.length;i++){
            for (int j=n;j<matrix[i].length;j++){
                if (j-n>=s||i-m>=s){
                    break;
                }
                if (matrix[i][j]=='0'&&j!=n){
                    s = Math.min(s,j-n);
                    break;
                }
                if (j==matrix[i].length-1){
                    s = Math.min(s,j-n+1);
                }
            }
            if (i-m>=s){
                break;
            }
            if (matrix[i][n]=='0'){
                s = Math.min(s,i-m);
                break;
            }
            if (i==matrix.length-1){
                s = Math.min(s,i-m+1);
            }
        }
        return (int)Math.pow(s,2);
    }

    public static void main(String[] args) {
        int i = maximalSquare(new char[][]{{'0','0','1','0'},{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','0'},{'1','1','0','0'},{'1','1','1','1'},{'1','1','1','0'}});
        System.out.println(i);
    }

}
