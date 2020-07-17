package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/5/12
 * Time: 9:27
 * Description: 给你两个字符串 s1 和 s2 ，它们长度相等，请你检查是否存在一个 s1  的排列可以打破 s2 的一个排列，
 *              或者是否存在一个 s2 的排列可以打破 s1 的一个排列。
 *              字符串 x 可以打破字符串 y （两者长度都为 n ）需满足对于所有 i（在 0 到 n - 1 之间）都有 x[i] >= y[i]
 *              （字典序意义下的顺序）。
 */
public class CheckIfCanBreak {
    public static boolean checkIfCanBreak(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        s1 = new String(chars1);
        s2 = new String(chars2);
        int i1 = s1.compareTo(s2);
        if (i1==0){
            return true;
        }
        boolean flag = true;
        for (int i=0;i<s1.length();i++){
            if (i1<0){
                if (chars1[i]<=chars2[i]){
                    continue;
                }else {
                    return false;
                }
            }
            if (i1>0){
                if (chars1[i]>=chars2[i]){
                    continue;
                }else {
                    return false;
                }
            }

        }
        return true;
    }

    public static boolean checkIfCanBreak1(String s1,String s2){
        int[] arr1=new int[26];
        int[] arr2=new int[26];
        //遍历 s1、s2 字符串
        for(int i=0;i<s1.length();i++){
            arr1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            arr2[s2.charAt(i)-'a']++;
        }

        //这里进行了两次遍历,一次检测 arr1 是否恒>=arr2 ,另一次检测arr1 是否恒<=arr2  可以做进一步优化.
        int cur=0;
        boolean flag=true;
        for(int i=0;i<26;i++){
            cur+=arr1[i]-arr2[i];
            if(cur<0){
                flag=false;
            }
        }
        // 遍历后,恒>=0,即返回 true;
        if(flag) {
            return true;
        }
        // 经过一轮遍历后,cur必然为0,无需重新赋初值
        flag=true;
        for(int i=0;i<26;i++){
            cur+=arr1[i]-arr2[i];
            if(cur>0){
                flag=false;
            }
        }
        // 遍历后,恒<=0,即返回 true,否则返回 false;
        return flag;
    }

    public static void main(String[] args) {
        boolean b = checkIfCanBreak1("aaad", "abcc");
        System.out.println(b);
    }

}
