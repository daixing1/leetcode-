package MainFunction;

import java.util.*;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2019/12/26
 * Time: 15:52
 * Description: 给出一个区间的集合，请合并所有重叠的区间
 */
public class Merge {
    public static int[][] merge(int[][] intervals) {
        if (intervals==null || intervals.length<=1){
            return intervals;
        }
        for (int i=0;i<intervals.length-1;i++){
            for (int j=i+1;j<intervals.length;j++){
                if (intervals[i][0]>intervals[j][0]){
                    int[] a = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = a;
                }
            }
        }
        List<int[]> result = new ArrayList<>();
        int i=0;
        int n = intervals.length;
        while (i<n){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i<n-1 && right>=intervals[i+1][0]){
                right = Math.max(right,intervals[i+1][1]);
                i++;
            }
            result.add(new int[]{left,right});
            i++;
        }
        int[][] array = new int[result.size()][];
        int m = 0;
        for (int[] a:result){
            array[m] = a;
            m++;
        }
        return array;

    }


    public static void main(String[] args) {
        int[] a1 = new int[]{1,4};
        int[] a2 = new int[]{0,2};
        int[] a3 = new int[]{3,5};
        int[] a4 = new int[]{15,18};
        int[][] pa = new int[][]{a1,a2,a3, a4};
        int[][] merge = merge(pa);
        System.out.println(merge);

    }


    private Map<int[], List<int[]> > graph;
    private Map<Integer, List<int[]> > nodesInComp;
    private Set<int[]> visited;

    // return whether two intervals overlap (inclusive)
    private boolean overlap(int[] a, int[] b) {
        return a[0] <= b[1] && b[0] <= a[1];
    }

    // build a graph where an undirected edge between intervals u and v exists
    // iff u and v overlap.
    private void buildGraph(List<int[]> intervals) {
        graph = new HashMap<>();
        for (int[] interval : intervals) {
            graph.put(interval, new LinkedList<>());
        }

        for (int[] interval1 : intervals) {
            for (int[] interval2 : intervals) {
                if (overlap(interval1, interval2)) {
                    graph.get(interval1).add(interval2);
                    graph.get(interval2).add(interval1);
                }
            }
        }
    }

    // merges all of the nodes in this connected component into one interval.
    private int[] mergeNodes(List<int[]> nodes) {
        int minStart = nodes.get(0)[0];
        for (int[] node : nodes) {
            minStart = Math.min(minStart, node[0]);
        }

        int maxEnd = nodes.get(0)[1];
        for (int[] node : nodes) {
            maxEnd= Math.max(maxEnd, node[1]);
        }

        return new int[]{minStart, maxEnd};
    }

    // use depth-first search to mark all nodes in the same connected component
    // with the same integer.
    private void markComponentDFS(int[] start, int compNumber) {
        Stack<int[]> stack = new Stack<>();
        stack.add(start);

        while (!stack.isEmpty()) {
            int[] node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);

                if (nodesInComp.get(compNumber) == null) {
                    nodesInComp.put(compNumber, new LinkedList<>());
                }
                nodesInComp.get(compNumber).add(node);

                for (int[] child : graph.get(node)) {
                    stack.add(child);
                }
            }
        }
    }

    // gets the connected components of the interval overlap graph.
    private void buildComponents(List<int[]> intervals) {
        nodesInComp = new HashMap();
        visited = new HashSet();
        int compNumber = 0;

        for (int[] interval : intervals) {
            if (!visited.contains(interval)) {
                markComponentDFS(interval, compNumber);
                compNumber++;
            }
        }
    }

    public List<int[]> merge(List<int[]> intervals) {
        buildGraph(intervals);
        buildComponents(intervals);

        // for each component, merge all intervals into one interval.
        List<int[]> merged = new LinkedList<>();
        for (int comp = 0; comp < nodesInComp.size(); comp++) {
            merged.add(mergeNodes(nodesInComp.get(comp)));
        }

        return merged;
    }

}
