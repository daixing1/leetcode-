package MainFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/8/22
 * Time: 22:18
 * Description: 对字符串中的所有单词进行倒排。
 *              说明：
 *                  1、构成单词的字符只有26个大写或小写英文字母；
 *                  2、非构成单词的字符均视为单词间隔符；
 *                  3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，
 *                  倒排转换后也只允许出现一个空格间隔符；
 *                  4、每个单词最长20个字母；
 */
public class ReverseSentence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line=br.readLine())!=null){
            List<String> list = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.toCharArray().length; i++) {
                char c = line.charAt(i);
                int j = i;

                while (j<line.length()-1&&((c>='A'&&c<='Z')||(c>='a'&&c<='z'))){
                    sb.append(c);
                    j++;
                    c = line.charAt(j);
                }
                if (j<line.length()&&((c>='A'&&c<='Z')||(c>='a'&&c<='z'))){
                    sb.append(c);
                }
                list.add(sb.toString());
                i = j;
            }

            for (int i = list.size()-1; i >= 0 ; i--) {
                if (i==0){
                    System.out.println(list.get(i));
                }else {
                    System.out.print(list.get(i)+" ");
                }
            }
        }

    }
}
