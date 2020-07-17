package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/30
 * Time: 22:46
 * Description: 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 */
public class ConvertToTitle {
    public static String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        int m = 0;
        while (n>26){
            m = n%26;
            n=n/26;
            res.insert(0,(char)('A'+m-1));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = convertToTitle(27);
        System.out.println(s);
    }
}
