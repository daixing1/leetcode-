package MainFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User: 兴希
 * Date: 2020/8/17
 * Time: 23:53
 * Description: 编写一个函数，传入一个int型数组，返回该数组能否分成两组，使得两组中各元素加起来的和相等，
 *              并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），能满足以上条件，
 *              返回true；不满足时返回false。
 */
public class DivideArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int sum1 = 0;
            int sum2 = 0;
            int restTotal = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                if (num%5==0){
                    sum1+=num;
                    continue;
                }
                if (num%3==0){
                    sum2+=num;
                    continue;
                }
                list.add(num);
                restTotal+=num;
            }
            if (Math.abs(restTotal)<Math.abs(sum1-sum2)){
                System.out.println("false");
                continue;
            }
//            canDivide(list,())
        }
    }

    private static boolean canDivide(List<Integer> list, int num){
        return false;
    }
}
