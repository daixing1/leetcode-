package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/5
 * Time: 9:57
 * Description: 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)!=' '){
                sb.append(s.charAt(i));
            }else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }
}
