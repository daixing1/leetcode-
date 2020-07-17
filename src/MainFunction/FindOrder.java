package MainFunction;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: 兴希
 * Date: 2020/5/17
 * Time: 10:42
 * Description: 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *              在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，
 *              我们用一个匹配来表示他们: [0,1]
 *              给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *              可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组
 */
public class FindOrder {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses==0){
            return new int[0];
        }
        int[] res = new int[numCourses];
        if (prerequisites.length==0){
            for (int i=0;i<res.length;i++){
                res[i] = i;
            }
            return res;
        }
        int[] indegree = new int[numCourses];
        for (int[] array:prerequisites){
            indegree[array[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<indegree.length;i++){
            if (indegree[i]==0){
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()){
            Integer course = queue.poll();
            res[count] = course;
            count++;
            for (int[] arr:prerequisites){
                if (arr[1]==course){
                    indegree[arr[0]]--;
                    if (indegree[arr[0]]==0){
                        queue.offer(arr[0]);
                    }
                }
            }
        }
        if (count==numCourses){
            return res;
        }
        return new int[0];
    }

    public static int[] findOrder1(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return new int[0];
        int[] inDegrees = new int[numCourses];
        // 建立入度表
        for (int[] p : prerequisites) { // 对于有先修课的课程，计算有几门先修课
            inDegrees[p[0]]++;
        }
        // 入度为0的节点队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }
        int count = 0;  // 记录可以学完的课程数量
        int[] res = new int[numCourses];  // 可以学完的课程
        // 根据提供的先修课列表，删除入度为 0 的节点
        while (!queue.isEmpty()){
            int curr = queue.poll();
            res[count++] = curr;   // 将可以学完的课程加入结果当中
            for (int[] p : prerequisites) {
                if (p[1] == curr){
                    inDegrees[p[0]]--;
                    if (inDegrees[p[0]] == 0) queue.offer(p[0]);
                }
            }
        }
        if (count == numCourses) return res;
        return new int[0];
    }

    public static void main(String[] args) {
        int[] order = findOrder1(2, new int[][]{});
    }
}
