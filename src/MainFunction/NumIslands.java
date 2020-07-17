package MainFunction;

import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/4/20
 * Time: 9:40
 * Description: 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *              岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *              此外，你可以假设该网格的四条边均被水包围
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int i,int j){
        if (i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }

    public static void main(String[] args) {
        System.out.println(5>>>2);
//        System.out.println(0&6&7);
    }
}
