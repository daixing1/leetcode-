package MainFunction;

/**
 * User: 兴希
 * Date: 2020/2/26
 * Time: 11:34
 * Description: 编写一个函数来查找字符串数组中的最长公共前缀。
 *              如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String ref = "";
        boolean flag = true;
        for (int i=0;i<strs[0].length();i++){
            ref+=strs[0].substring(i,i+1);
            for (int j=1;j<strs.length;j++){
                if (!strs[j].startsWith(ref)){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                break;
            }
        }
        if (ref.length()!=0&&!flag){
            ref = ref.substring(0,ref.length()-1);
        }
        return ref;
    }

    public static void main(String[] args) {
        String s = longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(s);
    }
}
