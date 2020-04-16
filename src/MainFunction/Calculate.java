package MainFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/2/26
 * Time: 0:39
 * Description: No Description
 */
public class Calculate {
    public static int calculate(String s) {
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        String d = "";
        for (int i=0;i<chars.length;i++){
            if ('*'==chars[i]){
                stack.push(d);
                d="";
                String pop = stack.pop();
                for (;i<chars.length;i++){
                    if (chars[i]>='0'&&chars[i]<='9'){
                        d+=String.valueOf(chars[i]);
                    }
                }
//                char c = chars[i + 1];
//                if (' '!=c){
                    stack.push(String.valueOf(Integer.valueOf(pop)*Integer.valueOf(String.valueOf(d))));
//                }
//                i++;
                continue;
            }
            if ('/'==chars[i]){
                stack.push(d);
                d="";
                String pop = stack.pop();
                for (;i<chars.length;i++){
                    if (chars[i]>='0'&&chars[i]<='9'){
                        d+=String.valueOf(chars[i]);
                    }
                }
//                char c = chars[i + 1];
//                if (' '!=c){
                    stack.push(String.valueOf(Integer.valueOf(pop)/Integer.valueOf(d)));
//                }
                continue;
            }
            if (' '==chars[i]){
                continue;
            }
            if (chars[i]>='0'&&chars[i]<='9'){
                d+=String.valueOf(chars[i]);
            }else {
                stack.push(d);
                d = String.valueOf(chars[i]);
                stack.push(d);
                d="";
            }
        }
        List<String> stringList = new ArrayList<>(stack);
        if (stringList.size()==1){
            return Integer.valueOf(stringList.get(0));
        }
        Integer res = 0;
        for (int i=0;i<stringList.size();i++){
            if ("+".equals(stringList.get(i))){
                res = Integer.valueOf(stringList.get(i-1))+Integer.valueOf(stringList.get(i+1));
                i++;
                continue;
            }
            if ("-".equals(stringList.get(i))){
                res = Integer.valueOf(stringList.get(i-1))-Integer.valueOf(stringList.get(i+1));
                i++;
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int calculate = calculate("1");
        System.out.println(calculate);
    }
}
