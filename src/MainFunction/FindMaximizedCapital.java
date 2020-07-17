package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/5/26
 * Time: 14:08
 * Description: 假设 力扣（LeetCode）即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，力扣 希望在
 *              IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。
 *              帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
 *              给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。
 *              最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 *              总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本
 */
public class FindMaximizedCapital {
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int res = W;
        List<List<Integer>> pc = new ArrayList<>();
        for (int i=0;i<Profits.length;i++){
            List<Integer> list = new ArrayList<>();
            list.add(Profits[i]);
            list.add(Capital[i]);
            pc.add(list);
        }
        Collections.sort(pc,(o1, o2) -> o2.get(0)-o1.get(0));
        while (k>0&&pc.size()!=0){
            for (List<Integer> arr:pc){
                if (arr.get(1)<=res){
                    res+=arr.get(0);
                    k--;
                    pc.remove(arr);
                    break;
                }
            }
            if (res==W){
                return res;
            }else {
                W = res;
            }
        }
        return W;
    }

    public static void main(String[] args) {
        int maximizedCapital = findMaximizedCapital(10, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2});
        System.out.println(maximizedCapital);
    }

}
