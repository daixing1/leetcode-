package MainFunction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * User: 兴希
 * Date: 2020/5/15
 * Time: 10:32
 * Description: 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。
 *              例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *              给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式
 */
public class AddToArrayForm {
    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> tmp = new ArrayList<>();
        while (K>0){
            tmp.add(K%10);
            K=K/10;

        }
        Collections.reverse(tmp);
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for (int i=A.length-1,j=tmp.size()-1;i>=0&&j>=0;i--,j--){
            res.add((A[i]+tmp.get(j)+count)%10);
            if (A[i]+tmp.get(j)+count>=10){
                count=1;
            }else {
                count=0;
            }

        }
        if (A.length>tmp.size()){
            for (int i=A.length-tmp.size()-1;i>=0;i--){
                res.add((A[i]+count)%10);
                if (A[i]+count>=10){
                    count=1;
                }else {
                    count=0;
                }

            }
        }else if (A.length<tmp.size()){
            for (int i=tmp.size()-A.length-1;i>=0;i--){
                res.add((tmp.get(i)+count)%10);
                if (tmp.get(i)+count>=10){
                    count=1;
                }else {
                    count=0;
                }

            }
        }
        if (count==1){
            res.add(1);
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = addToArrayForm(new int[]{1,2,0,0}, 34);
        System.out.println(list);
    }
}
