package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/22
 * Time: 21:16
 * Description: 给定两个整数 n 和 k，你需要实现一个数组，这个数组包含从 1 到 n 的 n 个不同整数，
 *              同时满足以下条件：
 *                  ① 如果这个数组是 [a1, a2, a3, ... , an] ，那么数组 [|a1 - a2|, |a2 - a3|,
 *                    |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数；.
 *                  ② 如果存在多种答案，你只需实现并返回其中任意一种.
 */
public class ConstructArray {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        res[0] = 1;
        int i=1;
        boolean flag = true;
        while (k>0){
            if (flag){
                res[i] = res[i-1]+k;
                flag = false;
            }else {
                res[i] = res[i-1]-k;
                flag = true;
            }
            i++;
            k--;
        }
        while (i<n){
            res[i] = i+1;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        ConstructArray constructArray = new ConstructArray();
        int[] ints = constructArray.constructArray(3, 2);
        System.out.println(ints);
    }
}
