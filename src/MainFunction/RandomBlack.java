package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/6/16
 * Time: 10:58
 * Description: 给定一个包含 [0，n ) 中独特的整数的黑名单 B，写一个函数从 [ 0，n ) 中返回一个不在B中的随机整数。
 *              对它进行优化使其尽量少调用系统方法 Math.random()
 */
public class RandomBlack {
    Map<Integer, Integer> map;
    int n;
    public RandomBlack(int N, int[] blacklist) {
        map = new HashMap<>();
        if (blacklist.length!=0){
            for (int a:blacklist){
                map.put(a,a);
            }
        }
        n = N;
    }

    public int pick() {
        int a = (int)Math.random()*n;
        while (map.containsKey(a)){
            a = (int)Math.random()*n;
        }
        return a;
    }

    public static void main(String[] args) {
        RandomBlack randomBlack = new RandomBlack(2,new int[0]);
        int i=0;
        while (true){
            i++;
            System.out.println(randomBlack.pick());
            if (i>1000){
                return;
            }
        }
    }
}
