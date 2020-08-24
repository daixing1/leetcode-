package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/8/5
 * Time: 20:44
 * Description: 给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。
 *              有效的表达式需遵循以下约定：
 *                  "t"，运算结果为 True
 *                  "f"，运算结果为 False
 *                  "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT）
 *                  "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND）
 *                  "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR）
 */
public class ParseBoolExpr {
    Map<Character, Boolean> map = new HashMap<>();
    public boolean parseBoolExpr(String expression) {
        map.put('f',false);
        map.put('t',true);
//        Set<Character> set = new HashSet<>();
//        set.add('(');
//        set.add('|');
//        set.add('!');
//        set.add('&');
        Stack<Character> stack = new Stack<>();
        List<Character> list = new ArrayList<>();
        boolean flag = true;
        for (int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if (')'==c){
                Character pop = stack.pop();
                while (pop!='('){
                    list.add(pop);
                    pop = stack.pop();
                }
                Character pop1 = stack.pop();
                char nextchar = getBoolean(list, pop1);
                stack.push(nextchar);
                list.clear();
            }else if (','==c){
                continue;
            }else {
                stack.push(c);
            }
        }
        return map.get(stack.pop());
    }

    private char getBoolean(List<Character> list, Character c){
        boolean flag = map.get(list.get(0));
        if (c=='!'){
            flag = !flag;
        }else if (c=='&'){
            for (Character cc:list){
                flag &=map.get(cc);
            }
        }else {
            for (Character cc:list){
                flag |=map.get(cc);
            }
        }
        if (flag){
            return 't';
        }else {
            return 'f';
        }
    }

    public static void main(String[] args) {
        ParseBoolExpr parseBoolExpr = new ParseBoolExpr();
        boolean b = parseBoolExpr.parseBoolExpr("|(&(t,f,t),!(t))");
        System.out.println(b);
    }
}















