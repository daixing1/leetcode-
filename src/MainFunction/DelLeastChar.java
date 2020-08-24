package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/8/15
 * Time: 22:56
 * Description: 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。
 *              输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 *              注意每个输入文件有多组输入，即多个字符串用回车隔开
 */
public class DelLeastChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            int[][] count = new int[26][2];
            for (int i=0;i<26;i++){
                count[i][0] = i;
            }
            for (char c:s.toCharArray()){
                count[c-'a'][1]++;
            }
            Arrays.sort(count, Comparator.comparingInt(o -> o[1]));
            int min = 0;
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < 26; i++) {
                if (count[i][1]==0){
                    continue;
                }else {
                    if (min==0){
                        min = count[i][1];
                        set.add((char) ('a'+count[i][0]));
                    }else if (min==count[i][1]){
                        set.add((char) ('a'+count[i][0]));
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c:s.toCharArray()){
                if (!set.contains(c)){
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
