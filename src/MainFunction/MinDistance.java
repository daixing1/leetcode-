package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/6
 * Time: 9:36
 * Description: 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *              你可以对一个单词进行如下三种操作:
 *                  插入一个字符
 *                  删除一个字符
 *                  替换一个字符
 */
public class MinDistance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (m*n==0){
            return m+n;
        }
        int[][] d = new int[m+1][n+1];
        for (int i=0;i<m+1;i++){
            d[i][0] = i;
        }
        for (int i=0;i<n+1;i++){
            d[0][i] = i;
        }
        for (int i=1;i<m+1;i++){
            for (int j=1;j<n+1;j++){
                int left = d[i][j-1]+1;
                int up = d[i-1][j]+1;
                int leftUp = d[i-1][j-1];
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    d[i][j] = Math.min(Math.min(left,up),leftUp);
                }else {
                    d[i][j] = Math.min(Math.min(left,up),leftUp+1);
                }
            }
        }
        return d[m][n];
    }

    public static void main(String[] args) {
        int i = minDistance("horse", "ros");
        System.out.println(i);
    }
}
