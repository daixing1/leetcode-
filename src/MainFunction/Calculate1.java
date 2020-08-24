package MainFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/8/23
 * Time: 22:18
 * Description: 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *              字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 */
public class Calculate1 {
    public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c==' '){
                continue;
            }
            if (c=='('||c=='+'||c=='-'){
                stack.push(String.valueOf(c));
                continue;
            }
            if (c==')'){
                list.clear();
                String pop = stack.pop();
                while (!"(".equals(pop)){
                    list.add(pop);
                    pop = stack.pop();
                }
                stack.push(String.valueOf(getTmpRes(list)));
                continue;
            }
            stack.push(String.valueOf(getNextDigita(s,i)));
        }
        if (stack.size()>1){
            list.clear();
            while (!stack.isEmpty()){
                list.add(stack.pop());
            }
            return getTmpRes(list);
        }else {
            return Integer.valueOf(stack.pop());
        }
    }

    private int getTmpRes(List<String> list){
        int res = Integer.valueOf(list.get(list.size()-1));
        for (int i = list.size()-2; i >= 0 ; i--) {
            String s = list.get(i);
            if ("+".equals(s)){
                res = res+Integer.valueOf(list.get(i-1));
            }else if ("-".equals(s)){
                res = res-Integer.valueOf(list.get(i-1));
            }
        }
        return res;
    }

    private int getNextDigita(String s, int index){
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c>='0'&&c<='9'){
                sb.append(c);
            }else {
                break;
            }
        }
        return Integer.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        Calculate1 calculate1 = new Calculate1();
        int calculate = calculate1.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(calculate);
    }
}
