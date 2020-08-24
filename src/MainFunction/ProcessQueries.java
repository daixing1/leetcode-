package MainFunction;

import java.util.LinkedList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/8/19
 * Time: 15:09
 * Description: 给你一个待查数组 queries ，数组中的元素为 1 到 m 之间的正整数。
 *              请你根据以下规则处理所有待查项 queries[i]（从 i=0 到 i=queries.length-1）：
 *                  一开始，排列 P=[1,2,3,...,m]。
 *                  对于当前的 i ，请你找出待查项 queries[i] 在排列 P 中的位置（下标从 0 开始），
 *                  然后将其从原位置移动到排列 P 的起始位置（即下标为 0 处）。注意， queries[i] 在 P
 *                  中的位置就是 queries[i] 的查询结果。
 *              请你以数组形式返回待查数组  queries 的查询结果。
 */
public class ProcessQueries {
    public int[] processQueries(int[] queries, int m) {
        if (queries==null||queries.length==0){
            return new int[0];
        }
        int[] res =new int[queries.length];
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            list.add(i+1);
        }
        for (int j=0;j<queries.length;j++){
            for (int i = 0; i < m; i++) {
                if (list.get(i)==queries[j]){
                    res[j] = i;
                    list.remove(i);
                    break;
                }
            }
            ((LinkedList<Integer>) list).addFirst(queries[j]);
        }
        return res;
    }
}
