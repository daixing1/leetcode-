package MainFunction;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/2/21
 * Time: 14:31
 * Description: 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，
 *              A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class IsStraight {
    public static boolean isStraight(int[] nums) {
        boolean flag = true;
        boolean same = false;
        Integer count = 0;
        List<Integer> numbers = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        for (int i=1;i<numbers.size();i++){
            if (numbers.get(i)==0){
                count++;
                continue;
            }
            if (numbers.get(i)-numbers.get(i-1)!=1){
                flag = false;
            }
            if (numbers.get(i)-numbers.get(i-1)==0){
                same = true;
            }
        }
        if (numbers.get(0)!=0&&count==0){
            return flag;
        }else {
            if (numbers.get(0)==0){
                count++;
            }
            if (same){
                return false;
            }
            if (numbers.get(numbers.size()-1)-numbers.get(count)>=5){
                flag = false;
            }else {
                flag = true;
            }
            return flag;
        }
    }

    public static void main(String[] args) {
        boolean straight = isStraight(new int[]{0, 0, 1, 2, 5});
        System.out.println(straight);
    }


}
