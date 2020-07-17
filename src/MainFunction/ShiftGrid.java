package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/6/9
 * Time: 11:19
 * Description: 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 *              每次「迁移」操作将会引发下述活动：
 *                  位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 *                  位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 *                  位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 *              请你返回 k 次迁移操作后最终得到的 二维网格。
 */
public class ShiftGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        k = k%(grid[0].length*grid.length);
        if (k==0){

        }
        int a = k%grid[0].length;
        int b = k/grid[0].length;
        return new ArrayList<>();
    }
}
