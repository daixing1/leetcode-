package MainFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/8/5
 * Time: 21:11
 * Description: 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。
 *              如果小数部分为循环小数，则将循环的部分括在括号内。
 */
public class FractionToDecimal {
    long integ = 0;
    Map<String, Integer> map = new HashMap<>();
    List<Long> list = new ArrayList<>();
    public String fractionToDecimal(int numerator, int denominator) {
        long num = (long)numerator;
        long den = (long)denominator;
        boolean flag = true;
        if (num*den<0){
            flag = false;
        }
        num = Math.abs(num);
        den = Math.abs(den);
        if (num%den==0){
            if (flag){
                return String.valueOf(num/den);
            }else {
                return "-"+String.valueOf(num/den);
            }
        }
        if (num>den){
            integ = num/den;
        }
        long n = num % den;
        if (flag){
            return integ+"."+getResult(n*10,den);
        }else {
            return "-"+integ+"."+getResult(n*10,den);
        }
    }

    private String getResult(long numerator, long denominator){
        long m = numerator / denominator;
        long n = numerator % denominator;
        String key = m+"#"+n;
        if (map.containsKey(key)){
            Integer integer = map.get(key);
            String res = "";
            for (int i=0;i<list.size();i++){
                if (i==integer){
                    res+="("+list.get(i);
                }else {
                    res+=list.get(i);
                }
            }
            return res+")";
        }else {
            map.put(key,list.size());
            list.add(m);
            if (n==0){
                String res = "";
                for (int i=0;i<list.size();i++){
                    res+=list.get(i);
                }
                return res;
            }else {
                return getResult(n*10,denominator);
            }
        }
    }

    public static void main(String[] args) {
        FractionToDecimal fractionToDecimal = new FractionToDecimal();
        String s = fractionToDecimal.fractionToDecimal(-2147483648
                ,-10);
        System.out.println(s);
    }
}
