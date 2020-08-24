package MainFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * User: 兴希
 * Date: 2020/8/19
 * Time: 15:39
 * Description: 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，
 *              她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，
 *              喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，
 *              喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 */
public class MaxDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            if (n==0){
                break;
            }
            list.add(n);
        }
        handle(list);
    }

    private static void handle(List<Integer> list){
//        List<Integer> drinks = new ArrayList<>();
        for (int drink:list){
            int m = 0;
            int n = drink;
            while (n>=3){
                m+=n/3;
                n = n/3+n%3;
            }
            if (n==2){
                m++;
            }
            System.out.println(m);
        }
    }
}
