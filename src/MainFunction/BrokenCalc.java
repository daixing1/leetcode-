package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/5
 * Time: 11:27
 * Description: 在显示着数字的坏计算器上，我们可以执行以下两种操作：
 *                  双倍（Double）：将显示屏上的数字乘 2；
 *                  递减（Decrement）：将显示屏上的数字减 1 。
 *              最初，计算器显示数字 X。
 *              返回显示数字 Y 所需的最小操作数。
 */
public class BrokenCalc {
    public static int brokenCalc(int X, int Y) {
        int count = 0;
        int n = X;
        while (n<Y){
            n = n+X;
            count++;
        }
        int dp[] = new int[n+1];
        if (X>Y){
            return X-Y;
        }
        for (int i=X;i>=0;i--){
            dp[i] = X-i;
        }
        for (int i=X*2;i<=n;i+=X){
            dp[i] = dp[i-X]+1;
        }
        for (int i=1;i<=count;i++){
            for (int j=X*(i+1)-1;j>X*i;j--){
                if (j%2==0){
                    dp[j] = Math.min(dp[j+1],dp[j/2])+1;
                }else {
                    dp[j] = dp[j+1]+1;
                }
            }
        }
        return dp[Y];
    }

    public static void main(String[] args) {
        int i = brokenCalc(5, 8);
        System.out.println(i);
    }
}
