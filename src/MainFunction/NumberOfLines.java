package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/3
 * Time: 12:19
 * Description: 我们要把给定的字符串 S 从左到右写到每一行上，每一行的最大宽度为100个单位，
 *              如果我们在写某个字母的时候会使这行超过了100 个单位，那么我们应该把这个字母写到下一行。
 *              我们给定了一个数组 widths ，这个数组 widths[0] 代表 'a' 需要的单位， widths[1]
 *              代表 'b' 需要的单位，...， widths[25] 代表 'z' 需要的单位。
 *              现在回答两个问题：至少多少行能放下S，以及最后一行使用的宽度是多少个单位？
 *              将你的答案作为长度为2的整数列表返回。
 */
public class NumberOfLines {
    public int[] numberOfLines(int[] widths, String S) {
        char[] chars = S.toCharArray();
        int row = 0;
        int col = 0;
        for (char c:chars){
            if (col+widths[c-'a']>100){
                col = widths[c-'a'];
                row++;
            }else {
                col += widths[c-'a'];
            }
        }
        return new int[]{row,col};
    }
}
