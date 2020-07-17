package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/30
 * Time: 9:03
 * Description: 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成
 *              （比如，waterbottle是erbottlewat旋转后的字符串）。
 */
public class IsFlipedString {
    public static boolean isFlipedString(String s1, String s2) {
        if (s1.equals(s2)){
            return true;
        }
        if (s1.length()!=s2.length()){
            return false;
        }
        for (int i=0;i<s2.length();i++){
            if (s1.charAt(0)==s2.charAt(i)){
                if (s1.startsWith(s2.substring(i))){
                    if (s1.substring(s1.length()-i).equals(s2.substring(0,i))){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean flipedString = isFlipedString("", "");
        System.out.println(flipedString);
    }
}
