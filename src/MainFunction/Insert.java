package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/4/16
 * Time: 8:52
 * Description: 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *              在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 */
public class Insert {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int idx = 0;
        while (idx<intervals.length){
            if (intervals[idx][0]<newStart){
                res.add(intervals[idx]);
            }else {
                if (newEnd<intervals[idx][0]){
                    res.add(newInterval);
                }else if (res.isEmpty()||res.get(res.size()-1)[1]<newEnd){
                    res.add(new int[]{newStart,});
                }
            }
        }


        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        int[][] insert = insert(new int[][]{{1, 5}}, new int[]{0, 3});
        System.out.println();
    }

}
