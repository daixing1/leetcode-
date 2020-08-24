package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/8/23
 * Time: 22:47
 * Description: 在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。
 *              每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
 *              现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
 *              投影就像影子，将三维形体映射到一个二维平面上。
 *              在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
 *              返回所有三个投影的总面积。
 */
public class ProjectionArea {
    public int projectionArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int first = 0;
        for (int i = 0; i < m; i++) {
            first+=Arrays.stream(grid[i]).max().getAsInt();
        }
        int side = 0;
        int top = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                max = Math.max(grid[j][i],max);
                if (grid[j][i]!=0){
                    top++;
                }
            }
            side+=max;
        }
        return side+top+first;
    }

    public static void main(String[] args) {
        ProjectionArea projectionArea = new ProjectionArea();
        int i = projectionArea.projectionArea(new int[][]{{2,2,2},{2,1,2},{2,2,2}});
        System.out.println(i);
    }

}
