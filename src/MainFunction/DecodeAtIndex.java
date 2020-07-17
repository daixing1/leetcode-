package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/30
 * Time: 11:05
 * Description: 给定一个编码字符串 S。为了找出解码字符串并将其写入磁带，从编码字符串中每次读取一个字符，
 *              并采取以下步骤：
 *                  如果所读的字符是字母，则将该字母写在磁带上。
 *                  如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
 *              现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
 */
public class DecodeAtIndex {
    public static String decodeAtIndex(String S, int K) {
        char[] chars = S.toCharArray();
        int len = 0;
        for (char c:chars){
            if (c>='0'&&c<='9'){
                len*=Integer.valueOf(String.valueOf(c));
            }else {
                len+=1;
            }
        }
        for (int i= chars.length-1;i>=0;i--){
            K%=len;
            if (Character.isLetter(chars[i])&&K==0){
                return ""+chars[i];
            }
            if (Character.isDigit(chars[i])){
                len/=chars[i]-'0';
            }else {
                len--;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String leet2code3 = decodeAtIndex("a2345678999999999999999",1);
        System.out.println(leet2code3);
    }
}
