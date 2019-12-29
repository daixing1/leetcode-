package MainFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: 兴希
 * Date: 2019/12/27
 * Time: 17:40
 * Description: 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 */
public class RestoreIpAddresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> stringList = new ArrayList<>();
        int length = s.length();
        List<List<Integer>> lengthList = new ArrayList<>();
        getEveryLength(1,length,new Stack<>(),lengthList);
        for (List<Integer> e:lengthList){
            String s1 = s.substring(0,e.get(0));
            String s2 = s.substring(e.get(0),e.get(0)+e.get(1));
            String s3 = s.substring(e.get(0)+e.get(1),e.get(0)+e.get(1)+e.get(2));
            String s4 = s.substring(e.get(0)+e.get(1)+e.get(2),length);
            if (isPass(s1)&&isPass(s2)&&isPass(s3)&&isPass(s4)){
                stringList.add(s1+"."+s2+"."+s3+"."+s4);
            }
        }
        return stringList;

    }

    public static boolean isPass(String s){
        int length = s.length();
        Integer integer = Integer.valueOf(s);
        if (integer==0&&length!=1){
            return false;
        }
        if (Math.pow(10,length-1)>integer && integer>0){
            return false;
        }
        if (integer>255 || integer<0){
            return false;
        }else {
            return true;
        }
    }

    public static void getEveryLength(int start, int re, Stack<Integer> stack, List<List<Integer>> lengthList){
        if (stack.size() == 4 && re==0){
            lengthList.add(new ArrayList<>(stack));
        }
        if (re<0 ||(stack.size() == 4 && re!=0)){
            return;
        }
        for (int i=start;i<4;i++){
            stack.push(i);
            getEveryLength(start,re-i,stack,lengthList);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        List<String> stringList = restoreIpAddresses("0000");
    }
}
