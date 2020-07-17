package MainFunction;

import java.util.HashSet;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/7/1
 * Time: 10:52
 * Description: No Description
 */
public class LargestIsLand {
    private int curIslandArea;
    public int largestIsland(int[][] grid) {
        // 1 <= grid.length = grid[0].length <= 50
        int m = grid.length, n = grid[0].length;
        int[] area = new int[250];
        int index = 2, maxIslandArea = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                curIslandArea = 0;
                dfs(grid, i, j, index);
                if (curIslandArea != 0) {
                    // 岛屿的最大面积
                    maxIslandArea = Math.max(maxIslandArea, curIslandArea);
                    // 记录每一块岛屿的面积
                    area[index++] = curIslandArea;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    maxIslandArea = Math.max(maxIslandArea, changeSea(grid, m, n, area, i, j));
                }
            }
        }
        return maxIslandArea;
    }
    // DFS 求每一个小岛，并且获得每一个小岛的面积
    private void dfs(int[][] grid, int i, int j, int index) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) return;
        grid[i][j] = index;
        curIslandArea++;
        // 在此处判断，不用进入下一层递归
        dfs(grid, i-1, j, index);
        dfs(grid, i+1, j, index);
        dfs(grid, i, j-1, index);
        dfs(grid, i, j+1, index);
    }
    // 尝试改变每一个海洋(为0的地方)
    private int changeSea(int[][] grid, int m, int n, int[] area, int i, int j) {
        Set<Integer> set = new HashSet<>();
        int areaSum = 1;
        if (i-1 >= 0) set.add(grid[i-1][j]);
        if (i+1 < m) set.add(grid[i+1][j]);
        if (j-1 >= 0) set.add(grid[i][j-1]);
        if (j+1 < n) set.add(grid[i][j+1]);
        for (Integer index : set) {
            areaSum += area[index];
        }
        return areaSum;
    }

    public static void main(String[] args) {
        LargestIsLand largestIsLand = new LargestIsLand();
        int i = largestIsLand.largestIsland(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
        System.out.println(i);
    }
}
