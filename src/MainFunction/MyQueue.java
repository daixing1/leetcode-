package MainFunction;

import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/5/31
 * Time: 9:58
 * Description: 使用栈实现队列的下列操作：
 *                  push(x) -- 将一个元素放入队列的尾部。
 *                  pop() -- 从队列首部移除元素。
 *                  peek() -- 返回队列首部的元素。
 *                  empty() -- 返回队列是否为空。
 */
public class MyQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;
    private boolean flag;
    private Integer peek;

    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
        flag = true;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (flag){
            if (peek==null){
                peek = x;
            }
            inStack.push(x);
        }else {
            if (!outStack.isEmpty()){
                peek = outStack.peek();
            }else {
                peek = x;
            }
            while (!outStack.isEmpty()){
                inStack.push(outStack.pop());
            }
            inStack.push(x);
            flag = true;
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!flag){
            Integer pop = outStack.pop();
            if (!outStack.isEmpty()){
                peek = outStack.peek();
            }else {
                peek = null;
            }
            return pop;
        }else {
            while (!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
            flag = false;
            Integer pop = outStack.pop();
            if (!outStack.isEmpty()){
                peek = outStack.peek();
            }else {
                peek = null;
            }
            return pop;
        }
    }

    /** Get the front element. */
    public int peek() {
        return peek;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (inStack.isEmpty()&&outStack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.pop();
        myQueue.push(2);
        myQueue.peek();
    }
}
