package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/6/15
 * Time: 10:28
 * Description: 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 *              今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 *              例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是
 *              [1, 1, 1, 2, 1, 4, 6]。
 */
public class StockSpanner {
    List<Integer> dp;
    List<Integer> list;
    public StockSpanner() {
        list = new ArrayList<>();
        dp = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);
        dp.add(list.size()-1);
        for (int i=list.size()-1;i>=0;i--){
            if (price>=list.get(i)&&dp.get(i)<=i){
                i = dp.get(i);
                dp.set(list.size()-1,i);
            }else {
                break;
            }
        }
        return dp.size()-dp.get(dp.size()-1);
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int next = stockSpanner.next(100);
        int next1 = stockSpanner.next(80);
        int next2 = stockSpanner.next(60);
        int next3 = stockSpanner.next(70);
        int next4 = stockSpanner.next(60);
        int next5 = stockSpanner.next(75);
        int next6 = stockSpanner.next(85);
        System.out.println();
    }
}
