package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/5/27
 * Time: 9:48
 * Description: 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 */
public class SmallestDifference {
    public static int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long res = Integer.MAX_VALUE;
        int tmp = 0;
        for (int aa:a){
            tmp = Math.abs(b[0]-aa);
            res = Math.abs(Math.min(res,Math.abs(b[0]-aa)));
            for (int i=1;i<b.length;i++){
                if (tmp<=Math.abs(b[i]-aa)){
                    break;
                }
                if (res>Math.abs(b[i]-aa)){
                    res = Math.abs(b[i]-aa);
                }
            }
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int i = smallestDifference(new int[]{1,2,3,4,5,6,7,8,9,6152,11,524,14,36366,16,24,26,
                21019,30,31,35,40,46121,42,44,63027,565,54,53,60981,56,59,61,63,67,23620,74,
                76,77,80,82,4180,87,90,91,608,61540,101,65124,118,39546,133,140,142,3217,29844},
                new int[]{23702,2710,663,3742,9895,54444,172,6829,1712,17073,62650,9924,12484,
                        714,715,2255,210,211,63701,37591,217,5850,3810,228,48874,8945,7410,49907,
                        763,46333,42754,775,2824,30987,32532,790,32534,41752,287,25377,5411,291,
                        24872,303,820,2870,828,55101,6975,320,843,847,45396,43349,21847,861,877,
                        45935,61295,48496,1919,33152,4490,397,911,38288,402,23957,7070,930,54181,
                        26538,23466,1963,1458,448,1484,35794,31701,45015,476,6625,46062,4080,508});
        System.out.println(i);
    }
}
