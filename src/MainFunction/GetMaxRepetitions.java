package MainFunction;

/**
 * User: 兴希
 * Date: 2019/12/26
 * Time: 20:03
 * Description: 定义由 n 个连接的字符串 s 组成字符串 S，即 S = [s,n]。例如，["abc", 3]=“abcabcabc”。
 *              另一方面，如果我们可以从 s2 中删除某些字符使其变为 s1，我们称字符串 s1 可以从字符串 s2 获得。
 *              例如，“abc” 可以根据我们的定义从 “abdbec” 获得，但不能从 “acbbe” 获得。
 *              现在给出两个非空字符串 S1 和 S2（每个最多 100 个字符长）和两个整数 0 ≤ N1 ≤ 106 和
 *              1 ≤ N2 ≤ 106。现在考虑字符串 S1 和 S2，其中S1=[s1,n1]和S2=[s2,n2]。
 *              找出可以使[S2,M]从 S1 获得的最大整数 M。
 *              示例：
 *                  输入：
 *                      s1 ="acb",n1 = 4
 *                      s2 ="ab",n2 = 2
 *                  返回：
 *                      2
 */
public class GetMaxRepetitions {
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        String S1 = s1.repeat(n1);
        String S2 = s2.repeat(n2);
        char[] chars1 = S1.toCharArray();
        char[] chars2 = S2.toCharArray();
        int count = 0;
        int j=0;
        for (int i=0;i<chars1.length;i++){
            while (j<chars2.length) {
                if (chars1[i]==chars2[j]){
                    j++;
                }
                if (j==chars2.length){
                    j=0;
                    count++;
                }
                break;
            }
            if (i==chars1.length-1){
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int maxRepetitions = getMaxRepetitions("abc", 4, "ab", 2);
        System.out.println(maxRepetitions);
    }
}
