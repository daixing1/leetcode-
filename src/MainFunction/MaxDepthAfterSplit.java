package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/4/1
 * Time: 9:06
 * Description: 有效括号字符串 仅由 "(" 和 ")" 构成，并符合下述几个条件之一：
 *                  空字符串
 *                  连接，可以记作 AB（A 与 B 连接），其中 A 和 B 都是有效括号字符串
 *                  嵌套，可以记作 (A)，其中 A 是有效括号字符串
 *                  类似地，我们可以定义任意有效括号字符串 s 的 嵌套深度 depth(S)：
 *              s 为空时，depth("") = 0
 *              s 为 A 与 B 连接时，depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是有效括号字符串
 *              s 为嵌套情况，depth("(" + A + ")") = 1 + depth(A)，其中 A 是有效括号字符串
 *              例如：""，"()()"，和 "()(()())" 都是有效括号字符串，嵌套深度分别为 0，1，2，而 ")(" 和 "(()" 
 *              都不是有效括号字符串。
 *              给你一个有效括号字符串 seq，将其分成两个不相交的子序列 A 和 B，且 A 和 B 满足有效括号字符串的定义
 *              （注意：A.length + B.length = seq.length）。
 *              现在，你需要从中选出 任意 一组有效括号字符串 A 和 B，使 max(depth(A), depth(B)) 的可能取值最小。
 *              返回长度为 seq.length 答案数组 answer ，选择 A 还是 B 的编码规则是：如果 seq[i] 是 A 的一部分，
 *              那么 answer[i] = 0。否则，answer[i] = 1。即便有多个满足要求的答案存在，你也只需返回 一个。
 */
public class MaxDepthAfterSplit {

    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        Map<String,Integer> aMap = new HashMap<>();
        Map<String,Integer> bMap = new HashMap<>();
        for (int i=0;i<seq.length();i++){
            if ("(".equals(seq.substring(i,i+1))){
                //a中包含"("
                if (aMap.containsKey("(")){
                    //b中包含"("
                    if (bMap.containsKey("(")){
                        //a中的"("比b多
                        if (aMap.get("(")>bMap.get("(")){
                            bMap.put("(",bMap.get("(")+1);
                            res[i] = 1;
                        }else {
                            aMap.put("(",aMap.get("(")+1);
                            res[i] = 0;
                        }
                    //b中不包含"("
                    }else {
                        bMap.put("(",1);
                        res[i] = 1;
                    }
                //a中不包含"("
                }else {
                    aMap.put("(",1);
                    res[i] = 0;
                }
            }else {
                if (aMap.containsKey(")")){
                    //b中包含"("
                    if (bMap.containsKey(")")){
                        //a中的"("比b多
                        if (aMap.get(")")>bMap.get(")")){
                            bMap.put(")",bMap.get(")")+1);
                            res[i] = 1;
                        }else {
                            aMap.put(")",aMap.get(")")+1);
                            res[i] = 0;
                        }
                        //b中不包含"("
                    }else {
                        bMap.put(")",1);
                        res[i] = 1;
                    }
                    //a中不包含"("
                }else {
                    aMap.put(")",1);
                    res[i] = 0;
                }
            }
        }

        return res;
    }
}
