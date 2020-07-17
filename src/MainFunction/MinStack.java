package MainFunction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/5/12
 * Time: 8:23
 * Description: 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *              push(x) —— 将元素 x 推入栈中。
 *              pop() —— 删除栈顶的元素。
 *              top() —— 获取栈顶元素。
 *              getMin() —— 检索栈中的最小元素。
 */
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack= new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.empty()){
            minStack.push(x);
        }else {
            Integer peek = minStack.peek();
            if (peek<x){
                minStack.push(peek);
            }else {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
