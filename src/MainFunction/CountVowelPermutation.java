package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/6/11
 * Time: 14:59
 * Description: 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 *              字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 *              每个元音 'a' 后面都只能跟着 'e'
 *              每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 *              每个元音 'i' 后面 不能 再跟着另一个 'i'
 *              每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 *              每个元音 'u' 后面只能跟着 'a'
 *              由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 */
public class CountVowelPermutation {
    int count = 0;
    public int countVowelPermutation(int n) {
        dfs(n,new String[]{"a","e","i","o","u"},new ArrayList<>());
        return count;
    }

    public void dfs(int n, String[] chars, List<String> list){
        if (list.size()==n){
            count++;
            return;
        }
        for (int i=0;i<chars.length;i++){
            if (list.isEmpty()){
                list.add(chars[i]);
            }else {
                String s = list.get(list.size() - 1);
                if ("a".equals(s)&&"e".equals(chars[i])){
                    list.add(chars[i]);
                }else if ("e".equals(s)&&("a".equals(chars[i])||"i".equals(chars[i]))){
                    list.add(chars[i]);
                }else if ("i".equals(s)&&!"i".equals(chars[i])){
                    list.add(chars[i]);
                }else if ("o".equals(s)&&("i".equals(chars[i])||"u".equals(chars[i]))){
                    list.add(chars[i]);
                }else if ("u".equals(s)&&"a".equals(chars[i])){
                    list.add(chars[i]);
                }else {
                    continue;
                }
            }
            dfs(n,chars,list);
            list.remove(list.size()-1);
        }
    }

    //上面方法超时
    public int countVowelPermutation1(int n) {
        //0->a,1->e,2->i,3->o,4->u
        long[][] dp = new long[n][5];
        for (int i=0;i<5;i++){
            dp[0][i] = 1;
        }
        int mod = (int)Math.pow(10,9)+7;
        for (int i=1;i<n;i++){
            dp[i][0] = (dp[i-1][1]+dp[i-1][2]+dp[i-1][4])%mod;
            dp[i][1] = (dp[i-1][0]+dp[i-1][2])%mod;
            dp[i][2] = (dp[i-1][1]+dp[i-1][3])%mod;
            dp[i][3] = dp[i-1][2];
            dp[i][4] = (dp[i-1][2]+dp[i-1][3])%mod;
        }
        long count = 0;
        for (int i=0;i<5;i++){
            count = (count+dp[n-1][i])%mod;
        }
        return (int)count;
    }

    public static void main(String[] args) {
        CountVowelPermutation c = new CountVowelPermutation();
        int i = c.countVowelPermutation1(144);
        System.out.println(i);
    }
}
