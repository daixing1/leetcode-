package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/23
 * Time: 9:24
 * Description: 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。
 *              (结果可能会很大，你需要将结果模上1000000007)
 */
public class WaysToChange {
    public static int waysToChange(int n) {
        int res = 0;
        int n1=0,n2=0,n3=0,n4=0;
        n4 = n/25;
        n3 = (n%25)/10;
        n2 = (n-n4*25-n3*10)/5;
        n1 = n-n4*25-n3*10-n2*5;
        for (int i=n4;i>=0;i--){
            for (int j=(n-i*25)/10;j>=0;j--){
                for (int k=(n-i*25-j*10)/5;k>=0;k--){
                    n1 = n-i*25-j*10-k*5;
                    if (n1>=0){
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static int waysToChange1(int n){
        int[][] res = new int[4][n+1];
        int[] coin = new int[]{1,5,10,25};
        for (int i=0;i<n+1;i++){
            res[0][i] = 1;
        }
        for (int i=0;i<4;i++){
            res[i][0] = 1;
        }
        for (int i=1;i<4;i++){
            for (int j=1;j<n+1;j++){
                if (j>=coin[i]){
                    res[i][j] = (res[i-1][j]+res[i][j-coin[i]])%1000000007;
                }else {
                    res[i][j] = res[i-1][j];
                }
            }
        }
        return res[3][n];
    }

    public static void main(String[] args) {
        int i = waysToChange1(900750);
        System.out.println(i);
    }
}
