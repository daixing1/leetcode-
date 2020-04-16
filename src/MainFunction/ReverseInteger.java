package MainFunction;

/**
 * User: 兴希
 * Date: 2020/2/26
 * Time: 11:03
 * Description: 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class ReverseInteger {
    public int reverse(int x) {
        String s = String.valueOf(x);
        int res = 0;
        try {
            if ("-".equals(s.substring(0,1))){
                s = s.substring(1);
                res = -Integer.valueOf(reverseString(s));
            }else {
                res = Integer.valueOf(reverseString(s));
            }
        }catch (NumberFormatException e){
            return res;
        }

        return res;
    }

    public String reverseString(String s){
        String res = "";
        char[] chars = s.toCharArray();
        for (int i=chars.length;i>0;i--){
            res+=String.valueOf(chars[i-1]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(String.valueOf(-123));
    }
}
