package MainFunction;

import java.util.HashSet;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/8/10
 * Time: 15:56
 * Description: 在 R 行 C 列的矩阵上，我们从 (r0, c0) 面朝东面开始
 *              这里，网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
 *              现在，我们以顺时针按螺旋状行走，访问此网格中的每个位置。
 *              每当我们移动到网格的边界之外时，我们会继续在网格之外行走（但稍后可能会返回到网格边界）。
 *              最终，我们到过网格的所有 R * C 个空间。
 *              按照访问顺序返回表示网格位置的坐标列表。
 */
public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        Set<String> set = new HashSet<>();
        int[][] res = new int[R*C][2];
        set.add(r0+"#"+c0);
        String direction = "right";
        int i = 0;
        res[i++] = new int[]{r0,c0};
        c0++;
        while (set.size()<R*C){
            if ("right".equals(direction)){
                while (c0<C){
                    if (!set.contains(r0+"#"+c0)){
                        res[i++] = new int[]{r0,c0};
                        set.add(r0+"#"+c0);
                    }
                    c0++;
                }
                direction = "down";
            }else if ("down".equals(direction)){
                while (r0<R){
                    if (!set.contains(r0+"#"+c0)){
                        res[i++] = new int[]{r0,c0};
                        set.add(r0+"#"+c0);
                    }
                    r0++;
                }
                direction = "left";
            }else if ("left".equals(direction)){
                direction = "up";
            }else {
                direction = "right";
            }
        }
        return res;
    }
}
