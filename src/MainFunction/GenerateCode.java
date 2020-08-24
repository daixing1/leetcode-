package MainFunction;

import java.util.Arrays;
import java.util.Scanner;

/**
 * User: 兴希
 * Date: 2020/7/23
 * Time: 8:21
 * Description: 小汪作为一个有数学天分的程序猿，设计了一套密码生成器来搞定自己的密码问题。
 *              密码生成器由N个槽位组成，槽位的下标为0~N-1，每个槽位存储一个数。起初每个槽位都是0。
 *              密码生成器会进行M轮计算，每轮计算，小汪会输入两个数L,R(L<=R),密码生成器会将这两个数作为下标，
 *              将两个下标之间（包含）的所有槽位赋值为i（i为当前的轮次，i∈[1,M]）。
 *              M轮计算完成后，密码生成器会根据槽位的最终值生成一条密码，密码的生成规则为：
 *              （0*a[0] + 1*a[1] + 2*a[2] + ... + (N-1)*a[N-1]) mod 100000009
 *              其中a[i]表示第i个槽位的最终值。
 *              请帮助小汪把他的密码生成器实现为代码。
 */
public class GenerateCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x,y;
        int[] dp = new int[n];
        int index = 0;
        while (m>0){
            index++;
            x = scanner.nextInt();
            y = scanner.nextInt();
            Arrays.fill(dp,x,y+1,index);
            m--;
        }
        int sum=0;
        for (int i=0;i<n;i++){
            sum+=dp[i]*i;

        }
        System.out.println(sum%100000009);

    }


}
