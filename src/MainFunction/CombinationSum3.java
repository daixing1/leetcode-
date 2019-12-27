package MainFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: 兴希
 * Date: 2019/12/25
 * Time: 16:39
 * Description: 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，
 *              并且每种组合中不存在重复的数字。
 *              说明：
 *                  所有数字都是正整数。
 *                  解集不能包含重复的组合。
 */
public class CombinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> listList = new ArrayList<>();
        listList = getResult(k,n,1,new Stack<>(),listList);
        return listList;
    }

    public static List<List<Integer>> getResult(int k, int re, int start, Stack<Integer> stack, List<List<Integer>> resultList){
        if (k==0&&re==0){
            resultList.add(new ArrayList<>(stack));
        }
        if(k<0 || re<0){
            return resultList;
        }
        for (int i=start;i<10;i++){
            stack.push(i);
            getResult(k-1,re-i,i+1,stack,resultList);
            stack.pop();
        }
        return resultList;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum3(3, 9);
        System.out.println(lists);
    }
}
