package MainFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * User: 兴希
 * Date: 2020/8/11
 * Time: 22:04
 * Description: •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 *              •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class CutString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s=br.readLine())!=null){
            while (s.length()>8){
                System.out.println(s.substring(0,8));
                s = s.substring(8);
            }
            if (s.length()==8){
                System.out.println(s);
            }else {
                int l = 8-s.length();
                System.out.println(s+"0".repeat(l));
            }
        }
    }
}
