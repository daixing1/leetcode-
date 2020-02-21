package MainFunction;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * User: 兴希
 * Date: 2020/2/21
 * Time: 13:17
 * Description: 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back
 *              和 pop_front 的时间复杂度都是O(1)。
 *              若队列为空，pop_front 和 max_value 需要返回 -1
 */
public class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> maxQueue;
    public MaxQueue() {
        queue=new ArrayDeque();
        maxQueue=new ArrayDeque();
    }
    public int max_value() {
        if(maxQueue.isEmpty())
            return -1;
        return maxQueue.peek();
    }
    public void push_back(int value) {
        queue.add(value);
        while(!maxQueue.isEmpty() && value>maxQueue.getLast())
            maxQueue.pollLast();
        maxQueue.add(value);
    }
    public int pop_front() {
        if(queue.isEmpty())
            return -1;
        int ans=queue.poll();
        if(ans==maxQueue.peek())
            maxQueue.poll();
        return ans;
    }
}
