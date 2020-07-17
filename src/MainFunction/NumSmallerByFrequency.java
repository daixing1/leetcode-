package MainFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/5/27
 * Time: 9:24
 * Description: 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  
 *              中（按字典序比较）最小字母的出现频次。
 *              例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 *              现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 
 *              作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 
 *              中的词
 */
public class NumSmallerByFrequency {
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        List<Integer> wf = new ArrayList<>();
        for (String s:words){
            wf.add(f(s));
        }
        Collections.sort(wf,(o1, o2) -> o2-o1);
        int index = 0;
        for (String s:queries){
            for (int i=0;i<wf.size();i++){
                if (wf.get(i)>f(s)){
                    res[index]++;
                }
            }
            index++;
        }
        return res;

    }

    public static int f(String s){
        int count = 0;
        char c = s.charAt(0);
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==c){
                count++;
            }
            if (s.charAt(i)<c){
                c = s.charAt(i);
                count=1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ints = numSmallerByFrequency(new String[]{"cbd"}, new String[]{"zaaaz"});
        System.out.println(ints);
    }
}
