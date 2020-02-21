package MainFunction;

/**
 * User: 兴希
 * Date: 2020/2/21
 * Time: 13:29
 * Description: 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *              你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */
public class TwoSum {
    public static double[] twoSum(int n) {
        double[] result = new double[n*5+1];
        double sumCount = Math.pow(6,n);
        for (int i=n;i<=n*6;i++){
            result[i-n] = getCount(n,i)/sumCount;
        }
        return result;
    }

    public static int getCount(int n,int sum){
        if (n==1 && sum<7 && sum>0){
            return 1;
        }
        if (n==1 && sum >6 || sum<1){
            return 0;
        }
        if (sum==2){
            return getCount(n-1,sum-1);
        }
        if (sum==3){
            return getCount(n-1,sum-1)+getCount(n-1,sum-2);
        }
        if (sum==4){
            return getCount(n-1,sum-1)+getCount(n-1,sum-2)+getCount(n-1,sum-3);
        }
        if (sum==5){
            return getCount(n-1,sum-1)+getCount(n-1,sum-2)+getCount(n-1,sum-3)
                    +getCount(n-1,sum-4);
        }
        if (sum==6){
            return getCount(n-1,sum-1)+getCount(n-1,sum-2)+getCount(n-1,sum-3)
                    +getCount(n-1,sum-4)+getCount(n-1,sum-5);
        }
        return getCount(n-1,sum-1)+getCount(n-1,sum-2)+getCount(n-1,sum-3)
                +getCount(n-1,sum-4)+getCount(n-1,sum-5)+getCount(n-1,sum-6);

    }

    public static void main(String[] args) {
        double[] doubles = twoSum(2);
        System.out.println(doubles);
    }
}
