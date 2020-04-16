package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/15
 * Time: 14:25
 * Description: 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *              两个相邻元素间的距离为 1 。
 */
public class UpdateMatrix {
    public static int[][] updateMatrix(int[][] matrix) {
        boolean[][] isUpdate = new boolean[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]==0){
                    isUpdate[i][j] = true;
                }else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]!=0){
                    update(isUpdate,i,j,matrix);
                }
            }
        }
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (matrix[i][j]!=0){
                    matrix[i][j] = Math.min(matrix[Math.max(i - 1, 0)][j], Math.min(matrix[Math.min(i + 1, isUpdate.length - 1)][j],
                            Math.min(matrix[i][Math.max(j - 1, 0)], matrix[i][Math.min(j + 1, isUpdate[i].length-1)]))) + 1;
                }
            }
        }
//        update(isUpdate,0,0,matrix);
        return matrix;
    }

    public static void update(boolean[][] isUpdate,int i,int j, int[][] matrix){

        if (!isUpdate[Math.max(i-1,0)][j]&&!isUpdate[Math.min(i+1,isUpdate.length-1)][j]
                &&!isUpdate[i][Math.max(j-1,0)]&&!isUpdate[i][Math.min(j+1,isUpdate[i].length-1)]){
            if (i+1<isUpdate.length){
                update(isUpdate,i+1,j,matrix);
            }
            if (j+1<isUpdate[i].length){
                update(isUpdate,i,j+1,matrix);
            }
        }

        matrix[i][j] = Math.min(matrix[Math.max(i - 1, 0)][j], Math.min(matrix[Math.min(i + 1, isUpdate.length - 1)][j],
                Math.min(matrix[i][Math.max(j - 1, 0)], matrix[i][Math.min(j + 1, isUpdate[i].length-1)]))) + 1;
        isUpdate[i][j] = true;
    }

    public static void main(String[] args) {
        int[][] ints = updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
        System.out.println();
    }
}
