package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/4/9
 * Time: 10:05
 * Description: No Description
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

    public static void main(String[] args) {
        List<String> stringList = generateParenthesis(3);
        System.out.println(stringList);
    }
}
