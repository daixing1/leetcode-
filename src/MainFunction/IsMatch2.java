package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/5
 * Time: 8:43
 * Description: 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *              '.' 匹配任意单个字符
 *              '*' 匹配零个或多个前面的那一个元素
 *              所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *              说明:
 *                  s 可能为空，且只包含从 a-z 的小写字母。
 *                  p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 */
public class IsMatch2 {
    public static boolean isMatch(String s, String p) {

        if (s==null||s.length()==0||s.equals(p)){
            return true;
        }
        if (p==null||p.length()==0){
            return false;
        }
        if (p.contains(".*")){
            return true;
        }
        p = removeStars(p);
        int i=0,j=0;
        for (;i<s.length()&&j<p.length();){
            if (s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'){
                i++;
                j++;
                continue;
            }
            if (j+1<p.length()&&p.charAt(j+1)=='*'){
                if (s.charAt(i)!=p.charAt(j)){
                    return isMatch(s.substring(i),p.substring(j+2));
                }
                while (i+1<s.length()&&s.charAt(i+1)==s.charAt(i)){
                    i++;
                }
                while (j+2<p.length()&&s.charAt(i)==p.charAt(j+2)){
                    j++;
                }
                return isMatch(s.substring(i+1),p.substring(j+2));
            }
            return false;
        }
        if (i==s.length()-1&&j==p.length()-1){
            return true;
        }else {
            return false;
        }
    }

    public static String removeStars(String s){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='*'){
                while (i<s.length()&&s.charAt(i++)=='*'){

                }
                sb.append("*");
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        boolean aa = isMatch("aa", "a*");
        System.out.println(aa);
    }
}
