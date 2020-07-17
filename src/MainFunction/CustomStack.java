package MainFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/7/10
 * Time: 10:40
 * Description: 请你设计一个支持下述操作的栈。
 *              实现自定义栈类 CustomStack ：
 *                  CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量，
 *                  栈在增长到 maxSize 之后则不支持 push 操作。
 *                  void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
 *                  int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1 。
 *                  void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，
 *                  则栈中的所有元素都增加 val 。
 *
 */
public class CustomStack {
    private int maxsize;
    private Stack<Integer> stack;
//    private Stack<Integer> incrStack;
    public CustomStack(int maxSize) {
        stack = new Stack<>();
        this.maxsize = maxSize;
    }

    public void push(int x) {
        if (stack.size()>=maxsize){
            return;
        }
        stack.push(x);
    }

    public int pop() {
        if (stack.isEmpty()){
            return -1;
        }
        return stack.pop();
    }

    public void increment(int k, int val) {
        List<Integer> list = new ArrayList<>(stack);
        stack.clear();
        for (int i=0;i<list.size();i++){
            if (i<k){
                stack.push(list.get(i)+val);
            }else {
                stack.push(list.get(i));
            }

        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        customStack.pop();
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.increment(5,100);
        customStack.increment(2,100);
        customStack.pop();
        customStack.pop();
        customStack.pop();
        customStack.pop();

    }
}
