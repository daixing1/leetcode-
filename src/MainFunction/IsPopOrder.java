package MainFunction;

import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/3/3
 * Time: 0:40
 * Description: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 *              假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈
 *              序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长
 *              度是相等的）
 */
public class IsPopOrder {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            int tmp = stack.pop();
            while(tmp==popA[j]){
                if(!stack.empty()){
                    tmp = stack.pop();
                }
                j++;
            }
            stack.push(tmp);
        }
        if(j==popA.length){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1});
    }
}