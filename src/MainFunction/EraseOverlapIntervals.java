package MainFunction;

import java.util.Arrays;
import java.util.Comparator;

/**
 * User: 兴希
 * Date: 2020/5/27
 * Time: 10:22
 * Description: 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 *              注意:
 *                  可以认为区间的终点总是大于它的起点。
 *                  区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠
 */
public class EraseOverlapIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0]!=o2[0]){
                return o1[0]-o2[0];
            }else {
                return o1[1]-o2[1];
            }
        });
        int count = 0;
        for (int i=0,j=1;i<intervals.length&&j<intervals.length;){
            if (intervals[j][0]>=intervals[i][0]&&intervals[j][0]<intervals[i][1]){
                j++;
                count++;
            }else {
                i=j;
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int i = eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}});
        System.out.println(i);
    }
}
