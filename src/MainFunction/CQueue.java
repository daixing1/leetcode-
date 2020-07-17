package MainFunction;

import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/6/8
 * Time: 9:52
 * Description: 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 *              分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class CQueue {

    Stack<Integer> popStack;
    Stack<Integer> pushStack;
    boolean flag;

    public CQueue() {
        popStack = new Stack<>();
        pushStack = new Stack<>();
        flag = true;
    }

    public void appendTail(int value) {
        if (flag){
            pushStack.push(value);
        }else {
            while (!popStack.isEmpty()){
                pushStack.push(popStack.pop());
            }
            pushStack.push(value);
            flag = true;
        }
    }

    public int deleteHead() {
        if (popStack.isEmpty()&&pushStack.isEmpty()){
            return -1;
        }
        if (flag){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
            flag = false;
        }
        return popStack.pop();
    }

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        int i = queue.deleteHead();
        queue.appendTail(5);
        queue.appendTail(2);
        int i1 = queue.deleteHead();
        int i2 = queue.deleteHead();
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);

    }
}
