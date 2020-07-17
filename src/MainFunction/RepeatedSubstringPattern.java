package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/25
 * Time: 9:08
 * Description: 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，
 *              并且长度不超过10000
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for(int i=1;i<s.length();i++){
            if(s.length()%i==0){
                if(judge(s.substring(0,i),s)) return true;
            }
        }
        return false;
    }
    public boolean judge(String sub, String S){
        int count = S.length()/sub.length();
        if (sub.repeat(count).equals(S)){
            return true;
        }else {
            return false;
        }
    }
}
