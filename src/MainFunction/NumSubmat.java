package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/15
 * Time: 20:34
 * Description: 给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。
 */
public class NumSubmat {
    public int numSubmat(int[][] mat) {
        int sum = 0;
        int[][] left = new int[mat.length][mat[0].length];
        int[][] up = new int[mat.length][mat[0].length];
        for (int i=0;i<mat.length;i++){
            for (int j=0;j<mat[0].length;j++){
                if (mat[i][j]==1){
                    left[i][j] = left[i][Math.max(j-1,0)]+1;
                    up[i][j] = up[Math.max(i-1,0)][j]+1;
                    sum+=left[i][j]+up[i][j]-1;
                }
            }
        }
        for (int i=1;i<mat.length;i++){
            for (int j=1;j<mat[0].length;j++) {
                if (left[i][j]>1){
                    int tmp = left[i][j];
                    for (int k=i-1;k>=0;k--){
                        if (left[k][j]>1){
                            tmp = Math.min(tmp,left[k][j]);
                            sum+=tmp-1;
                        }else {
                            break;
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        NumSubmat numSubmat = new NumSubmat();
        int i = numSubmat.numSubmat(new int[][]{
                {0,1,1,0},
                {0,1,1,1},
                {1,1,1,0}
        });
        System.out.println(i);
    }
}
