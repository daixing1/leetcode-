package MainFunction;

/**
 * User: 兴希
 * Date: 2020/8/15
 * Time: 22:02
 * Description: 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
 *              返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
 */
public class GenerateTheString {
    public String generateTheString(int n) {
        if ((n&1)==1){
            return "a".repeat(n);
        }else {
            return "a".repeat(n-1)+"b";
        }
    }
}
