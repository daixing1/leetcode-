package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/7/16
 * Time: 21:21
 * Description: 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用
 *              补码运算 方法。
 *              注意:
 *                  十六进制中所有字母(a-f)都必须是小写。
 *                  十六进制字符串中不能包含多余的前导零。如果要转化的数为0，
 *                  那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。
 *                  给定的数确保在32位有符号整数范围内。
 *                  不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 */
public class ToHex {
    public String toHex(int num) {
        String res = "";
        Map<Integer, String> map = new HashMap<>();
        map.put(10,"a");
        map.put(11,"b");
        map.put(12,"c");
        map.put(13,"d");
        map.put(14,"e");
        map.put(15,"f");
        int n = Math.abs(num);
        int m = 0;
        while (n>15){
            m = n%16;
            n = n/16;
            if (m>9){
                res+=map.get(m);
            }else {
                res+=m;
            }
        }
        res+=n>9?map.get(n):n;
        if (num>=0){
            return new StringBuilder(res).reverse().toString();
        }
        return getComplement(res);
    }

    private String getComplement(String s){
        String res = "";
        Map<String, String> map = new HashMap<>();
        map.put("a","5");
        map.put("b","4");
        map.put("c","3");
        map.put("d","2");
        map.put("e","1");
        map.put("f","0");
        map.put("1","e");
        map.put("2","d");
        map.put("3","c");
        map.put("4","b");
        map.put("5","a");
        map.put("6","9");
        map.put("7","8");
        map.put("8","7");
        map.put("9","6");
        map.put("0","f");
        for (int i=0;i<8;i++){
            if (s.length()!=0){
                String substring = s.substring(s.length() - 1);
                res+=map.get(s.substring(s.length()-1));
                s = s.substring(0,s.length()-1);
            }else {
                res+="f";
            }
        }
        if (res.charAt(0)!='f'){
            char c = (char) (res.charAt(0)+1);
            res = c+res.substring(1);
            return new StringBuilder(res).reverse().toString();
        }
        String ss = "";
        for (int i=0;i<res.length();i++){
            if (res.charAt(i)=='f'){
                ss+="0";
            }else {
                char c = (char) (res.charAt(i)+1);
                ss+=c;
                ss+=res.substring(i+1);
                break;
            }
        }
        return new StringBuilder(ss).reverse().toString();
    }

        public String toHex1(int num) {
            if(num == 0 ){
                return "0";
            }
            String hex="0123456789abcdef";
            String ans = "";

            while(num!=0 && ans.length() < 8){
                ans = hex.charAt(num & 15) + ans ;
                num >>= 4;
            }
            return ans;
        }



    public static void main(String[] args) {
        ToHex toHex = new ToHex();
        String s = toHex.toHex1(-1);
        System.out.println(s);
    }
}
