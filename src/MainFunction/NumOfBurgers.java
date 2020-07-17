package MainFunction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/5/28
 * Time: 10:52
 * Description: 圣诞活动预热开始啦，汉堡店推出了全新的汉堡套餐。为了避免浪费原料，请你帮他们制定合适的制作计划。
 *              给你两个整数 tomatoSlices 和 cheeseSlices，分别表示番茄片和奶酪片的数目。
 *              不同汉堡的原料搭配如下：
 *              巨无霸汉堡：4 片番茄和 1 片奶酪
 *              小皇堡：2 片番茄和 1 片奶酪
 *              请你以 [total_jumbo, total_small]（[巨无霸汉堡总数，小皇堡总数]）的格式返回恰当的制作方案，
 *              使得剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量都是 0。
 *              如果无法使剩下的番茄片 tomatoSlices 和奶酪片 cheeseSlices 的数量为 0，就请返回 []。
 */
public class NumOfBurgers {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        if (tomatoSlices%2!=0||tomatoSlices<cheeseSlices*2||tomatoSlices>cheeseSlices*4){
            return res;
        }
        if (tomatoSlices==0&&cheeseSlices==0){
            return Arrays.asList(0,0);
        }
        int jumboCount = tomatoSlices/2-cheeseSlices;
        int smallCount = cheeseSlices*2-tomatoSlices;
        return Arrays.asList(jumboCount,smallCount);
    }
}
