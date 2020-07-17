package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/31
 * Time: 11:00
 * Description: 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *              比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：/
 *                  L   C   I   R
 *                  E T O E S I I G
 *                  E   D   H   N
 *              之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 */
public class Convert {

    public static String convert(String s, int numRows) {
        int length = s.length();
        char[][] chars = new char[numRows][length*(numRows-1)/numRows+1];
        int count = 0;
        int i=0;
        int j=0;
        boolean down = true;
        while (count<length){
            if (down){
                if (i<numRows){
                    chars[i][j] = s.charAt(count++);
                    i++;
                }
                if (i>=numRows){
                    down = false;
                    i--;
                    j++;
                    i--;
                }
            }else {
                if (i>=0){
                    chars[i][j] = s.charAt(count++);
                    i--;
                    j++;
                }
                if (i<0){
                    down = true;
                    i++;
                    j--;
                    i++;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (char[] chs:chars){
            for (char c:chs){
                if (c!='\u0000'){
                    res.append(c);
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {

        System.out.println(convert("ABC",2));
    }
}
