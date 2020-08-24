package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/22
 * Time: 10:36
 * Description: 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 */
public class IsInterleave {
    public static boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        int i=0,j=0,k=0;
        boolean right = isRight(i, j, k, c1, c2, c3);
        return right;
    }

    public static boolean isRight(int i,int j,int k,char[] c1,char[] c2,char[] c3){

        if (i == c1.length && j == c2.length && k == c3.length) {
            return true;
        }
        if (i<c1.length&&j<c2.length&&k<c3.length&&c1[i] == c2[j] && c1[i] == c3[k]) {
            return isRight(i+1, j, k+1, c1, c2, c3) || isRight(i, j+1, k+1, c1, c2, c3);
        }
        if (i<c1.length&&k<c3.length&&c1[i] == c3[k]) {
            return isRight(i+1, j, k+1, c1, c2, c3);
        } else if (j<c2.length&&k<c3.length&&c2[j] == c3[k]) {
            return isRight(i, j+1, k+1, c1, c2, c3);
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        boolean interleave = isInterleave("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(interleave);
    }
}
