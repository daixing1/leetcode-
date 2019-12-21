package MainFunction;

/**
 * User: 兴希
 * Date: 2019/12/21
 * Time: 20:11
 * Description: No Description
 */
public class DiStringMatch {
    public int[] diStringMatch(String S) {
        char[] chars = S.toCharArray();
        int[] result = new int[chars.length+1];
        int m = chars.length;
        int n = 0;
        if (chars[0]=='D'){
            result[0] = chars.length;
            m--;
        }else {
            result[0] = 0;
            n++;
        }
        for (int i=1;i<chars.length;i++){
            if (chars[i]=='D'&&chars[i]==chars[i-1]){
                result[i] = m;
                m--;
            }else if (chars[i]=='D'&&chars[i]!=chars[i-1]){
                result[i] = m;
                m--;
            }else if (chars[i]=='I'&&chars[i]!=chars[i-1]){
                result[i] = n;
                n++;
            }else {
                result[i] = n;
                n++;
            }
        }
        result[chars.length] = m;
        return result;
    }
}
