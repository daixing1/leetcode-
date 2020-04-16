package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/3
 * Time: 8:30
 * Description: 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *              如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 *              假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 *              该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 *              注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 *              在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *              提示：
 *                  本题中的空白字符只包括空格字符 ' ' 。
 *                  假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
 *                  如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */
public class MyAtoi {
    public static int myAtoi(String str) {
        long res = 0;
        boolean flag = true;
        char[] chars = str.trim().toCharArray();
        if(chars.length<1){
            return 0;
        }
        if (chars.length>=2){
            if (chars[0]=='+'&&chars[1]>='0'&&chars[1]<='9'){
                flag = true;
            }else if (chars[0]=='-'&&chars[1]>='0'&&chars[1]<='9'){
                flag = false;
            }else if (chars[0]>'9'||chars[0]<'0'){
                return (int)res;
            }
        }
        for (int i=0;i<chars.length;i++){
            if (chars[i]<='9'&&chars[i]>='0'){
                res = res*10 + (int)Integer.valueOf(String.valueOf(chars[i]));
            }
            if (flag&&res>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if (!flag&&-res<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            if (i>0&&(chars[i]>'9'||chars[i]<'0')){
                break;
            }
        }
        if (!flag){
            res = 0-res;
        }
//        if (res>Math.pow(2,31)-1){
//            return (int)Math.pow(2,31);
//        }
//        if (res<-Math.pow(2,31)){
//            return (int)-Math.pow(2,31);
//        }
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        int i = myAtoi("   -42");
        System.out.println(i);
    }
}
