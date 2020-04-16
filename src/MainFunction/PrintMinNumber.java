package MainFunction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/3/4
 * Time: 22:44
 * Description: 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *              例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public static String printMinNumber(int [] numbers) {
        ArrayList<String> stringNumber = new ArrayList<>();
        for (int i = 0; i<numbers.length;i++){
            stringNumber.add(String.valueOf(numbers[i]));
        }
        List<String> collect = stringNumber.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if ((o1 + o2).compareTo(o2 + o1) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }).collect(Collectors.toList());
        return collect.toString();
    }

    public static void main(String[] args) {
        String s = printMinNumber(new int[]{3, 4, 1, 2, 5});
        System.out.println();
    }
}
