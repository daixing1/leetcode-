package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/7/8
 * Time: 20:37
 * Description: 给定一副牌，每张牌上都写着一个整数。
 *              此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *              每组都有 X 张牌。
 *              组内所有的牌上都写着相同的整数。
 *              仅当你可选的 X >= 2 时返回 true。
 */
public class HasGroupsSizeXI {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length<2){
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n:deck){
            map.put(n,map.getOrDefault(n,0)+1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int tmp = list.get(0);
        for (int i=tmp;i>1;i--){
            if (tmp%i==0){
                if (isValid(i,list)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int n,List<Integer> list){
        for (int num:list){
            if (num%n!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HasGroupsSizeXI hasGroupsSizeXI = new HasGroupsSizeXI();
        boolean b = hasGroupsSizeXI.hasGroupsSizeX(new int[]{1,1,2,2,2,2});
        System.out.println(b);
    }
}
