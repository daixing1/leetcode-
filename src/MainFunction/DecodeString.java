package MainFunction;

import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/5/28
 * Time: 8:34
 * Description: 给定一个经过编码的字符串，返回它解码后的字符串。
 *              编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
 *              注意 k 保证为正整数。
 *              你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *              此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 
 *              的输入
 */
public class DecodeString {
    public static String decodeString(String s) {
        if (s==null||s.length()==0){
            return "";
        }
        int count = 0;
        String res = "";
        String tmp = "";
        Stack<String> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                int[] digita = getDigita(s, i);
                count = digita[0];
                i = digita[1];
                continue;
            }
            if (s.charAt(i)=='['){
                stack.push(tmp);
                stack.push(""+count);
                stack.push("[");
                tmp = "";
                continue;
            }
            if (s.charAt(i)==']'){
                String pop = stack.pop();
                while (!"[".equals(pop)){
                    tmp = pop+tmp;
                    pop = stack.pop();
                }
                pop = stack.pop();
                res = tmp.repeat(Integer.valueOf(pop));
                stack.push(res);
                tmp = "";
                continue;
            }
            tmp+=String.valueOf(s.charAt(i));
        }
        res = "";
        for (String ss:stack){
            res+=ss;
        }
        return res+tmp;
    }

    public static int[] getDigita(String s, int index){
        int res = 0;
        for (int i=index;i<s.length();i++){
            if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                res = res*10+Integer.valueOf(String.valueOf(s.charAt(i)));
            }else {
                index = i-1;
                break;
            }
        }
        return new int[]{res,index};
    }

    public static void main(String[] args) {
        String s = decodeString("100[leetcode]");
        System.out.println(s);
    }
}
