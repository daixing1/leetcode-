package MainFunction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * User: 兴希
 * Date: 2020/7/14
 * Time: 9:46
 * Description: 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种
 *              不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。
 *              CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 *              然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内
 *              CPU 在执行不同的任务，或者在待命状态。
 *              你需要计算完成所有任务所需要的最短时间。
 */
public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        if (tasks==null||tasks.length==0){
            return 0;
        }
        if (tasks.length==1){
            return 1;
        }
        int[] taskCount = new int[26];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        Arrays.fill(taskCount,0);
        for (int i=0;i<tasks.length;i++){
            taskCount[tasks[i]-'A']++;
        }
        for (int num:taskCount){
            if (num>0){
                queue.offer(num);
            }
        }
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        while (flag){
            int m = n+1;
            flag = false;
            list.clear();
            while (!queue.isEmpty()){
                if (m==0){
                    break;
                }
                Integer poll = queue.poll();
                poll--;
                m--;
                sum++;
                flag = true;
                if (poll>0){
                    list.add(poll);
                }
            }
            for (int num:list){
                queue.add(num);
            }
            if (m>0&&!queue.isEmpty()){
                sum+=m;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LeastInterval leastInterval = new LeastInterval();
        int i = leastInterval.leastInterval(new char[]{'A','A','A','B','B','B'},2);
        System.out.println(i);
    }
}
