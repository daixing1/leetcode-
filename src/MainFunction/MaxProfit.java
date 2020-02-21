package MainFunction;

/**
 * User: 兴希
 * Date: 2020/2/21
 * Time: 15:04
 * Description: 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i=0;i<prices.length-1;i++){
            for (int j=i+1;j<prices.length;j++){
                if (prices[j]-prices[i]>max){
                    max = prices[j]-prices[i];
                }
            }
        }
        return max;
    }
}
