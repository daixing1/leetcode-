package MainFunction;

import java.util.Scanner;

/**
 * User: 兴希
 * Date: 2020/8/11
 * Time: 21:54
 * Description: 计算字符串最后一个单词的长度，单词以空格隔开。
 */
public class LenOfString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        System.out.println(split[split.length-1].length());
    }
}
