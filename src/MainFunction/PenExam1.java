package MainFunction;

import java.util.Scanner;

/**
 * User: 兴希
 * Date: 2020/3/23
 * Time: 18:57
 * Description: No Description
 */
public class PenExam1 {
    public static int calCount(int n){
        if (n<1){
            return 0;
        }
        int res = 0;
        for (int i=1;i<=n;i++){
            res+=cal(i,n);
        }
        return res;
    }

    public static int cal(int i,int n){
        int total = 1;
        int dev = 1;
        if (i==1){
            return n;
        }else {
            for (int j=i;j>0;j--){
                total *= n;
                n = n-1;
                dev*=j;
            }
            return total*i/dev;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a = calCount(n);
        System.out.println(a);
    }
}
