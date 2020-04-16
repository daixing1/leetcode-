package MainFunction;

import java.util.Collections;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/2/25
 * Time: 10:10
 * Description: No Description
 */
public class RepeatedStringMatch {
    public static int repeatedStringMatch(String A, String B) {
        Integer length = (int)Math.ceil(Double.valueOf(B.length())/A.length());
        Integer n = 0;
        for (int i=length;i<length+1;i++){
            if (String.join("",Collections.nCopies(i,A)).contains(B)){
                n=i;
                break;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int i = repeatedStringMatch("aa", "a");
        System.out.println(i);
    }
}
