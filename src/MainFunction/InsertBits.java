package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/8
 * Time: 9:15
 * Description: 插入。给定两个32位的整数N与M，以及表示比特位置的i与j。编写一种方法，将M插入N，使得M从N的第j位开始，
 *              到第i位结束。假定从j位到i位足以容纳M，也即若M = 10 011，那么j和i之间至少可容纳5个位。例如，
 *              不可能出现j = 3和i = 2的情况，因为第3位和第2位之间放不下M。
 */
public class InsertBits {
    public int insertBits(int N, int M, int i, int j) {
        StringBuilder s1 = new StringBuilder(String.valueOf(N));
        s1 = s1.reverse();
        StringBuilder s2 = new StringBuilder(String.valueOf(M));
        s2 = s2.reverse();
        for (int k=0;;k++){
            if (k>j){
                break;
            }
            if (k>=i&&k<=j){
                if (k<s1.length()){
                    s1.replace(k,k+1,String.valueOf(s2.charAt(k-i)));
                }else {
                    s1.append("0".repeat(k-s1.length())).append(s2.charAt(k-i));
                }
            }
        }
        Integer integer = Integer.valueOf(s1.reverse().toString());
        return integer;
    }
}
