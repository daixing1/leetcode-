package MainFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/8/11
 * Time: 22:14
 * Description: 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 */
public class HexToTen {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine())!=null){
            change(s.substring(2));
        }
    }

    private static void change(String s){
        Map<Character, Integer> map = new HashMap<>();
        map.put('A',10);
        map.put('B',11);
        map.put('C',12);
        map.put('D',13);
        map.put('E',14);
        map.put('F',15);
        long num = 0;
        for (int i=s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if (c>'9'){
                Integer integer = map.get(c);
                num+=Math.pow(16,s.length()-1-i)*integer;
            }else {
                Integer integer = c-'0';
                num+=Math.pow(16,s.length()-1-i)*integer;
            }
        }
        System.out.println(String.valueOf(num));
    }
}
