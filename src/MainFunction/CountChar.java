package MainFunction;

import java.util.Scanner;

/**
 * User: 兴希
 * Date: 2020/8/11
 * Time: 21:57
 * Description: 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 */
public class CountChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String c = scanner.next();
        int count = 0;
        for (int i=0;i<s.length();i++){
            if (c.toLowerCase().equals(s.substring(i,i+1).toLowerCase())){
                count++;
            }
        }
        System.out.println(count);
    }
}
