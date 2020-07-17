package MainFunction;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/4/19
 * Time: 14:48
 * Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *              有效字符串需满足：
 *                  左括号必须用相同类型的右括号闭合。
 *                  左括号必须以正确的顺序闭合。
 *
 */
public class IsValid {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (' '==chars[i]){
                continue;
            }
            if (')'==chars[i]&&stack.size()>0){
                Character pop = stack.pop();
                if (pop!='('){
                    return false;
                }
            }
            if (']'==chars[i]){
                Character pop = stack.pop();
                if (pop!='['){
                    return false;
                }
            }
            if ('}'==chars[i]){
                Character pop = stack.pop();
                if (pop!='{'){
                    return false;
                }
            }
            stack.push(chars[i]);
        }
        if (stack.size()==0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean valid = isValid("()");
        System.out.println();
    }
}
