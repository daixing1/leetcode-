package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/2
 * Time: 10:56
 * Description: 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *              '?' 可以匹配任何单个字符。
 *              '*' 可以匹配任意字符串（包括空字符串）。
 *              两个字符串完全匹配才算匹配成功。
 *              说明:
 *                  s 可能为空，且只包含从 a-z 的小写字母。
 *                  p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 */
public class isMatch {
    public static boolean isMatch(String s, String p) {
        if (p==null||s==null||p.length()==0||s.length()==0){
            return false;
        }
        p = removeStars(p);
        if (s.equals(p)||"?".equals(p)){
            return true;
        }
        Integer p_tmp=null, s_tmp=null ;
        int count = 0;
        int i,j;
        for ( i=0,j=0;i<s.length()&&j<p.length();) {
            if (s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }else if (p.charAt(j)=='?'){
                i++;
                j++;
            }else if (p.charAt(j)=='*'){
                p_tmp = j;
                s_tmp = i;
                j++;
                i = i+count;
                count++;
            }else {
                if (p_tmp!=null){
                    i = s_tmp+count;
                    j = p_tmp+1;
                }else {
                    return false;
                }
            }
        }
        if (i==s.length()&&j==p.length()){
            return true;
        }else {
            return false;
        }

    }

    public static String removeStars(String s){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='*'){
                while (i<s.length()&&s.charAt(i)=='*'){
                    i++;
                }
                sb.append("*");
                if (i>=s.length()){
                    return sb.toString();
                }
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        isMatch("","");
    }


}
