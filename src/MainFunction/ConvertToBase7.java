package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/6
 * Time: 22:12
 * Description: 给定一个整数，将其转化为7进制，并以字符串形式输出。
 */
public class ConvertToBase7 {
    public String convertToBase7(int num) {
        StringBuilder res = new StringBuilder();
        int n = Math.abs(num);
        while (n>=7){
            res.insert(0,String.valueOf(n%7));
            n /= 7;
        }
        res.insert(0,String.valueOf(n));
        if (num<0){
            res.insert(0,"-");
        }
        return res.toString();
    }
}
