package MainFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: 兴希
 * Date: 2020/7/5
 * Time: 11:24
 * Description: 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 *              给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 *              格雷编码序列必须以 0 开头。
 */
public class GrayCode {
    List<Integer> list;
    public List<Integer> grayCode(int n) {
        list = new ArrayList<>();
        if (n==0){
            list.add(0);
            return list;
        }
        if (n==1){
            list.add(0);
            list.add(1);
            return list;
        }
        String s = "0".repeat(n);
        dfs(new StringBuilder(s),0,0);
        return list.stream().distinct().collect(Collectors.toList());
    }

    private void dfs(StringBuilder sb, int index, int n){
        list.add(n);
        for (int i=index;i<sb.length()-1;i++){
            if (sb.charAt(i)=='0'){
                dfs(sb.replace(i,i+1,"1"),i,n+(int)Math.pow(2,sb.length()-i-1));
            }
            dfs(sb.replace(i+1,i+2,"1"),i+1,n+(int)Math.pow(2,sb.length()-i-2));

        }
    }

    public static void main(String[] args) {
        GrayCode grayCode = new GrayCode();
        List<Integer> list = grayCode.grayCode(1);
        System.out.println(list);
    }
}
