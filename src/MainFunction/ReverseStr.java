package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/10
 * Time: 9:29
 * Description: 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 *              如果剩余字符少于 k 个，则将剩余字符全部反转。
 *              如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class ReverseStr {
    public static String reverseStr(String s, int k) {
        int a = s.length()/(2*k);
        int b = s.length()%(2*k);
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<a;i++){
            sb.append(reverse(s.substring(i*2*k,i*2*k+k)));
            sb.append(s, i*2*k+k, (i+1)*2*k);
        }
        if (b<k){
            sb.append(reverse(s.substring(s.length()-b,s.length())));
        }else {
            sb.append(reverse(s.substring(s.length()-b,s.length()-b+k)));
            sb.append(s, s.length()-b+k, s.length());
        }
        return sb.toString();
    }

    public static String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = reverseStr("abcdefg", 4);
        System.out.println(s);
    }
}
