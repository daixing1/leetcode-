package MainFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * User: 兴希
 * Date: 2020/2/26
 * Time: 0:39
 * Description: 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *              字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 */
public class Calculate {
    public static int calculate(String s) {
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        int d = 0;
        for (int i=0;i<chars.length;i++){
            if ('*'==chars[i]){
                d = getNextDigita(s, i + 1);
                String pop = stack.pop();
                stack.push(String.valueOf(Integer.valueOf(pop)*d));
                i++;

                continue;
            }
            if ('/'==chars[i]){
                d = getNextDigita(s, i + 1);
                String pop = stack.pop();
                stack.push(String.valueOf(Integer.valueOf(pop)/d));
                i++;
                continue;
            }
            if (' '==chars[i]){
                continue;
            }
//            String ds = "";
            if (chars[i]>='0'&&chars[i]<='9'){
                String ds = "";
                int j = i;
                for (j=i;j<s.length();j++){
                    if (s.charAt(j)>='0'&&s.charAt(j)<='9'){
                        ds+=String.valueOf(s.charAt(j));
                    }else {
                        break;
                    }
                }
                stack.push(ds);
                if (j>=s.length()){
                    i = j;
                }else {
                    i = j-1;
                }
            }else {
                stack.push(String.valueOf(chars[i]));
            }
        }
        List<String> stringList = new ArrayList<>(stack);
        if (stringList.size()==1){
            return Integer.valueOf(stringList.get(0));
        }
        Integer res = Integer.valueOf(stringList.get(0));
        for (int i=1;i<stringList.size();i++){
            if ("+".equals(stringList.get(i))){
                res +=Integer.valueOf(stringList.get(i+1));
                i++;
                continue;
            }
            if ("-".equals(stringList.get(i))){
                res -=Integer.valueOf(stringList.get(i+1));
                i++;
                continue;
            }
        }
        return res;
    }

    private static int getNextDigita(String s,int index){
        String d = "";
        for (int i=index;i<s.length();i++){
            if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                d+=String.valueOf(s.charAt(i));
            }else if (' '==s.charAt(i)){
                continue;
            }else {
                break;
            }
        }
        return Integer.valueOf(d);
    }

    public static void main(String[] args) {
        int calculate = calculate("0-2147483647");
        System.out.println(calculate);
    }
}
