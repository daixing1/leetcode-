package MainFunction;


/**
 * User: 兴希
 * Date: 2019/12/29
 * Time: 11:15
 * Description: 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
 *              移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 *              返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 */
public class NumEnclaves {

    public int numEnclaves(int[][] A) {
        int row=A.length,col=A[0].length,count=0;
        if(row==0||col==0||A==null) return 0;
        for(int i=0;i<row;i++){
            dfs( A,i,0);
            dfs( A,i,col-1);
        }
        for(int j=0;j<col;j++){
            dfs( A,0,j);
            dfs( A,row-1,j);

        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                count +=A[i][j];
            }
        }
        return count;
    }
    public void dfs(int[][] A,int x,int y)
    {
        if(x<0|| x>=A.length ||y<0 || y>=A[0].length ) return;
        if(A[x][y]==0) return;
        A[x][y] =0;
        dfs( A,x+1,y);
        dfs( A,x-1,y);
        dfs( A,x  ,y+1);
        dfs( A,x  ,y-1);
    }
}
