package MainFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/3/4
 * Time: 23:11
 * Description: 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质
 *              因子7。习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class GetUglyNumber {
    public int getUglyNumber_Solution(int index) {
        List<Integer> uglyData = new ArrayList<>();
        uglyData.add(1);
        int t2 = 0, t3 = 0, t5 = 0;
        while (uglyData.size()<=index){
            int m2 = uglyData.get(t2)*2;
            int m3 = uglyData.get(t3)*3;
            int m5 = uglyData.get(t5)*5;
            int min = Math.min(Math.min(m2,m3),m5);
            uglyData.add(min);
            if (min == m2){
                t2++;
            }
            if (min == m3){
                t3++;
            }
            if (min == m5){
                t5++;
            }
        }
        return 0;
    }

}
