package MainFunction;

import java.util.PriorityQueue;

/**
 * User: 兴希
 * Date: 2020/6/26
 * Time: 10:19
 * Description: 给你一个整数数组 target 。一开始，你有一个数组 A ，它的所有元素均为 1 ，你可以执行以下操作：
 *                  令 x 为你数组里所有元素的和
 *                  选择满足 0 <= i < target.size 的任意下标 i ，并让 A 数组里下标为 i 处的值为 x 。
 *                  你可以重复该过程任意次
 *              如果能从 A 开始构造出目标数组 target ，请你返回 True ，否则返回 False 。
 */
public class IsPossible {
    public static boolean isPossible(int[] target) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        int sum = 0;
        for (int n:target){
            queue.offer(n);
            sum+=n;
        }
        boolean flag = true;
        while (flag){
            Integer poll = queue.poll();
            if (queue.peek() == 1) {
                //直接看它满足或不满足公式
                return (poll - 1) % (sum - poll) == 0;
            }
            if (poll==1){
                return true;
            }else {
                int num = poll-sum+poll;
                sum = poll;
                if (num<1){
                    return false;
                }else {
                    queue.offer(num);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean possible = isPossible(new int[]{1,1000000000});
        System.out.println(possible);
    }
}
