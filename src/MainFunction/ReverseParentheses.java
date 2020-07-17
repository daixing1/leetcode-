package MainFunction;

import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/5/30
 * Time: 21:57
 * Description: 给出一个字符串 s（仅含有小写英文字母和括号）。
 *              请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *              注意，您的结果中 不应 包含任何括号。
 */
public class ReverseParentheses {
    public String reverseParentheses(String s) {

        Stack<String> stack = new Stack<>();
        String tmp ="";
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                if (!"".equals(tmp)){
                    stack.push(tmp);
                }
                stack.push("(");
                tmp = "";
                continue;
            }
            if (s.charAt(i)==')'){
                String pop = stack.pop();
                while (!"(".equals(pop)){
                    tmp = pop+tmp;
                    pop = stack.pop();
                }
                stack.push(reverse(tmp));
                tmp = "";
                continue;
            }
            tmp+=s.charAt(i);
        }
        String res = "";
        if (stack.isEmpty()){
            return tmp;
        }else {
            while (!stack.isEmpty()){
                res=stack.pop()+res;
            }
            return res+tmp;
        }
    }

    public String reverse(String s){
        String res = "";
        for (int i=0;i<s.length();i++){
            res+=s.charAt(s.length()-1-i);
        }
        return res;
    }
}
