package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/7/6
 * Time: 22:16
 * Description: 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 */
public class TitleToNumber {
    public int titleToNumber(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        buildMap(map);
        for (int i=0;i<s.length();i++){
            Integer n = map.get(s.charAt(i));
            res+=Math.pow(26,s.length()-i-1)*n;
        }
        return res;
    }

    public static void main(String[] args) {
        TitleToNumber titleToNumber = new TitleToNumber();
        int a = titleToNumber.titleToNumber("ZY");
        System.out.println(a);
    }

    private void buildMap(Map<Character, Integer> map){
        map.put('A',1);
        map.put('B',2);
        map.put('C',3);
        map.put('D',4);
        map.put('E',5);
        map.put('F',6);
        map.put('G',7);
        map.put('H',8);
        map.put('I',9);
        map.put('J',10);
        map.put('K',11);
        map.put('L',12);
        map.put('M',13);
        map.put('N',14);
        map.put('O',15);
        map.put('P',16);
        map.put('Q',17);
        map.put('R',18);
        map.put('S',19);
        map.put('T',20);
        map.put('U',21);
        map.put('V',22);
        map.put('W',23);
        map.put('X',24);
        map.put('Y',25);
        map.put('Z',26);
    }
}
