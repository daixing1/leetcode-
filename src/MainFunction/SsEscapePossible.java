package MainFunction;

import java.util.HashSet;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/7/23
 * Time: 10:15
 * Description: 在一个 10^6 x 10^6 的网格中，每个网格块的坐标为 (x, y)，其中 0 <= x, y < 10^6。
 *              我们从源方格 source 开始出发，意图赶往目标方格 target。每次移动，我们都可以走到网格中在四个方向上相邻的方格，只要该方格不在给出的封锁列表 blocked 上。
 *              只有在可以通过一系列的移动到达目标方格时才返回 true。否则，返回 false。
 */
public class SsEscapePossible {
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length==0){
            return true;
        }
        Set<int[]> set = new HashSet<>();
        int[] left = new int[2];
        for (int[] arr:blocked){
            set.add(arr);
        }
        return true;
    }
}
