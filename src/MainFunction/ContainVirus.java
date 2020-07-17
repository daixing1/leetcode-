package MainFunction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/7/8
 * Time: 11:04
 * Description: 病毒扩散得很快，现在你的任务是尽可能地通过安装防火墙来隔离病毒。
 *              假设世界由二维矩阵组成，0 表示该区域未感染病毒，而 1 表示该区域已感染病毒。可以在任意 2 个四方向相邻单元
 *              之间的共享边界上安装一个防火墙（并且只有一个防火墙）。
 *              每天晚上，病毒会从被感染区域向相邻未感染区域扩散，除非被防火墙隔离。现由于资源有限，每天你只能安装一系列
 *              防火墙来隔离其中一个被病毒感染的区域（一个区域或连续的一片区域），且该感染区域对未感染区域的威胁最大且
 *              保证唯一。
 *              你需要努力使得最后有部分区域不被病毒感染，如果可以成功，那么返回需要使用的防火墙个数;
 *              如果无法实现，则返回在世界被病毒全部感染时已安装的防火墙个数。
 */
public class ContainVirus {
    //所有被感染的集合
    Set<Integer> seen;
    //感染每个区域的集合
    List<Set<Integer>> regions;
    //对应感染病毒区域的未感染元素
    List<Set<Integer>> frontiers;
    //对应感染病毒区域的未感染元素个数
    List<Integer> perimeters;
    int[][] grid;
    int R, C;
    int[] dr = new int[]{-1, 1, 0, 0};
    int[] dc = new int[]{0, 0, -1, 1};

    public int containVirus(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;

        int ans = 0;
        while (true) {
            seen = new HashSet();
            regions = new ArrayList();
            frontiers = new ArrayList();
            perimeters = new ArrayList();

            for (int r = 0; r < R; ++r) {
                for (int c = 0; c < C; ++c) {
                    if (grid[r][c] == 1 && !seen.contains(r*C + c)) {
                        regions.add(new HashSet());
                        frontiers.add(new HashSet());
                        perimeters.add(0);
                        dfs(r, c);
                    }
                }
            }

            if (regions.isEmpty()) break;
            int triageIndex = 0;
            for (int i = 0; i < frontiers.size(); ++i) {
                if (frontiers.get(triageIndex).size() < frontiers.get(i).size())
                    triageIndex = i;
            }
            ans += perimeters.get(triageIndex);

            for (int i = 0; i < regions.size(); ++i) {
                if (i == triageIndex) {
                    for (int code: regions.get(i))
                        grid[code / C][code % C] = -1;
                } else {
                    for (int code: regions.get(i)) {
                        int r = code / C, c = code % C;
                        for (int k = 0; k < 4; ++k) {
                            int nr = r + dr[k], nc = c + dc[k];
                            if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == 0)
                                grid[nr][nc] = 1;
                        }
                    }
                }
            }
        }
        return ans;
    }

    //获取感染区域元素、感染区域周围未感染元素以及未感染元素个数
    public void dfs(int r, int c) {
        if (!seen.contains(r*C + c)) {
            seen.add(r*C + c);
            int N = regions.size();
            regions.get(N - 1).add(r*C + c);
            //忘四个方向扩展
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if (grid[nr][nc] == 1) {
                        dfs(nr, nc);
                    } else if (grid[nr][nc] == 0){
                        frontiers.get(N - 1).add(nr*C + nc);
                        perimeters.set(N - 1, perimeters.get(N - 1) + 1);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ContainVirus containVirus = new ContainVirus();
        int i = containVirus.containVirus(new int[][]{
                {1,1,1,0,0,0,0,0,0},
                {1,0,1,0,1,1,1,1,1},
                {1,1,1,0,0,0,0,0,0}});
        System.out.println(i);
    }
}
