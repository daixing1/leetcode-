package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/14
 * Time: 10:28
 * Description: 给定两个字符串 s 和 t，它们只包含小写字母。
 *              字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *              请找出在 t 中被添加的字母
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] chars = t.toCharArray();
        for (char c:chars){
            if (s.contains(String.valueOf(c))){
                s = s.substring(0,s.indexOf(String.valueOf(c)))+s.substring(s.indexOf(String.valueOf(c))+1,s.length());
            } else{
                return c;
            }
        }
        return 'a';
    }
}
