package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/15
 * Time: 10:59
 * Description: 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，
 *              编写一个函数判定它们是否只需要一次(或者零次)编辑。
 */
public class OneEditAway {
    public static boolean oneEditAway(String first, String second) {
        if (first.equals(second)){
            return true;
        }
        if (Math.abs(first.length()-second.length())>1){
            return false;
        }
        int count = 0;
        for (int i=0,j=0;i<first.length()&&j<second.length();i++,j++){
            if (first.charAt(i)!=second.charAt(j)){
                count++;
                if (count>1){
                    return false;
                }
                if (first.length()==second.length()){
                    continue;
                }else if (first.length()<second.length()){
                    i--;
                }else {
                    j--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = oneEditAway("ab", "bc");
        System.out.println();
    }
}
