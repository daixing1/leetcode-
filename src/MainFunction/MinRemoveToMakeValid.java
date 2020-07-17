package MainFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/4/21
 * Time: 10:31
 * Description: 给你一个由 '('、')' 和小写字母组成的字符串 s。
 *              你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，
 *              使得剩下的「括号字符串」有效。
 *              请返回任意一个合法字符串。
 *                  有效「括号字符串」应当符合以下 任意一条 要求：
 *                  空字符串或只包含小写字母的字符串
 *                  可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 *                  可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 */
public class MinRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        String res = "";
        List<Integer> remove = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (stack.empty()&&chars[i]==')'){
                remove.add(i);
            }
            if(!stack.empty()&&chars[i]==')'){
                stack.pop();
            }
            if (chars[i]=='('){
                stack.push(i);
            }
        }
        if (!stack.empty()){
            remove.addAll(stack);
        }
        if (remove.size()==0){
            return s;
        }
        res = s.substring(0,remove.get(0));
        for (int i=0;i+1<remove.size();i++){
            res+=s.substring(remove.get(i)+1,remove.get(i+1));
        }
        res+=s.substring(remove.get(remove.size()-1)+1,s.length());
        return res;
    }
}
