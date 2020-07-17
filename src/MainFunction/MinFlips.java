package MainFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/7/14
 * Time: 22:07
 * Description: 给你三个正整数 a、b 和 c。
 *              你可以对 a 和 b 的二进制表示进行位翻转操作，返回能够使按位或运算
 *              a OR b == c  成立的最小翻转次数。
 *              位翻转操作」是指将一个数的二进制表示任何单个位上的 1 变成 0 或者 0 变成 1 。
 */
public class MinFlips {
    public int minFlips(int a, int b, int c) {
        int n = a|b;
        if (n==c){
            return 0;
        }
        List<Integer> listn = getbitList(n);
        List<Integer> listc = getbitList(c);
        int tmpn=0,tmpc=0,i=0,j=0;
        int sum = 0;
        while (i<listn.size()&&j<listc.size()){
            tmpn = listn.get(i);
            tmpc = listc.get(j);
            if (tmpc==tmpn){
                i++;
                j++;
                continue;
            }
            if (tmpc>tmpn){
                int m = 1 << (tmpn-1);
                int am = m&a;
                int bm = m&b;
                if (am==bm){
                    sum+=2;
                }else {
                    sum++;
                }
                i++;
                continue;
            }
            if (tmpc<tmpn){
                sum++;
                j++;
                continue;
            }
        }
        if (i<listn.size()){
            while (i<listn.size()){
                tmpn = listn.get(i);
                int m = 1 << (tmpn-1);
                int am = m&a;
                int bm = m&b;
                if (am==bm){
                    sum+=2;
                }else {
                    sum++;
                }
                i++;
            }
        }else {
            sum+=listc.size()-j;
        }
        return sum;
    }

    private List<Integer> getbitList(int a){
        List<Integer> list = new ArrayList<>();
        int i=0;
        while (a>0){
            i++;
            int b = a&1;
            if (b==1){
                list.add(i);
            }
            a = a>>1;
        }
        return list;
    }

    public static void main(String[] args) {
        MinFlips minFlips = new MinFlips();
        int i = minFlips.minFlips(8, 3, 16);
        System.out.println(i);
    }
}
