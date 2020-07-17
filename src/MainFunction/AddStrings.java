package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/6
 * Time: 10:31
 * Description: 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *              注意：
 *                  num1 和num2 的长度都小于 5100.
 *                  num1 和num2 都只包含数字 0-9.
 *                  num1 和num2 都不包含任何前导零。
 *                  你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class AddStrings {
    public static String addStrings(String num1, String num2) {
        int count = 0;
        if (num1.length()*num2.length()==0){
            return num1.length()==0?num2:num1;
        }
        if (num1.length()>num2.length()){
            return addStrings(num2,num1);
        }
        StringBuilder sb = new StringBuilder();
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for (int i=0;i<Math.min(num1.length(),num2.length());i++){
            Integer n1 = Integer.valueOf(num1.substring(i, i + 1));
            Integer n2 = Integer.valueOf(num2.substring(i, i + 1));
            if (n1+n2+count<10){
                sb.append(n1+n2+count);
                count = 0;
            }else {
                sb.append((n1+n2+count)%10);
                count = 1;
            }
        }
        for (int i=num1.length();i<num2.length();i++){
            if (Integer.valueOf(num2.substring(i, i + 1))+count<10){
                sb.append(Integer.valueOf(num2.substring(i, i + 1))+count);
                count = 0;
            }else {
                sb.append((Integer.valueOf(num2.substring(i, i + 1))+count)%10);
                count = 1;
            }
        }
        if (count==1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = addStrings("98", "9");
        System.out.println(s);
    }
}
