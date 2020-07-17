package MainFunction;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/6/25
 * Time: 11:20
 * Description: 「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的
 *              字符实体。
 *              HTML 里这些特殊字符和它们对应的字符实体包括：
 *                  双引号：字符实体为 &quot; ，对应的字符是 " 。
 *                  单引号：字符实体为 &apos; ，对应的字符是 ' 。
 *                  与符号：字符实体为 &amp; ，对应对的字符是 & 。
 *                  大于号：字符实体为 &gt; ，对应的字符是 > 。
 *                  小于号：字符实体为 &lt; ，对应的字符是 < 。
 *                  斜线号：字符实体为 &frasl; ，对应的字符是 / 。
 *              给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。
 */
public class EntityParser {
    public static String entityParser(String text) {
        Map<String,String> map = new HashMap<>();
        map.put("&quot;","\"");
        map.put("&apos;","\'");
        map.put("&amp;","&");
        map.put("&gt;",">");
        map.put("&lt;","<");
        map.put("&frasl;","/");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<text.length();i++){
            if (text.charAt(i)=='&'){
                int j = i;
                while (j<text.length()&&text.charAt(j)!=';'&&j-i<=6){
                    j++;
                }
//                if (j==text.length()||j-i>6){
//                    i--;
//                    continue;
//                }
                if (text.charAt(j)==';'&&map.containsKey(text.substring(i,j+1))){
                    sb.append(map.get(text.substring(i,j+1)));
                    i = j;
                }else {
                    sb.append(text, i, j+1);
                    i = j;
                }
                continue;
            }
            if (i<text.length()){
                sb.append(text.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = entityParser("x &gt; y &amp;&amp; x &lt; y is always false");
        System.out.println(s);
    }
}
