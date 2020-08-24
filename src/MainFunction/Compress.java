package MainFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/7/24
 * Time: 9:14
 * Description: 给定一组字符，使用原地算法将其压缩。
 *              压缩后的长度必须始终小于或等于原数组长度。
 *              数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 *              在完成原地修改输入数组后，返回数组的新长度。
 */
public class Compress {
    public int compress(char[] chars) {
        if (chars==null||chars.length==0){
            return 0;
        }
        if (chars.length==1){
            return chars.length;
        }
        int count = 1;
        char tmp = chars[0];
        int len = 0;
        int index = 0;
        for (int i=1;i<chars.length;i++){
            char c = chars[i];
            if (c==tmp){
                count++;
            }else {
                List<Integer> allDigit = getAllDigit(count);
                len+=1;
                chars[index] = tmp;
                index++;
                if (count>1){
                    len+=allDigit.size();
                    for (int j=allDigit.size()-1;j>=0;j--){
                        chars[index] = String.valueOf(allDigit.get(j)).charAt(0);
                        index++;
                    }
                }
                count=1;
                tmp = c;
            }
        }
        List<Integer> allDigit = getAllDigit(count);
        len+=1;
        chars[index] = tmp;
        index++;
        if (count>1){
            len+=allDigit.size();
            for (int j=allDigit.size()-1;j>=0;j--){
                chars[index] = String.valueOf(allDigit.get(j)).charAt(0);
                index++;
            }
        }
        return len;
    }

    private List<Integer> getAllDigit(int n){
        List<Integer> list = new ArrayList<>();
        if (n>1){
            while (n>9){
                list.add(n%10);
                n/=10;
            }
            list.add(n);
        }else {
            list.add(n);
        }
        return list;
    }

    public static void main(String[] args) {
        Compress compress = new Compress();
        int n = compress.compress(new char[]{'a','b','c'});
        System.out.println(n);
    }
}
