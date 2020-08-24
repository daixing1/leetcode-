package MainFunction;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/8/13
 * Time: 22:22
 * Description: 输入一个字符串，求出该字符串包含的字符集合
 *              输入描述:
 *                  每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 *              输出描述:
 *                  每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 */
public class Distinct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            distinct(s);
        }
    }

    private static void distinct(String s){
        Set<Character> set = new HashSet<>();
        StringBuilder distinct = new StringBuilder();
        for (char c:s.toCharArray()){
            if (!set.contains(c)){
                set.add(c);
                distinct.append(c);
            }
        }
        System.out.println(distinct.toString());
    }
}
