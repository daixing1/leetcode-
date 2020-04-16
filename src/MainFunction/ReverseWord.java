package MainFunction;

/**
 * User: 兴希
 * Date: 2020/2/26
 * Time: 23:26
 * Description: 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class ReverseWord {
    public String reverseWords(String s) {
        if (s==null||"".equals(s)){
            return "";
        }
        String[] split = s.split(" ");
        String res = "";
        for (int i=0;i<split.length;i++){
            res +=" " + reverse(split[i]);
        }
        return res.substring(1);
    }

    public String reverse(String s){
        char[] chars = s.toCharArray();
        String res = "";
        for (int i=chars.length;i>0;i--){
            res+=chars[i-1];
        }
        return res;
    }
}
