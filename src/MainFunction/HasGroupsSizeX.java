package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/3/27
 * Time: 10:34
 * Description: 给定一副牌，每张牌上都写着一个整数。
 *              此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *              每组都有 X 张牌。
 *              组内所有的牌上都写着相同的整数。
 *              仅当你可选的 X >= 2 时返回 true。
 */
public class HasGroupsSizeX {
    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck.length<2){
            return false;
        }
        for (int i=2;i<=deck.length;i++){
            if (deck.length%i==0){
                Map<Integer,List<Integer>> map = new HashMap<>();
                for (int j=0;j<deck.length;j++){
                    if (map.containsKey(deck[j])){
                        map.get(deck[j]).add(deck[j]);
                    }else {
                        map.put(deck[j],new ArrayList<>(Arrays.asList(deck[j])));
                    }
                }
                boolean flag = true;
                for (Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
                    if (flag&&entry.getValue().size()%i!=0){
                        flag = false;
                    }
                }
                if (flag){
                    return flag;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = hasGroupsSizeX(new int[]{1, 1});
        System.out.println(b);
    }
}
