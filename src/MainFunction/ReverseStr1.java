package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/24
 * Time: 16:50
 * Description: 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *              如果剩余字符少于 k 个，则将剩余字符全部反转。
 *              如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class ReverseStr1 {
    public String reverseStr(String s, int k) {
        if (s.length()<k){
            return reverse(s);
        }
        String res = "";
        int i=0;
        while (i<s.length()){
            if (i+k<=s.length()){
                res+=reverse(s.substring(i,i+k));
            }else {
                res+=reverse(s.substring(i,s.length()));
            }
            i+=k;
            if (i<s.length()){
                res+=s.substring(i,Math.min(s.length(),i+k));
            }
            i+=k;
        }
        return res;
    }

    private String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }

    public static void main(String[] args) {
        ReverseStr1 reverseStr1 = new ReverseStr1();
        String abcdefg = reverseStr1.reverseStr("abcdefg", 5);
        System.out.println(abcdefg);
    }
}
