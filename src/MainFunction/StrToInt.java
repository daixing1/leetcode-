package MainFunction;

/**
 * User: 兴希
 * Date: 2020/3/6
 * Time: 23:04
 * Description: 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 *              数值为0或者字符串不是一个合法的数值则返回0
 */
public class StrToInt {
    public static int strToInt(String str) {
        char[] chars = str.toCharArray();
        double n = 0L;
        for (int i=0;i<chars.length;i++){
            if (chars[i]!='+'&&chars[i]!='-'&&(chars[i]>'9'||chars[i]<'0')){
                n = 0L;
                break;
            }
            if (chars[i]<='9'&&chars[i]>='0'){
                n+=((chars[i]-'0')*Math.pow(10,chars.length-i-1));
            }
        }
        if (str.contains("-")){
            n = -n;
        }
        return (int) n;
    }

    public static void main(String[] args) {
        double i = strToInt("-2147483646");
        Integer integer = Integer.valueOf("5e2");
        System.out.println(Integer.MAX_VALUE+"------"+Integer.MIN_VALUE);
    }
}
