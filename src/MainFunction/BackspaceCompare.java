package MainFunction;

import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/7/25
 * Time: 20:19
 * Description: 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 */
public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        if (S.equals(T)){
            return true;
        }
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (Character c:S.toCharArray()){
            if ('#'==c){
                if (stack1.isEmpty()){
                    continue;
                }else {
                    stack1.pop();
                }
            }else {
                stack1.push(c);
            }
        }
        for (Character c:T.toCharArray()){
            if ('#'==c){
                if (stack2.isEmpty()){
                    continue;
                }else {
                    stack2.pop();
                }
            }else {
                stack2.push(c);
            }
        }
        if (stack1.size()!=stack2.size()){
            return false;
        }
        while (!stack1.isEmpty()){
            if (stack1.pop()!=stack2.pop()){
                return false;
            }
        }
        return true;
    }
}
