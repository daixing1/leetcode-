package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/19
 * Time: 8:50
 * Description: 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 *              我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 *              所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 *              请你返回「表现良好时间段」的最大长度
 */
public class LongestWPI {
    public static int longestWPI(int[] hours) {
        int count = 0;
        int days = 0;
        int res = 0;
        for (int i=0;i<hours.length;i++){

        }
        return res;
    }

    public static void main(String[] args) {
        int i = longestWPI(new int[]{6, 6, 9});
        System.out.println(i);
    }
}
