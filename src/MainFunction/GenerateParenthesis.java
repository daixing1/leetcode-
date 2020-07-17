package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/4/9
 * Time: 10:05
 * Description: 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] tmp = new char[2*n];
        generateAll(tmp,0,res);
        return res;
    }

    public static void generateAll(char[] tmp, int pos, List<String> res){
        if (tmp.length==pos){
            if (valid(tmp)){
                res.add(String.valueOf(tmp));
            }
            return;
        }
        tmp[pos] = '(';
        generateAll(tmp,pos+1,res);
        tmp[pos] = ')';
        generateAll(tmp,pos+1,res);
    }

    public static boolean valid(char[] tmp){
        int balance = 0;
        for (int i=0;i<tmp.length;i++){
            if ('('==tmp[i]){
                balance++;
            }else {
                balance--;
            }
            if (balance<0){
                return false;
            }
        }
        if (balance==0){
            return true;
        }else {
            return false;
        }
    }

    List<String> list;
    public List<String> generateParenthesis1(int n) {
        list = new ArrayList<>();
        generate(n,n,new StringBuilder());
        return list;
    }

    private void generate(int left, int right, StringBuilder s){
        if (right==left&&left==0){
            list.add(s.toString());
            s.deleteCharAt(s.length()-1);
            return;
        }
        if (left==right&&left>0){
            generate(left-1,right,s.append("("));
        }else {
            if (left==0&&right>0){
                generate(left,right-1,s.append(")"));
            }else{
                generate(left-1,right,s.append("("));
                generate(left,right-1,s.append(")"));
            }
        }
        if (s.length()!=0){
            s.deleteCharAt(s.length()-1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> stringList = generateParenthesis.generateParenthesis1(3);
        System.out.println(stringList);
    }
}
