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

    public int[][] insert1(int[][] intervals, int[] newInterval) {
        if (intervals==null||intervals.length==0){
            return new int[][]{newInterval};
        }

        List<int[]> list = new ArrayList<>();
        if (intervals[0][0]>newInterval[1]){
            list.add(newInterval);
            for (int[] arr:intervals){
                list.add(arr);
            }
        }else {
            int i=0;
            boolean flag = false;
            for (;i<intervals.length;i++){
                if (intervals[i][1]<newInterval[0]||flag){
                    list.add(intervals[i]);
                }else if (intervals[i][1]>=newInterval[0]&&intervals[i][0]<=newInterval[0]){
                    flag = true;
                    if (newInterval[1]<=intervals[i][1]){
                        list.add(intervals[i]);
                    }else {
                        int j = i;
                        while (j<intervals.length&&intervals[j][1]<newInterval[1]){
                            j++;
                        }
                        if (j>=intervals.length){
                            list.add(new int[]{intervals[i][0],newInterval[1]});
                            i = j;
                        }else if (intervals[j][1]>=newInterval[1]&&intervals[j][0]<=newInterval[1]){
                            list.add(new int[]{intervals[i][0],intervals[j][1]});
                            i = j;
                        }else {
                            list.add(new int[]{intervals[i][0],newInterval[1]});
                            list.add(intervals[j]);
                            i = j;
                        }
                    }
                }else {
                    flag = true;
                    if (newInterval[1]<intervals[i][0]){
                        list.add(newInterval);
                        list.add(intervals[i]);
                    }else if (newInterval[1]>=intervals[i][0]&&newInterval[1]<=intervals[i][1]){
                        list.add(new int[]{newInterval[0],intervals[i][1]});
                    }else {
                        int j = i;
                        while (j<intervals.length&&intervals[j][1]<newInterval[1]){
                            j++;
                        }
                        if (j>=intervals.length){
                            list.add(newInterval);
                            i = j;
                        }else if (intervals[j][1]>=newInterval[1]&&intervals[j][0]<=newInterval[1]){
                            list.add(new int[]{newInterval[0],intervals[j][1]});
                            i = j;
                        }else {
                            list.add(newInterval);
                            list.add(intervals[j]);
                            i = j;
                        }
                    }
                }
            }
            if (!flag){
                list.add(newInterval);
            }
        }
        int[][] res = new int[list.size()][2];
        return list.toArray(res);
    }

    public static void main(String[] args) {
        Insert insert = new Insert();
        int[][] res = insert.insert1(new int[][]{{1, 5},{7, 8}}, new int[]{6, 6});
        System.out.println();
    }

}
